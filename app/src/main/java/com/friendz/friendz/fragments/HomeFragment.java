package com.friendz.friendz.fragments;


import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SystemClock;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.facebook.AccessToken;
import com.facebook.FacebookActivity;
import com.facebook.FacebookDialog;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.login.LoginManager;
import com.friendz.friendz.FriendzApp;
import com.friendz.friendz.HomeActivity;
import com.friendz.friendz.LoginActivity;
import com.friendz.friendz.R;
import com.friendz.friendz.adapters.FeedAdapter;
import com.friendz.friendz.api.ApiHelper;
import com.friendz.friendz.db.Posts;
import com.friendz.friendz.db.PostsDataItem;
import com.friendz.friendz.model.PostResponse;
import com.friendz.friendz.reciever.EventNotifcationReceiver;
import com.friendz.friendz.request.FbMessageReq;
import com.friendz.friendz.request.Message;
import com.friendz.friendz.request.Recipient;
import com.friendz.friendz.service.FacebookSyncService;
import com.friendz.friendz.util.Constants;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;
import butterknife.Unbinder;
import io.realm.Realm;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

    String queries = "comments,likes,id, application, call_to_action, caption, created_time, description, feed_targeting, from, icon,   instagram_eligibility, is_hidden, is_instagram_eligible, is_published, link, message, message_tags, name, object_id, parent_id, permalink_url, picture, place, privacy, properties, shares, source, status_type, story, story_tags, targeting, to, type, updated_time, with_tags";

    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        mHomeActivity= (HomeActivity) getActivity();
//        ((FriendzApp)getActivity().getApplication()).getComponent().inject(this);
//        if(mPref.getStringSet(Constants.FRIENDS_LIST,null)==null){
//            mHomeActivity.getNavigation().setSelectedItemId(R.id.navigation_dashboard);
//        }
//        mHomeActivity.
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this, view);
        if (AccessToken.getCurrentAccessToken()!=null) {
            System.out.println("#####TOKEN##### "+AccessToken.getCurrentAccessToken().getToken());
            new GraphRequest(
                    AccessToken.getCurrentAccessToken(),
                    "/me/feed?fields="+queries,
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
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                final String finalData = data;
                                Realm.getDefaultInstance().executeTransaction(new Realm.Transaction() {
                                    @Override
                                    public void execute(Realm realm) {

                                        realm.createOrUpdateAllFromJson(PostsDataItem.class, finalData);

                                    }
                                });
                                RealmResults<PostsDataItem> dataItems= Realm.getDefaultInstance().where(PostsDataItem.class).findAll();
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

//        LoginManager.getInstance().logInWithPublishPermissions(this, Arrays.asList(new String[]{"publish_actions, manage_notifications"}));
//        Bundle bundle =new  Bundle();
//        bundle.putString("message","My first test post in fb");
//        new GraphRequest(
//                AccessToken.getCurrentAccessToken(),
//                "/me/feed",
//                bundle,
//                HttpMethod.POST,
//                new GraphRequest.Callback() {
//                    @Override
//                    public void onCompleted(GraphResponse response) {
//                        System.out.println("Posted Resp: "+response);
//                    }
//                }).executeAsync();
//        new GraphRequest(
//                AccessToken.getCurrentAccessToken(),
//                "/me/friends?fields=id,name, birthday",
//                null,
//                HttpMethod.GET,
//                new GraphRequest.Callback() {
//                    public void onCompleted(final GraphResponse response) {
//
//                        System.out.println(response);
//            /* handle the result */
//                    }
//                }
//        ).executeAsync();
//        sendMessage();
        AlarmManager alarmManager= (AlarmManager) getActivity().getSystemService(Context.ALARM_SERVICE);
        Intent intent=new Intent(getActivity(), EventNotifcationReceiver.class);
        intent.putExtra("Name","Dinesh Has sent this.");
//        PendingIntent pendingIntent=PendingIntent.getService(getActivity(),0,intent,0);
        PendingIntent pendingIntent=PendingIntent.getBroadcast(getActivity(),0,intent,0);
        alarmManager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME, SystemClock.elapsedRealtime(),60000,pendingIntent);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnItemClick(R.id.listFeeds)
    public void onItemClicked() {
    }

    private void sendMessage(){
        FbMessageReq msg=new FbMessageReq();
        Message m=new Message();
        m.setText("Hey How r u");
        Recipient r=new Recipient();
        r.setId("1872801576304970");
        msg.setMessage(m);
        msg.setRecipient(r);
        String url="https://graph.facebook.com/v2.6/me/messages?access_token="+AccessToken.getCurrentAccessToken().getToken();
        new ApiHelper().sendMessage(url,msg).enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                if(isAdded())
                System.out.println(response);
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                System.out.println(t);
            }
        });
    }
}
