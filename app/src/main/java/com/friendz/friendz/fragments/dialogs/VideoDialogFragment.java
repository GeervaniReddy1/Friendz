package com.friendz.friendz.fragments.dialogs;


import android.app.Dialog;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.devbrackets.android.exomedia.listener.OnPreparedListener;
import com.devbrackets.android.exomedia.ui.widget.VideoView;
import com.friendz.friendz.R;
import com.friendz.friendz.db.PostsDataItem;
import com.friendz.friendz.util.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.realm.Realm;

/**
 * A simple {@link Fragment} subclass.
 */
public class VideoDialogFragment extends DialogFragment {


    @BindView(R.id.video_view)
    VideoView videoView;
    Unbinder unbinder;
    String postId;
    public VideoDialogFragment() {
        // Required empty public constructor
    }
    @Override
    public void onStart()
    {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null)
        {
            int width = ViewGroup.LayoutParams.MATCH_PARENT;
            int height = ViewGroup.LayoutParams.MATCH_PARENT;
            dialog.getWindow().setLayout(width, height);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_video_dialog, container, false);
        unbinder = ButterKnife.bind(this, view);
        postId = getArguments().getString(Constants.POST_ID);
        PostsDataItem item = Realm.getDefaultInstance().where(PostsDataItem.class).equalTo("id", postId).findFirst();
        videoView.setVideoURI(Uri.parse(item.getSource()));
        videoView.setOnPreparedListener(new OnPreparedListener() {
            @Override
            public void onPrepared() {
                    videoView.start();
            }

        });
        return view;
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        videoView.reset();
        super.onDismiss(dialog);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
