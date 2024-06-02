import com.penaltyeleven.metodosexternos.InterfazMaestra;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class InterfazMaestraTest {
    private InterfazMaestra interfazMaestra;
    private JButton button;

    @BeforeEach
    public void setup() {
        interfazMaestra = new InterfazMaestra();
        button = new JButton();
    }

    @Test
    public void crearBoton_setsButtonProperties() {
        Font font = new Font("Arial", Font.PLAIN, 12);
        interfazMaestra.crearBoton(button, "Test", 10, 20, 30, 40, Color.RED, Color.BLUE, font, "sound.wav", 0.5f);

        assertEquals("Test", button.getText());
        assertEquals(new Rectangle(10, 20, 30, 40), button.getBounds());
        assertEquals(Color.RED, button.getBackground());
        assertEquals(Color.BLUE, button.getForeground());
        assertEquals(font, button.getFont());
        assertEquals(Color.WHITE, ((LineBorder) button.getBorder()).getLineColor());
    }

    @Test
    public void crearFondo_setsBackgroundProperties() {
        // Asegúrate de que la imagen exista en esta ruta
        String rutaImagen = "Imagenes/Escudo/Alpino.png";
        interfazMaestra.crearFondo(button, rutaImagen);

        assertEquals(new Rectangle(0, 0, 1280, 720), button.getBounds());
        assertFalse(button.isOpaque());
        assertFalse(button.isContentAreaFilled());
        assertFalse(button.isBorderPainted());
    }
}