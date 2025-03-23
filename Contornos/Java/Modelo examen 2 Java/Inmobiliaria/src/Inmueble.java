import java.util.LinkedList;

public class Inmueble extends LinkedList<Inmueble> {
    private int id;
    private String ubicacion;
    private double precio;
    private double superficie;
    private Estado estadoActual;

    public enum Estado {
        Disponible, Vendido, Alquilado
    }

    public Inmueble(int id, String ubicacion, double precio, double superficie) {
        this.id = id;
        this.ubicacion = ubicacion;
        this.precio = precio;
        this.superficie = superficie;
        this.estadoActual = Estado.Disponible; // Valor predeterminado
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    public Estado getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(Estado estadoActual) {
        this.estadoActual = estadoActual;
    }
}
