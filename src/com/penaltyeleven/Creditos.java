package com.penaltyeleven;

import javax.swing.*;
import java.awt.*;

public class Creditos extends InterfazMaestra {
    JPanel panel;
    JLabel creditos;
    public static final Color colorBaseBotones = new Color(25, 25, 25);
    public static final Font fuente = new Font("Rubik", Font.PLAIN, 20);
    public static final Color colorTexto = new Color(255, 255, 255);
    private MusicManager musicManager = new MusicManager();

    public Creditos() {

//Ventana
        crearVentana("Penalty Eleven", 1280, 720);

// Panel
        panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(null);

//Label creditos
        creditos = new JLabel("<html><center>Desarrollado por:<br><br>Pedro Piñeiro Ordax <br>&<br>Esteban Miguel Montes Adraz</center></html>");
        creditos.setFont(fuente);
        creditos.setForeground(Color.BLACK);
        creditos.setBounds(750, 150, 500, 300);

//Inicializar botones
        JButton volver=new JButton();
        JButton fondo=new JButton();

//Crear botones
        crearBoton(volver,"Volver",40,600,220,50,colorBaseBotones,colorTexto, fuente,"Musica/SoundEffect/SonidoSeleccion.wav",0.6f );

// Fondo
        crearFondo(fondo,"Imagenes/Fondo/Creditos.png");

// Añadir botones al panel
        panel.add(volver);

//Añadir Label al panel
        panel.add(creditos);

//Añadir fondo al panel
        panel.add(fondo);

//Añadir panel al JFrame
        add(panel);

//Accion boton volver
        volver.addActionListener(e -> {
            MenuInicial menuInicial = new MenuInicial();
            menuInicial.setVisible(true);
            dispose();

            musicManager.playSound("Musica/SoundEffect/SonidoElegir1.wav", 0.7f);
            musicManager.stopMusic();
        });

        // Controles de la música
        musicManager.playMusic("Musica/Soundtrack/Creditos.wav", 0.6f);


    }

}
