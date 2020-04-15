package com.example.androidtermproject.models;

import com.example.androidtermproject.business.exceptions.InvalidParamException;

import java.util.Calendar;

public abstract class Employee implements IEmployee {

    Employee(int id, String name, int age, int birthYear, double monthlySalary, double occupationRate) throws InvalidParamException {
        this.id = id;
        this.name = name;
        this.age = age;
        this.setBirthYear(birthYear);
        this.monthlySalary = monthlySalary;
        this.setOccupationRate(occupationRate);
    }

    private double occupationRate;
    private int id;
    private String name;
    private int age;
    private int birthYear;
    private double monthlySalary;

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

    public void setBirthYear(int birthYear) throws InvalidParamException {
        if(birthYear < 1900 || birthYear > Calendar.getInstance().get(Calendar.YEAR))
            throw new InvalidParamException("Birth year is not valid.");
        this.birthYear = birthYear;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public double getOccupationRate() {
        return occupationRate;
    }

    public void setOccupationRate(double occupationRate) {
        if (occupationRate > 1) this.occupationRate = 1;
        else if (occupationRate < 0.1) this.occupationRate = 0.1;
        else this.occupationRate = occupationRate;
    }
    @Override
    public abstract String getRole();

    @Override
    public int getEmpId() {
        return id;
    };
}
