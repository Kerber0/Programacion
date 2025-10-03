import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.util.List;

public class GestorTareas {
    static Scanner sc = new Scanner(System.in);
    List<Tareas> listaTareas = new ArrayList<>();


    public void menuPrincipal() {
        int opcion;

        do {
            System.out.println("""
            ***************************
            === GESTOR DE TAREAS ===
            1. Agregar tarea
            2. Listar tareas
            3. Marcar tarea como completada
            4. Eliminar tarea
            0. Salir
            ***************************
            """);

            opcion =inputInt("Ingrese la opcion deseada: ");

            switch (opcion){
                case 1:
                    agregar();
                    break;
                case 2:
                    mostrar();
                    System.out.println("*".repeat(30));
                    break;
                case 3:
                    completada();
                    break;
                case 4:
                    eliminar();
                    break;
                case 0:
                    System.out.println("Fin de programa.");
                    System.out.println("*".repeat(30));
                    break;
                default:
                    System.out.println("La opción selecionada es inválida.");
                    break;
            }
        } while (opcion != 0);

    }

    private void agregar() {
        int id;
        boolean idUnico = false;
        do {
            id = inputInt("Introduce el ID de la nueva tarea: ");
            int finalId = id;
            idUnico = listaTareas.stream().noneMatch(tarea -> tarea.getId() == finalId); // evaluo si algun id esta en la lista

            if (!idUnico) {
                System.out.println("Ese ID ya existe, utilice uno nuevo.");
                System.out.println("*".repeat(30));
            }
        } while (!idUnico);


        String descripcion = input("Introduce una descripcion de la taera: ");
        boolean completada = false;

        Tareas newtarea = new Tareas(id, descripcion, completada);
        listaTareas.add(newtarea);
        System.out.println("La tarea con id " + newtarea.getId() + " ha sido agregada correctamente a la lista.");
        System.out.println("*".repeat(30));
    }

    private void mostrar() {
        if (listaTareas.isEmpty()) {
            System.out.println("No hay tareas para listar.");
            System.out.println("*".repeat(30));
        }
        List<Tareas> tareasPorId = new ArrayList<>(listaTareas);
        tareasPorId.sort(Comparator.comparing(Tareas :: getId));

        for (Tareas tareas : tareasPorId){
            System.out.println(tareas);
        }

    }

    private void completada() {
        if (listaTareas.isEmpty()) {
            System.out.println("No hay tareas para marcar como completadas.");
            System.out.println("*".repeat(30));
            return;
        }

        mostrar();
        int id = inputInt("Seleccione el ID de la tarea completada: ");
        boolean encontrado = false;

        for (Tareas tarea : listaTareas) {
            if (tarea.getId() == id) {
                if (!tarea.isCompletada()) {
                    tarea.setCompletada(true);
                    System.out.println("La tarea se ha marcado como completada con éxito.");
                    System.out.println("*".repeat(30));
                } else {
                    System.out.println("La tarea ya estaba completada.");
                    System.out.println("*".repeat(30));
                }
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontró una tarea con ese ID.");
            System.out.println("*".repeat(30));
        }
    }

    private void eliminar() {
        if (listaTareas.isEmpty()) {
            System.out.println("No hay tareas para eliminar.");
            return;
        }

        mostrar();
        int id = inputInt("Seleccione el ID de la tarea a eliminar: ");
        boolean eliminado = false;

        Iterator<Tareas> iterator = listaTareas.iterator();  // al usar un for each y modificar la cantidad del array se crea una execpicon con iterator no
        while (iterator.hasNext()) {
            Tareas tarea = iterator.next();
            if (tarea.getId() == id) {
                iterator.remove();
                System.out.println("La tarea con ID " + id + " se ha eliminado correctamente.");
                eliminado = true;
                break;
            }
        }

        if (!eliminado) {
            System.out.println("No se encontró una tarea con ese ID.");
        }
    }





    static String input(String text) {
        System.out.println(text);
        return sc.nextLine();
    }

    static Integer inputInt(String text) {
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
