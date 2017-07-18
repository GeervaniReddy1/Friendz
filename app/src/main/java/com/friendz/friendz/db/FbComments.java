package com.friendz.friendz.db;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by dineshkumarbalasubramanian on 18/07/17.
 */

public class FbComments extends RealmObject{
private RealmList<FbCommentsData> data;

    public RealmList<FbCommentsData> getData() {
        return data;
    }

    public void setData(RealmList<FbCommentsData> data) {
        this.data = data;
    }
}
