import java.awt.List;
import java.security.PublicKey;

public class Vehiculo {

  private String marca;
  private String modelo;
  private int year;
  private double precio;
  private int kilometraje;
  private enum estado{nuevo,usado};
  private String id;
  private String color;

  public Vehiculo(String marca, String modelo, int year, double precio, int kilometraje, String id,
      String color) {
    this.marca = marca;
    this.modelo = modelo;
    this.year = year;
    this.precio = precio;
    this.kilometraje = kilometraje;
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

  public String agregarVehiculo(){


  }

  public String modificarVehiculo(){

  }

  public void eliminarVehiculo(){

  }

  public Vehiculo buscarVehiculo(){

  }

  public String listarVehiculos(){

  }

  public List filtrarVehiculos(){

  }

  public Vehiculo mostrarVehiculo(){

  }


}
