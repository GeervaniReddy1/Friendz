package com.friendz.friendz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.friendz.friendz.fragments.SplashFragment;

public class LoginActivity extends AppCompatActivity {
    FrameLayout container;

    public CallbackManager getCallbackManager() {
        return callbackManager;
    }

    CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        container = (FrameLayout) findViewById(R.id.container);
        callbackManager = CallbackManager.Factory.create();
        getSupportFragmentManager().beginTransaction().add(R.id.container, new SplashFragment()).commit();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}

