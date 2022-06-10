package com.informatica.unistmo.instagramapi.retrofitconfig;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InstagramResource {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("media_type")
    @Expose
    private String mediaType;
    @SerializedName("media_url")
    @Expose
    private String mediaUrl;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("timestamp")
    @Expose
    private String timestamp;

    public InstagramResource(String id, String username, String timestamp){
        this.id = id;
        this.username = username;
        this.timestamp = timestamp;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getMediaUrl() {
        return mediaUrl;
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
