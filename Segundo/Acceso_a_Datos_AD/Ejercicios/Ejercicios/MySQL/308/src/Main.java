/*
En este ejercicio vamos a desarrollar una pequeña aplicación CRUD (Create, Read, Update, Delete). Es decir,
una aplicación que tenga una interfaz gráfica (podéis usar la siguiente plantilla como ejemplo) y nos permita crear,
 mostrar, actualizar y borrar información de una base de datos. Para ello, vamos a reutilizar el código del ejercicio
 anterior, en el que trabajábamos con una base de datos llamada school, para que los datos de los estudiantes se
 muestren en la siguiente interfaz:



Debes crear un paquete para la/s clase/s de la intefaz y otro para la lógica de la aplicación. Para la interfaz,
 puedes utilizar la clase StudentsView que se proporciona junto con el enunciado. Recuerda gestionar los errores, de
  forma que si hay algún problema al utilizar la base de datos, se le muestre un mensaje al usuario.
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