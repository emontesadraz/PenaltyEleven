package com.penaltyeleven.pantallainicial;

import com.penaltyeleven.metodosexternos.InterfazMaestra;
import com.penaltyeleven.metodosexternos.MusicManager;
import com.penaltyeleven.basedatos.DatabaseHandler;
import com.penaltyeleven.basedatos.User;
import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Clase que muestra el ranking de los jugadores.
 */
public class Ranking extends InterfazMaestra {
    private MusicManager musicManager = new MusicManager();
    private JButton volver, fondo;
    private JPanel rankingPanel;
    public static final Color colorBase = new Color(25, 25, 25);
    public static final Font fuente = new Font("Rubik", Font.PLAIN, 20);
    public static final Color colorTexto = new Color(255, 255, 255);
    public static final Color colorDorado = new Color(255, 215, 0);
    public static final Color colorPlateado = new Color(192, 192, 192);
    public static final Color colorBronce = new Color(234, 145, 60);

    /**
     * Constructor de la clase.
     */
    public Ranking() {
        crearVentana("Penalty Eleven", 1280, 720);

        // Crear botones
        volver = new JButton();
        fondo = new JButton();

        JPanel panel = new JPanel();
        panel.setLayout(null);

        // Aquí creamos el fondo
        crearFondo(fondo,"Imagenes/Fondo/axelblaze.png");

        // Aquí creamos el botón volver
        crearBoton(volver, "Volver", 40, 600, 220, 50, colorBase, colorTexto, fuente, "Musica/SoundEffect/SonidoSeleccion.wav", 0.5f);

        // Crear un área de texto para mostrar el ranking
        rankingPanel = new JPanel();
        rankingPanel.setBounds(100, 150, 280, 500); // Ajusta estos valores según tus necesidades
        rankingPanel.setOpaque(false);
        rankingPanel.setLayout(new BoxLayout(rankingPanel, BoxLayout.Y_AXIS));


        // Añadir botones al panel
        panel.add(volver);
        panel.add(rankingPanel);
        panel.add(fondo);
        add(panel);

        volver.addActionListener(e -> {
            MenuInicial menuInicial = new MenuInicial();
            menuInicial.setVisible(true);
            dispose();

            musicManager.playSound("Musica/SoundEffect/SonidoAtras.wav", 0.5f);
            musicManager.stopMusic();
        });

        updateRanking();

        // Controles música
        musicManager.playMusic("Musica/Soundtrack/Ranking.wav", 0.7f);
    }

    /**
     * Actualiza el ranking de los jugadores.
     */
    public void updateRanking() {
        DatabaseHandler dbHandler = new DatabaseHandler();
        List<User> users = dbHandler.getUsersRanked();

        // Limpia el JPanel
        rankingPanel.removeAll();

        // Limitar el número de usuarios a mostrar a 10
        int maxUsersToShow = Math.min(users.size(), 10);

        // Itera a través de los usuarios y agrega etiquetas al rankingPanel
        for (int i = 0; i < maxUsersToShow; i++) {
            User user = users.get(i);
            String formattedName = String.format("%d. %s: %d", i + 1, user.getNombre(), user.getPuntuacion());
            JLabel userLabel = new JLabel(formattedName);
            userLabel.setOpaque(false);
            userLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

            // Ajustar el tamaño de fuente basado en la posición
            if (i == 0) {
                userLabel.setFont(new Font("Rubik", Font.BOLD, 30));
                userLabel.setForeground(colorDorado);
            } else if (i == 1) {
                userLabel.setFont(new Font("Rubik", Font.BOLD, 26));
                userLabel.setForeground(colorPlateado);
            } else if (i == 2) {
                userLabel.setFont(new Font("Rubik", Font.BOLD, 24));
                userLabel.setForeground(colorBronce);
            } else {
                userLabel.setFont(new Font("Rubik", Font.BOLD, 20));
                userLabel.setForeground(Color.BLACK);
            }

            rankingPanel.add(userLabel);
        }

        // Actualiza el JPanel
        rankingPanel.revalidate();
        rankingPanel.repaint();
    }

    /**
     * Método principal.
     * @param b  if {@code true}, makes the {@code Window} visible,
     * otherwise hides the {@code Window}.
     * If the {@code Window} and/or its owner
     * are not yet displayable, both are made displayable.  The
     * {@code Window} will be validated prior to being made visible.
     * If the {@code Window} is already visible, this will bring the
     * {@code Window} to the front.<p>
     * If {@code false}, hides this {@code Window}, its subcomponents, and all
     * of its owned children.
     * The {@code Window} and its subcomponents can be made visible again
     * with a call to {@code #setVisible(boolean)}.
     */
    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
        if (b) {
            updateRanking();
        }
    }
}