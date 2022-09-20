/*
 * Author Name: Aditya Chaurasia
 * Date: 20-09-2022
 * Created With: IntelliJ IDEA Community Edition
 * Profile: github.com/ChaurasiaAditya
 */
package com.niit.jdp.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseService {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String URL = "jdbc:mysql://localhost:3306/jukebox";
    private Connection connection;

    public DatabaseService() {
        this.connection = null;
    }

    public Connection getConnection() {
        return connection;
    }

    public boolean connect() throws SQLException {
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        return connection != null;
    }
    public void printConnectionStatus(){
        if (connection != null) {
            System.out.println("Connected to the database");
        } else {
            System.out.println("Failed to make connection!");
        }
    }
}
