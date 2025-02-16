package ejercicio.vehiculos;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Vehiculo {

  private String matricula;
  private String marca;
  private String modelo;
  private int year;
  private double precio;
  private int kilometraje;
  private Estado estado;
  private Color color;

  private static final int CURRENT_YEAR = LocalDate.now().getYear();

  private static final List<String> MARCAS_VALIDAS = Arrays.asList("Toyota", "Ford", "Chevrolet", "Honda", "Nissan", "BMW", "Mercedes-Benz", "Hyundai", "Kia", "Volkswagen", "Subaru", "Mazda", "Audi", "Jeep", "Tesla");
  private static final List<String> MODELOS_VALIDOS = Arrays.asList("Corolla", "Focus", "Cruze", "Civic", "Sentra", "Mustang", "Camry", "Elantra", "Tucson", "Golf", "Forester", "CX-5", "A4", "Wrangler", "Model 3", "Accord", "Altima", "Explorer", "X5", "Q5", "RAV4", "F-150", "Silverado", "Outback", "Cherokee", "Model Y", "Rio", "Sonata", "Passat");

  public Vehiculo(String matricula, String marca, String modelo, Estado estado, int year, double precio, int kilometraje, String color) {
    this.matricula = matricula;

    if (MARCAS_VALIDAS.contains(marca)) {
      this.marca = marca;
    } else {
      throw new IllegalArgumentException("Marca inválida. Debe ser una de: " + MARCAS_VALIDAS);
    }

    if (MODELOS_VALIDOS.contains(modelo)) {
      this.modelo = modelo;
    } else {
      throw new IllegalArgumentException("Modelo inválido. Debe ser uno de: " + MODELOS_VALIDOS);
    }

    this.year = (year > 1700 && year <= CURRENT_YEAR) ? year : CURRENT_YEAR;

    this.precio = (precio >= 0) ? precio : 0.0;

    this.kilometraje = (kilometraje >= 0) ? kilometraje : 0;

    if (this.kilometraje == 0){
      this.estado = Estado.valueOf("NUEVO");
    } else{
      this.estado = estado;
    }

    try {
      this.color = Color.valueOf(color.toUpperCase());
    } catch (IllegalArgumentException e) {
      throw new IllegalArgumentException("Color inválido. Debe ser uno de: " + Arrays.toString(Color.values()));
    }
  }

  public Vehiculo(String matricula, String marca, String modelo){
    this.matricula = matricula;

    if (MARCAS_VALIDAS.contains(marca)) {
      this.marca = marca;
    } else {
      throw new IllegalArgumentException("Marca inválida. Debe ser una de: " + MARCAS_VALIDAS);
    }

    if (MODELOS_VALIDOS.contains(modelo)) {
      this.modelo = modelo;
    } else {
      throw new IllegalArgumentException("Modelo inválido. Debe ser uno de: " + MODELOS_VALIDOS);
    }
  }

  public String getMatricula() {
    return matricula;
  }

  public String getMarca() {
    return marca;
  }

  public String getModelo() {
    return modelo;
  }

  public int getYear() {
    return year;
  }

  public double getPrecio() {
    return precio;
  }

  public int getKilometraje() {
    return kilometraje;
  }

  public Estado getEstado() {
    return estado;
  }

  public Color getColor() {
    return color;
  }

  public void setKilometraje(int kilometraje) {
    this.kilometraje = kilometraje;
  }

  public void setPrecio(double precio) {
    this.precio = precio;
  }

  public void setEstado(Estado estado) {
    this.estado = estado;
  }


  @Override
  public String toString() {
    return "ejercicio.vehiculos.Vehiculo{" +
        "matricula='" + matricula + '\'' +
        ", marca='" + marca + '\'' +
        ", modelo='" + modelo + '\'' +
        ", year=" + year +
        ", precio=" + String.format("%.2f", precio) +
        ", kilometraje=" + kilometraje +
        ", estado=" + estado +
        ", color=" + color +
        '}';
  }
}
