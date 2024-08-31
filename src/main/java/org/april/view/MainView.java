package org.april.view;

import org.april.model.*;

import java.util.List;

public class MainView {

    public void showHelp() {
        System.out.println(
                        "Usage:\n" +
                        "getall\n" +
                        "    Reads all items.\n" +
                        "<type>\n" +
                        "    Reads the item with given types. Ex: anime\n" +
                        "\n" +
                        "Options:\n" +
                        "-u\n" +
                        "    Returns only the unwatched items.\n" +
                        "-f \"FILTER\"\n" +
                        "    Applies filter to the search.\n" +
                        "-r <ID>\n" +
                        "    Removes the item with given id and used type.\n" +
                        "-e <ID> <FIELDNAME> \"NEWVALUE\"\n" +
                        "    Edits the item with given id's field with new value.\n" +
                        "    If the operation is to change the watched data then only the id is needed.\n" +
                        "-i [FIELDS]\n" +
                        "    Inserts an item to used type. Date format is \"yyyy-mm-dd\".\n" +
                        "    Insert 1 at the end if the item is already watched."

        );
    }

    public void showInvalidInput() {
        System.err.println("Invalid Input!");
        System.out.println("Type \"help\" to get help!");
    }

    public void showAnimes(List<Anime> items) {
        if (items == null) return;
        System.out.println("--- Anime ---");
        for (Anime item : items) System.out.println(item);
    }

    public void showGames(List<Game> items) {
        if (items == null) return;
        System.out.println("--- Game ---");
        for (Game item : items) System.out.println(item);
    }

    public void showMovies(List<Movie> items) {
        if (items == null) return;
        System.out.println("--- Movie ---");
        for (Movie item : items) System.out.println(item);
    }

    public void showSeries(List<Series> items) {
        if (items == null) return;
        System.out.println("--- Series ---");
        for (Series item : items) System.out.println(item);
    }

}
