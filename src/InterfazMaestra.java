import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class InterfazMaestra extends JFrame {

    //Metodo para crear el fondo de la ventana
    public static void crearFondo(JButton fondo,String rutaFondo) {
        // Crear un botón para el fondo
        fondo.setBounds(0, 0, 1280, 720);
        fondo.setOpaque(false);
        fondo.setContentAreaFilled(false);
        fondo.setBorderPainted(false);

        // Cargar la imagen de fondo y establecerla como icono del botón
        URL url = InterfazMaestra.class.getClassLoader().getResource(rutaFondo);
        ImageIcon icono = new ImageIcon(url);
        Image imagen = icono.getImage().getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
        icono = new ImageIcon(imagen);
        fondo.setIcon(icono);
    }



}
