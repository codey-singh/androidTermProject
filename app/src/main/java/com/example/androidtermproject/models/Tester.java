package com.example.androidtermproject.models;

import com.example.androidtermproject.business.exceptions.InvalidParamException;

public class Tester extends Employee {

    private final int GAIN_FACTOR_ERROR = 10;

    public Tester(int id, String name, int age, int birthYear, double monthlySalary, int nbBugs, double occupationRate) throws InvalidParamException {
        super(id, name, age, birthYear, monthlySalary, occupationRate);
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

    @Override
    public double annualIncome() {
        return (getMonthlySalary() * 12) + (GAIN_FACTOR_ERROR * nbBugs);
    }

}
