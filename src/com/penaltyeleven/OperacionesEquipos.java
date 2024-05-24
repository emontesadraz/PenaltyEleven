package com.penaltyeleven;

import java.util.ArrayList;
import java.util.List;

public class OperacionesEquipos extends Equipos{
    private List<Equipos> equipos = new ArrayList<Equipos>();

    public OperacionesEquipos() {
        agregarEquipo();
    }

    public void agregarEquipo() {
        Equipos equipo1 = new Equipos("Instituto Raimon", "Imagenes/Escudo/Raimon.png", "Tornado de Fuego", "Super Relámpago", "Fénix", "Despeje de Fuego","Mano Celestial", "Mano Mágica");
        equipos.add(equipo1);
        Equipos equipo2 = new Equipos("Instituto Zeus", "Imagenes/Escudo/Zeus.png", "Tornado de Fuego", "Super Relámpago", "Fénix", "Despeje de Fuego","Mano Celestial", "Mano Mágica");
        equipos.add(equipo2);

    }

    public List<Equipos> getEquipos() {
        return equipos;
    }
}
