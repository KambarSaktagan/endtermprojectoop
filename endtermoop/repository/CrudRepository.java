package com.example.endtermoop.repository;

import java.util.List;

public interface CrudRepository<T> {
    void create(T t);
    List<T> getAll();
    void delete(int id);
}
