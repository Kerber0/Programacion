import java.util.Scanner;

public class Menu {

  private final static Scanner sc = new Scanner(System.in);


  public bienvenida() {
    System.out.println("""
        Bienvenido a la biblioteca!
        Seleccione la opcion deseada:
        [1] - Mostrar todos los libros.
        [2] - Agregar un libro nuevo.
        [3] - Editar un libro.
        [4] - Eliminar un libo.
        [5] - Buscar libro.
        [0] - Salir
        """);
    switch (inputInt()) {
      case 1:
        Biblioteca.mostrarLibros();
      case 2:
        Biblioteca.agregar(Biblioteca.Libro.newLibro);
      case 3:
        menuEditar();
      case 4:
        menuBuscar();
      case 0:
        despedida();
      default:
        System.out.println("Error. La opcion elegida es inválida.");
    }
  }

  private void despedida() {
    System.out.println("Espero haberle sido de ayuda. Adios!");
  }

  public void menuEditar() {
    System.out.println("""
        Seleccione la opcion deseada:
        [1] - Editar título.
        [2] - Editar autor.
        [3] - Editar año de publicación.
        [4] - Editar número de páginas.
        [0] - Atrás.
        """);
    int pos = Integer.parseInt(input("Introduce la posición del libro a modificar"));
    String cambio = input("Introduce el nuevo valor.");

    switch (inputInt()) {
      case 1:
        Biblioteca.editarTitulo(pos, cambio);
      case 2:
        Biblioteca.editarAutor(pos, cambio);
      case 3:
        menuEditar();
      case 4:
        menuBuscar();
      case 0:
        break;
      default:
        System.out.println("Error. La opción elegida es inválida.");

    }
  }

  public void menuBuscar() {
    System.out.println("""
        Seleccione el índice de busqueda:
        [1] - Por título.
        [2] - Por autor.
        [0] - Atrás.
        """);
    String opcion = input();
    int pos = Integer.parseInt(input("Introduce la posición del libro a modificar"));
    String cambio = input("Introduce el nuevo valor.");
    switch (Integer.parseInt(opcion)){
      case 1: Biblioteca.buscar(Integer.parseInt(opcion));
    }
  }


  static String input(String text) {
    System.out.println(text);
    return sc.nextLine();
  }

  static String input() {
    System.out.println("Introducir valor: ");
    return sc.nextLine();
  }

  static int inputInt() {
    System.out.println("Introducir valor: ");
    return Integer.parseInt(sc.nextLine());
  }


}
