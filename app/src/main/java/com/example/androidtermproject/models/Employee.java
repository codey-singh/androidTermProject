package com.example.androidtermproject.models;

class Employee {

    Employee(String name, int age, int birthYear, double monthlySalary, double rate) {
        this.name = name;
        this.age = age;
        this.birthYear = birthYear;
        this.monthlySalary = monthlySalary;
        this.rate = rate;
    }

    private String name;
    private int age;
    private int birthYear;
    private double monthlySalary;
    private double rate;

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
}
