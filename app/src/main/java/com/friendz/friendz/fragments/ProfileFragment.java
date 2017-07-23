package com.friendz.friendz.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.friendz.friendz.R;
import com.friendz.friendz.db.ProfileData;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import io.realm.Realm;
import io.realm.RealmResults;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {
    //@BindView(R.id.listname)
    //ListView names;
    Unbinder unbinder;
    @BindView(R.id.profileimage)
    ImageView profileimage;
    @BindView(R.id.editimage)
    ImageView editimage;
    @BindView(R.id.navimage)
    ImageView navimage;
    @BindView(R.id.Firstname)
    TextView Firstname;
    @BindView(R.id.inputFirstname)
    EditText inputFirstname;
    @BindView(R.id.Lastname)
    TextView Lastname;
    @BindView(R.id.inputlastname)
    EditText inputlastname;
    @BindView(R.id.Location)
    TextView Location;
    @BindView(R.id.inputLocation)
    EditText inputLocation;
    @BindView(R.id.Username)
    TextView Username;
    @BindView(R.id.inputUsername)
    EditText inputUsername;


    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        unbinder = ButterKnife.bind(this, view);
        // return inflater.inflate(R.layout.fragment_profile, container, false);
        new GraphRequest(
                AccessToken.getCurrentAccessToken(),
                "me?fields=id,first_name,last_name",
                null,
                HttpMethod.GET,
                new GraphRequest.Callback() {
                    public void onCompleted(final GraphResponse response) {
            /* handle the result */
                        System.out.println(response);
//                        String data = new String();
//                        try {
//                            JSONObject jsonObject = new JSONObject(response.getRawResponse());
//                            data = jsonObject.getJSONObject("first_name").toString();
//
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                        final String finalData=data;


                        Realm.getDefaultInstance().executeTransaction(new Realm.Transaction() {
                            @Override
                            public void execute(Realm realm) {

                               // realm.createObjectFromJson(ProfileData.class,);
                               realm.createOrUpdateObjectFromJson(ProfileData.class,response.getRawResponse());

                            }
                        });
                       ProfileData dataItems = Realm.getDefaultInstance().where(ProfileData.class).findFirst();
                       // ProfileData dataItems =new Gson().fromJson(response.getRawResponse(), ProfileData.class);
                       // inputlastname.setText(dataItems.getLastName());
                        inputFirstname.setText(dataItems.getFirstName());

                    }
                }
        ).executeAsync();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }



    }

