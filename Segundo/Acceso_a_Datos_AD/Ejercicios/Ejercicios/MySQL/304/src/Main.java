/*
Implementa un programa en Java donde mediante una clase llamada TransaccionEmpleado se permita insertar en la base de datos Empleados tres nuevos contables: Pedro, Lucía y Daniel que pertenecerán al departamento 1.

¿Qué pasa si hay un error al insertar alguno de los empleados?

Utiliza transacciones para controlar que se inserten los 3 empleados a la vez y si ocurre un error, no se insertará ninguno.
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