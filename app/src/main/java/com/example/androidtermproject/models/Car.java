package com.example.androidtermproject.models;

public class Car extends Vehicle {

    public Car(int id, String make, String plate, String color, String category, String type, int belongsTo) {
        super(id, make, plate, color, category, belongsTo);
        this.type = type;
    }

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getVehicleType() {
        return "Car";
    }
}
