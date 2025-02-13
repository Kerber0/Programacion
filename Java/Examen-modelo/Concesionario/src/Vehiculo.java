import java.awt.List;
import java.util.Scanner;

public class Vehiculo {

  private String id;
  private String marca;
  private String modelo;
  private int year;
  private double precio;
  private int kilometraje;
  private  Estado  estado;
  private String color;
  public enum Estado  {NUEVO, USADO, REPARACION, VENDIDO}


  public Vehiculo(String id,String marca, String modelo, Estado estado, int year, double precio, int kilometraje,
      String color) {
    this.marca = marca;
    this.modelo = modelo;
    this.estado = estado;
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

  public void agregarVehiculo(){
    Scanner sc = new Scanner(System.in);
    String marca = sc.nextLine();
    String  modelo = sc.nextLine();
    Estado estado = Estado.valueOf(sc.nextLine());
    int year = Integer.parseInt(sc.nextLine());
    double precio = Double.parseDouble(sc.nextLine());
    int kilometraje = Integer.parseInt(sc.nextLine());
    String id = sc.nextLine();
    String color = sc.nextLine();

    Vehiculo nuevoVehiculo = new Vehiculo(id, marca, modelo, estado, year,  precio, kilometraje,  color);


    //agregar print si esta correcto despues de comprobar datos

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
