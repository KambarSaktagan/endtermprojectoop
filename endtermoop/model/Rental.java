package com.example.endtermoop.model;

public class Rental {

    private int id;
    private Car car;
    private Customer customer;
    private int days;

    public Rental(int id, Car car, Customer customer, int days) {
        this.id = id;
        this.car = car;
        this.customer = customer;
        this.days = days;
    }

    public double totalPrice() {
        return car.calculatePrice(days);
    }
}
