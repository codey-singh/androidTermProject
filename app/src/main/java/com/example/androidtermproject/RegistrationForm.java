package com.example.androidtermproject;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrationForm extends AppCompatActivity {
    //Variable declaration
    EditText e_fname, e_lname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_form);
        e_fname = findViewById(R.id.FirstName);
        e_lname = findViewById(R.id.LastName);
    }

    public void regfunc(View view) {
        final String fname = e_fname.getText().toString();
        if (fname.equals("")) {
            Toast toast = Toast.makeText(getApplicationContext(), "Please enter First name", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
    }
}