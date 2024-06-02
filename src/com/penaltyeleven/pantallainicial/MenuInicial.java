package com.penaltyeleven.pantallainicial;

import com.penaltyeleven.metodosexternos.InterfazMaestra;
import com.penaltyeleven.metodosexternos.MusicManager;
import com.penaltyeleven.pantallainicial.multiplayer.SelectorEquipos;
import com.penaltyeleven.pantallainicial.soloplayer.SoloPlayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Clase que muestra el menú inicial del juego.
 */
public class MenuInicial extends InterfazMaestra {
    public static JPanel panel;
    public static final Color colorBaseBotones = new Color(25, 25, 25);
    public static final Font fuenteBoton = new Font("Rubik", Font.BOLD, 20);
    public static final Color colorTexto = new Color(255, 255, 255);
    private final MusicManager musicManager = new MusicManager();

    /**
     * Constructor de la clase.
     */
    public MenuInicial() {

//Ventana
        crearVentana("Penalty Eleven", 1280, 720);

// Panel
        panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(null);

//Inicializar botones
        JButton soloPlayer = new JButton();
        JButton multiPlayer = new JButton();
        JButton ranking = new JButton();
        JButton creditos = new JButton();
        JButton salir = new JButton();

// Crear botones
        crearBoton(soloPlayer, "Un Jugador", 175, 275, 340, 45, colorBaseBotones, colorTexto, fuenteBoton, "Musica/SoundEffect/SonidoSeleccion.wav", 0.6f);
        crearBoton(multiPlayer, "Multijugador", 175, 355, 340, 45, colorBaseBotones, colorTexto, fuenteBoton, "Musica/SoundEffect/SonidoSeleccion.wav", 0.6f);
        crearBoton(ranking, "Ranking", 175, 435, 340, 45, colorBaseBotones, colorTexto, fuenteBoton, "Musica/SoundEffect/SonidoSeleccion.wav", 0.6f);
        crearBoton(creditos, "Créditos", 175, 515, 340, 45, colorBaseBotones, colorTexto, fuenteBoton, "Musica/SoundEffect/SonidoSeleccion.wav", 0.6f);
        crearBoton(salir, "Salir", 175, 595, 340, 45, colorBaseBotones, colorTexto, fuenteBoton, "Musica/SoundEffect/SonidoSeleccion.wav", 0.6f);

// Fondo
        JButton fondo = new JButton();
        crearFondo(fondo, "Imagenes/Fondo/MenuInicial.png");

// Añadir los botones al panel
        panel.add(soloPlayer);
        panel.add(multiPlayer);
        panel.add(ranking);
        panel.add(creditos);
        panel.add(salir);
        panel.add(fondo);

//Añadir panel al JFrame
        add(panel);

        //Accion del boton soloPlayer
        soloPlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SoloPlayer soloPlayer = new SoloPlayer();
                soloPlayer.setVisible(true);
                dispose();
                musicManager.playSound("Musica/SoundEffect/SonidoElegir1.wav", 0.7f);
                musicManager.stopMusic();
            }
        });

//Acción del botón multiPlayer
        multiPlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SelectorEquipos selectorEquipos = null;
                try {
                    selectorEquipos = new SelectorEquipos();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                selectorEquipos.setVisible(true);
                dispose();
                musicManager.playSound("Musica/SoundEffect/SonidoElegir1.wav", 0.7f);
                musicManager.stopMusic();

            }

        });

        //Acción del botón rankingGoleadores
        ranking.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ranking ranking = new Ranking();
                ranking.setVisible(true);
                dispose();
                musicManager.playSound("Musica/SoundEffect/SonidoElegir1.wav", 0.7f);
                musicManager.stopMusic();
            }
        });

        //Acción del botón creditos
        creditos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Creditos creditos = new Creditos();
                creditos.setVisible(true);
                dispose();
                musicManager.playSound("Musica/SoundEffect/SonidoElegir1.wav", 0.7f);
                musicManager.stopMusic();
            }
        });

        //Acción del botón salir
        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                musicManager.playSound("Musica/SoundEffect/SonidoAtras.wav", 0.7f);
                System.exit(0);
            }
        });

// Controles de la música
        musicManager.playMusic("Musica/Soundtrack/MenuInicial.wav", 0.4f);

    }
}
