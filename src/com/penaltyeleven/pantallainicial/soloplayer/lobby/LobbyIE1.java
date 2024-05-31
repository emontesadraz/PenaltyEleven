package com.penaltyeleven.pantallainicial.soloplayer.lobby;

import com.penaltyeleven.metodosexternos.InterfazMaestra;
import com.penaltyeleven.metodosexternos.MusicManager;
import com.penaltyeleven.pantallainicial.soloplayer.ElegirTemporada;
import com.penaltyeleven.pantallainicial.soloplayer.Proximamente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LobbyIE1 extends InterfazMaestra {
    public static final Color colorBaseBotones = new Color(25, 25, 25);
    public static final Font fuenteBoton = new Font("Rubik", Font.PLAIN, 20);
    public static final Color colorTexto = new Color(255, 255, 255);
    private final MusicManager musicManager = new MusicManager();

    public LobbyIE1() {

        //Ventana
        crearVentana("Penalty Eleven", 1280, 720);

        // Panel
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(null);

//Inicializar botones
        JButton empezar = new JButton();
        JButton volver = new JButton();
        JButton fondo = new JButton();

// Crear botones
        crearBoton(empezar, "Empezar", 1020, 620, 200, 50, colorBaseBotones, colorTexto, fuenteBoton, "Musica/SoundEffect/SonidoSeleccion.wav", 0.6f);
        crearBoton(volver, "Volver", 60, 620, 200, 50, colorBaseBotones, colorTexto, fuenteBoton, "Musica/SoundEffect/SonidoSeleccion.wav", 0.6f);

// Fondo
        crearFondo(fondo, "Imagenes/Fondo/LobbyIE1.png");

//Añadir botones al panel
        panel.add(empezar);
        panel.add(volver);

//Añadir fondo al panel
        panel.add(fondo);

//Añadir panel al JFrame
        add(panel);

        //Acción del botón siguiente
        empezar.addActionListener(new ActionListener() {
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
                ElegirTemporada elegirTemporada = new ElegirTemporada();
                elegirTemporada.setVisible(true);
                dispose();
                musicManager.playSound("Musica/SoundEffect/SonidoElegir1.wav", 0.7f);
                musicManager.stopMusic();
            }
        });


        // Controles de la música
        musicManager.playMusic("Musica/Soundtrack/SoloPlayer1.wav", 0.5f);

    }


}
