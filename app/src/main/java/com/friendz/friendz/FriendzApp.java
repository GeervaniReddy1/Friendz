package com.friendz.friendz;

import android.app.Application;
import android.content.SharedPreferences;

import com.friendz.friendz.app.AppComponent;
import com.friendz.friendz.app.AppModule;
import com.friendz.friendz.app.DaggerAppComponent;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by dineshkumarbalasubramanian on 10/06/17.
 */

public class FriendzApp extends Application {
    private static final String PREFERENCE_NAME = "friendz_app";
    static FriendzApp instance;
    SharedPreferences mPrefs;
    AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        mPrefs = getSharedPreferences(PREFERENCE_NAME, MODE_PRIVATE);
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder().schemaVersion(1).build();
        Realm.setDefaultConfiguration(config);
        component=DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        component.inject(this);
    }

    public AppComponent getComponent() {
        return component;
    }

    public static FriendzApp getInstance() {
        return instance;
    }

    public SharedPreferences getmPrefs() {
        return mPrefs;
    }
}
