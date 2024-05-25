package com.penaltyeleven.pantallainicial.multiplayer;

import com.penaltyeleven.InterfazMaestra;
import com.penaltyeleven.JuegoMultiplayer;
import com.penaltyeleven.MenuInicial;
import com.penaltyeleven.MusicManager;
import com.penaltyeleven.basedatos.DatabaseHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

public class Jugador2Gana extends InterfazMaestra {
    private JTextField nombreField;
    private JLabel mensajeGanador;
    private JLabel mensajeRegistro;
    private JLabel mensajeNombre;
    public static final Color colorBaseBotones = new Color(25, 25, 25);
    public static final Font fuente = new Font("Rubik", Font.PLAIN, 23);
    public static final Color colorTexto = new Color(255, 255, 255);
    private final MusicManager musicManager = new MusicManager();

    public Jugador2Gana() {
        setTitle("Penalty Eleven");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setIconImage(new ImageIcon("src/Imagenes/Logo.png").getImage());


        // Editamos el mensaje a nuestro gusto
        mensajeGanador = new JLabel();
        mensajeGanador.setHorizontalAlignment(JLabel.CENTER);
        mensajeGanador.setText("¡Enhorabuena! Has ganado.");
        mensajeGanador.setFont(new Font("Rubik", Font.BOLD, 34));
        mensajeGanador.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        mensajeGanador.setBackground(new Color(255, 255, 255));
        mensajeGanador.setOpaque(true);
        mensajeGanador.setBounds(380, 50, 500, 50);

        // Editamos el mensaje a nuestro gusto
        mensajeNombre = new JLabel();
        mensajeNombre.setHorizontalAlignment(JLabel.CENTER);
        mensajeNombre.setText("Jugador 2");
        mensajeNombre.setFont(new Font("Rubik", Font.PLAIN | Font.ITALIC, 30));
        mensajeNombre.setForeground(new Color(2, 34, 162));
        mensajeNombre.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        mensajeNombre.setBackground(new Color(255, 255, 255));
        mensajeNombre.setOpaque(true);
        mensajeNombre.setBounds(520, 100, 200, 50); // Ahora mensajeNombre ha sido inicializado antes de llamar a setBounds

        // Editamos el mensaje a nuestro gusto
        mensajeRegistro = new JLabel();
        mensajeRegistro.setHorizontalAlignment(JLabel.CENTER);
        mensajeRegistro.setText("¡Registra tu nombre para guardar tu victoria!");
        mensajeRegistro.setFont(new Font("Rubik", Font.PLAIN, 23));
        mensajeRegistro.setForeground(new Color(255, 255, 255));
        mensajeRegistro.setBounds(380, 250, 500, 50);

        // Editamos el campo de texto a nuestro gusto
        nombreField = new JTextField("Por favor, introduce tu nombre");
        nombreField.setBounds(450, 300, 350, 50);
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
        crearBoton(confirmarButton, "Confirmar", 520, 350, 200, 50, colorBaseBotones, Color.BLACK, fuente, "Musica/SoundEffect/SonidoSeleccion.wav", 0.5f);
        crearBoton(reiniciarButton, "Reiniciar", 520, 500, 200, 50, colorBaseBotones, Color.BLACK, fuente, "Musica/SoundEffect/SonidoSeleccion.wav", 0.5f);
        crearBoton(selectorEquipos, "Escoger equipos", 520, 550, 200, 50, colorBaseBotones, Color.BLACK, fuente, "Musica/SoundEffect/SonidoSeleccion.wav", 0.5f);
        crearBoton(salirButton, "Salir", 520, 600, 200, 50, colorBaseBotones, Color.BLACK, fuente, "Musica/SoundEffect/SonidoSeleccion.wav", 0.5f);

        add(mensajeGanador);
        add(mensajeRegistro);
        add(mensajeNombre);
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
                JuegoMultiplayer juegoMultiplayer = new JuegoMultiplayer();
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

                musicManager.playSound("Musica/SoundEffect/SonidoElegir1.wav", 0.5f);
                musicManager.stopMusic();
            }
        });

        // Cargar la imagen de fondo y establecerla como icono del botón
        URL url = this.getClass().getClassLoader().getResource("Imagenes/Fondo/Raimon.png");
        ImageIcon icono = new ImageIcon(url);
        Image imagen = icono.getImage().getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
        icono = new ImageIcon(imagen);
        fondo.setIcon(icono);

        musicManager.playMusic("Musica/Soundtrack/Victoria.wav", 0.7f);

    }

    public static void main(String[] args) {
        Jugador2Gana jugador2Gana = new Jugador2Gana();
        jugador2Gana.setVisible(true);
    }

}
