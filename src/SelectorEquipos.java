import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.awt.image.BufferedImage;

public class SelectorEquipos extends InterfazMaestra {
    OperacionesEquipos oe = new OperacionesEquipos();
    MusicManager musicManager = new MusicManager();
    private final ImageIcon[] imagenesEquipos = {new ImageIcon("src/Imagenes/Escudo/EscudoRaimon.png"), new ImageIcon("src/Imagenes/Escudo/EscudoZeus.png"), new ImageIcon("src/Imagenes/Escudo/EscudoGenesis.png")
            , new ImageIcon("src/Imagenes/Escudo/EscudoRoyal.png"), new ImageIcon("src/Imagenes/Escudo/EscudoAlpino.png"), new ImageIcon("src/Imagenes/Escudo/EscudoKirkwood.png"), new ImageIcon("src/Imagenes/Escudo/EscudoOccult.png"), new ImageIcon("src/Imagenes/Escudo/EscudoLittleGiants.png")
            , new ImageIcon("src/Imagenes/Escudo/EscudoEpsilon.png"), new ImageIcon("src/Imagenes/Escudo/EscudoOtaku.png"), new ImageIcon("src/Imagenes/Escudo/EscudoFarm.png"), new ImageIcon("src/Imagenes/Escudo/EscudoCaos.png")};
    JButton seleccionarEqu1;
    JButton seleccionarEqu2;
    JButton jugar;
    JButton atras;
    JButton flechaIzquierda;
    JButton flechaDerecha;
    JButton flechaIzquierda2;
    JButton flechaDerecha2;
    JButton fondo;
    JPanel panel;
    JLabel labelEquipo1;
    JLabel labelEquipo2;
    int indiceEquipo1 = 0;
    int indiceEquipo2 = 0;
    boolean eq1 = false;
    boolean eq2 = false;

