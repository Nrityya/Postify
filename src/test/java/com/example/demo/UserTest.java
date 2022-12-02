package com.example.demo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserTest {
    User x;

    @BeforeEach
    void setUp() throws Exception {
        x = new User();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void register_TC1() throws SQLException {
        //all values valid
        assertEquals( x.register("shailirm", "1234"), "Login Successful");
    }

    @Test
    public void register_TC2() throws SQLException {
        //wrong password
        assertEquals( x.register("shailirm", "6463"), "Incorrect Password");
    }

    @Test
    public void register_TC3() throws SQLException {
        //username doesn't exist
        assertEquals( x.register("daisyb", "6463"), "Username does not exist!");
    }

    @Test
    void check_TC1() throws SQLException {
        //username exists
        assertTrue(x.checkUsernameExisting("shailirm"));
    }

    @Test
    void check_TC2() throws SQLException {
        // Username does not exist
        assertFalse(x.checkUsernameExisting("utdstudent"));
    }

    @Test
    void search_TC1() throws SQLException {
        //search for friends
        List<SearchFriendResponse> sfr = new ArrayList<SearchFriendResponse>();
        sfr.add(new SearchFriendResponse("shailirm"));
        sfr.add(new SearchFriendResponse("shreyam"));
        assertEquals(sfr.get(0).getUsername(), x.searchFriend("sh").get(0).getUsername());
        assertEquals(sfr.get(1).getUsername(), x.searchFriend("sh").get(1).getUsername());
    }

    @Test
    void feed_TC1() throws SQLException {
        //search for friends
        List<Post> p = new ArrayList<Post>();
        p.add(new Post("aratib", "09863"));
        p.add(new Post("nrityya", "42485"));
        p.add(new Post("shailirm", "3XYRV7ZSHqIRDG87DKTtry"));

        assertEquals(p.get(0).getPostUsn(), x.getFeed("shreyam").get(0).getPostUsn());
        assertEquals(p.get(1).getPostUsn(), x.getFeed("shreyam").get(1).getPostUsn());
    }

}
