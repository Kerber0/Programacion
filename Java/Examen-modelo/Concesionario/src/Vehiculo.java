import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Vehiculo {

  private String id;
  private String marca;
  private String modelo;
  private int year;
  private double precio;
  private int kilometraje;
  private Estado estado;
  private Color color;


  public enum Estado {NUEVO, USADO, REPARACION, VENDIDO}
  public enum Color {ROJO, AZUL, NEGRO, BLANCO, GRIS}

  private static final int CURRENT_YEAR = LocalDate.now().getYear();

  // Listas predefinidas de marcas y modelos
  private static final List<String> MARCAS_VALIDAS = Arrays.asList("Toyota", "Ford", "Chevrolet", "Honda", "Nissan", "BMW", "Mercedes-Benz", "Hyundai", "Kia", "Volkswagen", "Subaru", "Mazda", "Audi", "Jeep", "Tesla");
  private static final List<String> MODELOS_VALIDOS = Arrays.asList("Corolla", "Focus", "Cruze", "Civic", "Sentra", "Mustang", "Camry", "Elantra", "Tucson", "Golf", "Forester", "CX-5", "A4", "Wrangler", "Model 3", "Accord", "Altima", "Explorer", "X5", "Q5", "RAV4", "F-150", "Silverado", "Outback", "Cherokee", "Model Y", "Rio", "Sonata", "Passat");

  public Vehiculo(String id, String marca, String modelo, Estado estado, int year, double precio, int kilometraje, String color) {
    this.id = id;

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


  public void modificarVehiculo(){
    Scanner sc = new Scanner(System.in);
    System.out.println("Seleccione el vehiculo a modificar: " + Vehiculo.mostrarStock());
    opcion =  sc.nextLine();


  }

  public static String mostrarStock(){
    StringBuilder toret = new StringBuilder("Lista de vehiculos:\n");
    for (int i = 0; i < Vehiculo.inventario.size(); i++){
      toret.append(i + stock.get(i).getMarca() + " " + stock.get(i).getmodelo() + " " + stock.get(i).getid()+ "\n");
    }
    return toret.toString();
  }



















  @Override
  public String toString() {
    return "Vehiculo{" +
        "id='" + id + '\'' +
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
