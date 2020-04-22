package com.example.androidtermproject.business;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.androidtermproject.business.exceptions.InvalidParamException;
import com.example.androidtermproject.models.Car;
import com.example.androidtermproject.models.IEmployee;
import com.example.androidtermproject.models.IVehicle;
import com.example.androidtermproject.models.Manager;
import com.example.androidtermproject.models.Motorcycle;
import com.example.androidtermproject.models.Programmer;
import com.example.androidtermproject.models.Tester;
import com.example.androidtermproject.models.Vehicle;

import java.util.ArrayList;

public class MemDataStoreSingleton implements IDataService {

    private ArrayList<IEmployee> employees = new ArrayList<>();
    private ArrayList<IVehicle> vehicles = new ArrayList<>();

    private MemDataStoreSingleton() throws InvalidParamException {

    }

    private static MemDataStoreSingleton instance;

    public static MemDataStoreSingleton getInstance() throws InvalidParamException {
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
    @Override
    public boolean updateEmployee(int id,String new_name,int new_age,int new_birthyear,double new_salary,double new_rate)
    {
        return true;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public boolean removeEmployee(int id) {
        return employees.removeIf(employee -> employee.getEmpId() == id);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public IEmployee getEmployee(int id) {
        return (IEmployee) employees.stream().filter(employee -> employee.getEmpId() == id).toArray()[0];
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
        return vehicles.removeIf(vehicle -> vehicle.getVehicleId() == id);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public IVehicle getVehicleForEmployee(int eId) {
        return (IVehicle) vehicles.stream().filter(iVehicle -> iVehicle.getBelongsTo() == eId).toArray()[0];
    }
}
