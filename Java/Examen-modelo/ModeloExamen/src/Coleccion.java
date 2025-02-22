import java.util.ArrayList;
import java.util.Scanner;

public class Coleccion {

  private final static Scanner sc = new Scanner(System.in);
  private static ArrayList<Album> albums;

  static String input(String text) {
    System.out.println(text);
    return sc.nextLine();
  }

  public  void agregar() {
    albums.add(
        new Album(
            input("Introduce el nombre del álbum: "),
            input("Introduce el nombre del artista o grupo:"),
            Integer.parseInt(input("Introduce el número canciones:")),
            Integer.parseInt(input("Introduce cantidad de canciones:"))
        ));
  }

  public String mostrar() {
    StringBuilder resultado = new StringBuilder("Lista de álbumes:\n");
    ArrayList<Album> aux = albums;
    for (Album album : aux) resultado.append(album.toString()).append("\n");
    return resultado.toString();
    }


  public void eliminar(String nombre) {
    nombre = input("Introduce el nombre del álbum a eliminar: ");
    boolean borrado = false;
    do {
      if (albums.contains(nombre)) {
        albums.remove(nombre);
        System.out.println("El album " + nombre + " ha sido elminado con exito.");
        borrado = true;
      } else {
        System.out.println("El nombre no se encuentra en la lista, pruebe de nuevo.");
      }
    } while (!borrado);
  }
}
