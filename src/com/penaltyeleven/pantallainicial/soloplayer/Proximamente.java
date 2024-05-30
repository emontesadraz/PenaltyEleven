package com.penaltyeleven.pantallainicial.soloplayer;

import com.penaltyeleven.metodosexternos.InterfazMaestra;
import com.penaltyeleven.metodosexternos.MusicManager;
import com.penaltyeleven.pantallainicial.soloplayer.lobby.LobbyIE1;
import com.penaltyeleven.pantallainicial.soloplayer.lobby.LobbyIE2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class Proximamente extends InterfazMaestra {
    private final JLabel comingSoon;
    private final JButton volver;
    private JButton fondo;
    public static final Color colorBaseBotones = new Color(25, 25, 25);
    private final MusicManager musicManager = new MusicManager();

    public Proximamente(JLabel proximamente) {
        this.comingSoon = proximamente;

        //Ventana
        crearVentana("Penalty Eleven", 1280, 720);

        // Panel
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(null);

        //Añadir panel al JFrame
        add(panel);

        //Crear botones
        comingSoon= new JLabel("Próximamente...");
        volver = new JButton("Volver");

        //Crear fondo
        fondo = new JButton();
        crearFondo(fondo, "Imagenes/Fondo/hectorhelio.png");

        //Añadir botones al panel
        panel.add(comingSoon);
        panel.add(volver);
        panel.add(fondo);

        //Acción del botón volver
        volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SoloPlayer soloPlayer = new SoloPlayer();
                soloPlayer.setVisible(true);
                dispose();
                musicManager.playSound("Musica/SoundEffect/SonidoElegir1.wav", 0.7f);
                musicManager.stopMusic();
            }
        });

        //Cambiar color base
        comingSoon.setBackground(colorBaseBotones);
        volver.setBackground(colorBaseBotones);

        //Cambiar tamaño y posición
        comingSoon.setBounds(120, 200, 460, 45);
        volver.setBounds(120, 515, 460, 45);

        //Cambiar la fuente
        Font fuenteBoton = new Font("Action Man", Font.BOLD, 20);
        comingSoon.setFont(new Font("Action Man", Font.BOLD, 40));
        volver.setFont(fuenteBoton);

        //Cambiar color de texto de los botones
        Color colorTexto = new Color(255, 255, 255);
        comingSoon.setForeground(colorTexto);
        volver.setForeground(colorTexto);

        // Cambiar color de los botones al pasar el ratón por encima
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



