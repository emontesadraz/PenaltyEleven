package com.penaltyeleven;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JuegoMultiplayer extends InterfazMaestra {

    private static final int NUM_PENALES = 5;
    private int turno = 0;
    private int penalesRestantes1 = NUM_PENALES;
    private int penalesRestantes2 = NUM_PENALES;
    private int aciertos1 = 0;
    private int aciertos2 = 0;
    private int[] tiroActual = new int[2];
    private boolean jugador1Tira = true;
    private boolean seleccionPortero = false;
    private int[] porteroSeleccion = new int[4];
    private int seleccionPorteroCount = 0;

    public static final Color colorBaseBotones = new Color(25, 25, 25);
    public static final Font fuenteBoton = new Font("Rubik", Font.PLAIN, 20);
    public static final Color colorTexto = new Color(255, 255, 255);
    private final MusicManager musicManager = new MusicManager();

    private JButton accionBoton = new JButton();
    private JButton seguirBoton = new JButton("Seguir");
    private final JButton[][] botones = new JButton[3][3];
    private JLabel marcadorLabel = new JLabel("Jugador 1: 0 | Jugador 2: 0");
    private JLabel estadoLabel = new JLabel("Jugador 1 tira");

    public JuegoMultiplayer() {
        setTitle("Penalty Eleven");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height); // Pantalla completa
        setLocationRelativeTo(null);
        setResizable(false);

        // Icono
        setIconImage(new ImageIcon("src/Imagenes/Logo.png").getImage());

        // Panel superior para el marcador y estado
        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new BorderLayout());
        panelSuperior.add(marcadorLabel, BorderLayout.WEST);
        panelSuperior.add(estadoLabel, BorderLayout.EAST);
        marcadorLabel.setFont(new Font("Rubik", Font.BOLD, 24));
        estadoLabel.setFont(new Font("Rubik", Font.BOLD, 24));

        // Panel portería con imagen de fondo
        JPanel porteriaPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Carga la imagen de fondo
                ImageIcon imagenFondo = new ImageIcon("src/Imagenes/Fondo/porteria3.png");
                // Dibuja la imagen de fondo
                g.drawImage(imagenFondo.getImage(), 0, 0, getWidth(), getHeight(), null);
            }
        };
        porteriaPanel.setLayout(null); // Usamos un layout null para poder posicionar los elementos manualmente

        // Añadimos los botones a este panel
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                final int x = i;
                final int y = j;
                botones[i][j] = new JButton();
                botones[i][j].setContentAreaFilled(false);
                botones[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
                botones[i][j].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (!seleccionPortero) {
                            tiroActual[0] = x;
                            tiroActual[1] = y;
                            marcarTiro(x, y);
                        } else {
                            seleccionarParada(x, y);
                        }
                    }
                });
                porteriaPanel.add(botones[i][j]);
            }
        }

        porteriaPanel.addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent evt) {
                int anchoBoton = porteriaPanel.getWidth() / 3;
                int altoBoton = porteriaPanel.getHeight() / 3;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        botones[i][j].setBounds(j * anchoBoton, i * altoBoton, anchoBoton, altoBoton);
                    }
                }
            }
        });

        // Paneles laterales
        JPanel panelIzquierdo = new JPanel();
        JPanel panelDerecho = new JPanel();

        // Definimos el tamaño de los paneles laterales
        Dimension panelLateralSize = new Dimension(200, getHeight());
        panelIzquierdo.setPreferredSize(panelLateralSize);
        panelDerecho.setPreferredSize(panelLateralSize);

        panelIzquierdo.setBackground(Color.GRAY); // Cambia el color de fondo si es necesario
        panelDerecho.setBackground(Color.GRAY); // Cambia el color de fondo si es necesario

        // Panel inferior para los botones de acción
        JPanel panelInferior = new JPanel();
        panelInferior.setLayout(new FlowLayout());

        // Botón Tirar/Parar
        crearBoton(accionBoton, "Tirar", 120, 595, 460, 45, colorBaseBotones, colorTexto, fuenteBoton, "Musica/SoundEffect/SonidoSeleccion.wav", 0.6f);
        panelInferior.add(accionBoton);

        // Botón Seguir
        crearBoton(seguirBoton, "Seguir", 700, 595, 460, 45, colorBaseBotones, colorTexto, fuenteBoton, "Musica/SoundEffect/SonidoSeleccion.wav", 0.6f);
        seguirBoton.setVisible(false);
        seguirBoton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                musicManager.playSound("Musica/SoundEffect/SonidoElegir1.wav", 0.7f);
                resetearBotones();
                setBotonesContentAreaFilled(false);
                seguirBoton.setVisible(false);
                accionBoton.setEnabled(true);
                estadoLabel.setText(jugador1Tira ? "Jugador 1 tira" : "Jugador 2 tira");
                tiroActual[0] = 0;
                tiroActual[1] = 0;
            }
        });
        panelInferior.add(seguirBoton);

        accionBoton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                musicManager.playSound("Musica/SoundEffect/SonidoElegir1.wav", 0.7f);
                if (jugador1Tira) {
                    if (!seleccionPortero) {
                        if (tiroActual[0] == 0 && tiroActual[1] == 0) {
                            estadoLabel.setText("Seleccione una casilla para tirar.");
                        } else {
                            estadoLabel.setText("Jugador 2 selecciona parada");
                            seleccionPortero = true;
                            accionBoton.setText("Parar");
                            ocultarTiro();
                        }
                    } else {
                        if (seleccionPorteroCount < 2) {
                            estadoLabel.setText("Seleccione dos casillas para parar.");
                        } else {
                            estadoLabel.setText("Jugador 1 tira");
                            seleccionPortero = false;
                            jugador1Tira = false;
                            procesarTurno();
                            accionBoton.setText("Tirar");
                            mostrarResultados();
                        }
                    }
                } else {
                    if (!seleccionPortero) {
                        if (tiroActual[0] == 0 && tiroActual[1] == 0) {
                            estadoLabel.setText("Seleccione una casilla para tirar.");
                        } else {
                            estadoLabel.setText("Jugador 1 selecciona parada");
                            seleccionPortero = true;
                            accionBoton.setText("Parar");
                            ocultarTiro();
                        }
                    } else {
                        if (seleccionPorteroCount < 2) {
                            estadoLabel.setText("Seleccione dos casillas para parar.");
                        } else {
                            estadoLabel.setText("Jugador 2 tira");
                            seleccionPortero = false;
                            jugador1Tira = true;
                            procesarTurno();
                            accionBoton.setText("Tirar");
                            mostrarResultados();
                        }
                    }
                }
            }
        });

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(panelSuperior, BorderLayout.NORTH);
        mainPanel.add(panelIzquierdo, BorderLayout.WEST);
        mainPanel.add(panelDerecho, BorderLayout.EAST);
        mainPanel.add(porteriaPanel, BorderLayout.CENTER);
        mainPanel.add(panelInferior, BorderLayout.SOUTH);

        add(mainPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    private void marcarTiro(int x, int y) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                botones[i][j].setBackground(Color.WHITE);
            }
        }
        botones[x][y].setBackground(Color.YELLOW);
    }

    private void seleccionarParada(int x, int y) {
        if (seleccionPorteroCount < 2) {
            botones[x][y].setBackground(Color.GREEN);
            if (seleccionPorteroCount == 0) {
                porteroSeleccion[0] = x;
                porteroSeleccion[1] = y;
            } else {
                porteroSeleccion[2] = x;
                porteroSeleccion[3] = y;
            }
            seleccionPorteroCount++;
        }
    }

    private void ocultarTiro() {
        botones[tiroActual[0]][tiroActual[1]].setBackground(Color.WHITE);
    }

    private void procesarTurno() {
        boolean parada = false;
        if ((tiroActual[0] == porteroSeleccion[0] && tiroActual[1] == porteroSeleccion[1]) ||
                (tiroActual[0] == porteroSeleccion[2] && tiroActual[1] == porteroSeleccion[3])) {
            parada = true;
        }

        if (parada) {
            estadoLabel.setText("¡Parada!");
        } else {
            estadoLabel.setText("¡Gol!");
            if (jugador1Tira) {
                aciertos2++;
            } else {
                aciertos1++;
            }
        }

        actualizarMarcador();

        turno++;
        if (jugador1Tira) {
            penalesRestantes1--;
        } else {
            penalesRestantes2--;
        }

        seleccionPorteroCount = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                botones[i][j].setBackground(Color.WHITE);
            }
        }

        if (penalesRestantes1 == 0 && penalesRestantes2 == 0) {
            determinarGanador();
        }
    }

    private void mostrarResultados() {
        accionBoton.setEnabled(false);
        botones[tiroActual[0]][tiroActual[1]].setBackground(Color.RED);
        for (int i = 0; i < 2; i++) {
            botones[porteroSeleccion[i * 2]][porteroSeleccion[i * 2 + 1]].setBackground(Color.GREEN);
        }
        setBotonesContentAreaFilled(true);
        seguirBoton.setVisible(true);
    }

    private void setBotonesContentAreaFilled(boolean filled) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                botones[i][j].setContentAreaFilled(filled);
            }
        }
    }

    private void actualizarMarcador() {
        marcadorLabel.setText("Jugador 1: " + aciertos1 + " | Jugador 2: " + aciertos2);
    }

    private void resetearBotones() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                botones[i][j].setBackground(Color.WHITE);
            }
        }
    }

    private void determinarGanador() {
        if (aciertos1 > aciertos2) {
            estadoLabel.setText("Jugador 1 gana");
        } else if (aciertos2 > aciertos1) {
            estadoLabel.setText("Jugador 2 gana");
        } else {
            estadoLabel.setText("Empate, muerte súbita");
            // Implementar lógica de muerte súbita
            accionBoton.setEnabled(false);
        }
        accionBoton.setEnabled(false);
    }

    public static void main(String[] args) {
        new JuegoMultiplayer();
    }
}
