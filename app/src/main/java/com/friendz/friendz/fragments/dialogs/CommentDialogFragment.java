package com.friendz.friendz.fragments.dialogs;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.friendz.friendz.R;
import com.friendz.friendz.adapters.CommentsAdapter;
import com.friendz.friendz.db.PostsDataItem;
import com.friendz.friendz.util.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import io.realm.Realm;

/**
 * A simple {@link Fragment} subclass.
 */
public class CommentDialogFragment extends DialogFragment {


    Unbinder unbinder;
    @BindView(R.id.listComments)
    ListView listComments;
    @BindView(R.id.txtComments)
    EditText txtComments;
    @BindView(R.id.btnComment)
    Button btnComment;
    String postId;
    @BindView(R.id.txtLikes)
    TextView txtLikes;

    public CommentDialogFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_comment, container, false);
        unbinder = ButterKnife.bind(this, view);
        postId = getArguments().getString(Constants.POST_ID);
        PostsDataItem item = Realm.getDefaultInstance().where(PostsDataItem.class).equalTo("id", postId).findFirst();
        txtLikes.setTextColor(Color.BLUE);
        if (item.getLikes() != null)
            txtLikes.setText(item.getLikes().getData().get(0).getName() + " and " + (item.getLikes().getData().size() - 1) + " liked");
        if (item.getComments() != null) {
            CommentsAdapter adapter = new CommentsAdapter(getActivity(), item.getComments().getData());
            listComments.setAdapter(adapter);
        }

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.btnComment)
    public void onViewClicked() {
        if (!txtComments.getText().toString().trim().isEmpty()) {
            postComment();
        }
    }

    private void postComment() {
        Bundle params = new Bundle();
        params.putString("message", txtComments.getText().toString());
/* make the API call */
        new GraphRequest(
                AccessToken.getCurrentAccessToken(),
                "/" + postId + "/comments",
                params,
                HttpMethod.POST,
                new GraphRequest.Callback() {
                    public void onCompleted(GraphResponse response) {
        /* handle the result */
                        dismiss();
                    }
                }
        ).executeAsync();
    }
}
