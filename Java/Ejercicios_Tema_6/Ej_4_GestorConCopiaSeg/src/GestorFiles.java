import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class GestorFiles {

    private static final String FICHERO_TAREAS = "tareas.txt";
    private static final Path PATH_TAREAS = Paths.get(FICHERO_TAREAS);
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        crearFicheroSiNoExiste();

        int opcion;
        do {
            mostrarMenu();
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    anadirTarea();
                    break;
                case 2:
                    mostrarTareas();
                    break;
                case 3:
                    eliminarTarea();
                    break;
                case 4:
                    crearCopiaSeguridad();
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);
    }

    private static void mostrarMenu() {
        System.out.println("\n--- Menú Gestor de Tareas ---");
        System.out.println("1. Añadir nueva tarea");
        System.out.println("2. Mostrar todas las tareas");
        System.out.println("3. Eliminar tarea por ID");
        System.out.println("4. Crear copia de seguridad");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void crearFicheroSiNoExiste() {
        try {
            if (Files.notExists(PATH_TAREAS)) {
                Files.createFile(PATH_TAREAS);
                System.out.println("Fichero de tareas creado.");
            }
        } catch (IOException e) {
            System.out.println("Error al crear el fichero de tareas.");
        }
    }

    private static void anadirTarea() {
        System.out.print("Introduce la descripción de la tarea: ");
        String descripcion = sc.nextLine();

        int nuevoId = obtenerSiguienteID();

        String linea = nuevoId + " | " + descripcion;

        try {
            Files.write(PATH_TAREAS, Arrays.asList(linea), StandardOpenOption.APPEND);
            System.out.println("Tarea añadida correctamente.");
        } catch (IOException e) {
            System.out.println("Error al añadir tarea.");
        }
    }

    private static int obtenerSiguienteID() {
        try {
            List<String> lineas = Files.readAllLines(PATH_TAREAS);
            int maxId = 0;

            for (String linea : lineas) {
                String[] partes = linea.split("\\|");
                int id = Integer.parseInt(partes[0].trim());
                if (id > maxId) {
                    maxId = id;
                }
            }

            return maxId + 1;

        } catch (IOException e) {
            System.out.println("Error al obtener ID.");
            return 1;
        }
    }

    private static void mostrarTareas() {
        System.out.println("\nListado de Tareas:");

        try {
            List<String> lineas = Files.readAllLines(PATH_TAREAS);

            if (lineas.isEmpty()) {
                System.out.println("No hay tareas registradas.");
            } else {
                lineas.forEach(System.out::println);
            }

        } catch (IOException e) {
            System.out.println("Error al leer las tareas.");
        }
    }

    private static void eliminarTarea() {
        mostrarTareas();

        System.out.print("Introduce el ID de la tarea a eliminar: ");
        int idEliminar = sc.nextInt();
        sc.nextLine(); // Limpiar buffer

        try {
            List<String> lineas = Files.readAllLines(PATH_TAREAS);

            List<String> nuevasLineas = lineas.stream()
                    .filter(linea -> {
                        String[] partes = linea.split("\\|");
                        int id = Integer.parseInt(partes[0].trim());
                        return id != idEliminar;
                    })
                    .collect(Collectors.toList());

            Files.write(PATH_TAREAS, nuevasLineas, StandardOpenOption.TRUNCATE_EXISTING);

            System.out.println("Tarea eliminada correctamente (si existía).");

        } catch (IOException e) {
            System.out.println("Error al eliminar tarea.");
        }
    }

    private static void crearCopiaSeguridad() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm");
        String fechaHora = LocalDateTime.now().format(formatter);

        String nombreBackup = "tareas_backup_" + fechaHora + ".txt";
        Path pathBackup = Paths.get(nombreBackup);

        try {
            Files.copy(PATH_TAREAS, pathBackup, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Copia de seguridad creada: " + nombreBackup);
        } catch (IOException e) {
            System.out.println("Error al crear la copia de seguridad.");
        }
    }
}