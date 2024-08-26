package org.april.service;

import jakarta.transaction.Transactional;
import org.april.model.Anime;
import org.april.repository.AnimeRepository;

import java.util.List;

public class AnimeService implements Service<Anime> {

    private final AnimeRepository animeRepository;

    public AnimeService() {
        animeRepository = new AnimeRepository();
    }

    @Override
    @Transactional
    public List<Anime> getAll() {
        return animeRepository.getAll();
    }

    @Override
    @Transactional
    public void insertItem(List<String> fields) {
        Anime anime = new Anime();

        anime.setTitle(fields.get(3));
        anime.setReleaseDate(java.sql.Date.valueOf(fields.get(4)));
        anime.setFinished(fields.get(5).equals("1"));

        animeRepository.insertItem(anime);
    }

    @Override
    @Transactional
    public Anime getItemById(int id) {
        return animeRepository.getItemById(id);
    }

    @Override
    @Transactional
    public Anime getItemByTitle(String title) {
        return animeRepository.getItemByTitle(title);
    }

    @Override
    @Transactional
    public void editItem(int id, String fieldName, String newValue) {
        Anime anime = animeRepository.getItemById(id);

        switch (fieldName) {
            case "title": anime.setTitle(newValue);
            case "releaseDate": anime.setReleaseDate(java.sql.Date.valueOf(newValue));
            case "finished": anime.setFinished(newValue.equals("1"));
        }

        animeRepository.editItem(anime);
    }

    @Override
    @Transactional
    public void removeItem(Anime item) {
        animeRepository.removeItem(item);
    }
}
