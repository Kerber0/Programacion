import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import static java.lang.Double.parseDouble;

public class Gestor {
    private static final Scanner sc = new Scanner(System.in);
    private final List<Producto> inventario = new ArrayList<>();

    public void menuPrincipal(){
        System.out.println("Bienvenido al inventario de la tienda!");
        int opcion = -1;
        do {
            try {
                switch (opcion = inputInt("""
                        Seleccione la opcion deseada:
                        [1] - Mostrar todos los productos.
                        [2] - Agregar un nuevo producto.
                        [3] - Editar un producto existente.
                        [4] - Eliminar un producto del inventario.
                        [5] - Buscar productos por nombre o categoría.
                        [0] - Salir.
                       """)) {
                   case 1:
                       mostrar();
                       break;
                   case 2:
                       agregar();
                       break;
                   case 3:
                       editar();
                       break;
                   case 4:
                       eliminar();
                       break;
                   case 5:
                       buscar();
                       break;
                   case 0:
                       salir();
                       break;
                   default:
                       System.out.println("La opcion seleccionada es inválida, pruebe otra vez.");
               }
           } catch (NumberFormatException exception) {
               System.out.println("Error: Debe ingresar un número válido.");
           }
       } while (opcion != 0);
    }

    private void salir() {
        System.out.println("Adios.");
    }

    private void mostrar(){
        if (inventario.isEmpty()) {
            System.out.println("No hay productos para mostrar");
            return;
        }
        List<Producto> productosOrdenados = new ArrayList<>(inventario);
        productosOrdenados.sort(Comparator.comparing(Producto::getNombre, String.CASE_INSENSITIVE_ORDER));

        System.out.println("Lista de productos: ");
        for (Producto producto : productosOrdenados){
            System.out.println(producto);
        }
    }

