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
        session.persist(item);
        session.close();
    }

    @Override
    public Series getItemById(int id) {
        Session session = sessionFactory.openSession();

        Series series = (Series) session.get(String.valueOf(id), Series.class);
        session.close();

        return series;
    }

    @Override
    public Series getItemByTitle(String title) {
        Session session = sessionFactory.openSession();

        Series series = (Series) session.createQuery("select * from Series where title = '" + title + "'", Series.class).getSingleResult();
        session.close();

        return series;
    }

    @Override
    public void editItem(Series item) {
        Session session = sessionFactory.openSession();
        session.merge(item);
        session.close();
    }

    @Override
    public void removeItem(Series item) {
        Session session = sessionFactory.openSession();
        session.remove(item);
        session.close();
    }

    @Override
    public List<Series> getAll() {
        Session session = sessionFactory.openSession();
        List<Series> series = session.createQuery("select * from Series", Series.class).getResultList();
        session.close();
        return series;
    }
}
