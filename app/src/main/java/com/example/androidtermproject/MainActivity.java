package com.example.androidtermproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private final String APP_NAME = "Hello";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String demo = "Hello demo";
    }

    public void goToReg(View view) {
        Intent intent = new Intent(this, EmpRegistrationActivity.class);
        startActivity(intent);
    }
}
