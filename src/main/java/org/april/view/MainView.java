package org.april.view;

import org.april.model.Item;

import java.util.List;

public class MainView {

    public void showHelp() {
        System.out.println(
                        """
                        Usage:
                        getall
                            Reads all items.
                        <type>
                            Reads the item with given types. Ex: anime
                        
                        Options:
                        -u
                            Returns only the unwatched items.
                        -f "FILTER"
                            Applies filter to the search.
                        -r <ID>
                            Removes the item with given id and used type.
                        -e <ID> <FIELDNAME> "NEWVALUE"
                            Edits the item with given id's field with new value.
                            If the operation is to change the watched data then only the id is needed.
                        -i [FIELDS]
                            Inserts an item to used type. Date format is "dd-mm-yyyy".
                            Insert 1 at the end if the item is already watched.
                        """
        );
    }

    public void showInvalidInput() {
        System.err.println("Invalid Input!");
        System.out.println("Type \"help\" to get help!");
    }

    public void showItems(List<Item> items) {

    }
    
}
