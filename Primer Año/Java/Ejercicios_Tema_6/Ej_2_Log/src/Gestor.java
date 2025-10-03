import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class Gestor {
    static Scanner sc = new Scanner(System.in);
    static File file;
    static String usuario;

    public void inicio(){
        file = new File("RegistroLog.txt");
        try {
            if (file.createNewFile()) {
                System.out.println("Fichero creado en: " + file.getAbsolutePath());
            } else {
                System.out.println("El fichero " + file.getName() + " ya existe en " + file.getAbsolutePath());
            }
        }catch (IOException e) {
            System.out.println("Error al crear el fichero: " + e.getMessage());
        }

        int option;


        do{
            option = inputInt("""
                Seleccione la opción deseada:
                1 - Login.
                2 - Logout
                3 - Mostrar historial de log.
                0 - Salir.
                """);
            switch (option){
                case 1:
                    login();
                    break;
                case 2:
                    logout();
                    break;
                case 3:
                    mostrar();
                    break;
                case 0:
                    System.out.println("Cerrando programa.");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }

        }while (option != 0);
    }

    private void login(){

        LocalDateTime fecha = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("[yyyy-MM-dd HH:mm:ss]");
        String fechaFormateada = fecha.format(formatter);
         usuario = input("Ingrese nombre de usuario.");
       try {
           FileWriter writer = new FileWriter(file, true);
           writer.write(fechaFormateada + "- LOGIN -" + "Usuario: " + usuario + "\n");
           writer.close();
       }catch (IOException e) {
           System.out.println("Error: " + e.getMessage());
       }
    }

    private void logout(){
        LocalDateTime fecha = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("[yyyy-MM-dd HH:mm:ss]");
        String fechaFormateada = fecha.format(formatter);
        String usuario = input("Ingrese nombre de usuario.");
        try {
            FileWriter writer = new FileWriter(file, true);
            writer.write(fechaFormateada + "LOGOUT" + "Usuario: " + usuario + "\n");
            writer.close();
        }catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
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
            System.out.println(usuario);
        }catch (IOException e) {
            System.out.println("Error al leer el archivo " + e.getMessage());
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














