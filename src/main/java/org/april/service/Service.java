package org.april.service;

import java.util.List;

public interface Service<T> {

    public List<T> getAll();

    public void insertItem(int id, String[] fields);

    public T getItemById(int id);

    public T getItemByTitle(String title);

    public void editItem(int id, String fieldName, String newValue);

    public void removeItem(T item);
}
