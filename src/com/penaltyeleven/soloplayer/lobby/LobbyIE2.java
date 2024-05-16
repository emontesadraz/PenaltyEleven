package com.penaltyeleven.soloplayer.lobby;

import com.penaltyeleven.InterfazMaestra;
import com.penaltyeleven.MusicManager;
import com.penaltyeleven.soloplayer.ElegirTemporada;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LobbyIE2 extends InterfazMaestra {
    public static final Color colorBaseBotones = new Color(25, 25, 25);
    public static final Font fuenteBoton = new Font("Rubik", Font.PLAIN, 20);
    public static final Color colorTexto = new Color(255, 255, 255);
    private final MusicManager musicManager = new MusicManager();

    public LobbyIE2() {

        //Ventana
        crearVentana("Penalty Eleven",1280,720);

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
        crearFondo(fondo,"Imagenes/Fondo/LobbyIE2.png");

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
                //Abrir ventana de Temporada 2

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
        musicManager.playMusic("Musica/Soundtrack/LobbyIE2.wav", 0.5f);

    }


}
