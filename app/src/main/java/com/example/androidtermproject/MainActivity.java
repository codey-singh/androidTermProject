package com.example.androidtermproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidtermproject.business.IDataService;
import com.example.androidtermproject.business.MemDataStoreSingleton;
import com.example.androidtermproject.models.Employee;
import com.example.androidtermproject.models.IEmployee;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private final String APP_NAME = "Hello";
    ListView listview;
    IDataService dataService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String demo = "Hello demo";
        listview = findViewById(R.id.List_Employees);
        dataService = MemDataStoreSingleton.getInstance();
        ListAdapter listAdapter = new ListAdapter(this, dataService.getEmployees());
        listview.setAdapter(listAdapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ArrayList <IEmployee> employees=dataService.getEmployees();
                Employee e=(Employee) employees.get(position);
                Intent intent=new Intent(MainActivity.this,EmployeeDetail.class);
                intent.putExtra("ID",e.getId());
                startActivity(intent);
            }
        });
    }

    public void goToReg(View view) {
        Intent intent = new Intent(this, RegistrationForm.class);
        startActivity(intent);
    }
}