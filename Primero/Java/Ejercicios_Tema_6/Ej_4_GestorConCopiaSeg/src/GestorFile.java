import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class GestorFile {

    private static final String FICHERO_TAREAS = "tareas.txt";
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
        File fichero = new File(FICHERO_TAREAS);
        if (!fichero.exists()) {
            try {
                fichero.createNewFile();
                System.out.println("Fichero de tareas creado.");
            } catch (IOException e) {
                System.out.println("Error al crear el fichero.");
            }
        }
    }

    private static void anadirTarea() {
        System.out.print("Introduce la descripción de la tarea: ");
        String descripcion = sc.nextLine();
        int nuevoId = obtenerSiguienteID();

        try (FileWriter fw = new FileWriter(FICHERO_TAREAS, true);
             PrintWriter pw = new PrintWriter(fw)) {

            pw.println(nuevoId + " | " + descripcion);
            System.out.println("Tarea añadida correctamente.");

        } catch (IOException e) {
            System.out.println("Error al escribir la tarea.");
        }
    }

    private static int obtenerSiguienteID() {
        int maxId = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(FICHERO_TAREAS))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split("\\|");
                int id = Integer.parseInt(partes[0].trim());
                if (id > maxId) {
                    maxId = id;
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer las tareas.");
        }

        return maxId + 1;
    }

    private static void mostrarTareas() {
        System.out.println("\nListado de Tareas:");

        try (BufferedReader br = new BufferedReader(new FileReader(FICHERO_TAREAS))) {
            String linea;
            boolean hayTareas = false;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
                hayTareas = true;
            }
            if (!hayTareas) {
                System.out.println("No hay tareas registradas.");
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

        File ficheroOriginal = new File(FICHERO_TAREAS);
        File ficheroTemporal = new File("tareas_temp.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(ficheroOriginal));
             PrintWriter pw = new PrintWriter(new FileWriter(ficheroTemporal))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split("\\|");
                int id = Integer.parseInt(partes[0].trim());

                if (id != idEliminar) {
                    pw.println(linea);
                }
            }

        } catch (IOException e) {
            System.out.println("Error al eliminar la tarea.");
        }

        if (ficheroOriginal.delete()) {
            ficheroTemporal.renameTo(ficheroOriginal);
            System.out.println("Tarea eliminada correctamente (si existía).");
        } else {
            System.out.println("Error al actualizar el fichero.");
        }
    }

    private static void crearCopiaSeguridad() {
        String fechaHora = new SimpleDateFormat("yyyy-MM-dd_HH-mm").format(new Date());
        String nombreBackup = "tareas_backup_" + fechaHora + ".txt";

        File ficheroOriginal = new File(FICHERO_TAREAS);
        File ficheroBackup = new File(nombreBackup);

        try (BufferedReader br = new BufferedReader(new FileReader(ficheroOriginal));
             PrintWriter pw = new PrintWriter(new FileWriter(ficheroBackup))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                pw.println(linea);
            }

            System.out.println("Copia de seguridad creada: " + nombreBackup);

        } catch (IOException e) {
            System.out.println("Error al crear la copia de seguridad.");
        }
    }
}