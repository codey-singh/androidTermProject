package com.example.androidtermproject.models;

abstract public class Vehicle implements IVehicle {

    Vehicle(int id, String make, String plate, String color, String category, int belongsTo) {
        this.id = id;
        this.make = make;
        this.plate = plate;
        this.color = color;
        this.category = category;
        this.belongsTo = belongsTo;
    }

    private int id;
    private String make;
    private String plate;
    private String color;
    private String category;
    private int belongsTo; // belongs to which employee

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getBelongsTo() {
        return belongsTo;
    }

    public void setBelongsTo(int belongsTo) {
        this.belongsTo = belongsTo;
    }

    @Override
    public abstract String getVehicleType();

    @Override
    public int getVehicleId() {
        return id;
    }

}
