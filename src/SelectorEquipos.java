import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SelectorEquipos extends JFrame{
    JButton seleccionarEqu1;
    JButton seleccionarEqu2;
    JButton jugar;
    JButton flechaIzquierda;
    JButton flechaDerecha;
    JButton back;
    JPanel panel;
    JButton flechaIzquierda2;
    JButton flechaDerecha2;
    BufferedImage imagen;

    public SelectorEquipos(){
        super("Penalty Eleven");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        // Fuente y color de los botones
        Font fuenteBoton = new Font("Action Man", Font.BOLD, 15);
        Color colorBoton = new Color(214, 202, 42);
        Color colorTexto = new Color(4, 38, 193);

        // Panel
        panel = new JPanel();
        panel.setLayout(null);
        this.add(panel);

        // Cargar imagen de fondo
        try {
            imagen = ImageIO.read(new File("src/FondoSelectorEquipos.jpeg")); // Ruta de la imagen de fondo
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Botón seleccionar para el equipo 1
        seleccionarEqu1 = new JButton("Seleccionar");
        seleccionarEqu1.setFont(fuenteBoton);
        seleccionarEqu1.setBackground(colorBoton);
        seleccionarEqu1.setForeground(colorTexto);
        seleccionarEqu1.setBounds(50, 50, 200, 50);
        panel.add(seleccionarEqu1);

        // Botón seleccionar para el equipo 2
        seleccionarEqu2 = new JButton("Seleccionar");
        seleccionarEqu2.setFont(fuenteBoton);
        seleccionarEqu2.setBackground(colorBoton);
        seleccionarEqu2.setForeground(colorTexto);
        seleccionarEqu2.setBounds(550, 50, 200, 50);
        panel.add(seleccionarEqu2);

        // Botón jugar
        jugar = new JButton("Jugar");
        jugar.setFont(fuenteBoton);
        jugar.setBackground(colorBoton);
        jugar.setForeground(colorTexto);
        jugar.setBounds(300, 450, 200, 50);
        panel.add(jugar);

        // Botón atrás
        back = new JButton("Atrás");
        back.setFont(fuenteBoton);
        back.setBackground(colorBoton);
        back.setForeground(colorTexto);
        back.setBounds(300, 500, 200, 50);
        panel.add(back);

        // Botón flecha izquierda
        flechaIzquierda = new JButton("<");
        flechaIzquierda.setFont(fuenteBoton);
        flechaIzquierda.setBackground(colorBoton);
        flechaIzquierda.setForeground(colorTexto);
        flechaIzquierda.setBounds(600, 350, 50, 50);
        panel.add(flechaIzquierda);

        // Botón flecha derecha
        flechaDerecha = new JButton(">");
        flechaDerecha.setFont(fuenteBoton);
        flechaDerecha.setBackground(colorBoton);
        flechaDerecha.setForeground(colorTexto);
        flechaDerecha.setBounds(650, 350, 50, 50);
        panel.add(flechaDerecha);

        // Botón flecha izquierda 2
        flechaIzquierda2 = new JButton("<");
        flechaIzquierda2.setFont(fuenteBoton);
        flechaIzquierda2.setBackground(colorBoton);
        flechaIzquierda2.setForeground(colorTexto);
        flechaIzquierda2.setBounds(100, 350, 50, 50);
        panel.add(flechaIzquierda2);

        // Botón flecha derecha 2
        flechaDerecha2 = new JButton(">");
        flechaDerecha2.setFont(fuenteBoton);
        flechaDerecha2.setBackground(colorBoton);
        flechaDerecha2.setForeground(colorTexto);
        flechaDerecha2.setBounds(150, 350, 50, 50);
        panel.add(flechaDerecha2);

    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // Dibujar la imagen de fondo en el JFrame
        if (imagen != null) {
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
