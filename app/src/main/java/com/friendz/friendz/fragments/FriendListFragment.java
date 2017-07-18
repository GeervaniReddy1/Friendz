package com.friendz.friendz.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.friendz.friendz.FriendzApp;
import com.friendz.friendz.R;
import com.friendz.friendz.adapters.FriendsListAdapter;
import com.friendz.friendz.model.FriendsResponse;
import com.friendz.friendz.util.Constants;
import com.google.gson.Gson;
//import com.friendz.friendz.db.InstaDataItem;
import com.friendz.friendz.db.FriendsList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.OnItemClick;
import io.realm.Realm;
import io.realm.RealmResults;

/**
 * A simple {@link Fragment} subclass.
 */
public class FriendListFragment extends Fragment {


    @BindView(R.id.listFriends)
    ListView listFriends;
    Unbinder unbinder;

    public FriendListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_friend_list, container, false);
        unbinder = ButterKnife.bind(this, view);
        new GraphRequest(
                AccessToken.getCurrentAccessToken(),
                "me/friends?fields=id,name&limit=100",
                null,
                HttpMethod.GET,
                new GraphRequest.Callback() {
                    public void onCompleted(final GraphResponse response) {
            /* handle the result */

            System.out.println(response);

////                        Realm.getDefaultInstance().executeTransaction(new Realm.Transaction() {
////                            @Override
////                            public void execute(Realm realm) {
////                                realm.createObjectFromJson(FriendsList.class,response.getRawResponse());
//
//                            }
//                        });



//                        RealmResults<InstaDataItem> friends= Realm.getDefaultInstance().where(InstaDataItem.class).findAll();
//                        // FriendsResponse friendsResponse=new Gson().fromJson(response.getRawResponse(),FriendsResponse.class);
//                        FriendsListAdapter adapter=new FriendsListAdapter(getActivity(),(friends));
//                        listFriends.setAdapter(adapter);

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
}
