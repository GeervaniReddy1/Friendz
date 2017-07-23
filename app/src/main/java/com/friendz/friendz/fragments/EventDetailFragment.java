package com.friendz.friendz.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.friendz.friendz.R;
import com.friendz.friendz.db.EventsDataItem;
import com.friendz.friendz.util.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.realm.Realm;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventDetailFragment extends Fragment {


    @BindView(R.id.imgEvent)
    ImageView imgEvent;
    @BindView(R.id.txtEventName)
    TextView txtEventName;
    @BindView(R.id.txtEventTime)
    TextView txtEventTime;
    @BindView(R.id.txtEventDesc)
    TextView txtEventDesc;
    Unbinder unbinder;

    public EventDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_event_detail, container, false);
       String eventId= getArguments().getString(Constants.EVENT_ID);
        unbinder = ButterKnife.bind(this, view);
        EventsDataItem eventsDataItem= Realm.getDefaultInstance().where(EventsDataItem.class).equalTo("id",eventId).findFirst();
        txtEventName.setText(eventsDataItem.getName());
        txtEventDesc.setText(eventsDataItem.getDescription());
        txtEventTime.setText(eventsDataItem.getStartTime().toString());
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
