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

        //initialize the total count to 0
        totalCount.setText("Total Count: " + String.valueOf(countDisplay));


        //If the user presses the "Settings" button, the user is directed to the Settings Page.
        View.OnClickListener buttons = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToSettings();
            }
        };
        settingsButton.setOnClickListener(buttons);

        //If the user presses the "Show my Counts" button, the use is directed to the Data Page.
        View.OnClickListener data = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToData();
            }

    }; showCounts.setOnClickListener(data);

    }


    //On the start of the Application, this method checks if all the three buttons have names set. If not, it directly goes to the Settings Page
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


    //This method is used to declare the UI and their identities
    private void setupUI() {
              settingsButton = findViewById(R.id.SettingsButton);
              eventA = findViewById(R.id.button1);
              eventB = findViewById(R.id.button2);
              eventC = findViewById(R.id.button3);
              showCounts = findViewById(R.id.sMCounts);
              totalCount = findViewById(R.id.totalCount);
    }


    //This method allows to increment the count of each buttons.
    private void buttonIncrement(){

        //Increments and updates the count of the upper button
        eventA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countA++;
                updateCounts();
            }
        });

        //Increments and updates the count of the middle button
        eventB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countB++;
                updateCounts();
            }
        });

        //Increments and updates the count of the lower button
        eventC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countC++;
                updateCounts();
            }
        });
    }


    //This method allows to update the number of counts depending on the user input
    private void updateCounts(){

        sPH.saveButtonOneCount(countA);
        sPH.saveButtonTwoCount(countB);
        sPH.saveButtonThreeCount(countC);

        countDisplay = countA + countB + countC;
        totalCount.setText("Total Count: " + String.valueOf(countDisplay));

        //The three buttons are disabled after reaching to the maximum number of counts set by the user. A message is also shown.
        if (countDisplay == sPH.getTotalCount()){
            eventA.setEnabled(false);
            eventB.setEnabled(false);
            eventC.setEnabled(false);
            Toast.makeText(this,"You have reached the maximum number of events", Toast.LENGTH_SHORT).show();
        }
    }


    //This method goes to the SettingsActivity Page
    private void goToSettings(){
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    //This method goes to the DataActivity Page
    private void goToData(){
        Intent intent = new Intent(this, DataActivity.class);
        startActivity(intent);
    }



}



