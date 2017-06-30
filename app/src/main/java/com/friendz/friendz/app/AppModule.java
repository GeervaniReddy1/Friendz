package com.friendz.friendz.app;

import android.content.Context;
import android.content.SharedPreferences;

import com.friendz.friendz.FriendzApp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by dineshkumarbalasubramanian on 28/06/2017 AD.
 */

@Module
public class AppModule {
private final String SHARED_NAME="Friendz";
SharedPreferences preferences;
    FriendzApp context;

    public AppModule(FriendzApp app) {
    this.context=app;
    }

    @Provides
    @Singleton
    SharedPreferences provideSharepreference(){
        return context.getSharedPreferences(SHARED_NAME,Context.MODE_PRIVATE);
    }
}
