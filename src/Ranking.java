import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Ranking extends JFrame{
    MusicManager musicManager = new MusicManager();
    private JPanel panel;
    private JButton volver;
    private JLabel  ranking;
    private JScrollPane scroll;
    private BufferedImage imagen;

    public Ranking() {
        setSize(1280,720);
        setTitle("Penalty Eleven");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setIconImage(new ImageIcon("src/Imagenes/Logo.png").getImage());

        // Cargar imagen de fondo
        try {
            imagen = ImageIO.read(new File("src/Imagenes/FondoRanking.png")); // Ruta de la imagen de fondo
        } catch (IOException e) {
            e.printStackTrace();
        }

        panel=new JPanel();
        panel.setLayout(null);

        ranking = new JLabel();
        ranking.setText("<html> RANKING DE LOS JUGADORES CON MÁS VICTORIAS</html>");
        ranking.setBounds(820, 50, 460, 500);
        panel.add(ranking);

        scroll = new JScrollPane(ranking);
        scroll.setOpaque(false);
        scroll.setBounds(820, 50, 460, 500);
        panel.add(scroll);

        volver = new JButton("Volver");
        volver.setBounds(620, 600, 460, 45);
        volver.addActionListener(e -> {
            MenuInicial menuInicial = new MenuInicial();
            menuInicial.setVisible(true);
            dispose();

            playSound("Musica/SoundEffect/SonidoAtras.wav", 0.5f);
            musicManager.stopMusic();
        });
        panel.add(volver);

        add(panel);

        //Controles música
        musicManager.playMusic("Musica/Soundtrack/Ranking.wav", 0.7f);
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
