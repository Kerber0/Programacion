import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Gestor {

    static Scanner sc = new Scanner(System.in);
    private List<Cliente> clientes;
    static String log = "log.txt";
    private final String ficheroClientes = "clientes.ser";
    private final String ficheroPeliculas = "peliculas.txt";


    public Gestor() {
        clientes = iniciar();
    }

    public void mostrarPeliculas() {
        System.out.println("\n Lista de peliculas.\n");
        try {
            FileReader reader = new FileReader(ficheroPeliculas);
            int character;
            while ((character = reader.read()) != -1) {
                System.out.print((char) character);
            }
            System.out.println("\n");

        } catch (IOException e) {
            System.out.println("Error al leer el archivo " + e.getMessage());
        }
    }

    public List<Cliente> iniciar() {
        List<Cliente> lista = new ArrayList<>();
        File ficheroCli = new File(ficheroClientes);
        File ficheroPeli = new File(ficheroPeliculas);
        File ficheroLog = new File(log);
        try {
            if (!ficheroPeli.exists()) {
                FileWriter writer = new FileWriter(ficheroPeli, true);
                String peliculas = """
                    Regreso al Futuro
                    Los Cazafantasmas
                    Capitán Fantástico
                    Blade Runner
                    Alien, el octavo pasajero
                    Terminator
                    La Historia Interminable
                    Indiana Jones y el Templo Maldito
                    El Club de los Cinco
                    El Club de la Lucha
                    """;
                writer.write(peliculas);
                writer.close();
            }
            if (!ficheroLog.exists()) {
                ficheroLog = new File("log.txt");
            }

            if (ficheroCli.exists()) {
                try (ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream(ficheroCli))) {
                    lista = (List<Cliente>) ois.readObject();
                } catch (IOException | ClassNotFoundException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return lista;
    }

    public int nuevoID() {
        return clientes.isEmpty() ? 1 : clientes.getLast().getId() + 1;
    }

    public void eliminarCliente() {
        mostrarClientes();
        String id;
        boolean eliminado = false;
        do {
            id = input("Ingrese el Id del clente a eliminar o 'S' para volver: ");
            if (id.equalsIgnoreCase("S")) {
                return;
            } else {
                int finalId = Integer.parseInt(id);

                boolean borrado = clientes.removeIf(c -> c.getId() == finalId);
                if (borrado) {
                    guardarCliente();
                    System.out.println("Cliente eliminado correctamente.");
                } else {
                    System.out.println("Cliente no encontrado.");
                }
            }
        } while (!eliminado);

    }  // no estoy seguro por que al terminar este metodo se sale del programa

    public void guardarCliente() {
        try (ObjectOutputStream oos = new ObjectOutputStream(
            new FileOutputStream(ficheroClientes))) {
            oos.writeObject(clientes);
        } catch (IOException e) {
            System.out.println("Error al guardar cliente: " + e.getMessage());
        }


    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
        guardarCliente();
        System.out.println("Cliente registrado correctamente.");

    }

    public void mostrarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Todavía no hay clientes registrados.");
        } else {
            for (Cliente c : clientes) {
                System.out.println(c);
            }
        }
    }

    public Integer inputInt(String text) {
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

    public static String input(String text) {
        boolean textcorrect = false;
        String resultado;
        do {
            System.out.println(text);
            resultado = sc.nextLine();
            if (resultado.isEmpty()) {
                System.out.println("Se debe ingresar algo.");
            } else {
                textcorrect = true;
            }
        } while (!textcorrect);
        return resultado;
    }

    public void registraroperacion(boolean alquiler) {

        mostrarPeliculas();

        int cliente = inputInt("Ingrese el id del cliente: ");
        String pelicula = input("Ingrese el nombre de la pelicula: ");
        LocalDateTime fecha = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("[yyyy-MM-dd HH:mm:ss]");
        String fechaFormateada = fecha.format(formatter);
        try {
            FileWriter writer = new FileWriter(log, true);

            if (alquiler) {
                writer.write(fechaFormateada + " Cliente: " + cliente + " alquiló "+  '"' + pelicula + '"' + "\n");
                writer.close();
            } else {
                writer.write(fechaFormateada + " Cliente: " + cliente + " devolvió " + '"' + pelicula + '"' + "\n");
                writer.close();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());

        }
        System.out.println("Operacion registrada con exito.");
    }

    public void buscarCliente() {
            int id = inputInt("Ingrese el número de id del cliente a buscar: ");
            for (Cliente c : clientes) {
                if (c.getId() == id) {
                    System.out.println("Cliente encontrado: " + c);

                } else {
                    System.out.println("Cliente no encontrado.");
                }
            }

        }

}

