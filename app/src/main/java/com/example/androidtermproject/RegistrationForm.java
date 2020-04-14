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
    EditText eFirstName, eLastName, eBirthYear, eMonthlySalary, eOccupationalRate, eEmpID, eVehicleModel, ePlateNumber;
    Spinner empTypeSpinner;
    LinearLayout dynamicLL;
    TextView empManualData;
    EditText manualData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_form);
        eFirstName = findViewById(R.id.FirstName);
        eLastName = findViewById(R.id.LastName);
        eBirthYear = findViewById(R.id.birth_year);
        eMonthlySalary = findViewById(R.id.monthlySalary);
        eOccupationalRate = findViewById(R.id.OccupationRate);
        eVehicleModel = findViewById(R.id.VehicleModel);
        ePlateNumber = findViewById(R.id.PlateNumber);
        eEmpID = findViewById(R.id.EmployeeID);
        dynamicLL = findViewById(R.id.dynamicLL);
        empManualData = findViewById(R.id.EmpManual_Data);
        manualData = findViewById(R.id.Manual_Data);
        empTypeSpinner = findViewById(R.id.EmpTypeSpinner);
        empTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    dynamicLL.setVisibility(View.GONE);
                    return;
                } else if (position == 1) {
                    empManualData.setText("Number of Clients");
                    manualData.setHint("Number of Clients");
                } else if (position == 2) {
                    empManualData.setText("Number of Bugs");
                    manualData.setHint("Number of Bugs");
                } else {
                    empManualData.setText("Number of Projects");
                    manualData.setHint("Number of Projects");
                }
                dynamicLL.setVisibility(View.VISIBLE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                dynamicLL.setVisibility(View.GONE);
            }
        });
    }

    public void validateForm(View view) {
        final String firstName = eFirstName.getText().toString();
        final String lastName = eLastName.getText().toString();
        final String birthYear = eBirthYear.getText().toString();
        final String monthlySalary = eMonthlySalary.getText().toString();
        final String occupationRate = eOccupationalRate.getText().toString();
        final String employeeId = eEmpID.getText().toString();
        final String vehicleModel = eVehicleModel.getText().toString();
        final String plateNumber = ePlateNumber.getText().toString();
        final String md = manualData.getText().toString();
        if (firstName.equals("")) {
            Toast toast = Toast.makeText(getApplicationContext(), "Please enter First name", Toast.LENGTH_SHORT);
            toast.show();

        } else if (lastName.equals("")) {
            Toast toast = Toast.makeText(getApplicationContext(), "Please enter Last name", Toast.LENGTH_SHORT);
            toast.show();

        } else if (birthYear.length() != 4) {
            Toast toast = Toast.makeText(getApplicationContext(), "Enter year with 4 digits", Toast.LENGTH_SHORT);
            toast.show();

        } else if (Integer.parseInt(birthYear) <= 1900 || Integer.parseInt(birthYear) > 2020) {
            Toast toast = Toast.makeText(getApplicationContext(), "Birth year should be after 1900 and before 2020", Toast.LENGTH_SHORT);
            toast.show();

        } else if (monthlySalary.equals("")) {
            Toast toast = Toast.makeText(getApplicationContext(), "Please enter valid salary", Toast.LENGTH_SHORT);
            toast.show();

        } else if (occupationRate.equals("")) {
            Toast toast = Toast.makeText(getApplicationContext(), "Please enter occupational rate", Toast.LENGTH_SHORT);
            toast.show();

        } else if (employeeId.equals("")) {
            Toast toast = Toast.makeText(getApplicationContext(), "Please enter employee ID", Toast.LENGTH_SHORT);
            toast.show();

        } else if(empTypeSpinner.getSelectedItemPosition() == 0) {
            Toast toast = Toast.makeText(getApplicationContext(), "Please enter employee type", Toast.LENGTH_SHORT);
            toast.show();
        }
        else if (vehicleModel.equals("")) {
            Toast toast = Toast.makeText(getApplicationContext(), "Please enter vehicle model", Toast.LENGTH_SHORT);
            toast.show();

        } else if (plateNumber.equals("")) {
            Toast toast = Toast.makeText(getApplicationContext(), "Please enter plate number", Toast.LENGTH_SHORT);
            toast.show();

        } else if (manualData.toString().equals("")) {
            Toast toast = null;
            switch (empTypeSpinner.getSelectedItem().toString()) {
                case "Manager":
                    toast = Toast.makeText(getApplicationContext(), "Please enter Number of Clients", Toast.LENGTH_SHORT);
                    toast.show();
                    break;
                case "Programmer":
                    toast =Toast.makeText(getApplicationContext(), "Please enter Number of Projects", Toast.LENGTH_SHORT);
                    toast.show();
                    break;
                case "Tester":
                    toast =Toast.makeText(getApplicationContext(), "Please enter Number of Bugs", Toast.LENGTH_SHORT);
                    toast.show();
                    break;
            }
        }
        else {
            Toast toast = Toast.makeText(getApplicationContext(), "Valid input", Toast.LENGTH_SHORT);
            toast.show();

        }

    }
}

