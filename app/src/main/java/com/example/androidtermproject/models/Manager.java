package com.example.androidtermproject.models;

public class Manager extends Employee {

    private final int GAIN_FACTOR_CLIENT = 500;
    private final int GAIN_FACTOR_TRAVEL = 100;

    public Manager(int id, String name, int age, int birthYear, double monthlySalary, double rate, int nbClients, double occupationRate) {
        super(id, name, age, birthYear, monthlySalary, rate, occupationRate);
        this.nbClients = nbClients;
    }

    private int nbClients;

    public int getNbClients() {
        return nbClients;
    }

    public void setNbClients(int nbClients) {
        this.nbClients = nbClients;
    }

    @Override
    public String getRole() {
        return "Manager";
    }

    @Override
    public double annualIncome() {
        return (12 * getMonthlySalary()) + (nbClients * GAIN_FACTOR_CLIENT) + (GAIN_FACTOR_TRAVEL * 0);
    }
}
