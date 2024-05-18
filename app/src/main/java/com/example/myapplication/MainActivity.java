package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
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

    protected TextView textView;
    protected sharedPreferenceHelper sPh = new sharedPreferenceHelper();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUI();


          }
          private void setupUI() {
              settingsButton = findViewById(R.id.SettingsButton);
              eventA = findViewById(R.id.button1);
              eventB = findViewById(R.id.button2);
              eventC = findViewById(R.id.button3);
              showCounts = findViewById(R.id.sMCounts);
              textView = findViewById(R.id.totalCount);


              View.OnClickListener buttons = new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                      goToSettings();
                  }
              };
              settingsButton.setOnClickListener(buttons);

          }

          private void goToSettings(){

        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);

    }
}



