package com.example.androidtermproject;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrationForm extends AppCompatActivity {
    //Variable declaration
    EditText e_fname, e_lname, e_birthyear,e_monsal,e_occupationalRate,e_empID,e_vehmodel,e_plateno;
    Spinner EmpTypeSpinner;
    LinearLayout dynamicLL;
    TextView EmpManual_Data;
    EditText Manual_Data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_form);
        e_fname = findViewById(R.id.FirstName);
        e_lname = findViewById(R.id.LastName);
        e_birthyear = findViewById(R.id.birth_year);
        e_monsal = findViewById(R.id.monthlySalary);
        e_occupationalRate =findViewById(R.id.OccupationRate);
        e_vehmodel=findViewById(R.id.VehicleModel);
        e_plateno=findViewById(R.id.PlateNumber);
        e_empID =findViewById(R.id.EmployeeID);
        dynamicLL = findViewById(R.id.dynamicLL);
        EmpManual_Data = findViewById(R.id.EmpManual_Data);
        Manual_Data = findViewById(R.id.Manual_Data);
        EmpTypeSpinner = findViewById(R.id.EmpTypeSpinner);
        EmpTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    dynamicLL.setVisibility(View.GONE);
                    return;
                } else if (position == 1) {
                    EmpManual_Data.setText("Number of Clients");
                    Manual_Data.setHint("Number of Clients");
                } else if (position == 2) {
                    EmpManual_Data.setText("Number of Bugs");
                    Manual_Data.setHint("Number of Bugs");
                } else {
                    EmpManual_Data.setText("Number of Projects");
                    Manual_Data.setHint("Number of Projects");
                }
                dynamicLL.setVisibility(View.VISIBLE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                dynamicLL.setVisibility(View.GONE);
            }
        });
    }

    public void regfunc(View view) {
        final String fname = e_fname.getText().toString();
        final String lname = e_lname.getText().toString();
        final String birthy = e_birthyear.getText().toString();
        final String monSal = e_monsal.getText().toString();
        final String occRate = e_occupationalRate.getText().toString();
        final String empid = e_empID.getText().toString();
        final String vehmodel = e_vehmodel.getText().toString();
        final String plateno = e_plateno.getText().toString();
        final int by = Integer.parseInt(birthy);
        //final int or = Integer.parseInt(occRate);
        if (fname.equals("")) {
            Toast toast = Toast.makeText(getApplicationContext(), "Please enter First name", Toast.LENGTH_SHORT);
            toast.show();
            return;
        } else if (lname.equals("")) {
            Toast toast = Toast.makeText(getApplicationContext(), "Please enter Lastname", Toast.LENGTH_SHORT);
            toast.show();
            return;
        } else if (birthy.length() != 4) {
            Toast toast = Toast.makeText(getApplicationContext(), "Enter year with 4 digits", Toast.LENGTH_SHORT);
            toast.show();
            return;
        } else if((by<=1900)||(by>2020)){
            Toast toast = Toast.makeText(getApplicationContext(), "Birthyear should be after 1900 and before 2020", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }else if (monSal.equals("")) {
            Toast toast = Toast.makeText(getApplicationContext(), "Please enter valid salary", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
        else if (occRate.equals("")) {
            Toast toast = Toast.makeText(getApplicationContext(), "Please enter occupational rate", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
        /*else if (or<=100) {
            Toast toast = Toast.makeText(getApplicationContext(), "Please enter occupational rate less than 101%", Toast.LENGTH_SHORT);
            toast.show();
            return;}*/
        else if (empid.equals("")) {
            Toast toast = Toast.makeText(getApplicationContext(), "Please enter employee ID", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
             else if (vehmodel.equals("")) {
            Toast toast = Toast.makeText(getApplicationContext(), "Please enter vehicle model", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
                 else if (plateno.equals("")) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Please enter plate number", Toast.LENGTH_SHORT);
                    toast.show();
                    return;
        }
                 else{
            Toast toast = Toast.makeText(getApplicationContext(), "Valid input", Toast.LENGTH_SHORT);
            toast.show();
            return;

        }

    }
    }

