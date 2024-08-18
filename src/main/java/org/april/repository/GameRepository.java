package org.april.repository;

import org.april.model.Anime;
import org.april.model.Game;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class GameRepository implements Repository<Game>{

    private final SessionFactory sessionFactory;

    public GameRepository() {
        sessionFactory = SessionFactoryMaker.getFactory();
    }

    @Override
    public void insertItem(Game item) {
        Session session = sessionFactory.openSession();
        session.persist(item);
        session.close();
    }

    @Override
    public Game getItemById(int id) {
        Session session = sessionFactory.openSession();

        Game game = (Game) session.get(String.valueOf(id), Game.class);
        session.close();

        return game;
    }

    @Override
    public Game getItemByTitle(String title) {
        Session session = sessionFactory.openSession();

        Game game = (Game) session.createQuery("select * from Anime where title = '" + title + "'", Game.class).getSingleResult();
        session.close();

        return game;
    }

    @Override
    public void editItem(Game item) {
        Session session = sessionFactory.openSession();
        session.merge(item);
        session.close();
    }

    @Override
    public void removeItem(Game item) {
        Session session = sessionFactory.openSession();
        session.remove(item);
        session.close();
    }
}
