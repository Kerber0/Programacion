import java.util.List;

public class Concesionario {

  private List<Vehiculo> inventario;
  private List<Cliente> clientes;
  private List<Venta> ventas;



  public Concesionario(String nombre, List<Vehiculo> inventario, List<Cliente> cliente,
      List<Venta> ventas) {
    this.inventario = inventario;
    this.clientes = cliente;
    this.ventas = ventas;
  }




  public List<Vehiculo> getInventario() {
    return inventario;
  }


  public List<Cliente> getClientes() {
    return clientes;
  }


  public List<Venta> getVentas() {
    return ventas;
  }






}
