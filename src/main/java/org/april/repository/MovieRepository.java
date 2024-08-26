package org.april.repository;

import org.april.model.Anime;
import org.april.model.Movie;
import org.april.model.Series;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class MovieRepository implements Repository<Movie>{

    private final SessionFactory sessionFactory;

    public MovieRepository() {
        sessionFactory = SessionFactoryMaker.getFactory();
    }

    @Override
    public void insertItem(Movie item) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(item);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Movie getItemById(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Movie movie = session.createQuery("select m from Movie m where title = " + id, Movie.class).getSingleResult();
        session.getTransaction().commit();
        session.close();

        return movie;
    }

    @Override
    public Movie getItemByTitle(String title) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Movie movie = (Movie) session.createQuery("select m from Movie m where title = '" + title + "'", Movie.class).getSingleResult();
        session.getTransaction().commit();
        session.close();

        return movie;
    }

    @Override
    public void editItem(Movie item) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.merge(item);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void removeItem(Movie item) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.remove(item);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Movie> getAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Movie> movies = session.createQuery("select m from Movie m", Movie.class).getResultList();
        session.getTransaction().commit();
        session.close();
        return movies;
    }
}
