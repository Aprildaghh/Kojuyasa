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

        Game game = (Game) session.createQuery("select * from Game where title = '" + title + "'", Game.class).getSingleResult();
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

    @Override
    public List<Game> getAll() {
        Session session = sessionFactory.openSession();
        List<Game> games = session.createQuery("select * from Game", Game.class).getResultList();
        session.close();
        return games;
    }
}
