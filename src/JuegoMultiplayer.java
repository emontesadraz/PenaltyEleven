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
    private JButton botonChutarCentro,botonChutarDerecha,botonChutarIzquierda, botonPararCentro, botonPararDerecha, botonPararIzquierda, fondo;

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

        // Creamos los botones de chutar
        botonChutarCentro = new JButton("Chutar al centro");
        botonChutarDerecha = new JButton("Chutar a la derecha");
        botonChutarIzquierda = new JButton("Chutar a la izquierda");

        // Creamos los botones de parar
        botonPararCentro = new JButton("Parar al centro");
        botonPararDerecha = new JButton("Parar a la derecha");
        botonPararIzquierda = new JButton("Parar a la izquierda");

        // Establecemos la posición de los botones de chutar
        botonChutarCentro.setBounds(100, 100, 200, 50);
        botonChutarDerecha.setBounds(100, 200, 200, 50);
        botonChutarIzquierda.setBounds(100, 300, 200, 50);

        // Establecemos la posición de los botones de parar
        botonPararCentro.setBounds(400, 100, 200, 50);
        botonPararDerecha.setBounds(400, 200, 200, 50);
        botonPararIzquierda.setBounds(400, 300, 200, 50);

        // Hacemos invisibles los botones de parar del jugador dos
        botonPararCentro.setVisible(false);
        botonPararDerecha.setVisible(false);
        botonPararIzquierda.setVisible(false);

        // Establecemos los colores de los botones


        // Añadimos Listeeners a los botones de chutar del jugador 1
        botonChutarCentro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jugador1.chutar(Jugador1.Direccion.CENTRO);
                // Ocultar botones de chutar del jugador 1
                botonChutarCentro.setVisible(false);
                botonChutarDerecha.setVisible(false);
                botonChutarIzquierda.setVisible(false);
                // Mostrar botones de parar del jugador 2
                botonPararCentro.setVisible(true);
                botonPararDerecha.setVisible(true);
                botonPararIzquierda.setVisible(true);

            }
        });
        botonChutarDerecha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jugador1.chutar(Jugador1.Direccion.DERECHA);
                // Ocultar botones de chutar del jugador 1
                botonChutarCentro.setVisible(false);
                botonChutarDerecha.setVisible(false);
                botonChutarIzquierda.setVisible(false);
                // Mostrar botones de parar del jugador 2
                botonPararCentro.setVisible(true);
                botonPararDerecha.setVisible(true);
                botonPararIzquierda.setVisible(true);

            }
        });
        botonChutarIzquierda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jugador1.chutar(Jugador1.Direccion.IZQUIERDA);
                // Ocultar botones de chutar del jugador 1
                botonChutarCentro.setVisible(false);
                botonChutarDerecha.setVisible(false);
                botonChutarIzquierda.setVisible(false);
                // Mostrar botones de parar del jugador 2
                botonPararCentro.setVisible(true);
                botonPararDerecha.setVisible(true);
                botonPararIzquierda.setVisible(true);

            }
        });

        // Añadimos Listeeners a los botones de parar del jugador 1
        botonPararCentro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jugador1.parar(Jugador1.Direccion.CENTRO);
                // Ocultar botones de parar del jugador 2
                botonPararCentro.setVisible(false);
                botonPararDerecha.setVisible(false);
                botonPararIzquierda.setVisible(false);
                // Mostrar botones de chutar del jugador 1
                botonChutarCentro.setVisible(true);
                botonChutarDerecha.setVisible(true);
                botonChutarIzquierda.setVisible(true);

            }
        });
        botonPararDerecha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jugador1.parar(Jugador1.Direccion.DERECHA);
                // Ocultar botones de parar del jugador 2
                botonPararCentro.setVisible(false);
                botonPararDerecha.setVisible(false);
                botonPararIzquierda.setVisible(false);
                // Mostrar botones de chutar del jugador 1
                botonChutarCentro.setVisible(true);
                botonChutarDerecha.setVisible(true);
                botonChutarIzquierda.setVisible(true);

            }
        });
        botonPararIzquierda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jugador1.parar(Jugador1.Direccion.IZQUIERDA);
                // Ocultar botones de parar del jugador 2
                botonPararCentro.setVisible(false);
                botonPararDerecha.setVisible(false);
                botonPararIzquierda.setVisible(false);
                // Mostrar botones de chutar del jugador 1
                botonChutarCentro.setVisible(true);
                botonChutarDerecha.setVisible(true);
                botonChutarIzquierda.setVisible(true);

            }
        });

        // Añadimos listeners a los botones de chutar del jugador 2
        botonChutarCentro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jugador2.chutar(Jugador2.Direccion.CENTRO);

            }
        });
        botonChutarDerecha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jugador2.chutar(Jugador2.Direccion.DERECHA);

            }
        });
        botonChutarIzquierda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jugador2.chutar(Jugador2.Direccion.IZQUIERDA);

            }
        });

        // Añadimos listeners a los botones de parar del jugador 2
        botonPararCentro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jugador2.parar(Jugador2.Direccion.CENTRO);

            }
        });

        botonPararDerecha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jugador2.parar(Jugador2.Direccion.DERECHA);

            }
        });

        botonPararIzquierda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jugador2.parar(Jugador2.Direccion.IZQUIERDA);

            }
        });

        // Añadimos los botones al JFrame
        panel.add(botonChutarCentro);
        panel.add(botonChutarDerecha);
        panel.add(botonChutarIzquierda);
        panel.add(botonPararCentro);
        panel.add(botonPararDerecha);
        panel.add(botonPararIzquierda);

    }

    public static void main(String[] args) {
        JuegoMultiplayer juegoMultiplayer = new JuegoMultiplayer();
        juegoMultiplayer.setVisible(true);
    }

}
