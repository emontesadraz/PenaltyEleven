import java.util.ArrayList;
import java.util.List;

public class OperacionesEquipos extends Equipos{
    private List<Equipos> equipos = new ArrayList<Equipos>();

    public OperacionesEquipos() {
        agregarEquipo();
    }

    public void agregarEquipo() {
        Equipos equipo1 = new Equipos("Instituto Raimon");
        equipos.add(equipo1);
        Equipos equipo2 = new Equipos("Instituto Zeus");
        equipos.add(equipo2);
        Equipos equipo3 = new Equipos("Genesis");
        equipos.add(equipo3);
        Equipos equipo4 = new Equipos("Royal Academy");
        equipos.add(equipo4);
        Equipos equipo5 = new Equipos("Instituto Alpino");
        equipos.add(equipo5);
        Equipos equipo6 = new Equipos("Instituto Kirkwood");
        equipos.add(equipo6);
        Equipos equipo7 = new Equipos("Instituto Occult");
        equipos.add(equipo7);
        Equipos equipo8 = new Equipos("Little Gigantes");
        equipos.add(equipo8);
        Equipos equipo9 = new Equipos("Épsilon");
        equipos.add(equipo9);
        Equipos equipo10 = new Equipos("Instituto Otaku");
        equipos.add(equipo10);
        Equipos equipo11 = new Equipos("Instituto Farm");
        equipos.add(equipo11);
        Equipos equipo12 = new Equipos("Prominence");
        equipos.add(equipo12);
        Equipos equipo13 = new Equipos("Caos");
        equipos.add(equipo13);
    }

    public List<Equipos> getEquipos() {
        return equipos;
    }
}
