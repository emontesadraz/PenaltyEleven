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

public class Jugador1Gana extends InterfazMaestra {
    private JTextField nombreField;
    private JLabel mensajeGanador;
    public static final Color colorBaseBotones = new Color(25, 25, 25);
    public static final Font fuente = new Font("Rubik", Font.PLAIN, 23);
    public static final Color colorTexto = new Color(255, 255, 255);
    private final MusicManager musicManager = new MusicManager();

    public Jugador1Gana() {
        setTitle("Penalty Eleven");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Editamos el mensaje a nuestro gusto
        mensajeGanador = new JLabel();
        mensajeGanador.setHorizontalAlignment(SwingConstants.CENTER);
        mensajeGanador.setText("¡Enhorabuena! Has ganado.");
        mensajeGanador.setFont(fuente);
        mensajeGanador.setForeground(colorTexto);

        nombreField = new JTextField("Por favor, introduce tu nombre");

        // Inicializamos los Botones
        JButton confirmarButton = new JButton();
        JButton reiniciarButton = new JButton();
        JButton selectorEquipos = new JButton();
        JButton salirButton = new JButton();

        // Creamos los botones
        crearBoton(confirmarButton, "Confirmar", 500, 500, 200, 50, colorBaseBotones, Color.WHITE, fuente, "src/Sonidos/Click.wav", 0.5f);
        crearBoton(reiniciarButton, "Reiniciar", 500, 600, 200, 50, colorBaseBotones, Color.WHITE, fuente, "src/Sonidos/Click.wav", 0.5f);
        crearBoton(selectorEquipos, "Reiniciar con distintos equipos", 1000, 600, 200, 50, colorBaseBotones, Color.WHITE, fuente, "src/Sonidos/Click.wav", 0.5f);
        crearBoton(salirButton, "Salir", 1000, 500, 200, 50, colorBaseBotones, Color.WHITE, fuente, "src/Sonidos/Click.wav", 0.5f);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(mensajeGanador);
        add(nombreField);
        add(confirmarButton);
        add(reiniciarButton);
        add(selectorEquipos);
        add(salirButton);

        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreField.getText();
                DatabaseHandler dbHandler = new DatabaseHandler();
                dbHandler.addUser(nombre);
            }
        });
        reiniciarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JuegoMultiplayer juegoMultiplayer = new JuegoMultiplayer();
                juegoMultiplayer.setVisible(true);
                dispose();

                musicManager.playSound("src/Sonidos/SonidoElegir1.wav", 0.5f);
                musicManager.stopMusic();
            }
        });
        selectorEquipos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SelectorEquipos selectorEquipos = new SelectorEquipos();
                selectorEquipos.setVisible(true);
                dispose();

                musicManager.playSound("src/Sonidos/SonidoElegir1.wav", 0.5f);
                musicManager.stopMusic();
            }
        });
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuInicial menuInicial = new MenuInicial();
                menuInicial.setVisible(true);
                dispose();

                musicManager.playSound("src/Sonidos/SonidoElegir1.wav", 0.5f);
                musicManager.stopMusic();
            }
        });
    }

    public static void main(String[] args) {
        Jugador1Gana jugador1Gana = new Jugador1Gana();
        jugador1Gana.setVisible(true);
    }

}
