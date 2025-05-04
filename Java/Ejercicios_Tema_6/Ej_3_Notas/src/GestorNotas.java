import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

public class GestorNotas {
    private static final Path DIR = Paths.get("Ej_03_Notas");
    private static final Path ESTUDIANTES_FILE = DIR.resolve("estudiantes.txt");
    private final Scanner scanner = new Scanner(System.in);

    public void inicio() {
        try {
            if (!Files.exists(DIR)) Files.createDirectories(DIR);
            if (!Files.exists(ESTUDIANTES_FILE)) Files.createFile(ESTUDIANTES_FILE);
        } catch (IOException e) {
            System.out.println("Error al crear archivos iniciales: " + e.getMessage());
            return;
        }

        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");
            switch (opcion) {
                case 1 -> registrarEstudiante();
                case 2 -> añadirNota();
                case 3 -> mostrarNotas();
                case 4 -> mostrarEstudiantes();
                case 5 -> System.out.println("Saliendo del sistema.");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 5);
    }

    private void mostrarMenu() {
        System.out.println("""
            \n--- MENÚ PRINCIPAL ---
            1. Registrar nuevo estudiante
            2. Añadir nota a un estudiante
            3. Mostrar notas de un estudiante
            4. Mostrar todos los estudiantes
            5. Salir
        """);
    }

    private void registrarEstudiante() {
        System.out.print("Ingrese el nombre del nuevo estudiante: ");
        String nombre = scanner.nextLine().trim();

        if (!esNombreValido(nombre)) {
            System.out.println("Nombre inválido. Solo se permiten letras y espacios.");
            return;
        }

        try {
            List<String> estudiantes = Files.readAllLines(ESTUDIANTES_FILE);
            if (estudiantes.contains(nombre)) {
                System.out.println("El estudiante ya está registrado.");
                return;
            }

            Files.write(ESTUDIANTES_FILE, List.of(nombre), StandardOpenOption.APPEND);
            Path archivoNotas = DIR.resolve("notas_" + nombre + ".txt");
            Files.createFile(archivoNotas);
            System.out.println("Estudiante registrado correctamente.");

        } catch (IOException e) {
            System.out.println("Error al registrar estudiante: " + e.getMessage());
        }
    }

    private void añadirNota() {
        List<String> estudiantes = cargarEstudiantes();
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }

        mostrarEstudiantes();
        System.out.print("Ingrese el nombre del estudiante: ");
        String nombre = scanner.nextLine().trim();

        if (!estudiantes.contains(nombre)) {
            System.out.println("Estudiante no encontrado.");
            return;
        }

        Path archivoNotas = DIR.resolve("notas_" + nombre + ".txt");
        if (!Files.exists(archivoNotas)) {
            System.out.println("El archivo de notas no existe.");
            return;
        }

        double nota;
        while (true) {
            nota = leerDecimal("Ingrese la nota (0 a 10): ");
            if (nota >= 0 && nota <= 10) break;
            System.out.println("La nota debe estar entre 0 y 10.");
        }

        try (BufferedWriter writer = Files.newBufferedWriter(archivoNotas, StandardOpenOption.APPEND)) {
            writer.write(String.valueOf(nota));
            writer.newLine();
            System.out.println("Nota añadida con éxito.");
        } catch (IOException e) {
            System.out.println("Error al escribir la nota: " + e.getMessage());
        }
    }

    private void mostrarNotas() {
        List<String> estudiantes = cargarEstudiantes();
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }

        mostrarEstudiantes();
        System.out.print("Ingrese el nombre del estudiante: ");
        String nombre = scanner.nextLine().trim();

        if (!estudiantes.contains(nombre)) {
            System.out.println("Estudiante no encontrado.");
            return;
        }

        Path archivoNotas = DIR.resolve("notas_" + nombre + ".txt");
        if (!Files.exists(archivoNotas)) {
            System.out.println("El archivo de notas no existe.");
            return;
        }

        try {
            List<String> notas = Files.readAllLines(archivoNotas);
            if (notas.isEmpty()) {
                System.out.println("No hay notas registradas.");
            } else {
                System.out.println("Notas de " + nombre + ":");
                notas.forEach(System.out::println);
            }
        } catch (IOException e) {
            System.out.println("Error al leer notas: " + e.getMessage());
        }
    }

    private void mostrarEstudiantes() {
        List<String> estudiantes = cargarEstudiantes();
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
        } else {
            System.out.println("Estudiantes registrados:");
            estudiantes.forEach(System.out::println);
        }
    }

    private List<String> cargarEstudiantes() {
        try {
            return Files.readAllLines(ESTUDIANTES_FILE).stream()
                    .map(String::trim)
                    .filter(n -> !n.isEmpty())
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println("Error al leer estudiantes: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    private int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número válido.");
            }
        }
    }

    private double leerDecimal(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número válido.");
            }
        }
    }

    private boolean esNombreValido(String nombre) {
        return nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]{2,}");
    }

}
