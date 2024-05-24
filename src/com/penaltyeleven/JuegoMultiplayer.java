package com.penaltyeleven;

import com.penaltyeleven.pantallainicial.multiplayer.Jugador1Gana;
import com.penaltyeleven.pantallainicial.multiplayer.Jugador2Gana;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class JuegoMultiplayer extends InterfazMaestra {

    private static final int NUM_PENALES = 5;
    private int turno = 0;
    private int penalesRestantes1 = NUM_PENALES;
    private int penalesRestantes2 = NUM_PENALES;
    private int aciertos1 = 0;
    private int aciertos2 = 0;
    private int[] tiroActual = {-1, -1}; // Inicializar en -1 para indicar que no se ha seleccionado ninguna casilla
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
    String[] canciones = {"Musica/Soundtrack/MusicaPartidoBasico1.wav", "Musica/Soundtrack/MusicaPartidoBasico2.wav", "Musica/Soundtrack/MusicaPartidoBasico3.wav", "Musica/Soundtrack/MusicaPartidoBasico4.wav"};
    private Timer timer;

    public JuegoMultiplayer() {
        setTitle("Penalty Eleven");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1430, 870);
        setLocationRelativeTo(null);
        setResizable(false);
        // Icono
        setIconImage(new ImageIcon("src/Imagenes/Logo.png").getImage());

        // Panel de marcador
        JPanel marcadorPanel = new JPanel();
        marcadorPanel.setLayout(new BorderLayout());
        marcadorPanel.setPreferredSize(new Dimension(1430, 120)); // Ajustar altura
        marcadorPanel.setBackground(new Color(0, 51, 102));
        marcadorLabel.setForeground(Color.WHITE);
        marcadorLabel.setFont(new Font("Rubik", Font.BOLD, 24));
        marcadorLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Panel para los botones y etiquetas en el marcador
        JPanel botonesPanel = new JPanel();
        botonesPanel.setOpaque(false);
        botonesPanel.setLayout(new GridLayout(2, 3, 10, 0));

        String[] superTecnicas = {"SuperTecnica Nivel 1", "SuperTecnica Nivel 2", "SuperTecnica Nivel 3"};
        for (String tecnica : superTecnicas) {
            JLabel etiqueta = new JLabel(tecnica);
            etiqueta.setFont(new Font("Rubik", Font.PLAIN, 16));
            etiqueta.setForeground(Color.WHITE);
            etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
            botonesPanel.add(etiqueta);
        }

        //Hacer que el nombre de las supertecnicas sean las que tenga el equipo que escogimos
        JButton tecnica1Boton = new JButton();
        crearBoton(tecnica1Boton, "Técnica 1", 50, 50, 150, 30, Color.BLUE, Color.BLACK, fuenteBoton, "Musica/SoundEffect/SonidoSeleccion.wav", 0.6f);
        JButton tecnica2Boton = new JButton();
        crearBoton(tecnica2Boton, "Técnica 2", 250, 50, 150, 30, Color.YELLOW, Color.BLACK, fuenteBoton, "Musica/SoundEffect/SonidoSeleccion.wav", 0.6f);
        JButton tecnica3Boton = new JButton();
        crearBoton(tecnica3Boton, "Técnica 3", 450, 50, 150, 30, Color.RED, Color.BLACK, fuenteBoton, "Musica/SoundEffect/SonidoSeleccion.wav", 0.6f);

        botonesPanel.add(tecnica1Boton);
        botonesPanel.add(tecnica2Boton);
        botonesPanel.add(tecnica3Boton);

        marcadorPanel.add(marcadorLabel, BorderLayout.CENTER);
        marcadorPanel.add(botonesPanel, BorderLayout.SOUTH);

        // Panel de la portería
        JPanel porteriaPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Carga la imagen de fondo
                ImageIcon imagenFondo = new ImageIcon("src/Imagenes/Fondo/porteriaConFondo.png");
                // Dibuja la imagen de fondo
                g.drawImage(imagenFondo.getImage(), 0, 0, getWidth(), getHeight(), null);
            }
        };
        porteriaPanel.setLayout(null); // Usamos un layout null para poder posicionar los elementos manualmente

        // Ahora añadimos los botones a este panel
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
                // Establecemos las coordenadas y el tamaño de cada botón
                int anchoBoton = 479; // ajusta este valor según tus necesidades
                int altoBoton = 210; // ajusta este valor según tus necesidades
                botones[i][j].setBounds(j * anchoBoton, i * altoBoton, anchoBoton, altoBoton);
                porteriaPanel.add(botones[i][j]);
            }
        }

        // Boton Tirar/Parar
        crearBoton(accionBoton, "Tirar", 120, 595, 460, 45, colorBaseBotones, colorTexto, fuenteBoton, "Musica/SoundEffect/SonidoSeleccion.wav", 0.6f);
        accionBoton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                musicManager.playSound("Musica/SoundEffect/SonidoElegir1.wav", 0.7f);
                if (jugador1Tira) {
                    if (!seleccionPortero) {
                        if (tiroActual[0] == -1 && tiroActual[1] == -1) {
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
                        if (tiroActual[0] == -1 && tiroActual[1] == -1) {
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

        // Boton Seguir
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

                tiroActual[0] = -1;
                tiroActual[1] = -1;
            }
        });

        JPanel controlPanel = new JPanel();
        controlPanel.add(accionBoton);
        controlPanel.add(seguirBoton);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(porteriaPanel, BorderLayout.CENTER);
        mainPanel.add(controlPanel, BorderLayout.SOUTH);
        mainPanel.add(marcadorPanel, BorderLayout.NORTH);

        // Ajustar la etiqueta de estado para el pie de página
        estadoLabel.setForeground(Color.BLACK);
        estadoLabel.setBackground(Color.WHITE);
        estadoLabel.setOpaque(true);
        estadoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        estadoLabel.setFont(new Font("Rubik", Font.PLAIN, 18));

        add(mainPanel, BorderLayout.CENTER);
        add(estadoLabel, BorderLayout.SOUTH);

        // Inicializamos el temporizador
        timer = new Timer(2000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Cerrar el JOptionPane después de 2 segundos
                JOptionPane.getRootFrame().dispose();
            }
        });
        Random random = new Random();
        int indiceCancionAleatoria = random.nextInt(canciones.length);
        String cancionAleatoria = canciones[indiceCancionAleatoria];
        musicManager.playSound(cancionAleatoria, 0.6f);

        setVisible(true);
    }

    // Método para crear botones en el marcador
    private JButton crearBotonMarcador(String texto) {
        JButton boton = new JButton(texto);
        boton.setFont(new Font("Rubik", Font.PLAIN, 16));
        boton.setBackground(colorBaseBotones);
        boton.setForeground(colorTexto);
        boton.setFocusPainted(false);
        boton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        return boton;
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
        // Incrementar los goles del jugador correspondiente si no hay parada
        if (!parada) {
            if (jugador1Tira) {
                aciertos1++;
            } else {
                aciertos2++;
            }
        }

        // Crear el JOptionPane
        final JOptionPane optionPane = new JOptionPane();
        optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);

        // Crear el ImageIcon y el JLabel
        ImageIcon imageIcon;
        if (parada) {
            imageIcon = new ImageIcon("src/Imagenes/Parada.png");
        } else {
            imageIcon = new ImageIcon("src/Imagenes/Gol.png");
        }
        JLabel label = new JLabel(imageIcon);

        // Establecer el mensaje del JOptionPane
        optionPane.setMessage(label);

        // Crear el JDialog y mostrarlo
        final JDialog dialog = optionPane.createDialog(null, "Resultado");
        dialog.setModal(false);
        dialog.setVisible(true);

        // Crear un Timer para cerrar el JDialog después de 2 segundos
        Timer timer = new Timer(1500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });
        timer.setRepeats(false);
        timer.start();

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
        marcadorLabel.setText("Jugador 1: " + aciertos2 + " | Jugador 2: " + aciertos1);
    }

    private void resetearBotones() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                botones[i][j].setBackground(Color.WHITE);
            }
        }
    }

    private void determinarGanador() {
        if (aciertos2 > aciertos1) {
            Jugador1Gana jugador1Gana = new Jugador1Gana();
            jugador1Gana.setVisible(true);
            dispose();
        } else if (aciertos1 > aciertos2) {
            Jugador2Gana jugador2Gana = new Jugador2Gana();
            jugador2Gana.setVisible(true);
            dispose();
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
