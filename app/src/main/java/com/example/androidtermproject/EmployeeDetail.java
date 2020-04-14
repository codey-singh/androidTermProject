package com.example.androidtermproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class EmployeeDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_detail);
        int employeeId=getIntent().getExtras().getInt("ID");
        Toast.makeText(this,""+employeeId,Toast.LENGTH_SHORT).show();
    }
}
