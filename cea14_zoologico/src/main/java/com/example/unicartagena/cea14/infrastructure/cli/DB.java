package com.example.unicartagena.cea14.infrastructure.cli;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DB {
    private static final String PROPS = "/application.properties";

    public static Connection getConnection() throws SQLException {
        Properties props = new Properties();
        try (InputStream is = DB.class.getResourceAsStream(PROPS)) {
            if (is == null) throw new IOException("application.properties not found on classpath");
            props.load(is);
        } catch (IOException e) {
            throw new SQLException("No se pudo cargar application.properties: " + e.getMessage(), e);
        }

        String host = props.getProperty("db.host", "localhost");
        String port = props.getProperty("db.port", "3306");
        String name = props.getProperty("db.name", "zoologico_db");
        String user = props.getProperty("db.username", "root");
        String pass = props.getProperty("db.password", "");

        String url = String.format("jdbc:mysql://%s:%s/%s?useSSL=false&serverTimezone=UTC", host, port, name);

        return DriverManager.getConnection(url, user, pass);
    }
}
