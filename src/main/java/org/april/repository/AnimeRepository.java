package org.april.repository;

import org.april.model.Anime;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class AnimeRepository implements Repository<Anime>{

    private final SessionFactory sessionFactory;

    public AnimeRepository() {
        sessionFactory = SessionFactoryMaker.getFactory();
    }

    @Override
    public void insertItem(Anime item) {
        Session session = sessionFactory.openSession();
        session.persist(item);
        session.close();
    }

    @Override
    public Anime getItemById(int id) {
        Session session = sessionFactory.openSession();

        Anime anime = (Anime) session.get(String.valueOf(id), Anime.class);
        session.close();

        return anime;
    }

    @Override
    public Anime getItemByTitle(String title) {
        Session session = sessionFactory.openSession();

        Anime anime = (Anime) session.createQuery("select * from Anime where title = '" + title + "'", Anime.class).getSingleResult();
        session.close();

        return anime;
    }

    @Override
    public void editItem(Anime item) {
        Session session = sessionFactory.openSession();
        session.merge(item);
        session.close();
    }

    @Override
    public void removeItem(Anime item) {
        Session session = sessionFactory.openSession();
        session.remove(item);
        session.close();
    }
}
