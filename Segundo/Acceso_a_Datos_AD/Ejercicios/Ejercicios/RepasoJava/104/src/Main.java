

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


import java.util.Scanner;


public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        double largoPisc = inputDouble("Ingrese el largo de la piscina: ");
        double anchoPisc = inputDouble("Ingrese el ancho de la piscina: ");
        double largoParcela = inputDouble("Ingrese el largo de la parcela: ");
        double anchoParcela = inputDouble("Ingrese el ancho de la parcela: ");

        Piscina piscina = new Piscina(largoPisc, anchoPisc, largoParcela, anchoParcela);
        piscina.setAforo();

        System.out.println("El aforo de la piscina es: " + piscina.getAforo() + " personas");

    }


    private static Double inputDouble(String text) {
        double num = -1;
        boolean valido = false;

        while (!valido) {
            try {
                System.out.println(text);
                num = Double.parseDouble(sc.nextLine());
                valido = true;
            } catch (NumberFormatException e) {
                System.out.println("Error: Por favor ingrese un número decimal válido.");
            }
        }
        return num;
    }


}