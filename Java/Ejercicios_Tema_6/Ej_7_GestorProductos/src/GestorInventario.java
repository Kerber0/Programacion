import java.io.*;
import java.util.*;

public class GestorInventario {
    private static final String RUTA = "Ej_7_productos.csv";
    private final List<Producto> PRODUCTOS = new ArrayList<>();

    public void inicio() {
        cargarProductos();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1 -> mostrarProductos();
                case 2 -> agregarProducto(sc);
                case 3 -> modificarStock(sc);
                case 4 -> eliminarProducto(sc);
                case 0 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    private void mostrarMenu() {
        System.out.println("\n--- GESTOR DE INVENTARIO ---");
        System.out.println("1. Mostrar productos");
        System.out.println("2. Añadir producto");
        System.out.println("3. Modificar stock");
        System.out.println("4. Eliminar producto");
        System.out.println("0. Salir");
        System.out.print("Elige una opción: ");
    }

    private void cargarProductos() {
        File archivo = new File(RUTA);
        if (!archivo.exists()) {
           return;
        }

        PRODUCTOS.clear();

        try (BufferedReader br = new BufferedReader(new FileReader(RUTA))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                if (partes.length == 4) {
                    int id = Integer.parseInt(partes[0]);
                    String nombre = partes[1];
                    double precio = Double.parseDouble(partes[2]);
                    int stock = Integer.parseInt(partes[3]);
                    PRODUCTOS.add(new Producto(id, nombre, precio, stock));
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
        }
    }

    private void mostrarProductos() {
        System.out.println("\n--- INVENTARIO ---");
        for (Producto p : PRODUCTOS) {
            System.out.println(p);
        }
    }

    private void mostrarProductosID() {
        System.out.println("\n--- INVENTARIO ---");
        for (Producto p : PRODUCTOS) {
            System.out.println("Id: " + p.getId() + " | " + "Nombre: " + p.getNombre());
        }
    }

    private void agregarProducto(Scanner sc) {
        try {
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Precio: ");
            double precio = Double.parseDouble(sc.nextLine());
            System.out.print("Stock: ");
            int stock = Integer.parseInt(sc.nextLine());

            int nuevoId = PRODUCTOS.isEmpty() ? 1 : PRODUCTOS.getLast().getId() + 1;
            Producto nuevo = new Producto(nuevoId, nombre, precio, stock);
            PRODUCTOS.add(nuevo);
            guardarProductos();
            System.out.println("Producto añadido correctamente.");
        } catch (NumberFormatException e) {
            System.out.println("Error en el formato del precio.");
        }
    }

    private void modificarStock(Scanner sc) {
        mostrarProductosID();
        try {
            System.out.print("ID del producto: ");
            int id = Integer.parseInt(sc.nextLine());
            Producto producto = buscarPorId(id);

            if (producto != null) {
                System.out.print("Nuevo stock: ");
                int nuevoStock = Integer.parseInt(sc.nextLine());
                producto.setStock(nuevoStock);
                guardarProductos();
                System.out.println("Stock actualizado.");
            } else {
                System.out.println("Producto no encontrado.");
            }
        } catch (NumberFormatException e) {
            System.out.println("ID o stock inválido.");
        }
    }

    private void eliminarProducto(Scanner sc) {
        mostrarProductosID();

        // boolean eliminado = producto.removeIF(producto -> producto.getId() == id); Stream
        try {
            System.out.print("ID del producto a eliminar: ");
            int id = Integer.parseInt(sc.nextLine());
            Producto producto = buscarPorId(id);

            if (producto != null) {
                PRODUCTOS.remove(producto);
                guardarProductos();
                System.out.println("Producto eliminado.");
            } else {
                System.out.println("Producto no encontrado.");
            }
        } catch (NumberFormatException e) {
            System.out.println("ID inválido.");
        }
    }

    private Producto buscarPorId(int id) {
        for (Producto p : PRODUCTOS) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    private void guardarProductos() {
        try {
            File archivo = new File(RUTA);
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
                for (Producto p : PRODUCTOS) {
                    bw.write(p.toCSV());
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            System.err.println("Error al guardar los productos: " + e.getMessage());
        }
    }


}
