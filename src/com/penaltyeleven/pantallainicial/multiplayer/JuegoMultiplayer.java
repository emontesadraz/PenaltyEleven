package com.penaltyeleven.pantallainicial.multiplayer;

import com.penaltyeleven.metodosexternos.Equipos;
import com.penaltyeleven.metodosexternos.InterfazMaestra;
import com.penaltyeleven.metodosexternos.MusicManager;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Arrays;
import java.util.Random;

public class JuegoMultiplayer extends InterfazMaestra {

    private static final int NUM_PENALES = 3;
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
    private JButton[][] botonesTiro1 = new JButton[1][3];
    private JButton[][] botonesParada1 = new JButton[1][3];
    private JButton[][] botonesTiro2 = new JButton[1][3];
    private JButton[][] botonesParada2 = new JButton[1][3];
    CardLayout cardLayout = new CardLayout();
    JPanel panelBotones = new JPanel(cardLayout);
    private int tiroSeleccionado = -1; // Nueva variable de instancia

    public static final Color colorBaseBotones = new Color(25, 25, 25);
    public static final Font fuenteBoton = new Font("Rubik", Font.PLAIN, 20);
    public static final Color colorTexto = new Color(255, 255, 255);
    private final MusicManager musicManager = new MusicManager();

    private JButton accionBoton = new JButton();
    private JButton seguirBoton = new JButton("Seguir");
    private final JButton[][] botones = new JButton[3][3];
    private JLabel marcadorLabel = new JLabel("Jugador 1: 0 | Jugador 2: 0");
    private JLabel estadoLabel = new JLabel("Jugador 1 tira");
    private java.util.List<String> canciones = Arrays.asList("Musica/Soundtrack/MusicaPartidoBasico1.wav", "Musica/Soundtrack/MusicaPartidoBasico2.wav", "Musica/Soundtrack/MusicaPartidoBasico3.wav", "Musica/Soundtrack/MusicaPartidoBasico4.wav", "Musica/Soundtrack/MusicaPartidoBasico5.wav", "Musica/Soundtrack/MusicaPartidoBasico6.wav" );
    private int currentSongsIndex = 0;

    // Variables para el equipo y el escudo seleccionados
    private Equipos equipoSeleccionado1;
    private BufferedImage escudoEquipoSeleccionado1;
    private Equipos equipoSeleccionado2;
    private BufferedImage escudoEquipoSeleccionado2;
    private JLabel equipo1Label;
    private JLabel escudo1Label;
    private JLabel equipo2Label;
    private JLabel escudo2Label;

    public JuegoMultiplayer() {

    }

    public JuegoMultiplayer(Equipos equipoSeleccionado1, BufferedImage escudoEquipoSeleccionado1, Equipos equipoSeleccionado2, BufferedImage escudoEquipoSeleccionado2) {
        setTitle("Penalty Eleven");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1430, 870);
        setLocationRelativeTo(null);
        setResizable(false);
        // Icono
        setIconImage(new ImageIcon("src/Imagenes/Logo.png").getImage());

        this.equipoSeleccionado1 = equipoSeleccionado1;
        this.escudoEquipoSeleccionado1 = escudoEquipoSeleccionado1;
        this.equipoSeleccionado2 = equipoSeleccionado2;
        this.escudoEquipoSeleccionado2 = escudoEquipoSeleccionado2;

        // Panel de marcador
        JPanel marcadorPanel = new JPanel();
        marcadorPanel.setLayout(new BorderLayout());
        marcadorPanel.setPreferredSize(new Dimension(1430, 120)); // Ajustar altura
        marcadorPanel.setBackground(new Color(0, 51, 102));
        marcadorLabel.setForeground(Color.WHITE);
        marcadorLabel.setFont(new Font("Rubik", Font.BOLD, 24));
        marcadorLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Inicializar los JLabel

        equipo1Label = new JLabel(equipoSeleccionado1.getNombreEquipo());
        equipo1Label.setFont(new Font("Rubik", Font.PLAIN, 20));


        equipo2Label = new JLabel(equipoSeleccionado2.getNombreEquipo());
        equipo2Label.setFont(new Font("Rubik", Font.PLAIN, 20));

        BufferedImage escudoImg1 = ImageIO.read(new File(equipo1.getImagenEquipo()));
        JLabel escudo1 = new JLabel(new ImageIcon(escudoImg1.getScaledInstance(200, 200, Image.SCALE_DEFAULT)));
        escudo1.setBorder(null);

