import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú Biblioteca ---");
            System.out.println("1. Añadir libro");
            System.out.println("2. Listar libros");
            System.out.println("3. Buscar libro por código");
            System.out.println("4. Eliminar libro por código");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Código: ");
                    String codigo = sc.nextLine();
                    System.out.print("Título: ");
                    String titulo = sc.nextLine();
                    System.out.print("Autor: ");
                    String autor = sc.nextLine();
                    System.out.print("Año de publicación: ");
                    int anio = sc.nextInt();
                    sc.nextLine();

                    Libro libro = new Libro(codigo, titulo, autor, anio);
                    biblioteca.añadirLibro(libro);
                    break;
                case 2:
                    biblioteca.listarLibros();
                    break;
                case 3:
                    System.out.print("Código del libro a buscar: ");
                    String codBuscar = sc.nextLine();
                    biblioteca.buscarLibro(codBuscar);
                    break;
                case 4:
                    System.out.print("Código del libro a eliminar: ");
                    String codEliminar = sc.nextLine();
                    biblioteca.eliminarLibro(codEliminar);
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);
    }
}