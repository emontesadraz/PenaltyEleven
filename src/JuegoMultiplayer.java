import com.juego.multiplayer.Jugador1;
import com.juego.multiplayer.Jugador2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JuegoMultiplayer extends JFrame {
    private Jugador1 jugador1;
    private Jugador2 jugador2;
    public static final Color colorBaseBotones = new Color(25, 25, 25);
    private final MusicManager musicManager = new MusicManager();
    private JCheckBox arribaIzquierda;
    private JCheckBox centroIzquierda;
    private JCheckBox abajoIzquierda;
    private JCheckBox arribaCentro;
    private JCheckBox centroCentro;
    private JCheckBox abajoCentro;
    private JCheckBox arribaDerecha;
    private JCheckBox centroDerecha;
    private JCheckBox abajoDerecha;
    private JButton chutar;
    private JButton parar;


    public JuegoMultiplayer() {
        // Configuramos el JFrame
        setSize(1280,720);
        setTitle("Penalty Eleven");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Poner icono de la aplicación
        setIconImage(new ImageIcon("src/Imagenes/Logo.png").getImage());

        // Creamos un panel
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(null);
        add(panel);

        // Creamos los jugadores
        jugador1 = new Jugador1();
        jugador2 = new Jugador2();

        // Creamos los checkbox
        arribaIzquierda = new JCheckBox();
        arribaDerecha = new JCheckBox();
        arribaCentro = new JCheckBox();
        centroIzquierda = new JCheckBox();
        centroDerecha = new JCheckBox();
        centroCentro = new JCheckBox();
        abajoIzquierda = new JCheckBox();
        abajoDerecha = new JCheckBox();
        abajoCentro = new JCheckBox();

        // Configuramos la posición de los checkbox
        arribaIzquierda.setBounds(100, 100, 150, 150);
        arribaDerecha.setBounds(1000, 100, 150, 150);
        arribaCentro.setBounds(500, 100, 150, 150);
        centroIzquierda.setBounds(100, 300, 150, 150);
        centroDerecha.setBounds(1000, 300, 150, 150);
        centroCentro.setBounds(500, 300, 150, 150);
        abajoIzquierda.setBounds(100, 500, 150, 150);
        abajoDerecha.setBounds(1000, 500, 150, 150);
        abajoCentro.setBounds(500, 500, 150, 150);

        // Añadimos los checkbox al panel
        panel.add(arribaIzquierda);
        panel.add(arribaDerecha);
        panel.add(arribaCentro);
        panel.add(centroIzquierda);
        panel.add(centroDerecha);
        panel.add(centroCentro);
        panel.add(abajoIzquierda);
        panel.add(abajoDerecha);
        panel.add(abajoCentro);


    }

    public static void main(String[] args) {
        JuegoMultiplayer juego = new JuegoMultiplayer();
        juego.setVisible(true);
    }
}
