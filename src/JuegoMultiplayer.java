import com.juego.multiplayer.Jugador1;
import com.juego.multiplayer.Jugador2;
import com.juego.multiplayer.TurnManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JuegoMultiplayer extends JFrame {

    private Jugador1 jugador1;
    private Jugador2 jugador2;
    public static final Color colorBaseBotones = new Color(25, 25, 25);
    private final MusicManager musicManager = new MusicManager();
    private JToggleButton [][] direcciones;
    private String tiroJugador1;
    private String tiroJugador2;
    private TurnManager turnManager;

    public JuegoMultiplayer() {
        // Configuramos el JFrame
        setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
        setTitle("Penalty Eleven");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        // Inicializamos el TurnManager
        turnManager = new TurnManager();

        // Obtén el tamaño de la pantalla
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;

        // Calcula las dimensiones de los paneles
        int panel1Width = width; // Ancho completo de la pantalla
        int panel1Height = (int) (height * 0.75); // 3/4 de la altura de la pantalla
        int panel2Width = width - panel1Width; // 1/4 del ancho de la pantalla
        int panel2Height = height; // Altura completa de la pantalla

        // Poner icono de la aplicación
        setIconImage(new ImageIcon("src/Imagenes/Logo.png").getImage());

        // Creamos el panel para chutar jugador 1
        JPanel panelChutarJugador1 = new JPanel();
        panelChutarJugador1.setSize(panel1Width, panel1Height);
        panelChutarJugador1.setBackground(new Color(23, 23, 213, 255));
        panelChutarJugador1.setLayout(null);
        add(panelChutarJugador1);

        // Creamos el panel para parar jugador 1
        JPanel panelPararJugador1 = new JPanel();
        panelPararJugador1.setSize(panel1Width, panel1Height);
        panelPararJugador1.setBackground(new Color(82, 255, 0, 255));
        panelPararJugador1.setVisible(false);
        panelPararJugador1.setLayout(null);
        add(panelPararJugador1);

        // Creamos el panel para chutar jugador 2
        JPanel panelChutarJugador2 = new JPanel();
        panelChutarJugador2.setSize(panel1Width, panel1Height);
        panelChutarJugador2.setBackground(new Color(23, 23, 213, 255));
        panelChutarJugador2.setVisible(false);
        panelChutarJugador2.setLayout(null);
        add(panelChutarJugador2);

        // Creamos el panel para parar jugador 2
        JPanel panelPararJugador2 = new JPanel();
        panelPararJugador2.setSize(panel1Width, panel1Height);
        panelPararJugador2.setBackground(new Color(82, 255, 0, 255));
        panelPararJugador2.setVisible(false);
        panelPararJugador2.setLayout(null);
        add(panelPararJugador2);



        // Creamos el panel2
        JPanel panelAbajo = new JPanel();
        panelAbajo.setSize(panel2Width, panel2Height);
        panelAbajo.setBackground(new Color(213, 23, 23, 255));
        panelAbajo.setLayout(null);
        add(panelAbajo);

        direcciones = new JToggleButton[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
            JToggleButton button = new JToggleButton(getDirectionLabel(i, j));
                final int row = i;
                final int col = j;
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (turnManager.isTurnoJugador1()){
                            tiroJugador1 = getDirectionLabel(row, col);
                        } else {
                            tiroJugador2 = getDirectionLabel(row, col);
                        }
                    }
                });
                direcciones[i][j] = button;
                panelChutarJugador1.add(button);
                panelChutarJugador2.add(button);
                panelPararJugador1.add(button);
                panelPararJugador2.add(button);
            }
        }

    }

    private String getDirectionLabel(int row, int col) {
        switch (row * 3 + col) {
            case 0: return "Arriba Izquierda";
            case 1: return "Arriba";
            case 2: return "Arriba Derecha";
            case 3: return "Izquierda";
            case 4: return "Parar";
            case 5: return "Derecha";
            case 6: return "Abajo Izquierda";
            case 7: return "Abajo";
            case 8: return "Abajo Derecha";
            default: return "";
        }
    }

    public static void main(String[] args) {
        JuegoMultiplayer juego = new JuegoMultiplayer();
        juego.setVisible(true);
    }
}





