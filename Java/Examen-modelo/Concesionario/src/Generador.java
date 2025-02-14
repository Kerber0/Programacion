import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class Generador {

  public static List<Vehiculo> generador(int cantidad) {
    List<String> marcas = Arrays.asList("Toyota", "Ford", "Chevrolet", "Honda", "Nissan", "BMW", "Mercedes-Benz", "Hyundai", "Kia", "Volkswagen", "Subaru", "Mazda", "Audi", "Jeep", "Tesla");
    List<String> modelos = Arrays.asList("Corolla", "Focus", "Cruze", "Civic", "Sentra", "Mustang", "Camry", "Elantra", "Tucson", "Golf", "Forester", "CX-5", "A4", "Wrangler", "Model 3", "Accord", "Altima", "Explorer", "X5", "Q5", "RAV4", "F-150", "Silverado", "Outback", "Cherokee", "Model Y", "Rio", "Sonata", "Passat");
    List<String> colores = Arrays.asList("Rojo", "Azul", "Negro", "Blanco", "Gris");
    Random random = new Random();
    int currentYear = LocalDate.now().getYear();

    List<Vehiculo> vehiculos = new ArrayList<>();
    for (int i = 0; i < cantidad; i++) {
      String id = UUID.randomUUID().toString();
      String marca = marcas.get(random.nextInt(marcas.size()));
      String modelo = modelos.get(random.nextInt(modelos.size()));
      int year = random.nextInt(currentYear - 1990 + 1) + 1990;
      double precio = 5000 + (random.nextDouble() * 45000); // Entre 5000 y 50000
      int kilometraje = random.nextInt(300000); // Máximo 300,000 km
      Vehiculo.Estado estado = Vehiculo.Estado.values()[random.nextInt(Vehiculo.Estado.values().length)];
      String color = colores.get(random.nextInt(colores.size()));

      vehiculos.add(new Vehiculo(id, marca, modelo, estado, year, precio, kilometraje, color));
    }
    return vehiculos;
  }


}
