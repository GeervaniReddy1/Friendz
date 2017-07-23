package com.friendz.friendz.fragments;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.util.ArraySet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.friendz.friendz.FriendzApp;
import com.friendz.friendz.HomeActivity;
import com.friendz.friendz.InstagramActivity;
import com.friendz.friendz.LoginActivity;
import com.friendz.friendz.R;
import com.friendz.friendz.adapters.FeedAdapter;
import com.friendz.friendz.db.PostsDataItem;
import com.friendz.friendz.util.Constants;

import org.json.JSONObject;

import java.util.Set;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;

/**
 * A simple {@link Fragment} subclass.
 */
public class SplashFragment extends Fragment {
    @Inject
    SharedPreferences mPref;
    String queries = "comments,likes,id, application, call_to_action, caption, created_time, description, feed_targeting, from, icon,   instagram_eligibility, is_hidden, is_instagram_eligible, is_published, link, message, message_tags, name, object_id, parent_id, permalink_url, picture, place, privacy, properties, shares, source, status_type, story, story_tags, targeting, to, type, updated_time, with_tags";

    public SplashFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FriendzApp.getInstance().getComponent().inject(this);
        new Thread(new Runnable() {
            @Override
            public void run() {
                Set<String> userIds = mPref.getStringSet(Constants.FRIENDS_LIST, new ArraySet<String>());
                userIds.add("me");
                for (String useriD : userIds) {
                    getPosts(useriD);
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

    private void getPosts(String userId) {
        if (AccessToken.getCurrentAccessToken() != null) {
            System.out.println("#####TOKEN##### " + AccessToken.getCurrentAccessToken().getToken());
            new GraphRequest(
                    AccessToken.getCurrentAccessToken(),
                    "/" + userId + "/feed?fields=" + queries,
                    null,
                    HttpMethod.GET,
                    new GraphRequest.Callback() {
                        public void onCompleted(final GraphResponse response) {
                            if (isAdded()) {
                                String data = new String();
                                try {
                                    JSONObject jsonObject = new JSONObject(response.getRawResponse());
                                    data = jsonObject.getJSONArray("data").toString();
                                    System.out.println(data);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                final String finalData = data;
                                Realm.getDefaultInstance().executeTransaction(new Realm.Transaction() {
                                    @Override
                                    public void execute(Realm realm) {

                                        realm.createOrUpdateAllFromJson(PostsDataItem.class, finalData);

                                    }
                                });

                                //                        PostResponse postResponse=new Gson().fromJson(response.getRawResponse(),PostResponse.class);

                            }
                /* handle the result */
                        }
                    }
            ).executeAndWait();
        } else {
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            intent.putExtra(Constants.LOGIN_TO_FB, true);
            startActivity(intent);
        }
    }
}
