package ejercicio;

import ejercicio.vehiculos.Estado;
import ejercicio.vehiculos.Vehiculo;

import java.time.LocalDate;
import java.util.*;

public class Generador {

  private static final String LETRAS_VALIDAS = "BCDFGHJKLMNPRSTVWXYZ";
  private static final Random random = new Random();

  public static List<Vehiculo> vehiculos(int cantidad) {
    List<String> marcas = Arrays.asList("Toyota", "Ford", "Chevrolet", "Honda", "Nissan", "BMW", "Mercedes-Benz", "Hyundai", "Kia", "Volkswagen", "Subaru", "Mazda", "Audi", "Jeep", "Tesla");
    List<String> modelos = Arrays.asList("Corolla", "Focus", "Cruze", "Civic", "Sentra", "Mustang", "Camry", "Elantra", "Tucson", "Golf", "Forester", "CX-5", "A4", "Wrangler", "Model 3", "Accord", "Altima", "Explorer", "X5", "Q5", "RAV4", "F-150", "Silverado", "Outback", "Cherokee", "Model Y", "Rio", "Sonata", "Passat");
    List<String> colores = Arrays.asList("Rojo", "Azul", "Negro", "Blanco", "Gris");
    int currentYear = LocalDate.now().getYear();

    List<Vehiculo> vehiculos = new ArrayList<>();
    for (int i = 0; i < cantidad; i++) {
      String matricula = generarMatricula(); // La matrícula será el ID
      String marca = marcas.get(random.nextInt(marcas.size()));
      String modelo = modelos.get(random.nextInt(modelos.size()));
      int year = random.nextInt(currentYear - 1990 + 1) + 1990;
      double precio = 5000 + (random.nextDouble() * 45000); // Entre 5000 y 50000
      int kilometraje = random.nextInt(300000); // Máximo 300,000 km
      Estado estado = Estado.values()[random.nextInt(Estado.values().length)];
      String color = colores.get(random.nextInt(colores.size()));

      vehiculos.add(new Vehiculo(matricula, marca, modelo, estado, year, precio, kilometraje, color));
    }
    return vehiculos;
  }

  private static String generarMatricula() {
    int numeros = random.nextInt(10000);

    StringBuilder letras = new StringBuilder();
    for (int i = 0; i < 3; i++) {
      letras.append(LETRAS_VALIDAS.charAt(random.nextInt(LETRAS_VALIDAS.length())));
    }

    return String.format("%04d %s", numeros, letras.toString());
  }
}
