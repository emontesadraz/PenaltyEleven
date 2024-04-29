import javax.swing.*;

public class SelectorEquipos extends JFrame{
    JButton seleccionarEqu1;
    JButton seleccionarEqu2;
    JButton jugar;
    JButton flechaIzquierda;
    JButton flechaDerecha;
    JPanel panel;

    public SelectorEquipos(){
        super("Penalty Eleven");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        panel = new JPanel();
        panel.setLayout(null);
        this.add(panel);

        seleccionarEqu1 = new JButton("Seleccionar equipo 1");
        seleccionarEqu1.setBounds(50, 50, 200, 50);
        panel.add(seleccionarEqu1);

        seleccionarEqu2 = new JButton("Seleccionar equipo 2");
        seleccionarEqu2.setBounds(550, 50, 200, 50);
        panel.add(seleccionarEqu2);

        jugar = new JButton("Jugar");
        jugar.setBounds(300, 500, 200, 50);
        panel.add(jugar);

        flechaIzquierda = new JButton("<");
        flechaIzquierda.setBounds(300, 250, 50, 50);
        panel.add(flechaIzquierda);

        flechaDerecha = new JButton(">");
        flechaDerecha.setBounds(450, 250, 50, 50);
        panel.add(flechaDerecha);
    }

}
