public class Contacto {
    private static int contadorIds = 1;
    private String nombre;
    private String telefono;
    private int id;


    public Contacto(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.id = contadorIds++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "ID contacto: " + id + " - " +
                nombre +
                ", telefono: " + telefono;
    }
}
