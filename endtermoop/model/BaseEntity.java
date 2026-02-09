package com.example.endtermoop.model;

public abstract class BaseEntity {
    protected int id;
    protected String name;

    public BaseEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }
    public String getName() { return name; }

    public abstract String getEntityType();
    public abstract String getSummary();

    public void printInfo() {
        System.out.println(getSummary());
    }
}
