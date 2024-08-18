package org.april.repository;

public interface Repository<T> {

    public void insertItem(T item);

    public T getItemById(int id);

    public T getItemByTitle(String title);

    public void editItem(T item);

    public void removeItem(T item);

}
