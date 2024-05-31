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
    private JLabel puesto1;
    public static final Color colorBase = new Color(25, 25, 25);
    public static final Font fuente = new Font("Rubik", Font.PLAIN, 20);
    public static final Color colorTexto = new Color(255, 255, 255);

    /**
     * Constructor de la clase.
     */
    public Ranking() {
        setSize(1280, 720);
        setTitle("Penalty Eleven");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setIconImage(new ImageIcon("src/Imagenes/Logo.png").getImage());

        // Crear botones
        volver = new JButton();
        fondo = new JButton();

        JPanel panel = new JPanel();
        panel.setLayout(null);

        // Aquí creamos el fondo
        crearFondo(fondo,"Imagenes/Fondo/axelblaze.png");

        //Aquí creamos el boton volver
        crearBoton(volver, "Volver", 40, 600, 220, 50, colorBase,colorTexto,fuente,"Musica/SoundEffect/SonidoSeleccion.wav",0.5f);


        // Crear un área de texto para mostrar el ranking
        rankingPanel = new JPanel();
        rankingPanel.setBounds(100, 150, 280, 500); // Ajusta estos valores según tus necesidades
        rankingPanel.setOpaque(false);

        // Crear un título para el ranking
        puesto1 = new JLabel("Tabla de Campeones Máximos");
        puesto1.setBounds(100, 100, 500, 50); // Ajusta estos valores según tus necesidades
        puesto1.setFont(new Font("Rubik", Font.BOLD, 30));
        puesto1.setForeground(Color.BLACK);
        puesto1.setHorizontalAlignment(JLabel.LEFT);
        puesto1.setVerticalAlignment(JLabel.TOP);
        puesto1.setOpaque(false);


        //Añadir botones al panel
        panel.add(volver);
        panel.add(rankingPanel);
        panel.add(puesto1);
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


        //Controles música
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

        for (User user : users) {
            String formattedName = String.format("%s: %d\n", user.getNombre(), user.getPuntuacion()); // Agrega 4 espacios al principio
            JLabel userLabel = new JLabel(formattedName);
            userLabel.setBackground(new Color(255, 255, 255));
            userLabel.setOpaque(true);
            userLabel.setAlignmentX(Component.LEFT_ALIGNMENT); // Alinea el texto a la izquierda
            userLabel.setFont(new Font("Rubik", Font.BOLD, 20));
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
     * with a call to {@code #setVisible(true)}.
     */
    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
        if (b) {
            updateRanking();
        }
    }
}
