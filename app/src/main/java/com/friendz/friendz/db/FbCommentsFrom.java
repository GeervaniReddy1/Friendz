package com.friendz.friendz.db;

import io.realm.RealmObject;

/**
 * Created by dineshkumarbalasubramanian on 18/07/17.
 */

public class FbCommentsFrom extends RealmObject {
    private String name;
    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
