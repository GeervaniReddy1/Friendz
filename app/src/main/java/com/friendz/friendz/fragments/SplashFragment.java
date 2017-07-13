package com.friendz.friendz.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.friendz.friendz.FriendzApp;
import com.friendz.friendz.HomeActivity;
import com.friendz.friendz.InstagramActivity;
import com.friendz.friendz.R;
import com.friendz.friendz.util.Constants;

/**
 * A simple {@link Fragment} subclass.
 */
public class SplashFragment extends Fragment {


    public SplashFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (FriendzApp.getInstance().getmPrefs().contains(Constants.FB_ACCESS_TOKEN)) {
                    startActivity(new Intent(getActivity(), HomeActivity.class));
                    getActivity().finish();
                } else
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new LoginFragment()).commit();
            }
        }).start();
        return inflater.inflate(R.layout.fragment_splash, container, false);
    }

}
