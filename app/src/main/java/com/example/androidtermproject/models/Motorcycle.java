package com.example.androidtermproject.models;

public class Motorcycle extends Vehicle {

    public Motorcycle(String make, String plate, String color, String category, boolean hasSideCar) {
        super(make, plate, color, category);
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
