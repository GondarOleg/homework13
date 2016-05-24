package com.epam.dao;

/**
 * Created by Oleg on 24.05.2016.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionManager {

    private Connection connection;

    public DBConnectionManager(String dbURL, String user, String pwd) throws ClassNotFoundException, SQLException{
        Class.forName("org.h2.Driver");
        this.connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "password");
    }

    public Connection getConnection(){
        return this.connection;
    }
}