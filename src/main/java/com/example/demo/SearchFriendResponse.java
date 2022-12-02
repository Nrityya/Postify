package com.example.demo;

public class SearchFriendResponse {
    private String username;

    public SearchFriendResponse(String username) {
        this.username = username;
    }
    public SearchFriendResponse() {
        this.username = "";
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
