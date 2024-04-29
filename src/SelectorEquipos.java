import javax.swing.*;
import java.awt.*;

public class SelectorEquipos extends JFrame{
    JButton seleccionarEqu1;
    JButton seleccionarEqu2;
    JButton jugar;
    JButton flechaIzquierda;
    JButton flechaDerecha;
    JPanel panel;
    JButton flechaIzquierda2;
    JButton flechaDerecha2;

    public SelectorEquipos(){
        super("Penalty Eleven");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        Font fuenteBoton = new Font("Action Man", Font.BOLD, 15);
        Color colorBoton = new Color(214, 202, 42);

        panel = new JPanel();
        panel.setLayout(null);
        this.add(panel);

        seleccionarEqu1 = new JButton("Seleccionar");
        seleccionarEqu1.setBounds(50, 50, 200, 50);
        panel.add(seleccionarEqu1);

        seleccionarEqu2 = new JButton("Seleccionar");
        seleccionarEqu2.setBounds(550, 50, 200, 50);
        panel.add(seleccionarEqu2);

        jugar = new JButton("Jugar");
        jugar.setBounds(300, 500, 200, 50);
        panel.add(jugar);

        flechaIzquierda = new JButton("<");
        flechaIzquierda.setBounds(600, 350, 50, 50);
        panel.add(flechaIzquierda);

        flechaDerecha = new JButton(">");
        flechaDerecha.setBounds(650, 350, 50, 50);
        panel.add(flechaDerecha);

        flechaIzquierda2 = new JButton("<");
        flechaIzquierda2.setBounds(100, 350, 50, 50);
        panel.add(flechaIzquierda2);

        flechaDerecha2 = new JButton(">");
        flechaDerecha2.setBounds(150, 350, 50, 50);
        panel.add(flechaDerecha2);

    }

}
