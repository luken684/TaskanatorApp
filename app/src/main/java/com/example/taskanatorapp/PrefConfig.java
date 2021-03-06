package com.example.taskanatorapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class PrefConfig {

    private static final String SYSTEM_KEY = "system_key";
    private static final String PROGRESS_KEY = "progress_key";

    public static void saveSystem(Context context, System system){
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = pref.edit();

        Gson gson = new Gson();
        String jsonString = gson.toJson(system);
        editor.putString(SYSTEM_KEY, jsonString);
        editor.apply();
    }

    public static System loadSystem(Context context){
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        String jsonString = pref.getString(SYSTEM_KEY, "");

        Gson gson = new Gson();
        Type type = new TypeToken<System>(){}.getType();
        System system = gson.fromJson(jsonString, type);
        return system;
    }

    public static void saveProgressBar(Context context, SystemProgressBar progressBar){
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = pref.edit();

        Gson gson = new Gson();
        String jsonString = gson.toJson(progressBar);
        editor.putString(PROGRESS_KEY, jsonString);
        editor.apply();
    }

    public static SystemProgressBar loadProgressBar(Context context){
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        String jsonString = pref.getString(PROGRESS_KEY, "");

        Gson gson = new Gson();
        Type type = new TypeToken<SystemProgressBar>(){}.getType();
        SystemProgressBar progressBar = gson.fromJson(jsonString, type);
        return progressBar;
    }
}
