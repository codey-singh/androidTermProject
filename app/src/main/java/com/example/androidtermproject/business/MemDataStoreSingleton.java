package com.example.androidtermproject.business;

import com.example.androidtermproject.models.IEmployee;
import com.example.androidtermproject.models.IVehicle;

import java.util.ArrayList;

public class MemDataStoreSingleton implements IDataService {

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
        return null;
    }

    @Override
    public boolean addEmployee(IEmployee employee) {
        return false;
    }

    @Override
    public boolean removeEmployee(int id) {
        return false;
    }

    @Override
    public ArrayList<IVehicle> getVehicles() {
        return null;
    }

    @Override
    public boolean addVehicle(IVehicle vehicle) {
        return false;
    }

    @Override
    public boolean removeVehicle(int id) {
        return false;
    }
}
