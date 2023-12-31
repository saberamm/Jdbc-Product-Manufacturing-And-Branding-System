package com.Investment_system.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {
    private static Connection connection = null;


    public Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(DBConfig.URL, DBConfig.USER_NAME, DBConfig.PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
