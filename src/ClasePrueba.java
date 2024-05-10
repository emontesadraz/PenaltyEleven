import javax.swing.*;
import java.awt.*;

public class ClasePrueba extends InterfazMaestra{
    private JButton boton;
    private JLabel etiqueta;
    private JButton fondo;
    public final Color colorBaseBotones = new Color(25, 25, 25);
    private MusicManager musicManager = new MusicManager();

    public ClasePrueba() {

        setSize(1280, 720);
        setTitle("Penalty Eleven");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        //Poner icono de la aplicación
        setIconImage(new ImageIcon("src/Imagenes/Logo.png").getImage());

        JPanel panel = new JPanel();
        panel.setLayout(null);

        // Cargar la imagen de fondo
        ImageIcon imagenFondo = new ImageIcon("Imagenes/Fondo/axelkevin.png");

        // Crear un JLabel y establecer la imagen como icono
        JLabel labelFondo = new JLabel();
        labelFondo.setIcon(imagenFondo);

        // Añadir el JLabel al panel
        panel.add(labelFondo, BorderLayout.CENTER);

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ClasePrueba());
    }
}