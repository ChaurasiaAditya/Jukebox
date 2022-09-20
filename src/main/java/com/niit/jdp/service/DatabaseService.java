/*
 * Author Name: Aditya Chaurasia
 * Date: 20-09-2022
 * Created With: IntelliJ IDEA Community Edition
 * Profile: github.com/ChaurasiaAditya
 */
package com.niit.jdp.service;

import java.sql.Connection;

public class DatabaseService {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String URL = "";
    private Connection connection;

    public DatabaseService() {
        this.connection = null;
    }
}
