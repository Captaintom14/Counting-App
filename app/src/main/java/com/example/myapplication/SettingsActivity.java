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


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


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
        sButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inserts();
                displayMode();
            }
        });
    }

    //This method is used to create the menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
       getMenuInflater().inflate(R.menu.menu_settings, menu);
       return true;
    }

    //This method is used to handle the clicks of the available options in the menu
    @Override
    public boolean onOptionsItemSelected (MenuItem item){

        if (item.getItemId() == R.id.action_settings) {
            editMode();
        }
        return super.onOptionsItemSelected(item);
    }


    //This method is used to set up the UI and declares their identities. It also displays texts as hints for the user.
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
    }

    //This method disables the texts once the user presses the Save button. It also hides the Save button.
    private void displayMode(){
        textA.setEnabled(false);
        textB.setEnabled(false);
        textC.setEnabled(false);
        countInsert.setHint(String.valueOf(settings.getTotalCount()));
        countInsert.setEnabled(false);
        sButton.setVisibility(View.GONE);
    }

    //This method enables the texts once the user presses the Edit Mode option in the menu. It also brings back the Save Button.
    private void editMode(){
        textA.setEnabled(true);
        textB.setEnabled(true);
        textC.setEnabled(true);
        countInsert.setEnabled(true);
        sButton.setVisibility(View.VISIBLE);
    }

    //In general, this method handles the user input.
    private void inserts(){
        String name1;
        String name2;
        String name3;
        int number;

        //With the use of a try-catch, it allows the application to not crash if the user inputs nothing.
        try {

            settings = new Settings();
            name1 = textA.getText().toString();
            name2 = textB.getText().toString();
            name3 = textC.getText().toString();
            number = Integer.parseInt(countInsert.getText().toString());

            //If the user inputs a number < 5 or > 200, it will make an error and display a message to try again so that the user puts an appropriate number
            if (number < 5 || number > 200){
                Toast.makeText(this,"Invalid, please insert a number between 5 and 200", Toast.LENGTH_SHORT).show();
                return;
            }

            //If the user inputs an empty name in one of the three names, it will make an error and display a message to try again.
            if (name1.isEmpty() || name2.isEmpty() || name3.isEmpty()){
                Toast.makeText(this, "Invalid, please insert names", Toast.LENGTH_SHORT).show();
                return;
            }

            //With the Settings class, it sets the names the maximum number of counts.
            settings.setName1(name1);
            settings.setName2(name2);
            settings.setName3(name3);
            settings.setTotalCount(number);

            //With the sharedPreferenceHelper class, it saves and the names and the maximum number of counts from the Settings class
            sharedPH = new sharedPreferenceHelper(getApplicationContext());
            sharedPH.saveProfileName1(settings.getName1());
            sharedPH.saveProfileName2(settings.getName2());
            sharedPH.saveProfileName3(settings.getName3());
            sharedPH.saveTotalCount(settings.getTotalCount());

            //Once the user presses the save button, it shows this message that the content is saved.
            Toast.makeText(this,"The names of each event and the maximum total count are now saved!", Toast.LENGTH_SHORT).show();

        }
        //If the user inputs nothing and presses the save button, it will make an error and display a message to put content in the names and the maximum number of counts.
        catch (NumberFormatException e){
            Toast.makeText(this,"Please insert names and the maximum number", Toast.LENGTH_SHORT).show();
            return;
        }
    }
}