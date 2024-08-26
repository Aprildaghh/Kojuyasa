package org.april.service;

import jakarta.transaction.Transactional;
import org.april.model.Anime;
import org.april.model.Movie;
import org.april.model.Series;
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
    public void insertItem(List<String> fields) {
        Movie movie = new Movie();

        movie.setTitle(fields.get(3));
        movie.setReleaseDate(java.sql.Date.valueOf(fields.get(4)));
        movie.setFinished(fields.get(5).equals("1"));

        movieRepository.insertItem(movie);
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
        Movie movie = movieRepository.getItemById(id);

        switch (fieldName) {
            case "title": movie.setTitle(newValue);
            case "releaseDate": movie.setReleaseDate(java.sql.Date.valueOf(newValue));
            case "finished": movie.setFinished(newValue.equals("1"));
        }

        movieRepository.editItem(movie);
    }

    @Override
    @Transactional
    public void removeItem(Movie item) {
        movieRepository.removeItem(item);
    }
}
