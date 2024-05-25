package com.penaltyeleven.metodosexternos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

public class InterfazMaestra extends JFrame {
    public static final MusicManager musicManager = new MusicManager();

    //Metodo para crear el fondo de la ventana
    public static void crearFondo(JButton fondo, String rutaFondo) {
        // Crear un botón para el fondo
        fondo.setBounds(0, 0, 1280, 720);
        fondo.setOpaque(false);
        fondo.setContentAreaFilled(false);
        fondo.setBorderPainted(false);

        // Cargar la imagen de fondo y establecerla como icono del botón
        URL url = InterfazMaestra.class.getClassLoader().getResource(rutaFondo);
        ImageIcon icono = new ImageIcon(url);
        Image imagen = icono.getImage().getScaledInstance(1280, 720, Image.SCALE_DEFAULT);
        icono = new ImageIcon(imagen);
        fondo.setIcon(icono);
    }

    //Metodo para crear un botón
    public static void crearBoton(JButton boton, String texto, int posX, int posY, int ancho, int alto, Color colorFondoBotones, Color colorTextoBotones, Font fuenteBoton, String rutaSoundEfectHover, float volumenSoundEfectHover) {
        boton.setText(texto);
        boton.setBounds(posX, posY, ancho, alto);
        boton.setBackground(colorFondoBotones);
        boton.setForeground(colorTextoBotones);
        boton.setFont(fuenteBoton);

        // Cambiar color de los botones al pasar el ratón por encima
        boton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                boton.setBackground(colorFondoBotones.darker());
                musicManager.playMusic(rutaSoundEfectHover, volumenSoundEfectHover);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                boton.setBackground(colorFondoBotones);
            }
        });
    }

    //Metodo para crear una ventana
    public void crearVentana(String titulo, int width, int height) {
        setTitle(titulo);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(width, height);
        setLocationRelativeTo(null);
        setResizable(false);
        // Icono
        setIconImage(new ImageIcon("src/Imagenes/Logo.png").getImage());
    }
}
