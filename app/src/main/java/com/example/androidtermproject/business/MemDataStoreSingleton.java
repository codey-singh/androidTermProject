package com.example.androidtermproject.business;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.androidtermproject.models.IEmployee;
import com.example.androidtermproject.models.IVehicle;
import com.example.androidtermproject.models.Manager;
import com.example.androidtermproject.models.Programmer;
import com.example.androidtermproject.models.Tester;

import java.util.ArrayList;

public class MemDataStoreSingleton implements IDataService {

    private ArrayList<IEmployee> employees = new ArrayList<>();
    private ArrayList<IVehicle> vehicles = new ArrayList<>();

    private MemDataStoreSingleton() {
        Tester tester = new Tester(100,"John Doe",25,1995,3000,100,1000);
        Programmer programmer = new Programmer(200,"Denny Thomas",30,1990,4500,100,2);
        Manager manager = new Manager(300,"Silvi Jane",40,1980,7500,100,4);
        employees.add(tester);
        employees.add(manager);
        employees.add(programmer);
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
