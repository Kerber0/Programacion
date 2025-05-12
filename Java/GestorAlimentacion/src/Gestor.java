import java.util.LinkedList;
import java.util.Scanner;

public class Gestor {

    private LinkedList<Producto> stock = new LinkedList<>();
    static Scanner sc = new Scanner(System.in);

    public void inicio() {
        int choice;
        System.out.println("Iniciando Gestor de tienda.");

        do {
            System.out.println("Seleccione la opción deseada:");

            choice = inputInt("""
                   [1] - Agregar un nuevo producto.
                   [2] - Vender producto.
                   [3] - Eliminar producto.
                   [4] - Mostrar productos.
                   [0] - Salir
                
                """);

            switch (choice) {
                case 1:
                    agregar();
                    break;
                case 2:
                    vender();
                    break;
                case 3:
                    eliminar();
                    break;
                case 4:
                    mostrarCompleto();
                    break;
                case 0:
                    System.out.println("Fin de programa");
                    sc.close();
            }

        }while(choice != 0);

    }

    private void vender() {
        String choice;
        double totalSinIVA;
        double total;
        int cantidad;

        do {
            if (stock.isEmpty()) {
                System.out.println("No hay productos para eliminar.");
                break;
            }

            System.out.println("Lista de productos: ");
            mostrarBasico();
            choice = input("Ingrese el ID del producto que desea vender o 0 para salir");

            if (!choice.equalsIgnoreCase("0")) {
                for (Producto producto : stock)
                    if (producto.getId().equalsIgnoreCase(choice)) {
                        cantidad = inputInt("Ingrese la cantidad del producto a vender.");
                        totalSinIVA = producto.getPrecio()* cantidad;
                        if (producto.isIvaReducido()) {
                            total= totalSinIVA * 1.10;
                        } else {
                            total = totalSinIVA * 1.21;
                        }

                        System.out.println("Se ha vendido " + cantidad + producto.getNombre());
                        System.out.println("Precio total de venta sin IVA: " +  String.format("%.2f",totalSinIVA));
                        System.out.println("Precio total de la venta con IVA: " +  String.format("%.2f",total));

                    }else {
                        System.out.println("El ID ingresado no pertenece a un producto registrado.");
                    }
            }
        }while (choice.equalsIgnoreCase("0"));

    }  //Me falta corregir que cuando se venda mas del stock disponible lance un mensaje de error

    private void eliminar() {
        String choice;
        do {
            if (stock.isEmpty()) {
                System.out.println("No hay productos para eliminar.");
                break;
            }

            System.out.println("Lista de productos: ");
            mostrarBasico();

            choice = input("Ingrese el id del producto a eliminar o 0 para volver atrás");
            if (!choice.equalsIgnoreCase("0")) {
                for (Producto productos : stock) {
                    if(productos.getId().equalsIgnoreCase(choice)) {
                        stock.remove(productos);
                        System.out.println("El producto " + productos.getNombre() + " ha sido eliminado.");
                    }
                    else {
                        System.out.println("El id ingresado no esta en el stock.");
                    }
                }
            }

        }while (!choice.equalsIgnoreCase("0"));
    }

    private void agregar() {
        String id = input("Ingrese el id del nuevo producto");
        String nombre = input("Ingrese el nombre del producto a registrar: ");
        double precio = validarPrecio();
        int cantidad = inputInt("Ingrese la cantidad actual en el stock de este producto ");
        boolean ivaReducido = ivaReducido();

        Producto producto = new Producto(id, nombre, precio, ivaReducido, cantidad);
        stock.add(producto);
        System.out.println("Producto agregado correctamente.");

    }  // me falta corregir para que no permita cargar productos con stock negativo

    private boolean ivaReducido () {
        boolean valido = false;
        Boolean iva = null;

        do {
            String respuesta = input("Indique 'Si' sí el iva de este producto es reducido o 'No' en el caso contrario");
            if (respuesta.equalsIgnoreCase("Si")) {
                iva = true;
                valido = true;
            }
            if (respuesta.equalsIgnoreCase("No")) {
                iva = false;
                valido = true;
            } else {
                System.out.println("Se debe ingresar 'Si' o 'No'.");
            }

        }while (!valido);
        return iva;
    }  //me falta corregir que aunque te tome la opcion de "si" te tire por pantalla que debe ingresarse si o no / pero asigna el tipo de iva correctamente igual

    private void mostrarBasico() {
        if (stock.isEmpty()) {
            System.out.println("Todavía no hay productos registrados.");
        } else {
            for (Producto productos : stock) {
                System.out.println("ID: " + productos.getId() + " - Nombre: " + productos.getNombre());
            }
        }
    }

    private double validarPrecio() {
       boolean valido = false;
       double precio = -1;
        do {
            try {
                precio =  Double.parseDouble(input("Ingrese el precio del producto"));
                if (precio < 0) {
                    System.out.println("Error: Error se debe ingresar un número positivo");
                } else {
                    valido = true;
                }

            }catch (NullPointerException e) {
                System.out.println("Error: Error el precio no puede estar vacío.");
            } catch (NumberFormatException e) {
                System.out.println("Error: Error se debe ingresar un número válido positivo");
            }

       }while (!valido);

        return precio;


    }

    private void mostrarCompleto() {
        String iva;
        if (stock.isEmpty()) {
            System.out.println("Todavía no hay productos registrados.");

        } else {
            for (Producto productos : stock) {

                if (productos.isIvaReducido()) {
                    iva ="Precio con IVA : " + String.format("%.2f", productos.getPrecio() * 1.21);
                } else {
                    iva = "Precio con IVA : " + String.format("%.2f" ,productos.getPrecio()*1.10);
                }
                System.out.println(productos + iva);
            }
        }
    }

    private static String input(String text) {
        boolean textcorrect = false;
        String resultado;
        do {
            System.out.println(text);
            resultado = sc.nextLine();
            if (resultado.isEmpty()){
                System.out.println("Se debe ingresar algo: ");

            } else {
                textcorrect = true;
            }
        }while (!textcorrect);
        return resultado;
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
