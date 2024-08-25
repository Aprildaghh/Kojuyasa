package org.april.service;

import jakarta.transaction.Transactional;
import org.april.model.Game;
import org.april.repository.GameRepository;

import java.util.List;

public class GameService implements Service<Game>{

    private final GameRepository gameRepository;

    public GameService() {
        gameRepository = new GameRepository();
    }

    @Override
    @Transactional
    public List<Game> getAll() {
        return gameRepository.getAll();
    }

    @Override
    @Transactional
    public void insertItem(int id, String[] fields) {
        gameRepository.insertItem(item);
    }

    @Override
    @Transactional
    public Game getItemById(int id) {
        return gameRepository.getItemById(id);
    }

    @Override
    @Transactional
    public Game getItemByTitle(String title) {
        return gameRepository.getItemByTitle(title);
    }

    @Override
    @Transactional
    public void editItem(int id, String fieldName, String newValue) {
        gameRepository.editItem(item);
    }

    @Override
    @Transactional
    public void removeItem(Game item) {
        gameRepository.removeItem(item);
    }
}
