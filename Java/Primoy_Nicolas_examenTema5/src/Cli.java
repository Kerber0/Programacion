import java.util.LinkedList;
import java.util.Scanner;

public class Cli {

    private LinkedList<Multimedia> vistas = new LinkedList<>();
    private LinkedList<Multimedia> viendo = new LinkedList<>();
    static Scanner sc = new Scanner(System.in);
    static Plataformas plataformas;
    private enum Plataformas {NETFLIX, MAX, AMAZON, DISNEY, OTROS}

    public void inicio() {
        int choice;
        System.out.println("Iniciando histórico de contenido multimedia. \n");
        do {
            choice =  inputInt("""
               Por favor, seleccione la opción deseada:
               
                   [1] - Agregar una película/serie a "Estoy viendo".
                   [2] - Eliminar una película o serie de “Estoy viendo”.
                   [3] - Marcar una película o serie como “Vista”.
                   [4] - Mostrar todo el contenido multimedia en “Estoy viendo”.
                   [5] - Mostrar las películas “Vistas”.
                   [6] - Mostrar las series “Vistas”.
                   [0] - Salir.
               
               """);
            switch (choice) {
                case 1 :
                    agregar();
                    break;
                case 2:
                    eliminar();
                    break;
                case 3 :
                    vista();
                    break;
                case 4:
                    mostrarViendo();
                    break;
                case 5 :
                   mostrarPelisVistas();
                    break;
                case 6:
                    mostrarSeriesVistas();
                    break;
                case 0:
                    System.out.println("Adios!");
                    sc.close();
            }

        }while (choice!= 0);

    }

    private void mostrarSeriesVistas() {
        if (vistas.isEmpty()) {
            System.out.println("No hay peliculas vistas");
        }else {
            for (Multimedia series : vistas) {
                if (series.getClass().getSimpleName().equals("Peliculas")){
                    System.out.println(series);
                    String valoracion = "*";
                    System.out.println("Valoracion: " + valoracion.repeat(series.getValoracion()));
                }
            }
        }
    }

    private void mostrarPelisVistas() {
        if (vistas.isEmpty()) {
            System.out.println("No hay peliculas vistas");
        }else {
            for (Multimedia pelis : vistas) {
                if (pelis.getClass().getSimpleName().equals("Peliculas")){
                    System.out.println(pelis);
                    String valoracion = "*";
                    System.out.println("Valoracion: " + valoracion.repeat(pelis.getValoracion()));
                }
            }
        }
    }

    private void mostrarViendo() {
        if (viendo.isEmpty()) {
            System.out.println("Todavía no esta viendo nada.");
            return;
        }else {
            for (Multimedia algo : viendo) {
                System.out.println(algo);
            }
        }
    }

    private void vista() {
        String choice;
        if (viendo.isEmpty()) {
            System.out.println("Todavía no esta viendo nada.");
            return;
        }
        try {
            do {
                choice = input("Ingrese el nombre de la serie que terminó de ver "
                    + "o escriba ¨volver¨ para el menú anterior: ");
                if (choice.equalsIgnoreCase("volver")) {
                    return;
                } else {
                    for (Multimedia algo : viendo) {
                        if (algo.getNombre().equalsIgnoreCase(choice)) {
                            vistas.add(algo);
                            algo.setValoracion(inputInt("Ingrese la valoración de la " + algo.getClass().getSimpleName() + algo.getNombre()));
                            viendo.remove(algo);
                            System.out.println("Se a modificoado " + algo.getNombre() + " de ¨Estoy viendo a ¨Vistas¨");
                        }
                    }
                }

            }while (choice.equalsIgnoreCase("atras") );

        }catch (NullPointerException e) {
            System.out.println("Error, debe ingresar una opcion.");
        }


    }

