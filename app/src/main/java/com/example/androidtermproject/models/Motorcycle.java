package com.example.androidtermproject.models;

public class Motorcycle extends Vehicle {

    public Motorcycle(int id, String make, String plate, String color, String category, boolean hasSideCar, int belongsTo) {
        super(id, make, plate, color, category, belongsTo);
        this.hasSideCar = hasSideCar;
    }

    private boolean hasSideCar;

    public boolean isHasSideCar() {
        return hasSideCar;
    }

    public void setHasSideCar(boolean hasSideCar) {
        this.hasSideCar = hasSideCar;
    }

    @Override
    public String getVehicleType() {
        return "Motorcycle";
    }
}
