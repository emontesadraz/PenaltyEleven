package com.penaltyeleven.pantallainicial.multiplayer;

import com.penaltyeleven.metodosexternos.Equipos;
import com.penaltyeleven.metodosexternos.InterfazMaestra;
import com.penaltyeleven.metodosexternos.MusicManager;
import com.penaltyeleven.metodosexternos.OperacionesEquipos;
import com.penaltyeleven.pantallainicial.MenuInicial;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a team selector interface for a game.
 * It extends from the com.penaltyeleven.metodosexternos.InterfazMaestra class.
 */
public class SelectorEquipos extends InterfazMaestra {
    OperacionesEquipos oe = new OperacionesEquipos();
    private final MusicManager musicManager = new MusicManager();
    public static final Color colorBase = new Color(25, 25, 25);
    public static final Font fuente = new Font("Rubik", Font.PLAIN, 20);
    public static final Color colorTexto = new Color(255, 255, 255);
    private final BufferedImage[][] imagenesEquipos = {
            {
                    ImageIO.read(new File("src/Imagenes/Escudo/Raimon.png")),
                    ImageIO.read(new File("src/Imagenes/Escudo/Occult.png")),
                    ImageIO.read(new File("src/Imagenes/Escudo/Wild.png")),
                    ImageIO.read(new File("src/Imagenes/Escudo/Brain.png")),
                    ImageIO.read(new File("src/Imagenes/Escudo/Otaku.png")),
                    ImageIO.read(new File("src/Imagenes/Escudo/RoyalAcademy.png")),
                    ImageIO.read(new File("src/Imagenes/Escudo/Shuriken.png")),
                    ImageIO.read(new File("src/Imagenes/Escudo/Farm.png")),
                    ImageIO.read(new File("src/Imagenes/Escudo/Kirkwood.png")),
                    ImageIO.read(new File("src/Imagenes/Escudo/Zeus.png")),
            },
            {
                    ImageIO.read(new File("src/Imagenes/Escudo/Raimon2.png")),
                    ImageIO.read(new File("src/Imagenes/Escudo/Alpino.png")),
                    ImageIO.read(new File("src/Imagenes/Escudo/TormentaDeGeminis.png")),
                    ImageIO.read(new File("src/Imagenes/Escudo/RoyalRedux.png")),
                    ImageIO.read(new File("src/Imagenes/Escudo/Epsilon.png")),
                    ImageIO.read(new File("src/Imagenes/Escudo/Prominence.png")),
                    ImageIO.read(new File("src/Imagenes/Escudo/PolvoDiamante.png")),
                    ImageIO.read(new File("src/Imagenes/Escudo/Caos.png")),
                    ImageIO.read(new File("src/Imagenes/Escudo/Genesis.png")),
                    ImageIO.read(new File("src/Imagenes/Escudo/EmperadoresOscuros.png")),
            },
            {
                    ImageIO.read(new File("src/Imagenes/Escudo/InazumaJapon.png")),
                    ImageIO.read(new File("src/imagenes/Escudo/NeoJapon.png")),
                    ImageIO.read(new File("src/Imagenes/Escudo/DragonesDeFuego.png")),
                    ImageIO.read(new File("src/Imagenes/Escudo/KnightsOfQueen.png")),
                    ImageIO.read(new File("src/Imagenes/Escudo/Emperadores.png")),
                    ImageIO.read(new File("src/Imagenes/Escudo/Unicorn.png")),
                    ImageIO.read(new File("src/Imagenes/Escudo/LosRojos.png")),
                    ImageIO.read(new File("src/Imagenes/Escudo/Orfeo.png")),
                    ImageIO.read(new File("src/Imagenes/Escudo/OsReis.png")),
                    ImageIO.read(new File("src/Imagenes/Escudo/LittleGiants.png")),
            }
    };
    private boolean equipo1Seleccionado = false;
    private boolean equipo2Seleccionado = false;
    private Equipos equipoSeleccionado1;
    private BufferedImage escudoEquipoSeleccionado1;
    private Equipos equipoSeleccionado2;
    private BufferedImage escudoEquipoSeleccionado2;
    private JPanel panel;
    private JLabel labelEquipo1;
    private JLabel labelEquipo2;
    private JLabel temporadaEquipo1Label;
    private JLabel temporadaEquipo2Label;
    int indiceEquipo1 = 0;
    int indiceEquipo2 = 0;
    int temporadaActual1 = 0;
    int temporadaActual2 = 0;
    boolean eq1 = false;
    boolean eq2 = false;
    List<List<Equipos>> temporadas;

