package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
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
    protected TextView txt;
    protected Settings settings;

    sharedPreferenceHelper sharedPH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        setupUI();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
       getMenuInflater().inflate(R.menu.menu_settings, menu);
       return true;
    }


    @Override
    public boolean onOptionsItemSelected (MenuItem item){

        if (item.getItemId() == R.id.action_settings) {
            editMode();
        }
        return super.onOptionsItemSelected(item);
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

        textA.setHint("Please insert a name");
        textB.setHint("Please insert a name");
        textC.setHint("Please insert a name");
        countInsert.setHint("Please insert a maximum number");

        sButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inserts();
                displayMode();
            }
        });



    }

    private void inserts(){
        String name1;
        String name2;
        String name3;
        int number;
        try {

            settings = new Settings();
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

            settings.setName1(name1);
            settings.setName2(name2);
            settings.setName3(name3);
            settings.setTotalCount(number);
            sharedPH = new sharedPreferenceHelper(getApplicationContext());
            sharedPH.saveProfileName1(settings.getName1());
            sharedPH.saveProfileName2(settings.getName2());
            sharedPH.saveProfileName3(settings.getName3());

            Toast.makeText(this,"The names of each event and the maximum total count are now saved!", Toast.LENGTH_SHORT).show();

        } catch (NumberFormatException e){
            Toast.makeText(this,"Please insert names and the maximum number", Toast.LENGTH_SHORT).show();
            return;
        }
    }


    private void displayMode(){

        textA.setEnabled(false);

        textB.setEnabled(false);

        textC.setEnabled(false);
        countInsert.setHint(String.valueOf(settings.getTotalCount()));
        countInsert.setEnabled(false);
        sButton.setVisibility(View.GONE);
    }

    private void editMode(){
        textA.setEnabled(true);
        textB.setEnabled(true);
        textC.setEnabled(true);
        countInsert.setEnabled(true);
        sButton.setVisibility(View.VISIBLE);
    }



}