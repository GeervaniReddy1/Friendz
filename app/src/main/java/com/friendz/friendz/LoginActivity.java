package com.friendz.friendz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.friendz.friendz.fragments.LoginFragment;
import com.friendz.friendz.fragments.SplashFragment;
import com.friendz.friendz.util.Constants;

public class LoginActivity extends AppCompatActivity {
    FrameLayout container;

    public CallbackManager getCallbackManager() {
        return callbackManager;
    }

    CallbackManager callbackManager;

    public boolean isLoginToFb() {
        return isLoginToFb;
    }

    boolean isLoginToFb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        if (getIntent().getExtras() != null)
            isLoginToFb = getIntent().getExtras().getBoolean(Constants.LOGIN_TO_FB, false);
        container = (FrameLayout) findViewById(R.id.container);
        callbackManager = CallbackManager.Factory.create();
        if (!isLoginToFb())
            getSupportFragmentManager().beginTransaction().add(R.id.container, new SplashFragment()).commit();
        else
            getSupportFragmentManager().beginTransaction().add(R.id.container, new LoginFragment()).commit();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}

