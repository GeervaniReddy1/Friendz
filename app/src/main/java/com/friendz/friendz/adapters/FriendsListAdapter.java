package com.friendz.friendz.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.friendz.friendz.R;
import com.friendz.friendz.model.DataItem;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by dineshkumarbalasubramanian on 14/06/17.
 */

public class FriendsListAdapter extends BaseAdapter {
    Context mContext;
    List<DataItem> friends = new ArrayList<>();
    LayoutInflater inflater;

    public FriendsListAdapter(Context mContext, List<DataItem> friends) {
        this.mContext = mContext;
        this.friends = friends;
        inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return friends.size();
    }

    @Override
    public Object getItem(int position) {
        return friends.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.friends_list_item, null);
            holder=new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
        DataItem item=friends.get(position);
        Picasso.with(mContext).load(item.getPicture().getData().getUrl()).into(holder.imgFriends);
        holder.txtFriendsName.setText(item.getName());
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.chkFriends)
        CheckBox chkFriends;
        @BindView(R.id.imgFriends)
        ImageView imgFriends;
        @BindView(R.id.txtFriendsName)
        TextView txtFriendsName;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
