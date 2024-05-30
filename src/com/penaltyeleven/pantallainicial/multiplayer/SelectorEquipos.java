package com.penaltyeleven.pantallainicial.multiplayer;
import com.penaltyeleven.MenuInicial;
import com.penaltyeleven.metodosexternos.Equipos;
import com.penaltyeleven.metodosexternos.InterfazMaestra;
import com.penaltyeleven.metodosexternos.MusicManager;
import com.penaltyeleven.metodosexternos.OperacionesEquipos;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a team selector interface for a game.
 * It extends from the com.penaltyeleven.InterfazMaestra class.
 */
public class SelectorEquipos extends InterfazMaestra {
    OperacionesEquipos oe = new OperacionesEquipos();
    private final MusicManager musicManager = new MusicManager();
    public static final Color colorBase = new Color(25, 25, 25);
    public static final Font fuente = new Font("Rubik", Font.PLAIN, 20);
    public static final Color colorTexto = new Color(255, 255, 255);
    private final ImageIcon[][] imagenesEquipos = {
            {
                    new ImageIcon("src/Imagenes/Escudo/Raimon.png", "Raimon"),
                    new ImageIcon("src/Imagenes/Escudo/Occult.png", "Occult"),
                    new ImageIcon("src/Imagenes/Escudo/Wild.png", "Wild"),
                    new ImageIcon("src/Imagenes/Escudo/Brain.png", "Brain"),
                    new ImageIcon("src/Imagenes/Escudo/Otaku.png", "Otaku"),
                    new ImageIcon("src/Imagenes/Escudo/RoyalAcademy.png", "Royal Academy"),
                    new ImageIcon("src/Imagenes/Escudo/Shuriken.png", "Shuriken"),
                    new ImageIcon("src/Imagenes/Escudo/Farm.png", "Farm"),
                    new ImageIcon("src/Imagenes/Escudo/Kirkwood.png", "Kirkwood"),
                    new ImageIcon("src/Imagenes/Escudo/Zeus.png", "Zeus"),
            },
            {
                    new ImageIcon("src/Imagenes/Escudo/Raimon2.png", "Raimon 2"),
                    new ImageIcon("src/Imagenes/Escudo/Alpino.png", "Alpino"),
                    new ImageIcon("src/Imagenes/Escudo/TormentaDeGeminis.png", "Tormenta de Geminis"),
                    new ImageIcon("src/Imagenes/Escudo/RoyalRedux.png", "Royal Academy Redux"),
                    new ImageIcon("src/Imagenes/Escudo/Epsilon.png", "Épsilon"),
                    new ImageIcon("src/Imagenes/Escudo/Prominence.png", "Prominence"),
                    new ImageIcon("src/Imagenes/Escudo/PolvoDiamante.png", "Polvo de Diamantes"),
                    new ImageIcon("src/Imagenes/Escudo/Caos.png", "Caos"),
                    new ImageIcon("src/Imagenes/Escudo/Genesis.png", "Genesis"),
                    new ImageIcon("src/Imagenes/Escudo/EmperadoresOscuros.png", "Emperadores Oscuros"),
            },
            {
                    new ImageIcon("src/Imagenes/Escudo/InazumaJapon.png", "Inazuma Japón"),
                    new ImageIcon("src/Imagenes/Escudo/NeoJapon.png", "Neo Japón"),
                    new ImageIcon("src/Imagenes/Escudo/DragonesDeFuego.png", "Dragones de Fuego"),
                    new ImageIcon("src/Imagenes/Escudo/KnightsOfQueen.png", "Knights of Queen"),
                    new ImageIcon("src/Imagenes/Escudo/Emperadores.png", "Los Emperadores"),
                    new ImageIcon("src/Imagenes/Escudo/Unicorn.png", "Unicorn"),
                    new ImageIcon("src/Imagenes/Escudo/LosRojos.png", "Los Rojos"),
                    new ImageIcon("src/Imagenes/Escudo/Orfeo.png", "Orfeo"),
                    new ImageIcon("src/Imagenes/Escudo/OsReis.png", "Os Reis"),
                    new ImageIcon("src/Imagenes/Escudo/LittleGiants.png", "Little Giants"),
            }
    };

