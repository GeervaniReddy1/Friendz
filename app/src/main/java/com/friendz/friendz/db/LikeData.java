package com.friendz.friendz.db;

import io.realm.RealmObject;

/**
 * Created by dineshkumarbalasubramanian on 18/07/17.
 */

public class LikeData extends RealmObject{

    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
