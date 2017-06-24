package com.friendz.friendz.service;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.friendz.friendz.adapters.FeedAdapter;
import com.friendz.friendz.db.Posts;
import com.friendz.friendz.db.PostsDataItem;

import io.realm.Realm;
import io.realm.RealmResults;


public class FacebookSyncService extends IntentService {

    public FacebookSyncService() {
        super("FacebookSyncService");
    }
    String queries = "id, application, call_to_action, caption, created_time, description, feed_targeting, from, icon,   instagram_eligibility, is_hidden, is_instagram_eligible, is_published, link, message, message_tags, name, object_id, parent_id, permalink_url, picture, place, privacy, properties, shares, source, status_type, story, story_tags, targeting, to, type, updated_time, with_tags";

    @Override
    protected void onHandleIntent(Intent intent) {
        new GraphRequest(
                AccessToken.getCurrentAccessToken(),
                "/me/feed?fields="+queries,
                null,
                HttpMethod.GET,
                new GraphRequest.Callback() {
                    public void onCompleted(final GraphResponse response) {

                        Realm.getDefaultInstance().executeTransaction(new Realm.Transaction() {
                            @Override
                            public void execute(Realm realm) {
                                realm.createObjectFromJson(Posts.class,response.getRawResponse());

                            }
                        });
                        System.out.println("hey i got the response");
//                        PostResponse postResponse=new Gson().fromJson(response.getRawResponse(),PostResponse.class);

            /* handle the result */
                    }
                }
        ).executeAndWait();

    }


}
