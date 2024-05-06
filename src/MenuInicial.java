import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class MenuInicial extends JFrame {
    private JPanel panel;
    private JButton soloPlayer;
    private JButton multiPlayer;
    private JButton rankingGoleadores;

    private JButton creditos;
    private JButton salir;
    private Clip musicClip;
    public static final Color colorBaseBotones = new Color(25, 25, 25);

    private MusicManager musicManager = new MusicManager();

    private BufferedImage imagen;

    public MenuInicial() {

        setSize(1280,720);
        setTitle("Penalty Eleven");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        panel=new JPanel();
        panel.setLayout(null);


        //Boton soloPlayer

        soloPlayer=new JButton("Un Jugador");
        soloPlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              SoloPlayer soloPlayer = new SoloPlayer();
                soloPlayer.setVisible(true);
                dispose();

                playSound("Musica/SoundEffect/SonidoElegir1.wav", 0.7f);
                musicManager.stopMusic();
            }
        });

        soloPlayer.setBounds(120,275,460,45);
        panel.add(soloPlayer);


        //Boton multiPlayer

        multiPlayer=new JButton("Multijugador");
        multiPlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SelectorEquipos selectorEquipos = new SelectorEquipos();
                selectorEquipos.setVisible(true);
                dispose();

                playSound("Musica/SoundEffect/SonidoElegir1.wav", 0.7f);
                musicManager.stopMusic();
            }
        });

        multiPlayer.setBounds(120,355,460,45);
        panel.add(multiPlayer);


        //Boton rankingGoleadores

        rankingGoleadores=new JButton("Ranking de Goleadores");
        rankingGoleadores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ranking ranking = new Ranking();
                ranking.setVisible(true);
                dispose();
                playSound("Musica/SoundEffect/SonidoElegir1.wav", 0.7f);

                musicManager.stopMusic();
            }
        });

        rankingGoleadores.setBounds(120,435,460,45);
        panel.add(rankingGoleadores);


        //Boton creditos

        creditos = new JButton("Créditos");
        creditos.addActionListener(e -> {
            Creditos creditos = new Creditos();
            creditos.setVisible(true);
            dispose();

            playSound("Musica/SoundEffect/SonidoElegir1.wav", 0.7f);
            musicManager.stopMusic();
        });
        creditos.setBounds(120, 515, 460, 45);
        panel.add(creditos);


        //Boton salir

        salir=new JButton("Salir");
        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
                playSound("Musica/SoundEffect/SonidoElegir1.wav", 0.7f);
            }
        });
        salir.setBounds(120,595,460,45);
        panel.add(salir);


        //Cambiar la fuente de los botones
        Font fuenteBoton = new Font("Action Man", Font.BOLD, 20);
        soloPlayer.setFont(fuenteBoton);
        multiPlayer.setFont(fuenteBoton);
        rankingGoleadores.setFont(fuenteBoton);
        creditos.setFont(fuenteBoton);
        salir.setFont(fuenteBoton);

        //Cambiar color de texto de los botones
        Color colorTexto = new Color(255, 255, 255);
        soloPlayer.setForeground(colorTexto);
        multiPlayer.setForeground(colorTexto);
        rankingGoleadores.setForeground(colorTexto);
        creditos.setForeground(colorTexto);
        salir.setForeground(colorTexto);

        getContentPane().add(panel);

        // Cargar imagen de fondo
        try {
            imagen = ImageIO.read(new File("src/Imagenes/FondoMenuInicial.png")); // Ruta de la imagen de fondo
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Cambiar color de los botones al pasar el ratón por encima
        soloPlayer.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                playSound("Musica/SoundEffect/SonidoSeleccion.wav", 0.7f);
                soloPlayer.setBackground(colorBaseBotones.darker());
            }
            @Override
            public void mouseExited(MouseEvent e) {
                soloPlayer.setBackground(colorBaseBotones);
            }



        });

        multiPlayer.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                playSound("Musica/SoundEffect/SonidoSeleccion.wav", 0.7f);
                multiPlayer.setBackground(colorBaseBotones.darker());
            }
            @Override
            public void mouseExited(MouseEvent e) {
                multiPlayer.setBackground(colorBaseBotones);
            }

        });

        rankingGoleadores.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                playSound("Musica/SoundEffect/SonidoSeleccion.wav", 0.7f);
                rankingGoleadores.setBackground(colorBaseBotones.darker());

            }

            @Override
            public void mouseExited(MouseEvent e) {
                rankingGoleadores.setBackground(colorBaseBotones);
            }
        });

        creditos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                playSound("Musica/SoundEffect/SonidoSeleccion.wav", 0.7f);
                creditos.setBackground(colorBaseBotones.darker());

            }

            @Override
            public void mouseExited(MouseEvent e) {
                creditos.setBackground(colorBaseBotones);
            }
        });

        salir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                playSound("Musica/SoundEffect/SonidoSeleccion.wav", 0.7f);
                salir.setBackground(colorBaseBotones.darker());

            }

            @Override
            public void mouseExited(MouseEvent e) {
                salir.setBackground(colorBaseBotones);
            }
        });

        // Controles de la música
        musicManager.playMusic("Musica/Soundtrack/MenuInicial.wav", 0.5f);

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
