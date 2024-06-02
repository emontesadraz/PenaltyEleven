import com.penaltyeleven.metodosexternos.Equipos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EquiposTest {
    private Equipos equipos;

    @BeforeEach
    public void setup() {
        equipos = new Equipos("Test Team", "test/path", "Shot1", "Shot2", "Shot3", "Stop1", "Stop2", "Stop3");
    }

    @Test
    public void getNombreEquipo_returnsCorrectName() {
        assertEquals("Test Team", equipos.getNombreEquipo());
    }

    @Test
    public void getRutaEscudo_returnsCorrectPath() {
        assertEquals("test/path", equipos.getRutaEscudo());
    }

    @Test
    public void getTiro1_returnsCorrectShot() {
        assertEquals("Shot1", equipos.getTiro1());
    }

    @Test
    public void getTiro2_returnsCorrectShot() {
        assertEquals("Shot2", equipos.getTiro2());
    }

    @Test
    public void getTiro3_returnsCorrectShot() {
        assertEquals("Shot3", equipos.getTiro3());
    }

    @Test
    public void getParada1_returnsCorrectStop() {
        assertEquals("Stop1", equipos.getParada1());
    }

    @Test
    public void getParada2_returnsCorrectStop() {
        assertEquals("Stop2", equipos.getParada2());
    }

    @Test
    public void getParada3_returnsCorrectStop() {
        assertEquals("Stop3", equipos.getParada3());
    }

    @Test
    public void setNombreEquipo_updatesName() {
        equipos.setNombreEquipo("New Name");
        assertEquals("New Name", equipos.getNombreEquipo());
    }

    @Test
    public void setRutaEscudo_updatesPath() {
        equipos.setRutaEscudo("new/path");
        assertEquals("new/path", equipos.getRutaEscudo());
    }

    @Test
    public void setTiro1_updatesShot() {
        equipos.setTiro1("New Shot1");
        assertEquals("New Shot1", equipos.getTiro1());
    }

    @Test
    public void setTiro2_updatesShot() {
        equipos.setTiro2("New Shot2");
        assertEquals("New Shot2", equipos.getTiro2());
    }

    @Test
    public void setTiro3_updatesShot() {
        equipos.setTiro3("New Shot3");
        assertEquals("New Shot3", equipos.getTiro3());
    }

    @Test
    public void setParada1_updatesStop() {
        equipos.setParada1("New Stop1");
        assertEquals("New Stop1", equipos.getParada1());
    }

    @Test
    public void setParada2_updatesStop() {
        equipos.setParada2("New Stop2");
        assertEquals("New Stop2", equipos.getParada2());
    }

    @Test
    public void setParada3_updatesStop() {
        equipos.setParada3("New Stop3");
        assertEquals("New Stop3", equipos.getParada3());
    }
}