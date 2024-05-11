package com.juego.multiplayer;

public class Jugador1 {

    public enum Direccion {
        ARRIBAIZQUIERDA(1), ARRIBADERECHA(2), ABAJOIZQUIERDA(3), ABAJODERECHA(4),CENTROARRIBA(5),CENTROABAJO(6),CENTROIZQUIERDA(7),CENTRODERECHA(8),CENTRO(9);

        private final int valor;

        Direccion(int valor) {
            this.valor = valor;
        }
        public int getValor() {
            return valor;
        }
    }
    public boolean chutar(Direccion direccion) {

        return true;
    }

    public boolean parar(Direccion direccion) {

        return true;
    }
}
