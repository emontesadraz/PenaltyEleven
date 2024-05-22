package com.penaltyeleven.basedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseHandler {
    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String DATABASE_USER = "";
    private static final String DATABASE_PASSWORD = "";

    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
            System.out.println("Connected to the database successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void addUser(String nombre) {
        String SQL = "INSERT INTO usuarios(nombre) VALUES(?)";

        try (Connection conn = connect()) {
            if (conn == null) {
                throw new SQLException("Failed to connect to the database");
            }

            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, nombre);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}