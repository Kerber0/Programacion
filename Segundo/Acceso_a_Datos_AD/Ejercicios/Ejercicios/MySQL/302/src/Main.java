/*
Dada la siguiente base de datos de empleados se pide desarrollar un programa Java que se conecte a la base de datos utilizando el usuario root y la contraseña abc123. y permita:

Mostrar la información de la base de datos.
Mostrar la información de la tabla proyectos.
Insertar un nuevo proyecto con los siguientes datos (11, 'Acceso a datos', 'Lugo', 3) en la tabla proyecto.
Eliminar una fila de la tabla proyecto a partir de su número de proyecto numproy.
NOTA: Sería conveniente crear una función independiente para cada una de las funcionalidades de forma que se puedan reutilizar en un futuro. NOTA: Será importante gestionar los posibles errores que pueda generar el código.

Información adicional
Algunas de las clases qeu se deberían utilizar para implementar este ejercicio son:

Statement: para gestionar las consultas
PreparedStatement: para poder reutilizar consultas.
SQLException: para gestionar las excepciones
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