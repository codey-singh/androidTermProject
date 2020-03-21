package com.example.androidtermproject.models;

public class Programmer extends Vehicle {

    public Programmer(String make, String plate, String color, String category, int nbProjects) {
        super(make, plate, color, category);
        this.nbProjects = nbProjects;
    }

    private int nbProjects;

    public int getNbProjects() {
        return nbProjects;
    }

    public void setNbProjects(int nbProjects) {
        this.nbProjects = nbProjects;
    }
}