    public SelectorEquipos() throws IOException {
        setTitle("Penalty Eleven");
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
        add(panel);

        // JLabel para el equipo 1
        labelEquipo1 = new JLabel(oe.getEquipos().get(indiceEquipo1).getNombreEquipo());
        labelEquipo1.setFont(new Font("Action Man", Font.BOLD, 30));
        labelEquipo1.setOpaque(false);
        labelEquipo1.setForeground(Color.BLACK);
        labelEquipo1.setBounds(100, 200, 300, 40);
        labelEquipo1.setHorizontalAlignment(JLabel.CENTER);

        // JLabel para la imagen del equipo 1
        JLabel imagenEquipo1 = new JLabel(imagenesEquipos[indiceEquipo1]);
        imagenEquipo1.setBounds(150, 250, 200, 200);

        // JLabel para el equipo 2
        labelEquipo2 = new JLabel(oe.getEquipos().get(indiceEquipo2).getNombreEquipo());
        labelEquipo2.setFont(new Font("Action Man", Font.BOLD, 30));
        labelEquipo2.setOpaque(false);
        labelEquipo2.setForeground(Color.BLACK);
        labelEquipo2.setHorizontalAlignment(JLabel.CENTER);
        labelEquipo2.setBounds(900, 200, 300, 40);

        // JLabel para la imagen del equipo 2
        JLabel imagenEquipo2 = new JLabel(imagenesEquipos[indiceEquipo2]);
        imagenEquipo2.setBounds(950, 250, 200, 200);

        //JLabel imagen versus
        BufferedImage vs = ImageIO.read(new File("src/Imagenes/Foto/versus.png"));
        JLabel versus = new JLabel();
        versus.setIcon(new ImageIcon(vs.getScaledInstance(400,400, Image.SCALE_DEFAULT)));
        versus.setBounds(450, 120, 400, 400);
        versus.setBorder(null);

        // Botón seleccionar para el equipo 1
        seleccionarEqu1 = new JButton("Seleccionar");
        seleccionarEqu1.setFont(fuenteBoton);
        seleccionarEqu1.setBackground(colorBoton);
        seleccionarEqu1.setForeground(colorTexto);
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
        seleccionarEqu1.setBounds(150, 100, 200, 50);

        // Botón seleccionar para el equipo 2
        seleccionarEqu2 = new JButton("Seleccionar");
        seleccionarEqu2.setFont(fuenteBoton);
        seleccionarEqu2.setBackground(colorBoton);
        seleccionarEqu2.setForeground(colorTexto);
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
        seleccionarEqu2.setBounds(950, 100, 200, 50);

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
                musicManager.playSound("Musica/SoundEffect/SonidoJugar.wav", 0.7f);
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

        // Botón atrás
        atras = new JButton("Atrás");
        atras.setFont(fuenteBoton);
        atras.setBackground(colorBoton);
        atras.setForeground(colorTexto);
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
        atras.setBounds(550, 600, 200, 50);

        // Botón flecha izquierda
        flechaIzquierda = new JButton("<");
        flechaIzquierda.setFont(fuenteBoton);
        flechaIzquierda.setBackground(colorBoton);
        flechaIzquierda.setForeground(colorTexto);
        flechaIzquierda.setBounds(900, 500, 50, 50);
        flechaIzquierda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                musicManager.playSound("Musica/SoundEffect/SonidoFlechas.wav", 0.7f);
                if (!eq2 && indiceEquipo2 > 0) {
                    indiceEquipo2--;
                    labelEquipo2.setText(oe.getEquipos().get(indiceEquipo2).getNombreEquipo());
                    imagenEquipo2.setIcon(imagenesEquipos[indiceEquipo2]);
                }
            }
        });

        // Botón flecha derecha
        flechaDerecha = new JButton(">");
        flechaDerecha.setFont(fuenteBoton);
        flechaDerecha.setBackground(colorBoton);
        flechaDerecha.setForeground(colorTexto);
        flechaDerecha.setBounds(1150, 500, 50, 50);
        flechaDerecha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                musicManager.playSound("Musica/SoundEffect/SonidoFlechas.wav", 0.7f);
                if (!eq2 && indiceEquipo2 < oe.getEquipos().size() - 1) {
                    indiceEquipo2++;
                    labelEquipo2.setText(oe.getEquipos().get(indiceEquipo2).getNombreEquipo());
                    imagenEquipo2.setIcon(imagenesEquipos[indiceEquipo2]);
                }
            }
        });

        // Botón flecha izquierda 2
        flechaIzquierda2 = new JButton("<");
        flechaIzquierda2.setFont(fuenteBoton);
        flechaIzquierda2.setBackground(colorBoton);
        flechaIzquierda2.setForeground(colorTexto);
        flechaIzquierda2.setBounds(100, 500, 50, 50);
        flechaIzquierda2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                musicManager.playSound("Musica/SoundEffect/SonidoFlechas.wav", 0.7f);
                if (!eq1 && indiceEquipo1 > 0) {
                    indiceEquipo1--;
                    labelEquipo1.setText(oe.getEquipos().get(indiceEquipo1).getNombreEquipo());
                    imagenEquipo1.setIcon(imagenesEquipos[indiceEquipo1]);
                }
            }
        });

        // Botón flecha derecha 2
        flechaDerecha2 = new JButton(">");
        flechaDerecha2.setFont(fuenteBoton);
        flechaDerecha2.setBackground(colorBoton);
        flechaDerecha2.setForeground(colorTexto);
        flechaDerecha2.setBounds(350, 500, 50, 50);
        flechaDerecha2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                musicManager.playSound("Musica/SoundEffect/SonidoFlechas.wav", 0.7f);
                if (!eq1 && indiceEquipo1 < oe.getEquipos().size() - 1) {
                    indiceEquipo1++;
                    labelEquipo1.setText(oe.getEquipos().get(indiceEquipo1).getNombreEquipo());
                    imagenEquipo1.setIcon(imagenesEquipos[indiceEquipo1]);
                }
            }
        });

        //Fondo
        fondo = new JButton();
        crearFondo(fondo,"Imagenes/Fondo/SelectorEquipos.jpg");

        //Añadir botones al panel
        panel.add(seleccionarEqu1);
        panel.add(seleccionarEqu2);
        panel.add(jugar);
        panel.add(atras);
        panel.add(flechaIzquierda);
        panel.add(flechaDerecha);
        panel.add(flechaIzquierda2);
        panel.add(flechaDerecha2);
        panel.add(labelEquipo1);
        panel.add(labelEquipo2);
        panel.add(imagenEquipo1);
        panel.add(imagenEquipo2);
        panel.add(versus);
        panel.add(fondo);

        // Controles de la música
        musicManager.playMusic("Musica/Soundtrack/SelectorEquipos.wav", 0.7f);
    }
}
