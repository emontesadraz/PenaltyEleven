import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class SelectorEquiposSolo extends JFrame {
    OperacionesEquipos oe = new OperacionesEquipos();
    MusicManager musicManager = new MusicManager();
    private ImageIcon[] imagenesEquipos = {new ImageIcon("src/Imagenes/EscudoRaimon.png"), new ImageIcon("src/Imagenes/EscudoZeus.png"), new ImageIcon("src/Imagenes/.png"), new ImageIcon("src/Imagenes/EscudoGenesis.png")
            , new ImageIcon("src/Imagenes/EscudoRoyal.png"), new ImageIcon("src/Imagenes/EscudoAlpino.png"), new ImageIcon("src/Imagenes/EscudoKirkwood.png"), new ImageIcon("src/Imagenes/EscudoOccult.png"), new ImageIcon("src/Imagenes/EscudoGigantes.png")
            , new ImageIcon("src/Imagenes/EscudoEpsilon.png"), new ImageIcon("src/Imagenes/EscudoOtaku.png"), new ImageIcon("src/Imagenes/EscudoFarm.png"), new ImageIcon("src/Imagenes/EscudoProminence.png"), new ImageIcon("src/Imagenes/EscudoCaos.png")};
    JButton seleccionarEqu1;
    JButton seleccionarEqu2;
    JButton jugar;
    JButton flechaIzquierda;
    JButton flechaDerecha;
    JButton back;
    JPanel panel;
    JButton flechaIzquierda2;
    JButton flechaDerecha2;
    BufferedImage imagen;
    JLabel labelEquipo1;
    JLabel labelEquipo2;
    int indiceEquipo1 = 0;
    int indiceEquipo2 = 0;
    boolean eq1 = false;
    boolean eq2 = false;
    private Clip musicClip;

    public SelectorEquiposSolo() {
        super("Penalty Eleven");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1280, 720);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);

        // Fuente y color de los botones
        Font fuenteBoton = new Font("Action Man", Font.BOLD, 15);
        Color colorBoton = new Color(209, 192, 9);
        Color colorTexto = new Color(4, 38, 193);

        // Panel
        panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(null);
        this.add(panel);

        // Cargar imagen de fondo
        try {
            imagen = ImageIO.read(new File("src/Imagenes/FondoSelectorEquipos.png")); // Ruta de la imagen de fondo
        } catch (IOException e) {
            e.printStackTrace();
        }

        // JLabel para el equipo 1
        labelEquipo1 = new JLabel(oe.getEquipos().get(indiceEquipo1).getNombreEquipo());
        labelEquipo1.setFont(new Font("Action Man", Font.BOLD, 20));
        labelEquipo1.setOpaque(false);
        labelEquipo1.setForeground(Color.BLACK);
        labelEquipo1.setBounds(150, 200, 200, 30);
        labelEquipo1.setHorizontalAlignment(JLabel.CENTER);
        panel.add(labelEquipo1);

        // JLabel para la imagen del equipo 1
        JLabel imagenEquipo1 = new JLabel(imagenesEquipos[indiceEquipo1]);
        imagenEquipo1.setBounds(150, 250, 200, 200);
        panel.add(imagenEquipo1);

        // JLabel para el equipo 2
        labelEquipo2 = new JLabel(oe.getEquipos().get(indiceEquipo2).getNombreEquipo());
        labelEquipo2.setFont(new Font("Action Man", Font.BOLD, 20));
        labelEquipo2.setOpaque(false);
        labelEquipo2.setForeground(Color.BLACK);
        labelEquipo2.setHorizontalAlignment(JLabel.CENTER);
        labelEquipo2.setBounds(950, 200, 200, 30);
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
                playSound("Musica/SonidoBotones.wav", 0.2f);
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
                playSound("Musica/SonidoBotones.wav", 0.2f);
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
        jugar.setBounds(500, 500, 200, 50);
        jugar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Reproducir sonido
                playSound("Musica/SonidoJugar.wav", 0.2f);
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
                playSound("Musica/SonidoAtras.wav", 0.2f);
                musicManager.stopMusic();
                dispose();
                MenuInicial menuInicial = new MenuInicial();
                menuInicial.setVisible(true);


            }
        });
        back.setBounds(500, 600, 200, 50);
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
                playSound("Musica/SonidoFlechas.wav", 0.2f);
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
                playSound("Musica/SonidoFlechas.wav", 0.2f);
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
                playSound("Musica/SonidoFlechas.wav", 0.2f);
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
                playSound("Musica/SonidoFlechas.wav", 0.2f);
                if (!eq1 && indiceEquipo1 < oe.getEquipos().size() - 1) {
                    indiceEquipo1++;
                    labelEquipo1.setText(oe.getEquipos().get(indiceEquipo1).getNombreEquipo());
                    imagenEquipo1.setIcon(imagenesEquipos[indiceEquipo1]);
                }
            }
        });
        panel.add(flechaDerecha2);
        // Controles de la música
        musicManager.playMusic("Musica/SelectorEquipos.wav", 0.6f);


    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // Dibujar la imagen de fondo en el JFrame
        if (imagen != null) {
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        }
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