    private void agregar(){
        String nombre = input("Introduce el nombre del nuevo producto: ");
        String categoria = input("Introduce la categoría del nuevo producto: ");
        Double precio = leerPrecio();
        int stock = leerStock();

        for (Producto producto : inventario) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                producto.setStock(producto.getStock() + 1);
                System.out.println("El producto " + producto.getNombre() + " ya existe. Se ha aumentado su stock en 1.");
                return;
            }
        }
        Producto nuevoProducto = new Producto(nombre, categoria, precio, stock);
        inventario.add(nuevoProducto);
        System.out.println("El producto " + nuevoProducto.getNombre() + " ha sido agregado con éxito.");
    }

    private double leerPrecio(){
        boolean preciocorrecto = false;
        double precio = -1.2;
        do {
            try {
            precio = parseDouble(input("Introduce el precio del nuevo producto:"));

            if (precio < 0) {
                System.out.println("El precio del producto debe ser positivo.");
            }else {
                preciocorrecto = true;
            }
        }catch (NumberFormatException exception){
                System.out.println("Error: se debe introducir un número.");
            }
        }while (!preciocorrecto);
        return precio;
    }

    private int leerStock(){
        boolean stockcorrecto = false;
        int stock = -1;
        do{
            try {
                stock =inputInt("Introduce la cantidad de stock del producto: ");
                if (stock < 0){
                    System.out.println("La cantidad mínima de stock es 0.");
                }else{
                    stockcorrecto = true;
                }
            }catch (NumberFormatException e){
                System.out.println("Error: se debe introducir un número.");
            }
        }while (!stockcorrecto);
        return stock;
    }

    private void editar(){
        mostrarPos();
        if(inventario.isEmpty()){
            System.out.println("No hay productos para modificar.");
        }
        try {
            int pos = inputInt("Seleccione la posición del producto a modificar:");
            if (pos >= 0 && pos < inventario.size()) {
                Producto producto = inventario.get(pos);
                boolean continuar = true;
                do{
                    System.out.println("Editando: " + producto.getNombre());
                    int opcion = inputInt("""
                        ¿Qué desea editar?
                        [1] - Nombre.
                        [2] - Categoría.
                        [3] - Precio.
                        [4] - Stock.
                        [0] - Atrás.
                        """);
                    switch(opcion) {
                        case 1 -> {
                            String nuevoNombre = input("Ingrese el nuevo nombre: ");
                            producto.setNombre(nuevoNombre);
                            System.out.println("Nombre modificado correctamente");
                        }
                        case 2 -> {
                            String nuevaCategoria = input("Ingrese la nueva categoría: ");
                            producto.setCategoria(nuevaCategoria);
                            System.out.println("Categoría modificada correctamente.");
                            }
                        case 3 -> {
                            double nuevoPrecio = leerPrecio();
                            producto.setPrecio(nuevoPrecio);
                            System.out.println("Precio modificado correctamente.");
                        }
                        case 4 -> {
                            int nuevoStock = leerStock();
                            producto.setStock(nuevoStock);
                            System.out.println("Stock modificado correctamente.");
                        }
                        case 0 -> {
                            System.out.println("Modificaciones finalizadas");
                            continuar = false;
                        }
                    }
                } while (continuar);
            } else {
                System.out.println("Error: la posición ingresada no es válida.");
            }
        } catch(NumberFormatException e) {
            System.out.println("Error: Se debe ingresar un número válido.");
        }
    }

    private void mostrarPos() {
        StringBuilder toret = new StringBuilder("Lista de productos: \n");
        if (inventario.isEmpty()) {
            System.out.println("El inventario esta vacío.");
            return;
        }
        for (Producto producto : inventario) {
           toret.append(inventario.indexOf(producto)).append(" ").append(producto.getNombre()).append("\n");
        }
       System.out.println(toret);
    }

    private void eliminar(){
        if (inventario.isEmpty()){
            System.out.println("No hay productos para eliminar.");
            return;
        }
        mostrarPos();

        try {
            int pos = inputInt("Seleccione la posicion del producto a eliminar: ");
            if (pos >= 0 && pos<inventario.size()){
                System.out.println("El producto " + inventario.get(pos).getNombre() + "se ha eliminado correctamente.");
                inventario.remove(pos);
            }else{
                System.out.println("Error: posición inválida.");
            }
        }catch (NumberFormatException e){
            System.out.println("Error: debes ingresar una posición válida.");
        }
    }

    private void buscar(){
        int opcion;
        do{
            try {
                System.out.println("""
                        Seleccione el metodo de busqueda:
                        [1] - Por nombre.
                        [2] - Por categoría.
                        [3] - Por precio.
                        [4] - Por stock.
                        [0] - Atrás.
                        
                        """);
                opcion = inputInt("Metodo: ");
                switch (opcion){
                    case 1:
                        buscarNombre(input("Introduce el nombre del producto a buscar: "));
                        break;
                    case 2:
                        buscarCategoria(input("Introduce la categoría del producto a buscar: "));
                        break;
                    case 3:
                        buscarPrecio();
                        break;
                    case 4:
                        buscarStock(inputInt("Introduce el stock del producto a buscar: "));
                        break;
                    case 0:

                        return;
                    default:
                        System.out.println("La opcion introducida no es válida, vuelva a intentar.");

                }
            }catch (NumberFormatException e){
                System.out.println("Error: debe introducir un número.");
            }
        }while (true);
    }

    private void buscarNombre(final String nombre) {
        final StringBuilder encontrado = new StringBuilder("Libro encontrado con exito: \n");

        inventario.parallelStream()
                .filter((p) -> p.getNombre().equalsIgnoreCase(nombre))
                .forEach((p) -> encontrado.append(p).append("\n"));

        System.out.println(encontrado.isEmpty() ? "No se encontro ningún producto con ese nombre." : encontrado);
    }   //Metodo a lo Jon

    private void buscarCategoria(String categoria){
        StringBuilder encontrado = new StringBuilder("Libro encontrado con exito: \n");
        for(Producto producto : inventario){ // O(n)
            if(producto.getCategoria().equalsIgnoreCase(categoria)){
                encontrado.append(producto).append("\n");
            }
        }
        if(encontrado.isEmpty()){
            System.out.println("No se encontro ningún producto con esa categoría.");
        }else{
            System.out.println(encontrado);
        }
    }

    private void buscarPrecio() {
        Double precio = null;
        do {
            try {
                precio = parseDouble(input("Introduce el precio del producto a buscar:"));
            } catch (NumberFormatException e) {
                System.out.println("Error: Debes ingresar un número válido.");
            }
        } while (precio == null);

        StringBuilder encontrado = new StringBuilder("Producto(s) encontrado(s): \n");
        for (Producto producto : inventario) {
            if (producto.getPrecio().equals(precio)) {
                encontrado.append(producto).append("\n");
            }
        }

        if (encontrado.length() == "Producto(s) encontrado(s): \n".length()) {
            System.out.println("No se encontró ningún producto con ese precio.");
        } else {
            System.out.println(encontrado);
        }
    }

    private void buscarStock(int stock) {
        StringBuilder encontrado = new StringBuilder("Libro encontrado con exito: \n");
        for (Producto producto : inventario) {
            if (producto.getStock().equals(stock)) {
                encontrado.append(producto).append("\n");
            }
        }
        if (encontrado.isEmpty()) {
            System.out.println("No se encontro ningún producto con ese stock.");
        } else {
            System.out.println(encontrado);
        }
    }

    private static String input(String text) {
        System.out.println(text);
        return sc.nextLine();
    }

    private static Integer inputInt(String text) {
        Integer num = null;
        boolean valido = false;
        do {
            try {
                System.out.println(text);
                num = Integer.parseInt(sc.nextLine());

                if (num >= 0) {
                    valido = true;
                } else {
                    System.out.println("Error: El número debe ser positivo.");
                }

            } catch (NumberFormatException exception) {
                System.out.println("Error: Se debe ingresar un número válido.");
            }
        } while (!valido);
        return num;
    }
}
