package com.friendz.friendz.db;

import io.realm.RealmObject;

/**
 * Created by dineshkumarbalasubramanian on 19/07/17.
 */

public class FriendsPicture extends RealmObject {
    private FriendsPictureData data;

    public FriendsPictureData getData() {
        return data;
    }

    public void setData(FriendsPictureData data) {
        this.data = data;
    }
}
