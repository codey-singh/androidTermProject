package com.example.androidtermproject.models;

public class Tester extends Employee {

    public Tester(int id, String name, int age, int birthYear, double monthlySalary, double rate, int nbBugs) {
        super(id, name, age, birthYear, monthlySalary, rate);
        this.nbBugs = nbBugs;
    }

    private int nbBugs;

    public int getNbBugs() {
        return nbBugs;
    }

    public void setNbBugs(int nbBugs) {
        this.nbBugs = nbBugs;
    }

    @Override
    public String getRole() {
        return "Tester";
    }
}
