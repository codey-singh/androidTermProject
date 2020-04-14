package com.example.androidtermproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidtermproject.business.IDataService;
import com.example.androidtermproject.business.MemDataStoreSingleton;
import com.example.androidtermproject.models.Car;
import com.example.androidtermproject.models.Employee;
import com.example.androidtermproject.models.IVehicle;
import com.example.androidtermproject.models.Manager;
import com.example.androidtermproject.models.Motorcycle;
import com.example.androidtermproject.models.Programmer;
import com.example.androidtermproject.models.Tester;

public class EmployeeDetail extends AppCompatActivity {
    TextView name,age,occupationRate, hasACarOrBike,
            annualIncome, carModelDetails, plateDetails,
            colorDetails, typeDetails, hasSideCar, achievementDisplay;
    LinearLayout carTypeLL, hasSideLL;
    IDataService dataService;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_detail);
        name=findViewById(R.id.nameDetails);
        age=findViewById(R.id.ageDetails);
        hasACarOrBike = findViewById(R.id.hasCarOrBike);
        occupationRate=findViewById(R.id.occupationRateDetails);
        annualIncome=findViewById(R.id.annualIncomeDetails);
        carModelDetails = findViewById(R.id.carModelDetails);
        plateDetails = findViewById(R.id.plateDetails);
        colorDetails = findViewById(R.id.colorDetails);
        typeDetails = findViewById(R.id.typeDetails);
        carTypeLL = findViewById(R.id.carTypeLL);
        hasSideLL = findViewById(R.id.hasSideLL);
        hasSideCar = findViewById(R.id.hasSideCar);
        achievementDisplay = findViewById(R.id.achievementDisplay);
        Employee employee= (Employee) getIntent().getSerializableExtra("Employee");
        Toast.makeText(this,""+employee.getRole(),Toast.LENGTH_SHORT).show();

        int employeeId = employee.getId();

        name.setText(""+employee.getName() + ", a " +employee.getRole());
        age.setText(""+employee.getAge());

        dataService = MemDataStoreSingleton.getInstance();

        IVehicle v = dataService.getVehicleForEmployee(employeeId);
        if (v.getVehicleType().equals("Car")) {
            hasACarOrBike.setText("Employee has a Car");
            carModelDetails.setText(((Car) v).getMake());
            plateDetails.setText(((Car) v).getPlate());
            colorDetails.setText(((Car) v).getColor());
            typeDetails.setText(((Car) v).getType());
            carTypeLL.setVisibility(View.VISIBLE);
        } else {
            hasACarOrBike.setText("Employee has a MotorCycle");
            carModelDetails.setText(((Motorcycle) v).getMake());
            plateDetails.setText(((Motorcycle) v).getPlate());
            colorDetails.setText(((Motorcycle) v).getColor());
            if(((Motorcycle) v).isHasSideCar()){
                hasSideCar.setText(" * With a Side Car");
            }else{
                hasSideCar.setText(" * Without a Side Car");
            }
            hasSideLL.setVisibility(View.VISIBLE);
        }

        occupationRate.setText(""+employee.getRate());
        annualIncome.setText(""+employee.getMonthlySalary()*12);

        if(employee.getRole().equals("Manager")){
            int clients = ((Manager) employee).getNbClients();
            achievementDisplay.setText("He/She has brought " + clients + " new Clients" );
        }else if(employee.getRole().equals("Tester")){
            int bugs = ((Tester) employee).getNbBugs();
            achievementDisplay.setText("He/She has corrected " + bugs + " bugs" );
        } else{
            int projectCount = ((Programmer) employee).getNbProjects();
            achievementDisplay.setText("He/She has completed" + projectCount + " Projects" );
        }
    }
}
