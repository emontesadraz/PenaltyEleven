package com.penaltyeleven.pantallainicial.soloplayer;

import com.penaltyeleven.metodosexternos.InterfazMaestra;
import com.penaltyeleven.pantallainicial.MenuInicial;
import com.penaltyeleven.metodosexternos.MusicManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase que muestra la pantalla de elección de modo de juego para un solo jugador.
 */
public class SoloPlayer extends InterfazMaestra {
    public static final Color colorBaseBotones = new Color(25, 25, 25);
    public static final Font fuenteBoton = new Font("Rubik", Font.BOLD, 20);
    public static final Color colorTexto = new Color(255, 255, 255);
    private final MusicManager musicManager = new MusicManager();

    /**
     * Constructor de la clase SoloPlayer.
     */
    public SoloPlayer() {

        //Ventana
        crearVentana("Penalty Eleven", 1280, 720);

        //Panel
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(null);

        //Añadir panel al JFrame
        add(panel);

        //Inicializar botones
        JButton modoHistoria = new JButton();
        JButton juegoLibre = new JButton();
        JButton volver = new JButton();
        JButton fondo = new JButton();

        //Crear botones
        crearBoton(modoHistoria, "Modo Historia", 160, 230, 320, 45, colorBaseBotones, colorTexto, fuenteBoton, "Musica/SoundEffect/SonidoSeleccion.wav", 0.6f);
        crearBoton(juegoLibre, "Juego Libre", 160, 325, 320, 45, colorBaseBotones, colorTexto, fuenteBoton, "Musica/SoundEffect/SonidoSeleccion.wav", 0.6f);
        crearBoton(volver, "Volver", 160, 420, 320, 45, colorBaseBotones, colorTexto, fuenteBoton, "Musica/SoundEffect/SonidoSeleccion.wav", 0.6f);

        modoHistoria.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        juegoLibre.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        volver.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));

        // Fondo
        crearFondo(fondo, "Imagenes/Fondo/markevans.png");

        //Añadir botones al panel
        panel.add(modoHistoria);
        panel.add(juegoLibre);
        panel.add(volver);
        panel.add(fondo);

        //Accion del boton modoHistoria
        modoHistoria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ElegirTemporada elegirTemporada = new ElegirTemporada();
                elegirTemporada.setVisible(true);
                dispose();

                musicManager.playSound("Musica/SoundEffect/SonidoElegir1.wav", 0.7f);
                musicManager.stopMusic();
            }
        });

        //Acción del botón juegoLibre
        juegoLibre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Proximamente proximamente = new Proximamente();
                proximamente.setVisible(true);
                dispose();

                musicManager.playSound("Musica/SoundEffect/SonidoElegir1.wav", 0.7f);
                musicManager.stopMusic();
            }
        });

        //Acción del botón volver
        volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuInicial menuInicial = new MenuInicial();
                menuInicial.setVisible(true);
                dispose();
                musicManager.playSound("Musica/SoundEffect/SonidoAtras.wav", 0.7f);

                musicManager.stopMusic();
            }
        });

        // Controles de la música
        musicManager.playMusic("Musica/Soundtrack/SoloPlayer1.wav", 0.5f);


    }
}
