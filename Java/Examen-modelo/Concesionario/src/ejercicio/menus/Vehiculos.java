package ejercicio.menus;

import ejercicio.vehiculos.Vehiculo;

import java.util.List;

import static ejercicio.menus.Menus.*;

public class Vehiculos {
    private final List<Vehiculo> vehiculos;

    public Vehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public void principal() {
        boolean salir = false;
        do {
            System.out.println("""
                    Seleccione la opcion deseada en vehiculos:
                    [1] - Listar Vehiculos.
                    [2] - Agregar vehiculos.
                    [3] - Modificar vehiculos.
                    [4] - Eliminar vehiculo.
                    [5] - Filtrar vehiculos del inventario.
                    [6] - Mostrar detalles completos de un vehiculo.
                    [0] - Salir.
                    """);
            switch (inputInt()) {
                case 1:
                    listar();
                    break;
                case 2:
                    agregar();
                    break;
                case 3:
                    modificar();
                    break;
                case 4:
                    eliminar();
                    break;
                case 5:
                    filtrar();
                    break;
                case 6:
                    mostrar();
                    break;
                case 0:
                    salir = true;
                    break;
                default:
                    System.out.println("Error");
            }
        } while(!salir);
    }


   public void listar() {
        StringBuilder resultado = new StringBuilder("Lista de vehiculos:\n");
        for (int i = 0; i < vehiculos.size(); i++) {
            final Vehiculo vehiculo = vehiculos.get(i);
            resultado.append("[").append(i).append("]")
                    .append(vehiculo.getMarca()).append(" ")
                    .append(vehiculo.getModelo()).append(" ")
                    .append(vehiculo.getMatricula()).append("\n");
        }
        System.out.println(resultado);
    }

    public void agregar()  {
        vehiculos.add(
                new Vehiculo(
                        input("Introduce id: "),
                        input("Introduce Marca: "),
                        input("Introduce Modelo: ")
                )
        );
    }

    public int modificar(){
        System.out.println("""
        Seleccione lo qe desea modificar del vehiculo:
        [1] - Precio
        [2] - Kilometros.
        [3] - Estado.
        [4] - Atrás.
        [0] - Salir.
        """);
        return inputInt();
    }

    public int filtrar(){
        System.out.println("""
        Seleccione el metodo a filtrar:
        [1] - Marca.
        [2] - Modelo.
        [3] - Año.
        [4] - Estado.
        [5] - Rango de precio.
        [6] - Rango Kilometros.
        [7] - Atrás.
        [0] - Salir.
        """);
        return inputInt();
    }
}
