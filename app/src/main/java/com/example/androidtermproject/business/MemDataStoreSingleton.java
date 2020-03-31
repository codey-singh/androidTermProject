package com.example.androidtermproject.business;

import com.example.androidtermproject.models.IEmployee;
import com.example.androidtermproject.models.IVehicle;

import java.util.ArrayList;

public class MemDataStoreSingleton implements IDataService {

    private ArrayList<IEmployee> employees = new ArrayList<>();
    private ArrayList<IVehicle> vehicles = new ArrayList<>();

    private MemDataStoreSingleton() {
    }

    private static MemDataStoreSingleton instance;

    public static MemDataStoreSingleton getInstance() {
        if (instance == null) {
            instance = new MemDataStoreSingleton();
        }
        return instance;
    }

    @Override
    public ArrayList<IEmployee> getEmployees() {
        return employees;
    }

    @Override
    public boolean addEmployee(IEmployee employee) {
        employees.add(employee);
        return true;
    }

    @Override
    public boolean removeEmployee(int id) {
        boolean ret = false;
        for (int i = 0; i < employees.size(); i++ ) {
            if(employees.get(i).getEmpId() == id) {
                employees.remove(i);
                ret = true;
            }
        }
        return ret;
    }

    @Override
    public ArrayList<IVehicle> getVehicles() {
        return vehicles;
    }

    @Override
    public boolean addVehicle(IVehicle vehicle) {
        vehicles.add(vehicle);
        return true;
    }

    @Override
    public boolean removeVehicle(int id) {
        boolean ret = false;
        for (int i = 0; i < vehicles.size(); i++ ) {
            if(vehicles.get(i).getVehicleId() == id) {
                vehicles.remove(i);
                ret = true;
            }
        }
        return ret;
    }
}
