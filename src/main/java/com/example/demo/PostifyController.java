package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@CrossOrigin(maxAge = 3600)
//@CrossOrigin("http://localhost:5500/")
@RestController
public class PostifyController {
    @GetMapping("/")
    public String index() {

        return "Greetings from Spring Boot!";
    }

    @PostMapping(path = "/login")
    public LoginResponse verifyLogin(@RequestBody LoginRequestBody newLogin) throws Exception{
        //Login l = new Login();
        User x = new User();
        return new LoginResponse(x.register(newLogin.getUsn(), newLogin.getPw()));
    }

    @GetMapping("/search")
    public List<SearchFriendResponse> searchFriend(@RequestParam("username") String username) throws Exception {
        User x = new User();
        return x.searchFriend(username);
    }

    @PostMapping(path = "/follow")
    public void followFriend(@RequestBody Friend newFriend) throws Exception, SQLException{
        User x = new User();
        x.follow(newFriend.getUserUsn(), newFriend.getFriendUsn(), newFriend.getIsFollowing());
    }

    @PostMapping(path = "/post")
    public void createPost(@RequestBody Post newPost) throws Exception, SQLException{
        User x = new User();
        x.createPost(newPost.getPostUsn(), newPost.getSongId());

    }

    @GetMapping(path = "/feed")
    public List<Post> retrieveFeed(@RequestParam("username") String username) throws Exception, SQLException
    {
        User x = new User();
        return x.getFeed(username);
    }

}