        //Label Escudo2
        BufferedImage escudoImg2 = ImageIO.read(new File(escudoEquipoSeleccionado1));
        JLabel escudo2 = new JLabel(new ImageIcon(escudoImg2.getScaledInstance(200, 200, Image.SCALE_DEFAULT)));
        escudo2.setBorder(null);

        // Inicializar los botones de las supertécnicas de tiro y parada
        for (int i = 0; i < 3; i++) {
            botonesTiro1[0][i] = new JButton();
            botonesParada1[0][i] = new JButton();
            botonesTiro2[0][i] = new JButton();
            botonesParada2[0][i] = new JButton();
        }

        // Añadir cada conjunto de botones al panel con un nombre único
        JPanel panelTiro1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel panelParada1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel panelTiro2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel panelParada2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        for (int i = 0; i < 3; i++) {
            panelTiro1.add(botonesTiro1[0][i]);
            panelParada1.add(botonesParada1[0][i]);
            panelTiro2.add(botonesTiro2[0][i]);
            panelParada2.add(botonesParada2[0][i]);
        }
        panelBotones.add(panelTiro1, "Tiro1");
        panelBotones.add(panelParada1, "Parada1");
        panelBotones.add(panelTiro2, "Tiro2");
        panelBotones.add(panelParada2, "Parada2");

