import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Gestor implements Generador {

    List<Profesor> profesores = new ArrayList<>();
    List<Alumno> alumnos = new ArrayList<>();
    static String[] CURSOS = {
            "1 ESO", "2 ESO", "3 ESO", "4 ESO", "1 Bachillerato", "2 Bachillerato"
    };
    Scanner sc = new Scanner(System.in);

    public ArrayList<Profesor> profesores() {
        while (profesores.size() < 5) {
            profesores.add(Generador.generarProfesor());
        }
        return (ArrayList<Profesor>) profesores;
    }

    public ArrayList<Alumno> alumnos() {
        while (alumnos.size()< 60) {
            alumnos.add(Generador.generarAlumno());
        }
        return (ArrayList<Alumno>) alumnos;
    }

    public void inicio() {

        profesores();
        alumnos();

        System.out.println("Bienvenido al gestor del Instituto!");

        int choice = -1;
        do {
            try {
                choice = inputInt(""" 
                            Seleccione la opcion que desea ejecutar:
                            
                            [1] - Registrar un nuevo alumno/profesor.
                            [2] - Mostrar todos los alumnos de un curso.
                            [3] - Mostrar todos los alumnos/profesores.
                            [4] - Buscar un alumno/profesor.
                            [5] - Eliminar un alumno/profesor.
                            [6] - Mostrar promedio de un curso.
                            [7] - Mostrara promedio de instituto.
                            [0] - Salir.
                            
                            
                            """);

                switch (choice) {
                    case 1:
                        agregar();
                        break;
                    case 2:
                        mostrarAlumnosPorCurso();
                        break;
                    case 3:
                         mostrarTodo();
                        break;
                    case 4:
                        buscar();
                        break;
                    case 5:
                        eliminar();
                        break;
                    case 6:
                        promedioCurso();
                        break;
                    case 7:
                        promedioInstituto();
                        break;
                    case 0:
                        System.out.println("Espero haberle sido de ayuda. Adios.");
                        break;
                    default:
                        System.out.println("La opcion ingresdada es invalida, por favor intente otra vez.");

                }

            }catch (NullPointerException e) {
                System.out.println("Error: " + e);
            }
        }while (choice != 0);
    }

    public void promedioInstituto() {
        double sumaNotas = 0;
        int contador = 0;

        for (Alumno alumno : alumnos) {
            for (Materias materia : alumno.getNotas()) {
                sumaNotas += (materia.getPrimerNota() + materia.getSegundaNota() + materia.getTerceraNota()) / 3.0;
            }
            contador++;
        }

        if (contador > 0) {
            double promedio = sumaNotas / contador;
            System.out.println("El promedio de notas del instituto es: " + promedio);
        } else {
            System.out.println("No hay alumnos registrados en el instituto.");
        }
    }

    public void promedioCurso() {
        String curso = input("Ingrese el curso para calcular el promedio (Ejemplo: 1° ESO): ");

        while (!esCursoValido(curso)) {
            System.out.println("Curso inválido. Por favor ingrese un curso válido.");
            curso = input("Ingrese el curso para calcular el promedio: ");
        }

        double sumaNotas = 0;
        int contador = 0;

        for (Alumno alumno : alumnos) {
            if (alumno.getCurso().equals(curso)) {
                for (Materias materia : alumno.getNotas()) {
                    sumaNotas += (materia.getPrimerNota() + materia.getSegundaNota() + materia.getTerceraNota()) / 3.0;
                }
                contador++;
            }
        }

        if (contador > 0) {
            double promedio = sumaNotas / contador;
            System.out.println("El promedio de las notas del curso " + curso + " es: " + promedio);
        } else {
            System.out.println("No hay alumnos registrados en el curso " + curso + ".");
        }
    }

    public void eliminar() {
        String dni = input("Ingrese el DNI del alumno o profesor que desea eliminar: ");

        alumnos.removeIf(alumno -> alumno.getDni().equals(dni));

        profesores.removeIf(profesor -> profesor.getDni().equals(dni));

        System.out.println("El alumno o profesor con DNI " + dni + " ha sido eliminado.");
    }

    public void buscar() {
        String criterio = input("Ingrese el nombre o apellido del alumno o profesor que desea buscar: ").toLowerCase();
        boolean encontrado = false;

        for (Alumno alumno : alumnos) {
            if (alumno.getNombre().toLowerCase().contains(criterio) ||
                    alumno.getApellido1().toLowerCase().contains(criterio) ||
                    alumno.getApellido2().toLowerCase().contains(criterio)) {
                System.out.println("Alumno encontrado: " + alumno);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            for (Profesor profesor : profesores) {
                if (profesor.getNombre().toLowerCase().contains(criterio) ||
                        profesor.getApellido1().toLowerCase().contains(criterio) ||
                        profesor.getApellido2().toLowerCase().contains(criterio)) {
                    System.out.println("Profesor encontrado: " + profesor);
                    encontrado = true;
                    break;
                }
            }
        }

        if (!encontrado) {
            System.out.println("No se encontró ningún alumno o profesor con ese nombre o apellido.");
        }
    }

    private void mostrarTodo() {
        int choice;
        do {

            choice = inputInt("""
                            Ingrese la opcion deseada:
                            [1] - Mostrar todos los alumnos.
                            [2] - Mostrar todos los profesores.
                            [3] - Mostrar todos los alumnos/profesores.
                            [0] - Atras.
                            """);
            switch (choice) {
                case 1:
                    mostrarAlumnos();
                case 2:
                    mostrarProfesores();
                case 3:
                    mostrarProfesores();
                    mostrarAlumnos();
                case 0:
                    return;
                default:
                    System.out.println("La opcion ingresada es invalida. Pruebe otra vez");
            }

        }while (choice != 0);
    }

    public void agregar() {
        int choice = -1;
        do {
            choice = inputInt("""
                    Seleccione la opcion deseada:
                    [1] - Registrar un alumno.
                    [2] - Registrar un profesor.
                    [0] - Atras.
                    """);

            if (choice == 0) {
                System.out.println("Registro finalizado.");
                System.out.println("\n");
                return;
            }

            if (choice < 1 || choice > 3) {
                System.out.println("Opción inválida. Intente de nuevo.");
                continue;
            }

            String nombre = input("Ingrese el nombre: ");
            String apellido1 = input("Ingrese el primer apellido: ");
            String apellido2 = input("Ingrese el segundo apellido: ");
            LocalDate fechaNacimiento = inputLocalDate();
            String dni = Generador.validarDNI(input("Ingrese el DNI: "));

            switch (choice) {
                case 1:
                    int edad = LocalDate.now().getYear() - fechaNacimiento.getYear();
                    String curso = asignarCurso(edad);
                    ArrayList<Materias> notas = new ArrayList<>(Generador.generarMaterias(5));
                    alumnos.add(new Alumno(nombre, apellido1, apellido2, fechaNacimiento, dni, curso, notas));
                case 2:
                    double salario = inputDouble("Ingrese el salario del profesor: ");
                    profesores.add( new Profesor(nombre, apellido1, apellido2, fechaNacimiento, dni, salario));

                case 3:
                    return;


            }


        }while (choice!= 0);
    }

    void mostrarAlumnosPorCurso() {

        System.out.println(Arrays.toString(CURSOS));
        String cursoIngresado = input("Ingrese el curso: ");


        while (!esCursoValido(cursoIngresado)) {
            System.out.println("Curso inválido. Por favor ingrese un curso válido.");
            cursoIngresado = input("Ingrese el curso: ");
        }

        System.out.println("Alumnos de " + cursoIngresado + ":");
        for (Alumno alumno : alumnos) {
            if (alumno.getCurso().equals(cursoIngresado)) {
                System.out.println(alumno.getNombre() + " " + alumno.getApellido1() + " " + alumno.getApellido2());
            }
        }
    }

    boolean esCursoValido(String curso) {
        for (String cursoValido : CURSOS) {
            if (cursoValido.equals(curso)) {
                return true;
            }
        }
        return false;
    }

    public void mostrarAlumnos() {
        if (alumnos.isEmpty()) {
            System.out.println("No hay alumnos registrados.");
            return;
        }

        System.out.println("Lista de alumnos: "); // Este mensaje solo se imprime una vez

        for (Alumno alumno : alumnos) {
            System.out.println(alumno); // Imprime cada alumno
        }
    }

    public void mostrarProfesores() {
        if (profesores.isEmpty()) {
            System.out.println("No hay profesores registrados.");
            return;
        }

        System.out.println("Lista de profesores: ");

        for (Profesor profesor : profesores) {
            System.out.println(profesor);
        }
    }


    //INPUTS
    private  String input(String text) {
        System.out.println(text);
        return sc.nextLine();
    }

    private  Integer inputInt(String text) {
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

    private boolean inputBoolean(String mensaje) {
        try {

            if (mensaje == null || mensaje.trim().isEmpty()) {
                throw new IllegalArgumentException("La respuesta no puede estar vacía.");
            }

            while (true) {
                String respuesta = input(mensaje).trim().toLowerCase();
                if (respuesta.equals("true") || respuesta.equals("sí") || respuesta.equals("si")) {
                    return true;
                } else if (respuesta.equals("false") || respuesta.equals("no")) {
                    return false;
                } else {
                    System.out.println("Por favor, ingrese 'si' o 'no'.");
                }
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            return false;  // o podrías devolver true o relanzar la excepción dependiendo de cómo desees manejarlo
        }
    }


    private  Double inputDouble(String text) {
        double num = 0.0;
        boolean valido = false;
        do {
            try {
                System.out.println(text);
                num = Double.parseDouble(sc.nextLine());
                valido = true;
            } catch (NumberFormatException e) {
                System.out.println("Error: Se debe ingresar un número válido.");
            }
        } while (!valido);
        return num;
    }

    public static LocalDate inputLocalDate() {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        while (true) {
            System.out.println("Introduce una fecha de nacimiento en formato dd/MM/yyyy: ");
            String input = scanner.nextLine();

            try {
                return LocalDate.parse(input, formatter);
            } catch (Exception e) {
                System.out.println("La fecha ingresada no tiene un formato válido. Intenta de nuevo.");
            }
        }
    }


}