    JPanel panel;
    JLabel labelEquipo1;
    JLabel labelEquipo2;
    int indiceEquipo1 = 0;
    int indiceEquipo2 = 0;
    int temporadaActual = 0;
    boolean eq1 = false;
    boolean eq2 = false;
    List<List<Equipos>> temporadas;

    /**
     * Constructor for the com.penaltyeleven.pantallainicial.SelectorEquipos class.
     * It initializes the team selector interface.
     * @throws IOException if there is an error reading an image file.
     */
    public SelectorEquipos() throws IOException {
        // Ventana
        crearVentana("Penalty Eleven", 1280, 720);

        // Inicializar temporadas
        temporadas = new ArrayList<>();
        List<Equipos> equipos = oe.getEquipos();
        temporadas.add(equipos.subList(0, 10)); // Asume que los primeros 10 equipos son de la temporada 1
        temporadas.add(equipos.subList(10, 20)); // Asume que los siguientes 10 equipos son de la temporada 2
        temporadas.add(equipos.subList(20, equipos.size())); // Asume que los equipos restantes son de la temporada 3

        // Panel
        panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(null);
        add(panel);

        // JLabel para el equipo 1
        labelEquipo1 = new JLabel(temporadas.get(temporadaActual).get(indiceEquipo1).getNombreEquipo());
        labelEquipo1.setFont(fuente);
        labelEquipo1.setOpaque(true);
        labelEquipo1.setForeground(colorBase);
        labelEquipo1.setBackground(Color.WHITE);
        labelEquipo1.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        labelEquipo1.setBounds(100, 190, 300, 40);
        labelEquipo1.setHorizontalAlignment(JLabel.CENTER);

        // JLabel para la imagen del equipo 1
        JLabel imagenEquipo1 = new JLabel(imagenesEquipos[indiceEquipo1][temporadaActual]);
        imagenEquipo1.setBounds(150, 250, 200, 200);

        // JLabel para el equipo 2
        labelEquipo2 = new JLabel(temporadas.get(temporadaActual).get(indiceEquipo2).getNombreEquipo());
        labelEquipo2.setFont(fuente);
        labelEquipo2.setOpaque(true);
        labelEquipo2.setForeground(colorBase);
        labelEquipo2.setBackground(Color.WHITE);
        labelEquipo2.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        labelEquipo2.setBounds(900, 190, 300, 40);
        labelEquipo2.setHorizontalAlignment(JLabel.CENTER);

        // JLabel para la imagen del equipo 2
        JLabel imagenEquipo2 = new JLabel(imagenesEquipos[indiceEquipo2][temporadaActual]);
        imagenEquipo2.setBounds(950, 250, 200, 200);

        // JLabel imagen versus
        BufferedImage vs = ImageIO.read(new File("src/Imagenes/Foto/versus.png"));
        JLabel versus = new JLabel();
        versus.setIcon(new ImageIcon(vs.getScaledInstance(400, 400, Image.SCALE_DEFAULT)));
        versus.setBounds(450, 120, 400, 400);
        versus.setBorder(null);

        // Inicializar botones
        JButton seleccionarEqu1 = new JButton();
        JButton seleccionarEqu2 = new JButton();
        JButton jugar = new JButton();
        JButton atras = new JButton();
        JButton flechaIzquierda = new JButton();
        JButton flechaDerecha = new JButton();
        JButton flechaIzquierda2 = new JButton();
        JButton flechaDerecha2 = new JButton();
        JButton fondo = new JButton();
        JButton seleccionarTemporada = new JButton();

        // Crear botones
        crearBoton(seleccionarEqu1, "Seleccionar", 150, 100, 200, 50, colorBase, colorTexto, fuente, "Musica/SoundEffect/SonidoSeleccion.wav", 0.6f);
        crearBoton(seleccionarEqu2, "Seleccionar", 950, 100, 200, 50, colorBase, colorTexto, fuente, "Musica/SoundEffect/SonidoSeleccion.wav", 0.6f);
        crearBoton(jugar, "Jugar", 550, 500, 200, 50, colorBase, colorTexto, fuente, "Musica/SoundEffect/SonidoSeleccion.wav", 0.6f);
        crearBoton(atras, "Atrás", 550, 600, 200, 50, colorBase, colorTexto, fuente, "Musica/SoundEffect/SonidoSeleccion.wav", 0.6f);
        crearBoton(flechaIzquierda, "<", 900, 500, 50, 50, colorBase, colorTexto, fuente, "Musica/SoundEffect/SonidoSeleccion.wav", 0.6f);
        crearBoton(flechaDerecha, ">", 1150, 500, 50, 50, colorBase, colorTexto, fuente, "Musica/SoundEffect/SonidoSeleccion.wav", 0.6f);
        crearBoton(flechaIzquierda2, "<", 100, 500, 50, 50, colorBase, colorTexto, fuente, "Musica/SoundEffect/SonidoSeleccion.wav", 0.6f);
        crearBoton(flechaDerecha2, ">", 350, 500, 50, 50, colorBase, colorTexto, fuente, "Musica/SoundEffect/SonidoSeleccion.wav", 0.6f);
        crearBoton(seleccionarTemporada, "Cambiar Temporada", 450, 20, 400, 50, colorBase, colorTexto, fuente, "Musica/SoundEffect/SonidoSeleccion.wav", 0.6f);

        // Fondo
        crearFondo(fondo, "Imagenes/Fondo/SelectorEquipos.jpg");

        // Añadir botones al panel
        panel.add(seleccionarEqu1);
        panel.add(seleccionarEqu2);
        panel.add(jugar);
        panel.add(atras);
        panel.add(flechaIzquierda);
        panel.add(flechaDerecha);
        panel.add(flechaIzquierda2);
        panel.add(flechaDerecha2);
        panel.add(seleccionarTemporada);

        // Añadir labels al panel
        panel.add(labelEquipo1);
        panel.add(labelEquipo2);
        panel.add(imagenEquipo1);
        panel.add(imagenEquipo2);
        panel.add(versus);

        // Añadir fondo al panel
        panel.add(fondo);

        // Añadir panel al JFrame
        add(panel);

        // Acciones de los botones
        // Accion del boton seleccionarEqu1
        seleccionarEqu1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Reproducir sonido
                musicManager.playSound("Musica/SoundEffect/SonidoBotones.wav", 0.7f);
                if (seleccionarEqu1.getText().equals("Seleccionar")) {
                    seleccionarEqu1.setText("Seleccionado");
                } else {
                    seleccionarEqu1.setText("Seleccionar");
                }
                eq1 = !eq1;
            }
        });

        // Accion del boton seleccionarEqu2
        seleccionarEqu2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Reproducir sonido
                musicManager.playSound("Musica/SoundEffect/SonidoBotones.wav", 0.7f);
                if (seleccionarEqu2.getText().equals("Seleccionar")) {
                    seleccionarEqu2.setText("Seleccionado");
                } else {
                    seleccionarEqu2.setText("Seleccionar");
                }
                eq2 = !eq2;
            }
        });

        // Accion del boton jugar
        jugar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Reproducir sonido
                musicManager.playSound("Musica/SoundEffect/SonidoJugar.wav", 0.7f);
                if (eq1 && eq2) {
                    JuegoMultiplayer juegoMultiplayer;
                    juegoMultiplayer = new JuegoMultiplayer();
                    juegoMultiplayer.setVisible(true);
                    dispose();
                    musicManager.stopMusic();
                } else {
                    // Mostrar un mensaje de error si los equipos no están seleccionados
                    JOptionPane.showMessageDialog(null, "Debes seleccionar ambos equipos antes de jugar.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Accion del boton atras
        atras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Reproducir sonido
                musicManager.playSound("Musica/SoundEffect/SonidoAtras.wav", 0.7f);
                musicManager.stopMusic();
                dispose();
                MenuInicial menuInicial = new MenuInicial();
                menuInicial.setVisible(true);
            }
        });

        // Accion del boton flechaIzquierda
        flechaIzquierda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                musicManager.playSound("Musica/SoundEffect/SonidoFlechas.wav", 0.7f);
                if (!eq2 && indiceEquipo2 > 0) {
                    indiceEquipo2--;
                    // Asegúrate de que el índice esté dentro de los límites de la matriz
                    if (indiceEquipo2 < imagenesEquipos[temporadaActual].length) {
                        labelEquipo2.setText(temporadas.get(temporadaActual).get(indiceEquipo2).getNombreEquipo());
                        imagenEquipo2.setIcon(imagenesEquipos[temporadaActual][indiceEquipo2]);
                    }
                }
            }
        });

        // Accion del boton flechaDerecha
        flechaDerecha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                musicManager.playSound("Musica/SoundEffect/SonidoFlechas.wav", 0.7f);
                if (!eq2 && indiceEquipo2 < temporadas.get(temporadaActual).size() - 1) {
                    indiceEquipo2++;
                    // Asegúrate de que el índice esté dentro de los límites de la matriz
                    if (indiceEquipo2 < imagenesEquipos[temporadaActual].length) {
                        labelEquipo2.setText(temporadas.get(temporadaActual).get(indiceEquipo2).getNombreEquipo());
                        imagenEquipo2.setIcon(imagenesEquipos[temporadaActual][indiceEquipo2]);
                    }
                }
            }
        });

        // Accion del boton flechaIzquierda2
        flechaIzquierda2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                musicManager.playSound("Musica/SoundEffect/SonidoFlechas.wav", 0.7f);
                if (!eq1 && indiceEquipo1 > 0) {
                    indiceEquipo1--;
                    // Asegúrate de que el índice esté dentro de los límites de la matriz
                    if (indiceEquipo1 < imagenesEquipos[temporadaActual].length) {
                        labelEquipo1.setText(temporadas.get(temporadaActual).get(indiceEquipo1).getNombreEquipo());
                        imagenEquipo1.setIcon(imagenesEquipos[temporadaActual][indiceEquipo1]);
                    }
                }
            }
        });

        // Accion del boton flechaDerecha2
        flechaDerecha2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                musicManager.playSound("Musica/SoundEffect/SonidoFlechas.wav", 0.7f);
                if (!eq1 && indiceEquipo1 < temporadas.get(temporadaActual).size() - 1) {
                    indiceEquipo1++;
                    // Asegúrate de que el índice esté dentro de los límites de la matriz
                    if (indiceEquipo1 < imagenesEquipos[temporadaActual].length) {
                        labelEquipo1.setText(temporadas.get(temporadaActual).get(indiceEquipo1).getNombreEquipo());
                        imagenEquipo1.setIcon(imagenesEquipos[temporadaActual][indiceEquipo1]);
                    }
                }
            }
        });

        // Accion del boton seleccionarTemporada
        seleccionarTemporada.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                musicManager.playSound("Musica/SoundEffect/SonidoBotones.wav", 0.7f);
                temporadaActual = (temporadaActual + 1) % temporadas.size();
                indiceEquipo1 = 0;
                indiceEquipo2 = 0;
                labelEquipo1.setText(temporadas.get(temporadaActual).get(indiceEquipo1).getNombreEquipo());
                labelEquipo2.setText(temporadas.get(temporadaActual).get(indiceEquipo2).getNombreEquipo());
                // Actualiza los íconos de los equipos
                imagenEquipo1.setIcon(imagenesEquipos[temporadaActual][indiceEquipo1]);
                imagenEquipo2.setIcon(imagenesEquipos[temporadaActual][indiceEquipo2]);
            }
        });

        // Controles de la música
        musicManager.playMusic("Musica/Soundtrack/SelectorEquipos.wav", 0.7f);
    }

    /**
     * Main method for the com.penaltyeleven.pantallainicial.SelectorEquipos class.
     * It creates a new team selector interface.
     * @param args the command line arguments.
     * @throws IOException if there is an error reading an image file.
     */
    public static void main(String[] args) throws IOException {
        SelectorEquipos selectorEquipos = new SelectorEquipos();
        selectorEquipos.setVisible(true);
    }
}
