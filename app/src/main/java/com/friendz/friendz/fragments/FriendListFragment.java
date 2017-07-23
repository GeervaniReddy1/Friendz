package com.friendz.friendz.fragments;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.util.ArraySet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.friendz.friendz.FriendzApp;
import com.friendz.friendz.HomeActivity;
import com.friendz.friendz.R;
import com.friendz.friendz.adapters.FriendsListAdapter;
import com.friendz.friendz.db.FriendsListDataItem;
import com.friendz.friendz.util.Constants;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Set;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;
import butterknife.Unbinder;
import io.realm.Realm;
import io.realm.RealmResults;

//import com.friendz.friendz.db.InstaDataItem;

/**
 * A simple {@link Fragment} subclass.
 */
public class FriendListFragment extends Fragment {


    @BindView(R.id.listFriends)
    ListView listFriends;
    Unbinder unbinder;
    @BindView(R.id.btnSaveFrnds)
    Button btnSaveFrnds;
    @Inject
    SharedPreferences pref;
HomeActivity homeActivity;
    public FriendListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_friend_list, container, false);
        unbinder = ButterKnife.bind(this, view);
        FriendzApp.getInstance().getComponent().inject(this);
        homeActivity= (HomeActivity) getActivity();

        new GraphRequest(
                AccessToken.getCurrentAccessToken(),
                "me/friends?fields=id,name,picture&limit=100",
                null,
                HttpMethod.GET,
                new GraphRequest.Callback() {
                    public void onCompleted(final GraphResponse response) {
            /* handle the result */

                        System.out.println(response);
                        try {
                            JSONObject jsonObject = new JSONObject(response.getRawResponse());
                            final JSONArray friendsData = jsonObject.getJSONArray("data");
                            Realm.getDefaultInstance().executeTransaction(new Realm.Transaction() {
                                @Override
                                public void execute(Realm realm) {
                                    realm.createOrUpdateAllFromJson(FriendsListDataItem.class, friendsData.toString());

                                }
                            });
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                        RealmResults<FriendsListDataItem> friends = Realm.getDefaultInstance().where(FriendsListDataItem.class).findAll();
                        // FriendsResponse friendsResponse=new Gson().fromJson(response.getRawResponse(),FriendsResponse.class);
                        FriendsListAdapter adapter = new FriendsListAdapter(getActivity(), (friends));
                        listFriends.setAdapter(adapter);

                    }
                }
        ).executeAsync();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnItemClick(R.id.listFriends)
    public void onItemClicked() {
    }

    @OnClick(R.id.btnSaveFrnds)
    public void onViewClicked() {
        Set<String> friendsID = new ArraySet<>();
        RealmResults<FriendsListDataItem> friendsListDataItems = Realm.getDefaultInstance().where(FriendsListDataItem.class).equalTo("isCloseFriend", true).findAll();
        for (FriendsListDataItem data : friendsListDataItems) {
            friendsID.add(data.getId());
        }
        pref.edit().putStringSet(Constants.FRIENDS_LIST, friendsID).commit();
        homeActivity.getNavigation().setSelectedItemId(R.id.navigation_home);
    }
}
