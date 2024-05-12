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

public class LobbyIE1 extends JFrame {
    private final JButton empezar,volver,fondo;
    public static final Color colorBaseBotones = new Color(25, 25, 25);
    private BufferedImage imagen;
    private final MusicManager musicManager = new MusicManager();

    public LobbyIE1() {

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
        empezar=new JButton("Empezar");
        volver=new JButton("Volver");

        // Crear un botón para el fondo
        fondo = new JButton();
        fondo.setBounds(0, 0, 1280, 720);
        fondo.setOpaque(false);
        fondo.setContentAreaFilled(false);
        fondo.setBorderPainted(false);

        // Cargar la imagen de fondo y establecerla como icono del botón
        URL url = this.getClass().getClassLoader().getResource("Imagenes/Fondo/LobbyIE1.png");
        ImageIcon icono = new ImageIcon(url);
        Image imagen = icono.getImage().getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
        icono = new ImageIcon(imagen);
        fondo.setIcon(icono);

        //Añadir botones al panel
        panel.add(empezar);
        panel.add(volver);
        panel.add(fondo);

        //Acción del botón siguiente
        empezar.addActionListener(new ActionListener() {
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
                ElegirTemporada elegirTemporada = new ElegirTemporada();
                elegirTemporada.setVisible(true);
                dispose();
                playSound("Musica/SoundEffect/SonidoElegir1.wav", 0.7f);
                musicManager.stopMusic();
            }
        });

        //Cambiar color base de los botones
        empezar.setBackground(colorBaseBotones);
        volver.setBackground(colorBaseBotones);
        fondo.setBackground(colorBaseBotones);

        //Cambiar tamaño y posición de los botones
        empezar.setBounds(120,435,460,45);
        volver.setBounds(120,515,460,45);

        //Cambiar la fuente de los botones
        Font fuenteBoton = new Font("Action Man", Font.BOLD, 20);
        empezar.setFont(fuenteBoton);
        volver.setFont(fuenteBoton);

        //Cambiar color de texto de los botones
        Color colorTexto = new Color(255, 255, 255);
        empezar.setForeground(colorTexto);
        volver.setForeground(colorTexto);

        // Cambiar color de los botones al pasar el ratón por encima
        empezar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                playSound("Musica/SoundEffect/SonidoSeleccion.wav", 0.7f);
                empezar.setBackground(colorBaseBotones.darker());}
            @Override
            public void mouseExited(MouseEvent e) {
                empezar.setBackground(colorBaseBotones);
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
