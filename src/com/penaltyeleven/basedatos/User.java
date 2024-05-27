package com.penaltyeleven.basedatos;

public class User {
    private String nombre;
    private int puntuacion;


    public User(String nombre, int puntuacion) {
        this.nombre = nombre;
        this.puntuacion = puntuacion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntuacion() {
        return puntuacion;
    }
}
