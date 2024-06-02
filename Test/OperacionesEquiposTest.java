import com.penaltyeleven.metodosexternos.OperacionesEquipos;
import com.penaltyeleven.metodosexternos.Equipos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class OperacionesEquiposTest {
    private OperacionesEquipos operacionesEquipos;

    @BeforeEach
    public void setup() {
        operacionesEquipos = new OperacionesEquipos();
    }

    @Test
    public void equiposListIsInitializedWithCorrectSize() {
        List<Equipos> equipos = operacionesEquipos.getEquipos();
        assertEquals(30, equipos.size());
    }

    @Test
    public void equiposListContainsCorrectFirstTeam() {
        Equipos equipo = operacionesEquipos.getEquipos().get(0);
        assertEquals("Instituto Raimon", equipo.getNombreEquipo());
        assertEquals("Imagenes/Escudo/Raimon.png", equipo.getRutaEscudo());
        assertEquals("Tornado de Fuego", equipo.getTiro1());
        assertEquals("Super Relámpago", equipo.getTiro2());
        assertEquals("Fénix", equipo.getTiro3());
        assertEquals("Despeje de Fuego", equipo.getParada1());
        assertEquals("Mano Celestial", equipo.getParada2());
        assertEquals("Mano Mágica", equipo.getParada3());
    }

    @Test
    public void equiposListContainsCorrectLastTeam() {
        Equipos equipo = operacionesEquipos.getEquipos().get(29);
        assertEquals("Little Giants", equipo.getNombreEquipo());
        assertEquals("Imagenes/Escudo/LittleGiants.png", equipo.getRutaEscudo());
        assertEquals("Mandíbulas Dobles", equipo.getTiro1());
        assertEquals("Disparo Dual", equipo.getTiro2());
        assertEquals("Disparo X", equipo.getTiro3());
        assertEquals("Mano Celestial", equipo.getParada1());
        assertEquals("Mano Celestial X", equipo.getParada2());
        assertEquals("Mano Espiritual", equipo.getParada3());
    }
}