package com.friendz.friendz.db;

import io.realm.RealmObject;

/**
 * Created by dineshkumarbalasubramanian on 19/07/17.
 */

public class FriendsPictureData extends RealmObject{
    private boolean is_silhouette;
    private String url;

    public boolean is_silhouette() {
        return is_silhouette;
    }

    public void setIs_silhouette(boolean is_silhouette) {
        this.is_silhouette = is_silhouette;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
