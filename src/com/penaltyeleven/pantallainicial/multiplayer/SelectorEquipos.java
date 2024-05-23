package com.penaltyeleven.pantallainicial.multiplayer;

import com.penaltyeleven.metodosexternos.MusicManager;
import com.penaltyeleven.metodosexternos.OperacionesEquipos;
import com.penaltyeleven.pantallainicial.MenuInicial;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;

public class SelectorEquipos extends JFrame {
    OperacionesEquipos oe = new OperacionesEquipos();
    MusicManager musicManager = new MusicManager();
    private ImageIcon[] imagenesEquipos = {new ImageIcon("src/Imagenes/Escudo/EscudoRaimon.png"), new ImageIcon("src/Imagenes/Escudo/EscudoZeus.png"), new ImageIcon("src/Imagenes/Escudo/EscudoGenesis.png")
            , new ImageIcon("src/Imagenes/Escudo/EscudoRoyal.png"), new ImageIcon("src/Imagenes/Escudo/EscudoAlpino.png"), new ImageIcon("src/Imagenes/Escudo/EscudoKirkwood.png"), new ImageIcon("src/Imagenes/Escudo/EscudoOccult.png"), new ImageIcon("src/Imagenes/Escudo/EscudoLittleGiants.png")
            , new ImageIcon("src/Imagenes/Escudo/EscudoEpsilon.png"), new ImageIcon("src/Imagenes/Escudo/EscudoOtaku.png"), new ImageIcon("src/Imagenes/Escudo/EscudoFarm.png"), new ImageIcon("src/Imagenes/Escudo/EscudoCaos.png")};
    JButton seleccionarEqu1, seleccionarEqu2, jugar, back, flechaIzquierda, flechaDerecha, flechaIzquierda2, flechaDerecha2;
    JPanel panel;
    JLabel labelEquipo1, labelEquipo2;
    int indiceEquipo1, indiceEquipo2 = 0;
    boolean eq1, eq2 = false;


