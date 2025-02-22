import java.util.Comparator;
import java.util.Random;

public class Main {
  public static void main(String[] arg) {
    int opcion;
    do {
      System.out.println(" *** Agenda Telefónica ***");
      System.out.println("Seleccione una opción de las siguientes: ");
      System.out.println("1. Agregar contacto");
      System.out.println("2. Mostrar contactos");
      System.out.println("3. Buscar contacto");
      System.out.println("4. Eliminar contacto");
      System.out.println("5. Mostrar contactos ordenados alfabéticamente");
      System.out.println("6. Salir del programa");
      opcion = AgendaTelefonica.scanner.nextInt();
      AgendaTelefonica.scanner.nextLine();

      switch (opcion) {
        case 1:
          agregarContacto();
          break;
        case 2:
          mostrarContactos();
          break;
        case 3:
          buscarContacto();
          break;
        case 4:
          eliminarContacto();
          break;
        case 5:
          mostrarAlfabeticamenteContacto();
          break;
        case 6:
          System.out.println("Fin del programa");
        default:
          System.out.println("Opción no válida, introduzca una opción del 1 al 6");
      }
    } while (opcion != 6);
  }

  private static void agregarContacto() {
    System.out.println("Introduzca el nombre: ");
    String nombre = AgendaTelefonica.scanner.nextLine();
    System.out.println("Introduzca el número de teléfono: ");
    String telefono = AgendaTelefonica.scanner.nextLine();
    System.out.println("Introduzca el email: ");
    String email = AgendaTelefonica.scanner.nextLine();

    AgendaTelefonica.contactos.add(new Contacto(nombre, telefono, email));
    System.out.println("El contacto ha sido agregado correctamente");
  }

  private static void mostrarAlfabeticamenteContacto() {
    if (AgendaTelefonica.contactos.isEmpty()) {
      System.out.println("La agenda telefónica está vacía");
    } else {
      System.out.println("Lista de todos los contactos: ");
      AgendaTelefonica.contactos.sort(Comparator.comparing(Contacto::toString));
      for (Contacto contacto : AgendaTelefonica.contactos) {
        System.out.println(contacto.toString());
      }
    }
  }

  private static void mostrarContactos() {
    if (AgendaTelefonica.contactos.isEmpty()) {
      System.out.println("La agenda telefónica está vacía");
    } else {
      System.out.println("Lista de todos los contactos: ");
      for (Contacto contacto : AgendaTelefonica.contactos) {
        System.out.println(contacto.toString());
      }
    }
  }

  private static void buscarContacto() {
    System.out.println("Introduzca el nombre que quiere buscar: ");
    String nombreBuscado = AgendaTelefonica.scanner.nextLine(); // Puedo hacer boolean encontrado = false
    for (Contacto contacto : AgendaTelefonica.contactos) {
      if (contacto.getNombre().equalsIgnoreCase(nombreBuscado)) {
        System.out.println("Contacto encontrado: ");
        System.out.println(contacto); // Y aquí encontrado = true
        break;
      } else {
        System.out.println("No se encontró el contacto"); // y aquí meter un if con !encontrado
      }
    }
  }

  private static void eliminarContacto() {
    System.out.println("Ingrese el nombre del contacto a eliminar: ");
    String nombreEliminado = AgendaTelefonica.scanner.nextLine();
    boolean eliminado = false;

    for (int i = 0; i < AgendaTelefonica.contactos.size(); i++) {
      if (AgendaTelefonica.contactos.get(i).getNombre().equalsIgnoreCase(nombreEliminado)) {
        AgendaTelefonica.contactos.remove(i);
        eliminado = true;
        System.out.println("El contacto ha sido eliminado correctamente");
        break;
      }
    }
    if (!eliminado) { // Aquí podría hacerlo con else como en el anterior método
      System.out.println("No se encontró ningún contacto");
    }

    Random random = new Random();

    int randomNumber = random.nextInt(16);
    System.out.println("Número aleatorio entre 0 y 15: " + randomNumber);

    int randomNumberInRange = random.nextInt(100) + 1;
    System.out.println("Número aleatorio entre 1 y 100: " + randomNumberInRange);
  }
}