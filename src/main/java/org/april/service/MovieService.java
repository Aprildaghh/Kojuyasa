package org.april.service;

import jakarta.transaction.Transactional;
import org.april.model.Movie;
import org.april.repository.MovieRepository;

import java.util.List;

public class MovieService implements Service<Movie>{

    private final MovieRepository movieRepository;

    public MovieService() {
        movieRepository = new MovieRepository();
    }

    @Override
    @Transactional
    public List<Movie> getAll() {
        return movieRepository.getAll();
    }

    @Override
    @Transactional
    public void insertItem(int id, String[] fields) {
        movieRepository.insertItem(item);
    }

    @Override
    @Transactional
    public Movie getItemById(int id) {
        return movieRepository.getItemById(id);
    }

    @Override
    @Transactional
    public Movie getItemByTitle(String title) {
        return movieRepository.getItemByTitle(title);
    }

    @Override
    @Transactional
    public void editItem(int id, String fieldName, String newValue) {
        movieRepository.editItem(item);
    }

    @Override
    @Transactional
    public void removeItem(Movie item) {
        movieRepository.removeItem(item);
    }
}
