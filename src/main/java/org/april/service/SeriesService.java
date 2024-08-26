package org.april.service;

import jakarta.transaction.Transactional;
import org.april.model.Anime;
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
    public void insertItem(List<String> fields) {
        Series series = new Series();

        series.setTitle(fields.get(3));
        series.setSeasonCount(Integer.parseInt(fields.get(4)));
        series.setReleaseDate(java.sql.Date.valueOf(fields.get(5)));
        series.setFinished(fields.get(6).equals("1"));

        seriesRepository.insertItem(series);
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
        Series series = seriesRepository.getItemById(id);

        switch (fieldName) {
            case "title": series.setTitle(newValue);
            case "releaseDate": series.setReleaseDate(java.sql.Date.valueOf(newValue));
            case "seasonCount": series.setSeasonCount(Integer.parseInt(newValue));
            case "finished": series.setFinished(newValue.equals("1"));
        }

        seriesRepository.editItem(series);
    }

    @Override
    @Transactional
    public void removeItem(Series item) {
        seriesRepository.removeItem(item);
    }
}
