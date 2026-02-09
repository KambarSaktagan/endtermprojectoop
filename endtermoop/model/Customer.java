package com.example.endtermoop.model;

import com.example.endtermoop.exception.InvalidInputException;

public class Customer extends BaseEntity implements Validatable {

    public Customer(int id, String name) {
        super(id, name);
    }

    public String getEntityType() { return "CUSTOMER"; }
    public String getSummary() { return "Customer: " + name; }

    public void validate() {
        if (name == null || name.isBlank())
            throw new InvalidInputException("Customer name required");
    }
}
