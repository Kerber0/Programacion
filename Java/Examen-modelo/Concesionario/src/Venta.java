import java.time.LocalDateTime;

public class Venta {

private String id;
private LocalDateTime fecha;
private Cliente cliente;
private Vehiculo vehiculo;
private double precioFinal;



  public Venta(String id, LocalDateTime fecha, Cliente cliente, Vehiculo vehiculo,
      double precioFinal,
      String metodoPago) {
    this.id = id;
    this.fecha = fecha;
    this.cliente = cliente;
    this.vehiculo = vehiculo;
    this.precioFinal = precioFinal;
    }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public LocalDateTime getFecha() {
    return fecha;
  }

  public void setFecha(LocalDateTime fecha) {
    this.fecha = fecha;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public Vehiculo getVehiculo() {
    return vehiculo;
  }

  public void setVehiculo(Vehiculo vehiculo) {
    this.vehiculo = vehiculo;
  }

  public double getPrecioFinal() {
    return precioFinal;
  }

  public void setPrecioFinal(double precioFinal) {
    this.precioFinal = precioFinal;
  }

}
