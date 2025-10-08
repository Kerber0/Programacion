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







import java.util.Scanner;


public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        menu();

    }


    private static void menu() {
        System.out.println("Bienvenido al gestor.");
        System.out.println("Primero vamos a cargar la piscina para calcular su aforo.");
        agregarPiscina();
        reservar();
    }

    private static void agregarPiscina() {
        double largoPisc = inputDouble("Ingrese el largo de la piscina: ");
        double anchoPisc = inputDouble("Ingrese el ancho de la piscina: ");
        double largoParcela = inputDouble("Ingrese el largo de la parcela: ");
        double anchoParcela = inputDouble("Ingrese el ancho de la parcela: ");

        Piscina piscina = new Piscina(largoPisc, anchoPisc, largoParcela, anchoParcela);
        piscina.setAforo();

        System.out.println("El aforo de la piscina es: " + piscina.getAforo() + " personas");
    }

    private static void reservar() {
        int opcion;
        System.out.println("Ahora seleccione la franja horaria deseada indicando el numero: ");

        do {
            opcion = inputInt("""
               Franja 1 → 08:00h -10:00h
               
               Franja 2 → 10:00h- 12:00h
               
               Franja 3 → 12:00h -14:00h
               
               Franja 4 → 14:00h- 16:00h
               
               Franja 5 → 16:00h -18:00h
               
               Franja 6 → 18:00h- 20:00h
               
               """);
            if (opcion < 1 || opcion > 6) {
                System.out.println("Debe elegir la franja horaria selecionando del 1 al 6.");
            }

        } while (opcion < 1 || opcion > 6);


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

     private static Integer inputInt (String text){
             int num = -1;
             boolean valido = false;

             while (!valido) {
                 try {
                     System.out.println(text);
                     num = Integer.parseInt(sc.nextLine());
                     valido = true;
                 } catch (NumberFormatException e) {
                     System.out.println("Error: Por favor ingrese un número válido.");
                 }
             }
             return num;
         }


}