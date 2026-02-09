package com.example.endtermoop.service;

import com.example.endtermoop.exception.InvalidInputException;
import com.example.endtermoop.model.Car;
import com.example.endtermoop.repository.CarRepositoryInterface;
import com.example.endtermoop.utils.SortingUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalService {

    private final CarRepositoryInterface carRepo;

    public RentalService(CarRepositoryInterface carRepo) {
        this.carRepo = carRepo;
    }

    public void addCar(Car car) {
        car.validate();
        carRepo.create(car);
    }

    public List<Car> getAllCars() {
        return carRepo.getAll();
    }

    public List<Car> getCarsSortedByPrice() {
        List<Car> cars = carRepo.getAll();
        SortingUtils.sortByPrice(cars);
        return cars;
    }

    public void updateCarPrice(int id, double newPrice) {
        if (newPrice <= 0)
            throw new InvalidInputException("New price must be positive");
        carRepo.updatePrice(id, newPrice);
    }

    public void deleteCar(int id) {
        carRepo.delete(id);
    }
}
