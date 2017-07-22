package com.friendz.friendz;

import android.app.IntentService;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.util.ArraySet;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.friendz.friendz.adapters.FeedAdapter;
import com.friendz.friendz.db.PostsDataItem;
import com.friendz.friendz.util.Constants;

import org.json.JSONObject;

import java.util.Set;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmResults;


/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions and extra parameters.
 */
public class FetchFeedFromFbService extends IntentService {
    String queries = "id, application, call_to_action, caption, created_time, description, feed_targeting, from, icon,   instagram_eligibility, is_hidden, is_instagram_eligible, is_published, link, message, message_tags, name, object_id, parent_id, permalink_url, picture, place, privacy, properties, shares, source, status_type, story, story_tags, targeting, to, type, updated_time, with_tags";
@Inject
    SharedPreferences pref;
    public FetchFeedFromFbService() {
        super("FetchFeedFromFbService");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        FriendzApp.getInstance().getComponent().inject(this);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            Set<String> userIds=pref.getStringSet(Constants.FB_USER_ID,new ArraySet<String>());
            for(String s:userIds){
                getFeeds(s);
            }


        }
    }

    private void getFeeds(String userID) {
        new GraphRequest(
                AccessToken.getCurrentAccessToken(),
                "/"+userID+"/feed?fields="+queries,
                null,
                HttpMethod.GET,
                new GraphRequest.Callback() {
                    public void onCompleted(final GraphResponse response) {
                            String data=new String();
                            try {
                                JSONObject jsonObject=new JSONObject(response.getRawResponse());
                                data=jsonObject.getJSONArray("data").toString();
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

                        }
                }
        ).executeAsync();
    }


}
