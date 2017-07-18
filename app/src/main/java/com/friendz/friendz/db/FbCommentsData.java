package com.friendz.friendz.db;

import io.realm.RealmObject;

/**
 * Created by dineshkumarbalasubramanian on 18/07/17.
 */

public class FbCommentsData  extends RealmObject{
    private String created_time;
    private String id;
    private String message;
    private FbCommentsFrom from;

    public String getCreated_time() {
        return created_time;
    }

    public void setCreated_time(String created_time) {
        this.created_time = created_time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public FbCommentsFrom getFrom() {
        return from;
    }

    public void setFrom(FbCommentsFrom from) {
        this.from = from;
    }
}
