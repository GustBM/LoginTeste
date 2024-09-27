package com.example.loginteste.data.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.loginteste.data.model.User;
import com.google.gson.Gson;

public class SessionManager {
    private static final String SHARED_PREFS_NAME = "SessionPrefs";

    public static void setUser(Context context, String json) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("user", json);
        editor.apply();
    }

    public static User getUser(Context context) {
        Gson gson = new Gson();
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE);

        String userJson = sharedPreferences.getString("user", null);

        if (userJson != null) {
            return gson.fromJson(userJson, User.class);
        }

        return null;
    }
}
