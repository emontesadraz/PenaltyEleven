package com.penaltyeleven.metodosexternos;

/**
 * This class represents a team in the system.
 * Each team has a name, a path to its shield image, and a set of shots and stops.
 */
public class Equipos{
    private String nombreEquipo;
    private String rutaEscudo;
    private String Tiro1;
    private String Tiro2;
    private String Tiro3;
    private String Parada1;
    private String Parada2;
    private String Parada3;

    /**
     * Default constructor.
     */
    public Equipos() {
    }

    /**
     * Constructs a new Team with the specified parameters.
     * @param nombreEquipo the name of the team
     * @param rutaEscudo the path to the team's shield image
     * @param Tiro1 the first shot
     * @param Tiro2 the second shot
     * @param Tiro3 the third shot
     * @param Parada1 the first stop
     * @param Parada2 the second stop
     * @param Parada3 the third stop
     */
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

    /**
     * Returns the name of this team.
     * @return the name of this team
     */
    public String getNombreEquipo() {
        return nombreEquipo;
    }

    /**
     * Sets the name of this team.
     * @param nombreEquipo the new name of this team
     */
    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    /**
     * Returns the path to this team's shield image.
     * @return the path to this team's shield image
     */
    public String getRutaEscudo() {
        return rutaEscudo;
    }

    /**
     * Sets the path to this team's shield image.
     * @param rutaEscudo the new path to this team's shield image
     */
    public void setRutaEscudo(String rutaEscudo) {
        this.rutaEscudo = rutaEscudo;
    }

    /**
     * Returns the first shot of this team.
     * @return the first shot of this team
     */
    public String getTiro1() {
        return Tiro1;
    }

    /**
     * Sets the first shot of this team.
     * @param tiro1 the new first shot of this team
     */
    public void setTiro1(String tiro1) {
        this.Tiro1 = tiro1;
    }

    /**
     * Returns the second shot of this team.
     * @return the second shot of this team
     */
    public String getTiro2() {
        return Tiro2;
    }

    /**
     * Sets the second shot of this team.
     * @param tiro2 the new second shot of this team
     */
    public void setTiro2(String tiro2) {
        this.Tiro2 = tiro2;
    }

    /**
     * Returns the third shot of this team.
     * @return the third shot of this team
     */
    public String getTiro3() {
        return Tiro3;
    }

    /**
     * Sets the third shot of this team.
     * @param tiro3 the new third shot of this team
     */
    public void setTiro3(String tiro3) {
        this.Tiro3 = tiro3;
    }

    /**
     * Returns the first stop of this team.
     * @return the first stop of this team
     */
    public String getParada1() {
        return Parada1;
    }

    /**
     * Sets the first stop of this team.
     * @param parada1 the new first stop of this team
     */
    public void setParada1(String parada1) {
        this.Parada1 = parada1;
    }

    /**
     * Returns the second stop of this team.
     * @return the second stop of this team
     */
    public String getParada2() {
        return Parada2;
    }

    /**
     * Sets the second stop of this team.
     * @param parada2 the new second stop of this team
     */
    public void setParada2(String parada2) {
        this.Parada2 = parada2;
    }

    /**
     * Returns the third stop of this team.
     * @return the third stop of this team
     */
    public String getParada3() {
        return Parada3;
    }

    /**
     * Sets the third stop of this team.
     * @param parada3 the new third stop of this team
     */
    public void setParada3(String parada3) {
        this.Parada3 = parada3;
    }
}