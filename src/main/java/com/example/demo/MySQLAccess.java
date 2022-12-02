package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class MySQLAccess {
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public Connection connectdb() throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/?" + "user=root&password=8p4e2arL!");

            return connect;
        	/*
        	statement = connect.createStatement();
        	resultSet = statement.executeQuery("SELECT Friend_Usn FROM Music_App.Following");
        	while (resultSet.next()) {
        		// retrieve and print the values for the current row
        		String usn = resultSet.getString("Friend_Usn");
        		System.out.println("FRIEND USN = " + usn);

        	} */

        }
        catch (Exception e)
        {
            throw e;
        }

    }
}
