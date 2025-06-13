import java.io.Serializable;

public class Cliente implements Serializable {
    private String nombre;
    private String email;
    private int id;

    public Cliente(String nombre, String email, int id) {
        this.nombre = nombre;
        this.email = email;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ID: " + id +
            ", Nombre: " + nombre +
            ", Email: " + email + "\n";
    }
}
