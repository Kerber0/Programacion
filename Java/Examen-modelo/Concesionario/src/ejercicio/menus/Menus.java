package ejercicio.menus;

import java.util.Scanner;
import ejercicio.Concesionario;

public class Menus {
    private final Concesionario concesionario;
    private final Vehiculos vehiculos;

    public Menus(Concesionario concesionario) {
        this.concesionario = concesionario;
        this.vehiculos = new Vehiculos(concesionario.getInventario());
    }

    private final static Scanner sc = new Scanner(System.in);

    static String input(String text) {
        System.out.println(text);
        return sc.nextLine();
    }
    static String input() {
        System.out.println("Introducir valor: ");
        return sc.nextLine();
    }

    static int inputInt() {
        System.out.println("Introducir valor: ");
        return Integer.parseInt(sc.nextLine());
    }

    public void principal() {
        boolean salir = false;
        do {
            System.out.println("Bienvenido al menú del Consecionario!");
            System.out.println("Seleccione la opción deseada: ");
            System.out.println("""
                    [1] - Opciones en Vehiculos.
                    [2] - Opciones en Clientes.
                    [3] - Opciones en Ventas.
                    [4] - Reportes y estadisticas.
                    [0] - Salir.
                    """);
            switch (inputInt()) {
                case 1:
                    vehiculos.principal();
                    break;
                case 2:
                    // clientes.principal();
                    break;
                case 0:
                    salir = true;
                    break;
                default:
                    System.out.println("Opcion invalida!");
            }
        } while(!salir);
        despedida();
    }

    public void despedida() {
       System.out.println("Espero haberle sido de ayuda. Hasta la proxima.");
    }

    public  int cliente() {
        System.out.println("""
            Seleccione la opcion deseada:
            [1] - Registrar nuevo cliente.
            [2] - Modificar cliente.
            [3] - Eliminar cliente.
            [4] - Buscar cliente.
            [5] - Listar todos los clientes.
            [6] - Ver historial de compra.
            [7] - Atrás.
            [0] - Salir.
            """);
        return Integer.parseInt(input());
    }

    public  int modificiarCliente(){
        System.out.println("""
            Seleccione que desea modificar del cliente:
            [1] - Telefono.
            [2] - Email.
            [3] - Atrás.
            [0] - Salir.
            """);
        return Integer.parseInt(input());
    }

    public  int buscarCliente(){
        System.out.println("""
            Seleccione el metodo de busqueda:
            [1] - Dni.
            [2] - Nombre y/o apellido.
            [3] - Telefono.
            [4] - Email.
            [5] - Atrás.
            [0] - Salir.
            """);
        return Integer.parseInt(input());
    }

    public  int ventas(){
        System.out.println("""
            Seleccione la opción deseada:
            [1] - Registrar nueva venta.
            [2] - Buscar venta por matricula.
            [3] - Listar todas las ventas.
            [4] - Filtrar ventas por fechas.
            [5] - Calcular comisiones por ventas.
            [6] - Generar factura de venta.
            [7] - Atras.
            [0] - Salir
            """);
        return Integer.parseInt(input());
    }

    public  int reportes(){
        System.out.println("""
            Seleccione la opción deseada:
            [1] - Generar reporte de ventas menusal.
            [2] - Mostrar vehículos más vendidos.
            [3] - Calcular ingresos totales por período.
            [4] - Mostrar estadísticas de ventas por marca.
            [5] -  Listar clientes frecuentes.
            [6] - Atras.
            [0] - Salir
            """);
        return Integer.parseInt(input());
    }




}







