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
    EditText e_fname, e_lname;
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
        dynamicLL = findViewById(R.id.dynamicLL);
        EmpManual_Data = findViewById(R.id.EmpManual_Data);
        Manual_Data = findViewById(R.id.Manual_Data);
        EmpTypeSpinner = findViewById(R.id.EmpTypeSpinner);
        EmpTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position == 1) {
                    EmpManual_Data.setText("Number of Clients");
                    Manual_Data.setHint("Number of Clients");
                }
                else if (position == 2){
                    EmpManual_Data.setText("Number of Bugs");
                    Manual_Data.setHint("Number of Bugs");
                }
                else if (position == 3){
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
        if (fname.equals("")) {
            Toast toast = Toast.makeText(getApplicationContext(), "Please enter First name", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
        final String lname = e_lname.getText().toString();
        if (lname.equals("")) {
            Toast toast = Toast.makeText(getApplicationContext(), "Please enter Lastname", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }


    }
}