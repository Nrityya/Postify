package com.example.demo;

import javax.swing.tree.RowMapper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;


public class User {
    private Connection dbconn;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;



    public User() throws Exception
    {
        MySQLAccess db = new MySQLAccess();
        dbconn = db.connectdb();
    }


    public boolean checkUsernameExisting(String name) throws SQLException {
        preparedStatement = (dbconn).prepareStatement("SELECT Username FROM Music_App.User WHERE EXISTS (SELECT Username FROM Music_App.User WHERE Username=?)");
        preparedStatement.setString(1, name);
        resultSet = preparedStatement.executeQuery();
        if (!resultSet.isBeforeFirst()) {
            return false;
        } else {
            return true;
        }
    }

    public List<SearchFriendResponse> searchFriend(String name) throws SQLException {
        preparedStatement = (dbconn).prepareStatement("SELECT Username FROM Music_App.User WHERE Username LIKE ?");
        preparedStatement.setString(1, "%" + name + "%");
        resultSet = preparedStatement.executeQuery();
        List<SearchFriendResponse> list = new ArrayList<>();

        if (!resultSet.isBeforeFirst()) {
            return list;
        } else {
            while (resultSet.next())
            {
                list.add( new SearchFriendResponse(resultSet.getString(1)));
            }
        }
    return list;

    }

    public boolean follow(String userUsn, String friendUsn, boolean isFollowing) throws SQLException {
        //if user wants to follow friend
        if (!isFollowing)
        {
            preparedStatement = (dbconn).prepareStatement("INSERT INTO Music_App.Following (User_Usn, Friend_Usn) VALUES (?, ?);");
            preparedStatement.setString(1, userUsn);
            preparedStatement.setString(2, friendUsn);
            preparedStatement.executeUpdate();
            return true;
        }
        // else if user wants to unfollow friend
        else {
            preparedStatement = (dbconn).prepareStatement("DELETE FROM Music_App.Following WHERE User_Usn = ? AND Friend_Usn = ?");
            preparedStatement.setString(1, userUsn);
            preparedStatement.setString(2, friendUsn);
            preparedStatement.executeUpdate();
            return true;
        }
    }

    public boolean verifyLogin(String usn, String pw) throws SQLException
    {
        preparedStatement = (dbconn).prepareStatement("SELECT Password FROM Music_App.User WHERE Username=?");
        preparedStatement.setString(1, usn);
        resultSet = preparedStatement.executeQuery();
        if(!resultSet.isBeforeFirst())
        {
            return false;
        }
        resultSet.next();
        String password = resultSet.getString("Password");
        if (password.equals(pw))
        {
            return true;
        }
        return false;

    }

    public String register(String argUserName, String argPwd1) throws SQLException
    {
        if( !checkUsernameExisting( argUserName ) ) {
            return "Username does not exist!";
        }
        if(verifyLogin(argUserName, argPwd1))
        {
            return "Login Successful";
        }
        else
        {
            return "Incorrect Password";
        }
    }

    public void createPost(String usn, String songID) throws SQLException {
        preparedStatement = (dbconn).prepareStatement("INSERT INTO Music_App.Posts (Post_Usn, Song_Title) VALUES (?, ?);");
        preparedStatement.setString(1, usn);
        preparedStatement.setString(2, songID);
        preparedStatement.executeUpdate();
    }

    public List<Post> getFeed(String usn) throws SQLException {
        List<Post> list = new ArrayList<>();
        preparedStatement = (dbconn).prepareStatement("Select * From Music_App.Posts Where Post_Usn in (SELECT Friend_Usn From Music_App.Following WHERE User_Usn = ?);");
        preparedStatement.setString(1, usn);
        resultSet = preparedStatement.executeQuery();
        if (!resultSet.isBeforeFirst()) {
            return list;
        } else {
            while (resultSet.next())
            {
                Post p = new Post(resultSet.getString(1), resultSet.getString(2));
                list.add(p);
            }
        }
        return list;
    }
}
