/*
Desarrolla un programa en Java que permita gestionar los libros de un sistema bibliotecario.


Supongamos que necesitas desarrollar un sistema de biblioteca que incluye libros y revistas. Cada libro o revista tiene un título y un número de identificación único. Además, se quiere llevar un registro de los préstamos y devoluciones de estos materiales.

Para ello utilizaremos herencia y polimorfismo:

Crearemos una clase Material que contendrá los atributos y métodos comunes.

De la clase Material extenderán las clases Libro y Revista.

Los Libros además del título y el número de identificación queremos almacenar el nombre del autor.

Para las Revistas queremos almacenar a mayores el número de la revista.

Se creará una clase Biblioteca que permita:

almacenar el catálogo de libros que tiene la biblioteca disponibles y los libros que están siendo prestados.
        prestar libros
ver los libros prestados
devolver los libros prestados
Se creará una clase SistemaBiblioteca que contendrá el método main en el que:

Creará un par de libros y revistas
Los añadirá a la biblioteca
Simulará el préstamo de algún libro/revista
Simulará la devolución de esos libros/revistas
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