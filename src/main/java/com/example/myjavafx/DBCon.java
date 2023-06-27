package com.example.myjavafx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBCon {
    private static String jdbc = "jdbc:mysql://localhost:3306/java";
    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(jdbc, "tarkhna", "password");
    }

}
