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

public class SoloPlayer extends JFrame {
    private final JButton modoHistoria,juegoLibre,volver;
    public static final Color colorBaseBotones = new Color(25, 25, 25);
    private BufferedImage imagen;
    private final MusicManager musicManager = new MusicManager();

    public SoloPlayer() {

        setSize(1280,720);
        setTitle("Penalty Eleven");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setIconImage(new ImageIcon("src/Imagenes/Logo.png").getImage());

        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(null);

        // Cargar imagen de fondo
        try {
            imagen = ImageIO.read(new File("src/Imagenes/Fondo/markevans.png")); // Ruta de la imagen de fondo
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Añadir panel al JFrame
        add(panel);

        //Crear botones
        modoHistoria=new JButton("Modo Historia");
        juegoLibre=new JButton("Juego Libre");
        volver=new JButton("Volver");

        //Añadir botones al panel
        panel.add(modoHistoria);
        panel.add(juegoLibre);
        panel.add(volver);

        //Accion del boton modoHistoria
        modoHistoria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ElegirTemporada elegirTemporada = new ElegirTemporada();
                elegirTemporada.setVisible(true);
                dispose();

                playSound("Musica/SoundEffect/SonidoElegir1.wav", 0.7f);
                musicManager.stopMusic();
            }
        });

        //Acción del botón juegoLibre
        juegoLibre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SelectorEquiposSolo selectorEquiposSolo = new SelectorEquiposSolo();
                selectorEquiposSolo.setVisible(true);
                dispose();

                playSound("Musica/SoundEffect/SonidoElegir1.wav", 0.7f);
                musicManager.stopMusic();
            }
        });

        //Acción del botón volver
        volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuInicial menuInicial = new MenuInicial();
                menuInicial.setVisible(true);
                dispose();
                playSound("Musica/SoundEffect/SonidoElegir1.wav", 0.7f);

                musicManager.stopMusic();
            }
        });

        //Cambiar tamaño y posición de los botones
        modoHistoria.setBounds(120,275,460,45);
        juegoLibre.setBounds(120,355,460,45);
        volver.setBounds(120,435,460,45);

        //Cambiar la fuente de los botones
        Font fuenteBoton = new Font("Action Man", Font.BOLD, 20);
        modoHistoria.setFont(fuenteBoton);
        juegoLibre.setFont(fuenteBoton);
        volver.setFont(fuenteBoton);

        //Cambiar color de texto de los botones
        Color colorTexto = new Color(255, 255, 255);
        modoHistoria.setForeground(colorTexto);
        juegoLibre.setForeground(colorTexto);
        volver.setForeground(colorTexto);

        // Cambiar color de los botones al pasar el ratón por encima
        modoHistoria.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                playSound("Musica/SoundEffect/SonidoSeleccion.wav", 0.7f);
                modoHistoria.setBackground(colorBaseBotones.darker());
            }
            @Override
            public void mouseExited(MouseEvent e) {
                modoHistoria.setBackground(colorBaseBotones);
            }
        });

        juegoLibre.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                playSound("Musica/SoundEffect/SonidoSeleccion.wav", 0.7f);
                juegoLibre.setBackground(colorBaseBotones.darker());}
            @Override
            public void mouseExited(MouseEvent e) {
                juegoLibre.setBackground(colorBaseBotones);
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

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
    }

}
