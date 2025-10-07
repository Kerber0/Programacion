/*Realiza un programa en Java que gestione la compra de los productos de un supermercado.

El programa solicitará el nombre del producto y su precio en bucle.

Después de de introducir estos datos, preguntará si deseamos continuar introduciendo más productos. Las posibles
respuestas serán SI para seguir en el bucle y NO para salir.

Al terminar, mostrará el importe total de la compra y cuántos productos hemos comprado.*/









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