public class Contacto {
  private String nombre;
  private String telefono;
  private String email;

  public Contacto(String nombre, String telefono, String email) {
    this.nombre = nombre;
    this.telefono = telefono;
    this.email = email;
  }

  public Contacto() {

  }

  public String getNombre() {
    return nombre;
  }

  public String getTelefono() {
    return telefono;
  }

  public String getEmail() {
    return email;
  }

  public void setNombre() {
    this.nombre = nombre;
  }

  public void setTelefono() {
    this.telefono = telefono;
  }

  public void setEmail() {
    this.email = email;
  }

  @Override
  public String toString() {
    return "Contacto: { " + "Nombre: " + nombre + " | Teléfono: " + telefono + " | Email: " + email + " } ";
  }
}