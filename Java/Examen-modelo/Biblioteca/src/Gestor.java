import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.time.LocalDate;

public class Gestor {
    static Scanner sc = new Scanner(System.in);
    List<Libro> biblioteca = new ArrayList<>();


    public Gestor() {
    }

    public void menuPrincipal() {
        System.out.println(" Bienvenido a la biblioteca!");

        int opcion = -1;
        do {
            System.out.println("""
                Seleccione la opción deseada:
                [1] - Mostrar Libros.
                [2] - Agregar nuevo libro.
                [3] - Editar libro.
                [4] - Eliminar libro.
                [5] - Buscar libro.
                [0] - Salir.
                """);

            try {
                System.out.print("Opción: ");
                opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {
                    case 1 -> mostrar();
                    case 2 -> agregar();
                    case 3 -> editar();
                    case 4 -> eliminar();
                    case 5 -> buscar();
                    case 0 -> salir();
                    default -> System.out.println("Opción inválida. Intente de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un número válido.");
            }

        } while (opcion != 0);
    }

    private void salir(){
        System.out.println("Espero haberle sido de ayuda. Adiós.");
        sc.close();
    }

    private void buscar(){
        int opcion;
        do {
            System.out.println("""
                    Seleccione el metodo de busqueda:
                    [1] - Título.
                    [2] - Autor.
                    [3] - Año de publicación.
                    [4] - Número de páginas.
                    [0] - Atras.
                    """);
            opcion = Integer.parseInt(sc.nextLine());
            switch (opcion){
                case 1:
                    buscarTitulo(input("Ingrese el titulo: "));
                    break;
                case 2:
                    buscarAutor(input("Ingrese el autor: "));
                    break;
                case 3:
                    buscaryear(inputInt("Ingrese el año que desea buscar: "));
                    break;
                case 4:
                    buscarNumPag(inputInt("Ingrese el número de paginas: "));
                case 0:
                    return;
                default:
                    System.out.println("La opcion introducida no es válida, vuelva a intentar.");
            }
        } while (true);
    }

    private void mostrar(){
        if (biblioteca.isEmpty()) {
            System.out.println("No hay libros para mostrar");
            return;
        }
        System.out.println("Lista de libros: ");
        for (Libro libro : biblioteca){
            System.out.println(libro);
            return;
        }
    }

    private void mostrarpos(){
        StringBuilder toret = new StringBuilder("Lista de libros:\n");
        if(biblioteca.isEmpty()){
            System.out.println("La biblioteca esta vacía.");
        }else{
            for (int i = 0; i < biblioteca.size(); i++) {
                toret.append(i).append(" ").append(biblioteca.get(i).getTitulo()).append("\n");
            }
        System.out.println(toret);
        }
    }

    private void agregar(){
        String titulo = input("Introduce el titulo");
        String autor = input("Introduce el autor");
        int year = leeryear();
        int numPag = leerNumPag();
        Libro libro = new Libro(titulo, autor, year, numPag);
        biblioteca.add(libro);
        System.out.println("El libro " + titulo + " se ha agregado correctamente.");
    }

    private void editar() {
        mostrarpos();

        if (biblioteca.isEmpty()) {
            System.out.println("No hay libros para editar.");
            return;
        }

        try {
            int pos = Integer.parseInt(input("Seleccione la posición del libro a editar: "));

            if (pos >= 0 && pos < biblioteca.size()) {
                Libro libro = biblioteca.get(pos);
                boolean continuar = true;

                do {
                    System.out.println("Editando: " + libro.getTitulo());
                    System.out.println("""
                        ¿Qué desea editar?
                        [1] - Título.
                        [2] - Autor.
                        [3] - Año de publicación.
                        [4] - Número de páginas.
                        [0] - Atrás.
                        """);

                    int opcion = Integer.parseInt(sc.nextLine());

                    switch (opcion) {
                        case 1 -> {
                            String nuevoTitulo = input("Ingrese el nuevo título: ");
                            libro.setTitulo(nuevoTitulo);
                            System.out.println("Título actualizado correctamente.");
                        }
                        case 2 -> {
                            String nuevoAutor = input("Ingrese el nuevo autor: ");
                            libro.setAutor(nuevoAutor);
                            System.out.println("Autor actualizado correctamente.");
                        }
                        case 3 -> {
                            int nuevoYear = leeryear();
                            libro.setYear(nuevoYear);
                            System.out.println("Año actualizado correctamente.");
                        }
                        case 4 -> {
                            int nuevasPaginas = leerNumPag();
                            libro.setNumPag(nuevasPaginas);
                            System.out.println("Número de páginas actualizado correctamente.");
                        }
                        case 0 -> {
                            System.out.println("Edición finalizada.");
                            continuar = false;
                        }
                        default -> System.out.println("Opción inválida, intente nuevamente.");
                    }
                } while (continuar);

            } else {
                System.out.println("Error: La posición ingresada no es válida.");
            }

        } catch (NumberFormatException e) {
            System.out.println("Error: Debes ingresar un número válido.");
        }
    }

    private int leeryear(){
        int year = 0;
        boolean correctYear = false;
        do {
            try {
                year = Integer.parseInt(input("Introduce el año de publicación del libro: "));
                if(year > 1500 && year < LocalDate.now().getYear()){
                    correctYear = true;
                }else {
                    System.out.println("El año debe estar entre 1500 y " + (LocalDate.now().getYear() - 1));
                }
            }catch (NumberFormatException exception) {
                System.out.println("Error: Debes ingresar un número válido.");
            }
        } while (!correctYear);
        return year;
    }

    private int leerNumPag(){
        int numpag = 0;
        boolean correcto = false;
        do {
            try {
                numpag = Integer.parseInt(input("Introduce el número de páginas del libro: "));
                if (numpag > 0) {
                    correcto = true;
                } else {
                    System.out.println("Error: El número de páginas debe ser mayor que 0.");
                }
            } catch (NumberFormatException exception) {

                System.out.println("Error: Debes ingresar un número válido.");
            }
        } while (!correcto);

        return numpag;
    }

    private void eliminar(){
        if (biblioteca.isEmpty()) {
            System.out.println("No hay libros en la biblioteca para eliminar.");
            return;
        }

        mostrarpos();

        try {
            int pos = Integer.parseInt(input("Seleccione la posición del libro a eliminar: "));

            if (pos >= 0 && pos < biblioteca.size()) {
                Libro eliminado = biblioteca.remove(pos);
                System.out.println("El libro " + eliminado + " se ha eliminado correctamente.");
            } else {
                System.out.println("Error: Posición inválida.");
            }
        } catch (NumberFormatException exception) {
            System.out.println("Error: Debes ingresar una posición válida.");
        }
    }

    private void buscarTitulo(String titulo){
        ArrayList<Libro> aux = new ArrayList<>();
        for (Libro libro : biblioteca) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                aux.add(libro);
            }
        }
        if(aux.isEmpty()){
             System.out.println("No se encuentra el titulo que se busca.");

        }else {
            System.out.println("Libro encontrado con exito: " + aux);
        }
    }

    private void buscarAutor(String autor){
        ArrayList<Libro> aux = new ArrayList<>();
        for (Libro libro : biblioteca) {
            if (libro.getTitulo().equalsIgnoreCase(autor)) {
                aux.add(libro);
            }
        }
        if(aux.isEmpty()){
            System.out.println("No se encuentra el autor que se busca.");
        }else {
            System.out.println("Libro encontrado con exito: " + aux);
        }
    }

    private void buscaryear(int year){
        ArrayList<Libro> aux = new ArrayList<>();
        for (Libro libro : biblioteca) {
            if (libro.getYear() == (year)) {
                aux.add(libro);
            }
        }
        if(aux.isEmpty()){
            System.out.println("No se encuentra ningun libro con el año que se busca.");
        }else {
            System.out.println("Libro encontrado con exito: " + aux);
        }
    }

    private void buscarNumPag(int num){
        ArrayList<Libro> aux = new ArrayList<>();
        for (Libro libro : biblioteca) {
            if (libro.getNumPag() == (num)) {
                aux.add(libro);
            }
        }
        if(aux.isEmpty()){
            System.out.println("No se encuentra ningun libro con ese número de páginas.");
        }else {
            System.out.println("Libro encontrado con exito: " + aux);
        }
    }

    static String input(String text) {
        System.out.println(text);
        return sc.nextLine();
    }

    static Integer inputInt(String text) {
        Integer num = null;
        boolean valido = false;
        do {
            try {
                System.out.println(text);
                num = Integer.parseInt(sc.nextLine());

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



