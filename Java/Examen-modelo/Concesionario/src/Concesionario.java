import java.util.List;

public class Concesionario {

  private List<Vehiculo> inventario;
  private List<Cliente> cliente;
  private List<Venta> venta;

  public Concesionario(String nombre, List<Vehiculo> inventario, List<Cliente> cliente,
      List<Venta> venta) {
    this.nombre = nombre;
    this.inventario = inventario;
    this.cliente = cliente;
    this.venta = venta;
  }

    private String nombre;

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public List<Vehiculo> getInventario() {
    return inventario;
  }

  public void setInventario(List<Vehiculo> inventario) {
    this.inventario = inventario;
  }

  public List<Cliente> getCliente() {
    return cliente;
  }

  public void setCliente(List<Cliente> cliente) {
    this.cliente = cliente;
  }

  public List<Venta> getVenta() {
    return venta;
  }

  public void setVenta(List<Venta> venta) {
    this.venta = venta;
  }







}
