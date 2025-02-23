import java.util.Scanner;
import static java.lang.Integer.parseInt;


public class Menus {

    private final Gestor gestor;
    private static final Scanner sc = new Scanner(System.in);

    public Menus(Gestor gestor) {
        this.gestor = new Gestor();
    }

    public void menuPrincipal() {
        System.out.println("Bienvenido a la colección de álbumes");
        Integer opcion = -1;
        do {
            try {
            opcion = (inputInt("""
                    Seleccione la opcion que desea:
                    [1] - Mostrar todos los álbumes de la colección.
                    [2] - Añadir un nuevo álbum.
                    [3] - Editar un álbum.
                    [4] - Eliminar un álbum.
                    [0] - Salir.
                    """));
            switch (opcion) {
                case 1:
                    gestor.mostrar();
                    break;
                case 2:
                    gestor.agregar();
                    break;
                case 3:
                    menuEditar();
                    break;
                case 4:
                    gestor.eliminar();
                    break;
                case 5:
                    menuBuscar();
                    break;
                case 0:
                    System.out.println("Adios.");

            }
        } catch (NumberFormatException e){
                System.out.println("Error: debe ingresar un número.");
            }
    } while (opcion != 0);

    }

    public void menuEditar() {
        gestor.mostrarPos();
        Integer opcion = -1;
        do {
            try {
                opcion = (inputInt("""
                        Seleccione lo que desea editar:
                        [1] - Título.
                        [2] - Nombre del artista/grupo.
                        [3] - Año de publicación.
                        [4] - Número de canciones.
                        [0] - Atrás.
                        """));
                switch (opcion) {
                    case 1 -> {
                        
                    }
                    case 2 -> {
                        String nuevaCategoria = input("Ingrese la nueva categoría: ");
                        producto.setCategoria(nuevaCategoria);
                        System.out.println("Categoría modificada correctamente.");
                    }
                    case 3 -> {
                        double nuevoPrecio = leerPrecio();
                        producto.setPrecio(nuevoPrecio);
                        System.out.println("Precio modificado correctamente.");
                    }
                    case 4 -> {
                        int nuevoStock = leerStock();
                        producto.setStock(nuevoStock);
                        System.out.println("Stock modificado correctamente.");
                    }
                    case 0 -> {
                        System.out.println("Modificaciones finalizadas");
                        continuar = false;
                    }
                }

            } catch(NumberFormatException e){
            System.out.println("Error: debe ingresar un número.");
        }
    }while (opcion != 0) ;
    }

    public void menuBuscar(){
        Integer opcion = -1;
        do {
            try {
                opcion = (inputInt("""
                    Seleccione el método de busqueda que desea:
                    [1] - Por título.
                    [2] - Por nombre del artista/grupo.
                    [3] - Por año de publicación.
                    [4] - Por número de canciones.
                    [0] - Atrás.
                    """));
                switch (opcion) {
                    case 1:
                        gestor.buscarTitulo(input("Introduce título a buscar: "));
                        break;
                    case 2:
                        gestor.buscarAutor(input("Introduce autor a buscar: "));
                        break;
                    case 3:
                        gestor.buscarYear(inputInt("Introduce el año de publicación a buscar: "));
                        break;
                    case 4:
                        gestor.buscarNumSong(inputInt("Introduce el número de canciones: "));
                        break;
                    case 0:
                        System.out.println("Adios.");

                }
            } catch (NumberFormatException e){
                System.out.println("Error: debe ingresar un número.");
            }
        } while (opcion != 0);

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
