package com.penaltyeleven.pantallainicial.multiplayer;

import com.penaltyeleven.metodosexternos.Equipos;
import com.penaltyeleven.metodosexternos.InterfazMaestra;
import com.penaltyeleven.metodosexternos.MusicManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Random;

/**
 * Clase que representa la pantalla de juego en modo multijugador.
 * @version 1.0, 2021-08-10
 */
public class JuegoMultiplayer extends InterfazMaestra {

    private static final int NUM_PENALES = 1;
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
    public static final Font fuenteBoton = new Font("Rubik", Font.PLAIN, 30);
    public static final Color colorTexto = new Color(255, 255, 255);
    private final MusicManager musicManager = new MusicManager();

    private JButton accionBoton = new JButton();
    private JButton seguirBoton = new JButton("Seguir");
    private final JButton[][] botones = new JButton[3][3];
    private JLabel marcadorLabel = new JLabel(" 0   -   0 ");
    private JLabel estadoLabel = new JLabel("Jugador 1 tira");
    private java.util.List<String> canciones = Arrays.asList("Musica/Soundtrack/MusicaPartidoBasico1.wav", "Musica/Soundtrack/MusicaPartidoBasico2.wav", "Musica/Soundtrack/MusicaPartidoBasico3.wav", "Musica/Soundtrack/MusicaPartidoBasico4.wav", "Musica/Soundtrack/MusicaPartidoBasico5.wav", "Musica/Soundtrack/MusicaPartidoBasico6.wav","Musica/Soundtrack/PartidoVsZeus.wav");
    private int currentSongsIndex = 0;

    // Variables para el equipo y el escudo seleccionados
    private Equipos equipoSeleccionado1;
    private Equipos equipoSeleccionado2;
    private JLabel equipo1Label;
    private JLabel equipo2Label;
    private BufferedImage escudoEquipoSeleccionado1;
    private BufferedImage escudoEquipoSeleccionado2;
    private boolean muerteSubitaMostrada = false;

    /**
     * Constructor de la clase JuegoMultiplayer.
     * @param equipoSeleccionado1 Equipo seleccionado por el jugador 1.
     * @param escudoEquipoSeleccionado1 Escudo del equipo seleccionado por el jugador 1.
     * @param equipoSeleccionado2 Equipo seleccionado por el jugador 2.
     * @param escudoEquipoSeleccionado2 Escudo del equipo seleccionado por el jugador 2.
     */
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

        // Escalar las imágenes
        int desiredWidth = 100; // Ajusta esto a la anchura deseada
        int desiredHeight = 100; // Ajusta esto a la altura deseada
        BufferedImage escudoEquipoSeleccionado1Scaled = scaleImage(escudoEquipoSeleccionado1, desiredWidth, desiredHeight);
        BufferedImage escudoEquipoSeleccionado2Scaled = scaleImage(escudoEquipoSeleccionado2, desiredWidth, desiredHeight);

        // Inicializar los JLabel de los Equipos
        equipo1Label = new JLabel(equipoSeleccionado1.getNombreEquipo());
        equipo1Label.setForeground(new Color(255,255,255));
        equipo1Label.setFont(new Font("Rubik", Font.BOLD | Font.ITALIC, 25));

        equipo2Label = new JLabel(equipoSeleccionado2.getNombreEquipo());
        equipo2Label.setForeground(new Color(255,255,255));
        equipo2Label.setFont(new Font("Rubik", Font.BOLD | Font.ITALIC, 25));

        // Crear ImageLabel para los escudos de los equipos
        ImageLabel escudo1Label = new ImageLabel(escudoEquipoSeleccionado1Scaled);
        escudo1Label.setPreferredSize(new Dimension(desiredWidth, desiredHeight));
        ImageLabel escudo2Label = new ImageLabel(escudoEquipoSeleccionado2Scaled);
        escudo2Label.setPreferredSize(new Dimension(desiredWidth, desiredHeight));

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
                int anchoBoton = 472; // ajusta este valor según tus necesidades
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

        // Panel para el marcador
        JPanel marcadorPanel = new JPanel();
        marcadorPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        marcadorPanel.setBackground(new Color(25,25,25));
        marcadorLabel.setForeground(new Color(255,255,255));
        marcadorLabel.setFont(new Font("Impact", Font.PLAIN, 70));



