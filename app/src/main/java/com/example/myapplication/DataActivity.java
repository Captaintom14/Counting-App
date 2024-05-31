package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class DataActivity extends AppCompatActivity {

    protected Toolbar toolbar;
    protected TextView textA;
    protected TextView textB;
    protected TextView textC;
    protected TextView totalEvents;
    sharedPreferenceHelper sharedPH;
    List<String> list = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);


        //If the list of names is null, then it initializes it
        if (list == null){
            list = new ArrayList<>();
        }

        setupUI();
        displayEventMode();

    }


    //This method is used to declare the UI and their identities
    @SuppressLint("SetTextI18n")
    private void setupUI(){
        toolbar = (Toolbar) findViewById(R.id.toolbarData);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.data);
        textA = findViewById(R.id.eventOneText);
        textB = findViewById(R.id.eventTwoText);
        textC = findViewById(R.id.eventThreeText);
        totalEvents = findViewById(R.id.totalEventsText);
        sharedPH = new sharedPreferenceHelper(this);
    }


    //This method is used to create the menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_data, menu);
        return true;
    }


    //This method is used to handle the clicks of the available options in the menu
    @Override
    public boolean onOptionsItemSelected (MenuItem item){

        if (item.getItemId() == R.id.action_data) {
            toggleEventMode();
        }
        return super.onOptionsItemSelected(item);
    }


    //This method is used to display the names of the buttons and the number of counts.
    @SuppressLint("SetTextI18n")
    private void displayEventMode(){
        textA.setText(sharedPH.getProfileName1() + ": " + String.valueOf(sharedPH.getButtonOneCount()) + " events");
        textB.setText(sharedPH.getProfileName2()+ ": " +  String.valueOf(sharedPH.getButtonTwoCount()) + " events");
        textC.setText(sharedPH.getProfileName3() + ": "+ String.valueOf(sharedPH.getButtonThreeCount())+ " events");
        totalEvents.setText("Total Events: "+ String.valueOf(sharedPH.getTotalCount()) + " events");
        list.add(sharedPH.getProfileName1());
        list.add(sharedPH.getProfileName2());
        list.add(sharedPH.getProfileName3());
    }


    //If the user presses the Toggle Events names option, it replaces the names of the buttons into Counter A, B and C.
    @SuppressLint("SetTextI18n")
    private void toggleEventMode(){

        for (String name: list){
            if (name.equals(sharedPH.getProfileName1())){
                textA.setText("Counter A: "  + String.valueOf(sharedPH.getButtonOneCount()) + " events");
            } else if (name.equals(sharedPH.getProfileName2())) {
                textB.setText("Counter B: " + String.valueOf(sharedPH.getButtonTwoCount()) + " events");
            }
            else if (name.equals(sharedPH.getProfileName3())){
                textC.setText("Counter C: " + String.valueOf(sharedPH.getButtonThreeCount()) + " events");
            }
        }



    }





}