import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public interface  Generador {
    Random random = new Random();
    String[] NOMBRES_MATERIAS = {
            "Matemáticas", "Física", "Química", "Historia", "Lengua",
            "Biología", "Geografía", "Inglés", "Programación", "Arte"
    };

     String[] NOMBRES = {
            "Carlos", "Laura", "Pedro", "Ana", "Javier", "Marta", "Luis", "Elena",
            "Fernando", "Sofía", "Diego", "Valeria", "Andrés", "Camila", "Rubén"
    };

       String[] APELLIDOS = {
            "García", "Fernández", "López", "Martínez", "Rodríguez", "Sánchez", "Pérez",
            "Gómez", "Díaz", "Torres", "Ramírez", "Navarro", "Molina", "Ortega", "Delgado"
    };

       String[] CURSOS = {
            "1° ESO", "2° ESO", "3° ESO", "4° ESO", "1° Bachillerato", "2° Bachillerato"
    };





     static Profesor generarProfesor() {
        String nombre = NOMBRES[random.nextInt(NOMBRES.length)];
        String apellido1 = APELLIDOS[random.nextInt(APELLIDOS.length)];
        String apellido2 = APELLIDOS[random.nextInt(APELLIDOS.length)];
        LocalDate fechaNacimiento = generarFechaNacimiento(30, 65);
        String dni = generarDni();
        int salario = random.nextInt(2000) + 1800; // Entre 1800€ y 3800€

        return new Profesor(nombre, apellido1, apellido2, fechaNacimiento, dni, salario);
    }

    static Alumno generarAlumno() {
        String nombre = NOMBRES[random.nextInt(NOMBRES.length)];
        String apellido1 = APELLIDOS[random.nextInt(APELLIDOS.length)];
        String apellido2 = APELLIDOS[random.nextInt(APELLIDOS.length)];
        LocalDate fechaNacimiento = generarFechaNacimiento(12, 18);
        String dni = generarDni();

        int edad = LocalDate.now().getYear() - fechaNacimiento.getYear();

        String curso;
        if (edad == 12) {
            curso = "1° ESO";
        } else if (edad == 13) {
            curso = "2° ESO";
        } else if (edad == 14) {
            curso = "3° ESO";
        } else if (edad == 15) {
            curso = "4° ESO";
        } else if (edad == 16) {
            curso = "1° Bachillerato";
        } else {
            curso = "2° Bachillerato";
        }

        ArrayList<Materias> notas = new ArrayList<>(generarMaterias(5));

        return new Alumno(nombre, apellido1, apellido2, fechaNacimiento, dni, curso, notas);
    }

    default String asignarCurso(int edad){
        String curso;
        if (edad == 12) {
            curso = "1° ESO";
        } else if (edad == 13) {
            curso = "2° ESO";
        } else if (edad == 14) {
            curso = "3° ESO";
        } else if (edad == 15) {
            curso = "4° ESO";
        } else if (edad == 16) {
            curso = "1° Bachillerato";
        } else {
            curso = "2° Bachillerato";
        }
        return curso;
    }

    private static LocalDate generarFechaNacimiento(int edadMin, int edadMax) {
        int edad = random.nextInt(edadMax - edadMin + 1) + edadMin;
        return LocalDate.now().minusYears(edad).withDayOfYear(random.nextInt(365) + 1);
    }

    private static String generarDni() {
        int numero = 10000000 + random.nextInt(90000000);
        char letra = "TRWAGMYFPDXBNJZSQVHLCKE".charAt(numero % 23);
        return numero + "" + letra;
    }

    static String validarDNI(String dni) {
        Scanner sc = new Scanner(System.in);
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        boolean dniValido = false;


        if (dni == null || dni.isEmpty()) {
            do {
                System.out.print("Ingrese su DNI (8 números + 1 letra): ");
                dni = sc.nextLine().toUpperCase();

                if (!dni.matches("\\d{8}[A-Z]")) {
                    System.out.println("Formato incorrecto. El DNI debe tener 8 números seguidos de 1 letra.");
                    continue;
                }


                int numero = Integer.parseInt(dni.substring(0, 8));
                char letraCorrecta = letras.charAt(numero % 23);

                if (dni.charAt(8) == letraCorrecta) {
                    dniValido = true;
                } else {
                    System.out.println("La letra del DNI no es correcta. Intente de nuevo.");
                }

            } while (!dniValido);
        }
        sc.close();
        return dni;
    }


     static List<Materias> generarMaterias(int cantidad) {
        List<Materias> listaMaterias = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < cantidad; i++) {
            String nombre = NOMBRES_MATERIAS[random.nextInt(NOMBRES_MATERIAS.length)];
            int nota1 = random.nextInt(11);
            int nota2 = random.nextInt(11);
            int nota3 = random.nextInt(11);


            listaMaterias.add(new Materias(nombre, nota1, nota2, nota3));
        }
        return listaMaterias;
    }

}
