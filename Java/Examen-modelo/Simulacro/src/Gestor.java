import java.time.LocalDate;
import java.util.*;

import static java.lang.Integer.parseInt;

public class Gestor {

    private static final Scanner sc = new Scanner(System.in);
    private final List<Album> coleccion;

    public Gestor() {
        coleccion = new ArrayList<>();
    }

    public void mostrar() {
        if (coleccion.isEmpty()) {
            System.out.println("No hay productos para mostrar");
            return;
        }
        List<Album> albumsOrdenados = new ArrayList<>(coleccion);
        albumsOrdenados.sort(Comparator.comparing(Album::getTitulo, String.CASE_INSENSITIVE_ORDER));

       imprimirLista("Lista de albums: ", albumsOrdenados);
    }

    public void agregar() {
        String titulo = input("Introduce el título del álbum: ");
        String autor = input("Introduce el nombre del autor/grupo: ");
        int year = leerYear();
        int numSong = leerNumSong();

        for (Album album : coleccion) {
            if(album.getTitulo().equalsIgnoreCase(titulo)) {
                System.out.println("El álbum ya esta en la colección.");
                return;
            }
        }
    Album nuevoAlbum = new Album(titulo, autor, year, numSong);
        coleccion.add(nuevoAlbum);
        System.out.println("El álbum " + nuevoAlbum.getTitulo() + "ha sido agregado a la colección.");
    }

    public int leerYear() {
        boolean correctyear = false;
        int year = -1;
        do {
            try {
                year = parseInt(input("Introduce año de publicación: "));

                if (year < 1800 && year > LocalDate.now().getYear()) {
                    System.out.println("El precio del producto debe ser positivo.");
                } else {
                    correctyear = true;
                }
            } catch (NumberFormatException exception) {
                System.out.println("Error: se debe introducir un número.");
            }
        } while (!correctyear);
        return year;
    }

    public int leerNumSong() {
        boolean correctNumSong = false;
        int num = -1;
        do {
            try {
                num =inputInt("Introduce la cantidad de canciones del álbum: ");
                if (num < 1) {
                    System.out.println("La cantidad mínima de canciones es 1.");
                } else {
                    correctNumSong = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: se debe introducir un número.");
            }
        } while (!correctNumSong);
        return num;
    }

    public void buscarTitulo(final String titulo) {

        final StringBuilder encontrado = new StringBuilder("Libro encontrado con exito: \n");

        coleccion.parallelStream()
                .filter((p) -> p.getTitulo().equalsIgnoreCase(titulo))
                .forEach((p) -> encontrado.append(p).append("\n"));

        System.out.println(encontrado.isEmpty() ? "No se encontro ningún producto con ese nombre." : encontrado);
    }

    public void buscarAutor(final String autor) {

        final StringBuilder encontrado = new StringBuilder("Libro encontrado con exito: \n");

        coleccion.parallelStream()
                .filter((p) -> p.getAutor().equalsIgnoreCase(autor))
                .forEach((p) -> encontrado.append(p).append("\n"));

        System.out.println(encontrado.isEmpty() ? "No se encontro ningún producto con ese autor." : encontrado);
    }

    public void buscarYear(final int year) {

        final StringBuilder encontrado = new StringBuilder("Libro encontrado con exito: \n");

        coleccion.parallelStream()
                .filter((p) -> p.getYear() == (year))
                .forEach((p) -> encontrado.append(p).append("\n"));

        System.out.println(encontrado.isEmpty() ? "No se encontro ningún producto con ese año." : encontrado);
    }

    public void buscarNumSong(final int numSong) {

        final StringBuilder encontrado = new StringBuilder("Libro encontrado con exito: \n");

        coleccion.parallelStream()
                .filter((p) -> p.getNumSong() == (numSong))
                .forEach((p) -> encontrado.append(p).append("\n"));

        System.out.println(encontrado.isEmpty() ? "No se encontro ningún producto con ese número de canciones." : encontrado);
    }

    public void imprimirLista(String text, List<Album> albums) {
        System.out.println(text);
        for (Album album : albums) {
            System.out.println(album);
        }
    }

    public void mostrarPos(){
        StringBuilder toret = new StringBuilder("Lista de productos: \n");
        if (coleccion.isEmpty()) {
            System.out.println("El inventario esta vacío.");
            return;
        }
        for (Album album : coleccion) {
            toret.append(coleccion.indexOf(album)).append(" ").append(album.getTitulo()).append("\n");
        }
        System.out.println(toret);
    }

    public void nuevoTitulo(){
        String nuevoTitulo = input("Ingrese el nuevo título: ");
        album.setTitulo(nuevoTitulo);
        System.out.println("Nombre modificado correctamente");
    }

    private static String input(String text) {
        System.out.println(text);
        return sc.nextLine();
    }

    private static Integer inputInt(String text) {
        Integer num = null;
        boolean valido = false;
        do {
            try {
                System.out.println(text);
                num = parseInt(sc.nextLine());

                if (num >= 0) {
                    valido = true;
                } else {
                    System.out.println("Error: El número debe ser positivo.");
                }

            } catch (NumberFormatException exception) {
                System.out.println("Error: Se debe ingresar un número válido.");
            }
        } while (!valido);
        return num;
    }
}