        marcadorPanel.add(escudo1Label, FlowLayout.LEFT);
        marcadorPanel.add(equipo1Label, BorderLayout.WEST);
        marcadorPanel.add(marcadorLabel, BorderLayout.CENTER);
        marcadorPanel.add(equipo2Label, BorderLayout.EAST);
        marcadorPanel.add(escudo2Label, BorderLayout.EAST);


        // Panel para los botones y etiquetas en el marcador
        JPanel botonesPanel = new JPanel();
        botonesPanel.setOpaque(false);
        botonesPanel.setLayout(new GridLayout(2, 3));

        // Panel de botones
        JPanel panelBotones = new JPanel(new GridLayout(1, 2));
        panelBotones.add(accionBoton, BorderLayout.WEST);
        panelBotones.add(seguirBoton, BorderLayout.EAST);

        JPanel controlPanel = new JPanel(new GridLayout(1, 3));
        controlPanel.setBackground(new Color(25,25,25));

        controlPanel.add(panelBotones);

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


        playNextSong();

        setVisible(true);
    }

    /**
     * Método que marca la casilla seleccionada para el tiro.
     * @param x
     * @param y
     */
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

    /**
     * Método que selecciona la casilla de la portería para la parada.
     * @param x
     * @param y
     */
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

    /**
     * Método que oculta el tiro seleccionado.
     */
    private void ocultarTiro() {
        botones[tiroActual[0]][tiroActual[1]].setBackground(Color.WHITE);
    }
    /**
     * Método que procesa el turno del jugador.
     */
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
            imageIcon = new ImageIcon("src/Imagenes/Foto/parada.jpg");
        } else {
            imageIcon = new ImageIcon("src/Imagenes/Foto/gol.png");
        }
        JLabel label = new JLabel(imageIcon);

        // Establecer el mensaje del JOptionPane
        optionPane.setMessage(label);

        // Crear el JDialog y mostrarlo
        final JDialog dialog = optionPane.createDialog(null, "Resultado");
        dialog.setModal(false);
        dialog.setVisible(true);

        // Crear un Timer para cerrar el JDialog después de 900 ms
        Timer timer = new Timer(1100, new ActionListener() {
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
    /**
     * Método que muestra los resultados del tiro.
     */
    private void mostrarResultados() {
        accionBoton.setEnabled(false);
        botones[tiroActual[0]][tiroActual[1]].setBackground(Color.RED);
        for (int i = 0; i < 2; i++) {
            botones[porteroSeleccion[i * 2]][porteroSeleccion[i * 2 + 1]].setBackground(Color.GREEN);
        }
        setBotonesContentAreaFilled(true);
        seguirBoton.setVisible(true);
    }
    /**
     * Método que establece si los botones deben tener el área de contenido rellena.
     * @param filled
     */
    private void setBotonesContentAreaFilled(boolean filled) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                botones[i][j].setContentAreaFilled(filled);
            }
        }
    }

    /**
     * Método que actualiza el marcador.
     */
    private void actualizarMarcador() {
        marcadorLabel.setText(aciertos2 + "  -  " + aciertos1);
    }

    /**
     * Método que resetea los botones.
     */
    private void resetearBotones() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                botones[i][j].setBackground(Color.WHITE);
            }
        }
    }

    /**
     * Metodo que reproduce la siguiente canción.
     */
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

    /**
     * Método que determina al ganador del juego.
     */
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
            if (!muerteSubitaMostrada) {
                JOptionPane.showMessageDialog(null, "Muerte Súbita, que gane el mejor!", "Muerte Súbita", JOptionPane.INFORMATION_MESSAGE);
                muerteSubitaMostrada = true;
            }
            muerteSubita();
            accionBoton.setEnabled(false);
        }
        accionBoton.setEnabled(false);
    }
    /**
     * Método que determina al ganador en caso de muerte súbita.
     */
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

    /**
     * Clase que extiende a JLabel para mostrar una imagen.
     */
    public class ImageLabel extends JLabel {
        private BufferedImage image;

        public ImageLabel(BufferedImage image) {
            this.image = image;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (image != null) {
                g.drawImage(image, 0, 0, this);
            }
        }
    }

    /**
     * Método que escala una imagen.
     * @param source
     * @param width
     * @param height
     * @return
     */
    public BufferedImage scaleImage(BufferedImage source, int width, int height) {
        Image tmp = source.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage scaled = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = scaled.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return scaled;
    }
}
