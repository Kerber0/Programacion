import java.awt.Stroke;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Coleccion {

  private final static Scanner sc = new Scanner(System.in);
  private List<Album> albumes;

  public void Album(ArrayList<Album> albumes) {
    this.albumes = Album.albumes;
  }

  static String input(String text) {
    System.out.println(text);
    return sc.nextLine();
  }

  public void agregar() {
    albumes.add(
        new Album(
            input("Introduce el nombre del álbum: "),
            input("Introduce el nombre del artista o grupo:"),
            Integer.parseInt(input("Introduce el número canciones:")),
            Integer.parseInt(input("Introduce cantidad de canciones:"))
        ));
  }

  public void mostrar() {
    StringBuilder resultado = new StringBuilder("Lista de álbumes:\n");
    for (int i = 0; i < albumes.size(); i++) {
      Album albumes = this.albumes.get(i);
      resultado.append("[").append(i).append("]")
          .append(albumes.getNombre()).append(" ")
          .append(albumes.getArtista()).append(" ")
          .append(albumes.getYear()).append(" ")
          .append(albumes.getNumCanciones());
    }
    System.out.println(resultado);
  }

  public void eliminar(String nombre) {
    nombre = input("Introduce el nombre del álbum a eliminar: ");
    boolean borrado = false;
    do {
      if (albumes.contains(nombre)) {
        albumes.remove(nombre);
        System.out.println("El album " + nombre + " ha sido elminado con exito.");
        borrado = true;
      } else {
        System.out.println("El nombre no se encuentra en la lista, pruebe de nuevo.");
      }
    } while (!borrado);
  }
}
