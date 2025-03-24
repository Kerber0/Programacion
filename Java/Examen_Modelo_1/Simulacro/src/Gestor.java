import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.List;


public class Gestor {
    static Scanner sc = new Scanner(System.in);
    List<Album> coleccion = new ArrayList<>();

    public void menuPrincipal() {
        int opcion;
        do {
        System.out.println("""
              ________________________
             |       BIENVENIDO       |
             |1. Mostrar albums       |
             |2. Añadir album         |
             |3. Editar datos de álbum|
             |4. Eliminar un álbum    |
             |5. Filtrar por nombre   |
             |6. Número de álbums     |
             |7. Salir                |
              ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯
            """);


             opcion = inputInt("Introduce la opcción deseada: ");
            switch (opcion) {
                case 1:
                    mostrar();
                    break;
                case 2:
                    add();
                    break;
                case 3:
                    edit();
                    break;
                case 4:
                    delete();
                    break;
                case 5:
                    search();
                    break;
                case 6:
                    count();
                    break;
                case 0:
                    System.out.println("Fin de programa.");
                    break;
                default:
                    System.out.println("La opción es inválida, pruebe otra vez.");

            }
        } while (opcion != 0);
    }

    public void mostrar() {
        if(coleccion.isEmpty()) {
            System.out.println("No hay albums para mostrar.");
            System.out.println("-".repeat(30));
            return;
        }
        List<Album> albumsOrdenados = new ArrayList<>(coleccion);
        albumsOrdenados.sort(Comparator.comparing(Album :: getName, String.CASE_INSENSITIVE_ORDER));

        System.out.println("Lista de albums ordenados: ");
        for (Album albums : albumsOrdenados){
            System.out.println(albums);
        }
        System.out.println("-".repeat(30));
    }

    public void add() {
      /*
        boolean isValid = false;
        String name = null;

        while (!isValid) {
            name = input("Introduce el nombre del nuevo álbum.");
            isValid = name.matches("^[\\p{L} ]+$");
        }
       */

        String name = input("Introduce el nombre del nuevo álbum.");
        String author = input("Introduce el nombre del autor/grupo.");
        int year = readYear();
        int numSong = readSongs();

        Album newAlbum = new Album(name, author, year, numSong);
        coleccion.add(newAlbum);
        System.out.println("El album " + newAlbum.getName() + " ha sido agregad con éxito.");
        System.out.println("-".repeat(30));
    }

    private int readYear() {
        boolean correctYear = false;
        int year = 0;
        do {
            try {
                year = inputInt("Introduce un año válido.");
                if (year < 1500 || year > LocalDate.now().getYear()) {
                    System.out.println("El número ingresado no es válido, pruebe otra vez.");
                    System.out.println("-".repeat(30));
                } else {
                    correctYear = true;
                }

            } catch (NumberFormatException e){
                System.out.println("Error: se debe ingresar un número.");
                System.out.println("-".repeat(30));
            }
        } while (!correctYear);
        return year;
    }

    private int readSongs() {
        boolean correctnumber = false;
        int songs = 0;
        do {
            try {
                songs = inputInt("Introduce el número de canciones.");
                if (songs <= 0){
                    System.out.println("El número debe ser positivo, pruebe otra vez.");
                    System.out.println("-".repeat(30));
                } else {
                    correctnumber = true;
                }
            }catch (NumberFormatException e) {
                System.out.println("Error: se debe ingresar un número positivo.");
                System.out.println("-".repeat(30));
            }
        } while (!correctnumber);
        return songs;
    }

    private void delete() {
        if (coleccion.isEmpty()){
            System.out.println("No hay álbums para eliminar.");
            System.out.println("-".repeat(30));
            return;
        }
        mostrarPos();

        try {
            int pos = inputInt("Introduce la posicion del álbum a eliminar: ");
            if (pos >= 0 && pos < coleccion.size()) {
                System.out.println("El álbum " + coleccion.remove(pos).getName() + " se ha eliminado correctamente.");
                System.out.println("-".repeat(30));
                coleccion.remove(pos);
            } else {
                System.out.println("Error: posición inválida.");
                System.out.println("-".repeat(30));
            }
        }catch (NumberFormatException e) {
            System.out.println("Error: debes ingresar un número de posición");
            System.out.println("-".repeat(30));
        }
    }

