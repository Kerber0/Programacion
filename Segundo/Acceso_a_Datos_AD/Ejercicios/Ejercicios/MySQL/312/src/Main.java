/*
Aplicación de libros
Dado la base de datos de libros, la cual tiene el siguiente diagrama ER:



Se pide, desarrollar una aplicación Java que permita realizar consultas y recuperar los datos utilizando los siguientes procedimientos almacenados:

pa_libros_limite_stock(): devuelve la lista de libros en stock
get_libro_by_id(IN id int): devuelve la información de un libro por le código
contar_libros_precio(IN precio decimal(5,2), OUT total int): permite obtener el número de libros que cuestan más que una determinada cantidad
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