public class Main {
    public static void main(String[] args) {

        // Crear un objeto de la clase Libro
        Libro libro = new Libro("El Principito", "Antoine de Saint-Exupéry", 96, "978-3-16-148410-0");

        // Mostrar la información del libro utilizando el método toString
        System.out.println(libro.toString());

        // Modificar algunos atributos del libro
        libro.setTitulo("El Principito - Edición Especial");
        libro.setNumPaginas(104);

        // Mostrar nuevamente la información del libro después de los cambios
        System.out.println(libro);
    }
}