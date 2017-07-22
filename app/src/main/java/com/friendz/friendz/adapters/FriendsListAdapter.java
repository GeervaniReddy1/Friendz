package com.friendz.friendz.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.friendz.friendz.R;
import com.friendz.friendz.db.FriendsListDataItem;
import com.friendz.friendz.model.DataItem;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;

/**
 * Created by dineshkumarbalasubramanian on 14/06/17.
 */

public class FriendsListAdapter extends BaseAdapter {
    Context mContext;
    List<FriendsListDataItem> friends = new ArrayList<>();
    LayoutInflater inflater;

    public FriendsListAdapter(Context mContext, List<FriendsListDataItem> friends) {
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
        final FriendsListDataItem item=friends.get(position);
        Picasso.with(mContext).load(item.getPicture().getData().getUrl()).into(holder.imgFriends);
        holder.txtFriendsName.setText(item.getName());
        holder.chkFriends.setTag(item.getId());
        holder.chkFriends.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(final CompoundButton buttonView, final boolean isChecked) {
             Realm realm=Realm.getDefaultInstance();
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        realm .where(FriendsListDataItem.class).equalTo("id", (String) buttonView.getTag()).findFirst().setCloseFriend(isChecked);

                    }
                });

            }
        });
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
