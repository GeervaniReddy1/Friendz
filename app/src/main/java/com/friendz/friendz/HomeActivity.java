package com.friendz.friendz;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.friendz.friendz.fragments.EventsFragment;
import com.friendz.friendz.fragments.FriendListFragment;
import com.friendz.friendz.fragments.HomeFragment;
import com.friendz.friendz.fragments.InstaFragment;
import com.friendz.friendz.fragments.SettingsFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity {


    public BottomNavigationView getNavigation() {
        return navigation;
    }

    @BindView(R.id.navigation)
    BottomNavigationView navigation;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    getSupportFragmentManager().beginTransaction().replace(R.id.content, new HomeFragment()).commit();
                    return true;
                case R.id.navigation_dashboard:
                    getSupportFragmentManager().beginTransaction().replace(R.id.content, new FriendListFragment()).commit();
                    return true;
                case R.id.navigation_notifications:
                    getSupportFragmentManager().beginTransaction().replace(R.id.content, new EventsFragment()).commit();

                    return true;
                case R.id.navigation_insta:
                    getSupportFragmentManager().beginTransaction().replace(R.id.content, new SettingsFragment()).commit();
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        if (AccessToken.getCurrentAccessToken()==null||AccessToken.getCurrentAccessToken().isExpired()) {
            AccessToken.refreshCurrentAccessTokenAsync(new AccessToken.AccessTokenRefreshCallback() {
                @Override
                public void OnTokenRefreshed(AccessToken accessToken) {
                    AccessToken.setCurrentAccessToken(accessToken);
                    navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
                    navigation.setSelectedItemId(R.id.navigation_home);
                }

                @Override
                public void OnTokenRefreshFailed(FacebookException exception) {
                    System.out.println(exception);
                }
            });
        } else {
            BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
            navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
            navigation.setSelectedItemId(R.id.navigation_home);
        }
    }

}

