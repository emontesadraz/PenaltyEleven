package com.penaltyeleven.metodosexternos;

import javax.swing.*;
import java.awt.*;

public class GestorVentanas extends JFrame {
    private JPanel currentPanel; // Mantiene una referencia al panel actualmente visible

    public GestorVentanas() {
        setTitle("Penalty Eleven");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setResizable(false);

        //Poner icono de la aplicación
        setIconImage(new ImageIcon("src/Imagenes/Logo.png").getImage());

// Paneles de contenido
        JPanel p1 = new JPanel();
        p1.add(new JLabel("Menu Inicial"));
        JPanel p2 = new JPanel();
        p2.add(new JLabel("com.penaltyeleven.pantallainicial.soloplayer.Ranking"));
        JPanel p3 = new JPanel();
        p3.add(new JLabel("com.penaltyeleven.pantallainicial.Creditos"));
        JPanel p4 = new JPanel();
        p4.add(new JLabel("com.penaltyeleven.pantallainicial.SelectorEquipos"));

//Panel com.penaltyeleven.pantallainicial.MenuInicial
        //Crear botones
        JButton soloPlayer = new JButton("Un Jugador");
        JButton multiPlayer = new JButton("Multijugador");
        JButton ranking = new JButton("com.penaltyeleven.pantallainicial.soloplayer.Ranking de Goleadores");
        JButton creditos = new JButton("Créditos");
        JButton salir = new JButton("Salir");

// Botones para cambiar paneles
        JButton b1 = new JButton("Button 1");
        JButton b2 = new JButton("Button 2");
        JButton b3 = new JButton("Button 3");
        JButton b4 = new JButton("Button 4");
        b1.addActionListener(e -> setPanel(p1));
        b2.addActionListener(e -> setPanel(p2));
        b3.addActionListener(e -> setPanel(p3));
        b4.addActionListener(e -> setPanel(p4));

        JPanel buttonsPanel = new JPanel(new GridLayout(2, 2));
        buttonsPanel.add(b1);
        buttonsPanel.add(b2);
        buttonsPanel.add(b3);
        buttonsPanel.add(b4);

// Configurar el layout principal
        add(buttonsPanel, BorderLayout.WEST);
        setPanel(p1); // Configurar el panel inicial

        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    private void setPanel(JPanel panel) {
        if (currentPanel != null) {
            getContentPane().remove(currentPanel); // Elimina el panel actual
        }
        currentPanel = panel; // Actualiza la referencia al panel actual
        getContentPane().add(currentPanel, BorderLayout.CENTER);
        revalidate();
        repaint(); // Asegura que el área donde estaba el panel anterior se redibuje
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GestorVentanas());
    }
}

