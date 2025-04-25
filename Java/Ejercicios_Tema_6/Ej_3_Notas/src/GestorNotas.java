import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestorNotas {
    private static final String ARCHIVO_ESTUDIANTES = "estudiantes.txt";

    public GestorNotas() {
        crearArchivoSiNoExiste(ARCHIVO_ESTUDIANTES);
    }

    private void crearArchivoSiNoExiste(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        try {
            if (!archivo.exists()) {
                archivo.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("Error al crear el archivo: " + nombreArchivo);
        }
    }

    public boolean registrarEstudiante(String nombre) {
        if (estudianteExiste(nombre)) {
            return false;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO_ESTUDIANTES, true))) {
            writer.write(nombre);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo de estudiantes.");
        }

        crearArchivoSiNoExiste("notas_" + nombre + ".txt");
        return true;
    }

    public boolean estudianteExiste(String nombre) {
        List<String> estudiantes = obtenerEstudiantes();
        return estudiantes.contains(nombre);
    }

    public List<String> obtenerEstudiantes() {
        List<String> lista = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO_ESTUDIANTES))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                lista.add(linea.trim());
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de estudiantes.");
        }
        return lista;
    }

    public boolean agregarNota(String nombre, double nota) {
        if (!estudianteExiste(nombre)) {
            return false;
        }

        String archivoNotas = "notas_" + nombre + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoNotas, true))) {
            writer.write(String.valueOf(nota));
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error al escribir nota.");
        }

        return true;
    }

    public List<Double> obtenerNotas(String nombre) {
        List<Double> notas = new ArrayList<>();
        String archivoNotas = "notas_" + nombre + ".txt";
        File archivo = new File(archivoNotas);
        if (!archivo.exists()) {
            return notas;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(archivoNotas))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                try {
                    notas.add(Double.parseDouble(linea.trim()));
                } catch (NumberFormatException e) {
                    System.out.println("Nota inválida encontrada: " + linea);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de notas.");
        }

        return notas;
    }
}
