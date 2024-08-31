package org.april.repository;

import org.april.model.Anime;
import org.april.model.Game;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class AnimeRepository implements Repository<Anime>{

    private final SessionFactory sessionFactory;

    public AnimeRepository() {
        sessionFactory = SessionFactoryMaker.getFactory();
    }

    @Override
    public void insertItem(Anime item) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(item);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Anime getItemById(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Anime anime = session.createQuery("select a from Anime a where id = " + id, Anime.class).getSingleResult();
        session.getTransaction().commit();
        session.close();

        return anime;
    }

    @Override
    public Anime getItemByTitle(String title) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Anime anime = (Anime) session.createQuery("select a from Anime a where title = '" + title + "'", Anime.class).getSingleResult();

        session.getTransaction().commit();
        session.close();

        return anime;
    }

    @Override
    public void editItem(Anime item) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.merge(item);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void removeItem(Anime item) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.remove(item);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Anime> getAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Anime> animes = session.createQuery("select a from Anime a ", Anime.class).getResultList();
        session.getTransaction().commit();
        session.close();
        return animes;
    }

}
