package com.example.myapplication;

import android.content.Context;
import android.content.SharedPreferences;

public class sharedPreferenceHelper {
    private SharedPreferences sharedPreferences;
    public void SharedPreferenceHelper(Context context)
    {
        sharedPreferences = context.getSharedPreferences("ProfilePreference", Context.MODE_PRIVATE );
    }

    public void saveProfileName(String name)
    {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("profileName",name );
        editor.commit();
    }

    public String getProfileName()
    {
        return sharedPreferences.getString("profileName", null);
    }
}


