package com.andrebento.models;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by andre on 19/01/2017.
 */

public class MySharedPreferences {
    private static final String VELOCITY_KEY = "velocityKey";

    public static int loadVelocity(Context context) {
        SharedPreferences tmpSharedPreferences
                = PreferenceManager.getDefaultSharedPreferences(context);

        String storedVelocity = tmpSharedPreferences.getString(VELOCITY_KEY, "0");
        return Integer.parseInt(storedVelocity);
    }
}
