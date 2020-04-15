package com.example.androidtermproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidtermproject.business.DatabaseHelper;
import com.example.androidtermproject.business.IDataService;
import com.example.androidtermproject.business.exceptions.InvalidParamException;
import com.example.androidtermproject.models.Car;
import com.example.androidtermproject.models.Employee;
import com.example.androidtermproject.models.Manager;
import com.example.androidtermproject.models.Motorcycle;
import com.example.androidtermproject.models.Programmer;
import com.example.androidtermproject.models.Tester;
import com.example.androidtermproject.models.Vehicle;

import java.util.Calendar;

public class RegistrationForm extends AppCompatActivity {
    //Variable declaration
    EditText eFirstName, eLastName, eBirthYear, eMonthlySalary, eOccupationalRate, eEmpID, eVehicleModel, ePlateNumber, eCarType;
    Spinner empTypeSpinner, colorSpinner;
    LinearLayout dynamicLL;
    TextView empManualData;
    EditText manualData;
    LinearLayout dynamicSwitch;
    Switch extraCar;
    RadioGroup carMotorbike;
    RadioButton empCar;
    RadioButton empBike;
    LinearLayout carTypeLL;
    IDataService dataService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_form);
        dataService = DatabaseHelper.getInstance(this);
        eFirstName = findViewById(R.id.FirstName);
        eLastName = findViewById(R.id.LastName);
        eBirthYear = findViewById(R.id.birth_year);
        eMonthlySalary = findViewById(R.id.monthlySalary);
        eOccupationalRate = findViewById(R.id.OccupationRate);
        eVehicleModel = findViewById(R.id.VehicleModel);
        ePlateNumber = findViewById(R.id.PlateNumber);
        eEmpID = findViewById(R.id.EmployeeID);
        eCarType = findViewById(R.id.carType);
        dynamicLL = findViewById(R.id.dynamicLL);
        empManualData = findViewById(R.id.EmpManual_Data);
        manualData = findViewById(R.id.Manual_Data);
        extraCar = findViewById(R.id.extracarswitch);
        empTypeSpinner = findViewById(R.id.EmpTypeSpinner);
        carMotorbike = findViewById(R.id.carMotorbikeRB);
        dynamicSwitch = findViewById(R.id.dynamicSwitch);
        empCar = findViewById(R.id.EmpCar);
        empBike = findViewById(R.id.EmpMotorBike);
        carTypeLL = findViewById(R.id.dynamicCarTypeLayout);
        colorSpinner = findViewById(R.id.VColorSpinner);

        carMotorbike.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.EmpCar) {
                carTypeLL.setVisibility(View.VISIBLE);
                dynamicSwitch.setVisibility(View.GONE);
            } else if (checkedId == R.id.EmpMotorBike) {
                carTypeLL.setVisibility(View.GONE);
                dynamicSwitch.setVisibility(View.VISIBLE);
            }
        });

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

    public void validateForm(View view) throws InvalidParamException {
        final String firstName = eFirstName.getText().toString();
        final String lastName = eLastName.getText().toString();
        final String birthYear = eBirthYear.getText().toString();
        final String monthlySalary = eMonthlySalary.getText().toString();
        final String occupationRate = eOccupationalRate.getText().toString();
        final String employeeId = eEmpID.getText().toString();
        final String vehicleModel = eVehicleModel.getText().toString();
        final String plateNumber = ePlateNumber.getText().toString();
        final String md = manualData.getText().toString();
        final String carType = eCarType.getText().toString();
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

        } else if (empTypeSpinner.getSelectedItemPosition() == 0) {
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
                    toast = Toast.makeText(getApplicationContext(), "Please enter Number of Projects", Toast.LENGTH_SHORT);
                    toast.show();
                    break;
                case "Tester":
                    toast = Toast.makeText(getApplicationContext(), "Please enter Number of Bugs", Toast.LENGTH_SHORT);
                    toast.show();
                    break;
            }
        } else if (carMotorbike.getCheckedRadioButtonId() == R.id.EmpCar && carType.equals("")) {
            Toast toast = Toast.makeText(getApplicationContext(), "Please enter Car Type", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            Toast toast = Toast.makeText(getApplicationContext(), "Valid input", Toast.LENGTH_SHORT);
            toast.show();
            Employee employee = null;
            int presentYear = Calendar.getInstance().get(Calendar.YEAR);
            int age = presentYear - Integer.parseInt(birthYear);
            switch (empTypeSpinner.getSelectedItem().toString()) {
                case "Manager":
                    employee = new Manager(Integer.parseInt(employeeId), firstName + " " + lastName, age, Integer.parseInt(birthYear),
                            Double.parseDouble(monthlySalary), Integer.parseInt(md), Double.parseDouble(occupationRate));
                    break;
                case "Programmer":
                    employee = new Programmer(Integer.parseInt(employeeId), firstName + " " + lastName, age, Integer.parseInt(birthYear),
                            Double.parseDouble(monthlySalary), Integer.parseInt(md), Double.parseDouble(occupationRate));
                    break;
                case "Tester":
                    employee = new Tester(Integer.parseInt(employeeId), firstName + " " + lastName, age, Integer.parseInt(birthYear),
                            Double.parseDouble(monthlySalary), Integer.parseInt(md), Double.parseDouble(occupationRate));
                    break;
                default:
                    break;
            }
            Vehicle vehicle = null;
            switch (carMotorbike.getCheckedRadioButtonId()) {
                case R.id.EmpCar:
                    vehicle = new Car(0, vehicleModel, plateNumber, colorSpinner.getSelectedItem().toString(), "", carType, employee.getEmpId());
                    break;
                case R.id.EmpMotorBike:
                    vehicle = new Motorcycle(0, vehicleModel, plateNumber, colorSpinner.getSelectedItem().toString(), "", extraCar.isActivated(), employee.getEmpId());
                    break;
                default:
                    break;
            }

            dataService.addEmployee(employee);
            dataService.addVehicle(vehicle);
            Intent intent=new Intent(this,MainActivity.class);
            startActivity(intent);
        }

    }
}

