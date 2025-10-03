
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Cli implements Menus, ValidarDatos {

    private LinkedList<Inmueble> inmuebles = new LinkedList<>();
    static Scanner sc = new Scanner(System.in);

    public void inicio() {
        Integer choice;
        System.out.println("Bienvenido al Gestor de Inmuebles!");
        do {
            menuPrincipal();
            choice = inputInt("Seleccione la opción deseada: ");

            switch (choice) {
                case 1:
                    registrarInmueble();
                    break;
                case 2:
                   // aVenta();
                    break;
                case 3:
                    aAlquiler();
                    break;
                case 4:
                    mostrarInmuebles();
                    break;
                case 5:
                    eliminarInmueble();
                    break;

                case 0:
                    despedida();
                    sc.close();
                    break;
                default:
                    System.out.println("La opción es inválida, pruebe otra vez.");
            }

        } while (choice != 0);
    }

    private void mostrarInmuebles() {
        System.out.println("Lista de inmubeles: ");
        for (Inmueble inmueble : inmuebles) {
            System.out.println(inmueble);
        }
    }

    private void eliminarInmueble() {
        mostrarInmuebles();


    }

    private void registrarInmueble() {

        int choice;

        do {
            choice = inputInt(""" 
                    ¿Qué tipo de inmueble desea agregar?:
                    [1] - Para casa.
                    [2] - Para apartamento.
                    [0] - Atrás.
                """);

            if (choice == 0) {
                System.out.println("Registro de inmuebles finalizado.");
                System.out.println("\n");
                sc.close();
                return;
            }

            if (choice < 1 || choice > 2) {
                System.out.println("Opción inválida. Intente de nuevo.");
                continue;
            }
            int superficie = superficieInmueble(
            inputInt("Ingrese la superficie del nuevo inmueble: "));
            int numHabitaciones = inputInt("ingrese el numero de habitaciones");
            boolean garaje = inputBoolean("¿Tiene garaje? (Sí/No): ");
            String calle = direccionInmueble("Ingrese la calle del inmueble: ");
            int numero = numeroInmueble(inputInt("Ingrese el número del inmueble: "));
            Inmueble.Estado estado = Inmueble.Estado.DISPONIBLE;
            Double precio = null;
            int id = inputInt("Ingrese el ID del nuevo inmueble: ");
            idInmueble(id, inmuebles);

            Inmueble nuevoInmueble = null;

            switch (choice) {
                case 1: // Casa
                    int numPisos = pisosCasa(inputInt("Ingrese el número de pisos de la casa: "));
                    boolean piscina = inputBoolean("La casa tiene piscina? (Sí/No):");
                    nuevoInmueble = new Casa(superficie, numHabitaciones, garaje, calle,
                        numero, estado, precio, id, numPisos, piscina);
                    break;

                case 2: // Departamento
                    int piso = pisoDepartamento();
                    String letra = letraDepartamento();
                    nuevoInmueble = new Departamento(superficie, numHabitaciones, garaje, calle,
                        numero, estado, precio, id, piso, letra);
                    break;

            }

            inmuebles.add(nuevoInmueble);
            System.out.println(
                "El inmueble ha sido agregado con éxito. Su estado se guardo como ´Disponible´");

        } while (choice != 0);
    }

    private void aVenta() {
        System.out.println("Estos son los inmuebles disponibles: ");
        inmueblesDisponible();
        int id = inputInt("Seleccione el Id del inmueble que quiere pasar a ´En Venta´: ");
        for (Inmueble inmueble : inmuebles) {
            if(id == inmueble.getId()) {
                inmueble.setEstado(Inmueble.Estado.EN_VENTA);
                inmueble.setPrecio(inmueble.precioVenta());
            }
        }
    }
// ver la llamada para fijar el precio del inmueble

    private void aAlquiler() {
        System.out.println("Estos son los inmuebles disponibles: ");
        inmueblesDisponible();
        int id = inputInt("Seleccione el Id del inmueble que quiere pasar a ´En Alquiler´: ");
        for (Inmueble inmueble : inmuebles) {
            if(id == inmueble.getId()) {
                inmueble.setEstado(Inmueble.Estado.EN_ALQUILER);
                inmueble.setPrecio(inmueble.precioAlquiler());
            }
        }
    }

    private void inmueblesDisponible() {
        if (inmuebles.isEmpty()) {
            System.out.println("No hay inmuebles registrados.");
            return;
        }

        ArrayList<Inmueble> inmueblesDisponibles = filtrarInmueblesPorTipoYDisponibilidad();

        if (inmueblesDisponibles == null) {
            System.out.println("Se ha cancelado la búsqueda.");
            return;
        }

        if (inmueblesDisponibles.isEmpty()) {
            System.out.println("No se encontraron inmuebles disponibles de ese tipo.");
        } else {
            System.out.println("Inmuebles disponibles:");
            for (Inmueble inmueble : inmueblesDisponibles) {
                System.out.println(inmueble);
            }
        }
    }

    private ArrayList<Inmueble> filtrarInmueblesPorTipoYDisponibilidad() {
        ArrayList<Inmueble> inmueblesFiltrados = new ArrayList<>();
        String tipoInmueble;

        do {
            tipoInmueble = input(
                "Indique el tipo de inmueble que desea buscar (Casa, Departamento, Local Comercial) o 0 para volver: ").trim();

            if (tipoInmueble.equals("0")) {
                return inmueblesFiltrados;
            }

            if (!(tipoInmueble.equalsIgnoreCase("casa") ||
                tipoInmueble.equalsIgnoreCase("departamento") ||
                tipoInmueble.equalsIgnoreCase("local comercial"))) {
                System.out.println("Tipo de inmueble no válido. Intente nuevamente.");
            }
        } while (!(tipoInmueble.equalsIgnoreCase("casa") ||
            tipoInmueble.equalsIgnoreCase("departamento") ||
            tipoInmueble.equalsIgnoreCase("local comercial")));

        for (Inmueble inmueble : inmuebles) {
            // Filtrar solo los inmuebles disponibles del tipo seleccionado
            if (inmueble.getEstado() == Inmueble.Estado.DISPONIBLE) {
                if (tipoInmueble.equalsIgnoreCase("casa") && inmueble instanceof Casa) {
                    inmueblesFiltrados.add(inmueble);
                } else if (tipoInmueble.equalsIgnoreCase("departamento")
                    && inmueble instanceof Departamento) {
                    inmueblesFiltrados.add(inmueble);
                }
            }


        }
        return inmueblesFiltrados;
    }



    private static String input (String text){
        System.out.println(text);
        return sc.nextLine();
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

    private boolean inputBoolean (String mensaje){
        try {
            // Validación para asegurarse de que el mensaje no esté vacío
            if (mensaje == null || mensaje.trim().isEmpty()) {
                throw new IllegalArgumentException("La respuesta no puede estar vacía.");
            }

            while (true) {
                String respuesta = input(mensaje).trim().toLowerCase();
                if (respuesta.equals("true") || respuesta.equals("sí") || respuesta.equals(
                    "si")) {
                    return true;
                } else if (respuesta.equals("false") || respuesta.equals("no")) {
                    return false;
                } else {
                    System.out.println("Por favor, ingrese 'si' o 'no'.");
                }
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    private static Double inputDouble (String text){
        double num = 0.0;
        boolean valido = false;
        do {
            try {
                System.out.println(text);
                num = Double.parseDouble(sc.nextLine());
                valido = true;
            } catch (NumberFormatException e) {
                System.out.println("Error: Se debe ingresar un número válido.");
            }
        } while (!valido);
        return num;
    }

}












