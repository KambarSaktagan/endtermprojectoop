package com.example.endtermoop.repository;

import com.example.endtermoop.model.Car;

public interface CarRepositoryInterface extends CrudRepository<Car> {
    void updatePrice(int id, double newPrice);
}
