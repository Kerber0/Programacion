import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final GestorNotas gestor = new GestorNotas();

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Selecciona una opción: ");

            switch (opcion) {
                case 1 -> registrarEstudiante();
                case 2 -> agregarNota();
                case 3 -> mostrarNotas();
                case 4 -> mostrarEstudiantes();
                case 5 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción no válida.");
            }

        } while (opcion != 5);
    }

    private static void mostrarMenu() {
        System.out.println("\n--- MENÚ PRINCIPAL ---");
        System.out.println("1. Registrar nuevo estudiante");
        System.out.println("2. Añadir nota a un estudiante");
        System.out.println("3. Mostrar notas de un estudiante");
        System.out.println("4. Mostrar todos los estudiantes");
        System.out.println("5. Salir");
    }

    private static void registrarEstudiante() {
        System.out.print("Ingrese el nombre del estudiante: ");
        String nombre = scanner.nextLine().trim();

        if (gestor.registrarEstudiante(nombre)) {
            System.out.println("Estudiante registrado correctamente.");
        } else {
            System.out.println("El estudiante ya existe.");
        }
    }

    private static void agregarNota() {
        List<String> estudiantes = gestor.obtenerEstudiantes();
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }

        mostrarEstudiantes();
        System.out.print("Ingrese el nombre del estudiante: ");
        String nombre = scanner.nextLine().trim();

        if (!gestor.estudianteExiste(nombre)) {
            System.out.println("El estudiante no existe.");
            return;
        }

        double nota = leerDouble("Ingrese la nota (0 a 10): ");
        if (nota < 0 || nota > 10) {
            System.out.println("Nota fuera de rango.");
            return;
        }

        if (gestor.agregarNota(nombre, nota)) {
            System.out.println("Nota añadida.");
        }
    }

    private static void mostrarNotas() {
        List<String> estudiantes = gestor.obtenerEstudiantes();
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }

        mostrarEstudiantes();
        System.out.print("Ingrese el nombre del estudiante: ");
        String nombre = scanner.nextLine().trim();

        if (!gestor.estudianteExiste(nombre)) {
            System.out.println("El estudiante no existe.");
            return;
        }

        List<Double> notas = gestor.obtenerNotas(nombre);
        if (notas.isEmpty()) {
            System.out.println("No hay notas registradas.");
        } else {
            System.out.println("Notas de " + nombre + ":");
            for (Double nota : notas) {
                System.out.println("- " + nota);
            }
        }
    }

    private static void mostrarEstudiantes() {
        List<String> estudiantes = gestor.obtenerEstudiantes();
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
        } else {
            System.out.println("Estudiantes registrados:");
            for (String estudiante : estudiantes) {
                System.out.println("- " + estudiante);
            }
        }
    }

    private static int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Intente de nuevo.");
            }
        }
    }

    private static double leerDouble(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Intente de nuevo.");
            }
        }
    }
}
