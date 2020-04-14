package com.example.androidtermproject.business;

import android.os.Build;

import androidx.annotation.RequiresApi;

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

    private MemDataStoreSingleton() {
        Car car1=new Car(1,"Honda","A1234","Red","Sedan","4-Door",100);
        Car car2=new Car(2,"Toyota","B1234","Black","Sedan","4-Door",200);
        Motorcycle bike1=new Motorcycle(3,"Suzuki","C007","Blue","Sports bike",false,300);
        Tester tester = new Tester(100,"John Doe",25,1995,3000,100, 0.2);
        Programmer programmer = new Programmer(200,"Denny Thomas",30,1990,4500,100, 0.2);
        Manager manager = new Manager(300,"Silvi Jane",40,1980,7500,4, 0.2);
        vehicles.add(car1);
        vehicles.add(car2);
        vehicles.add(bike1);
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

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public IEmployee getEmployee(int id) {
        return (IEmployee) employees.stream().filter(employee -> employee.getEmpId() == id);
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

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public IVehicle getVehicleForEmployee(int eId) {
        return (IVehicle) vehicles.stream().filter(iVehicle -> iVehicle.getBelongsTo() == eId);
    }
}
