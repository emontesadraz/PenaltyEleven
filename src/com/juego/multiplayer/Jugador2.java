package com.juego.multiplayer;

public class Jugador2 {

    public enum Direccion {
        ARRIBAIZQUIERDA, ARRIBADERECHA, ABAJOIZQUIERDA, ABAJODERECHA,CENTROARRIBA,CENTROABAJO,CENTROIZQUIERDA,CENTRODERECHA,CENTRO
    }
    public boolean chutar(Direccion direccion) {
        return true;
    }

    public boolean parar(Direccion direccion) {
        return true;
    }
}
