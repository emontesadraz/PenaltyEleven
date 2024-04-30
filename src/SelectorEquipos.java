import javax.imageio.ImageIO;
import javax.print.attribute.standard.Media;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;


public class SelectorEquipos extends JFrame{
    OperacionesEquipos oe = new OperacionesEquipos();
    JLabel[] equipos = new JLabel[14];
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

    public SelectorEquipos(){
        super("Penalty Eleven");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);

        // Fuente y color de los botones
        Font fuenteBoton = new Font("Action Man", Font.BOLD, 15);
        Color colorBoton = new Color(209, 192, 9);
        Color colorTexto = new Color(4, 38, 193);

        // Panel
        panel = new JPanel();
        panel.setLayout(null);
        this.add(panel);

        // Cargar imagen de fondo
        try {
            imagen = ImageIO.read(new File("src/Imagenes/FondoSelectorEquipos.jpeg")); // Ruta de la imagen de fondo
        } catch (IOException e) {
            e.printStackTrace();
        }

        // JLabel para el equipo 1
        labelEquipo1 = new JLabel(oe.getEquipos().get(indiceEquipo1).getNombreEquipo());
        labelEquipo1.setFont(new Font("Action Man", Font.BOLD, 20));
        labelEquipo1.setBounds(50, 110, 200, 30);
        labelEquipo1.setHorizontalAlignment(JLabel.CENTER);
        panel.add(labelEquipo1);

        // JLabel para el equipo 2
        labelEquipo2 = new JLabel(oe.getEquipos().get(indiceEquipo2).getNombreEquipo());
        labelEquipo2.setFont(new Font("Action Man", Font.BOLD, 20));
        labelEquipo2.setHorizontalAlignment(JLabel.CENTER);
        labelEquipo2.setBounds(550, 110, 200, 30);
        panel.add(labelEquipo2);

        // Botón seleccionar para el equipo 1
        seleccionarEqu1 = new JButton("Seleccionar");
        seleccionarEqu1.setFont(fuenteBoton);
        seleccionarEqu1.setBackground(colorBoton);
        seleccionarEqu1.setForeground(colorTexto);
        seleccionarEqu1.setBounds(50, 50, 200, 50);
        panel.add(seleccionarEqu1);

        // Botón seleccionar para el equipo 2
        seleccionarEqu2 = new JButton("Seleccionar");
        seleccionarEqu2.setFont(fuenteBoton);
        seleccionarEqu2.setBackground(colorBoton);
        seleccionarEqu2.setForeground(colorTexto);
        seleccionarEqu2.setBounds(550, 50, 200, 50);
        panel.add(seleccionarEqu2);

        // Botón jugar
        jugar = new JButton("Jugar");
        jugar.setFont(fuenteBoton);
        jugar.setBackground(colorBoton);
        jugar.setForeground(colorTexto);
        jugar.setBounds(300, 450, 200, 50);
        panel.add(jugar);

        // Botón atrás
        back = new JButton("Atrás");
        back.setFont(fuenteBoton);
        back.setBackground(colorBoton);
        back.setForeground(colorTexto);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        back.setBounds(300, 500, 200, 50);
        panel.add(back);

        // Botón flecha izquierda
        flechaIzquierda = new JButton("<");
        flechaIzquierda.setFont(fuenteBoton);
        flechaIzquierda.setBackground(colorBoton);
        flechaIzquierda.setForeground(colorTexto);
        flechaIzquierda.setBounds(600, 350, 50, 50);
        flechaIzquierda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (indiceEquipo2 > 0) {
                    indiceEquipo2--;
                    labelEquipo2.setText(oe.getEquipos().get(indiceEquipo2).getNombreEquipo());
                }
            }
        });
        panel.add(flechaIzquierda);

        // Botón flecha derecha
        flechaDerecha = new JButton(">");
        flechaDerecha.setFont(fuenteBoton);
        flechaDerecha.setBackground(colorBoton);
        flechaDerecha.setForeground(colorTexto);
        flechaDerecha.setBounds(650, 350, 50, 50);
        flechaDerecha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (indiceEquipo2 < oe.getEquipos().size() - 1) {
                    indiceEquipo2++;
                    labelEquipo2.setText(oe.getEquipos().get(indiceEquipo2).getNombreEquipo());
                }
            }
        });
        panel.add(flechaDerecha);

        // Botón flecha izquierda 2
        flechaIzquierda2 = new JButton("<");
        flechaIzquierda2.setFont(fuenteBoton);
        flechaIzquierda2.setBackground(colorBoton);
        flechaIzquierda2.setForeground(colorTexto);
        flechaIzquierda2.setBounds(100, 350, 50, 50);
        flechaIzquierda2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (indiceEquipo1 > 0) {
                    indiceEquipo1--;
                    labelEquipo1.setText(oe.getEquipos().get(indiceEquipo1).getNombreEquipo());
                }
            }
        });
        panel.add(flechaIzquierda2);

        // Botón flecha derecha 2
        flechaDerecha2 = new JButton(">");
        flechaDerecha2.setFont(fuenteBoton);
        flechaDerecha2.setBackground(colorBoton);
        flechaDerecha2.setForeground(colorTexto);
        flechaDerecha2.setBounds(150, 350, 50, 50);
        flechaDerecha2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (indiceEquipo1 < oe.getEquipos().size() - 1) {
                    indiceEquipo1++;
                    labelEquipo1.setText(oe.getEquipos().get(indiceEquipo1).getNombreEquipo());
                }
            }
        });
        panel.add(flechaDerecha2);

        playMusic("Musica/SelectorEquipos.wav");

    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // Dibujar la imagen de fondo en el JFrame
        if (imagen != null) {
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        }
    }
  public void playMusic(String musicFile) {
    try {
        // Abrir un audio input stream
        URL url = this.getClass().getClassLoader().getResource(musicFile);
        AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);

        // Obtener un clip de sonido
        Clip clip = AudioSystem.getClip();

        // Abrir el clip de audio y cargar muestras de audio del audio input stream
        clip.open(audioIn);

        // Iniciar la reproducción
        clip.start();
    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
        e.printStackTrace();
    }
}
}
