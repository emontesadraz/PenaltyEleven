import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MenuInicial extends JFrame {
    private JPanel panel;
    private JButton soloPlayer;
    private JButton multiPlayer;
    private JButton rankingGoleadores;
    private JButton salir;

    public MenuInicial() {

        setSize(800,600);
        setTitle("Penalty Eleven");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        panel=new JPanel();
        //panel.setPreferredSize(new Dimension(800,600));
        panel.setLayout(null);

        soloPlayer=new JButton("Un Jugador");
        /*soloPlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //poner enlace a pantalla de SelectorEquipos
            }
        });
         */
        soloPlayer.setBounds(300,180,200,40);
        panel.add(soloPlayer);
        getContentPane().add(panel);
    }


}
