package com.penaltyeleven.basedatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.sql.DriverManager.getConnection;

/**
 * This class handles all the database operations for the application.
 */
public class DatabaseHandler {
    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String DATABASE_USER = "postgres";
    private static final String DATABASE_PASSWORD = "@24Octubre2004";

    /**
     * This method is used to establish a connection with the database.
     * @return Connection This returns the connection object for the database.
     */
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

    /**
     * This method is used to add or update a user in the database.
     * @param nombre This is the name of the user.
     */
    public void addOrUpdateUser(String nombre) {
        Connection conn = connect();
        try {
            // Try to update the score of the existing user
            String updateSql = "UPDATE usuarios SET puntuacion = puntuacion + 1 WHERE nombre = ?";
            PreparedStatement updatePstmt = conn.prepareStatement(updateSql);
            updatePstmt.setString(1, nombre);
            int updatedRows = updatePstmt.executeUpdate();

            // If no rows were updated, insert a new user
            if (updatedRows == 0) {
                String insertSql = "INSERT INTO usuarios (nombre, puntuacion) VALUES (?, ?)";
                PreparedStatement insertPstmt = conn.prepareStatement(insertSql);
                insertPstmt.setString(1, nombre);
                insertPstmt.setInt(2, 1); // Set the initial score to 1
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

    /**
     * This method is used to get a list of users ranked by their scores.
     * @return List<User> This returns a list of users ranked by their scores.
     */
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