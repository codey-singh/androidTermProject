package com.example.androidtermproject.models;

public abstract class Employee implements IEmployee {

    Employee(int id, String name, int age, int birthYear, double monthlySalary, double rate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.birthYear = birthYear;
        this.monthlySalary = monthlySalary;
        this.rate = rate;
    }

    private int id;
    private String name;
    private int age;
    private int birthYear;
    private double monthlySalary;
    private double rate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public abstract String getRole();

    @Override
    public int getEmpId() {
        return id;
    };
}
