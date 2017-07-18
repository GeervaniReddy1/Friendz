package com.friendz.friendz.adapters;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.devbrackets.android.exomedia.listener.OnPreparedListener;
import com.devbrackets.android.exomedia.ui.widget.VideoView;
import com.friendz.friendz.R;
import com.friendz.friendz.db.PostsDataItem;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
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
        PostsDataItem item = dataItems.get(position);
//        item.getType()
        switch (item.getType()) {
            case "photo":
                Picasso.with(mContext).load(item.getPicture()).into(holder.imgFeed);
                holder.videoView.setVisibility(View.GONE);
                holder.imgFeed.setVisibility(View.VISIBLE);
                break;
            case "video":
                holder.imgFeed.setVisibility(View.GONE);
                holder.videoView.setVisibility(View.VISIBLE);
                final ViewHolder finalHolder = holder;
                holder.videoView.setOnPreparedListener(new OnPreparedListener() {
                    @Override
                    public void onPrepared() {
                        finalHolder.videoView.start();
                    }
                });

                //For now we just picked an arbitrary item to play
                holder.videoView.setVideoURI(Uri.parse(item.getSource()));


        }
        holder.txtDesc.setText(item.getName());
        if (item.getLikes() != null)
            holder.txtLike.setText(item.getLikes().getData().size() + " likes");
        if(item.getComments()!=null){
            holder.txtComments.setText(item.getComments().getData().size()+" Comments");

        }
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
        @BindView(R.id.video_view)
        VideoView videoView;
        @BindView(R.id.txtComments)
        TextView txtComments;
        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
