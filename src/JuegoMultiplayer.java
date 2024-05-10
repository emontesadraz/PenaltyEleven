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
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setTitle("Penalty Eleven");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Poner icono de la aplicación
        setIconImage(new ImageIcon("src/Imagenes/Logo.png").getImage());

        // Creamos un panel
        JPanel panel1 = new JPanel();
        panel1.setSize(1280, 720);
        panel1.setBackground(new Color(0, 0, 0, 255));
        panel1.setOpaque(false);
        panel1.setLayout(null);
        add(panel1);

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
        arribaIzquierda.setBounds(150, 10, 200, 200);
        arribaDerecha.setBounds(920, 10, 200, 200);
        arribaCentro.setBounds(520,10, 200, 200);
        centroIzquierda.setBounds(150, 210, 200, 200);
        centroDerecha.setBounds(920, 210, 200, 200);
        centroCentro.setBounds(520, 210, 200, 200);
        abajoIzquierda.setBounds(150, 410, 200, 200);
        abajoDerecha.setBounds(920, 410, 200, 200);
        abajoCentro.setBounds(520, 410, 200, 200);



        // Añadimos los checkbox al panel
        panel1.add(arribaIzquierda);
        panel1.add(arribaDerecha);
        panel1.add(arribaCentro);
        panel1.add(centroIzquierda);
        panel1.add(centroDerecha);
        panel1.add(centroCentro);
        panel1.add(abajoIzquierda);
        panel1.add(abajoDerecha);
        panel1.add(abajoCentro);


    }

    public static void main(String[] args) {
        JuegoMultiplayer juego = new JuegoMultiplayer();
        juego.setVisible(true);
    }
}
