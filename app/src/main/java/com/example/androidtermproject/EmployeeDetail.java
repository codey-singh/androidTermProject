package com.example.androidtermproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidtermproject.models.Employee;
import com.example.androidtermproject.models.IEmployee;

public class EmployeeDetail extends AppCompatActivity {
    TextView name,age,role,occupatioRate,annualIncome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_detail);
        name=findViewById(R.id.nameDetails);
        age=findViewById(R.id.ageDetails);
        role=findViewById(R.id.roleDetails);
        occupatioRate=findViewById(R.id.occupationRateDetails);
        annualIncome=findViewById(R.id.annualIncomeDetails);
        Employee emp= (Employee) getIntent().getSerializableExtra("Employee");
        Toast.makeText(this,""+emp.getRole(),Toast.LENGTH_SHORT).show();
        name.setText(""+emp.getName());
        age.setText(""+emp.getAge());
        role.setText(""+emp.getRole());
        occupatioRate.setText(""+emp.getRate());
        annualIncome.setText(""+emp.getMonthlySalary()*12);
    }
}
