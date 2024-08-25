package org.april.controller;

import org.april.model.Item;
import org.april.service.*;
import org.april.view.MainView;

import java.util.ArrayList;
import java.util.Arrays;
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
                !line.contains("movie") && !line.contains("help"))
            return false;

        if (line.contains("-r") || line.contains("-e") || line.contains("-i"))
            if (line.split("-").length > 2)
                return false;

        return true;
    }

    private void getAllItems() {
        List<Item> items = new ArrayList<>();
        items.addAll(animeService.getAll());
        items.addAll(gameService.getAll());
        items.addAll(movieService.getAll());
        items.addAll(seriesService.getAll());

        mainView.showItems(items);
    }

    private void performRemove(String line) {
        String[] inputAsArray = splitInput(line);
        int id = Integer.parseInt(inputAsArray[2]);
        String itemName = inputAsArray[0];

        switch (itemName) {
            case "anime": animeService.removeItem(animeService.getItemById(id));
            case "game": gameService.removeItem(gameService.getItemById(id));
            case "movie": movieService.removeItem(movieService.getItemById(id));
            case "series": seriesService.removeItem(seriesService.getItemById(id));
        }
    }

    private void performEdit(String line) {
        String[] inputAsArray = splitInput(line);
        String name = inputAsArray[0];
        int id = Integer.parseInt(inputAsArray[2]);
        String fieldName = inputAsArray[3];
        String newValue = inputAsArray[4];

        switch (name) {
            case "anime": animeService.editItem(id, fieldName, newValue);
            case "game": gameService.editItem(id, fieldName, newValue);
            case "movie": movieService.editItem(id, fieldName, newValue);
            case "series": seriesService.editItem(id, fieldName, newValue);
        }
    }

    private void performInsert(String line) {
        String[] inputAsArray = splitInput(line);
        String name = inputAsArray[0];
        int id = Integer.parseInt(inputAsArray[2]);
        String[] fields = Arrays.copyOfRange(inputAsArray, 3, inputAsArray.length);

        switch (name) {
            case "anime": animeService.insertItem(id, fields);
            case "game": gameService.insertItem(id, fields);
            case "movie": movieService.insertItem(id, fields);
            case "series": seriesService.insertItem(id, fields);
        }
    }

    private void performRead(String line) {
        String[] inputAsArray = splitInput(line);
        String name = inputAsArray[0];
        Service theService = null;
        switch (name) {
            case "anime": theService = animeService;
            case "game": theService = gameService;
            case "movie": theService = movieService;
            case "series": theService = seriesService;
        }

        if (theService == null) {
            mainView.showInvalidInput();
            return;
        }

        List<Item> items = theService.getAll();

        if (line.contains("-f") && line.contains("-u")) {
            items = excludeWatchedItems(items);
            items = addFilter(items, inputAsArray[2]);
        }
        else if (!line.contains("-f") && line.contains("-u"))
            items = excludeWatchedItems(items);
        else if (line.contains("-f") && !line.contains("-u"))
            items = addFilter(items, inputAsArray[2]);

        mainView.showItems(items);
    }

    private String[] splitInput(String line) {
        // store all items according to the " symbol

        return null;
    }

    private List<Item> excludeWatchedItems(List<Item> items) {
        List<Item> newItems = new ArrayList<>();
        for (int i = items.size()-1; i >= 0; i--)
            if (!items.get(i).isFinished())
                newItems.add(items.get(i));
        return newItems;
    }

    private List<Item> addFilter(List<Item> items, String title) {
        List<Item> newItems = new ArrayList<>();
        for (int i = items.size()-1; i >= 0; i--)
            if (items.get(i).getTitle().contains(title))
                newItems.add(items.get(i));
        return newItems;
    }

}
