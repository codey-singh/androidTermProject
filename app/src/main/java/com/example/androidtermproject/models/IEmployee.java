package com.example.androidtermproject.models;

import java.io.Serializable;

public interface IEmployee extends Serializable {
    String getRole();
    int getEmpId();
    double annualIncome();
}
