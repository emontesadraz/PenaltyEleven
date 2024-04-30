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

    public MenuInicial() {

        setSize(800,600);
        setTitle("Penalty Eleven");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        panel=new JPanel();
        //panel.setPreferredSize(new Dimension(800,600));
        panel.setLayout(null);

        //Boton soloPlayer
        soloPlayer=new JButton("Un Jugador");
        /*soloPlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //poner enlace a pantalla de SelectorEquipos
            }
        });
         */
        soloPlayer.setBounds(250,180,300,40);
        panel.add(soloPlayer);

        //Boton multiPlayer
        multiPlayer=new JButton("Multijugador");
        /*multiPlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //poner enlace a pantalla de SelectorEquipos
            }
        });
         */
        multiPlayer.setBounds(250,260,300,40);
        panel.add(multiPlayer);

        //Boton rankingGoleadores
        rankingGoleadores=new JButton("Ranking de Goleadores");
        /*rankingGoleadores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //poner enlace a pantalla de RankingGoleadores
            }
        });
         */
        rankingGoleadores.setBounds(250,340,300,40);
        panel.add(rankingGoleadores);

        //Boton salir
        salir=new JButton("Salir");
        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        salir.setBounds(250,420,300,40);
        panel.add(salir);

        //Cambiar la fuente de los botones
        Font fuenteBoton = new Font("Action Man", Font.BOLD, 15);
        soloPlayer.setFont(fuenteBoton);
        multiPlayer.setFont(fuenteBoton);
        rankingGoleadores.setFont(fuenteBoton);
        salir.setFont(fuenteBoton);

        //Cambiar color de fondo de los botones
        Color colorBoton = new Color(24, 92, 195);
        soloPlayer.setBackground(colorBoton);
        multiPlayer.setBackground(colorBoton);
        rankingGoleadores.setBackground(colorBoton);
        salir.setBackground(colorBoton);

        //Cambiar color de texto de los botones
        Color colorTexto = new Color(255, 255, 255);
        soloPlayer.setForeground(colorTexto);
        multiPlayer.setForeground(colorTexto);
        rankingGoleadores.setForeground(colorTexto);
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
                soloPlayer.setBackground(Color.BLUE.darker());

            }

        });

        multiPlayer.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                multiPlayer.setBackground(Color.WHITE.brighter());

            }

            @Override
            public void mouseExited(MouseEvent e) {
                multiPlayer.setBackground(Color.BLACK);
            }
        });

        rankingGoleadores.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                rankingGoleadores.setBackground(Color.WHITE.brighter());

            }

            @Override
            public void mouseExited(MouseEvent e) {
                rankingGoleadores.setBackground(Color.BLACK);
            }
        });

        salir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                salir.setBackground(Color.WHITE.brighter());

            }

            @Override
            public void mouseExited(MouseEvent e) {
                salir.setBackground(Color.BLACK);
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
