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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

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
                "782489875094649/friends?fields=id,name&limit=100",
                null,
                HttpMethod.GET,
                new GraphRequest.Callback() {
                    public void onCompleted(GraphResponse response) {
            /* handle the result */
                        FriendsResponse friendsResponse=new Gson().fromJson(response.getRawResponse(),FriendsResponse.class);
                        FriendsListAdapter adapter=new FriendsListAdapter(getActivity(),friendsResponse.getData());
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
}
