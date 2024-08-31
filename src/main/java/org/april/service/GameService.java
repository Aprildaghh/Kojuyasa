package org.april.service;

import jakarta.transaction.Transactional;
import org.april.model.Anime;
import org.april.model.Game;
import org.april.model.Series;
import org.april.repository.GameRepository;

import java.util.Arrays;
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
    public void insertItem(List<String> fields) {
        Game game = new Game();

        game.setTitle(fields.get(3));
        game.setFinished(fields.get(4).equals("1"));

        gameRepository.insertItem(game);
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
        Game game = gameRepository.getItemById(id);

        switch (fieldName) {
            case "title": game.setTitle(newValue); break;
            case "finished": game.setFinished(newValue.equals("1")); break;
        }

        gameRepository.editItem(game);
    }

    @Override
    @Transactional
    public void removeItem(Game item) {
        gameRepository.removeItem(item);
    }
}
