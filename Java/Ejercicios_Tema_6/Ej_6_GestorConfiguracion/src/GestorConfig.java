import java.io.*;
import java.util.*;

public class GestorConfig {
    private final Properties props = new Properties();

    public void iniciar() {
        cargarConfig();
        menu();
    }

    private void cargarConfig() {
        File file = new File(Config.CONFIG_FILE);
        if (!file.exists()) {
            System.out.println("No se encontró el archivo, creando por defecto...");
            guardarConfig(Config.getDefaultProperties());
        }
        try (FileInputStream fis = new FileInputStream(Config.CONFIG_FILE)) {
            props.load(fis);
        } catch (IOException e) {
            System.out.println("Error al leer: " + e.getMessage());
        }
    }

    private void guardarConfig(Properties propiedades) {
        try (FileOutputStream fos = new FileOutputStream("config.properties")) {
            propiedades.store(fos, "Configuración de la aplicación");
        } catch (IOException e) {
            System.out.println("Error al guardar configuración: " + e.getMessage());
        }
    }

    private void mostrarConfig() {
        System.out.println("\n--- Configuración actual ---");
        for (String key : props.stringPropertyNames()) {
            System.out.println(key + " = " + props.getProperty(key));
        }
        System.out.println("-----------------------------");
    }

    private void modificarConfig(Scanner sc) {
        mostrarConfig();
        System.out.print("Introduce la propiedad a modificar: ");
        String clave = sc.nextLine();
        if (!props.containsKey(clave)) {
            System.out.println("Propiedad no encontrada.");
            return;
        }
        System.out.print("Nuevo valor para '" + clave + "': ");
        String nuevoValor = sc.nextLine();
        props.setProperty(clave, nuevoValor);
        guardarConfig(props);
        System.out.println("Propiedad modificada.");
    }

    private void restaurarPorDefecto() {

        Properties porDefecto = Config.getDefaultProperties();
        guardarConfig(porDefecto);

        props.clear();
        props.putAll(porDefecto);
        System.out.println("Configuración restaurada a valores por defecto.");
    }

    private void menu() {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n=== Menú de Configuración ===");
            System.out.println("1. Ver configuración");
            System.out.println("2. Modificar propiedad");
            System.out.println("3. Restaurar valores por defecto");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1 -> mostrarConfig();
                case 2 -> modificarConfig(sc);
                case 3 -> restaurarPorDefecto();
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }
}