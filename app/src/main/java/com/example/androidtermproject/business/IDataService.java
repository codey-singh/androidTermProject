package com.example.androidtermproject.business;

import com.example.androidtermproject.models.IEmployee;
import com.example.androidtermproject.models.IVehicle;
import com.example.androidtermproject.models.Vehicle;

import java.util.ArrayList;

public interface IDataService {
    ArrayList<IEmployee> getEmployees();
    boolean addEmployee(IEmployee employee);
    boolean removeEmployee(int id);
    IEmployee getEmployee(int id);

    ArrayList<IVehicle> getVehicles();
    boolean addVehicle(IVehicle vehicle);
    boolean removeVehicle(int id);
    IVehicle getVehicleForEmployee(int eId);
}
