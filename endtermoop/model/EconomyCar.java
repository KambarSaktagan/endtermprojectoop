package com.example.endtermoop.model;

public class EconomyCar extends Car {

    public EconomyCar(int id, String name, double price, boolean available) {
        super(id, name, price, available);
    }

    public String getEntityType() { return "ECONOMY"; }
    public String getSummary() { return "Economy Car: " + name; }
    public double calculatePrice(int days) { return pricePerDay * days; }
}
