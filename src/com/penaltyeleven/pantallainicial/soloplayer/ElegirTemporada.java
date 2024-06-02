package com.penaltyeleven.pantallainicial.soloplayer;

import com.penaltyeleven.metodosexternos.InterfazMaestra;
import com.penaltyeleven.metodosexternos.MusicManager;
import com.penaltyeleven.pantallainicial.soloplayer.lobby.LobbyIE1;
import com.penaltyeleven.pantallainicial.soloplayer.lobby.LobbyIE2;
import com.penaltyeleven.pantallainicial.soloplayer.lobby.LobbyIE3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

/**
 * Clase que muestra la pantalla de elección de temporada para el modo de juego de un solo jugador.
 */
public class ElegirTemporada extends InterfazMaestra {
    private final JButton temp1;
    private final JButton temp2;
    private final JButton temp3;
    private final JButton volver;
    private JButton fondo;
    public static final Color colorBaseBotones = new Color(25, 25, 25);
    private BufferedImage imagen;
    private final MusicManager musicManager = new MusicManager();
    /**
     * Constructor de la clase ElegirTemporada.
     */
    public ElegirTemporada() {

        //Ventana
        crearVentana("Penalty Eleven", 1280, 720);

        // Panel
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(null);

        //Añadir panel al JFrame
        add(panel);

        //Crear botones
        temp1 = new JButton("Temporada 1");
        temp2 = new JButton("Temporada 2");
        temp3 = new JButton("Temporada 3");
        volver = new JButton("Volver");

        //Crear fondo
        fondo = new JButton();
        crearFondo(fondo, "Imagenes/Fondo/axelkevin.png");

        //Añadir botones al panel
        panel.add(temp1);
        panel.add(temp2);
        panel.add(temp3);
        panel.add(volver);
        panel.add(fondo);

        //Accion del boton temp1
        temp1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LobbyIE1 lobbyIE1 = new LobbyIE1();
                lobbyIE1.setVisible(true);
                dispose();

                musicManager.playSound("Musica/SoundEffect/SonidoElegir1.wav", 0.7f);
                musicManager.stopMusic();
            }
        });

        //Acción del botón temp2
        temp2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LobbyIE2 lobbyIE2 = new LobbyIE2();
                lobbyIE2.setVisible(true);
                dispose();

                musicManager.playSound("Musica/SoundEffect/SonidoElegir1.wav", 0.7f);
                musicManager.stopMusic();
            }
        });

        //Acción del botón temp3
        temp3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LobbyIE3 lobbyIE3 = new LobbyIE3();
                lobbyIE3.setVisible(true);
                dispose();

                musicManager.playSound("Musica/SoundEffect/SonidoElegir1.wav", 0.7f);
                musicManager.stopMusic();
            }
        });

        //Acción del botón volver
        volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SoloPlayer soloPlayer = new SoloPlayer();
                soloPlayer.setVisible(true);
                dispose();
                musicManager.playSound("Musica/SoundEffect/SonidoAtras.wav", 0.7f);
                musicManager.stopMusic();
            }
        });

        //Cambiar color base de los botones
        temp1.setBackground(colorBaseBotones);
        temp2.setBackground(colorBaseBotones);
        temp3.setBackground(colorBaseBotones);
        volver.setBackground(colorBaseBotones);
        fondo.setBackground(colorBaseBotones);

        //Cambiar tamaño y posición de los botones
        temp1.setBounds(120, 275, 460, 45);
        temp2.setBounds(120, 355, 460, 45);
        temp3.setBounds(120, 435, 460, 45);
        volver.setBounds(120, 515, 460, 45);

        //Cambiar la fuente de los botones
        Font fuenteBoton = new Font("Rubik", Font.BOLD, 20);
        temp1.setFont(fuenteBoton);
        temp2.setFont(fuenteBoton);
        temp3.setFont(fuenteBoton);
        volver.setFont(fuenteBoton);

        //Cambiar color de texto de los botones
        Color colorTexto = new Color(255, 255, 255);
        temp1.setForeground(colorTexto);
        temp2.setForeground(colorTexto);
        temp3.setForeground(colorTexto);
        volver.setForeground(colorTexto);

        // Cambiar color de los botones al pasar el ratón por encima
        temp1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                musicManager.playSound("Musica/SoundEffect/SonidoSeleccion.wav", 0.7f);
                temp1.setBackground(colorBaseBotones.darker());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                temp1.setBackground(colorBaseBotones);
            }
        });

        temp2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                musicManager.playSound("Musica/SoundEffect/SonidoSeleccion.wav", 0.7f);
                temp2.setBackground(colorBaseBotones.darker());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                temp2.setBackground(colorBaseBotones);
            }
        });

        temp3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                musicManager.playSound("Musica/SoundEffect/SonidoSeleccion.wav", 0.7f);
                temp3.setBackground(colorBaseBotones.darker());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                temp3.setBackground(colorBaseBotones);
            }
        });

        volver.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                musicManager.playSound("Musica/SoundEffect/SonidoSeleccion.wav", 0.7f);
                volver.setBackground(colorBaseBotones.darker());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                volver.setBackground(colorBaseBotones);
            }
        });

        // Controles de la música
        musicManager.playMusic("Musica/Soundtrack/SoloPlayer1.wav", 0.5f);

    }


}


