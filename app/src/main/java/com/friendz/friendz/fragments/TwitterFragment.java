package com.friendz.friendz.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.friendz.friendz.R;
import com.twitter.sdk.android.tweetui.TweetTimelineListAdapter;
import com.twitter.sdk.android.tweetui.UserTimeline;

/**
 * A simple {@link Fragment} subclass.
 */
public class TwitterFragment extends ListFragment {


    public TwitterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Runnable runnable = new Runnable() {
            public void run() {
                final UserTimeline userTimeline = new UserTimeline.Builder()
                        .screenName("dinesh88_b")
                        .build();
                final TweetTimelineListAdapter adapter = new TweetTimelineListAdapter.Builder(getActivity())
                        .setTimeline(userTimeline)
                        .build();
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        setListAdapter(adapter);

                    }
                });

            }
        };
        new Thread(runnable).start();
        return inflater.inflate(R.layout.fragment_twitter, container, false);
    }

}
