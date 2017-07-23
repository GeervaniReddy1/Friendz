package com.friendz.friendz.reciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;

public class EventNotifcationReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        System.out.println("Hey i recieved the message ");
        Bundle bundle =new  Bundle();
        bundle.putString("message","My first test post in fb "+intent.getExtras().getString("Name"));
        new GraphRequest(
                AccessToken.getCurrentAccessToken(),
                "/me/feed",
                bundle,
                HttpMethod.POST,
                new GraphRequest.Callback() {
                    @Override
                    public void onCompleted(GraphResponse response) {
                        System.out.println("Posted Resp: "+response);
                    }
                }).executeAsync();
    }
}
