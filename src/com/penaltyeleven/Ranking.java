package com.penaltyeleven;

import com.penaltyeleven.basedatos.DatabaseHandler;
import com.penaltyeleven.basedatos.User;
import com.penaltyeleven.metodosexternos.InterfazMaestra;
import com.penaltyeleven.metodosexternos.MusicManager;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Ranking extends InterfazMaestra {
    MusicManager musicManager = new MusicManager();
    private JButton volver, fondo;
    private JPanel rankingPanel;
    private JLabel puesto1;
    private JLabel puesto2;
    private JLabel puesto3;
    private JLabel puesto4;
    private JLabel puesto5;
    private JLabel puesto6;
    private JLabel puesto7;
    private JLabel puesto8;
    private JLabel puesto9;
    private JLabel puesto10;
    public static final Color colorBase = new Color(25, 25, 25);
    public static final Font fuente = new Font("Rubik", Font.PLAIN, 20);
    public static final Color colorTexto = new Color(255, 255, 255);

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

    private void updateRanking() {
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

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
        if (b) {
            updateRanking();
        }
    }

    public static void main(String[] args) {
        new Ranking().setVisible(true);
    }

}
