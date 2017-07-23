package com.friendz.friendz;

import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.widget.Toast;

import com.friendz.friendz.api.ApiHelper;
import com.friendz.friendz.db.InstaDataItem;
import com.friendz.friendz.db.InstagramMediaResponse;
import com.friendz.friendz.db.PostsDataItem;
import com.google.gson.Gson;
import com.steelkiwi.instagramhelper.InstagramHelper;
import com.steelkiwi.instagramhelper.InstagramHelperConstants;
import com.steelkiwi.instagramhelper.model.InstagramUser;
import com.steelkiwi.instagramhelper.utils.SharedPrefUtils;

import java.text.ParseException;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InstagramActivity extends AppCompatActivity {

    @BindView(R.id.instsLogin)
    WebView instsLogin;
    InstagramHelper instagramHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instagram);
        ButterKnife.bind(this);
        String scope = "basic+public_content+follower_list+comments+relationships+likes";
//scope is for the permissions
        instagramHelper = new InstagramHelper.Builder()
                .withClientId("a0a6dd2d64334663aaeab3ebacadc673")
                .withRedirectUrl("http://localhost.com")
                .withScope(scope)
                .build();
        if (SharedPrefUtils.getToken(this) == null)
            instagramHelper.loginFromActivity(this);
//        getInstaData();?

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onActivityResult(final int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == InstagramHelperConstants.INSTA_LOGIN && resultCode == RESULT_OK) {
            InstagramUser user = instagramHelper.getInstagramUser(this);
            System.out.println(SharedPrefUtils.getToken(this));

//            Picasso.with(this).load(user.getData().getProfilePicture()).into(userPhoto);
//            userTextInfo.setText(user.getData().getUsername() + "\n"
//                    + user.getData().getFullName() + "\n"
//                    + user.getData().getWebsite()
//            );

        } else {
            Toast.makeText(this, "Login failed", Toast.LENGTH_LONG).show();
        }
        finish();
    }


}
