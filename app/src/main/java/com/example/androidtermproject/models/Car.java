package com.example.androidtermproject.models;

public class Car extends Vehicle {

    public Car(String make, String plate, String color, String category, String type) {
        super(make, plate, color, category);
        this.type = type;
    }

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
