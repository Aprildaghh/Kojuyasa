package org.april.service;

public interface Service<T> {

    public void insertItem(T item);

    public T getItemById(int id);

    public T getItemByTitle(String title);

    public void editItem(T item);

    public void removeItem(T item);
}
