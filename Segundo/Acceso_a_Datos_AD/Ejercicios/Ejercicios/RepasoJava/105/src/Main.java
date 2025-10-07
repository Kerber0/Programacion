/* Como continuación del ejercicio anterior, para gestionar el aforo, la comunidad ha establecido 6 franjas horarias

Franja1 → 08:00h -10:00h

Franja2 → 10:00h- 12:00h

Franja3 → 12:00h -14:00h

Franja4 → 14:00h- 16:00h

Franja5 → 16:00h -18:00h

Franja6 → 18:00h- 20:00h

La comunidad ha decidido establecer una política de reservas, donde para cada franja horaria se establecerá
 un máximo de personas igual al aforo calculado previamente. Modifica el fichero Ejercicio_Piscina.java para que,
 tras calcular el aforo, se permita reservar plaza en una franja horaria. Para ello:

crea un array bidimensional reservasPorFranja que guarde para cada franja horaria, el dni del solicitante.
Ejemplo de array bidimensional para un aforo de 17 personas

Crea un método reservar que solicite de forma continua por teclado:

El número de la franja en la que se desea reservar. Debe ser un entero del 1 al 6. Si no es así, se debe mostrar
un mensaje al usuario informándole de que se debe introducir un entero del 1 al 6 e insistir solicitando la franja
de la reserva.

Si hay plazas disponibles en la franja horaria solicitada, se debe solicitar por teclado el dni del solicitante.
El dni deberá tener una longitud de 9 caracteres: los 8 primeros han de ser dígitos (del 0 al 9) y el último ha de
ser una letra. Si el dni no es válido, se debe mostrar un mensaje al usuario informándole de la entrada esperada e
 insistir preguntando por el dni.

Si el dni es válido, se añade el dni de la persona solicitante en la primera posición vacía del array reservasPorFranja
para la franja solicitada y se informa del éxito de la operación.
Si no se encontrara ninguna posición vacía en la la franja solicitada, se ha de informar al usuario de que
 no hay plazas libres en la franja solicitada y ya no se solicitará el dni.

Modifica el método reservar para que no se permita que un mismo dni realice más de una reserva en todas
               las franjas horarias.

ejemplo de funcionamiento

Introduzca longitud de la piscina:

2

Introduzca anchura de la piscina:

1

Introduzca longitud de la parcela:

1

Introduzca anchura de la parcela:

2

El aforo de la piscina es: 1 personas

Introduzca número de franja donde quiere reservar [1-6]:

0

Solo se permiten enteros entre [1,6]

Introduzca número de franja donde quiere reservar [1-6]:

1

Introduzca dni:

12345678k

Su reserva se ha realizado con éxito

Introduzca número de franja donde quiere reservar [1-6]:

1

No hay plazas en la franja: 1

Introduzca número de franja donde quiere reservar [1-6]:

2

Introduzca dni:

12345678k

No se puede reservar 2 veces en el mismo día

Introduzca número de franja donde quiere reservar [1-6]:*/








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