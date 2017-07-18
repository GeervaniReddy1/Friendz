package com.friendz.friendz.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.friendz.friendz.R;
import com.friendz.friendz.db.EventsDataItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EventsAdapter extends BaseAdapter {

    Context mContext;
    List<EventsDataItem> events = new ArrayList<>();
    LayoutInflater inflater;

    public EventsAdapter(Context mContext,List<EventsDataItem> events) {
        this.mContext = mContext;
        this.events = events;
        inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {

        return events.size();
    }

    @Override
    public Object getItem(int position) {

        return events.get(position);
    }

    @Override
    public long getItemId(int position) {

        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.events_items, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        EventsDataItem item = events.get(position);

//        switch (item.getType()) {
//            case "photo":
//                Picasso.with(mContext).load(item.getPicture()).into(holder.imgEvent);
//                break;
//        }
        holder.txtEventName.setText(item.getName());
        holder.txtEventTime.setText(item.getStartTime());
        holder.txtEventDesc.setText(item.getDescription());

        return convertView;
    }


    static class ViewHolder {
        @BindView(R.id.imgEvent)
        ImageView imgEvent;
        @BindView(R.id.txtEventName)
        TextView txtEventName;
        @BindView(R.id.txtEventTime)
        TextView txtEventTime;
        @BindView(R.id.txtEventDesc)
        TextView txtEventDesc;


        ViewHolder(View view) {

            ButterKnife.bind(this, view);
        }
    }

}
