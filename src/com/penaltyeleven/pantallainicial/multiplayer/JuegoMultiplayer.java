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
    private JButton pararJugador1;
    private JButton pararJugador2;
    private JButton chutarJugador2;
    private TurnManager turnManager;
    private JPanel panelJugador1;
    private JPanel panelJugador2;
    private JPanel panelAbajo;
    private JLabel infoTurno;
    private JLabel golesLabel;
    private int golesJugador1;
    private int golesJugador2;
    private int seleccionPorteroCount = 0;
    private int[] porteroSeleccion = new int[4];

    public JuegoMultiplayer() {
        golesJugador1 = 0;
        golesJugador2 = 0;

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

        // Creamos el panelAbajo
        panelAbajo = new JPanel();
        panelAbajo.setSize(panel2Width, panel2Height);
        panelAbajo.setBackground(new Color(213, 23, 23, 255));
        panelAbajo.setLayout(null);
        add(panelAbajo);

        // Inicializamos las matrices de botones
        direccionesJugador1 = new JToggleButton[3][3];
        direccionesJugador2 = new JToggleButton[3][3];

        // Creamos los paneles de la portería para cada jugador
        JPanel porteriaPanelJugador1 = crearPanelPorteria(direccionesJugador1, true);
        JPanel porteriaPanelJugador2 = crearPanelPorteria(direccionesJugador2, false);

        // Añadimos los paneles de la portería a los paneles de los jugadores
        panelJugador1.add(porteriaPanelJugador1);
        panelJugador2.add(porteriaPanelJugador2);


        // Llamamos al método para crear los botones de dirección
        crearBotonesDireccion();

        // Creamos los botones a sus respectivos sitios
        chutarJugador1 = new JButton("Chutar");
        chutarJugador2 = new JButton("Chutar");

        // Creamos los botones de parar
        pararJugador1 = new JButton("Parar");
        pararJugador2 = new JButton("Parar");

        // Ponemos las medidas en las que queremos que estén los botones
        pararJugador1.setBounds(100, 500, 200, 100);
        pararJugador2.setBounds(100, 500, 200, 100);

        // Los deshabilitamos
        pararJugador1.setEnabled(false);
        pararJugador2.setEnabled(false);

        // Los añadimos a los paneles
        panelJugador1.add(pararJugador1);
        panelJugador2.add(pararJugador2);

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

                // Cambiar de panel
                panelJugador1.setVisible(false);
                panelJugador2.setVisible(true);

                chutarJugador1.setEnabled(false);
                pararJugador2.setEnabled(true);

                // No cambiar de turno aquí
                updateTurnInfo();
            }
        });
        // Botón para chutar del jugador 2
        chutarJugador2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String direccionSeleccionada = guardarDireccionSeleccionada(direccionesJugador2);
                if (direccionSeleccionada == null) {
                    JOptionPane.showMessageDialog(null, "Debes elegir una dirección antes de chutar.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Cambiar de panel
                panelJugador2.setVisible(false);
                panelJugador1.setVisible(true);

                chutarJugador2.setEnabled(false);
                pararJugador1.setEnabled(true);

                // No cambiar de turno aquí
                updateTurnInfo();
            }
        });


        // Botón para parar del jugador 1
        pararJugador1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<int[]> direccionesSeleccionadas = getDireccionesSeleccionadas(direccionesJugador1);
                seleccionarPortero(direccionesSeleccionadas.get(0)[0], direccionesSeleccionadas.get(0)[1], true);
                seleccionarPortero(direccionesSeleccionadas.get(1)[0], direccionesSeleccionadas.get(1)[1], true);


                chutarJugador1.setEnabled(true);
                pararJugador1.setEnabled(false);

                // Cambiar de turno
                procesarTurno();
                updateTurnInfo();
                finalizarPartido();
            }
        });
        // Botón para parar del jugador 2
        pararJugador2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<int[]> direccionesSeleccionadas = getDireccionesSeleccionadas(direccionesJugador2);
                seleccionarPortero(direccionesSeleccionadas.get(0)[0], direccionesSeleccionadas.get(0)[1], false);
                seleccionarPortero(direccionesSeleccionadas.get(1)[0], direccionesSeleccionadas.get(1)[1], false);




                chutarJugador2.setEnabled(true);
                pararJugador2.setEnabled(false);

                // Cambiar de turno
                procesarTurno();
                updateTurnInfo();
                finalizarPartido();
            }
        });

    }
    private List<int[]> getDireccionesSeleccionadas(JToggleButton[][] direcciones) {
        List<int[]> direccionesSeleccionadas = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (direcciones[i][j].isSelected()) {
                    direccionesSeleccionadas.add(new int[]{i, j});
                }
            }
        }
        return direccionesSeleccionadas; // Devuelve una lista con las direcciones seleccionadas
    }
    private void seleccionarPortero(int x, int y, boolean jugador1) {
        JToggleButton[][] direcciones = jugador1 ? direccionesJugador1 : direccionesJugador2;

        if (seleccionPorteroCount < 2) {
            direcciones[x][y].setBackground(Color.GREEN);
            if (seleccionPorteroCount == 0) {
                porteroSeleccion[0] = x;
                porteroSeleccion[1] = y;
            } else {
                porteroSeleccion[2] = x;
                porteroSeleccion[3] = y;
            }
            seleccionPorteroCount++;
        } else {
            JOptionPane.showMessageDialog(null, "No puedes seleccionar más de dos direcciones.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Si el portero ha sido seleccionado dos veces, intentar parar el tiro
        if (seleccionPorteroCount == 2) {
            int[] tiroActual = getTiroActual(!jugador1); // Obtener el tiro del otro jugador
            boolean parada = (tiroActual[0] == porteroSeleccion[0] && tiroActual[1] == porteroSeleccion[1]) ||
                    (tiroActual[0] == porteroSeleccion[2] && tiroActual[1] == porteroSeleccion[3]);

            if (parada) {
                ImageIcon icon = new ImageIcon("src/Imagenes/Parada.png");
                JOptionPane.showMessageDialog(null, "¡El portero ha detenido el tiro!", "Portero", JOptionPane.INFORMATION_MESSAGE, icon);
            } else {
                ImageIcon icon = new ImageIcon("src/Imagenes/Gol.png");
                JOptionPane.showMessageDialog(null, "", "Portero", JOptionPane.INFORMATION_MESSAGE, icon);
                if (!jugador1) { // Si el jugador actual es el jugador 2, entonces el tiro fue del jugador 1
                    golesJugador1++;
                } else {
                    golesJugador2++;
                }
            }
            actualizarGoles();

            // Llamada al método ocultarTiro
            ocultarTiro(tiroActual[0], tiroActual[1], !jugador1);

            if (turnManager.isGameFinished()) {
                finalizarPartido();
            }
        } else if (seleccionPorteroCount < 2) {
            JOptionPane.showMessageDialog(null, "Debes seleccionar dos direcciones antes de parar.", "Error", JOptionPane.ERROR_MESSAGE);
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
    private void actualizarGoles() {
        golesLabel.setText("Jugador 1: " + golesJugador1 + " | Jugador 2: " + golesJugador2);
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

                // Añadir oyentes de eventos a los botones
                buttonTirarJugador1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (chutarJugador1.isEnabled() && getDireccionesSeleccionadas(direccionesJugador1).size() > 1) {
                            JOptionPane.showMessageDialog(null, "Solo puedes seleccionar una dirección para chutar.", "Error", JOptionPane.ERROR_MESSAGE);
                            buttonTirarJugador1.setSelected(false);
                        } else if (pararJugador1.isEnabled() && getDireccionesSeleccionadas(direccionesJugador1).size() > 2) {
                            JOptionPane.showMessageDialog(null, "Solo puedes seleccionar dos direcciones para parar.", "Error", JOptionPane.ERROR_MESSAGE);
                            buttonTirarJugador1.setSelected(false);
                        }
                    }
                });

                buttonTirarJugador2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (chutarJugador2.isEnabled() && getDireccionesSeleccionadas(direccionesJugador2).size() > 1) {
                            JOptionPane.showMessageDialog(null, "Solo puedes seleccionar una dirección para chutar.", "Error", JOptionPane.ERROR_MESSAGE);
                            buttonTirarJugador2.setSelected(false);
                        } else if (pararJugador2.isEnabled() && getDireccionesSeleccionadas(direccionesJugador2).size() > 2) {
                            JOptionPane.showMessageDialog(null, "Solo puedes seleccionar dos direcciones para parar.", "Error", JOptionPane.ERROR_MESSAGE);
                            buttonTirarJugador2.setSelected(false);
                        }
                    }
                });
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
    private void marcarTiro(int x, int y, boolean jugador1) {
        JToggleButton[][] direcciones = jugador1 ? direccionesJugador1 : direccionesJugador2;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                direcciones[i][j].setBackground(Color.WHITE);
            }
        }
        direcciones[x][y].setBackground(Color.YELLOW);
    }
    private void ocultarTiro(int x, int y, boolean jugador1) {
        JToggleButton[][] direcciones = jugador1 ? direccionesJugador1 : direccionesJugador2;
        direcciones[x][y].setBackground(Color.WHITE);
    }
    private void procesarTurno() {
        boolean parada = false;
        int[] tiroActual = getTiroActual(turnManager.isTurnoJugador1());
        if ((tiroActual[0] == porteroSeleccion[0] && tiroActual[1] == porteroSeleccion[1]) ||
                (tiroActual[0] == porteroSeleccion[2] && tiroActual[1] == porteroSeleccion[3])) {
            parada = true;
        }

        if (parada) {
            ImageIcon icon = new ImageIcon("src/Imagenes/Parada.png");
            JOptionPane.showMessageDialog(null, "¡El portero ha detenido el tiro!", "Portero", JOptionPane.INFORMATION_MESSAGE, icon);
        } else {
            ImageIcon icon = new ImageIcon("src/Imagenes/Gol.png");
            JOptionPane.showMessageDialog(null, "", "Portero", JOptionPane.INFORMATION_MESSAGE, icon);
            if (turnManager.isTurnoJugador1()) {
                golesJugador1++;
            } else {
                golesJugador2++;
            }
        }
        actualizarGoles();

        // Llamada al método ocultarTiro
        ocultarTiro(tiroActual[0], tiroActual[1], turnManager.isTurnoJugador1());

        turnManager.nextTurn();
        updateTurnInfo();

        seleccionPorteroCount = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                direccionesJugador1[i][j].setBackground(Color.WHITE);
                direccionesJugador2[i][j].setBackground(Color.WHITE);
            }
        }

        if (turnManager.isGameFinished()) {
            finalizarPartido();
        }
    }

    private int[] getTiroActual(boolean jugador1) {
        JToggleButton[][] direcciones = jugador1 ? direccionesJugador1 : direccionesJugador2;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (direcciones[i][j].isSelected()) {
                    return new int[]{i, j};
                }
            }
        }
        return null; // Devuelve null si no se ha seleccionado ninguna dirección
    }
    private JPanel crearPanelPorteria(JToggleButton[][] direcciones, boolean jugador1) {
        JPanel porteriaPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Aquí puedes agregar código para pintar en el panel si lo necesitas
            }
        };
        porteriaPanel.setLayout(null); // Usamos un layout null para poder posicionar los elementos manualmente

        // Ahora añadimos los botones a este panel
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                final int x = i;
                final int y = j;
                direcciones[i][j] = new JToggleButton();
                direcciones[i][j].setContentAreaFilled(false);
                direcciones[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
                direcciones[i][j].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        seleccionarPortero(x, y, jugador1);
                        if (jugador1) {
                            marcarTiro(x, y, true);
                        } else {
                            marcarTiro(x, y, false);
                        }
                    }
                });
                // Establecemos las coordenadas y el tamaño de cada botón
                int anchoBoton = 422; // ajusta este valor según tus necesidades
                int altoBoton = 204; // ajusta este valor según tus necesidades
                direcciones[i][j].setBounds(j * anchoBoton, i * altoBoton, anchoBoton, altoBoton);
                porteriaPanel.add(direcciones[i][j]);
            }
        }

        return porteriaPanel;
    }
    public void finalizarPartido(){
        if (turnManager.isGameFinished()) {
            if (golesJugador1 > golesJugador2) {
                JOptionPane.showMessageDialog(null, "¡El jugador 1 ha ganado!", "Fin del partido", JOptionPane.INFORMATION_MESSAGE);
            } else if (golesJugador2 > golesJugador1) {
                JOptionPane.showMessageDialog(null, "¡El jugador 2 ha ganado!", "Fin del partido", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "¡Empate!", "Fin del partido", JOptionPane.INFORMATION_MESSAGE);

            }
        }
    }

    public static void main(String[] args) {
        JuegoMultiplayer juego = new JuegoMultiplayer();
        juego.setVisible(true);
    }
}





