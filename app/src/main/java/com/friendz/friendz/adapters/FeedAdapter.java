package com.friendz.friendz.adapters;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.friendz.friendz.HomeActivity;
import com.friendz.friendz.R;
import com.friendz.friendz.db.PostsDataItem;
import com.friendz.friendz.fragments.dialogs.CommentDialogFragment;
import com.friendz.friendz.fragments.dialogs.VideoDialogFragment;
import com.friendz.friendz.util.Constants;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.RealmResults;

/**
 * Created by dineshkumarbalasubramanian on 12/06/17.
 */

public class FeedAdapter extends BaseAdapter {






    enum type {
        link(), status, photo, video, offer
    }

    Context mContext;
    List<PostsDataItem> dataItems = new ArrayList<>();
    LayoutInflater inflater;

    public FeedAdapter(Context mContext, RealmResults<PostsDataItem> dataItems) {
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
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.feed_view, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        final PostsDataItem item = dataItems.get(position);

        holder.imgFeed.setVisibility(View.GONE);
//        item.getType()
        holder.imgFeed.setTag(item.getId());
        holder.imgFeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playVideo(v);

            }
        });
holder.imgPlay.setVisibility(View.GONE);
        switch (item.getType()) {
            case "video":
                holder.imgPlay.setVisibility(View.VISIBLE);
            case "photo":
            case "link":
                Picasso.with(mContext).load(item.getPicture()).into(holder.imgFeed);
                holder.imgFeed.setVisibility(View.VISIBLE);
                break;


        }
        holder.txtDesc.setText(item.getName());
        holder.txtLike.setTag(item.getId());
        if (item.getLikes() != null)
            holder.txtLike.setText(item.getLikes().getData().size() + " likes");
        holder.txtComments.setTag(item.getId());
        if (item.getComments() != null) {
            holder.txtComments.setText(item.getComments().getData().size() + " Comments");

        }
        holder.txtComments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCommentsDialog(v);
            }
        });
        holder.txtLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Realm.getDefaultInstance().where(PostsDataItem.class).
//                if(item.getLikes().getData())
                showCommentsDialog(v);
            }
        });
        return convertView;
    }

    private void playVideo(View v) {
        VideoDialogFragment videoDialogFragment = new VideoDialogFragment();
        Bundle b = new Bundle();
        b.putString(Constants.POST_ID, (String) v.getTag());
        videoDialogFragment.setArguments(b);
        videoDialogFragment.show(((HomeActivity) mContext).getSupportFragmentManager(), "Video");
    }


    private void showCommentsDialog(View v) {
        CommentDialogFragment commentDialogFragment = new CommentDialogFragment();
        Bundle b = new Bundle();
        b.putString(Constants.POST_ID, (String) v.getTag());
        commentDialogFragment.setArguments(b);
        commentDialogFragment.show(((HomeActivity) mContext).getSupportFragmentManager(), "Comments");
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
        @BindView(R.id.imgPlay)
        ImageView imgPlay;
        @BindView(R.id.txtComments)
        TextView txtComments;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
