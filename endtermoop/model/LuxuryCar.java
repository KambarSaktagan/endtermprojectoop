package com.example.endtermoop.model;

public class LuxuryCar extends Car {

    public LuxuryCar(int id, String name, double price, boolean available) {
        super(id, name, price, available);
    }

    public String getEntityType() { return "LUXURY"; }
    public String getSummary() { return "Luxury Car: " + name; }
    public double calculatePrice(int days) { return pricePerDay * days * 1.5; }
}
