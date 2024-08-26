package org.april.controller;

import org.april.model.*;
import org.april.service.*;
import org.april.view.MainView;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.exit;

public class MainController {

    private final AnimeService animeService;
    private final GameService gameService;
    private final MovieService movieService;
    private final SeriesService seriesService;

    private final MainView mainView;

    public MainController() {
        animeService = new AnimeService();
        gameService = new GameService();
        movieService = new MovieService();
        seriesService = new SeriesService();
        mainView = new MainView();
    }

    public void processInput(String line) {
        if (!isValidInput(line)) {
            mainView.showInvalidInput();
            return;
        }

        switch (line) {
            case "help": mainView.showHelp(); return;
            case "exit": exit(0); return ;
            case "getall": getAllItems(); return;
        }
        if (line.contains("-r"))
            performRemove(line);
        else if (line.contains("-e"))
            performEdit(line);
        else if (line.contains("-i"))
            performInsert(line);
        else
            performRead(line);
    }

    private boolean isValidInput(String line) {

        if (!line.contains("getall") && !line.contains("anime") &&
            !line.contains("series") && !line.contains("game") &&
            !line.contains("movie") && !line.contains("help") &&
            !line.contains("exit"))
            return false;

        /*
        if (line.contains("-r") || line.contains("-e") || line.contains("-i"))
            if (line.split("-").length > 2)
                return false;
        */

        return true;
    }

    private void getAllItems() {
        mainView.showAnimes(animeService.getAll());
        mainView.showGames(gameService.getAll());
        mainView.showMovies(movieService.getAll());
        mainView.showSeries(seriesService.getAll());
    }

    private void performRemove(String line) {
        List<String> inputAsArray = splitInput(line);
        int id = Integer.parseInt(inputAsArray.get(2));
        String itemName = inputAsArray.get(0);

        switch (itemName) {
            case "anime": animeService.removeItem(animeService.getItemById(id)); break;
            case "game": gameService.removeItem(gameService.getItemById(id)); break;
            case "movie": movieService.removeItem(movieService.getItemById(id)); break;
            case "series": seriesService.removeItem(seriesService.getItemById(id)); break;
        }
    }

    private void performEdit(String line) {
        List<String> inputAsArray = splitInput(line);
        String name = inputAsArray.get(0);
        int id = Integer.parseInt(inputAsArray.get(2));
        String fieldName = inputAsArray.get(3);
        String newValue = inputAsArray.get(4);

        switch (name) {
            case "anime": animeService.editItem(id, fieldName, newValue); break;
            case "game": gameService.editItem(id, fieldName, newValue); break;
            case "movie": movieService.editItem(id, fieldName, newValue); break;
            case "series": seriesService.editItem(id, fieldName, newValue); break;
        }
    }

    private void performInsert(String line) {
        List<String> inputAsArray = splitInput(line);
        String name = inputAsArray.get(0);

        switch (name) {
            case "anime": animeService.insertItem(inputAsArray); break;
            case "game": gameService.insertItem(inputAsArray); break;
            case "movie": movieService.insertItem(inputAsArray); break;
            case "series": seriesService.insertItem(inputAsArray); break;
        }
    }

    private void performRead(String line) {
        List<String> inputAsArray = splitInput(line);
        String name = inputAsArray.get(0);

        switch (name) {
            case "anime": readAnimes(inputAsArray); break;
            case "game": readGames(inputAsArray); break;
            case "movie": readMovies(inputAsArray); break;
            case "series": readSeries(inputAsArray); break;
        }
    }

