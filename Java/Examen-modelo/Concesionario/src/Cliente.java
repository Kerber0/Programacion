import java.util.List;

public class Cliente {
  private String dni;
  private String nombre;
  private String apellido;
  private String telefono;
  private String email;
  private List<Venta> historialCompra;

  public Cliente(String dni, String nombre, String apellido, String telefono, String email,
      List<Venta> historialCompra) {
    this.dni = dni;
    this.nombre = nombre;
    this.apellido = apellido;
    this.telefono = telefono;
    this.email = email;
    this.historialCompra = historialCompra;
  }

  public String getDni() {
    return dni;
  }

  public void setDni(String dni) {
    this.dni = dni;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellido() {
    return apellido;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public List<Venta> getHistorialCompra() {
    return historialCompra;
  }

  public void setHistorialCompra(List<Venta> historialCompra) {
    this.historialCompra = historialCompra;
  }

public Cliente(cliente){
    cliente = new Cliente();
}




}
