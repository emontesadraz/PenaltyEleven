import com.juego.multiplayer.Jugador1;
import com.juego.multiplayer.Jugador2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JuegoMultiplayer extends JFrame {

    private Jugador1 jugador1;
    private Jugador2 jugador2;
    public static final Color colorBaseBotones = new Color(25, 25, 25);
    private final MusicManager musicManager = new MusicManager();
    private JToggleButton tirarArribaIzquierda;
    private JToggleButton tirarCentroIzquierda;
    private JToggleButton tirarAbajoIzquierda;
    private JToggleButton tirarArribaCentro;
    private JToggleButton tirarCentroCentro;
    private JToggleButton tirarAbajoCentro;
    private JToggleButton tirarArribaDerecha;
    private JToggleButton tirarCentroDerecha;
    private JToggleButton tirarAbajoDerecha;
    private JToggleButton pararArribaIzquierda;
    private JToggleButton pararCentroIzquierda;
    private JToggleButton pararAbajoIzquierda;
    private JToggleButton pararArribaCentro;
    private JToggleButton pararCentroCentro;
    private JToggleButton pararAbajoCentro;
    private JToggleButton pararArribaDerecha;
    private JToggleButton pararCentroDerecha;
    private JToggleButton pararAbajoDerecha;
    private JButton chutarJugador1;
    private JButton pararJugador1;
    private JButton chutarJugador2;
    private JButton pararJugador2;
    private Jugador1.Direccion direccionTiroJugador1_1;
    private Jugador2.Direccion direccionTiroJugador2_1;
    private Jugador1.Direccion direccionParadaJugador1;
    private Jugador1.Direccion direccionParadaJugador1_2;
    private Jugador2.Direccion direccionParadaJugador2;
    private Jugador2.Direccion direccionParadaJugador2_2;
    private boolean turnoJugador1;
    private int turnos;
    private static final int MAX_TURNOS = 5;

    public JuegoMultiplayer() {
        // Configuramos el JFrame
        setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
        setTitle("Penalty Eleven");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        turnos = 0;
        turnoJugador1 = true; // Empieza el jugador 1

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


        // Creamos los jugadores
        jugador1 = new Jugador1();
        jugador2 = new Jugador2();

        // Creamos los botones de tiro
        tirarArribaIzquierda = new JToggleButton();
        tirarArribaDerecha = new JToggleButton();
        tirarArribaCentro = new JToggleButton();
        tirarCentroIzquierda = new JToggleButton();
        tirarCentroDerecha = new JToggleButton();
        tirarCentroCentro = new JToggleButton();
        tirarAbajoIzquierda = new JToggleButton();
        tirarAbajoDerecha = new JToggleButton();
        tirarAbajoCentro = new JToggleButton();

        // Configuramos los botones de parar
        pararArribaIzquierda = new JToggleButton();
        pararArribaDerecha = new JToggleButton();
        pararArribaCentro = new JToggleButton();
        pararCentroIzquierda = new JToggleButton();
        pararCentroDerecha = new JToggleButton();
        pararCentroCentro = new JToggleButton();
        pararAbajoIzquierda = new JToggleButton();
        pararAbajoDerecha = new JToggleButton();
        pararAbajoCentro = new JToggleButton();

        // Configuramos la posicion de los botones de tiro
        tirarArribaIzquierda.setBounds(500, 110, 300, 200);
        tirarCentroIzquierda.setBounds(500, 310, 300, 200);
        tirarAbajoIzquierda.setBounds(500, 510, 300, 200);
        tirarArribaCentro.setBounds(800, 110, 250, 200);
        tirarCentroCentro.setBounds(800, 310, 250, 200);
        tirarAbajoCentro.setBounds(800, 510, 250, 200);
        tirarArribaDerecha.setBounds(1050, 110, 300, 200);
        tirarCentroDerecha.setBounds(1050, 310, 300, 200);
        tirarAbajoDerecha.setBounds(1050, 510, 300, 200);

        // Configuramos la posicion de los botones de parar
        pararArribaIzquierda.setBounds(500, 110, 300, 200);
        pararCentroIzquierda.setBounds(500, 310, 300, 200);
        pararAbajoIzquierda.setBounds(500, 510, 300, 200);
        pararArribaCentro.setBounds(800, 110, 250, 200);
        pararCentroCentro.setBounds(800, 310, 250, 200);
        pararAbajoCentro.setBounds(800, 510, 250, 200);
        pararArribaDerecha.setBounds(1050, 110, 300, 200);
        pararCentroDerecha.setBounds(1050, 310, 300, 200);
        pararAbajoDerecha.setBounds(1050, 510, 300, 200);

        // Botón de chutar jugador1
        chutarJugador1 = new JButton("Tirar");
        chutarJugador1.setBounds(100, 350, 200, 100);

        // Botón de parar jugador 1
        pararJugador1 = new JButton("Parar");
        pararJugador1.setBounds(100, 350, 200, 100);

        // Botón de chutar jugador2
        chutarJugador2 = new JButton("Tirar");
        chutarJugador2.setBounds(100, 350, 200, 100);

        // Botón de parar jugador 2
        pararJugador2 = new JButton("Parar");
        pararJugador2.setBounds(100, 350, 200, 100);

        // Color del boton de chutar y de parar de los dos jugadores
        chutarJugador1.setBackground(colorBaseBotones);
        pararJugador1.setBackground(colorBaseBotones);
        chutarJugador2.setBackground(colorBaseBotones);
        pararJugador2.setBackground(colorBaseBotones);

        // Color de letras de los botones de jugadores
        chutarJugador1.setForeground(Color.WHITE);
        pararJugador1.setForeground(Color.WHITE);
        chutarJugador2.setForeground(Color.WHITE);
        pararJugador2.setForeground(Color.WHITE);

        // Añadimos los botones de dirección al panel de chutar jugador 1
        panelChutarJugador1.add(tirarArribaIzquierda);
        panelChutarJugador1.add(tirarArribaDerecha);
        panelChutarJugador1.add(tirarArribaCentro);
        panelChutarJugador1.add(tirarCentroIzquierda);
        panelChutarJugador1.add(tirarCentroDerecha);
        panelChutarJugador1.add(tirarCentroCentro);
        panelChutarJugador1.add(tirarAbajoIzquierda);
        panelChutarJugador1.add(tirarAbajoDerecha);
        panelChutarJugador1.add(tirarAbajoCentro);
        panelChutarJugador1.add(chutarJugador1);

        // Añadimos los botones de dirección al panel de chutar jugador 2
        panelChutarJugador2.add(tirarArribaIzquierda);
        panelChutarJugador2.add(tirarArribaDerecha);
        panelChutarJugador2.add(tirarArribaCentro);
        panelChutarJugador2.add(tirarCentroIzquierda);
        panelChutarJugador2.add(tirarCentroDerecha);
        panelChutarJugador2.add(tirarCentroCentro);
        panelChutarJugador2.add(tirarAbajoIzquierda);
        panelChutarJugador2.add(tirarAbajoDerecha);
        panelChutarJugador2.add(tirarAbajoCentro);
        panelChutarJugador2.add(chutarJugador2);


        // Añadimos los botones de dirección al panel de parada jugador 1
        panelPararJugador1.add(tirarArribaIzquierda);
        panelPararJugador1.add(tirarArribaDerecha);
        panelPararJugador1.add(tirarArribaCentro);
        panelPararJugador1.add(tirarCentroIzquierda);
        panelPararJugador1.add(tirarCentroDerecha);
        panelPararJugador1.add(tirarCentroCentro);
        panelPararJugador1.add(tirarAbajoIzquierda);
        panelPararJugador1.add(tirarAbajoDerecha);
        panelPararJugador1.add(tirarAbajoCentro);
        panelPararJugador1.add(chutarJugador2);


        // Añadimos los botones de dirección al panel de parar jugador 2
        panelPararJugador2.add(pararArribaIzquierda);
        panelPararJugador2.add(pararArribaDerecha);
        panelPararJugador2.add(pararArribaCentro);
        panelPararJugador2.add(pararCentroIzquierda);
        panelPararJugador2.add(pararCentroDerecha);
        panelPararJugador2.add(pararCentroCentro);
        panelPararJugador2.add(pararAbajoIzquierda);
        panelPararJugador2.add(pararAbajoDerecha);
        panelPararJugador2.add(pararAbajoCentro);
        panelPararJugador2.add(pararJugador1);



        // Listeners de los tiros
        tirarArribaIzquierda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí actualizas la dirección del tiro o de la parada dependiendo del turno
                if (turnoJugador1) {
                    direccionTiroJugador1_1 = Jugador1.Direccion.ARRIBAIZQUIERDA;
                } else {
                    direccionTiroJugador2_1 = Jugador2.Direccion.ARRIBAIZQUIERDA;
                }
            }
        });
        tirarArribaDerecha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí actualizas la dirección del tiro o de la parada dependiendo del turno
                if (turnoJugador1) {
                    direccionTiroJugador1_1 = Jugador1.Direccion.ARRIBADERECHA;
                } else {
                    direccionTiroJugador2_1 = Jugador2.Direccion.ARRIBADERECHA;
                }
            }
        });
        tirarArribaCentro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí actualizas la dirección del tiro o de la parada dependiendo del turno
                if (turnoJugador1) {
                    direccionTiroJugador1_1 = Jugador1.Direccion.CENTROARRIBA;
                } else {
                    direccionTiroJugador2_1 = Jugador2.Direccion.CENTROARRIBA;
                }
            }
        });
        tirarCentroIzquierda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí actualizas la dirección del tiro o de la parada dependiendo del turno
                if (turnoJugador1) {
                    direccionTiroJugador1_1 = Jugador1.Direccion.CENTROIZQUIERDA;
                } else {
                    direccionTiroJugador2_1 = Jugador2.Direccion.CENTROIZQUIERDA;
                }
            }
        });
        tirarCentroDerecha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí actualizas la dirección del tiro o de la parada dependiendo del turno
                if (turnoJugador1) {
                    direccionTiroJugador1_1 = Jugador1.Direccion.CENTRODERECHA;
                } else {
                    direccionTiroJugador2_1 = Jugador2.Direccion.CENTRODERECHA;
                }
            }
        });
        tirarCentroCentro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí actualizas la dirección del tiro o de la parada dependiendo del turno
                if (turnoJugador1) {
                    if (direccionTiroJugador1_1 == null) {
                        direccionTiroJugador1_1 = Jugador1.Direccion.ARRIBAIZQUIERDA;
                    } else {
                        JOptionPane.showMessageDialog(null, "Ya has seleccionado una dirección de tiro. No puedes seleccionar más de una.");
                    }
                } else {
                    if (direccionTiroJugador2_1 == null) {
                        direccionTiroJugador2_1 = Jugador2.Direccion.ARRIBAIZQUIERDA;
                    } else {
                        JOptionPane.showMessageDialog(null, "Ya has seleccionado una dirección de tiro. No puedes seleccionar más de una.");
                    }
                }
            }
        });
        tirarAbajoIzquierda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turnoJugador1) {
                    if (direccionTiroJugador1_1 == null) {
                        direccionTiroJugador1_1 = Jugador1.Direccion.ARRIBAIZQUIERDA;
                    } else {
                        JOptionPane.showMessageDialog(null, "Ya has seleccionado una dirección de tiro. No puedes seleccionar más de una.");
                    }
                } else {
                    if (direccionTiroJugador2_1 == null) {
                        direccionTiroJugador2_1 = Jugador2.Direccion.ARRIBAIZQUIERDA;
                    } else {
                        JOptionPane.showMessageDialog(null, "Ya has seleccionado una dirección de tiro. No puedes seleccionar más de una.");
                    }
                }
            }
        });
        tirarAbajoDerecha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí actualizas la dirección del tiro o de la parada dependiendo del turno
                if (turnoJugador1) {
                    if (direccionTiroJugador1_1 == null) {
                        direccionTiroJugador1_1 = Jugador1.Direccion.ARRIBAIZQUIERDA;
                    } else {
                        JOptionPane.showMessageDialog(null, "Ya has seleccionado una dirección de tiro. No puedes seleccionar más de una.");
                    }
                } else {
                    if (direccionTiroJugador2_1 == null) {
                        direccionTiroJugador2_1 = Jugador2.Direccion.ARRIBAIZQUIERDA;
                    } else {
                        JOptionPane.showMessageDialog(null, "Ya has seleccionado una dirección de tiro. No puedes seleccionar más de una.");
                    }
                }
            }
        });
        tirarAbajoCentro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí actualizas la dirección del tiro o de la parada dependiendo del turno
                if (turnoJugador1) {
                    if (direccionTiroJugador1_1 == null) {
                        direccionTiroJugador1_1 = Jugador1.Direccion.ARRIBAIZQUIERDA;
                    } else {
                        JOptionPane.showMessageDialog(null, "Ya has seleccionado una dirección de tiro. No puedes seleccionar más de una.");
                    }
                } else {
                    if (direccionTiroJugador2_1 == null) {
                        direccionTiroJugador2_1 = Jugador2.Direccion.ARRIBAIZQUIERDA;
                    } else {
                        JOptionPane.showMessageDialog(null, "Ya has seleccionado una dirección de tiro. No puedes seleccionar más de una.");
                    }
                }
            }
        });

        // Listeners de las paradas
        pararArribaIzquierda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí actualizas la dirección de la parada o del tiro dependiendo del turno
                if (turnoJugador1) {
                    if (direccionParadaJugador1 == null) {
                        direccionParadaJugador1 = Jugador1.Direccion.ARRIBAIZQUIERDA;
                    } else if (Math.abs(direccionParadaJugador1.getValor() - Jugador1.Direccion.ARRIBAIZQUIERDA.getValor()) == 1) {
                        direccionParadaJugador1_2 = Jugador1.Direccion.ARRIBAIZQUIERDA;
                    }
                } else {
                    if (direccionParadaJugador2 == null) {
                        direccionParadaJugador2 = Jugador2.Direccion.ARRIBAIZQUIERDA;
                    } else if (Math.abs(direccionParadaJugador2.getValor() - Jugador2.Direccion.ARRIBAIZQUIERDA.getValor()) == 1) {
                        direccionParadaJugador2_2 = Jugador2.Direccion.ARRIBAIZQUIERDA;
                    }
                }
            }
        });
        pararArribaDerecha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí actualizas la dirección de la parada o del tiro dependiendo del turno
                if (turnoJugador1) {
                    if (direccionParadaJugador1 == null) {
                        direccionParadaJugador1 = Jugador1.Direccion.ARRIBADERECHA;
                    } else if (Math.abs(direccionParadaJugador1.getValor() - Jugador1.Direccion.ARRIBADERECHA.getValor()) == 2) {
                        direccionParadaJugador1_2 = Jugador1.Direccion.ARRIBADERECHA;
                    }
                } else {
                    if (direccionParadaJugador2 == null) {
                        direccionParadaJugador2 = Jugador2.Direccion.ARRIBADERECHA;
                    } else if (Math.abs(direccionParadaJugador2.getValor() - Jugador2.Direccion.ARRIBADERECHA.getValor()) == 2) {
                        direccionParadaJugador2_2 = Jugador2.Direccion.ARRIBADERECHA;
                    }
                }
            }
        });
        pararArribaCentro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí actualizas la dirección de la parada o del tiro dependiendo del turno
                if (turnoJugador1) {
                    if (direccionParadaJugador1 == null) {
                        direccionParadaJugador1 = Jugador1.Direccion.CENTROARRIBA;
                    } else if (Math.abs(direccionParadaJugador2.getValor() - Jugador2.Direccion.CENTROARRIBA.getValor()) == 5) {
                        direccionParadaJugador1_2 = Jugador1.Direccion.CENTROARRIBA;
                    }
                } else {
                    if (direccionParadaJugador2 == null) {
                        direccionParadaJugador2 = Jugador2.Direccion.CENTROARRIBA;
                    } else if (Math.abs(direccionParadaJugador2.getValor() - Jugador2.Direccion.CENTROARRIBA.getValor()) == 5) {
                        direccionParadaJugador2_2 = Jugador2.Direccion.CENTROARRIBA;
                    }
                }
            }
        });
        pararCentroIzquierda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí actualizas la dirección de la parada o del tiro dependiendo del turno
                if (turnoJugador1) {
                    if (direccionParadaJugador1 == null) {
                        direccionParadaJugador1 = Jugador1.Direccion.CENTROIZQUIERDA;
                    } else if (Math.abs(direccionParadaJugador2.getValor() - Jugador2.Direccion.CENTROIZQUIERDA.getValor()) == 7) {
                        direccionParadaJugador1_2 = Jugador1.Direccion.CENTROIZQUIERDA;
                    }
                } else {
                    if (direccionParadaJugador2 == null) {
                        direccionParadaJugador2 = Jugador2.Direccion.CENTROIZQUIERDA;
                    } else if (Math.abs(direccionParadaJugador2.getValor() - Jugador2.Direccion.CENTROIZQUIERDA.getValor()) == 7) {
                        direccionParadaJugador2_2 = Jugador2.Direccion.CENTROIZQUIERDA;
                    }
                }
            }
        });
        pararCentroDerecha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí actualizas la dirección de la parada o del tiro dependiendo del turno
                if (turnoJugador1) {
                    if (direccionParadaJugador1 == null) {
                        direccionParadaJugador1 = Jugador1.Direccion.CENTRODERECHA;
                    } else if (Math.abs(direccionParadaJugador2.getValor() - Jugador2.Direccion.CENTRODERECHA.getValor()) == 8) {
                        direccionParadaJugador1_2 = Jugador1.Direccion.CENTRODERECHA;
                    }
                } else {
                    if (direccionParadaJugador2 == null) {
                        direccionParadaJugador2 = Jugador2.Direccion.CENTRODERECHA;
                    } else if (Math.abs(direccionParadaJugador2.getValor() - Jugador2.Direccion.CENTRODERECHA.getValor()) == 8) {
                        direccionParadaJugador2_2 = Jugador2.Direccion.CENTRODERECHA;
                    }
                }
            }
        });
        pararCentroCentro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí actualizas la dirección de la parada o del tiro dependiendo del turno
                if (turnoJugador1) {
                    if (direccionParadaJugador1 == null) {
                        direccionParadaJugador1 = Jugador1.Direccion.CENTRO;
                    } else if (Math.abs(direccionParadaJugador2.getValor() - Jugador2.Direccion.CENTRO.getValor()) == 9) {
                        direccionParadaJugador1_2 = Jugador1.Direccion.CENTRO;
                    }
                } else {
                    if (direccionParadaJugador2 == null) {
                        direccionParadaJugador2 = Jugador2.Direccion.CENTRO;
                    } else if (Math.abs(direccionParadaJugador2.getValor() - Jugador2.Direccion.CENTRO.getValor()) == 5) {
                        direccionParadaJugador2_2 = Jugador2.Direccion.CENTRO;
                    }
                }
            }
        });
        pararAbajoIzquierda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí actualizas la dirección de la parada o del tiro dependiendo del turno
                if (turnoJugador1) {
                    if (direccionParadaJugador1 == null) {
                        direccionParadaJugador1 = Jugador1.Direccion.ABAJOIZQUIERDA;
                    } else if (Math.abs(direccionParadaJugador2.getValor() - Jugador2.Direccion.ABAJOIZQUIERDA.getValor()) == 3) {
                        direccionParadaJugador1_2 = Jugador1.Direccion.ABAJOIZQUIERDA;
                    }
                } else {
                    if (direccionParadaJugador2 == null) {
                        direccionParadaJugador2 = Jugador2.Direccion.ABAJOIZQUIERDA;
                    } else if (Math.abs(direccionParadaJugador2.getValor() - Jugador2.Direccion.ABAJOIZQUIERDA.getValor()) == 3) {
                        direccionParadaJugador2_2 = Jugador2.Direccion.ABAJOIZQUIERDA;
                    }
                }
            }
        });
        pararAbajoDerecha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí actualizas la dirección de la parada o del tiro dependiendo del turno
                if (turnoJugador1) {
                    if (direccionParadaJugador1 == null) {
                        direccionParadaJugador1 = Jugador1.Direccion.ABAJODERECHA;
                    } else if (Math.abs(direccionParadaJugador2.getValor() - Jugador2.Direccion.ABAJODERECHA.getValor()) == 4) {
                        direccionParadaJugador1_2 = Jugador1.Direccion.ABAJODERECHA;
                    }
                } else {
                    if (direccionParadaJugador2 == null) {
                        direccionParadaJugador2 = Jugador2.Direccion.ABAJODERECHA;
                    } else if (Math.abs(direccionParadaJugador2.getValor() - Jugador2.Direccion.ABAJODERECHA.getValor()) == 4) {
                        direccionParadaJugador2_2 = Jugador2.Direccion.ABAJODERECHA;
                    }
                }
            }
        });
        pararAbajoCentro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí actualizas la dirección de la parada o del tiro dependiendo del turno
                if (turnoJugador1) {
                    if (direccionParadaJugador1 == null) {
                        direccionParadaJugador1 = Jugador1.Direccion.CENTROABAJO;
                    } else if (Math.abs(direccionParadaJugador2.getValor() - Jugador2.Direccion.CENTROABAJO.getValor()) == 6) {
                        direccionParadaJugador1_2 = Jugador1.Direccion.CENTROABAJO;
                    }
                } else {
                    if (direccionParadaJugador2 == null) {
                        direccionParadaJugador2 = Jugador2.Direccion.CENTROARRIBA;
                    } else if (Math.abs(direccionParadaJugador2.getValor() - Jugador2.Direccion.CENTROABAJO.getValor()) == 6) {
                        direccionParadaJugador2_2 = Jugador2.Direccion.CENTROABAJO;
                    }
                }
            }
        });
        // Botón de chutar jugador 1
        chutarJugador1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turnoJugador1 && turnos < MAX_TURNOS) {
                    jugador1.chutar(direccionTiroJugador1_1);
                    chutarJugador1.setEnabled(false);
                    pararJugador2.setEnabled(true);
                    panelChutarJugador1.setVisible(false);
                    panelPararJugador2.setVisible(true);
                    JOptionPane.showMessageDialog(null, "Turno " + (turnos + 1) + ": Jugador 1 ha chutado.");
                }
            }
        });

        // Botón de parar jugador 2
        pararJugador2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!turnoJugador1 && turnos < MAX_TURNOS) {
                    jugador2.parar(direccionParadaJugador2);
                    pararJugador2.setEnabled(false);
                    chutarJugador2.setEnabled(true);
                    panelPararJugador2.setVisible(false);
                    panelChutarJugador2.setVisible(true);
                    JOptionPane.showMessageDialog(null, "Turno " + (turnos + 1) + ": Jugador 2 ha parado.");
                }
            }
        });
        // Botón de chutar jugador 2
        chutarJugador2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!turnoJugador1 && turnos < MAX_TURNOS) {
                    jugador2.chutar(direccionTiroJugador2_1);
                    chutarJugador2.setEnabled(false);
                    pararJugador1.setEnabled(true);
                    panelChutarJugador2.setVisible(false);
                    panelPararJugador1.setVisible(true);
                    JOptionPane.showMessageDialog(null, "Turno " + (turnos + 1) + ": Jugador 2 ha chutado.");
                }
            }
        });
        // Botón de parar jugador 1
        pararJugador1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turnoJugador1 && turnos < MAX_TURNOS) {
                    jugador1.parar(direccionParadaJugador1);
                    pararJugador1.setEnabled(false);
                    chutarJugador1.setEnabled(true);
                    panelPararJugador1.setVisible(false);
                    panelChutarJugador1.setVisible(true);
                    // Cambiamos el turno al otro jugador y incrementamos la cuenta de los turnos
                    turnoJugador1 = !turnoJugador1;
                    turnos++;
                    JOptionPane.showMessageDialog(null, "Turno " + turnos + ": Jugador 1 ha parado. Cambiando turno al Jugador " + (turnoJugador1 ? "1" : "2") + ".");
                }
            }
        });
    }

    public static void main(String[] args) {
        JuegoMultiplayer juego = new JuegoMultiplayer();
        juego.setVisible(true);
    }
}





