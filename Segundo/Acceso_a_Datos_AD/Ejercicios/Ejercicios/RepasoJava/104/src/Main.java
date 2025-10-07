/* Crea una clase Ejercicio_Piscina que sirva para calcular el aforo de una piscina comunitaria.

Con las medidas de seguridad derivadas de la situación sanitaria por motivos del COVID-19, las comunidades de
 vecinos han de regular la afluencia a sus piscinas comunitarias. Para ello han de calcular:

la superficie de la piscina (del vaso que contiene el agua)

la superficie de la parcela aledaña a la piscina

Se reservarán 2 metros cuadrados por persona para asegurar la distancia interpersonal. Para calcular el aforo de
la piscina comunitaria habrá que dividir cada una de las superficies calculadas anteriormente entre 2 y se
escogerá el menor de los dos resultados.

El código deberá pedir por teclado:

La longitud de la piscina

La anchura de la piscina

La longitud de la parcela

La anchura de la parcela

Además, se deberá gestionar que los datos introducidos no son erróneos para que no se produzca una excepción

ejemplo de funcionamiento
Introduzca longitud de la piscina:

7

Introduzca anchura de la piscina:

lau

Ha ocurrido una excepción. Solo se permiten enteros

Introduzca anchura de la piscina:

5

Introduzca longitud de la parcela:

15

Introduzca anchura de la parcela:

10

El aforo de la piscina es: 17 personas */







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