    /**
     * Constructor for the com.penaltyeleven.pantallainicial.SelectorEquipos class.
     * It initializes the team selector interface.
     *
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
        labelEquipo1 = new JLabel(temporadas.get(temporadaActual1).get(indiceEquipo1).getNombreEquipo());
        labelEquipo1.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
        labelEquipo1.setOpaque(true);
        labelEquipo1.setForeground(colorBase);
        labelEquipo1.setBackground(Color.WHITE);
        labelEquipo1.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        labelEquipo1.setBounds(80, 190, 340, 45);
        labelEquipo1.setHorizontalAlignment(JLabel.CENTER);

        ImageLabel imagenEquipo1 = new ImageLabel(imagenesEquipos[indiceEquipo1][temporadaActual1]);
        imagenEquipo1.setBounds(150, 270, 200, 200);

        // JLabel para el equipo 2
        labelEquipo2 = new JLabel(temporadas.get(temporadaActual2).get(indiceEquipo2).getNombreEquipo());
        labelEquipo2.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
        labelEquipo2.setOpaque(true);
        labelEquipo2.setForeground(colorBase);
        labelEquipo2.setBackground(Color.WHITE);
        labelEquipo2.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        labelEquipo2.setBounds(880, 190, 340, 45);
        labelEquipo2.setHorizontalAlignment(JLabel.CENTER);

        // JLabel para la imagen del equipo 2
        ImageLabel imagenEquipo2 = new ImageLabel(imagenesEquipos[indiceEquipo2][temporadaActual2]);
        imagenEquipo2.setBounds(950, 270, 200, 200);

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
        JButton seleccionarTemporada1 = new JButton();
        JButton seleccionarTemporada2 = new JButton();


        // Crear botones
        crearBoton(seleccionarEqu1, "Seleccionar", 150, 50, 200, 50, colorBase, colorTexto, fuente, "Musica/SoundEffect/SonidoSeleccion.wav", 0.6f);
        crearBoton(seleccionarEqu2, "Seleccionar", 950, 50, 200, 50, colorBase, colorTexto, fuente, "Musica/SoundEffect/SonidoSeleccion.wav", 0.6f);
        crearBoton(jugar, "Jugar", 550, 500, 200, 50, colorBase, colorTexto, fuente, "Musica/SoundEffect/SonidoSeleccion.wav", 0.6f);
        crearBoton(atras, "Atrás", 550, 600, 200, 50, colorBase, colorTexto, fuente, "Musica/SoundEffect/SonidoSeleccion.wav", 0.6f);
        crearBoton(flechaIzquierda, "<", 100, 500, 50, 50, colorBase, colorTexto, fuente, "Musica/SoundEffect/SonidoSeleccion.wav", 0.6f);
        crearBoton(flechaDerecha, ">", 350, 500, 50, 50, colorBase, colorTexto, fuente, "Musica/SoundEffect/SonidoSeleccion.wav", 0.6f);
        crearBoton(flechaIzquierda2, "<", 900, 510, 50, 50, colorBase, colorTexto, fuente, "Musica/SoundEffect/SonidoSeleccion.wav", 0.6f);
        crearBoton(flechaDerecha2, ">", 1150, 510, 50, 50, colorBase, colorTexto, fuente, "Musica/SoundEffect/SonidoSeleccion.wav", 0.6f);
        crearBoton(seleccionarTemporada1, "Cambiar Temporada", 100, 585, 300, 45, colorBase, colorTexto, fuente, "Musica/SoundEffect/SonidoSeleccion.wav", 0.6f);
        crearBoton(seleccionarTemporada2, "Cambiar Temporada", 900, 585, 300, 45, colorBase, colorTexto, fuente, "Musica/SoundEffect/SonidoSeleccion.wav", 0.6f);

        // Asignar actions listeners para los botones de flechas y temporadas
        flechaIzquierda.addActionListener(e -> {
            musicManager.playSound("Musica/SoundEffect/SonidoFlechas.wav", 0.7f);
            cambiarEquipo(labelEquipo1, imagenEquipo1, -1, true);
        });
        flechaDerecha.addActionListener(e -> {
            musicManager.playSound("Musica/SoundEffect/SonidoFlechas.wav", 0.7f);
            cambiarEquipo(labelEquipo1, imagenEquipo1, 1, true);
        });
        flechaIzquierda2.addActionListener(e -> {
            musicManager.playSound("Musica/SoundEffect/SonidoFlechas.wav", 0.7f);
            cambiarEquipo(labelEquipo2, imagenEquipo2, -1, false);
        });
        flechaDerecha2.addActionListener(e -> {
            musicManager.playSound("Musica/SoundEffect/SonidoFlechas.wav", 0.7f);
            cambiarEquipo(labelEquipo2, imagenEquipo2, 1, false);
        });
        seleccionarTemporada1.addActionListener(e -> {
            musicManager.playSound("Musica/SoundEffect/SonidoPagina.wav", 0.7f);
            cambiarTemporada(labelEquipo1, imagenEquipo1, true);
            // Actualizar el JLabel después de cambiar la temporada
            temporadaEquipo1Label.setText("Temporada " + (temporadaActual1 + 1));
        });

        seleccionarTemporada2.addActionListener(e -> {
            musicManager.playSound("Musica/SoundEffect/SonidoPagina.wav", 0.7f);
            cambiarTemporada(labelEquipo2, imagenEquipo2, false);
            // Actualizar el JLabel después de cambiar la temporada
            temporadaEquipo2Label.setText("Temporada " + (temporadaActual2 + 1));
        });

// Inicializar los JLabels en el constructor
        temporadaEquipo1Label = new JLabel("Temporada " + (temporadaActual1 + 1));
        temporadaEquipo1Label.setBounds(130, 145, 240, 40);
        temporadaEquipo1Label.setBackground(Color.WHITE);
        temporadaEquipo1Label.setOpaque(true);
        temporadaEquipo1Label.setBorder(BorderFactory.createLineBorder(colorBase, 3));
        temporadaEquipo1Label.setHorizontalAlignment(JLabel.CENTER);
        temporadaEquipo1Label.setForeground(colorBase);
        temporadaEquipo1Label.setFont(new Font("Rubik", Font.PLAIN, 25));

        temporadaEquipo2Label = new JLabel("Temporada " + (temporadaActual2 + 1));
        temporadaEquipo2Label.setBounds(930, 145, 240, 40);
        temporadaEquipo2Label.setBackground(Color.WHITE);
        temporadaEquipo2Label.setOpaque(true);
        temporadaEquipo2Label.setBorder(BorderFactory.createLineBorder(colorBase, 3));
        temporadaEquipo2Label.setHorizontalAlignment(JLabel.CENTER);
        temporadaEquipo2Label.setForeground(colorBase);
        temporadaEquipo2Label.setFont(new Font("Rubik", Font.PLAIN, 25));

// Actualizar el texto de los JLabels en los oyentes de acción
        seleccionarTemporada1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Actualizar el JLabel
                temporadaEquipo1Label.setText("Temporada " + (temporadaActual1 + 1));
            }
        });

        seleccionarTemporada2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Actualizar el JLabel
                temporadaEquipo2Label.setText("Temporada " + (temporadaActual2 + 1));
            }
        });

        // Seleccionar equipo 1
        seleccionarEqu1.addActionListener(e -> {
            if (!equipo1Seleccionado) {
                musicManager.playSound("Musica/SoundEffect/SonidoElegir1.wav", 0.7f);
                eq1 = true;
                equipoSeleccionado1 = temporadas.get(temporadaActual1).get(indiceEquipo1);
                escudoEquipoSeleccionado1 = imagenesEquipos[temporadaActual1][indiceEquipo1];
                labelEquipo1.setBackground(Color.GREEN);
                equipo1Seleccionado = true;
                seleccionarEqu1.setText("Seleccionado");
                flechaIzquierda.setEnabled(false);
                flechaDerecha.setEnabled(false);
                seleccionarTemporada1.setEnabled(false);
                if (eq2) {
                    jugar.setEnabled(true);
                }
            } else {
                musicManager.playSound("Musica/SoundEffect/SonidoElegir1.wav", 0.7f);
                eq1 = false;
                equipoSeleccionado1 = null;
                escudoEquipoSeleccionado1 = null;
                labelEquipo1.setBackground(Color.WHITE);
                equipo1Seleccionado = false;
                seleccionarEqu1.setText("Seleccionar");
                flechaIzquierda.setEnabled(true);
                flechaDerecha.setEnabled(true);
                seleccionarTemporada1.setEnabled(true);
                jugar.setEnabled(false);
            }
        });

// Seleccionar equipo 2
        seleccionarEqu2.addActionListener(e -> {
            if (!equipo2Seleccionado) {
                musicManager.playSound("Musica/SoundEffect/SonidoElegir1.wav", 0.7f);
                eq2 = true;
                equipoSeleccionado2 = temporadas.get(temporadaActual2).get(indiceEquipo2);
                escudoEquipoSeleccionado2 = imagenesEquipos[temporadaActual2][indiceEquipo2];
                labelEquipo2.setBackground(Color.GREEN);
                equipo2Seleccionado = true;
                seleccionarEqu2.setText("Seleccionado");
                flechaIzquierda2.setEnabled(false);
                flechaDerecha2.setEnabled(false);
                seleccionarTemporada2.setEnabled(false);
                if (eq1) {
                    jugar.setEnabled(true);
                }
            } else {
                musicManager.playSound("Musica/SoundEffect/SonidoElegir1.wav", 0.7f);
                eq2 = false;
                equipoSeleccionado2 = null;
                escudoEquipoSeleccionado2 = null;
                labelEquipo2.setBackground(Color.WHITE);
                equipo2Seleccionado = false;
                seleccionarEqu2.setText("Seleccionar");
                flechaIzquierda2.setEnabled(true);
                flechaDerecha2.setEnabled(true);
                seleccionarTemporada2.setEnabled(true);
                jugar.setEnabled(false);
            }
        });


        // Jugar
        jugar.addActionListener(e -> {
            if (eq1 && eq2) {
                musicManager.playSound("Musica/SoundEffect/SonidoJugar.wav", 0.7f);
                musicManager.stopMusic();
                JuegoMultiplayer juegoMultiplayer = new JuegoMultiplayer(equipoSeleccionado1, escudoEquipoSeleccionado1, equipoSeleccionado2, escudoEquipoSeleccionado2);
                juegoMultiplayer.setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "No se puede jugar hasta que ambos equipos estén seleccionados", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        // Inicialmente, el botón de jugar está desactivado
        jugar.setEnabled(false);

        // Atrás
        atras.addActionListener(e -> {
            musicManager.playSound("Musica/SoundEffect/SonidoAtras.wav", 0.7f);
            musicManager.stopMusic();
            MenuInicial menuInicial = new MenuInicial();
            menuInicial.setVisible(true);
            dispose();
        });

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
        panel.add(seleccionarTemporada1);
        panel.add(seleccionarTemporada2);

        // Añadir labels al panel
        panel.add(temporadaEquipo1Label);
        panel.add(temporadaEquipo2Label);
        panel.add(labelEquipo1);
        panel.add(labelEquipo2);
        panel.add(imagenEquipo1);
        panel.add(imagenEquipo2);
        panel.add(versus);

        // Añadir fondo al panel
        panel.add(fondo);

        // Añadir panel al JFrame
        add(panel);

        // Controles de la música
        musicManager.playMusic("Musica/Soundtrack/SelectorEquiposMultiPlayer.wav", 0.5f);

    }

    /**
     * Cambia el equipo mostrado en el JLabel y la imagen correspondiente.
     *
     * @param label El JLabel del equipo a cambiar.
     * @param imagen El ImageLabel de la imagen del equipo a cambiar.
     * @param cambio El cambio en el índice del equipo (-1 para anterior, 1 para siguiente).
     * @param esEquipo1 Si es el equipo 1 (true) o el equipo 2 (false).
     */
    private void cambiarEquipo(JLabel label, ImageLabel imagen, int cambio, boolean esEquipo1) {
        if (esEquipo1) {
            indiceEquipo1 = (indiceEquipo1 + cambio + temporadas.get(temporadaActual1).size()) % temporadas.get(temporadaActual1).size();
            label.setText(temporadas.get(temporadaActual1).get(indiceEquipo1).getNombreEquipo());
            imagen.updateImage(imagenesEquipos[temporadaActual1][indiceEquipo1]);
        } else {
            indiceEquipo2 = (indiceEquipo2 + cambio + temporadas.get(temporadaActual2).size()) % temporadas.get(temporadaActual2).size();
            label.setText(temporadas.get(temporadaActual2).get(indiceEquipo2).getNombreEquipo());
            imagen.updateImage(imagenesEquipos[temporadaActual2][indiceEquipo2]);
        }
    }

