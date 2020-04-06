package com.example.androidtermproject.business;

import com.example.androidtermproject.models.IEmployee;
import com.example.androidtermproject.models.IVehicle;

import java.util.ArrayList;

public interface IDataService {
    ArrayList<IEmployee> getEmployees();
    boolean addEmployee(IEmployee employee);
    boolean removeEmployee(int id);

    ArrayList<IVehicle> getVehicles();
    boolean addVehicle(IVehicle vehicle);
    boolean removeVehicle(int id);
}
