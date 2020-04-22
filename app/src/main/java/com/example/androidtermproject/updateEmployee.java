package com.example.androidtermproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidtermproject.business.IDataService;
import com.example.androidtermproject.models.Employee;

import java.util.Calendar;

public class updateEmployee extends AppCompatActivity {
    Employee e;
    EditText name,year,salary,rate;
    IDataService d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_employee);
        name=(EditText)findViewById(R.id.UName);
        year=(EditText)findViewById(R.id.UYear);
        salary=(EditText)findViewById(R.id.USalary);
        rate=(EditText)findViewById(R.id.URate);
        e= (Employee) getIntent().getSerializableExtra("Employee");
        name.setText(e.getName());
        year.setText(e.getBirthYear());
        salary.setText(""+e.getMonthlySalary());
        rate.setText(""+e.getOccupationRate());
        Toast.makeText(this,e.getName(),Toast.LENGTH_SHORT).show();
    }
    public void update(View view)
    {

        int presentYear = Calendar.getInstance().get(Calendar.YEAR);
        int new_age = presentYear - Integer.parseInt(year.getText().toString());
        d.updateEmployee(e.getId(),name.getText().toString(),new_age,Integer.parseInt(year.getText().toString()),Double.parseDouble(salary.getText().toString()),Double.parseDouble(rate.getText().toString()));
        Toast.makeText(this,"Employee Details Updated",Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
