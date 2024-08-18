package org.april.service;

import jakarta.transaction.Transactional;
import org.april.model.Game;
import org.april.repository.GameRepository;

public class GameService implements Service<Game>{

    private final GameRepository gameRepository;

    public GameService() {
        gameRepository = new GameRepository();
    }

    @Override
    @Transactional
    public void insertItem(Game item) {
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
    public void editItem(Game item) {
        gameRepository.editItem(item);
    }

    @Override
    @Transactional
    public void removeItem(Game item) {
        gameRepository.removeItem(item);
    }
}
