import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ElegirTemporada extends JFrame {
    private final JButton temp1,temp2,temp3,volver,fondo;
    public static final Color colorBaseBotones = new Color(25, 25, 25);
    private final MusicManager musicManager = new MusicManager();

    public ElegirTemporada() {

        setSize(1280,720);
        setTitle("Penalty Eleven");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        //Poner icono de la aplicación
        setIconImage(new ImageIcon("src/Imagenes/Logo.png").getImage());

        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(null);

        //Añadir panel al JFrame
        add(panel);

        //Crear botones
        temp1=new JButton("Temporada 1");
        temp2=new JButton("Temporada 2");
        temp3=new JButton("Temporada 3");
        volver=new JButton("Volver");

        // Crear un botón para el fondo
        fondo = new JButton();
        fondo.setBounds(0, 0, 1280, 720);
        fondo.setOpaque(false);
        fondo.setContentAreaFilled(false);
        fondo.setBorderPainted(false);

        // Cargar la imagen de fondo y establecerla como icono del botón
        URL url = this.getClass().getClassLoader().getResource("Imagenes/Fondo/axelkevin.png");
        ImageIcon icono = new ImageIcon(url);
        Image imagen = icono.getImage().getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
        icono = new ImageIcon(imagen);
        fondo.setIcon(icono);

        //Añadir botones al panel
        panel.add(temp1);
        panel.add(temp2);
        panel.add(temp3);
        panel.add(volver);
        panel.add(fondo);

        //Accion del boton temp1
        temp1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Abrir ventana de Temporada1

                playSound("Musica/SoundEffect/SonidoElegir1.wav", 0.7f);
                musicManager.stopMusic();
            }
        });

        //Acción del botón temp2
        temp2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Abrir ventana de Temporada2

                playSound("Musica/SoundEffect/SonidoElegir1.wav", 0.7f);
                musicManager.stopMusic();
            }
        });

        //Acción del botón temp3
        temp3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Abrir ventana de Temporada3

                playSound("Musica/SoundEffect/SonidoElegir1.wav", 0.7f);
                musicManager.stopMusic();
            }
        });

        //Acción del botón volver
        volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SoloPlayer soloPlayer = new SoloPlayer();
                soloPlayer.setVisible(true);
                dispose();
                playSound("Musica/SoundEffect/SonidoElegir1.wav", 0.7f);
                musicManager.stopMusic();
            }
        });

        //Cambiar color base de los botones
        temp1.setBackground(colorBaseBotones);
        temp2.setBackground(colorBaseBotones);
        temp3.setBackground(colorBaseBotones);
        volver.setBackground(colorBaseBotones);
        fondo.setBackground(colorBaseBotones);

        //Cambiar tamaño y posición de los botones
        temp1.setBounds(120,275,460,45);
        temp2.setBounds(120,355,460,45);
        temp3.setBounds(120,435,460,45);
        volver.setBounds(120,515,460,45);

        //Cambiar la fuente de los botones
        Font fuenteBoton = new Font("Action Man", Font.BOLD, 20);
        temp1.setFont(fuenteBoton);
        temp2.setFont(fuenteBoton);
        temp3.setFont(fuenteBoton);
        volver.setFont(fuenteBoton);

        //Cambiar color de texto de los botones
        Color colorTexto = new Color(255, 255, 255);
        temp1.setForeground(colorTexto);
        temp2.setForeground(colorTexto);
        temp3.setForeground(colorTexto);
        volver.setForeground(colorTexto);

        // Cambiar color de los botones al pasar el ratón por encima
        temp1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                playSound("Musica/SoundEffect/SonidoSeleccion.wav", 0.7f);
                temp1.setBackground(colorBaseBotones.darker());
            }
            @Override
            public void mouseExited(MouseEvent e) {
                temp1.setBackground(colorBaseBotones);
            }
        });

        temp2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                playSound("Musica/SoundEffect/SonidoSeleccion.wav", 0.7f);
                temp2.setBackground(colorBaseBotones.darker());}
            @Override
            public void mouseExited(MouseEvent e) {
                temp2.setBackground(colorBaseBotones);
            }
        });

        temp3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                playSound("Musica/SoundEffect/SonidoSeleccion.wav", 0.7f);
                temp3.setBackground(colorBaseBotones.darker());}
            @Override
            public void mouseExited(MouseEvent e) {
                temp3.setBackground(colorBaseBotones);
            }
        });

        volver.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                playSound("Musica/SoundEffect/SonidoSeleccion.wav", 0.7f);
                volver.setBackground(colorBaseBotones.darker());}
            @Override
            public void mouseExited(MouseEvent e) {
                volver.setBackground(colorBaseBotones);
            }
        });

        // Controles de la música
        musicManager.playMusic("Musica/Soundtrack/SoloPlayer1.wav", 0.5f);

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
