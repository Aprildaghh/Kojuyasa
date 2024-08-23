package org.april.service;

import java.util.List;

public interface Service<T> {

    public List<T> getAll();

    public void insertItem(T item);

    public T getItemById(int id);

    public T getItemByTitle(String title);

    public void editItem(T item);

    public void removeItem(T item);
}
