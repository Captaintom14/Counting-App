package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    protected Button settingsButton;
    protected Button eventA;
    protected Button eventB;
    protected Button eventC;
    protected Button showCounts;

    protected TextView totalCount;
    protected sharedPreferenceHelper sPH;
    Settings settings;
    int countA;
     int countB;
     int countC;

    int countDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sPH = new sharedPreferenceHelper(MainActivity.this);
        setupUI();
        totalCount.setText("Total Count: " + String.valueOf(countDisplay));
        View.OnClickListener buttons = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToSettings();
            }
        };
        settingsButton.setOnClickListener(buttons);
    }

    protected void onStart() {
        super.onStart();

        if (sPH.getProfileName1() == null && sPH.getProfileName2() == null && sPH.getProfileName3() == null){
            goToSettings();
        } else {
            eventA.setText(sPH.getProfileName1());
            eventB.setText(sPH.getProfileName2());
            eventC.setText(sPH.getProfileName3());
        }

    }


    @Override
    protected void onResume() {
        super.onResume();

        buttonIncrement();

    }

    private void setupUI() {
              settingsButton = findViewById(R.id.SettingsButton);
              eventA = findViewById(R.id.button1);
              eventB = findViewById(R.id.button2);
              eventC = findViewById(R.id.button3);
              showCounts = findViewById(R.id.sMCounts);
              totalCount = findViewById(R.id.totalCount);
    }


    private void buttonIncrement(){
        eventA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countA++;
                updateCounts();
            }
        });

        eventB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countB++;
                updateCounts();
            }
        });

        eventC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countC++;
                updateCounts();
            }
        });
    }

    private void updateCounts(){

        countDisplay = countA + countB + countC;
        totalCount.setText("Total Count: " + String.valueOf(countDisplay));

        if (countDisplay == 10){
            eventA.setEnabled(false);
            eventB.setEnabled(false);
            eventC.setEnabled(false);
            Toast.makeText(this,"You have reached the maximum number of events", Toast.LENGTH_SHORT).show();
        }
    }




    private void goToSettings(){
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }
}



