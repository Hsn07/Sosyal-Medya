package com.hbacakk.sosyalmedya.data.models;

public class Message {
    String userID;
    String message;

    public Message(String userID, String message) {
        this.userID = userID;
        this.message = message;
    }

    public String getUserID() {
        return userID;
    }

    public String getMessage() {
        return message;
    }
}
