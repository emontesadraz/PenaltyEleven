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
    private JButton chutar;
    private JButton parar;
    private Jugador1.Direccion direccionTiroJugador1_1;
    private Jugador2.Direccion direccionTiroJugador2_1;
    private Jugador1.Direccion direccionParadaJugador1;
    private Jugador1.Direccion direccionParadaJugador1_2;
    private Jugador2.Direccion direccionParadaJugador2;
    private Jugador2.Direccion direccionParadaJugador2_2;
    private boolean turnoJugador1;
    private int turnosJugador1 = 0;
    private int turnosJugador2 = 0;
    private static final int MAX_TURNOS = 5;

    public JuegoMultiplayer() {
        // Configuramos el JFrame
        setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
        setTitle("Penalty Eleven");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

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

        // Creamos el panel para chutar
        JPanel panelChutar = new JPanel();
        panelChutar.setSize(panel1Width, panel1Height);
        panelChutar.setBackground(new Color(23, 23, 213, 255));
        panelChutar.setLayout(null);
        add(panelChutar);

        // Creamos el panel para parar
        JPanel panelParar = new JPanel();
        panelParar.setSize(panel1Width, panel1Height);
        panelParar.setBackground(new Color(82, 255, 0, 255));
        panelParar.setVisible(false);
        panelParar.setLayout(null);
        add(panelParar);


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

        // Botón de chutar
        chutar = new JButton("Tirar");
        chutar.setBounds(100, 350, 200, 100);

        // Botón de parar
        parar = new JButton("Parar");
        parar.setBounds(100, 350, 200, 100);

        // Color del boton de chutar y de parar
        chutar.setBackground(colorBaseBotones);
        parar.setBackground(colorBaseBotones);

        // Añadimos los botones de dirección al panel de chutar
        panelChutar.add(tirarArribaIzquierda);
        panelChutar.add(tirarArribaDerecha);
        panelChutar.add(tirarArribaCentro);
        panelChutar.add(tirarCentroIzquierda);
        panelChutar.add(tirarCentroDerecha);
        panelChutar.add(tirarCentroCentro);
        panelChutar.add(tirarAbajoIzquierda);
        panelChutar.add(tirarAbajoDerecha);
        panelChutar.add(tirarAbajoCentro);
        panelChutar.add(chutar);

        // Añadimos los botones de dirección al panel de parar
        panelParar.add(pararArribaIzquierda);
        panelParar.add(pararArribaDerecha);
        panelParar.add(pararArribaCentro);
        panelParar.add(pararCentroIzquierda);
        panelParar.add(pararCentroDerecha);
        panelParar.add(pararCentroCentro);
        panelParar.add(pararAbajoIzquierda);
        panelParar.add(pararAbajoDerecha);
        panelParar.add(pararAbajoCentro);
        panelParar.add(parar);

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
                if (turnoJugador1){
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
        // Botón de chutar
        chutar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turnoJugador1 && turnosJugador1 < MAX_TURNOS) {
                    jugador1.chutar(direccionTiroJugador1_1);
                    turnosJugador1++;
                    panelChutar.setVisible(false);
                    panelParar.setVisible(true);
                } else if (!turnoJugador1 && turnosJugador2 < MAX_TURNOS) {
                    jugador2.chutar(direccionTiroJugador2_1);
                    turnosJugador2++;
                    panelChutar.setVisible(false);
                    panelParar.setVisible(true);
                }
            }
        });

// Botón de parar
        parar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turnoJugador1 && turnosJugador1 < MAX_TURNOS) {
                    if (direccionParadaJugador1 != null && direccionParadaJugador1_2 != null) {
                        jugador1.parar(direccionParadaJugador1);
                        jugador1.parar(direccionParadaJugador1_2);
                        turnosJugador1++;
                        panelParar.setVisible(false);
                        panelChutar.setVisible(true);
                        // Restablecemos las direcciones de parada para el próximo turno
                        direccionParadaJugador1 = null;
                        direccionParadaJugador1_2 = null;
                    } else if (!turnoJugador1 && turnosJugador2 < MAX_TURNOS) {
                        jugador2.parar(direccionParadaJugador2);
                        jugador2.parar(direccionParadaJugador2_2);
                        turnosJugador2++;
                        panelParar.setVisible(false);
                        panelChutar.setVisible(true);
                        // Restablecemos las direcciones de parada para el próximo turno
                        direccionParadaJugador2 = null;
                        direccionParadaJugador2_2 = null;
                    }
                }
                turnoJugador1 = !turnoJugador1;
            }
        });


        // Añadimos el turno del jugador 1 para que empiece el la partida
        turnoJugador1 = true;
    }
    public static void main(String[] args) {
        JuegoMultiplayer juego = new JuegoMultiplayer();
        juego.setVisible(true);
    }
}





