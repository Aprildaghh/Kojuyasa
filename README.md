## Kojuyasa is a CLI application that manages animes, games, movies and series.

### USAGE
    getall
        Reads all items.
    <type>
        Reads the item with given types. Ex: anime

    Options:
    -u
        Returns only the unwatched items.
    -f <FIELDNAME> "FILTER"
        Applies filter to the search.
    -r <ID>
        Removes the item with given id and used type.
    -e <ID> <FIELDNAME> "NEWVALUE"
        Edits the item with given id's field with new value.
        If the operation is to change the watched data then only the id is needed.
    -i [FIELDS]
        Inserts an item to used type. Date format is "dd-mm-yyyy".
        Insert 1 at the end if the item is already watched.