        for (int i = 0; i < 3; i++) {
            final int tiroIndex = i + 1;
            botonesTiro1[0][i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    tiroSeleccionado = tiroIndex;
                    // No procesar el turno inmediatamente
                }
            });
            botonesTiro2[0][i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    tiroSeleccionado = tiroIndex;
                    // No procesar el turno inmediatamente
                }
            });
        }


        marcadorPanel.add(marcadorLabel, BorderLayout.CENTER);
        marcadorPanel.add(panelBotones, BorderLayout.SOUTH);

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
                            // Mostrar botones de parada del jugador 2
                            cardLayout.show(panelBotones, "Parada2");
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
                            // Mostrar botones de tiro del jugador 1
                            cardLayout.show(panelBotones, "Tiro1");
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
                            // Mostrar botones de parada del jugador 1
                            cardLayout.show(panelBotones, "Parada1");
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
                            // Mostrar botones de tiro del jugador 2
                            cardLayout.show(panelBotones, "Tiro2");
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
        // Añadir los JLabel al panelBotones
        JPanel panelEquipo1 = new JPanel(new BorderLayout());
        panelEquipo1.add(equipo1Label);
        panelEquipo1.add(escudo1Label);

        JPanel panelEquipo2 = new JPanel(new BorderLayout());
        panelEquipo2.add(equipo2Label);
        panelEquipo2.add(escudo2Label);


        JPanel controlPanel = new JPanel();
        controlPanel.add(accionBoton);
        controlPanel.add(seguirBoton);
        controlPanel.add(panelEquipo1);
        controlPanel.add(panelEquipo2);


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

        actualizarBotonesTecnicas();

        playNextSong();

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

    @Override
    public void dispose() {
        musicManager.stopMusic();
        super.dispose();
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
        if (seleccionPorteroCount == 2) { // Verificar si el jugador 2 ha intentado parar el tiro
            if (tiroSeleccionado == 1 && ((tiroActual[0] == porteroSeleccion[0] && tiroActual[1] == porteroSeleccion[1]) ||
                    (tiroActual[0] == porteroSeleccion[2] && tiroActual[1] == porteroSeleccion[3]))) {
                parada = true;
            } else if (tiroSeleccionado == 2 && tiroActual[0] == porteroSeleccion[2] && tiroActual[1] == porteroSeleccion[3]) {
                parada = true;
            } else if (tiroSeleccionado == 3 && tiroActual[0] == porteroSeleccion[2] && tiroActual[1] == porteroSeleccion[3]) {
                parada = true;
            }
        }
        // Incrementar los goles del jugador correspondiente si no hay parada
        if (!parada) {
            if (jugador1Tira) {
                aciertos1++; // Incrementar el marcador del jugador 1
            } else {
                aciertos2++; // Incrementar el marcador del jugador 2
            }
        }

        // Si la diferencia de goles es 3 o más, determinar al ganador
        if (Math.abs(aciertos1 - aciertos2) >= 3) {
            determinarGanador();
            return;
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
        // Si estamos en muerte súbita y ambos jugadores han tenido un turno
        if (estadoLabel.getText().equals("Empate, muerte súbita") && turno % 2 == 0) {
            // Si un jugador ha anotado y el otro no, determinar al ganador
            if (aciertos1 != aciertos2) {
                determinarGanador();
            } else {
                // Si ambos jugadores anotaron o fallaron, reiniciar los aciertos y continuar
                aciertos1 = 0;
                aciertos2 = 0;
            }
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


    private void actualizarBotonesTecnicas() {
        if (jugador1Tira) {
            if (!seleccionPortero) {
                // Es el turno del jugador 1 para tirar
                String[] tecnicasTiro1 = {equipoSeleccionado1.getTiro1(), equipoSeleccionado1.getTiro2(), equipoSeleccionado1.getTiro3()};
                for (int i = 0; i < 3; i++) {
                    botonesTiro1[0][i].setText(tecnicasTiro1[i]);
                }
                cardLayout.show(panelBotones, "Tiro1");
            } else {
                // Es el turno del jugador 1 para parar
                String[] tecnicasParada1 = {equipoSeleccionado1.getParada1(), equipoSeleccionado1.getParada2(), equipoSeleccionado1.getParada3()};
                for (int i = 0; i < 3; i++) {
                    botonesParada1[0][i].setText(tecnicasParada1[i]);
                }
                cardLayout.show(panelBotones, "Parada1");
            }
        } else {
            if (!seleccionPortero) {
                // Es el turno del jugador 2 para tirar
                String[] tecnicasTiro2 = {equipoSeleccionado2.getTiro1(), equipoSeleccionado2.getTiro2(), equipoSeleccionado2.getTiro3()};
                for (int i = 0; i < 3; i++) {
                    botonesTiro2[0][i].setText(tecnicasTiro2[i]);
                }
                cardLayout.show(panelBotones, "Tiro2");
            } else {
                // Es el turno del jugador 2 para parar
                String[] tecnicasParada2 = {equipoSeleccionado2.getParada1(), equipoSeleccionado2.getParada2(), equipoSeleccionado2.getParada3()};
                for (int i = 0; i < 3; i++) {
                    botonesParada2[0][i].setText(tecnicasParada2[i]);
                }
                cardLayout.show(panelBotones, "Parada2");
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
        actualizarBotonesTecnicas();
    }

    private void playNextSong() {
        if (canciones.isEmpty()) {
            return;
        }

        // Si es la primera vez que se llama a playNextSong, selecciona una canción aleatoria
        if (currentSongsIndex == 0) {
            Random random = new Random();
            currentSongsIndex = random.nextInt(canciones.size());
        }

        String song = canciones.get(currentSongsIndex);
        musicManager.stopMusic();
        musicManager.playMusic(song, 0.5f);
    }

    private void determinarGanador() {
        if (aciertos2 > aciertos1) {
            Jugador1Gana jugador1Gana = new Jugador1Gana(equipoSeleccionado1, escudoEquipoSeleccionado1, equipoSeleccionado2, escudoEquipoSeleccionado2);
            jugador1Gana.setVisible(true);
            dispose();
        } else if (aciertos1 > aciertos2) {
            Jugador2Gana jugador2Gana = new Jugador2Gana(equipoSeleccionado1, escudoEquipoSeleccionado1, equipoSeleccionado2, escudoEquipoSeleccionado2);
            jugador2Gana.setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Muerte Súbita, que gane el mejor!", "Muerte Súbita", JOptionPane.INFORMATION_MESSAGE);
            muerteSubita();
            accionBoton.setEnabled(false);
        }
        accionBoton.setEnabled(false);
    }

    private void muerteSubita() {
        penalesRestantes1 = 1;
        penalesRestantes2 = 1;
        turno = 0;
        aciertos1 = 0;
        aciertos2 = 0;
        jugador1Tira = true;

        // Si estamos en muerte súbita y ambos jugadores han tenido un turno
        if (turno % 2 == 0) {
            // Si el jugador 1 ha anotado y el jugador 2 no, el jugador 1 gana
            if (aciertos1 > 0 && aciertos2 == 0) {
                Jugador1Gana jugador1Gana = new Jugador1Gana(equipoSeleccionado1, escudoEquipoSeleccionado1, equipoSeleccionado2, escudoEquipoSeleccionado2);
                jugador1Gana.setVisible(true);
                dispose();
            }
            // Si el jugador 2 ha anotado y el jugador 1 no, el jugador 2 gana
            else if (aciertos2 > 0 && aciertos1 == 0) {
                Jugador2Gana jugador2Gana = new Jugador2Gana(equipoSeleccionado1, escudoEquipoSeleccionado1, equipoSeleccionado2, escudoEquipoSeleccionado2);
                jugador2Gana.setVisible(true);
                dispose();
            }
        }
    }
}
