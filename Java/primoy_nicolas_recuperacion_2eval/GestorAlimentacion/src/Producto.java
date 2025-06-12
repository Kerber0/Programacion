public class Producto {
    private String id;
    private String nombre;
    private double precio;
    private boolean ivaReducido;
    private int cantidad;

    public Producto(String id, String nombre, double precio, boolean ivaReducido, int cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.ivaReducido = ivaReducido;
        this.cantidad = cantidad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isIvaReducido() {
        return ivaReducido;
    }

    public void setIvaReducido(boolean ivaReducido) {
        this.ivaReducido = ivaReducido;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }



    @Override
    public String toString() {
        return "ID: " +
             id +
            " - Nombre: " + nombre +
            " - Cantidad en stock: "  + cantidad +
            " - Precio unitario: " + String.format("%.2f", precio)  + " $\n"
             ;
    }
}
