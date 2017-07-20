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
import com.friendz.friendz.R;
import com.friendz.friendz.adapters.EventsAdapter;
import com.friendz.friendz.db.EventsDataItem;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;
import butterknife.Unbinder;
import io.realm.Realm;
import io.realm.RealmResults;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventsFragment extends Fragment {
    @BindView(R.id.listEvents)
    ListView listEvents;
    Unbinder unbinder;


    public EventsFragment() {
        // Required empty public constructor
    }

    String queries="id,name,place,start_time,end_time,description,rsvp_status";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_events, container, false);
        unbinder = ButterKnife.bind(this, view);
        new GraphRequest(
                AccessToken.getCurrentAccessToken(),
                        "me/events?fields=" + queries,
                        null,
                        HttpMethod.GET,
                new GraphRequest.Callback() {
                    public void onCompleted(GraphResponse response) {
                        System.out.println(response);
                        String data=new String();
                        try{
                            JSONObject jsonObject=new JSONObject(response.getRawResponse());
                            data=jsonObject.getJSONArray("data").toString();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        final String finalData=data;

                        Realm.getDefaultInstance().executeTransaction(new Realm.Transaction() {
                            @Override
                            public void execute(Realm realm) {

                                realm.createOrUpdateAllFromJson(EventsDataItem.class,finalData);
                                //realm.createObjectFromJson(FriendsResponse.class,response.getRawResponse());

                            }
                        });
            /* handle the result */
                        RealmResults<EventsDataItem> dataItems = Realm.getDefaultInstance().where(EventsDataItem.class).findAll();
//                        FriendsResponse friendsResponse=new Gson().fromJson(response.getRawResponse(),FriendsResponse.class);
                        EventsAdapter adapter = new EventsAdapter(getActivity(), (dataItems));
                        listEvents.setAdapter(adapter);


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
    @OnItemClick(R.id.listEvents)
    public void onItemClicked() {
    }
}

