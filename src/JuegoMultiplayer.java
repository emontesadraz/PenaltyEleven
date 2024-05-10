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
    private JButton arribaIzquierda;
    private JButton centroIzquierda;
    private JButton abajoIzquierda;
    private JButton arribaCentro;
    private JButton centroCentro;
    private JButton abajoCentro;
    private JButton arribaDerecha;
    private JButton centroDerecha;
    private JButton abajoDerecha;
    private JButton chutar;
    private JButton parar;


    public JuegoMultiplayer() {
        // Configuramos el JFrame
        setSize(1280, 720);
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

        // Creamos los botones
        arribaIzquierda = new JButton();
        arribaDerecha = new JButton();
        arribaCentro = new JButton();
        centroIzquierda = new JButton();
        centroDerecha = new JButton();
        centroCentro = new JButton();
        abajoIzquierda = new JButton();
        abajoDerecha = new JButton();
        abajoCentro = new JButton();

        // Configuramos la posicion de los botones
        arribaIzquierda.setBounds(100, 100, 100, 100);
        arribaDerecha.setBounds(1080, 100, 100, 100);
        arribaCentro.setBounds(600, 100, 100, 100);
        centroIzquierda.setBounds(100, 300, 100, 100);
        centroDerecha.setBounds(1080, 300, 100, 100);
        centroCentro.setBounds(600, 300, 100, 100);
        abajoIzquierda.setBounds(100, 500, 100, 100);
        abajoDerecha.setBounds(1080, 500, 100, 100);
        abajoCentro.setBounds(600, 500, 100, 100);



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
