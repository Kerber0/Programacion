import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class JavaCiudad implements Generador {
    HashMap<TransportePublico, String> vehiculos = new HashMap<>();
    Queue<TransportePublico> mantenimiento = new ArrayDeque<>();

    static Scanner sc = new Scanner(System.in);

    public void inicio() {
        Generador.generar(vehiculos);

        System.out.println("Bienvenido al gestor de Transporte Publico!");

        int choice = -1;
        do {
            try {
                choice = inputInt(""" 
                        Seleccione la opcion que desea ejecutar:
                        
                        [1] - Registrar un nuevo vehiculo.
                        [2] - Calacular tarifa.(tiene que elegir de que vehiculo calcular la tarifa)
                        [3] - Mostrar los vehiculos.
                        [4] - Realizar mantenimiento a vehiculo.
                        [5] - Eliminar un vehiculo.
                        [0] - Salir.
                        
                        
                        """);

                switch (choice) {
                    case 1:
                        agregar();
                        break;
                    case 2:
                        AsignarTarifa();
                        break;
                    case 3:
                        mostrarPorTipo();
                        break;
                    case 4:
                        mantenimiento();
                        break;
                    case 5:
                        // eliminar();
                        break;
                    case 0:
                        System.out.println("Espero haberle sido de ayuda. Adios.");
                        break;
                    default:
                        System.out.println("La opcion ingresdada es invalida, por favor intente otra vez.");

                }

            } catch (NullPointerException e) {
                System.out.println("Error: " + e);
            }
        } while (choice != 0);
    }

    public void agregar() {
        System.out.println("Entrando al método agregar...");
        int choice;
        do {
            choice = inputInt("""
                    Seleccione el vehiculo que desea registrar:
                    [1] - Un autobus.
                    [2] - Un taxi.
                    [3] - Un tranvia.
                    [0] - Atras
                    """);

            if (choice == 0) {
                System.out.println("Registro de vehiculo finalizado.");
                System.out.println("\n");
                return;
            }

            if (choice < 0 || choice > 3) {
                System.out.println("La opcion ingresada no es valida. Pruebe otra vez.");
                continue;
            }

            System.out.println("Solicitando matrícula...");
            String matricula = validarMatricula(input("Ingrese la matricula del vehiculo: "));
            System.out.println("Matrícula recibida: " + matricula);  // Agrega esta línea para ver el valor recibido
            int capacidad = validarPasajeros(choice);
            int velMax = inputInt("Ingrese la velocidad maxima del vehiculo: ");
            //... (resto del código)
        } while (choice != 0);
    }

    private void mostrarPorTipo() {
        if (vehiculos.isEmpty()) {
            System.out.println("No hay vehículos registrados.");
            return;
        }

        int opcion;
        do {
            System.out.println("""
                Seleccione el tipo de vehículo que desea:

                [1] - Autobuses.
                [2] - Taxis.
                [3] - Tranvías.
                [4] - Todo.
                [0] - Volver.

                """);

            opcion = inputInt("Ingrese su opción: ");

            if (opcion < 0 || opcion > 4) {
                System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion < 0 || opcion > 4); // Ahora permite hasta 4

        if (opcion == 0) {
            return; // Salir si elige volver
        }

        String titulo;
        Class<?> tipo = null;

        switch (opcion) {
            case 1:
                titulo = "=== AUTOBUSES ===";
                tipo = Autobus.class;
                break;
            case 2:
                titulo = "=== TAXIS ===";
                tipo = Taxi.class;
                break;
            case 3:
                titulo = "=== TRANVÍAS ===";
                tipo = Tranvia.class;
                break;
            case 4:
                titulo = "=== TODOS LOS VEHÍCULOS ===";
                break;
            default:
                return;
        }

        System.out.println(titulo);

        boolean encontrado = false;
        for (TransportePublico vehiculo : vehiculos.keySet()) {
            if (opcion == 4 || tipo.isInstance(vehiculo)) { // Si elige 4, muestra todo
                System.out.println(vehiculo);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No hay vehículos de este tipo registrados.");
        }
    }

    private void eliminar(){

    }

    private void AsignarTarifa() {
        boolean asignado = false;
        do {
            mostrarPorTipo();
            String seleccion = input("Seleccione la matricula del vehiculo al que calcular tarifa: ");
            if (!vehiculos.containsValue(seleccion)) {
                System.out.println("La matricula ingresada no pertenece a ningun vehiculo, intente otra vez.");
            }
            for (TransportePublico vehiculo : vehiculos.keySet()) {
                if (vehiculo.getMatricula().equalsIgnoreCase(seleccion)) {
                    double tarifa = vehiculo.calcularTarifa();
                    System.out.println("La tarifa para el vehiculo: " + vehiculo.getClass().getSimpleName() + " " +
                            vehiculo.getMatricula() + " es: " + tarifa + "$");
                    asignado = true;
                    break;
                }
            }

        }while (!asignado);

    }

    private void mantenimiento() {
        int choice;
        do {
            choice = inputInt("""
                Seleccione la opcion deseada:
                [1] - Realizar mantenimiento a un vehiculo.
                [2] - Mostrar vehiculos pendientes de mantenimiento.
                [0] - Atras.
                """);

            if (choice == 0) {
                return;
            }
            if (choice < 0 || choice > 2) {
                System.out.println("La opcion ingresada es invalida. Pruebe otra vez.");
            }

            switch (choice) {
                case 1:
                    agregarMantenimiento();
                    break;
                case 2:
                    if (mantenimiento.isEmpty()) {
                        System.out.println("No hay vehículos pendientes de mantenimiento.");
                    } else {
                        System.out.println("Lista de vehículos en mantenimiento:\n");
                        for (TransportePublico vehiculo : mantenimiento) {
                            System.out.println(vehiculo.getClass().getSimpleName() + " - " + vehiculos.get(vehiculo));
                        }
                    }
                    break;

            }
        }while (choice != 0);
    }


    private void agregarMantenimiento() {
        String matricula;
        boolean agregado = false;

        do {
            mostrarPorTipo();
            matricula = input("Ingrese la matricula del vehiculo al que se le va a realizar el mantenimiento o 0 para salir: ");
            if (matricula.equalsIgnoreCase("0")) {
                return;
            }
            if (!vehiculos.containsValue(matricula)) {
                System.out.println("La matricula ingresada no pertenece a ningun vehiculo, intente otra vez");
            } else {
                for (Map.Entry<TransportePublico, String> entry : vehiculos.entrySet()) {
                    if (entry.getValue().equals(matricula)) {
                        mantenimiento.add(entry.getKey()); // Agregar a la cola de mantenimiento
                        System.out.println("Vehículo agregado a mantenimiento: " + entry.getKey().getClass().getSimpleName() + " - " + matricula);
                        agregado = true;
                        break;
                    }

                }

            }
        }while (!agregado) ;
    }

    private String validarMatricula(String matricula) {
        matricula = matricula.toUpperCase();
        String regex = "^[0-9]{4}[BCDFGHJKLMNPRSTVWXYZ]{3}$";

        while (!matricula.matches(regex)) {
            System.out.println("Matrícula inválida. Formato correcto: 1234-BCD");
            matricula = input("Ingrese la matrícula otra vez: ").toUpperCase();
        }

        return matricula;
    }



    private int validarPasajeros ( int choice){
        boolean valido = false;
        int pasajeros;
        do {
            pasajeros = inputInt("Ingerese la capacidad maxima de pasajeros: ");
            switch (choice) {
                case 1:
                    if (pasajeros != 102) {
                        System.out.println("El maximo de pasajeros de un autobus es 102. Intente de nuevo. ");
                    } else {
                        valido = true;
                    }
                    break;
                case 2:
                    if (pasajeros != 1 && pasajeros != 6) {
                        System.out.println("El maximo de pasajeros de un taxi es 3 o 6. Intente de nuevo. ");
                    } else {
                        valido = true;
                    }
                    break;
                case 3:
                    if (pasajeros != 200 && pasajeros != 510) {
                        System.out.println("El maximo de pasajeros de un tranvia es 200 o 510. Intente de nuevo. ");
                    } else {
                        valido = true;
                    }
                    break;


            }
        } while (!valido);
        return pasajeros;
    }

    //INPUTS
    public static String input (String text){
        boolean textcorrect = false;
        String resultado;
        do {
            System.out.println(text);
            resultado = sc.nextLine();
            if (text.isEmpty()) {
                System.out.println("Se debe ingresar algo: ");
            } else {
                textcorrect = true;
            }
        } while (!textcorrect);
        return resultado;
    }

    public static Integer inputInt (String text){
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

    public static boolean inputBoolean (String mensaje){
        try {

            if (mensaje == null || mensaje.trim().isEmpty()) {
                throw new IllegalArgumentException("La respuesta no puede estar vacía.");
            }

            while (true) {
                String respuesta = input(mensaje).trim().toLowerCase();
                if (respuesta.equals("true") || respuesta.equals("sí") || respuesta.equals("si")) {
                    return true;
                } else if (respuesta.equals("false") || respuesta.equals("no")) {
                    return false;
                } else {
                    System.out.println("Por favor, ingrese 'si' o 'no'.");
                }
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            return false;  // o podrías devolver true o relanzar la excepción dependiendo de cómo desees manejarlo
        }
    }


    public static double inputDouble (String text){
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

    public static LocalDate inputLocalDate () {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        while (true) {
            String input = input("Introduce una fecha de nacimiento en formato dd/MM/yyyy: ");

            try {
                return LocalDate.parse(input, formatter);
            } catch (Exception e) {
                System.out.println("La fecha ingresada no tiene un formato válido. Intenta de nuevo.");
            }
        }
    }

    }




