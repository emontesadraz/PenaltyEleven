import java.util.ArrayList;
import java.util.List;

public class EquiposT2 extends Equipos{
    private List<Equipos> equiposT2 = new ArrayList<Equipos>();


    public void equiposTemporada2(){
        Equipos equipos1 = new Equipos("Tormenta de Géminis");
        equiposT2.add(equipos1);
        Equipos equipos2 = new Equipos("Servicio Secreto");
        equiposT2.add(equipos2);
        //Aqui se vuelven a enfrentar al Tormenta de Géminis
        Equipos equipos3 = new Equipos("Instituto Alpino");
        equiposT2.add(equipos3);
        // Se vuelven a enfrentar al Tormenta de Géminis
        Equipos equipos4 = new Equipos("Claustro Sagrado");
        equiposT2.add(equipos4);
        Equipos equipos5 = new Equipos("Épsilon");
        equiposT2.add(equipos5);
        Equipos equipos6 = new Equipos("Royal Academy Redux");
        equiposT2.add(equipos6);
        Equipos equipos7 = new Equipos("CCC Osaka");
        equiposT2.add(equipos7);
        //Se vuelven a enfrentar al Épsilon
        Equipos equipos8 = new Equipos("Instituto Fauxhore");
        equiposT2.add(equipos8);
        Equipos equipos9 = new Equipos("Génesis");
        equiposT2.add(equipos9);
        Equipos equipos10 = new Equipos("Instituto Mary Times");
        equiposT2.add(equipos10);
        //Se vuelven a enfrentar al Épsilon
        Equipos equipos11 = new Equipos("Polvo de Diamantes");
        equiposT2.add(equipos11);
        Equipos equipos12 = new Equipos("Chaos");
        equiposT2.add(equipos12);
        //Se vuelven a enfrentar al Génesis
        Equipos equipos13 = new Equipos("Emperadores Oscuros");
        equiposT2.add(equipos13);
        Equipos equipos14 = new Equipos("Instituto Raimon");
        equiposT2.add(equipos14);
    }
}
