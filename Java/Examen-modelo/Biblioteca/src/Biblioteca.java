import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

public class Biblioteca {

  private static ArrayList<Libro> biblioteca = new ArrayList<>();


  public static void mostrarLibros() {
    if (biblioteca.isEmpty()) {
      System.out.println("Todavía no hay ningún libro añadidoen la biblioteca.");
    }
    ArrayList<Libro> aux = new ArrayList<>(biblioteca);
    aux.sort(Comparator.comparing(Libro::getAutor));
    for (Libro libro : aux) {
      System.out.println(libro);
    }
    System.out.println(aux);
  }


  public static void agregar(Libro newLibro) {
    Biblioteca.biblioteca.add(newLibro);
  }

  public static void editarTitulo(int pos, String titulo) {
    try {
      Biblioteca.biblioteca.get(pos).setTitulo(titulo);
    } catch (IndexOutOfBoundsException exception) {
      System.out.println("El libro seleccionado no existe.");
    }
  }

  public static void editarAutor(int pos, String autor) {
    try {
      Biblioteca.biblioteca.get(pos).setAutor(autor);
    } catch (IndexOutOfBoundsException exception) {
      System.out.println("El libro seleccionado no existe.");
    }
  }

  public void editaryear(int pos, Date anio) {
    try {
      Biblioteca.biblioteca.get(pos).setYear(anio);
    } catch (IndexOutOfBoundsException exception) {
      System.out.println("El libro seleccionado no existe.");
    }
  }

  public void editarNumPag(int pos, int numpag) {
    try {
      Biblioteca.biblioteca.get(pos).setNumpag(numpag);
    } catch (IndexOutOfBoundsException exception) {
      System.out.println("El libro seleccionado no existe.");
    }
  }


  public void borrar(int pos) {
    try {
      System.out.println(
          "El libro " + Biblioteca.biblioteca.remove(pos).getTitulo() + " ha sido eliminado.");
    } catch (IndexOutOfBoundsException exception) {
      System.out.println("El libro seleccionado no existe.");
    }
  }

  public static void buscar(int opcion) {
    if (opcion == 1) {

    }
  }

  private static void agregarLibro() {
    String title = askForTitle();
    String author = askForAuthor();
    Date year = askForYear();
    int numSongs = askForNumSongs();
    Libro newLibro = new Libro(title, author, year, numSongs);
    Biblioteca.agregar(newLibro);
  }

}

