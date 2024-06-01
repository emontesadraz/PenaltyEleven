package com.penaltyeleven.basedatos;

/**
 * This class represents a User in the system.
 * Each user has a name and a score.
 */
public class User {
    private String nombre;
    private int puntuacion;

    /**
     * Constructs a new User with the specified name and score.
     * @param nombre the name of the user
     * @param puntuacion the score of the user
     */
    public User(String nombre, int puntuacion) {
        this.nombre = nombre;
        this.puntuacion = puntuacion;
    }

    /**
     * Returns the name of this user.
     * @return the name of this user
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Returns the score of this user.
     * @return the score of this user
     */
    public int getPuntuacion() {
        return puntuacion;
    }
}