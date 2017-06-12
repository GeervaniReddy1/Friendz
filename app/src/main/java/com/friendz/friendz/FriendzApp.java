package com.friendz.friendz;

import android.app.Application;
import android.content.SharedPreferences;

/**
 * Created by dineshkumarbalasubramanian on 10/06/17.
 */

public class FriendzApp extends Application {
    private static final String PREFERENCE_NAME = "friendz_app";
    static FriendzApp instance;
    SharedPreferences mPrefs;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        mPrefs = getSharedPreferences(PREFERENCE_NAME, MODE_PRIVATE);
    }

    public static FriendzApp getInstance() {
        return instance;
    }

    public SharedPreferences getmPrefs() {
        return mPrefs;
    }
}
