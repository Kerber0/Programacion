package dataBase;/*
A partir de la base de datos Librería la cual tiene el siguiente diagrama:

Se pide crear un programa Java que tenga un paquete llamado dataBase que tenga dos clases:

Clase Operaciones.java: que se encargará de la conexión a la base de datos y contendrá las siguientes funciones:

existsClient: recibirá un id de cliente (idClient) y devolverá true o false indicando si el cliente existe en la BD
 o no.
existsBook: recibe un id de libro (idBook) y devuelve true o false indicando si el libro existe en la BD o no.
isBorrowed: recibe el código (code) de un libro y devuelve true o false si el libro está prestado o no.
addLoan: recibe el código (code) de un libro y el id de cliente (idClient) y usa los métodos anteriores para
 hacer las comprobaciones necesarias y añadir un préstamos a la BD.
addReturn: recibe el código de un libro y modifica el campo prestado (borrowed) en la tabla de préstamos (loan).
borrowedBooksList: devuelve un ArrayList de libros con la lista de libros prestados hasta el momento.
availableBooksList: devuelve un ArrayList de libros con la lista de libros que están disponibles para ser prestados.
Clase dataBase.Main.java: permitirá lanzar la aplicación, mostrará un menú que permita:

Prestar un libro.
Devolver un libro.
Listar los libros prestados.
Listar los libros que se pueden prestar.
NOTA: tendrán que notificarse todos los posibles errores.
 */


import java.util.Scanner;

public class Main {
    final static Scanner sc = new Scanner(System.in);
    static Operaciones op = new Operaciones();

    public static void main(String[] args) {
        System.out.println("Bienvenido!!");
        op.openConnection();
        menu();
    }


    private static void menu(){
        int opcion = -1;
        do {
            opcion = inputInt("""
                    Seleccione:
                    1 Prestar un libro.
                    2 Devolver un libro.
                    3 Listar los libros prestados.
                    4 Listar los libros que se pueden prestar.
                    0 Salir.
                    """);
            switch (opcion) {
                case 1 -> op.addLoan(inputInt("IdBook: "));
                case 2 -> op.addReturn(inputInt("IdBook: "));
                case 3 -> op.borrowedBooksList();
                case 4 -> op.availableBooksList();
                case 0 -> System.out.println("Adios!");
            }

        }while (opcion != 0);
        op.closeConnection();
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

}