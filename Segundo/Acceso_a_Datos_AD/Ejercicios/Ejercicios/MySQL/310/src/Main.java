/*
Se pide desarrollar una pequeña aplicación que permita realizar pedidos a clientes en una tienda. Para ello, crea una base de datos tienda teniendo en cuenta el siguiente diagrama E-R:



La estructura de cada factura debería seguir el siguiente modelo:

Cliente:
 DNI: 22222222B
Nombre: Ann

Fecha:
 2023-07-24

Productos:
Nombre: bicicleta Precio: 205,60
Cantidad: 1
Nombre: silla Precio: 20,00
Cantidad: 2
Precio total: 245,60

Después, diseña e implementa la aplicación, que nos debe permitir:

Consultar la información personal de un cliente.
Consultar los pedidos realizados por un cliente. Se debe mostrar la fecha en la que realizó el pedido, los productos que compró y el precio total del pedido.
Realizar un pedido. El cliente introducirá su dni e indicará los productos que quiere añadir al pedido
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