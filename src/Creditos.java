import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Creditos extends JFrame {
    private JPanel panel;
    private JButton volver;
    private JLabel creditos;
    public static final Color colorBaseBotones = new Color(25, 25, 25);
    private Clip musicClip;
    private BufferedImage imagen;
    private MusicManager musicManager = new MusicManager();

    public Creditos() {

        setSize(1280,720);
        setTitle("Penalty Eleven");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        panel=new JPanel();
        panel.setLayout(null);

        //Boton volver
        volver=new JButton("Volver");
        volver.setBackground(colorBaseBotones);
        volver.setForeground(Color.WHITE);
        volver.setFont(new Font("Action Man", Font.BOLD, 20));
        volver.addActionListener(e -> {
            MenuInicial menuInicial = new MenuInicial();
            menuInicial.setVisible(true);
            dispose();

            playSound("Musica/SoundEffect/SonidoElegir1.wav", 0.7f);
            musicManager.stopMusic();
        });

        volver.setBounds(40,600,220,50);
        panel.add(volver);

        add(panel);

        //Boton volver musica y color
        volver.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                playSound("Musica/SoundEffect/SonidoSeleccion.wav", 0.7f);
                volver.setBackground(colorBaseBotones.darker());

            }

            @Override
            public void mouseExited(MouseEvent e) {
                volver.setBackground(colorBaseBotones);
            }
        });

        //Texto de creditos
        creditos = new JLabel("<html><center>Desarrollado por:<br><br>Pedro Piñeiro Ordax <br>&<br>Esteban Miguel Montes Adraz</center></html>");
        creditos.setFont(new Font("Action Man", Font.BOLD, 30));
        creditos.setForeground(Color.BLACK);
        creditos.setBounds(550, 180, 500, 300);
        panel.add(creditos);

        // Controles de la música
        musicManager.playMusic("Musica/Soundtrack/Creditos.wav", 0.6f);

        // Cargar imagen de fondo
        try {
            imagen = ImageIO.read(new File("src/Imagenes/FondoCreditos.png")); // Ruta de la imagen de fondo
        } catch (IOException e) {
            e.printStackTrace();
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

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // Dibujar la imagen de fondo en el JFrame
        if (imagen != null) {
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        }
    }

}