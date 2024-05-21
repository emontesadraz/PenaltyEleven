<<<<<<<< HEAD:src/com/penaltyeleven/metodosexternos/Equipos.java
package com.penaltyeleven.metodosexternos;
========
package com.penaltyeleven;
>>>>>>>> origin/premain:src/com/penaltyeleven/Equipos.java

public class Equipos {
    private String nombreEquipo;

    public Equipos() {
    }
    public Equipos(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    @Override
    public String toString() {
        return nombreEquipo;
    }
}
