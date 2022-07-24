package com.hbacakk.sosyalmedya.data.models;

import java.io.Serializable;

public class User implements Serializable {
    public int imageId;
    String userName;
    String lastMessage;

    public User(int imageId, String userName, String lastMessage) {
        this.imageId = imageId;
        this.userName = userName;
        this.lastMessage = lastMessage;
    }

    public int getImageId() {
        return imageId;
    }

    public String getUserName() {
        return userName;
    }

    public String getLastMessage() {
        return lastMessage;
    }
}
