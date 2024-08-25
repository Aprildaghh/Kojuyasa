package org.april.service;

import jakarta.transaction.Transactional;
import org.april.model.Series;
import org.april.repository.SeriesRepository;

import java.util.List;

public class SeriesService implements Service<Series> {

    private final SeriesRepository seriesRepository;

    public SeriesService() {
        seriesRepository = new SeriesRepository();
    }

    @Override
    @Transactional
    public List<Series> getAll() {
        return seriesRepository.getAll();
    }

    @Override
    @Transactional
    public void insertItem(int id, String[] fields) {
        seriesRepository.insertItem(item);
    }

    @Override
    @Transactional
    public Series getItemById(int id) {
        return seriesRepository.getItemById(id);
    }

    @Override
    @Transactional
    public Series getItemByTitle(String title) {
        return seriesRepository.getItemByTitle(title);
    }

    @Override
    @Transactional
    public void editItem(int id, String fieldName, String newValue) {
        seriesRepository.editItem(item);
    }

    @Override
    @Transactional
    public void removeItem(Series item) {
        seriesRepository.removeItem(item);
    }
}
