import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;

public class MenuInicial extends InterfazMaestra {
    private final JButton soloPlayer, multiPlayer, ranking, creditos, salir,fondo;
    public static final Color colorBaseBotones = new Color(25, 25, 25);
    private final MusicManager musicManager = new MusicManager();

    public MenuInicial() {

        setSize(1280,720);
        setTitle("Penalty Eleven");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        //Poner icono de la aplicación
        setIconImage(new ImageIcon("src/Imagenes/Logo.png").getImage());

        //Crear panel
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(null);

        //Crear botones
        soloPlayer=new JButton("Un Jugador");
        multiPlayer=new JButton("Multijugador");
        ranking =new JButton("Ranking de Goleadores");
        creditos=new JButton("Créditos");
        salir=new JButton("Salir");

        fondo = new JButton();
        crearFondo(fondo,"Imagenes/Fondo/FondoMenuInicial.png");

        // Añadir los otros botones al panel
        panel.add(soloPlayer);
        panel.add(multiPlayer);
        panel.add(ranking);
        panel.add(creditos);
        panel.add(salir);
        panel.add(fondo);

        //Añadir panel al JFrame
        add(panel);

        //Accion del boton soloPlayer
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

        //Acción del botón multiPlayer
        multiPlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SelectorEquipos selectorEquipos = null;
                try {
                    selectorEquipos = new SelectorEquipos();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                selectorEquipos.setVisible(true);
                dispose();
                playSound("Musica/SoundEffect/SonidoElegir1.wav", 0.7f);
                musicManager.stopMusic();
            }
        });

        //Acción del botón rankingGoleadores
        ranking.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ranking ranking = new Ranking();
                ranking.setVisible(true);
                dispose();
                playSound("Musica/SoundEffect/SonidoElegir1.wav", 0.7f);
                musicManager.stopMusic();
            }
        });

        //Acción del botón creditos
        creditos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Creditos creditos = new Creditos();
                creditos.setVisible(true);
                dispose();
                playSound("Musica/SoundEffect/SonidoElegir1.wav", 0.7f);
                musicManager.stopMusic();
            }
        });

        //Acción del botón salir
        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSound("Musica/SoundEffect/SonidoElegir1.wav", 0.7f);
                System.exit(0);
            }
        });

        //Cambiar color base de los botones
        soloPlayer.setBackground(colorBaseBotones);
        multiPlayer.setBackground(colorBaseBotones);
        ranking.setBackground(colorBaseBotones);
        creditos.setBackground(colorBaseBotones);
        salir.setBackground(colorBaseBotones);

        //Cambiar tamaño y posición de los botones
        soloPlayer.setBounds(120,275,460,45);
        multiPlayer.setBounds(120,355,460,45);
        ranking.setBounds(120,435,460,45);
        creditos.setBounds(120,515,460,45);
        salir.setBounds(120,595,460,45);

        //Cambiar la fuente de los botones
        Font fuenteBoton = new Font("Action Man", Font.BOLD, 20);
        soloPlayer.setFont(fuenteBoton);
        multiPlayer.setFont(fuenteBoton);
        ranking.setFont(fuenteBoton);
        creditos.setFont(fuenteBoton);
        salir.setFont(fuenteBoton);

        //Cambiar color de texto de los botones
        Color colorTexto = new Color(255, 255, 255);
        soloPlayer.setForeground(colorTexto);
        multiPlayer.setForeground(colorTexto);
        ranking.setForeground(colorTexto);
        creditos.setForeground(colorTexto);
        salir.setForeground(colorTexto);

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
                multiPlayer.setBackground(colorBaseBotones.darker());}
            @Override
            public void mouseExited(MouseEvent e) {
                multiPlayer.setBackground(colorBaseBotones);
            }
        });

        ranking.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                playSound("Musica/SoundEffect/SonidoSeleccion.wav", 0.7f);
                ranking.setBackground(colorBaseBotones.darker());}
            @Override
            public void mouseExited(MouseEvent e) {
                ranking.setBackground(colorBaseBotones);
            }
        });

        creditos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                playSound("Musica/SoundEffect/SonidoSeleccion.wav", 0.7f);
                creditos.setBackground(colorBaseBotones.darker());}
            @Override
            public void mouseExited(MouseEvent e) {
                creditos.setBackground(colorBaseBotones);
            }
        });

        salir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                playSound("Musica/SoundEffect/SonidoSeleccion.wav", 0.7f);
                salir.setBackground(colorBaseBotones.darker());}
            @Override
            public void mouseExited(MouseEvent e) {
                salir.setBackground(colorBaseBotones);
            }
        });

        // Controles de la música
        musicManager.playMusic("Musica/Soundtrack/MenuInicial.wav", 0.2f);

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
