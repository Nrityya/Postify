package com.example.demo;

public class LoginRequestBody {
    private String usn;
    private String pw;

    public LoginRequestBody(String username, String password){
        usn = username;
        pw = password;
    }

    public String getUsn()
    {
        return usn;
    }

    public String getPw()
    {
        return pw;
    }
}
