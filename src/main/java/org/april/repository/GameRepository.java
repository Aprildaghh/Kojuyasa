package org.april.repository;

import org.april.model.Anime;
import org.april.model.Game;
import org.april.model.Series;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class GameRepository implements Repository<Game>{

    private final SessionFactory sessionFactory;

    public GameRepository() {
        sessionFactory = SessionFactoryMaker.getFactory();
    }

    @Override
    public void insertItem(Game item) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(item);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Game getItemById(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Game game = session.createQuery("select g from Game g where id = " + id, Game.class).getSingleResult();
        session.getTransaction().commit();
        session.close();

        return game;
    }

    @Override
    public Game getItemByTitle(String title) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Game game = (Game) session.createQuery("select g from Game g where title = '" + title + "'", Game.class).getSingleResult();
        session.getTransaction().commit();
        session.close();

        return game;
    }

    @Override
    public void editItem(Game item) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.merge(item);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void removeItem(Game item) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.remove(item);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Game> getAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Game> games = session.createQuery("select g from Game g", Game.class).getResultList();
        session.getTransaction().commit();
        session.close();
        return games;
    }
}
