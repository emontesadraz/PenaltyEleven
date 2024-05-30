package com.penaltyeleven.metodosexternos;

public class Equipos{
    private String nombreEquipo;
    private String rutaEscudo;
    private String Tiro1;
    private String Tiro2;
    private String Tiro3;
    private String Parada1;
    private String Parada2;
    private String Parada3;

    // Constructor vacio
    public Equipos() {
    }

    // Constructor con parametros
    public Equipos(String nombreEquipo, String rutaEscudo, String Tiro1, String Tiro2, String Tiro3, String Parada1, String Parada2, String Parada3) {
        this.nombreEquipo = nombreEquipo;
        this.rutaEscudo = rutaEscudo;
        this.Tiro1 = Tiro1;
        this.Tiro2 = Tiro2;
        this.Tiro3 = Tiro3;
        this.Parada1 = Parada1;
        this.Parada2 = Parada2;
        this.Parada3 = Parada3;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public String getRutaEscudo() {
        return rutaEscudo;
    }

    public void setRutaEscudo(String rutaEscudo) {
        this.rutaEscudo = rutaEscudo;
    }

    public String getTiro1() {
        return Tiro1;
    }

    public void setTiro1(String tiro1) {
        this.Tiro1 = tiro1;
    }

    public String getTiro2() {
        return Tiro2;
    }

    public void setTiro2(String tiro2) {
        this.Tiro2 = tiro2;
    }

    public String getTiro3() {
        return Tiro3;
    }

    public void setTiro3(String tiro3) {
        this.Tiro3 = tiro3;
    }

    public String getParada1() {
        return Parada1;
    }

    public void setParada1(String parada1) {
        this.Parada1 = parada1;
    }

    public String getParada2() {
        return Parada2;
    }

    public void setParada2(String parada2) {
        this.Parada2 = parada2;
    }

    public String getParada3() {
        return Parada3;
    }

    public void setParada3(String parada3) {
        this.Parada3 = parada3;
    }
}
