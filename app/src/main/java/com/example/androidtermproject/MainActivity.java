package com.example.androidtermproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidtermproject.business.IDataService;
import com.example.androidtermproject.business.MemDataStoreSingleton;

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
    }

    public void goToReg(View view) {
        Intent intent = new Intent(this, RegistrationForm.class);
        startActivity(intent);
    }
}
