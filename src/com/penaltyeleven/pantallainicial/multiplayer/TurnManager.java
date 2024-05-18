package com.penaltyeleven.pantallainicial.multiplayer;

public class TurnManager {
    public static final int MAX_TURNOS = 10;
    private int turnos;
    private boolean turnoJugador1;
    private boolean esTurnoDeTirar;

    public TurnManager() {
        turnos = 0;
        turnoJugador1 = true; // Empieza el jugador 1
        esTurnoDeTirar = true; // Empieza tirando
    }

    public boolean isTurnoJugador1() {
        return turnoJugador1;
    }

    public boolean isTurnoDeTirar() {
        return esTurnoDeTirar;
    }

    public void nextTurn() {
        if (turnos < MAX_TURNOS) {
            // Si es turno de tirar, cambiamos a turno de parar
            if (esTurnoDeTirar) {
                esTurnoDeTirar = false;
            } else {
                // Si es turno de parar, cambiamos al otro jugador y volvemos a turno de tirar
                turnoJugador1 = !turnoJugador1;
                esTurnoDeTirar = true;
                turnos++;
            }
        }
    }

    public boolean isGameFinished() {
        return turnos >= MAX_TURNOS;
    }

    public int getTurnos() {
        return turnos;
    }
}