    private void readAnimes(List<String> input) {
        List<Anime> animes = animeService.getAll();

        if (input.contains("-f") && input.contains("-u")) {
            for (int i = animes.size()-1; i >= 0; i--)
                if (animes.get(i).isFinished())
                    animes.remove(i);

            for (int i = animes.size()-1; i >= 0; i--)
                if (!animes.get(i).getTitle().contains(input.get(2)))
                    animes.remove(i);
        }
        else if (!input.contains("-f") && input.contains("-u")) {
            for (int i = animes.size()-1; i >= 0; i--)
                if (animes.get(i).isFinished())
                    animes.remove(i);
        }
        else if (input.contains("-f") && !input.contains("-u")) {
            for (int i = animes.size()-1; i >= 0; i--)
                if (!animes.get(i).getTitle().contains(input.get(2)))
                    animes.remove(i);
        }

        mainView.showAnimes(animes);
    }

    private void readGames(List<String> input) {
        List<Game> games = gameService.getAll();

        if (input.contains("-f") && input.contains("-u")) {
            for (int i = games.size()-1; i >= 0; i--)
                if (games.get(i).isFinished())
                    games.remove(i);

            for (int i = games.size()-1; i >= 0; i--)
                if (!games.get(i).getTitle().contains(input.get(2)))
                    games.remove(i);
        }
        else if (!input.contains("-f") && input.contains("-u")) {
            for (int i = games.size()-1; i >= 0; i--)
                if (games.get(i).isFinished())
                    games.remove(i);
        }
        else if (input.contains("-f") && !input.contains("-u")) {
            for (int i = games.size()-1; i >= 0; i--)
                if (!games.get(i).getTitle().contains(input.get(2)))
                    games.remove(i);
        }

        mainView.showGames(games);
    }

    private void readMovies(List<String> input) {
        List<Movie> movies = movieService.getAll();

        if (input.contains("-f") && input.contains("-u")) {
            for (int i = movies.size()-1; i >= 0; i--)
                if (movies.get(i).isFinished())
                    movies.remove(i);

            for (int i = movies.size()-1; i >= 0; i--)
                if (!movies.get(i).getTitle().contains(input.get(2)))
                    movies.remove(i);
        }
        else if (!input.contains("-f") && input.contains("-u")) {
            for (int i = movies.size()-1; i >= 0; i--)
                if (movies.get(i).isFinished())
                    movies.remove(i);
        }
        else if (input.contains("-f") && !input.contains("-u")) {
            for (int i = movies.size()-1; i >= 0; i--)
                if (!movies.get(i).getTitle().contains(input.get(2)))
                    movies.remove(i);
        }

        mainView.showMovies(movies);
    }

    private void readSeries(List<String> input) {
        List<Series> series = seriesService.getAll();

        if (input.contains("-f") && input.contains("-u")) {
            for (int i = series.size()-1; i >= 0; i--)
                if (series.get(i).isFinished())
                    series.remove(i);

            for (int i = series.size()-1; i >= 0; i--)
                if (!series.get(i).getTitle().contains(input.get(2)))
                    series.remove(i);
        }
        else if (!input.contains("-f") && input.contains("-u")) {
            for (int i = series.size()-1; i >= 0; i--)
                if (series.get(i).isFinished())
                    series.remove(i);
        }
        else if (input.contains("-f") && !input.contains("-u")) {
            for (int i = series.size()-1; i >= 0; i--)
                if (!series.get(i).getTitle().contains(input.get(2)))
                    series.remove(i);
        }

        mainView.showSeries(series);
    }

    private List<String> splitInput(String line) {
        List<String> splittedInput = new ArrayList<>();
        int inputIndex = 0;

        while(inputIndex < line.length() && line.charAt(inputIndex) == ' ')
            inputIndex++;

        String input = "";
        boolean inStar = false;
        while(inputIndex < line.length()) {
            char theChar = line.charAt(inputIndex);
            if (theChar == ' ' && !inStar) {
                if (input.isEmpty()) continue;
                splittedInput.add(input);
                input = "";
            }
            else if(theChar == '"') {
                if (inStar)
                    splittedInput.add(input);
                inStar = !inStar;
            }
            else
                input += theChar;
            inputIndex++;
        }
        if (!input.isEmpty()) splittedInput.add(input);
        return splittedInput;
    }

}
/*
* there's a commented out part of isValidInput.
* editing doesn't work
* */