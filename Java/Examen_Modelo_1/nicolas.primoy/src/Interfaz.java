import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.List;

public class Interfaz {

    static Scanner sc = new Scanner(System.in);
    List<Alumno> listaAlumnos = new ArrayList<>();


    public void menuPrincipal() {
        int opcion;

        do {
            System.out.println("""
                ***************************
                === GESTOR DE ALUMNOS ===
                [1] - Mostrar todos los datos del alumnado.
                [2] - Añadir un nuevo alumno y registrar notas.
                [3] - Eliminar alumno existente.
                [4] - Mostrar nota media de la clase.
                [5] - Mostrar al alumno con la mejor nota media y su nota calcularMedia.
                [0] - Salir
                ***************************
                """);

            opcion = inputInt("Ingrese la opcion deseada: ");

            switch (opcion) {
                case 1:
                    mostrar();
                    break;
                case 2:
                    agregar();
                    System.out.println("*".repeat(30));
                    break;
                case 3:
                    eliminar();
                    break;
                case 4:
                    mediaClase();
                    break;
                case 5:
                  //  mejorMedia();
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

    private void mostrar() {
        if (listaAlumnos.isEmpty()) {
            System.out.println("No hay alumnos para mostrar.");
            System.out.println("*".repeat(30));
        }
        List<Alumno> tareasPorId = new ArrayList<>(listaAlumnos);
        tareasPorId.sort(Comparator.comparing(Alumno::getId));

        for (Alumno alumno : tareasPorId) {
            System.out.println(alumno);
            System.out.println("Media: " + alumno.calcularMedia());
        }
    }

    private void agregar() {
        int id;
        boolean idUnico;
        do {
            id = inputInt("Introduce el ID del nuevo alumno: ");
            int finalId = id;
            idUnico = listaAlumnos.stream().noneMatch(alumno -> alumno.getId() == finalId);

            if (!idUnico) {
                System.out.println("Ese ID ya existe, utilice uno nuevo.");
                System.out.println("*".repeat(30));
            }
        } while (!idUnico);
        String nombre = input("Introduce el nombre del nuevo alumno: ");
        String apellido1 = input("Introduce el primer apellido del nuevo alumno: ");
        String apellido2 = input("Introduce el segundo apellido del nuevo alumno: ");

        double tema1 = leernota(1);
        double tema2 = leernota(2);
        double tema3 = leernota(2);
        double tema4 = leernota(3);

        Alumno newAlumno = new Alumno(id, nombre, apellido1, apellido2, tema1, tema2, tema3, tema4);
        listaAlumnos.add(newAlumno);
        System.out.println("El alumno con id " + newAlumno.getId()
            + " ha sido agregada correctamente a la lista.");
        System.out.println("*".repeat(30));
    }

    private void eliminar() {
        if (listaAlumnos.isEmpty()) {
            System.out.println("No hay alumnos para eliminar.");
            System.out.println("-".repeat(30));
            return;
        }
        mostrarPos();

        try {
            int pos = inputInt("Introduce la posición del alumno a eliminar: ");
            if (pos >= 0 && pos < listaAlumnos.size()) {
                System.out.println("El alumno con ID " + listaAlumnos.remove(pos).getId()
                    + " se ha eliminado correctamente.");
                System.out.println("-".repeat(30));
                listaAlumnos.remove(pos);
            } else {
                System.out.println("Error: posición inválida.");
                System.out.println("-".repeat(30));
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: debes ingresar un número de posición");
            System.out.println("-".repeat(30));
        }
    }

    private double leernota(int x) {
        boolean notaCorrecta = false;
        double nota = -1.0;

        do {
            try {
                nota = Double.parseDouble(input("Introduce la nota del tema " + x + ": "));
                if (nota < 0 || nota > 10) {
                    System.out.println("Se debe ingresar un número positivo entre 0 y 10.");

                } else {
                    notaCorrecta = true;
                }
            } catch (NumberFormatException a) {
                System.out.println("Error: se debe ingresar un número");
            }

        } while (!notaCorrecta);
        return nota;
    }

    private void mostrarPos() {
        StringBuilder aux = new StringBuilder("Lista de alumnos: ");
        if (listaAlumnos.isEmpty()) {
            System.out.println("No hay alumnos para eliminar.");
            System.out.println("-".repeat(30));
        }
        for (Alumno alumno : listaAlumnos) {
            aux.append(listaAlumnos.indexOf(alumno)).append(" ")
                .append(alumno.getApellido1()).append(" ")
                .append(alumno.getApellido2()).append(",")
                .append(alumno.getNombre()).append("\n");
        }
        System.out.println(aux);
        System.out.println("-".repeat(30));
    }

    private void mediaClase() {
        double media = -1.0;
        if (listaAlumnos.isEmpty()) {
            System.out.println("No hay alumnos para calcular la calcularMedia.");
            System.out.println("-".repeat(30));
        } else {
            for (Alumno alumno : listaAlumnos) {
                media = alumno.calcularMedia();
            }
        }
        System.out.println("La media de toda la clase es: " + media);
    }

   /** private void mejorMedia() {
        if (listaAlumnos.isEmpty()) {
            System.out.println("No hay alumnos para calcular la media.");
            return;
        }
        double resultado = 0.0;
        Alumno mejorMedia = null;
        double media;
        for (Alumno alumno : listaAlumnos) {
            media = alumno.calcularMedia();
            if (resultado < media) {
                resultado = media;
                mejorMedia = alumno;
            }
            System.out.println("El alumno con mejor media es " +  mejormedia() + " con la media " + media );
        }



        }*/

    private static String input (String text){
        System.out.println(text);
        return sc.nextLine();
    }

    private static Integer inputInt (String text){
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










