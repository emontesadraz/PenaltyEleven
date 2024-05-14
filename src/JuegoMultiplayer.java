import com.juego.multiplayer.Jugador1;
import com.juego.multiplayer.Jugador2;
import com.juego.multiplayer.TurnManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class JuegoMultiplayer extends JFrame {
    public static final Color colorBaseBotones = new Color(25, 25, 25);
    private final MusicManager musicManager = new MusicManager();
    private JToggleButton [][] direccionesJugador1;
    private JToggleButton [][] direccionesJugador2;
    private String tiroJugador1;
    private String tiroJugador2;
    private String direccionSeleccionada;
    private JButton chutarJugador1;
    private JButton chutarJugador2;
    private JButton pararJugador1;
    private JButton pararJugador2;
    private TurnManager turnManager;
    private JPanel panelJugador1;
    private JPanel panelJugador2;
    private JPanel panelAbajo;
    private List<JToggleButton> pararDireccionesJugador1;
    private List<JToggleButton> pararDireccionesJugador2;
    private JLabel infoTurno;
    private int golesJugador1;
    private int golesJugador2;

    public JuegoMultiplayer() {
        golesJugador1 = 0;
        golesJugador2 = 0;

        // Configuramos el JFrame
        setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
        setTitle("Penalty Eleven");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);


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

        // Inicializamos el Label de información del turno
        infoTurno = new JLabel();
        infoTurno.setBounds(100, 100, 300, 50); // Ajusta la posición y el tamaño según sea necesario
        add(infoTurno);

        // Inicializamos el JLabel de la imagen del evento
        JLabel golesLabel = new JLabel();
        golesLabel.setBounds(100, 200, 300, 300); // Ajusta la posición y el tamaño según sea necesario
        add(golesLabel);

        // Creamos el panel para chutar jugador 1
        panelJugador1 = new JPanel();
        panelJugador1.setSize(panel1Width, panel1Height);
        panelJugador1.setBackground(new Color(23, 23, 213, 255));
        panelJugador1.setLayout(null);
        add(panelJugador1);

        // Creamos el panel para chutar jugador 2
        panelJugador2 = new JPanel();
        panelJugador2.setSize(panel1Width, panel1Height);
        panelJugador2.setBackground(new Color(82, 255, 0, 255));
        panelJugador2.setVisible(false);
        panelJugador2.setLayout(null);
        add(panelJugador2);

        // Creamos el panel2
        panelAbajo = new JPanel();
        panelAbajo.setSize(panel2Width, panel2Height);
        panelAbajo.setBackground(new Color(213, 23, 23, 255));
        panelAbajo.setLayout(null);
        add(panelAbajo);

        // Llamamos al método para crear los botones de dirección
        crearBotonesDireccion();

        // Creamos los botones a sus respectivos sitios
        chutarJugador1 = new JButton("Chutar");
        pararJugador1 = new JButton("Parar");
        chutarJugador2 = new JButton("Chutar");
        pararJugador2 = new JButton("Parar");

        // Ponemos las medidas en las que queremos que estén los botones
        chutarJugador1.setBounds(100, 300, 200, 100);
        pararJugador1.setBounds(100, 450, 200, 100);
        chutarJugador2.setBounds(100, 300, 200, 100);
        pararJugador2.setBounds(100, 450, 200, 100);

        // Añadimos los botones a los paneles
        panelJugador1.add(chutarJugador1);
        panelJugador1.add(pararJugador1);
        panelJugador2.add(chutarJugador2);
        panelJugador2.add(pararJugador2);

        // Botón para chutar del jugador 1
        chutarJugador1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarDireccionSeleccionada();
                turnManager.nextTurn();
                actualizarUI();
                // ...
            }
        });
        // Boton para parar del jugador 1
        pararJugador1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarDireccionSeleccionada();
                turnManager.nextTurn();
                actualizarUI();
                // ...
            }
        });
        // Boton para chutar del jugador 2
        chutarJugador2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarDireccionSeleccionada();
                turnManager.nextTurn();
                actualizarUI();
                // ...
            }
        });
        // Boton para parar del jugador 2
        pararJugador2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarDireccionSeleccionada();
                turnManager.nextTurn();
                actualizarUI();
                // ...
            }
        });
    }
    private void incrementarGolesJugador1() {
        golesJugador1++;
    }
    private void incrementarGolesJugador2() {
        golesJugador2++;
    }

    private String getDirectionLabel(int row, int col) {
        switch (row * 3 + col) {
            case 0: return "Arriba Izquierda";
            case 1: return "Arriba";
            case 2: return "Arriba Derecha";
            case 3: return "Izquierda";
            case 4: return "Centro";
            case 5: return "Derecha";
            case 6: return "Abajo Izquierda";
            case 7: return "Abajo";
            case 8: return "Abajo Derecha";
            default: return "";
        }
    }
    private void guardarDireccionSeleccionada(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (turnManager.isTurnoJugador1() && direccionesJugador1[i][j].isSelected()) {
                    direccionSeleccionada = getDirectionLabel(i, j);
                    break;
                } else if (!turnManager.isTurnoJugador1() && direccionesJugador2[i][j].isSelected()) {
                    direccionSeleccionada = getDirectionLabel(i, j);
                    break;
                }
            }
        }
    }
    private void guardarDireccionesParar() {
        List<String> direccionesParar = new ArrayList<>();
        for (JToggleButton button : turnManager.isTurnoJugador1() ? pararDireccionesJugador1 : pararDireccionesJugador2) {
            if (button.isSelected()) {
                direccionesParar.add(button.getText());
            }
        }
    }

    private void actualizarUI() {
        if (turnManager.isTurnoJugador1()) {
            // Es el turno del jugador 1
            // Mostrar el panel del jugador 1 y ocultar el del jugador 2
            panelJugador1.setVisible(true);
            panelJugador2.setVisible(false);

            // Habilitar los botones de tirar y parar del jugador 1
            chutarJugador1.setEnabled(true);
            pararJugador1.setEnabled(true);

            // Deshabilitar los botones de tirar y parar del jugador 2
            chutarJugador2.setEnabled(false);
            pararJugador2.setEnabled(false);
        } else {
            // Es el turno del jugador 2
            // Mostrar el panel del jugador 2 y ocultar el del jugador 1
            panelJugador1.setVisible(false);
            panelJugador2.setVisible(true);

            // Habilitar los botones de tirar y parar del jugador 2
            chutarJugador2.setEnabled(true);
            pararJugador2.setEnabled(true);

            // Deshabilitar los botones de tirar y parar del jugador 1
            chutarJugador1.setEnabled(false);
            pararJugador1.setEnabled(false);
        }
        actualizarInfoTurno();
    }
    private void crearBotonesDireccion() {
        // Inicializar la matriz de los botones
        direccionesJugador1 = new JToggleButton[3][3];
        direccionesJugador2 = new JToggleButton[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JToggleButton buttonTirarJugador1 = new JToggleButton(getDirectionLabel(i, j));
                JToggleButton buttonTirarJugador2 = new JToggleButton(getDirectionLabel(i, j));

                // Establecer las dimensiones y la posición de los botones
                int buttonWidth = 300;
                int buttonHeight = 200;
                int x = 550 + j * buttonWidth;
                int y = 100 + i * buttonHeight;

                buttonTirarJugador1.setBounds(x, y, buttonWidth, buttonHeight);
                buttonTirarJugador2.setBounds(x, y, buttonWidth, buttonHeight);

                // Guardar los botones en las matrices
                direccionesJugador1[i][j] = buttonTirarJugador1;
                direccionesJugador2[i][j] = buttonTirarJugador2;

                // Añadir los botones al panel del jugador 1
                panelJugador1.add(buttonTirarJugador1);

                // Añadir los botones al panel del jugador 2
                panelJugador2.add(buttonTirarJugador2);
            }
        }
    }
    private void actualizarInfoTurno() {
        String jugador = turnManager.isTurnoJugador1() ? "Jugador 1" : "Jugador 2";
        String accion = (turnManager.isTurnoJugador1() ? chutarJugador1 : chutarJugador2).isEnabled() ? "tirar" : "parar";
        int turnosRestantes = TurnManager.MAX_TURNOS - turnManager.getTurnos();
        infoTurno.setText(String.format("%s tiene que %s. Quedan %d turnos.", jugador, accion, turnosRestantes));
        infoTurno.setBackground(Color.WHITE);
        infoTurno.setHorizontalTextPosition(JLabel.CENTER);
        infoTurno.setOpaque(true);
        infoTurno.setFont(new Font("Arial", Font.PLAIN, 14));
    }
    public void registrarEvento(boolean esGol, boolean esJugador1) {
        JLabel golesLabel = new JLabel(); // Asegúrate de inicializar este JLabel en tu constructor y agregarlo a tu JFrame
        if (esGol) {
            // Incrementa el número de goles del jugador correspondiente
            if (esJugador1) {
                incrementarGolesJugador1();
                JOptionPane.showMessageDialog(null, "¡Gol del Jugador 1!");
                golesLabel.setText("Jugador 1: " + golesJugador1 + " goles");
            } else {
                incrementarGolesJugador2();
                JOptionPane.showMessageDialog(null, "¡Gol del Jugador 2!");
                golesLabel.setText("Jugador 2: " + golesJugador2 + " goles");
            }
        } else {
            JOptionPane.showMessageDialog(null, "¡Tiro detenido!");
        }

        // Actualiza la información del turno
        actualizarInfoTurno();
    }
    public void evaluarTiro() {
        String tiro;
        List<JToggleButton> direccionesParar;

        if (turnManager.isTurnoJugador1()) {
            tiro = tiroJugador1;
            direccionesParar = pararDireccionesJugador2;
        } else {
            tiro = tiroJugador2;
            direccionesParar = pararDireccionesJugador1;
        }

        if (!direccionesParar.contains(tiro)) {
            // Si el tiro no está en las direcciones seleccionadas para parar, es gol
            registrarEvento(true, turnManager.isTurnoJugador1());
        } else {
            // Si el tiro está en las direcciones seleccionadas para parar, el tiro es detenido
            registrarEvento(false, turnManager.isTurnoJugador1());
        }
    }

    public static void main(String[] args) {
        JuegoMultiplayer juego = new JuegoMultiplayer();
        juego.setVisible(true);
    }
}





