import java.util.*;


public class Gestor implements Menu, ValidarDatos {
    private Stack<Operaciones> historial = new Stack<>();
    private LinkedList<Inmueble> inmuebles = new LinkedList<>();
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private Queue<Cliente> listaEspera = new ArrayDeque<>();
    private HashMap<String, LinkedList<Inmueble>> clienteInmueble = new HashMap<>();
    static Scanner sc = new Scanner(System.in);


    public void inicio() {
        Integer choice;
        do {
            menuPrinpial();
            choice = inputInt("Seleccione la opción deseada: ");

            switch (choice) {
                case 1:
                    registrarInmueble();
                    break;
                case 2:
                    realizarAccion();
                    break;
                case 3:
                    clientes.add(addCliente());
                    break;
                case 4:
                    buscar();
                    break;
                case 5:
                    buscarCliente();
                    break;
                case 6:
                    mostrarOperaciones();
                    break;
                case 7:
                    asignarACliente();
                    break;
                case 0:
                    despedida();
                    sc.close();
                    break;
                default:
                    System.out.println("La opción es inválida, pruebe otra vez.");

            }

        }while (choice != 0) ;
    }

    private void asignarACliente() {
        boolean terminado = false;
        int opcion;
        do {
            System.out.println("Ingrese la opción deseada: ");
            opcion = inputInt("""
                [1] - Agregar un nuevo cliente a la lista de espera.
                [2] - Agregar un cliente existente a la lista de espera.
                [0] - Atrás.
                """);

            if (opcion == 0) {
                terminado = true;
            }

            switch (opcion) {
                case 1:
                    Cliente cliente = addCliente();
                    listaEspera.add(cliente);
                    clientes.add(cliente);
                    System.out.println("Operación realizada con éxito");
                    break;
                case 2:
                    listaEspera.add(buscarCliente());
                    System.out.println("Operación realizada con éxito");
                    break;
                default:
                    System.out.println("La opción es inválida. Pruebe otra vez.");
            }

        } while (!terminado);
    }


    private void realizarAccion() {
        int choice;
        do {
            accion();
            choice = inputInt("Ingrese la opción deseada: ");

            if (choice == 1 || choice == 2) {
                Cliente cliente = buscarCliente();
                Inmueble inmueble = buscarInmueble();
                Operaciones.Tipo tipo = (choice == 1) ? Operaciones.Tipo.VENTA : Operaciones.Tipo.COMPRA;
                    // si choice es 1 operacion es venta, si no operacion es compra
                Operaciones operacion = new Operaciones(cliente, inmueble, tipo);
                historial.add(operacion);

                assert cliente != null;
                clienteInmueble.putIfAbsent(cliente.getDni(), new LinkedList<>());
                clienteInmueble.get(cliente.getDni()).add(inmueble);

                System.out.println("La operación se ha realizado con éxito.");
            } else if (choice != 0) {
                System.out.println("La opción es inválida, pruebe otra vez.");
            }

        } while (choice != 0);
    }


    private void mostrarOperaciones() {
        if (historial.isEmpty()) {
            System.out.println("El historial de operaciones se encuentra vacío.");
        } else {
            System.out.println("Historial de operaciones:");
            for (Operaciones operacion : historial) {
                System.out.println(operacion + "\n");
            }
        }
    }



    private Cliente addCliente() {
        String nombre = input("Introduce el nombre del nuevo cliente: ");
        String apellido1 = input("Introduce el primer apellido del cliente: ");
        String apellido2 = input("Introduce el segundo apellido del cliente: ");
        String dni = input("Introduce el DNI del cliente: ");

        return new Cliente(nombre, apellido1, apellido2, dni);

    }

    private void registrarInmueble() {
        int choice;

        do {
            tipoInmueble();
            choice = inputInt("¿Qué tipo de inmueble desea agregar? (1: Casa, 2: Departamento, 3: Local Comercial, 0 para salir): ");

            if (choice == 0) {
                System.out.println("Registro de inmuebles finalizado.");
                return;
            }

            if (choice < 1 || choice > 3) {
                System.out.println("Opción inválida. Intente de nuevo.");
                continue;
            }
            int id = inputInt("Ingrese el ID del nuevo inmueble: ");
            idInmueble(id, inmuebles);
            String ubicacion = ubicacionInmueble(input("Ingrese la ubicación del nuevo inmueble: "));
            double precio = precioInmueble(inputDouble("Ingrese el precio del inmueble: "));
            double superficie = superficieInmueble(inputDouble("Ingrese la superficie del nuevo inmueble: "));

            Inmueble nuevoInmueble = null;

            switch (choice) {
                case 1: // Casa
                    int habitaciones = habitacionCasa(inputInt("Ingrese el número de habitaciones: "));
                    double gardenSize = jardinCasa(inputDouble("Ingrese el tamaño del jardin: "));
                    nuevoInmueble = new Casa(id, ubicacion, precio, superficie, habitaciones, gardenSize);
                    break;

                case 2: // Departamento
                    int piso = pisoDepartamento(inputInt("Introduce el piso del departamento: "));
                    String letra = letraDepartamento(input("Introduce la letra del departamento: "));
                    double expensas = expensasDepartamento(inputDouble("Introduce las expensas del departamento: "));
                    boolean tieneAscensor = inputBoolean("¿Tiene ascensor? (Sí/No): ");
                    boolean tieneGaraje = inputBoolean("¿Tiene garaje? (Sí/No): ");
                    nuevoInmueble = new Departamento(id, ubicacion, precio, superficie, piso, letra, expensas, tieneAscensor, tieneGaraje);
                    break;

                case 3: // Local Comercial
                    String zona = zonaLocal(input("Ingrese la zona del local: "));
                    boolean terraza = inputBoolean("¿Tiene terraza? (Sí/No): ");
                    nuevoInmueble = new LocalComercial(id, ubicacion, precio, superficie, zona, terraza);
                    break;
            }

            inmuebles.add(nuevoInmueble);
            System.out.println("El inmueble ha sido agregado con éxito.");

        } while (choice != 0);
    }

