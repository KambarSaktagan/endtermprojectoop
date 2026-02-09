package com.example.endtermoop.model;

import com.example.endtermoop.exception.InvalidInputException;

public abstract class Car extends BaseEntity implements Validatable, PricedItem {

    protected double pricePerDay;
    protected boolean available;

    public Car(int id, String name, double pricePerDay, boolean available) {
        super(id, name);
        this.pricePerDay = pricePerDay;
        this.available = available;
    }

    public boolean isAvailable() { return available; }
    public double getPricePerDay() { return pricePerDay; }

    @Override
    public void validate() {
        if (name == null || name.isBlank())
            throw new InvalidInputException("Car name cannot be empty");
        if (pricePerDay <= 0)
            throw new InvalidInputException("Price must be positive");
    }
}
