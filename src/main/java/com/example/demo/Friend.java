package com.example.demo;

public class Friend {
    private String userUsn;
    private String friendUsn;

    private boolean isFollowing;

    public Friend(String username, String friendUsn, boolean isFollowing)
    {
        userUsn = username;
        this.friendUsn = friendUsn;
        this.isFollowing = isFollowing;
    }

    public String getUserUsn()
    {
        return userUsn;
    }

    public String getFriendUsn()
    {
        return friendUsn;
    }

    public boolean getIsFollowing()
    {
        return isFollowing;
    }
}