    public SelectorEquipos() {

        // Configuración de la ventana
        super("Penalty Eleven");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1280, 720);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);

        //Poner icono de la aplicación
        setIconImage(new ImageIcon("src/Imagenes/Logo.png").getImage());

        // Fuente y color de los botones
        Font fuenteBoton = new Font("Action Man", Font.BOLD, 20);
        Color colorBoton = new Color(25,25,25);
        Color colorTexto = new Color(255, 255, 255);

        // Panel
        panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(null);
        this.add(panel);

        // JLabel para el equipo 1
        labelEquipo1 = new JLabel(oe.getEquipos().get(indiceEquipo1).getNombreEquipo());
        labelEquipo1.setFont(new Font("Action Man", Font.BOLD, 30));
        labelEquipo1.setOpaque(false);
        labelEquipo1.setForeground(Color.BLACK);
        labelEquipo1.setBounds(100, 200, 300, 40);
        labelEquipo1.setHorizontalAlignment(JLabel.CENTER);
        panel.add(labelEquipo1);

        // JLabel para la imagen del equipo 1
        JLabel imagenEquipo1 = new JLabel(imagenesEquipos[indiceEquipo1]);
        imagenEquipo1.setBounds(150, 250, 200, 200);
        panel.add(imagenEquipo1);

        // JLabel para el equipo 2
        labelEquipo2 = new JLabel(oe.getEquipos().get(indiceEquipo2).getNombreEquipo());
        labelEquipo2.setFont(new Font("Action Man", Font.BOLD, 30));
        labelEquipo2.setOpaque(false);
        labelEquipo2.setForeground(Color.BLACK);
        labelEquipo2.setHorizontalAlignment(JLabel.CENTER);
        labelEquipo2.setBounds(900, 200, 300, 40);
        panel.add(labelEquipo2);

        // JLabel para la imagen del equipo 2
        JLabel imagenEquipo2 = new JLabel(imagenesEquipos[indiceEquipo2]);
        imagenEquipo2.setBounds(950, 250, 200, 200);
        panel.add(imagenEquipo2);

        // Botón seleccionar para el equipo 1
        seleccionarEqu1 = new JButton("Seleccionar");
        seleccionarEqu1.setFont(fuenteBoton);
        seleccionarEqu1.setBackground(colorBoton);
        seleccionarEqu1.setForeground(colorTexto);
        seleccionarEqu1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Reproducir sonido
                playSound("Musica/SoundEffect/SonidoBotones.wav", 0.7f);
                if (seleccionarEqu1.getText().equals("Seleccionar")) {
                    seleccionarEqu1.setText("Seleccionado");
                } else {
                    seleccionarEqu1.setText("Seleccionar");
                }
                eq1 = !eq1;
            }
        });
        seleccionarEqu1.setBounds(150, 100, 200, 50);

        panel.add(seleccionarEqu1);

        // Botón seleccionar para el equipo 2
        seleccionarEqu2 = new JButton("Seleccionar");
        seleccionarEqu2.setFont(fuenteBoton);
        seleccionarEqu2.setBackground(colorBoton);
        seleccionarEqu2.setForeground(colorTexto);
        seleccionarEqu2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Reproducir sonido
                playSound("Musica/SoundEffect/SonidoBotones.wav", 0.7f);
                if (seleccionarEqu2.getText().equals("Seleccionar")) {
                    seleccionarEqu2.setText("Seleccionado");
                } else {
                    seleccionarEqu2.setText("Seleccionar");
                }
                eq2 = !eq2;
            }
        });
        seleccionarEqu2.setBounds(950, 100, 200, 50);
        panel.add(seleccionarEqu2);

        // Botón jugar
        jugar = new JButton("Jugar");
        jugar.setFont(fuenteBoton);
        jugar.setBackground(colorBoton);
        jugar.setForeground(colorTexto);
        jugar.setBounds(550, 500, 200, 50);
        jugar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Reproducir sonido
                playSound("Musica/SoundEffect/SonidoJugar.wav", 0.7f);
                if (eq1 && eq2) {
                    // Aquí va el código para iniciar el juego
                    // dispose();
                    // playMusic.stopMusic();
                    // new Juego().setVisible(true);
                } else {
                    // Mostrar un mensaje de error si los equipos no están seleccionados
                    JOptionPane.showMessageDialog(null, "Debes seleccionar ambos equipos antes de jugar.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(jugar);

        // Botón atrás
        back = new JButton("Atrás");
        back.setFont(fuenteBoton);
        back.setBackground(colorBoton);
        back.setForeground(colorTexto);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Reproducir sonido
                playSound("Musica/SoundEffect/SonidoAtras.wav", 0.7f);
                musicManager.stopMusic();
                dispose();
                MenuInicial menuInicial = new MenuInicial();
                menuInicial.setVisible(true);
            }
        });
        back.setBounds(550, 600, 200, 50);
        panel.add(back);

        // Botón flecha izquierda
        flechaIzquierda = new JButton("<");
        flechaIzquierda.setFont(fuenteBoton);
        flechaIzquierda.setBackground(colorBoton);
        flechaIzquierda.setForeground(colorTexto);
        flechaIzquierda.setBounds(900, 500, 50, 50);
        flechaIzquierda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSound("Musica/SoundEffect/SonidoFlechas.wav", 0.7f);
                if (!eq2 && indiceEquipo2 > 0) {
                    indiceEquipo2--;
                    labelEquipo2.setText(oe.getEquipos().get(indiceEquipo2).getNombreEquipo());
                    imagenEquipo2.setIcon(imagenesEquipos[indiceEquipo2]);
                }
            }
        });
        panel.add(flechaIzquierda);

        // Botón flecha derecha
        flechaDerecha = new JButton(">");
        flechaDerecha.setFont(fuenteBoton);
        flechaDerecha.setBackground(colorBoton);
        flechaDerecha.setForeground(colorTexto);
        flechaDerecha.setBounds(1150, 500, 50, 50);
        flechaDerecha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSound("Musica/SoundEffect/SonidoFlechas.wav", 0.7f);
                if (!eq2 && indiceEquipo2 < oe.getEquipos().size() - 1) {
                    indiceEquipo2++;
                    labelEquipo2.setText(oe.getEquipos().get(indiceEquipo2).getNombreEquipo());
                    imagenEquipo2.setIcon(imagenesEquipos[indiceEquipo2]);
                }
            }
        });
        panel.add(flechaDerecha);

        // Botón flecha izquierda 2
        flechaIzquierda2 = new JButton("<");
        flechaIzquierda2.setFont(fuenteBoton);
        flechaIzquierda2.setBackground(colorBoton);
        flechaIzquierda2.setForeground(colorTexto);
        flechaIzquierda2.setBounds(100, 500, 50, 50);
        flechaIzquierda2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSound("Musica/SoundEffect/SonidoFlechas.wav", 0.7f);
                if (!eq1 && indiceEquipo1 > 0) {
                    indiceEquipo1--;
                    labelEquipo1.setText(oe.getEquipos().get(indiceEquipo1).getNombreEquipo());
                    imagenEquipo1.setIcon(imagenesEquipos[indiceEquipo1]);
                }
            }
        });
        panel.add(flechaIzquierda2);

        // Botón flecha derecha 2
        flechaDerecha2 = new JButton(">");
        flechaDerecha2.setFont(fuenteBoton);
        flechaDerecha2.setBackground(colorBoton);
        flechaDerecha2.setForeground(colorTexto);
        flechaDerecha2.setBounds(350, 500, 50, 50);
        flechaDerecha2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSound("Musica/SoundEffect/SonidoFlechas.wav", 0.7f);
                if (!eq1 && indiceEquipo1 < oe.getEquipos().size() - 1) {
                    indiceEquipo1++;
                    labelEquipo1.setText(oe.getEquipos().get(indiceEquipo1).getNombreEquipo());
                    imagenEquipo1.setIcon(imagenesEquipos[indiceEquipo1]);
                }
            }
        });
        panel.add(flechaDerecha2);

        // Crear un botón para el fondo
        JButton fondo = new JButton();
        fondo.setBounds(0, 0, 1280, 720);
        fondo.setOpaque(false);
        fondo.setContentAreaFilled(false);
        fondo.setBorderPainted(false);
        panel.add(fondo);

        //Crear el mouseListener de todos los botones
        seleccionarEqu1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                playSound("Musica/SoundEffect/SonidoSeleccion.wav", 0.7f);
                seleccionarEqu1.setBackground(colorBoton.darker());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                seleccionarEqu1.setBackground(colorBoton);
            }
        });
        seleccionarEqu2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                playSound("Musica/SoundEffect/SonidoSeleccion.wav", 0.7f);
                seleccionarEqu2.setBackground(colorBoton.darker());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                seleccionarEqu2.setBackground(colorBoton);
            }
        });

        jugar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                playSound("Musica/SoundEffect/SonidoSeleccion.wav", 0.7f);
                jugar.setBackground(colorBoton.darker());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jugar.setBackground(colorBoton);
            }
        });

        back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                playSound("Musica/SoundEffect/SonidoSeleccion.wav", 0.7f);
                back.setBackground(colorBoton.darker());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                back.setBackground(colorBoton);
            }
        });

        flechaIzquierda.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                playSound("Musica/SoundEffect/SonidoSeleccion.wav", 0.7f);
                flechaIzquierda.setBackground(colorBoton.darker());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                flechaIzquierda.setBackground(colorBoton);
            }
        });

        flechaDerecha.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                playSound("Musica/SoundEffect/SonidoSeleccion.wav", 0.7f);
                flechaDerecha.setBackground(colorBoton.darker());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                flechaDerecha.setBackground(colorBoton);
            }
        });

        flechaIzquierda2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                playSound("Musica/SoundEffect/SonidoSeleccion.wav", 0.7f);
                flechaIzquierda2.setBackground(colorBoton.darker());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                flechaIzquierda2.setBackground(colorBoton);
            }
        });

        flechaDerecha2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                playSound("Musica/SoundEffect/SonidoSeleccion.wav", 0.7f);
                flechaDerecha2.setBackground(colorBoton.darker());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                flechaDerecha2.setBackground(colorBoton);
            }
        });



        // Cargar la imagen de fondo y establecerla como icono del botón
        URL url = this.getClass().getClassLoader().getResource("Imagenes/Fondo/SelectorEquipos.jpg");
        ImageIcon icono = new ImageIcon(url);
        Image imagen = icono.getImage().getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
        icono = new ImageIcon(imagen);
        fondo.setIcon(icono);

        // Controles de la música
        musicManager.playMusic("Musica/Soundtrack/SelectorEquipos.wav", 0.7f);
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
}