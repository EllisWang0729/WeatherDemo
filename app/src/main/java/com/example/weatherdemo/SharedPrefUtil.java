package com.example.weatherdemo;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefUtil {
    private static final String PREFS_NAME = "setting";
    private static final String KEY_FIRST_COME = "FirstCome";

    private static SharedPreferences getPrefs(Context context) {
        return context.getSharedPreferences(PREFS_NAME, Activity.MODE_PRIVATE);
    }

    public static boolean isFirstCome(Context context) {
        return getPrefs(context).getBoolean(KEY_FIRST_COME, true);
    }

    public static void setFirstCome(Context context, boolean isFirst) {
        getPrefs(context).edit().putBoolean(KEY_FIRST_COME, isFirst).apply();

    }


}
