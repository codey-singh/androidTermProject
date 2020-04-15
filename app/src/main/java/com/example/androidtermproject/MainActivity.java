package com.example.androidtermproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidtermproject.business.DatabaseHelper;
import com.example.androidtermproject.business.IDataService;
import com.example.androidtermproject.business.MemDataStoreSingleton;
import com.example.androidtermproject.business.exceptions.InvalidParamException;
import com.example.androidtermproject.models.Employee;
import com.example.androidtermproject.models.IEmployee;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private final String APP_NAME = "Hello";
    ListView listview;
    IDataService dataService;
    EditText searchBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchBar=findViewById(R.id.searchBar);
        listview = findViewById(R.id.List_Employees);
        dataService = DatabaseHelper.getInstance(this);
        ListAdapter listAdapter = null;
        try {
            listAdapter = new ListAdapter(this, dataService.getEmployees());
        } catch (InvalidParamException e) {
            e.printStackTrace();
        }
        listview.setAdapter(listAdapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ArrayList <IEmployee> employees= null;
                try {
                    employees = dataService.getEmployees();
                } catch (InvalidParamException e) {
                    e.printStackTrace();
                }
                IEmployee e=(Employee) employees.get(position);
                Intent intent=new Intent(MainActivity.this,EmployeeDetail.class);
                intent.putExtra("Employee", (Serializable) e);
                startActivity(intent);
            }
        });
        ListAdapter finalListAdapter = listAdapter;
        searchBar.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO Auto-generated method stub
                //MainActivity.this.adapt.getFilter().filter(s);
                String searchString=searchBar.getText().toString();
                finalListAdapter.filter(searchString);
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub

            }
        });
    }

    public void goToReg(View view) {
        Intent intent = new Intent(this, RegistrationForm.class);
        startActivity(intent);
    }
}