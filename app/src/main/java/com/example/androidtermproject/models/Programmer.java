package com.example.androidtermproject.models;

public class Programmer extends Employee {

    public Programmer(int id, String name, int age, int birthYear, double monthlySalary, double rate, int nbProjects) {
        super(id, name, age, birthYear, monthlySalary, rate);

        this.nbProjects = nbProjects;
    }

    private int nbProjects;

    public int getNbProjects() {
        return nbProjects;
    }

    public void setNbProjects(int nbProjects) {
        this.nbProjects = nbProjects;
    }

    @Override
    public String getRole() {
        return "Programmer";
    }
}
