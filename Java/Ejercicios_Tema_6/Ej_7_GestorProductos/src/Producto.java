public class Producto {
    private int id;
    private String nombre;
    private double precio;
    private int stock;

    public Producto(int id, String nombre, double precio, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int nuevoStock) {
        this.stock = nuevoStock;
    }

    @Override
    public String toString() {
        return String.format("ID: %d | Nombre: %s | Precio: %.2f€ | Stock: %d unidades",
            id, nombre, precio, stock);
    }

    public String toCSV() {
        return id + ";" + nombre + ";" + precio + ";" + stock;
    }
}
