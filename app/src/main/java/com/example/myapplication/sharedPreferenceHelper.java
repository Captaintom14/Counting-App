package com.example.myapplication;

import android.content.Context;
import android.content.SharedPreferences;

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

}


