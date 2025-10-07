
/*
Desarrolla un programa en Java que permita cifrar y descifrar un mensaje usando
 el cifrado César.

Cifrado Cesar
El cifrado César consiste en coger cada letra y desplazarla n posiciones hacia arriba.
 Es decir, si n=4 y tenemos el mensaje hola el resultado
 sería lspe: h → l o → s l → p a → e

El programa solicitará al usuario que introduzca dos números:

El primer número indicará el desplazamiento:
Se tendrá en cuenta el desplazamiento siguiendo la tabla ASCII que cuenta
 con un alfabeto de 26 letras
El segundo número indicará:
1: cifrar.
2: descifrar.
Se deberán tener en cuenta el uso de las mayúsculas y de las minúsculas
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