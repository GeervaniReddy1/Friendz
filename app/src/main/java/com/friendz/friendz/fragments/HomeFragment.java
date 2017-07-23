package com.friendz.friendz.fragments;


import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.util.ArraySet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.login.LoginManager;
import com.friendz.friendz.FriendzApp;
import com.friendz.friendz.HomeActivity;
import com.friendz.friendz.LoginActivity;
import com.friendz.friendz.R;
import com.friendz.friendz.adapters.FeedAdapter;
import com.friendz.friendz.db.PostsDataItem;
import com.friendz.friendz.reciever.EventNotifcationReceiver;
import com.friendz.friendz.util.Constants;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.Set;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;
import butterknife.Unbinder;
import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    @Inject
    SharedPreferences mPref;

    @BindView(R.id.listFeeds)
    ListView listFeeds;
    Unbinder unbinder;
    HomeActivity mHomeActivity;
    public HomeFragment() {
        // Required empty public constructor
    }
    Set<String> userIds;
    String queries = "comments,likes,id, application, call_to_action, caption, created_time, description, feed_targeting, from, icon,   instagram_eligibility, is_hidden, is_instagram_eligible, is_published, link, message, message_tags, name, object_id, parent_id, permalink_url, picture, place, privacy, properties, shares, source, status_type, story, story_tags, targeting, to, type, updated_time, with_tags";

    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mHomeActivity= (HomeActivity) getActivity();
        ((FriendzApp)getActivity().getApplication()).getComponent().inject(this);
        if(mPref.getStringSet(Constants.FRIENDS_LIST,null)==null){
            mHomeActivity.getNavigation().setSelectedItemId(R.id.navigation_dashboard);
        }
//        mHomeActivity.
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this, view);
        userIds=mPref.getStringSet(Constants.FRIENDS_LIST,new ArraySet<String>());
        userIds.add("me");
        for(String useriD:userIds) {
            getPosts(useriD);
        }


        checkPublishPermission();

//        publishOnTime();

        return view;
    }

    private void checkPublishPermission() {
        new GraphRequest(
          AccessToken.getCurrentAccessToken(),
                  "/me/permissions",
                  null,
                  HttpMethod.GET,
                  new GraphRequest.Callback() {
                      public void onCompleted(GraphResponse response) {
                          System.out.println(response);
                          try {
                              if(!checkPermissions(response)){
                                  LoginManager.getInstance().logInWithPublishPermissions(HomeFragment.this, Arrays.asList(new String[]{"publish_actions"}));
                              }
                          } catch (JSONException e) {

                              e.printStackTrace();
                          }
              /* handle the result */
                      }
                  }
  ).executeAsync();
    }

    private void publishOnTime() {
        AlarmManager alarmManager= (AlarmManager) getActivity().getSystemService(Context.ALARM_SERVICE);
        Intent intent=new Intent(getActivity(), EventNotifcationReceiver.class);
        intent.putExtra("Name","Dinesh Has sent this.");
//        PendingIntent pendingIntent=PendingIntent.getService(getActivity(),0,intent,0);
        PendingIntent pendingIntent=PendingIntent.getBroadcast(getActivity(),0,intent,0);
        alarmManager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME, SystemClock.elapsedRealtime(),60000,pendingIntent);
    }

    private boolean checkPermissions(GraphResponse response) throws JSONException {
        JSONObject jsonObject=new JSONObject(response.getRawResponse());
        JSONArray data=jsonObject.getJSONArray("data");
        for(int i=0;i<data.length();i++){
            if (data.getJSONObject(i).getString("permission").equals("publish_actions")&&data.getJSONObject(i).getString("status").equals("granted")){
                return true;
            }
        }
        return false;
    }

    private void getPosts(String userId) {
        if (AccessToken.getCurrentAccessToken()!=null) {
            System.out.println("#####TOKEN##### "+AccessToken.getCurrentAccessToken().getToken());
            new GraphRequest(
                    AccessToken.getCurrentAccessToken(),
                    "/"+userId+"/feed?fields="+queries,
                    null,
                    HttpMethod.GET,
                    new GraphRequest.Callback() {
                        public void onCompleted(final GraphResponse response) {
                            if (isAdded()) {
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
                                RealmResults<PostsDataItem> dataItems= Realm.getDefaultInstance().where(PostsDataItem.class).equalTo("type","video").or().equalTo("type","photo").or().equalTo("type","link").or().equalTo("type","status").findAllSorted("updated_time", Sort.DESCENDING);
                                //                        PostResponse postResponse=new Gson().fromJson(response.getRawResponse(),PostResponse.class);
                                FeedAdapter adapter=new FeedAdapter(getActivity(),(dataItems));
                                listFeeds.setAdapter(adapter);
                            }
                /* handle the result */
                        }
                    }
            ).executeAsync();
        }else{
            Intent intent=new Intent(getActivity(), LoginActivity.class);
            intent.putExtra(Constants.LOGIN_TO_FB,true);
            startActivity(intent);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnItemClick(R.id.listFeeds)
    public void onItemClicked() {
    }


}
