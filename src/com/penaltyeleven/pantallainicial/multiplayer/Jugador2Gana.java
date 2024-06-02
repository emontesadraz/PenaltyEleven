package com.penaltyeleven.pantallainicial.multiplayer;
import com.penaltyeleven.metodosexternos.Equipos;
import com.penaltyeleven.metodosexternos.InterfazMaestra;
import com.penaltyeleven.pantallainicial.MenuInicial;
import com.penaltyeleven.metodosexternos.MusicManager;
import com.penaltyeleven.basedatos.DatabaseHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 * Clase que muestra la pantalla de victoria del jugador 1 en el modo multijugador.
 */
public class Jugador2Gana extends InterfazMaestra {
    private JTextArea nombreField;
    public static final Color colorBaseBotones = new Color(25, 25, 25);
    public static final Font fuente = new Font("Rubik", Font.PLAIN, 23);
    public static final Color colorTexto = new Color(255, 255, 255);
    private final MusicManager musicManager = new MusicManager();
    private Equipos equipoSeleccionado1;
    private BufferedImage escudoEquipoSeleccionado1;
    private Equipos equipoSeleccionado2;
    private BufferedImage escudoEquipoSeleccionado2;

    /**
     * Constructor de la clase Jugador1Gana.
     * @param equipoSeleccionado1 Equipo seleccionado por el jugador 1.
     * @param escudoEquipoSeleccionado1 Escudo del equipo seleccionado por el jugador 1.
     * @param equipoSeleccionado2 Equipo seleccionado por el jugador 2.
     * @param escudoEquipoSeleccionado2 Escudo del equipo seleccionado por el jugador 2.
     */
    public Jugador2Gana(Equipos equipoSeleccionado1, BufferedImage escudoEquipoSeleccionado1, Equipos equipoSeleccionado2, BufferedImage escudoEquipoSeleccionado2) {
        setTitle("Penalty Eleven");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setIconImage(new ImageIcon("src/Imagenes/Logo.png").getImage());

        this.equipoSeleccionado1 = equipoSeleccionado1;
        this.escudoEquipoSeleccionado1 = escudoEquipoSeleccionado1;
        this.equipoSeleccionado2 = equipoSeleccionado2;
        this.escudoEquipoSeleccionado2 = escudoEquipoSeleccionado2;


        // Editamos el campo de texto a nuestro gusto
        nombreField = new JTextArea("Por favor, introduce tu nombre");
        nombreField.setBounds(450, 310, 350, 50);
        nombreField.setAlignmentX(JTextArea.CENTER_ALIGNMENT);
        nombreField.setAlignmentY(JTextArea.CENTER_ALIGNMENT);
        nombreField.setFont(fuente);

        // Iniciamos el campo de texto con un click
        nombreField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nombreField.setText("");
            }
        });

        // Creamos el fondo
        JButton fondo = new JButton();
        fondo.setBounds(0, 0, 1280, 720);
        fondo.setOpaque(false);
        fondo.setContentAreaFilled(false);
        fondo.setBorderPainted(false);


        // Inicializamos los Botones
        JButton confirmarButton = new JButton();
        JButton reiniciarButton = new JButton();
        JButton selectorEquipos = new JButton();
        JButton salirButton = new JButton();

        // Creamos los botones
        crearBoton(confirmarButton, "Confirmar", 520, 360, 200, 50, colorBaseBotones, Color.WHITE, fuente, "Musica/SoundEffect/SonidoSeleccion.wav", 0.5f);
        crearBoton(reiniciarButton, "Reiniciar", 520, 500, 200, 50, colorBaseBotones, Color.WHITE, fuente, "Musica/SoundEffect/SonidoSeleccion.wav", 0.5f);
        crearBoton(selectorEquipos, "Escoger equipos", 520, 550, 200, 50, colorBaseBotones, Color.WHITE, fuente, "Musica/SoundEffect/SonidoSeleccion.wav", 0.5f);
        crearBoton(salirButton, "Salir", 520, 600, 200, 50, colorBaseBotones, Color.WHITE, fuente, "Musica/SoundEffect/SonidoSeleccion.wav", 0.5f);


        add(nombreField);
        add(confirmarButton);
        add(reiniciarButton);
        add(selectorEquipos);
        add(salirButton);
        add(fondo);

        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreField.getText();
                DatabaseHandler dbHandler = new DatabaseHandler();
                dbHandler.addOrUpdateUser(nombre);

                JOptionPane.showMessageDialog(null, "¡Tu victoria ha sido registrada con éxito!", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
                confirmarButton.setEnabled(false);
            }
        });
        reiniciarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JuegoMultiplayer juegoMultiplayer = new JuegoMultiplayer(equipoSeleccionado1,escudoEquipoSeleccionado1,equipoSeleccionado2,escudoEquipoSeleccionado2);
                juegoMultiplayer.setVisible(true);
                dispose();

                musicManager.playSound("Musica/SoundEffect/SonidoElegir1.wav", 0.5f);
                musicManager.stopMusic();
            }
        });
        selectorEquipos.addActionListener(new ActionListener() {
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

                musicManager.playSound("Musica/SoundEffect/SonidoElegir1.wav", 0.5f);
                musicManager.stopMusic();
            }
        });
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuInicial menuInicial = new MenuInicial();
                menuInicial.setVisible(true);
                dispose();

                musicManager.playSound("Musica/SoundEffect/SonidoAtras.wav", 0.5f);
                musicManager.stopMusic();
            }
        });

        // Cargar la imagen de fondo y establecerla como icono del botón
        URL url = this.getClass().getClassLoader().getResource("Imagenes/Fondo/VictoriaJ2.png");
        ImageIcon icono = new ImageIcon(url);
        Image imagen = icono.getImage().getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
        icono = new ImageIcon(imagen);
        fondo.setIcon(icono);

        musicManager.playMusic("Musica/Soundtrack/Victoria.wav", 0.7f);

    }
}