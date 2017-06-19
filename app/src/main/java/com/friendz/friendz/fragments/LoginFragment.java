package com.friendz.friendz.fragments;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.friendz.friendz.HomeActivity;
import com.friendz.friendz.util.Constants;
import com.friendz.friendz.FriendzApp;
import com.friendz.friendz.LoginActivity;
import com.friendz.friendz.R;

import java.util.Arrays;

import butterknife.BindArray;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {
    @BindArray(R.array.facebook_permissions)
    String[] permissions;
    LoginActivity mLoginActivity;
    @BindView(R.id.login_button)
    LoginButton loginButton;
    Unbinder unbinder;
    SharedPreferences.Editor mEditor;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        unbinder = ButterKnife.bind(this, view);
        mLoginActivity = (LoginActivity) getActivity();
        loginButton.setFragment(this);
        mEditor = FriendzApp.getInstance().getmPrefs().edit();
        loginButton.setReadPermissions(Arrays.asList(permissions));

        loginButton.registerCallback(mLoginActivity.getCallbackManager(), new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                mEditor.putString(Constants.FB_ACCESS_TOKEN, loginResult.getAccessToken().getToken()).commit();
                mEditor.putString(Constants.FB_USER_ID, loginResult.getAccessToken().getUserId()).commit();
                startActivity(new Intent(getActivity(), HomeActivity.class));
                getActivity().finish();
            }

            @Override
            public void onCancel() {
                System.out.println("Cancelled");
            }

            @Override
            public void onError(FacebookException error) {
                System.out.println(error);
            }
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mLoginActivity.getCallbackManager().onActivityResult(requestCode,resultCode,data);
    }
}
