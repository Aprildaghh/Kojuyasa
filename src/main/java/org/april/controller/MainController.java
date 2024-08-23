package org.april.controller;

import org.april.service.AnimeService;
import org.april.service.GameService;
import org.april.service.MovieService;
import org.april.service.SeriesService;
import org.april.view.MainView;

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
        //
        return true;
    }

    private void getAllItems() {
        //
    }

    private void performRemove(String line) {
        //
    }

    private void performEdit(String line) {
        //
    }

    private void performInsert(String line) {
        //
    }

    private void performRead(String line) {
        //
    }

}
