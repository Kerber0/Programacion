import java.util.*;


public class Gestor implements Menu, ValidarDatos {
    private Stack<Operaciones> historial = new Stack<>();
    private LinkedList<Inmueble> inmuebles = new LinkedList<>();
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private Queue<Cliente> listaEspera = new ArrayDeque<>();
    private HashMap<String, LinkedList<Inmueble>> clienteInmueble = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    //***********CREACION INMBUEBLES Y CLIENTES PARA TRABAJAR
    public LinkedList<Inmueble> inmuebles() {
        while (inmuebles.size() < 9){
            inmuebles.add(CreacionRandom.generarCasa());
            inmuebles.add(CreacionRandom.generarDepartamento());
            inmuebles.add(CreacionRandom.generarLocalComercial());
        }
        return inmuebles;
    }

    public ArrayList<Cliente> clientes () {
        while (clientes.size() < 5) {
            clientes.add(CreacionRandom.generarCliente());
        }
        return clientes;
    }

    public void inicio() {

        inmuebles();
        clientes();

        Integer choice;
        System.out.println("Bienvenido al Gestor de Inmuebles!");
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
                    inmueblesDisponible();
                    break;
                case 5:
                    System.out.println(buscarCliente());
                    break;
                case 6:
                    mostrarOperaciones();
                    break;
                case 7:
                    asignarACliente();
                    break;
                case 8:
                    mostrarInmuebles();
                    break;
                case 9:
                    mostrarClientes();
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

    private void mostrarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes para mostrar.");
        } else {
            System.out.println("Lista de clientes: ");
            for(Cliente cliente : clientes) {
                System.out.println(cliente);
            }
        }
    }

    private void mostrarInmuebles() {
        if (inmuebles.isEmpty()) {
            System.out.println("No hay inmuebles para mostrar.");
        } else {
            for(Inmueble inmueble : inmuebles) {
                System.out.println(inmueble);
            }
        }
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
                    mostrarClientes();
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
        String nombre = datoCliente("nombre");
        String apellido1 = datoCliente("primer apellido");
        String apellido2 = datoCliente("segundo apellido");
        String dni = Cliente.validarDNI(input("Ingrese el DNI del cliente: "));

        return new Cliente(nombre, apellido1, apellido2, dni);

    }

    private void registrarInmueble() {
        int choice;

        do {
            tipoInmueble();
            choice = inputInt("¿Qué tipo de inmueble desea agregar?: ");

            if (choice == 0) {
                System.out.println("Registro de inmuebles finalizado.");
                System.out.println("\n");
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
        ArrayList<Cliente> encontrados = new ArrayList<>();
        Cliente clienteSeleccionado = null;
        String nombre;
        boolean valido = false;

        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return null;
        }

        do {
            nombre = input("Indique el nombre del cliente que esta buscando o 0 para volver: ");

            if (nombre.equals("0")) {
                break;
            }

            for (Cliente cliente : clientes) {
                if (nombre.equalsIgnoreCase(cliente.getNombre())) {
                    encontrados.add(cliente);
                }
            }

            if (!encontrados.isEmpty()) {
                System.out.println("Clientes encontrados:");
                for (int i = 0; i < encontrados.size(); i++) {
                    System.out.println((i + 1) + ". " + encontrados.get(i).getNombre() + " " + encontrados.get(i).getApellidos() + " - DNI: " + encontrados.get(i).getDni());
                }

                String dniSeleccionado = input("Indique el DNI del cliente que desea seleccionar o 0 para volver: ");
                if (dniSeleccionado.equals("0")) {
                    break;
                }

                for (Cliente cliente : encontrados) {
                    if (cliente.getDni().equalsIgnoreCase(dniSeleccionado)) {
                        clienteSeleccionado = cliente;
                        valido = true;
                        break;
                    }
                }

                if (clienteSeleccionado == null) {
                    System.out.println("DNI no encontrado entre los clientes seleccionados. Intente de nuevo.");
                }
            } else {
                System.out.println("No se encontraron clientes con ese nombre. Intente de nuevo.");
            }
        } while (!valido);
        return clienteSeleccionado;
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
            tipoInmueble = input("Indique el tipo de inmueble que desea buscar (Casa, Departamento, Local Comercial) o 0 para volver: ").trim();

            if (tipoInmueble.equals("0")) {
                return inmueblesFiltrados; // Retorna una lista vacía para terminar la búsqueda
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
            if (inmueble.getEstadoActual() == Inmueble.Estado.Disponible) {
                if (tipoInmueble.equalsIgnoreCase("casa") && inmueble instanceof Casa) {
                    inmueblesFiltrados.add(inmueble);
                } else if (tipoInmueble.equalsIgnoreCase("departamento") && inmueble instanceof Departamento) {
                    inmueblesFiltrados.add(inmueble);
                } else if (tipoInmueble.equalsIgnoreCase("local comercial") && inmueble instanceof LocalComercial) {
                    inmueblesFiltrados.add(inmueble);
                }
            }
        }

        return inmueblesFiltrados;
    }



    private Inmueble buscarInmueble() {
        Inmueble inmueble = null;

        if (inmuebles.isEmpty()) {
            System.out.println("No hay inmuebles registrados.");
            return null;
        }

        ArrayList<Inmueble> inmueblesFiltrados = filtrarInmueblesPorTipoYDisponibilidad();

        if (inmueblesFiltrados == null) {
            System.out.println("Se ha cancelado la búsqueda.");
            return null;
        }

        if (inmueblesFiltrados.isEmpty()) {
            System.out.println("No se encontraron inmuebles disponibles de ese tipo.");
            return null;
        }

        System.out.println("Inmuebles disponibles del tipo seleccionado:");
        for (Inmueble inm : inmueblesFiltrados) {
            System.out.println(inm);
        }

        int id = inputInt("Indique el ID del inmueble que desea seleccionar o 0 para volver: ");
        if (id == 0) {
            return null;
        }

        for (Inmueble inm : inmueblesFiltrados) {
            if (inm.getId() == id) {
                return inm;
            }
        }

        System.out.println("Inmueble no encontrado con ese ID.");
        return null;
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
    }          // ********** no lo utilizo de momento

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



//***************inputs

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