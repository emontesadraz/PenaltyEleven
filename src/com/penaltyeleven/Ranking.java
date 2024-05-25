package com.penaltyeleven;

import com.penaltyeleven.basedatos.DatabaseHandler;
import com.penaltyeleven.basedatos.User;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class Ranking extends JFrame {
    MusicManager musicManager = new MusicManager();
    private JButton volver, fondo;
    private JPanel rankingPanel;
    private JLabel mensaje;

    public Ranking() {
        setSize(1280, 720);
        setTitle("Penalty Eleven");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setIconImage(new ImageIcon("src/Imagenes/Logo.png").getImage());

        JPanel panel = new JPanel();
        panel.setLayout(null);

        // Crear un botón para el fondo
        fondo = new JButton();
        fondo.setBounds(0, 0, 1280, 720);
        fondo.setOpaque(false);
        fondo.setContentAreaFilled(false);
        fondo.setBorderPainted(false);

        // Cargar la imagen de fondo y establecerla como icono del botón
        URL url = this.getClass().getClassLoader().getResource("Imagenes/Fondo/axelblaze.png");
        ImageIcon icono = new ImageIcon(url);
        Image imagen = icono.getImage().getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
        icono = new ImageIcon(imagen);
        fondo.setIcon(icono);


        //Boton volver
        volver = new JButton("Volver");
        volver.setBounds(40, 600, 220, 50);
        volver.setBackground(MenuInicial.colorBaseBotones);
        volver.setForeground(Color.WHITE);
        volver.setFont(new Font("Action Man", Font.BOLD, 20));
        volver.addActionListener(e -> {
            MenuInicial menuInicial = new MenuInicial();
            menuInicial.setVisible(true);
            dispose();

            playSound("Musica/SoundEffect/SonidoAtras.wav", 0.5f);
            musicManager.stopMusic();
        });
        // Crear un área de texto para mostrar el ranking
        rankingPanel = new JPanel();
        rankingPanel.setBounds(100, 150, 280, 500); // Ajusta estos valores según tus necesidades
        rankingPanel.setOpaque(false);

        // Crear un título para el ranking
        mensaje = new JLabel("Tabla de Campeones Máximos");
        mensaje.setBounds(100, 100, 500, 50); // Ajusta estos valores según tus necesidades
        mensaje.setFont(new Font("Rubik", Font.BOLD, 30));
        mensaje.setForeground(Color.BLACK);
        mensaje.setHorizontalAlignment(SwingConstants.LEFT);
        mensaje.setVerticalAlignment(SwingConstants.TOP);
        mensaje.setOpaque(false);


        //Añadir botones al panel
        panel.add(volver);
        panel.add(rankingPanel);
        panel.add(mensaje);
        panel.add(fondo);
        add(panel);


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
            String formattedName = String.format("    %s: %d", user.getNombre(), user.getPuntuacion()); // Agrega 4 espacios al principio
            JLabel userLabel = new JLabel(formattedName);
            userLabel.setAlignmentX(Component.LEFT_ALIGNMENT); // Alinea el texto a la izquierda
            userLabel.setFont(new Font("Rubik", Font.BOLD, 20));
            rankingPanel.add(userLabel);
        }

        // Actualiza el JPanel
        rankingPanel.revalidate();
        rankingPanel.repaint();
    }

    public void playSound(String soundFile, float volume) {
        try {
            // Abrir un audio input stream
            URL url = this.getClass().getClassLoader().getResource(soundFile);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);

            // Obtener un clip de sonido
            Clip clip = AudioSystem.getClip();

            // Abrir el clip de audio y cargar muestras de audio del audio input stream
            clip.open(audioIn);

            // Obtener el control de volumen
            FloatControl volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);

            // Convertir el volumen en decibelios
            float dB = (float) (Math.log(volume) / Math.log(10.0) * 20.0);
            volumeControl.setValue(dB);

            // Iniciar la reproducción
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
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