    private void edit() {
        mostrarPos();
        if (coleccion.isEmpty()) {
            System.out.println("No hay álbums para modificar.");
            System.out.println("-".repeat(30));
        }
        try {
            int pos = inputInt("Seleccione la posición del álbum a modificar: ");
            if (pos >= 0 && pos < coleccion.size()) {
                Album album = coleccion.get(pos);
                boolean continuar = true;
                do {
                    System.out.println("Editando: " + album.getName());
                    int opcion = inputInt("""
                        ¿Qué desea editar?
                        [1] - Título.
                        [2] - Autor/Grupo.
                        [3] - Número de Canciones.
                        [4] - Año de publicación.
                        [0] - Atrás.
                        """);
                    System.out.println("-".repeat(30));
                    switch(opcion) {
                        case 1 -> {
                            String nuevoTitulo = input("Ingrese el nuevo título: ");
                            album.setTitle(nuevoTitulo);
                            System.out.println("Título modificado correctamente");
                            System.out.println("-".repeat(30));
                        }
                        case 2 -> {
                            String nuevoAutor = input("Ingrese el nuevo nombre de autor/grupo: ");
                            album.setName(nuevoAutor);
                            System.out.println("Autor/Grupo modificado correctamente.");
                            System.out.println("-".repeat(30));
                        }
                        case 3 -> {
                            int nuevoNumSongs = readSongs();
                            album.setNumSong(nuevoNumSongs);
                            System.out.println("Precio modificado correctamente.");
                            System.out.println("-".repeat(30));
                        }
                        case 4 -> {
                            int nuevoYear = readYear();
                            album.setYear(nuevoYear);
                            System.out.println("Año de publicación modificado correctamente.");
                            System.out.println("-".repeat(30));
                        }
                        case 0 -> {
                            System.out.println("Modificaciones finalizadas");
                            System.out.println("-".repeat(30));
                            continuar = false;
                        }
                    }
                } while (continuar);
                } else {
                System.out.println("Error: la posición ingresada no es válida.");
                System.out.println("-".repeat(30));
            }
        }catch (NumberFormatException e) {
            System.out.println("Error: Se debe ingresar un número válido.");
            System.out.println("-".repeat(30));
        }
    }

    private void search(){
        String busqueda = input("Introduce el tílulo completo o parte de él: ");
        StringBuilder aux = new StringBuilder("Albums encontrados: ");

        for (Album album : coleccion) {
            if (album.getTitle().toLowerCase().contains(busqueda)){
                aux.append(coleccion.indexOf(album)).append(" ").append(album.getName()).append("\n");
            }
        }
        if (aux.length() <= 0) {
            System.out.println("No se encontró ningún álbum. ");
        }else {
            System.out.println(aux);
            System.out.println("-".repeat(30));
        }
    }

    private void mostrarPos() {
        StringBuilder aux = new StringBuilder("Lista de albums: ");
        if (coleccion.isEmpty()){
            System.out.println("No hay productos para eliminar.");
            System.out.println("-".repeat(30));
        }
        for (Album albums : coleccion) {
            aux.append(coleccion.indexOf(albums)).append(" ").append(albums.getName()).append("\n");
        }
        System.out.println(aux);
        System.out.println("-".repeat(30));
    }

    private void count (){

        System.out.println("En la colección hay " + coleccion.size() + " álbum/s");
        System.out.println("-".repeat(30));
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
                num = Integer.parseInt(sc.nextLine());

                if (num >= 0) {
                    valido = true;
                } else {
                    System.out.println("Error: El número debe ser positivo.");
                    System.out.println("-".repeat(30));
                }

            } catch (NumberFormatException exception) {
                System.out.println("Error: Se debe ingresar un número válido.");
                System.out.println("-".repeat(30));
            }
        } while (!valido);
        return num;
    }


}
