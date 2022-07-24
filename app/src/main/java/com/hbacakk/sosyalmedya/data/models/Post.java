package com.hbacakk.sosyalmedya.data.models;

public class Post {
    public int imageId;
    public int postId;
    public String userName;
    public String time;
    public String like;
    public String message;
    public String post;

    public Post(int imageId) {
        this.imageId = imageId;
    }

    public Post(int imageId, int postId, String userName, String time, String like, String message, String post) {
        this.postId = postId;
        this.imageId = imageId;
        this.userName = userName;
        this.time = time;
        this.like = like;
        this.message = message;
        this.post = post;
    }

}
