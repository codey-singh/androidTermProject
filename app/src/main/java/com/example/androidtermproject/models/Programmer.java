package com.example.androidtermproject.models;

public class Programmer extends Employee {

    private final int GAIN_FACTOR_PROJECTS = 200;

    public Programmer(int id, String name, int age, int birthYear, double monthlySalary, double rate, int nbProjects, double occupationRate) {
        super(id, name, age, birthYear, monthlySalary, rate, occupationRate);

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

    @Override
    public double annualIncome() {
        return (getMonthlySalary() * 12) + (GAIN_FACTOR_PROJECTS * nbProjects);
    }

}
