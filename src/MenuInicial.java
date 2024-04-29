import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MenuInicial extends JFrame {
    private JPanel panel;
    private JButton soloPlayer;
    private JButton multiPlayer;
    private JButton rankingGoleadores;
    private JButton salir;

    private BufferedImage imagen;

    public MenuInicial() {

        setSize(800,600);
        setTitle("Penalty Eleven");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        panel=new JPanel();
        //panel.setPreferredSize(new Dimension(800,600));
        panel.setLayout(null);

        Font fuenteBoton = new Font("Action Man", Font.BOLD, 15);
        Color colorBoton = new Color(214, 202, 42);

        soloPlayer=new JButton("Un Jugador");
        /*soloPlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //poner enlace a pantalla de SelectorEquipos
            }
        });
         */
        soloPlayer.setFont(fuenteBoton);
        soloPlayer.setBackground(colorBoton);
        soloPlayer.setBounds(250,180,300,40);
        panel.add(soloPlayer);
        multiPlayer=new JButton("Multijugador");
        /*multiPlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //poner enlace a pantalla de SelectorEquipos
            }
        });
         */
        multiPlayer.setFont(fuenteBoton);
        multiPlayer.setBackground(colorBoton);
        multiPlayer.setBounds(250,260,300,40);
        panel.add(multiPlayer);

        rankingGoleadores=new JButton("Ranking de Goleadores");
        /*rankingGoleadores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //poner enlace a pantalla de RankingGoleadores
            }
        });
         */
        rankingGoleadores.setFont(fuenteBoton);
        rankingGoleadores.setBackground(colorBoton);
        rankingGoleadores.setBounds(250,340,300,40);
        panel.add(rankingGoleadores);

        salir=new JButton("Salir");
        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        salir.setFont(fuenteBoton);
        salir.setBackground(colorBoton);
        salir.setBounds(250,420,300,40);
        panel.add(salir);

        getContentPane().add(panel);

        // Cargar imagen de fondo
        try {
            imagen = ImageIO.read(new File("src/FondoSelectorEquipos.jpeg")); // Ruta de la imagen de fondo
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
