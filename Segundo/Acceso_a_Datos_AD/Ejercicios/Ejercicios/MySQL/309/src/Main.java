/*
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
Clase Main.java: permitirá lanzar la aplicación, mostrará un menú que permita:

Prestar un libro.
Devolver un libro.
Listar los libros prestados.
Listar los libros que se pueden prestar.
NOTA: tendrán que notificarse todos los posibles errores.
 */




//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }
    }
}