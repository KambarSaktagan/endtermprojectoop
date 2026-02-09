package com.example.endtermoop.utils;

import com.example.endtermoop.model.Car;
import java.util.Comparator;
import java.util.List;

public class SortingUtils {

    public static void sortByPrice(List<Car> cars) {
        cars.sort(Comparator.comparingDouble(Car::getPricePerDay));
    }
}
