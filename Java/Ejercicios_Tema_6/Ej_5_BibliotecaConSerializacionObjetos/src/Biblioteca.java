import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Libro> libros;
    private final String nombreFichero = "biblioteca.dat";

    public Biblioteca() {
        libros = cargarLibros();
    }

    private List<Libro> cargarLibros() {
        List<Libro> lista = new ArrayList<>();
        File fichero = new File(nombreFichero);

        if (fichero.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero))) {
                lista = (List<Libro>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error al cargar libros: " + e.getMessage());
            }
        }

        return lista;
    }

    private void guardarLibros() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreFichero))) {
            oos.writeObject(libros);
        } catch (IOException e) {
            System.out.println("Error al guardar libros: " + e.getMessage());
        }
    }

    public void añadirLibro(Libro libro) {
        libros.add(libro);
        guardarLibros();
        System.out.println("Libro añadido correctamente.");
    }

    public void listarLibros() {
        if (libros.isEmpty()) {
            System.out.println("No hay libros en la biblioteca.");
        } else {
            for (Libro l : libros) {
                System.out.println(l);
            }
        }
    }

    public void buscarLibro(String codigo) {
        for (Libro l : libros) {
            if (l.getCodigo().equalsIgnoreCase(codigo)) {
                System.out.println("Libro encontrado: " + l);
                return;
            }
        }
        System.out.println("Libro no encontrado.");
    }

    public void eliminarLibro(String codigo) {
        boolean eliminado = libros.removeIf(l -> l.getCodigo().equalsIgnoreCase(codigo));
        if (eliminado) {
            guardarLibros();
            System.out.println("Libro eliminado correctamente.");
        } else {
            System.out.println("Libro no encontrado.");
        }
    }
}