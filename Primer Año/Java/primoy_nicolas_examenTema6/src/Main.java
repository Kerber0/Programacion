import java.util.Scanner;

public class Main {

    public static final int LISTAR_PELICULAS = 1;

    public static void main(String[] args) {
        Gestor gestor = new Gestor();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú Videoclub ---");
            System.out.println("1. Listar Peliculas");
            System.out.println("2. Registrar Cliente");
            System.out.println("3. Listar clientes registrados");
            System.out.println("4. Buscar un cliente por número");
            System.out.println("5. Eliminar cliente");
            System.out.println("6. Registrar alquiler");
            System.out.println("7. Registrar devolucion");
            System.out.println("0. Salir\n");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case LISTAR_PELICULAS:
                    gestor.mostrarPeliculas();
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del nuevo cliente: ");
                    String nombre = sc.nextLine();
                    System.out.print("Ingrese el email del nuevo cliente: ");
                    String email = sc.nextLine();
                    int id = gestor.nuevoID();
                    Cliente nuevo = new Cliente(nombre, email, id);
                    gestor.agregarCliente(nuevo);
                    break;
                case 3:
                    gestor.mostrarClientes();
                    break;
                case 4:
                    gestor.buscarCliente();
                    break;
                case 5:
                    gestor.eliminarCliente();;
                    break;
                case 6:
                    gestor.registraroperacion(true );
                    break;
                case 7:
                    gestor.registraroperacion(false);
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    sc.close();
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }
}