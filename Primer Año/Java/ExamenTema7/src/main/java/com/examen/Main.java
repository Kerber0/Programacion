package com.examen;


import com.examen.dao.VideojuegoDAO;
import com.examen.dao.VideojuegoDAOImpl;
import com.examen.model.Videojuego;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static VideojuegoDAO dao;

    public static void main(String[] args) {
        try {
            DatabaseFactory.initialize("gameshelf.db");
            dao = new VideojuegoDAOImpl();
        } catch (SQLException e) {
            System.err.println("Error inicializando BD: " + e.getMessage());
            return;
        }
        boolean salir = false;
        while (!salir) {
            mostrarMenu();
            String op = scanner.nextLine();
            switch (op) {
                case "1" -> listarTodos();
                case "2" -> crearVideojuego();
                case "3" -> buscarPorId();
                case "4" -> actualizarVideojuego();
                case "5" -> borrarVideojuego();
                case "6" -> mostrarPrecioMedioPorPlataforma();
                case "7" -> registrarVenta();
                case "8" -> salir = true;
                default -> System.out.println("Opción no válida.");
            }
        }
        System.out.println("¡Hasta luego!");
    }
    private static void mostrarMenu() {
        System.out.println("\n--- GameShelf ---");
        System.out.println("1. Listar todos");
        System.out.println("2. Crear videojuego");
        System.out.println("3. Buscar por ID");
        System.out.println("4. Actualizar");
        System.out.println("5. Borrar");
        System.out.println("6. Precio medio por plataforma");
        System.out.println("7. Registrar venta");
        System.out.println("8. Salir");
        System.out.print("Opción: ");
    }

    private static void listarTodos() {
        try {
            List<Videojuego> juegos = dao.listarTodos();
            juegos.forEach(System.out::println);
        } catch (SQLException e) {
            System.out.println("Error al listar videojuegos: " + e.getMessage());
        }
    }

    private static void crearVideojuego() {
        try {
            System.out.print("Título: ");
            String titulo = scanner.nextLine();

            System.out.print("Plataforma: ");
            String plataforma = scanner.nextLine();

            double precio = leerDouble("Precio: ");
            int stock = leerInt("Stock: ");

            Videojuego v = new Videojuego(0, titulo, plataforma, precio, stock);
            dao.crear(v);
            System.out.println("Videojuego creado con éxito.");
        } catch (SQLException e) {
            System.out.println("Error al crear videojuego: " + e.getMessage());
        }
    }

    private static void buscarPorId() {
        try {
            int id = leerInt("ID del videojuego: ");
            Videojuego v = dao.buscarPorId(id);
            if (v != null) {
                System.out.println(v);
            } else {
                System.out.println("No se encontró un videojuego con ese ID.");
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar videojuego: " + e.getMessage());
        }
    }

    private static void actualizarVideojuego() {
        try {
            int id = leerInt("ID del videojuego a actualizar: ");
            Videojuego v = dao.buscarPorId(id);
            if (v == null) {
                System.out.println("No se encontró un videojuego con ese ID.");
                return;
            }

            System.out.print("Nuevo título [" + v.getTitulo() + "]: ");
            String titulo = scanner.nextLine();
            if (!titulo.isBlank()) v.setTitulo(titulo);

            System.out.print("Nueva plataforma [" + v.getPlataforma() + "]: ");
            String plataforma = scanner.nextLine();
            if (!plataforma.isBlank()) v.setPlataforma(plataforma);

            String precioInput = leerOpcional("Nuevo precio [" + v.getPrecio() + "]: ");
            if (!precioInput.isBlank()) v.setPrecio(Double.parseDouble(precioInput));

            String stockInput = leerOpcional("Nuevo stock [" + v.getStock() + "]: ");
            if (!stockInput.isBlank()) v.setStock(Integer.parseInt(stockInput));

            dao.actualizar(v);
            System.out.println("Videojuego actualizado.");
        } catch (SQLException | NumberFormatException e) {
            System.out.println("Error al actualizar videojuego: " + e.getMessage());
        }
    }

    private static void borrarVideojuego() {
        try {
            int id = leerInt("ID del videojuego a borrar: ");
            dao.borrar(id);
            System.out.println("Videojuego borrado si existía.");
        } catch (SQLException e) {
            System.out.println("Error al borrar videojuego: " + e.getMessage());
        }
    }

    private static void mostrarPrecioMedioPorPlataforma() {
        try {
            Map<String, Double> medias = dao.precioMedioPorPlataforma();
            medias.forEach((plataforma, media) ->
                    System.out.printf("%s: %.2f €%n", plataforma, media));
        } catch (SQLException e) {
            System.out.println("Error al calcular medias: " + e.getMessage());
        }
    }

    private static void registrarVenta() {
        try {
            int id = leerInt("ID del videojuego vendido: ");
            dao.registrarVenta(id);
            System.out.println("Venta registrada y stock actualizado.");
        } catch (SQLException e) {
            System.out.println("Error al registrar venta: " + e.getMessage());
        }
    }

    // Métodos auxiliares para leer enteros y decimales con validación
    private static int leerInt(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Introduce un número entero válido.");
            }
        }
    }

    private static double leerDouble(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Introduce un número decimal válido.");
            }
        }
    }

    private static String leerOpcional(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }
}
