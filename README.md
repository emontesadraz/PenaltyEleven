Readme para ir poniendo los avances del proyecto

```mermaid
classDiagram
    class DatabaseHandler{
        -Connection connection
        -String url
        -String username
        -String password
        +DatabaseHandler(String url, String username, String password)
        +void connect()
        +void disconnect()
        +ResultSet query(String sql)
        +int update(String sql)
    }
    class User{
        -String nombre
        -int puntuacion
        +User(String nombre, int puntuacion)
        +String getNombre()
        +int getPuntuacion()
    }
    class Equipos{
        -String nombreEquipo
        -int puntos
        +Equipos(String nombreEquipo, int puntos)
        +String getNombreEquipo()
        +void setNombreEquipo(String nombreEquipo)
        +int getPuntos()
        +void setPuntos(int puntos)
    }
    class MusicManager{
        -String currentSong
        -float volume
        +MusicManager()
        +void playMusic(String song, float volume)
        +void stopMusic()
        +void setVolume(float volume)
    }
    class OperacionesEquipos{
        -Equipos equipo
        +OperacionesEquipos(Equipos equipo)
        +void agregarJugador(Jugador jugador)
        +void eliminarJugador(Jugador jugador)
        +void actualizarPuntos(int puntos)
    }
    class JuegoMultiplayer{
        -Jugador jugador1
        -Jugador jugador2
        -Tablero tablero
        +JuegoMultiplayer(Jugador jugador1, Jugador jugador2)
        +void iniciarJuego()
        +void terminarJuego()
        +void turnoJugador(Jugador jugador)
    }
    
    
    
```