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
    int indiceEquipo1 = 0;
    int indiceEquipo2 = 0;
    int temporadaActual = 0;
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
        labelEquipo1 = new JLabel(temporadas.get(temporadaActual).get(indiceEquipo1).getNombreEquipo());
        labelEquipo1.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
        labelEquipo1.setOpaque(true);
        labelEquipo1.setForeground(colorBase);
        labelEquipo1.setBackground(Color.WHITE);
        labelEquipo1.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        labelEquipo1.setBounds(80, 170, 340, 45);
        labelEquipo1.setHorizontalAlignment(JLabel.CENTER);

        ImageLabel imagenEquipo1 = new ImageLabel(imagenesEquipos[indiceEquipo1][temporadaActual]);
        imagenEquipo1.setBounds(150, 250, 200, 200);

        // JLabel para el equipo 2
        labelEquipo2 = new JLabel(temporadas.get(temporadaActual).get(indiceEquipo2).getNombreEquipo());
        labelEquipo2.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
        labelEquipo2.setOpaque(true);
        labelEquipo2.setForeground(colorBase);
        labelEquipo2.setBackground(Color.WHITE);
        labelEquipo2.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        labelEquipo2.setBounds(880, 170, 340, 45);
        labelEquipo2.setHorizontalAlignment(JLabel.CENTER);

        // JLabel para la imagen del equipo 2
        ImageLabel imagenEquipo2 = new ImageLabel(imagenesEquipos[indiceEquipo2][temporadaActual]);
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
        JButton seleccionarTemporada1 = new JButton();
        JButton seleccionarTemporada2 = new JButton();


        // Crear botones
        crearBoton(seleccionarEqu1, "Seleccionar", 150, 60, 200, 50, colorBase, colorTexto, fuente, "Musica/SoundEffect/SonidoSeleccion.wav", 0.6f);
        crearBoton(seleccionarEqu2, "Seleccionar", 950, 60, 200, 50, colorBase, colorTexto, fuente, "Musica/SoundEffect/SonidoSeleccion.wav", 0.6f);
        crearBoton(jugar, "Jugar", 550, 500, 200, 50, colorBase, colorTexto, fuente, "Musica/SoundEffect/SonidoSeleccion.wav", 0.6f);
        crearBoton(atras, "Atrás", 550, 600, 200, 50, colorBase, colorTexto, fuente, "Musica/SoundEffect/SonidoSeleccion.wav", 0.6f);
        crearBoton(flechaIzquierda, "<", 900, 500, 50, 50, colorBase, colorTexto, fuente, "Musica/SoundEffect/SonidoSeleccion.wav", 0.6f);
        crearBoton(flechaDerecha, ">", 1150, 500, 50, 50, colorBase, colorTexto, fuente, "Musica/SoundEffect/SonidoSeleccion.wav", 0.6f);
        crearBoton(flechaIzquierda2, "<", 100, 500, 50, 50, colorBase, colorTexto, fuente, "Musica/SoundEffect/SonidoSeleccion.wav", 0.6f);
        crearBoton(flechaDerecha2, ">", 350, 500, 50, 50, colorBase, colorTexto, fuente, "Musica/SoundEffect/SonidoSeleccion.wav", 0.6f);
        crearBoton(seleccionarTemporada1, "Cambiar Temporada", 100, 580, 300, 40, colorBase, colorTexto, fuente, "Musica/SoundEffect/SonidoSeleccion.wav", 0.6f);
        crearBoton(seleccionarTemporada2, "Cambiar Temporada", 900, 580, 300, 40, colorBase, colorTexto, fuente, "Musica/SoundEffect/SonidoSeleccion.wav", 0.6f);

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
                    equipoSeleccionado1 = temporadas.get(temporadaActual).get(indiceEquipo1);
                    escudoEquipoSeleccionado1 = imagenesEquipos[temporadaActual][indiceEquipo1];
                } else {
                    seleccionarEqu1.setText("Seleccionar");
                    equipoSeleccionado1 = null;
                    escudoEquipoSeleccionado1 = null;
                }
                equipo1Seleccionado = !equipo1Seleccionado;
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
                    equipoSeleccionado2 = temporadas.get(temporadaActual).get(indiceEquipo2);
                    escudoEquipoSeleccionado2 = imagenesEquipos[temporadaActual][indiceEquipo2];
                } else {
                    seleccionarEqu2.setText("Seleccionar");
                    equipoSeleccionado2 = null;
                    escudoEquipoSeleccionado2 = null;
                }
                equipo2Seleccionado = !equipo2Seleccionado;
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
                    juegoMultiplayer = new JuegoMultiplayer(equipoSeleccionado1, escudoEquipoSeleccionado1, equipoSeleccionado2, escudoEquipoSeleccionado2);
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
                        imagenEquipo2.image = scaleImage(imagenesEquipos[temporadaActual][indiceEquipo2], 200, 200);
                        imagenEquipo2.repaint();
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
                        imagenEquipo2.image = scaleImage(imagenesEquipos[temporadaActual][indiceEquipo2], 200, 200);
                        imagenEquipo2.repaint();
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
                        imagenEquipo1.image = scaleImage(imagenesEquipos[temporadaActual][indiceEquipo1], 200, 200);
                        imagenEquipo1.repaint();
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
                        imagenEquipo1.image = scaleImage(imagenesEquipos[temporadaActual][indiceEquipo1], 200, 200);
                        imagenEquipo1.repaint();
                    }
                }
            }
        });

        // Accion del boton seleccionarTemporada
        seleccionarTemporada1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!equipo1Seleccionado) {
                    musicManager.playSound("Musica/SoundEffect/SonidoBotones.wav", 0.7f);
                    temporadaActual = (temporadaActual + 1) % temporadas.size();
                    indiceEquipo1 = 0;
                    labelEquipo1.setText(temporadas.get(temporadaActual).get(indiceEquipo1).getNombreEquipo());
                    // Actualiza los íconos de los equipos
                    imagenEquipo1.image = scaleImage(imagenesEquipos[temporadaActual][indiceEquipo1], 200, 200);
                    imagenEquipo1.repaint();
                }
            }
        });
        // Accion del boton seleccionarTemporada2
        seleccionarTemporada2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!equipo2Seleccionado) {
                    musicManager.playSound("Musica/SoundEffect/SonidoBotones.wav", 0.7f);
                    temporadaActual = (temporadaActual + 1) % temporadas.size();
                    indiceEquipo2 = 0;
                    labelEquipo2.setText(temporadas.get(temporadaActual).get(indiceEquipo2).getNombreEquipo());
                    // Actualiza los íconos de los equipos
                    imagenEquipo2.image = scaleImage(imagenesEquipos[temporadaActual][indiceEquipo2], 200, 200);
                    imagenEquipo2.repaint();
                }
            }
        });

        // Controles de la música
        musicManager.playMusic("Musica/Soundtrack/SelectorEquipos.wav", 0.7f);
    }

    /**
     * Scales an image to the specified width and height.
     *
     * @param source the image to scale.
     * @param width the width of the scaled image.
     * @param height the height of the scaled image.
     * @return the scaled image.
     */
    public BufferedImage scaleImage(BufferedImage source, int width, int height) {
        Image tmp = source.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage scaled = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = scaled.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return scaled;
    }

    /**
     * Clase para mostrar una imagen en un JLabel.
     */
    public class ImageLabel extends JLabel {
        private BufferedImage image;

        public ImageLabel(BufferedImage image) {
            this.image = image;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Calcula la posición x e y para centrar la imagen
            int x = (this.getWidth() - image.getWidth()) / 2;
            int y = (this.getHeight() - image.getHeight()) / 2;
            g.drawImage(image, x, y, this);
        }
    }
}
