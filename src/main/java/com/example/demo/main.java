package com.example.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.sql.SQLException;

public class main {

    public static void main(String[] args) throws Exception, SQLException
    {
        Connection dbconn;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
    User x = new User();
    List<Post> p;
    p = x.getFeed("shreyam");
    for (Post post: p)
    {
        System.out.println(post.getPostUsn() + " " + post.getSongId());
    }

    }
}
