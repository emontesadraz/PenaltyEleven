package com.penaltyeleven.metodosexternos;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que contiene los métodos para agregar los equipos de la serie Inazuma Eleven
 * a una lista de equipos.
 * @version 1.0, 2021-08-10
 */
public class OperacionesEquipos extends Equipos {
    private List<Equipos> equipos = new ArrayList<Equipos>();

    /**
     * Constructor de la clase OperacionesEquipos que agrega los equipos a la lista.
     */
    public OperacionesEquipos() {
        agregarEquipo();
    }

    /**
     * Método que agrega los equipos a la lista.
     */
    public void agregarEquipo() {
        //Temporada 1
        Equipos equipo1 = new Equipos("Instituto Raimon", "Imagenes/Escudo/Raimon.png", "Tornado de Fuego", "Super Relámpago", "Fénix", "Despeje de Fuego", "Mano Celestial", "Mano Mágica");
        equipos.add(equipo1);
        Equipos equipo2 = new Equipos("Instituto Occult", "Imagenes/Escudo/Occult.png", "Tiro del Cometa", "Rapto Divino", "Tiro Fantasma", "Despeje de Fuego", "Cuchilla Asesina", "Espiral de Distorsión");
        equipos.add(equipo2);
        Equipos equipo3 = new Equipos("Instituto Wild", "Imagenes/Escudo/Wild.png", "Remate Serpiente", "Ataque de Cóndor", "Remate Tarzán", "Bloque dureza", "Deslizamiento", "Garra Salvaje");
        equipos.add(equipo3);
        Equipos equipo4 = new Equipos("Instituto Brain", "Imagenes/Escudo/Brain.png", "Tiro Dinamita", "Remate Misil", "Psicorremate", "Puños Voladores", "Despeje Cohete", "Campo de Fuerza Defensivo");
        equipos.add(equipo4);
        Equipos equipo5 = new Equipos("Instituto Otaku", "Imagenes/Escudo/Otaku.png", "Tiro Dinamita", "Tiro Giratorio", "Bateo Total", "Puño de Furia", "Mano Ultradimensional", "Parada Celestial");
        equipos.add(equipo5);
        Equipos equipo6 = new Equipos("Royal Academy", "Imagenes/Escudo/RoyalAcademy.png", "Chut de los 100 Toques", "Pingüino Emperador Nº 2", "Triangulo Letal", "Despeje de Fuerza", "Escudo de Fuerza", "Colmillo de Pantera");
        equipos.add(equipo6);
        Equipos equipo7 = new Equipos("Instituto Shuriken", "Imagenes/Escudo/Shuriken.png", "Bomba Acrobática", "Bola de Fango", "Remate Multiple", "Bloque Dureza", "Torbellino", "Parada Múltiple");
        equipos.add(equipo7);
        Equipos equipo8 = new Equipos("Instituto Farm", "Imagenes/Escudo/Farm.png", "Cabezazo Kung-fu", "Balón Rodante", "Tiro Cegador", "Hojarasca", "Despeje de Leñador", "Muralla Infinita");
        equipos.add(equipo8);
        Equipos equipo9 = new Equipos("Instituto Kirkwood", "Imagenes/Escudo/Kirkwood.png", "Flecha Huracán", "Tornado Inverso", "Triángulo Z", "Despeje de Fuego", "Bloque Dureza", "Puño Vengativo");
        equipos.add(equipo9);
        Equipos equipo10 = new Equipos("Instituto Zeus", "Imagenes/Escudo/Zeus.png", "Disparo con Rebotes", "Flecha Divina", "Sabiduria Divina", "Torbellino", "Muralla Tsunami", "Muralla Gigante");
        equipos.add(equipo10);

        //Temporada 2
        Equipos equipo11 = new Equipos("Raimon 2", "Imagenes/Escudo/Raimon2.png", "Tormenta de Fuego", "Fuego Helado", "La Tierra", "Mano Celestial R", "Super Puño Invencible", "Manos Infinitas");
        equipos.add(equipo11);
        Equipos equipo12 = new Equipos("Instituto Alpino", "Imagenes/Escudo/Alpino.png", "Chut Congelante", "Leopardo de la Ventisca", "Ventisca Eterna", "Bloque Dureza", "Bloque de Hielo", "Cortina Aurora");
        equipos.add(equipo12);
        Equipos equipo13 = new Equipos("Tormenta de Geminis", "Imagenes/Escudo/TormentaDeGeminis.png", "Tiro del Cometa", "Astro Remate", "Disparo Cósmico", "Puños Voladores", "Escudo Protector", "Agujero Negro");
        equipos.add(equipo13);
        Equipos equipo14 = new Equipos("Royal Academy Redux", "Imagenes/Escudo/RoyalRedux.png", "Chut Granada", "Chut de los 200 toques", "Pingüino Emperador Nº 1", "Escudo de Fuerza", "Escudo de Fuerza Total", "Colmillo de Pantera");
        equipos.add(equipo14);
        Equipos equipo15 = new Equipos("Épsilon", "Imagenes/Escudo/Epsilon.png", "Rayo de Ganímedes", "Remate de Gaia", "Lanza de Odín", "Despeje Cohete", "Agujero de Gusano", "Destrozataladros");
        equipos.add(equipo15);
        Equipos equipo16 = new Equipos("Prominence", "Imagenes/Escudo/Prominence.png", "Astro Remate", "Llamarada Infernal", "Llamarada Atómica", "Despeje Explosivo", "Despeje de Fuego", "Combustión");
        equipos.add(equipo16);
        Equipos equipo17 = new Equipos("Polvo de Diamantes", "Imagenes/Escudo/PolvoDiamante.png", "Astro Remate", "Remate de Hielo", "Balón Iceberg", "Torbellino", "Atajo Tornado", "Bloque de Hielo");
        equipos.add(equipo17);
        Equipos equipo18 = new Equipos("Caos", "Imagenes/Escudo/Caos.png", "Balón Iceberg", "Llamarada Atómica", "Ventisca de Fuego", "Torbellino", "Bloque de Hielo", "Combustión");
        equipos.add(equipo18);
        Equipos equipo19 = new Equipos("Génesis", "Imagenes/Escudo/Génesis.png", "Cañon de Meteoritos", "Pingüino Espacial", "Supernova", "Espiral de Distorsión", "Constelación Estelar", "Muro Dimensional");
        equipos.add(equipo19);
        Equipos equipo20 = new Equipos("Emperadores Oscuros", "Imagenes/Escudo/EmperadoresOscuros.png", "Tornado Oscuro", "Remate Triple", "Fénix Oscuro", "Campo de Fuerza Defensivo", "Malla Letal", "Bloqueo Doble");
        equipos.add(equipo20);

        //Temporada 3
        Equipos equipo21 = new Equipos("Inazuma Japón", "Imagenes/Escudo/InazumaJapon.png", "Descenso Estelar", "La Aurora", "Big Bang", "Puño de Furia", "Mano Ultradimensional", "Parada Celestial");
        equipos.add(equipo21);
        Equipos equipo22 = new Equipos("Neo Japón","Imagenes/Escudo/NeoJapon.png", "Flecha Divina", "Triángulo Z", "Lanza de Odín", "Colmillo de Pantera", "Destrozataladros", "Muralla Infinita");
        equipos.add(equipo22);
        Equipos equipo23 = new Equipos("Dragones de Fuego","Imagenes/Escudo/DragonesDeFuego.png","Remate Celestial", "Ventisca de Fuego", "Remate Caótico", "Combustión", "Lanzallamas", "Rechace de Fuego");
        equipos.add(equipo23);
        Equipos equipo24 = new Equipos("Knights of Queen","Imagenes/Escudo/KnightsOfQueen.png", "Tiro del Cometa", "Ataque de Paladín", "Excalibur", "Cuchilla Asesina", "Escudo Protector", "Espada Defensiva");
        equipos.add(equipo24);
        Equipos equipo25 = new Equipos("Los Emperadores","Imagenes/Escudo/Emperadores.png",  "Ataque del Cóndor", "Remate del Águila", "LLamarada Infernal", "Simun", "Muralla Infinita", "Millón de Manos");
        equipos.add(equipo25);
        Equipos equipo26 = new Equipos("Unicorn","Imagenes/Escudo/Unicorn.png", "Remate Pegaso", "Remate Unicornio", "Tri-Pegaso", "Puño Vengativo", "Despeje Cohete", "Golpes de Luz");
        equipos.add(equipo26);
        Equipos equipo27 = new Equipos("Los Rojos","Imagenes/Escudo/LosRojos.png", "Disparo Rodante", "Tirachinas", "Dragón Terrestre", "Despeje de Fuego", "Destrozataladros", "Aguijón");
        equipos.add(equipo27);
        Equipos equipo28 = new Equipos("Orfeo","Imagenes/Escudo/Orfeo.png", "Remate de Hielo", "Disparo Valiente", "Espada de Odín", "Barrera de Cristal", "Muralla Gigante", "Guardia del Coliseo");
        equipos.add(equipo28);
        Equipos equipo29 = new Equipos("Os Reis","Imagenes/Escudo/OsReis.png",  "Tiro Giratorio", "Tiro Vendaval", "Golpe de Samba", "Parada Múltiple", "Garra Salvaje", "Parada Capoeira");
        equipos.add(equipo29);
        Equipos equipo30 = new Equipos("Little Giants","Imagenes/Escudo/LittleGiants.png",  "Mandíbulas Dobles", "Disparo Dual", "Disparo X", "Mano Celestial", "Mano Celestial X", "Mano Espiritual");
        equipos.add(equipo30);
    }



    /**
     * Método que retorna la lista de equipos.
     * @return equipos Lista de equipos.
     */
    public List<Equipos> getEquipos() {
        return equipos;
    }
}
