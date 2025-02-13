import java.time.LocalDate;

public class Persona {

  private String nombre;
  private String direccion;
  private int cp;
  private String ciudad;
  private Fecha fechaNacimiento;

  public Persona(String nombre, String direccion, int cp, String ciudad, Fecha fechaNacimiento) {
    this.nombre = nombre;
    this.direccion = direccion;
    this.cp = cp;
    this.ciudad = ciudad;
    this.fechaNacimiento = fechaNacimiento;
  }

  public String getNombre() {
    return nombre;
  }

  public String getDireccion() {
    return direccion;
  }

  public int getCp() {
    return cp;
  }

  public String getCiudad() {
    return ciudad;
  }

  public Fecha getFechaNacimiento() {
    return fechaNacimiento;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  public void setCp(int cp) {
    this.cp = cp;
  }

  public void setCiudad(String ciudad) {
    this.ciudad = ciudad;
  }

  public void setFechaNacimiento(Fecha fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
  }

  @Override
  public String toString() {
    return "Nombre: " + nombre + "\n" +
        "Fecha Nacimiento: " + fechaNacimiento + "\n" +
        "Dirección: " + direccion + "\n" +
        cp + " " + ciudad + "\n";
  }

  public boolean esMayorDeEdad() {
    LocalDate hoy = LocalDate.now();
    int edad = hoy.getYear() - fechaNacimiento.getAnio();

    if (hoy.getMonthValue() < fechaNacimiento.getMes() ||
        (hoy.getMonthValue() == fechaNacimiento.getMes()
            && hoy.getDayOfMonth() < fechaNacimiento.getDia())) {
      edad--;
    }

    return edad >= 18;
  }
}
