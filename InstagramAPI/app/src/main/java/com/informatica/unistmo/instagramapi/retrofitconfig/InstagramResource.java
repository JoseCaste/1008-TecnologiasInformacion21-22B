package com.informatica.unistmo.instagramapi.retrofitconfig;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InstagramResource {
    private String media_url;
    private String userName;
    private String timestamp;

    public InstagramResource(String media_url, String userName, String timestamp){
        this.media_url = media_url;
        this.userName = userName;
        this.timestamp = timestamp;
    }

    public String getMedia_url() {
        return media_url;
    }

    public void setMedia_url(String media_url) {
        this.media_url = media_url;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
