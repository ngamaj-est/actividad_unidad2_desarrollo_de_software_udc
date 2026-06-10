package com.example.unicartagena.cea14.infrastructure.config;

import java.io.InputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public final class DatabaseConfig {
    private static final Properties PROPS = new Properties();

    static {
        try (InputStream in = DatabaseConfig.class.getClassLoader().getResourceAsStream("application.properties")) {
            if (in != null) {
                PROPS.load(in);
            }
        } catch (IOException e) {
            throw new ExceptionInInitializerError("Failed to load application.properties: " + e.getMessage());
        }
    }

    private DatabaseConfig() {}

    public static Connection getConnection() throws SQLException {
        String driver = PROPS.getProperty("db.driver", "com.mysql.cj.jdbc.Driver");
        String url = PROPS.getProperty("db.url", "jdbc:mysql://localhost:3306/zoologico_db?useSSL=false&serverTimezone=UTC");
        String user = PROPS.getProperty("db.username", "root");
        String pass = PROPS.getProperty("db.password", "");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new SQLException("JDBC Driver not found: " + driver, e);
        }
        return DriverManager.getConnection(url, user, pass);
    }
}
