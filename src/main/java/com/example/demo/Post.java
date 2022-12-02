package com.example.demo;

public class Post {
    private String postUsn;
    private String songId;

    public Post(String username, String songId)
    {
        postUsn = username;
        this.songId = songId;
    }

    public String getPostUsn()
    {
        return postUsn;
    }

    public String getSongId()
    {
        return songId;
    }
}
