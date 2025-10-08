/* Realiza un programa en Java que pida por teclado el nombre y la edad de una persona mayor de edad
(se debe validar el valor introducido) y responda indicando:

Si no está jubilado (edad de jubilación = 65 años), cuántos años le quedan para jubilarse.
Si ya está jubilada indicará cuántos años lleva jubilado.*/


import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        iniciar();

    }

    private static void iniciar() {
        String nombre = input("Ingrese el nombre de la persona mayor de edad: ");
        int edad = inputInt("Ingrese la edad, debe ser mayor de 18: ");

        if(edad == 65 ) {
            System.out.println(nombre + "Se jubilara este anio");
        } else if (edad <= 65) {
            System.out.println("A " + nombre + "le faltan " + (65 - edad) + " para jubilarse");  // Integer.toString(edad - 65) pasa el int a strin eliminando el simbolo
        }   else {
            System.out.println(nombre + " se jubilo hace " + (edad - 65) + " anios");
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
                     if (num >= 18) {
                         valido = true;
                     } else {
                         System.out.println("La edad debe ser mayor de 18, pruebe otra vez.");
                     }

                 } catch (NumberFormatException e) {
                     System.out.println("Error: Por favor ingrese un número válido.");
                 }
             }
             return num;
         }



}

