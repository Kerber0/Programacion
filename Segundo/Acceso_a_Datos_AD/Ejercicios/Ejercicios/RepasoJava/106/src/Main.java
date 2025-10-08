/*
 Desarrolla un programa en Java permita crear una lista de contactos
que puedes agregar, eliminar y mostrar. Cada contacto estará representado por
 una clase Contacto.

El programa implementará un menú que permita:

Agregar contacto
Mostrar contacto
Eliminar contacto
*/


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static final Scanner sc = new Scanner(System.in);

    public static List<Contacto> contactos = new ArrayList<>();

    private static final String menu = """
            | 1 | Agregar contacto.
            | 2 | Mostrar contacto.
            | 3 | Eliminar contacto.
            | 0 | Salir.
            """;

    public static void main(String[] args) {
        inicio();


    }

    private static void inicio() {
        int opcion = -1;
        System.out.println("Bienvenido al gestor de tus contactos!");
        System.out.println("Seleccione la opcion deseada: ");


        do {
            opcion = inputInt(menu);
            switch (opcion) {
                case 1 -> agregar();
                case 2 -> mostrarTodos();
                case 3 -> eliminar();
                case 0 -> System.out.println("Adiós!");
                default -> System.out.println("Opcion ingresada invalida, pruebe otra vez");
            }
        } while (opcion != 0);

        System.out.println("Adios");
        sc.close();
    }

    private static void agregar() {
        String nombre = input("Ingrese el nombre del contacto: ");
        String telefono = inputTelefono("Ingrese el numero telefonico del contacto: ");

        Contacto nuevo = new Contacto(nombre, telefono);

        contactos.add(nuevo);
        System.out.println("Contacto agregado correctamente.");

    }

    private static void mostrarTodos(){
        if (contactos.isEmpty()) {
            System.out.println("La lista de contactos esta vacia.");
        } else {
            contactos.sort(Comparator.comparingInt(Contacto::getId));
            System.out.println("Lista de contactos: ");
            for (Contacto cont : contactos) {
                System.out.println(cont);
            }
        }
    }

    private static void eliminar() {
        if (contactos.isEmpty()) {
            System.out.println("No hay contactos para eliminar.");
            return;
        }

        do {
            mostrarTodos();
            int seleccion = inputInt("Ingrese el ID del contacto a eliminar: ");

            Contacto contactoAEliminar = buscarPorId(seleccion);

            if (contactoAEliminar != null) {
                String confirmacion = input("¿Seguro que desea eliminar este contacto? (S/N): ");
                if (confirmacion.equalsIgnoreCase("S")) {
                    contactos.remove(contactoAEliminar);
                    System.out.println("Contacto eliminado correctamente.");
                    break;
                } else {
                    System.out.println("Operación cancelada.");
                    break;
                }
            } else {
                System.out.println("No se encontró ningún contacto con ese ID.");
            }

        } while (true);
    }

    private static Contacto buscarPorId(int id) {
        for (Contacto c : contactos) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null; // Si no lo encuentra
    }

    public static String inputTelefono(String text) {
        boolean valido = false;
        String telefono = "";

        while (!valido) {
            System.out.println(text);
            telefono = sc.nextLine().trim();

            if (telefono.isEmpty()) {
                System.out.println("Error: Debe ingresar un número de teléfono.");
                continue;
            }

            // Quitar espacios y guiones si los hay
            telefono = telefono.replaceAll("[\\s-]", "");

            // Validar que solo tenga dígitos (opcionalmente puede empezar por +)
            if (!telefono.matches("^\\+?\\d{9,15}$")) {
                System.out.println("Error: El número debe tener entre 9 y 15 dígitos (puede comenzar con +).");
                continue;
            }

            // Validación específica: si es número español, debe empezar por 6, 7, 8 o 9
            if (telefono.matches("^\\d{9}$") && !telefono.matches("^[6789].*")) {
                System.out.println("Error: En España, el número debe comenzar por 6, 7, 8 o 9.");
                continue;
            }

            valido = true;
        }

        return telefono;
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