import java.util.ArrayList;
import java.util.List;

public class Vehiculo {

  private String marca;
  private String modelo;
  private int year;
  private double precio;
  private int kilometraje;
  private Estado estado;
  private String id;
  private String color;
  private static List<Vehiculo> listaVehiculos = new ArrayList<>();

  public enum Estado {
    NUEVO, USADO
  }

  public Vehiculo(String marca, String modelo, int year, double precio, int kilometraje, Estado estado, String id,
                  String color) {
    this.marca = marca;
    this.modelo = modelo;
    this.year = year;
    this.precio = precio;
    this.kilometraje = kilometraje;
    this.estado = estado;
    this.id = id;
    this.color = color;
  }

  public String getMarca() {
    return marca;
  }

  public void setMarca(String marca) {
    this.marca = marca;
  }

  public String getModelo() {
    return modelo;
  }

  public void setModelo(String modelo) {
    this.modelo = modelo;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public double getPrecio() {
    return precio;
  }

  public void setPrecio(double precio) {
    this.precio = precio;
  }

  public int getKilometraje() {
    return kilometraje;
  }

  public void setKilometraje(int kilometraje) {
    this.kilometraje = kilometraje;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public static String agregarVehiculo(String marca, String modelo, int year, double precio, int kilometraje, Estado estado, String id, String color) {
    for (Vehiculo v : listaVehiculos) {
      if (v.getId().equals(id)) {
        return "Error: Ya existe un vehículo con el ID " + id;
      }
    }

    if (year < 1886 || year > 2025) {
      return "Error: El año ingresado no es válido.";
    }
    if (precio <= 0) {
      return "Error: El precio debe ser mayor a 0.";
    }
    if (kilometraje < 0) {
      return "Error: El kilometraje no puede ser negativo.";
    }

    Vehiculo nuevoVehiculo = new Vehiculo(marca, modelo, year, precio, kilometraje, estado, id, color);
    listaVehiculos.add(nuevoVehiculo);
    return "Vehículo agregado con éxito: " + marca + " " + modelo;
  }

public List<> mostrarVehiculos

}
