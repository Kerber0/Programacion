package ejercicio;

import ejercicio.vehiculos.Vehiculo;

import java.util.List;
import java.util.Set;

public class Concesionario {
  private List<Vehiculo> inventario;
  private Set<Cliente> clientes;
  private List<Venta> ventas;

  public Concesionario(List<Vehiculo> inventario, Set<Cliente> cliente, List<Venta> ventas) {
    this.inventario = inventario;
    this.clientes = cliente;
    this.ventas = ventas;
  }

  public List<Vehiculo> getInventario() {
    return inventario;
  }

  public Set<Cliente> getClientes() {
    return clientes;
  }

  public List<Venta> getVentas() {
    return ventas;
  }
}
