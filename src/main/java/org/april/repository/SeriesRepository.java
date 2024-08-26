package org.april.repository;

import org.april.model.Anime;
import org.april.model.Series;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class SeriesRepository implements Repository<Series>{

    private final SessionFactory sessionFactory;

    public SeriesRepository() {
        sessionFactory = SessionFactoryMaker.getFactory();
    }

    @Override
    public void insertItem(Series item) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(item);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Series getItemById(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Series series = session.createQuery("select s from Series s where title = " + id, Series.class).getSingleResult();
        session.getTransaction().commit();
        session.close();

        return series;
    }

    @Override
    public Series getItemByTitle(String title) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Series series = (Series) session.createQuery("select s from Series s where title = '" + title + "'", Series.class).getSingleResult();

        session.getTransaction().commit();
        session.close();

        return series;
    }

    @Override
    public void editItem(Series item) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.merge(item);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void removeItem(Series item) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.remove(item);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Series> getAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Series> series = session.createQuery("select s from Series s", Series.class).getResultList();
        session.getTransaction().commit();
        session.close();
        return series;
    }
}