    private Cliente buscarCliente() {
        Cliente cliente = null;
        String dni;
        boolean valido = false;

        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return null;
        }

        do {
            dni = input("Indique el DNI del cliente o 0 para volver: ");

            if (dni.equals("0")) {
                break;
            }

            boolean encontrado = false;
            for (Cliente cliente1 : clientes) {
                if (dni.equalsIgnoreCase(cliente1.getDni())) {
                    cliente = cliente1;
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                System.out.println("Cliente no encontrado. Intente de nuevo.");
            } else {
                valido = true;
            }

        } while (!valido);

        return cliente;
    }

    private Inmueble buscarInmueble() {
        Inmueble inmueble = null;
        int id;
        boolean valido = false;

        if (inmuebles.isEmpty()) {
            System.out.println("No hay inmuebles registrados.");
            return null;
        }

        do {
            id = inputInt("Ingrese el id del inmueble o 0 para volver.");

            if (id == 0) {
                break;
            }

            boolean encontrado = false;
            for (Inmueble inmueble1 : inmuebles) {
                if (id == inmueble1.getId()) {
                    inmueble = inmueble1;
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                System.out.println("Inmueble no encontrado. Intente de nuevo.");
            } else {
                valido = true;
            }

        } while (!valido);

        return inmueble;
    }

    private Operaciones.Tipo tipoOperacion() {
        Operaciones.Tipo tipo = null;
        boolean valido = false;

        do {
            try {
                String entrada = input("Ingrese el tipo de operación (Compra/Venta): ")
                        .trim()
                        .toUpperCase(Locale.ROOT);

                tipo = Operaciones.Tipo.valueOf(entrada);
                valido = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: Tipo de operación inválido. Debe ser 'Compra' o 'Venta'. Intente nuevamente.");
            }
        } while (!valido);

        return tipo;
    }          // **********no lo utilizo de momento

    private void busquedaDepartamento() {        // ********************** revisar/terminar

    }

    private void busquedaCasas() {           // ********************** revisar/terminar

    }

    private void busquedaLocales(){  // ********************** revisar/terminar

    }

    private void busquedaCategorias() {
        if (inmuebles.isEmpty()) {
            System.out.println("No hay inmuebles registrados en los que buscar.");
            return;
        }
        boolean valido = false;
         int opcion;
         LinkedList<Inmueble> aux= new LinkedList<>(inmuebles);
        do {
            opcion = inputInt("""
                    Buscar por:
                    [1] - Ubicación.
                    [2] - Precio.
                    [3] - Superficie.
                    [0] - Atrás.
                    """);

            if (opcion == 0) {
                System.out.println("Busqueda cancelada.");
                return;
            }

        switch (opcion) {
            case 1: // Ordenar por ubicación (alfabéticamente)
                aux.sort(Comparator.comparing(Inmueble::getUbicacion));
                System.out.println("Inmuebles por ubicación.");
                break;

            case 2: // Ordenar por precio (de menor a mayor)
                aux.sort(Comparator.comparingDouble(Inmueble::getPrecio));
                System.out.println("Inmuebles por precio.");
                break;

            case 3: // Ordenar por superficie (de menor a mayor)
                aux.sort(Comparator.comparingDouble(Inmueble::getSuperficie));
                System.out.println("Inmuebles por superficie.");
                break;

            case 0:
                return;

            default:
                System.out.println("Opción inválida. Vuelva a intentar.");

        }

            System.out.println(aux);
    } while (!valido);
    }   // ********************** revisar/terminar

    private static String input(String text) {
        System.out.println(text);
        return sc.nextLine();
    }

    private static Integer inputInt(String text) {
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

    private boolean inputBoolean(String mensaje) {
        try {
            // Validación para asegurarse de que el mensaje no esté vacío
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


    private static Double inputDouble(String text) {
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
