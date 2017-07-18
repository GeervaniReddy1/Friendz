package com.friendz.friendz.fragments.dialogs;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
public class CommentDialogFragment extends DialogFragment {


    @BindView(R.id.txtName)
    TextView txtName;
    @BindView(R.id.txtMessage)
    TextView txtMessage;
    Unbinder unbinder;

    public CommentDialogFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_comment, container, false);
        String postId=getArguments().getString(Constants.POST_ID);
        PostsDataItem item=Realm.getDefaultInstance().where(PostsDataItem.class).equalTo("id",postId).findFirst();
        item.getComments().getData();
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
