public class Main {

  private static ArrayList<Persona> personas = new ArrayList<>();
  private static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    leerPersonas();
    mostrar();
    System.out.println("Número de personas: " + numeroDePersonas());
    System.out.println("Persona de mayor edad: \n" + personaMayorEdad());
    System.out.print("Ingrese ciudad para buscar cuántas personas viven allí: ");
    String ciudad = scanner.nextLine();
    System.out.println("Personas que viven en " + ciudad + ": " + cuantasPersonasVivenEn(ciudad));
    System.out.println("Número de personas mayores de edad: " + personasMayoresDeEdad());
  }

  public static void leerPersonas() {
    System.out.print("Ingrese el número de personas: ");
    int n = scanner.nextInt();
    scanner.nextLine();

    for (int i = 0; i < n; i++) {
      System.out.println("Datos de la persona " + (i + 1) + ":");
      System.out.print("Nombre: ");
      String nombre = scanner.nextLine();
      System.out.print("Dirección: ");
      String direccion = scanner.nextLine();
      System.out.print("Código Postal: ");
      int codigoPostal = scanner.nextInt();
      scanner.nextLine();
      System.out.print("Ciudad: ");
      String ciudad = scanner.nextLine();
      System.out.print("Fecha de nacimiento (dd mm aaaa): ");
      int dia = scanner.nextInt();
      int mes = scanner.nextInt();
      int anio = scanner.nextInt();
      scanner.nextLine();

      personas.add(new Persona(nombre, direccion, codigoPostal, ciudad, new Fecha(dia, mes, anio)));
    }
  }

  public static void mostrar() {
    for (Persona p : personas) {
      System.out.println(p);
    }
  }

  public static int numeroDePersonas() {
    return personas.size();
  }

  public static Persona personaMayorEdad() {
    if (personas.isEmpty()) {
      return null;
    }
    Persona mayor = personas.get(0);
    for (Persona p : personas) {
      if (p.getFechaNacimiento().esMayorQue(mayor.getFechaNacimiento())) {
        mayor = p;
      }
    }
    return mayor;
  }

  public static int cuantasPersonasVivenEn(String ciudad) {
    int contador = 0;
    for (Persona p : personas) {
      if (p.getCiudad().equalsIgnoreCase(ciudad)) {
        contador++;
      }
    }
    return contador;
  }

  public static int personasMayoresDeEdad() {
    int contador = 0;
    for (Persona p : personas) {
      if (p.esMayorDeEdad()) {
        contador++;
      }
    }
    return contador;
  }
}

