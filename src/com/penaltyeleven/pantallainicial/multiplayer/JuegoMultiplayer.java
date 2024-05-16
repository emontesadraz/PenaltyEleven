package com.penaltyeleven.pantallainicial.multiplayer;

import com.penaltyeleven.metodosexternos.MusicManager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;


public class JuegoMultiplayer extends JFrame {
    public static final Color colorBaseBotones = new Color(25, 25, 25);
    private final MusicManager musicManager = new MusicManager();
    private JToggleButton [][] direccionesJugador1;
    private JToggleButton [][] direccionesJugador2;
    private JButton chutarJugador1;
    private JButton chutarJugador2;
    private TurnManager turnManager;
    private JPanel panelJugador1;
    private JPanel panelJugador2;
    private JPanel panelAbajo;
    private JLabel infoTurno;
    private JLabel golesLabel;
    private int golesJugador1;
    private int golesJugador2;
    private Map<String, Double> probabilidadDeGol = new HashMap<>();
    private String direccionPortero;
    private List<String> direcciones = Arrays.asList("Arriba Izquierda", "Arriba", "Arriba Derecha", "Izquierda", "Centro", "Derecha", "Abajo Izquierda", "Abajo", "Abajo Derecha");
    private Random random = new Random();

    public JuegoMultiplayer() {
        golesJugador1 = 0;
        golesJugador2 = 0;

        inicializarProbabilidades();

        // Configuramos el JFrame
        setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
        setTitle("Penalty Eleven");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Inicializamos el Label de información del turno
        infoTurno = new JLabel();
        infoTurno.setHorizontalAlignment(JLabel.CENTER);
        infoTurno.setFont(new Font("Rubik", Font.PLAIN, 14));
        infoTurno.setBackground(Color.WHITE);
        infoTurno.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
        infoTurno.setOpaque(true);
        infoTurno.setBounds(50, 20, 200, 50); // Ajusta la posición y el tamaño según sea necesario
        add(infoTurno);

        // Inicializamos el Label de información de los goles
        golesLabel = new JLabel();// Asegúrate de inicializar este JLabel en tu constructor y agregarlo a tu JFrame
        golesLabel.setBackground(Color.WHITE);
        golesLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
        golesLabel.setBounds(1500, 20, 200, 50); // Ajusta la posición y el tamaño según sea necesario
        golesLabel.setOpaque(true);
        golesLabel.setFont(new Font("Rubik", Font.PLAIN, 14));
        add(golesLabel);

        // Inicializamos TurnManager
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
        chutarJugador2 = new JButton("Chutar");

        // Ponemos las medidas en las que queremos que estén los botones
        chutarJugador1.setBounds(100, 400, 200, 100);
        chutarJugador2.setBounds(100, 400, 200, 100);


        // Añadimos los botones a los paneles
        panelJugador1.add(chutarJugador1);
        panelJugador2.add(chutarJugador2);

        // Botón para chutar del jugador 1
        chutarJugador1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String direccionSeleccionada = guardarDireccionSeleccionada(direccionesJugador1);
                if (direccionSeleccionada == null) {
                    JOptionPane.showMessageDialog(null, "Debes elegir una dirección antes de chutar.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                // Verificar si el portero para el tiro
                if (porteroPara(direccionSeleccionada)) {
                    ImageIcon icon = new ImageIcon("src/Imagenes/Parada.png");
                    JOptionPane.showMessageDialog(null, "¡El portero ha detenido el tiro!", "Portero", JOptionPane.INFORMATION_MESSAGE, icon);
                } else {
                    ImageIcon icon = new ImageIcon("src/Imagenes/Gol.png");
                    JOptionPane.showMessageDialog(null, "¡Tremendo golazo, si señor!", "Portero", JOptionPane.INFORMATION_MESSAGE, icon);
                    actualizarGoles(true);
                }

                // Cambiar de panel
                panelJugador1.setVisible(false);
                panelJugador2.setVisible(true);

                // Cambiar de turno
                turnManager.nextTurn();
                updateTurnInfo();

                finalizarPartido();
            }
        });
        // Boton para chutar del jugador 2
        chutarJugador2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String direccionSeleccionada = guardarDireccionSeleccionada(direccionesJugador2);
                if (direccionSeleccionada == null) {
                    JOptionPane.showMessageDialog(null, "Debes elegir una dirección antes de chutar.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                // Verificar si el portero para el tiro
                if (porteroPara(direccionSeleccionada)) {
                    ImageIcon icon = new ImageIcon("src/Imagenes/Parada.png");
                    JOptionPane.showMessageDialog(null, "", "Portero", JOptionPane.INFORMATION_MESSAGE, icon);
                } else {
                    ImageIcon icon = new ImageIcon("src/Imagenes/Gol.png");
                    JOptionPane.showMessageDialog(null, "", "Portero", JOptionPane.INFORMATION_MESSAGE, icon);
                    actualizarGoles(false);
                }
                // Cambiar de panel
                panelJugador2.setVisible(false);
                panelJugador1.setVisible(true);

                // Cambiar de turno
                turnManager.nextTurn();
                updateTurnInfo();

                finalizarPartido();
            }
        });
    }
    public void finalizarPartido() {
        if (turnManager.isGameFinished()) {
            if (golesJugador1 > golesJugador2) {
                JOptionPane.showMessageDialog(null, "El jugador 1 ha ganado el partido!", "Fin del partido", JOptionPane.INFORMATION_MESSAGE);
            } else if (golesJugador2 > golesJugador1) {
                JOptionPane.showMessageDialog(null, "El jugador 2 ha ganado el partido!", "Fin del partido", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "El partido ha terminado en empate. Se repetirán los penaltis.", "Fin del partido", JOptionPane.INFORMATION_MESSAGE);
                reiniciarPartido();
            }
        }
    }
    private void reiniciarPartido() {
        golesJugador1 = 0;
        golesJugador2 = 0;
        turnManager = new TurnManager();
        golesLabel.setText("<html>Goles Jugador 1: " + golesJugador1 + "<br>Goles Jugador 2: " + golesJugador2 + "</html>");
    }
    private String guardarDireccionSeleccionada(JToggleButton[][] direcciones) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (direcciones[i][j].isSelected()) {
                    return getDirectionLabel(i, j);
                }
            }
        }
        return null; // Devuelve null si no se ha seleccionado ninguna dirección
    }
    private void actualizarGoles(boolean golJugador1) {
        if (golJugador1) {
            golesJugador1++;
        } else {
            golesJugador2++;
        }

        golesLabel.setText("<html>Goles Jugador 1: " + golesJugador1 + "<br>Goles Jugador 2: " + golesJugador2 + "</html>");
    }
    private void crearBotonesDireccion() {
        // Inicializar la matriz de los botones
        direccionesJugador1 = new JToggleButton[3][3];
        direccionesJugador2 = new JToggleButton[3][3];

        // Crear los ButtonGroups
        ButtonGroup groupJugador1 = new ButtonGroup();
        ButtonGroup groupJugador2 = new ButtonGroup();

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

                // Añadir los botones a los ButtonGroups
                groupJugador1.add(buttonTirarJugador1);
                groupJugador2.add(buttonTirarJugador2);

                // Añadir los botones al panel del jugador 1
                panelJugador1.add(buttonTirarJugador1);

                // Añadir los botones al panel del jugador 2
                panelJugador2.add(buttonTirarJugador2);
            }
        }
    }
    private void updateTurnInfo() {
        if (turnManager.isTurnoJugador1()) {
            infoTurno.setText("Turno del jugador 1");
        } else {
            infoTurno.setText("Turno del jugador 2");
        }
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
    private void inicializarProbabilidades() {
        probabilidadDeGol.put("Arriba Izquierda", 0.4);
        probabilidadDeGol.put("Arriba", 0.25);
        probabilidadDeGol.put("Arriba Derecha", 0.4);
        probabilidadDeGol.put("Izquierda", 0.25);
        probabilidadDeGol.put("Centro", 0.2);
        probabilidadDeGol.put("Derecha", 0.25);
        probabilidadDeGol.put("Abajo Izquierda", 0.5);
        probabilidadDeGol.put("Abajo", 0.25);
        probabilidadDeGol.put("Abajo Derecha", 0.5);
    }

    private boolean porteroPara(String direccion) {
        cambiarDireccionPortero();
        double probabilidad = probabilidadDeGol.get(direccion);
        return random.nextDouble() >= probabilidad;
    }
    private void cambiarDireccionPortero() {
        int index = random.nextInt(direcciones.size());
        direccionPortero = direcciones.get(index);
    }

    public static void main(String[] args) {
        JuegoMultiplayer juego = new JuegoMultiplayer();
        juego.setVisible(true);
    }
}