    private void agregar () {
        int choice;
        do {
            choice = inputInt("""
                Pulse:
                [1] - Para agregar una película.
                [2] - Para agregar una serie.
                [0] - Volver.
                """);

            if (choice == 0) {
                System.out.println("Operacion cancelada.");
                System.out.println("\n");
                return;
            }
            String nombre = input("Ingrese el nombre: ");
            String plataforma = validarPlataforma();

            switch (choice) {
                case 1:
                   try {
                       int duracion = validarDuracion();
                       Multimedia peli = new Peliculas(nombre, plataforma, duracion);
                       System.out.println("La película " + peli.getNombre() + " ha sido agregada correctamente.");
                       viendo.add(peli);

                   }catch (NullPointerException e) {
                       System.out.println("Error se debe ingresar algo");
                   }
                    break;


                case 2:
                    String cap = validarCap();
                    int temp = inputInt("ingrese el numero de temporadas de la serie: ");
                    Multimedia serie = new Series(nombre,plataforma, temp, cap);
                    System.out.println("La serie " + serie.getNombre() + " ha sido agregada correctamente.");
                    viendo.add(serie);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("La opción es invalida, pruebe otra vez.");
            }

        } while (choice!=0);
    }

    private int validarDuracion() {
       boolean valido = false;
       int duracion = 0;
       do {
           duracion =  inputInt("Ingrese la duracón de la película: ");
           if (duracion <= 60 || duracion > 300) {
               System.out.println("Una pelicula debe durar entre 60 y 300 min.");
           }else {
               valido = true;
           }
       }while (!valido);
      return duracion;
    }

    private String validarPlataforma() {
        int plat;
        String plataforma = null;
        boolean valido = false;
        plat = inputInt("""
            Ingrese la plataforma en la que lo esta disfrutando:
                [1] - NETFLIX.
                [2] - MAX.
                [3] - AMAZON.
                [4] - DISNEY.
                [5] - OTROS.
            """);
        do {
            if(plat< 0 || plat>5) {
                System.out.println("""
                    La opción seleccionada no es correcta, vuelva a intentar.
                        [1] - NETFLIX.
                        [2] - MAX.
                        [3] - AMAZON.
                        [4] - DISNEY.
                        [5] - OTROS.
                    
                    """);
                break;
            } else {
                switch (plat) {
                    case 1:
                        plataforma = "Netflix";
                        valido = true;
                        break;
                    case 2:
                        plataforma = "MAX";
                        valido = true;
                        break;
                    case 3:
                        plataforma = "Amazon";
                        valido = true;
                        break;
                    case 4:
                        plataforma = "Disney";
                        valido = true;
                        break;
                    case 5:
                        plataforma = "Otros";
                        valido = true;
                        break;
                }
            }
        }while (!valido);
        return plataforma;
    }

    private String validarCap () {
        String cap = null;
        boolean valido = false;
        cap = input("La serie es de capitulos cortos o largos?");
        do {
            if(!cap.equalsIgnoreCase("CORTOS") && !cap.equalsIgnoreCase("LARGOS")) {
                cap = input("Debe ingresar si los cáptulos son largos o cortos poniedo: largos o cortos.");
            } else {
                valido = true;
            }
        }while (!valido);
        return cap;
    }

    private void eliminar() {
        if (viendo.isEmpty()) {
            System.out.println("Todavía no empezó a ver nada, a que espera?");
        }else {
            String nombre = input("Indique el nombre de la serie o película a borrar: ");

            for(Multimedia algo : viendo) {
                if (algo.getNombre().equalsIgnoreCase(nombre)) {
                    System.out.println("La " + algo.getClass().getSimpleName() + algo.getNombre()
                        + " ha sido eliminada de la lista;");
                    viendo.remove(algo);
                }
            }
        }


    }

    public static String input(String text) {
        boolean textcorrect = false;
        String resultado;
        do {
            System.out.println(text);
            resultado = sc.nextLine();
            if (resultado.isEmpty()){
                System.out.println("Se debe ingresar algo: ");
            } else {
                textcorrect = true;
            }
        }while (!textcorrect);
        return resultado;
    }

    private static Integer inputInt (String text){
        int num = -1;
        boolean valido = false;

        while (!valido) {
            try {
                System.out.println(text);
                num = Integer.parseInt(sc.nextLine());
                valido = true;
            } catch (NumberFormatException e) {
                System.out.println("Error: Por favor ingrese un número válido.");
            }
        }
        return num;
    }





}
