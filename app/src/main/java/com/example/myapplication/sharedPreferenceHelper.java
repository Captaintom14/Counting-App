package com.example.myapplication;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Collections;
import java.util.List;

public class sharedPreferenceHelper {
    private SharedPreferences sharedPreferences;
    public sharedPreferenceHelper(Context context)
    {
        sharedPreferences = context.getSharedPreferences("ProfilePreference", Context.MODE_PRIVATE );
    }

    public void saveProfileName1(String name){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("profileName1",name );
        editor.commit();
    }

    public String getProfileName1()
    {
        return sharedPreferences.getString("profileName1", null);
    }

    public void saveProfileName2(String name){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("profileName2",name );
        editor.commit();
    }
    public String getProfileName2()
    {
        return sharedPreferences.getString("profileName2", null);
    }

    public void saveProfileName3(String name){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("profileName3",name );
        editor.commit();
    }

    public String getProfileName3()
    {
        return sharedPreferences.getString("profileName3", null);
    }


    public void saveTotalCount(int count ){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("totalCount",count );
        editor.commit();
    }

    public int getTotalCount(){ return sharedPreferences.getInt("totalCount",0);}


    public void saveButtonOneCount(int count1){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("buttonOne",count1 );
        editor.commit();
    }
    public int getButtonOneCount(){ return sharedPreferences.getInt("buttonOne",0);}

    public void saveButtonTwoCount(int count2){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("buttonTwo",count2 );
        editor.commit();
    }
    public int getButtonTwoCount(){ return sharedPreferences.getInt("buttonTwo",0);}

    public void saveButtonThreeCount(int count3){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("buttonThree",count3 );
        editor.commit();
    }

    public int getButtonThreeCount(){ return sharedPreferences.getInt("buttonThree",0);}

}


