package com.example.androidtermproject.business;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.androidtermproject.models.Car;
import com.example.androidtermproject.models.IEmployee;
import com.example.androidtermproject.models.IVehicle;
import com.example.androidtermproject.models.Manager;
import com.example.androidtermproject.models.Motorcycle;
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
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        switch (employee.getRole()){
            case "Programmer":
                values.put("id", employee.getEmpId());
                values.put("name", ((Programmer) employee).getName());
                values.put("age", ((Programmer) employee).getAge());
                values.put("birthYear", ((Programmer) employee).getBirthYear());
                values.put("monthlySalary", ((Programmer) employee).getMonthlySalary());
                values.put("rate", ((Programmer) employee).getRate());
                values.put("nbProjects", ((Programmer) employee).getNbProjects());
                values.put("occupationRate", ((Programmer) employee).getOccupationRate());
                break;
            case "Tester":
                values.put("id", employee.getEmpId());
                values.put("name", ((Tester) employee).getName());
                values.put("age", ((Tester) employee).getAge());
                values.put("birthYear", ((Tester) employee).getBirthYear());
                values.put("monthlySalary", ((Tester) employee).getMonthlySalary());
                values.put("rate", ((Tester) employee).getRate());
                values.put("nbBugs", ((Tester) employee).getNbBugs());
                values.put("occupationRate", ((Tester) employee).getOccupationRate());
                break;
            case "Manager":
                values.put("id", employee.getEmpId());
                values.put("name", ((Manager) employee).getName());
                values.put("age", ((Manager) employee).getAge());
                values.put("birthYear", ((Manager) employee).getBirthYear());
                values.put("monthlySalary", ((Manager) employee).getMonthlySalary());
                values.put("rate", ((Manager) employee).getRate());
                values.put("nbClients", ((Manager) employee).getNbClients());
                values.put("occupationRate", ((Manager) employee).getOccupationRate());
                break;
        }
        return db.insert("Employees", null, values) != -1;
    }

    @Override
    public boolean removeEmployee(int id) {
        SQLiteDatabase db = getWritableDatabase();
        return db.delete("Employees", "id = ?", new String[] { ""+id }) > 0;
    }

    @Override
    public IEmployee getEmployee(int id) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Employees", new String[]{});
        IEmployee employee = null;
        while(!cursor.isAfterLast()){
            employee = employeeMapper(cursor);
            cursor.moveToNext();
        }
        return employee;
    }

    @Override
    public ArrayList<IVehicle> getVehicles() {
        return null;
    }

    @Override
    public boolean addVehicle(IVehicle vehicle) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        switch (vehicle.getVehicleType()) {
            case "Car":
                values.put("id", vehicle.getVehicleId());//int id, String make, String plate, String color, String category, String type, int belongsTo
                values.put("make", ((Car)vehicle).getMake());
                values.put("plate", ((Car) vehicle).getPlate());
                values.put("color", ((Car) vehicle).getColor());
                values.put("category", ((Car) vehicle).getCategory());
                values.put("type", ((Car) vehicle).getType());
                values.put("belongsTo", ((Car) vehicle).getBelongsTo()); //hasSideCar

                break;
            case "Motorcycle":
                values.put("id", vehicle.getVehicleId());//int id, String make, String plate, String color, String category, String type, int belongsTo
                values.put("make", ((Motorcycle)vehicle).getMake());
                values.put("plate", ((Motorcycle) vehicle).getPlate());
                values.put("color", ((Motorcycle) vehicle).getColor());
                values.put("category", ((Motorcycle) vehicle).getCategory());
                values.put("type", ((Motorcycle) vehicle).isHasSideCar());
                values.put("belongsTo", ((Motorcycle) vehicle).getBelongsTo());
                values.put("hasSideCar", ((Motorcycle) vehicle).isHasSideCar()); //hasSideCar
                break;
        }

        return db.insert("Vehicles", null, values) != -1;
    }

    @Override
    public boolean removeVehicle(int id) {
        SQLiteDatabase db = getWritableDatabase();
        return db.delete("Vehicles", "id = ?", new String[] { ""+id }) > 0;
    }

    @Override
    public IVehicle getVehicleForEmployee(int eId) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Employees", new String[]{});
        IVehicle vehicle = null;
        while(!cursor.isAfterLast()){
            vehicle = vehicleMapper(cursor);
            cursor.moveToNext();
        }
        return vehicle;
    }

    private IVehicle vehicleMapper(Cursor cursor) {
        switch(cursor.getString(cursor.getColumnIndex("type"))) {
            case "Car":
                return new Car(
                        cursor.getInt(cursor.getColumnIndex("id")),
                        cursor.getString(cursor.getColumnIndex("make")),
                        cursor.getString(cursor.getColumnIndex("plate")),
                        cursor.getString(cursor.getColumnIndex("color")),
                        cursor.getString(cursor.getColumnIndex("category")),
                        cursor.getString(cursor.getColumnIndex("type")),
                        cursor.getInt(cursor.getColumnIndex("belongsTo"))
                );
            case "Motorcycle":
                return new Motorcycle(
                        cursor.getInt(cursor.getColumnIndex("id")),
                        cursor.getString(cursor.getColumnIndex("make")),
                        cursor.getString(cursor.getColumnIndex("plate")),
                        cursor.getString(cursor.getColumnIndex("color")),
                        cursor.getString(cursor.getColumnIndex("category")),
                        cursor.getShort(cursor.getColumnIndex("type")) == 1,
                        cursor.getInt(cursor.getColumnIndex("belongsTo"))
                );
            default:
                return null;
        }
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
                        cursor.getInt(cursor.getColumnIndex("nbProjects")),
                        cursor.getDouble(cursor.getColumnIndex("occupationRate"))
                        );
            case "Tester":
                return new Tester(
                        cursor.getInt(cursor.getColumnIndex("id")),
                        cursor.getString(cursor.getColumnIndex("name")),
                        cursor.getInt(cursor.getColumnIndex("age")),
                        cursor.getInt(cursor.getColumnIndex("birthYear")),
                        cursor.getDouble(cursor.getColumnIndex("monthlySalary")),
                        cursor.getInt(cursor.getColumnIndex("nbBugs")),
                        cursor.getDouble(cursor.getColumnIndex("occupationRate"))
                );
            case "Manager":
                return new Manager(
                        cursor.getInt(cursor.getColumnIndex("id")),
                        cursor.getString(cursor.getColumnIndex("name")),
                        cursor.getInt(cursor.getColumnIndex("age")),
                        cursor.getInt(cursor.getColumnIndex("birthYear")),
                        cursor.getDouble(cursor.getColumnIndex("monthlySalary")),
                        cursor.getInt(cursor.getColumnIndex("nbClients")),
                        cursor.getDouble(cursor.getColumnIndex("occupationRate"))
                );
            default:
                return null;
        }
    }
}
