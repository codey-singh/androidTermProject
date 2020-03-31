package com.example.androidtermproject.business;

import android.os.Build;

import androidx.annotation.RequiresApi;

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
        return employees.add(employee);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public boolean removeEmployee(int id) {
        return employees.removeIf(employee -> employee.getEmpId() == id);
    }

    @Override
    public ArrayList<IVehicle> getVehicles() {
        return vehicles;
    }

    @Override
    public boolean addVehicle(IVehicle vehicle) {
        return vehicles.add(vehicle);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public boolean removeVehicle(int id) {
        return employees.removeIf(employee -> employee.getEmpId() == id);
    }
}
