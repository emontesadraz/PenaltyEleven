package com.penaltyeleven.basedatos;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.sql.DriverManager.getConnection;

public class DatabaseHandler {
    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String DATABASE_USER = "postgres";
    private static final String DATABASE_PASSWORD = "@24Octubre2004";

    public Connection connect() {
        Connection conn = null;
        try {
            conn = getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
            System.out.println("Connected to the database successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void addOrUpdateUser(String nombre) {
        Connection conn = connect();
        try {
            // Intenta actualizar la puntuación del usuario existente
            String updateSql = "UPDATE usuarios SET puntuacion = puntuacion + 1 WHERE nombre = ?";
            PreparedStatement updatePstmt = conn.prepareStatement(updateSql);
            updatePstmt.setString(1, nombre);
            int updatedRows = updatePstmt.executeUpdate();

            // Si no se actualizó ninguna fila, inserta un nuevo usuario
            if (updatedRows == 0) {
                String insertSql = "INSERT INTO usuarios (nombre, puntuacion) VALUES (?, ?)";
                PreparedStatement insertPstmt = conn.prepareStatement(insertSql);
                insertPstmt.setString(1, nombre);
                insertPstmt.setInt(2, 1); // Establece la puntuación inicial en 1
                insertPstmt.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    public List<User> getUsersRanked() {
        List<User> users = new ArrayList<>();
        Connection conn = connect();
        try {
            String sql = "SELECT nombre, puntuacion FROM usuarios ORDER BY puntuacion DESC";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                int puntuacion = rs.getInt("puntuacion");
                users.add(new User(nombre, puntuacion));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return users;
    }
}