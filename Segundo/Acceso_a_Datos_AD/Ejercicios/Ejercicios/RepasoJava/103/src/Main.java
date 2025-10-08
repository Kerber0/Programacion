/*Realiza un programa en Java que gestione la compra de los productos de un supermercado.

El programa solicitará el nombre del producto y su precio en bucle.

Después de de introducir estos datos, preguntará si deseamos continuar introduciendo más productos. Las posibles
respuestas serán SI para seguir en el bucle y NO para salir.

Al terminar, mostrará el importe total de la compra y cuántos productos hemos comprado.*/


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static List<Articulo> articulos = new ArrayList<>();

       public static void main(String[] args) {
           String opcion = "Si";
        System.out.println("Bienvenido al gestor de productos!");

        do {
            agregar();
            opcion = input("Desea seguir agregando articulos? Si/No").toLowerCase();
        } while (opcion.equals("si"));

        mostrarTodo();

        }

    public static void agregar() {
        String nombre = input("Ingrese el nombre del nuevo producto: ");
        double precio = inputDouble("Ingrese el importe del producto: ");

        Articulo nuevo = new Articulo(nombre,precio);
        articulos.add(nuevo);

    }

    public static void mostrarTodo() {
        System.out.println("Resumen de articulos: ");

           for(Articulo art : articulos) {
               System.out.println(art);
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

    private static Double inputDouble(String text) {
            double num = -1;
            boolean valido = false;

            while (!valido) {
                try {
                    System.out.println(text);
                    num = Double.parseDouble(sc.nextLine());
                    valido = true;
                } catch (NumberFormatException e) {
                    System.out.println("Error: Por favor ingrese un número decimal válido.");
                }
            }
            return num;
        }


}

