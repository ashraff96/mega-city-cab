package com.megacity.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/megacitycabdb";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Ashraff@123$";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("MySQL JDBC Driver not found!", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
}
