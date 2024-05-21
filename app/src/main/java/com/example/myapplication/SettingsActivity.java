package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SettingsActivity extends AppCompatActivity {

    private Toolbar toolbar;
    protected EditText textA;
    protected EditText textB;
    protected EditText textC;
    protected EditText countInsert;
    protected Button sButton;
    protected Settings profile;
    protected TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        setupUI();

        findViewById(R.id.saveButton).setOnClickListener(v -> onRegisterClick());
    }


    private void setupUI(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.settings);

        textA = findViewById(R.id.editText3);
        textB = findViewById(R.id.editText2);
        textC = findViewById(R.id.editText1);
        countInsert = findViewById(R.id.countText);
        sButton  = findViewById(R.id.saveButton);
        txt = findViewById(R.id.textView);
    }

    @SuppressLint("SetTextI18n")
    private void onRegisterClick(){

        String name1;
        String name2;
        String name3;
        int number;

        try {

           name1 = textA.getText().toString();
           name2 = textB.getText().toString();
           name3 = textC.getText().toString();

           number = Integer.parseInt(countInsert.getText().toString());
            if (number < 5 || number > 200){
                Toast.makeText(this,"Invalid, please insert a number between 5 and 200", Toast.LENGTH_SHORT).show();
                return;
            }

            if (name1.isEmpty() || name2.isEmpty() || name3.isEmpty()){
                Toast.makeText(this, "Invalid, please insert names", Toast.LENGTH_SHORT).show();
                return;
            }

            txt.setText(name1 + " " + name2 + " " + name3 + " " + number);

        } catch (NumberFormatException e){
            Toast.makeText(this,"Please insert names and the maximum number", Toast.LENGTH_SHORT).show();
            return;
        }

        System.out.println("text A " + name1);
        System.out.println("text B " + name2);
        System.out.println("text C " + name3);
        System.out.println("number " + number);
    }

}