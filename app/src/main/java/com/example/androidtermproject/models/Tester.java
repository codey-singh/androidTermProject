package com.example.androidtermproject.models;

public class Tester extends Employee {

    public Tester(String name, int age, int birthYear, double monthlySalary, double rate, int nbBugs) {
        super(name, age, birthYear, monthlySalary, rate);
        this.nbBugs = nbBugs;
    }

    private int nbBugs;

    public int getNbBugs() {
        return nbBugs;
    }

    public void setNbBugs(int nbBugs) {
        this.nbBugs = nbBugs;
    }
}