    /**
     * Cambia la temporada del equipo mostrado en el JLabel y la imagen correspondiente.
     *
     * @param label El JLabel del equipo a cambiar.
     * @param imagen El ImageLabel de la imagen del equipo a cambiar.
     * @param esEquipo1 Si es el equipo 1 (true) o el equipo 2 (false).
     */
    private void cambiarTemporada(JLabel label, ImageLabel imagen, boolean esEquipo1) {
        if (esEquipo1) {
            temporadaActual1 = (temporadaActual1 + 1) % imagenesEquipos.length;
            indiceEquipo1 = 0; // Resetear al primer equipo de la nueva temporada
            label.setText(temporadas.get(temporadaActual1).get(indiceEquipo1).getNombreEquipo());
            imagen.updateImage(imagenesEquipos[temporadaActual1][indiceEquipo1]);
        } else {
            temporadaActual2 = (temporadaActual2 + 1) % imagenesEquipos.length;
            indiceEquipo2 = 0; // Resetear al primer equipo de la nueva temporada
            label.setText(temporadas.get(temporadaActual2).get(indiceEquipo2).getNombreEquipo());
            imagen.updateImage(imagenesEquipos[temporadaActual2][indiceEquipo2]);
        }
    }

    /**
     * Clase para mostrar una imagen en un JLabel.
     */
    public class ImageLabel extends JLabel {
        private BufferedImage image;

        public ImageLabel(BufferedImage image) {
            this.image = scaleImage(image, 200, 200);
        }

        public void updateImage(BufferedImage newImage) {
            this.image = scaleImage(newImage, 200, 200);
            this.repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (image != null) {
                g.drawImage(image, 0, 0, this);
            }
        }
    }

    public BufferedImage scaleImage(BufferedImage source, int width, int height) {
        Image tmp = source.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage scaled = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = scaled.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return scaled;
    }

    /**
     * Main method to run the SelectorEquipos class.
     *
     * @param args Command line arguments (not used).
     * @throws IOException if there is an error reading an image file.
     */
    public static void main(String[] args) throws IOException {
        new SelectorEquipos();
    }
}