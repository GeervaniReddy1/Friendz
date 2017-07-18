package com.friendz.friendz.db;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by dineshkumarbalasubramanian on 18/07/17.
 */

public class FbLikes extends RealmObject{

    private RealmList<LikeData> data;

    public RealmList<LikeData> getData() {
        return data;
    }

    public void setData(RealmList<LikeData> data) {
        this.data = data;
    }
}
