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
    public void insertItem(Anime item) {
        animeRepository.insertItem(item);
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
    public void editItem(Anime item) {
        animeRepository.editItem(item);
    }

    @Override
    @Transactional
    public void removeItem(Anime item) {
        animeRepository.removeItem(item);
    }
}
