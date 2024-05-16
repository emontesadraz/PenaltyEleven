package com.penaltyeleven.pantallainicial.multiplayer;

public class TurnManager {
    public static final int MAX_TURNOS = 10;
    private int turnos;
    private boolean turnoJugador1;

    public TurnManager() {
        turnos = 0;
        turnoJugador1 = true; // Empieza el jugador 1
    }

    public boolean isTurnoJugador1() {
        return turnoJugador1;
    }

    public void nextTurn() {
        if (turnos < MAX_TURNOS) {
            turnoJugador1 = !turnoJugador1;
            turnos++;
        }
    }

    public boolean isGameFinished() {
        return turnos >= MAX_TURNOS;
    }

    public int getTurnos() {
        return turnos;
    }
}
