import javax.imageio.ImageIO;
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

public class MenuInicial extends JFrame {
    private JPanel panel;
    private JButton soloPlayer;
    private JButton multiPlayer;
    private JButton rankingGoleadores;
    private JButton salir;

    private BufferedImage imagen;

    private Color colorBaseBotones = new Color(214, 202, 42);

    public MenuInicial() {

        setSize(1200,800);
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
       soloPlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SelectorEquiposSolo selectorEquiposSolo = new SelectorEquiposSolo();
                selectorEquiposSolo.setVisible(true);
            }
        });

        soloPlayer.setFont(fuenteBoton);
        soloPlayer.setBackground(colorBoton);
        soloPlayer.setBounds(450,170,300,60);
        panel.add(soloPlayer);


        multiPlayer=new JButton("Multijugador");
        multiPlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SelectorEquipos selectorEquipos = new SelectorEquipos();
                selectorEquipos.setVisible(true);
                dispose();
            }
        });

        multiPlayer.setFont(fuenteBoton);
        multiPlayer.setBackground(colorBoton);
        multiPlayer.setBounds(450,270,300,60);
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
        rankingGoleadores.setBounds(450,380,300,60);
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
        salir.setBounds(450,490,300,60);
        panel.add(salir);

        getContentPane().add(panel);

        // Cargar imagen de fondo
        try {
            imagen = ImageIO.read(new File("src/FondoMenuInicial.jpeg")); // Ruta de la imagen de fondo
        } catch (IOException e) {
            e.printStackTrace();
        }

        soloPlayer.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
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
                rankingGoleadores.setBackground(colorBaseBotones.darker());

            }

            @Override
            public void mouseExited(MouseEvent e) {
                rankingGoleadores.setBackground(colorBaseBotones);
            }
        });

        salir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                salir.setBackground(colorBaseBotones.darker());

            }

            @Override
            public void mouseExited(MouseEvent e) {

                salir.setBackground(colorBaseBotones);
            }
        });

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
