package com.example.androidtermproject.business;

import com.example.androidtermproject.business.exceptions.InvalidParamException;
import com.example.androidtermproject.models.IEmployee;
import com.example.androidtermproject.models.IVehicle;
import com.example.androidtermproject.models.Vehicle;

import java.util.ArrayList;

public interface IDataService {
    ArrayList<IEmployee> getEmployees() throws InvalidParamException;
    boolean addEmployee(IEmployee employee);
    boolean removeEmployee(int id);
    boolean updateEmployee(int id,String new_name,int new_age,int new_birthyear,double new_salary,double new_rate);
    IEmployee getEmployee(int id) throws InvalidParamException;

    ArrayList<IVehicle> getVehicles();
    boolean addVehicle(IVehicle vehicle);
    boolean removeVehicle(int id);
    IVehicle getVehicleForEmployee(int eId);
}
