import java.util.ArrayList;

public class Jugador {
    String nombreUsuario;
    String email;
    ArrayList<Videojuego> coleccion;

    public Jugador(String nombreUsuario, String email) {
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.coleccion = new ArrayList<>();
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Videojuego> getColeccion() {
        return coleccion;
    }

    public void setColeccion(ArrayList<Videojuego> coleccion) {
        this.coleccion = coleccion;
    }

    @Override
    public String toString() {
        return "Jugador: " + nombreUsuario +
                ", Email: " + email +
                ", Coleccion: " + coleccion;
    }


}
