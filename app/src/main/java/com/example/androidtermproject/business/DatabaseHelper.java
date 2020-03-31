package com.example.androidtermproject.business;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.androidtermproject.models.IEmployee;
import com.example.androidtermproject.models.IVehicle;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper implements IDataService {

    private static DatabaseHelper instance;

    private DatabaseHelper(@Nullable Context context) {
        super(context, "db", null, 1);
    }

    public static DatabaseHelper getInstance(@Nullable Context context) {
        if (instance == null) {
            instance = new DatabaseHelper(context);
        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

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
