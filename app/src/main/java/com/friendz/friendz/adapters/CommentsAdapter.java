package com.friendz.friendz.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.friendz.friendz.R;
import com.friendz.friendz.db.FbCommentsData;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by dineshkumarbalasubramanian on 18/07/17.
 */

public class CommentsAdapter extends BaseAdapter {
    Context mContext;
    private List<FbCommentsData> commentsDatas = new ArrayList<>();
    LayoutInflater inflater;

    public CommentsAdapter(Context mContext, List<FbCommentsData> commentsDatas) {
        this.mContext = mContext;
        this.commentsDatas = commentsDatas;
        inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return commentsDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return commentsDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.fragment_comment_dialog, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.txtMessage.setText(commentsDatas.get(position).getMessage());
        holder.txtName.setText(commentsDatas.get(position).getFrom().getName());
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.txtName)
        TextView txtName;
        @BindView(R.id.txtMessage)
        TextView txtMessage;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
