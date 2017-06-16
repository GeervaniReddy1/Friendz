package com.friendz.friendz.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.friendz.friendz.R;
import com.friendz.friendz.model.DataItem;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static java.lang.String.*;

/**
 * Created by dineshkumarbalasubramanian on 12/06/17.
 */

public class FeedAdapter extends BaseAdapter {
    enum type {
        link(), status, photo, video, offer
    }

    Context mContext;
    List<DataItem> dataItems = new ArrayList<>();
    LayoutInflater inflater;

    public FeedAdapter(Context mContext, List<DataItem> dataItems) {
        this.mContext = mContext;
        this.dataItems = dataItems;
        inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return dataItems.size();
    }

    @Override
    public Object getItem(int position) {
        return dataItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
//        if (convertView == null) {
//            convertView = inflater.inflate(R.layout.feed_view, null);
//            holder = new ViewHolder(convertView);
//            convertView.setTag(holder);
//        } else {
//            holder = (ViewHolder) convertView.getTag();
//        }
//        PostsDataItem item = dataItems.get(position);
////        item.getType()
//        switch (item.getType()) {
//            case "photo":
//                Picasso.with(mContext).load(item.getPicture()).into(holder.imgFeed);
//                break;
//        }
//        holder.txtDesc.setText(item.getType());
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.imgFeed)
        ImageView imgFeed;
        @BindView(R.id.txtLike)
        TextView txtLike;
        @BindView(R.id.txtShare)
        TextView txtShare;
        @BindView(R.id.txtDesc)
        TextView txtDesc;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
