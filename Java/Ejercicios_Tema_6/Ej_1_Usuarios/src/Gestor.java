
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Gestor {
    static Scanner sc = new Scanner(System.in);
    static File file;
    public void inicio () {
      file = new File("usuarios.txt");
        try {
            if (file.createNewFile()) {
                System.out.println("Fichero creado en : " + file.getAbsolutePath());
            } else {
                System.out.println("El fichero" + file.getName() + " ya existe.");
            }
        } catch (IOException e) {
            System.out.println("Error al crear el fichero: " + e.getMessage());
        }

        int opcion;

        do {
        System.out.println(file.getAbsolutePath());;
        menu();
        opcion = inputInt("Seleccione la opción deseada: ");

        
        if (opcion == 1) {
            agregar();
        } else if (opcion == 2) {
            mostrar();
        } else if (opcion == 3) {
            buscar();

        } else if (opcion == 4) {
            System.out.println("Adios.");

        } else {
            System.out.println("Opción inválida. Pruebe otra vez");
        }
        } while (opcion != 4);

    }

    private void menu(){
        System.out.println("""
            1 - Añadir nuevo usuario
            2 - Mostrar todos los usuarios
            3 - Buscar usuario por nombre
            4 - Salir
            """);
    }

    private void agregar(){
        try {
            FileWriter writer = new FileWriter(file, true); // <- agregás true para no sobreescribir
            String nombre = input("Ingrese el nombre del nuevo usuario: ");
            int edad = inputInt("Ingrese la edad del nuevo usuario: ");
            String ciudad = input("Ingrese la ciudad del nuevo usuario: ");

            writer.write(nombre + "," + edad + "," + ciudad + "\n");
            writer.close(); // <- no te olvides de cerrar el writer

            System.out.println("Usuario agregado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al escribir el fichero: " + e.getMessage());
        }
    }

    private void mostrar(){
        try {
            FileReader reader = new FileReader(file);
            int character;
            while ((character = reader.read()) != -1){
                System.out.print((char) character);
            }
            System.out.println("\n Datos leídos del fichero.");
        }catch (IOException e) {
            System.out.println("Error al leer el archivo " + e.getMessage());
        }
    }
    private void buscar() {
        String nombreBuscado = input("Ingrese el nombre que desea buscar: ");

        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            boolean encontrado = false;

            while ((linea = br.readLine()) != null) {
                if (linea.toLowerCase().contains(nombreBuscado.toLowerCase())) {
                    System.out.println("Coincidencia: " + linea);
                    encontrado = true;
                }
            }

            br.close();

            if (!encontrado) {
                System.out.println("No se encontró ningún usuario con ese nombre.");
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public static String input(String text) {
        boolean textcorrect = false;
        String resultado;
        do {
            System.out.println(text);
            resultado = sc.nextLine();
            if (resultado.isEmpty()){
                System.out.println("Se debe ingresar algo.");
            } else {
                textcorrect = true;
            }
        }while (!textcorrect);
        return resultado;
    }

    private static Integer inputInt (String text){
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
    
}
