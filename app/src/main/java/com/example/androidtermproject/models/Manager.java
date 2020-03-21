package com.example.androidtermproject.models;

public class Manager extends Employee {

    public Manager(String name, int age, int birthYear, double monthlySalary, double rate, int nbClients) {
        super(name, age, birthYear, monthlySalary, rate);
        this.nbClients = nbClients;
    }

    private int nbClients;

    public int getNbClients() {
        return nbClients;
    }

    public void setNbClients(int nbClients) {
        this.nbClients = nbClients;
    }
}
