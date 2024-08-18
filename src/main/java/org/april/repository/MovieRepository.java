package org.april.repository;

import org.april.model.Anime;
import org.april.model.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class MovieRepository implements Repository<Movie>{

    private final SessionFactory sessionFactory;

    public MovieRepository() {
        sessionFactory = SessionFactoryMaker.getFactory();
    }

    @Override
    public void insertItem(Movie item) {
        Session session = sessionFactory.openSession();
        session.persist(item);
        session.close();
    }

    @Override
    public Movie getItemById(int id) {
        Session session = sessionFactory.openSession();

        Movie movie = (Movie) session.get(String.valueOf(id), Movie.class);
        session.close();

        return movie;
    }

    @Override
    public Movie getItemByTitle(String title) {
        Session session = sessionFactory.openSession();

        Movie movie = (Movie) session.createQuery("select * from Anime where title = '" + title + "'", Movie.class).getSingleResult();
        session.close();

        return movie;
    }

    @Override
    public void editItem(Movie item) {
        Session session = sessionFactory.openSession();
        session.merge(item);
        session.close();
    }

    @Override
    public void removeItem(Movie item) {
        Session session = sessionFactory.openSession();
        session.remove(item);
        session.close();
    }
}
