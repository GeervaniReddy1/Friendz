package com.friendz.friendz.reciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class EventNotifcationReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        System.out.println("Hey i recieved the message "+intent.getExtras().getString("Name"));

    }
}
