package com.example.androidtermproject.business;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.androidtermproject.models.IEmployee;
import com.example.androidtermproject.models.IVehicle;
import com.example.androidtermproject.models.Manager;
import com.example.androidtermproject.models.Programmer;
import com.example.androidtermproject.models.Tester;

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
        String sqlCreate = "CREATE TABLE Employees (id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, age INTEGER, birthYear INTEGER, monthlySalary DOUBLE, rate double, role VARCHAR, nbProjects INTEGER, nbBugs INTEGER, nbClients INTEGER)";
        String sqlCreateVehicle = "CREATE TABLE Vehicles (id INTEGER PRIMARY KEY AUTOINCREMENT, make VARCHAR, plate VARCHAR, color VARCHAR, category VARCHAR, belongsTo INTEGER, hasSideCar BIT, type VARCHAR,  FOREIGN KEY (belongsto) REFERENCES Employee (id))";
        db.execSQL(sqlCreate);
        db.execSQL(sqlCreateVehicle);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Do nothing for now
    }

    @Override
    public ArrayList<IEmployee> getEmployees() {
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<IEmployee> employees = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM Employees", new String[]{});
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            employees.add(employeeMapper(cursor));
            cursor.moveToNext();
        }
        return employees;
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

    private IEmployee employeeMapper(Cursor cursor) {
        switch (cursor.getString(cursor.getColumnIndex("role"))){
            case "Programmer" :
                return new Programmer(
                        cursor.getInt(cursor.getColumnIndex("id")),
                        cursor.getString(cursor.getColumnIndex("name")),
                        cursor.getInt(cursor.getColumnIndex("age")),
                        cursor.getInt(cursor.getColumnIndex("birthYear")),
                        cursor.getDouble(cursor.getColumnIndex("monthlySalary")),
                        cursor.getDouble(cursor.getColumnIndex("rate")),
                        cursor.getInt(cursor.getColumnIndex("nbProjects"))
                        );
            case "Tester":
                return new Tester(
                        cursor.getInt(cursor.getColumnIndex("id")),
                        cursor.getString(cursor.getColumnIndex("name")),
                        cursor.getInt(cursor.getColumnIndex("age")),
                        cursor.getInt(cursor.getColumnIndex("birthYear")),
                        cursor.getDouble(cursor.getColumnIndex("monthlySalary")),
                        cursor.getDouble(cursor.getColumnIndex("rate")),
                        cursor.getInt(cursor.getColumnIndex("nbBugs"))
                );
            case "Manager":
                return new Manager(
                        cursor.getInt(cursor.getColumnIndex("id")),
                        cursor.getString(cursor.getColumnIndex("name")),
                        cursor.getInt(cursor.getColumnIndex("age")),
                        cursor.getInt(cursor.getColumnIndex("birthYear")),
                        cursor.getDouble(cursor.getColumnIndex("monthlySalary")),
                        cursor.getDouble(cursor.getColumnIndex("rate")),
                        cursor.getInt(cursor.getColumnIndex("nbClients"))
                );
            default:
                return null;
        }
    }
}
