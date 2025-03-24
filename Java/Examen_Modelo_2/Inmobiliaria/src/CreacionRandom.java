import java.util.Random;

public class CreacionRandom {
    private static final Random random = new Random();
    private static final String[] NOMBRES = {
            "Juan", "María", "Carlos", "Ana", "Luis", "Sofía", "Pedro", "Elena", "Miguel", "Lucía",
            "Javier", "Carmen", "José", "Isabel", "Fernando", "Laura", "Andrés", "Marta", "Diego", "Paula"
    };
    private static final String[] APELLIDOS = {
            "Gómez", "Pérez", "Rodríguez", "Fernández", "López", "Díaz", "Martínez", "García", "Sánchez", "Romero",
            "Torres", "Ramírez", "Flores", "Acosta", "Morales", "Herrera", "Rojas", "Castro", "Ortiz", "Silva"
    };
    private static final String[] DIRECCIONES = {
            "Calle 1", "Calle 2", "Avenida 3", "Boulevard 4", "Plaza 5", "Camino 6", "Ruta 7", "Pasaje 8", "Vereda 9", "Sendero 10"
    };
    private static final String[] ZONAS = {"Centro", "Comercial", "Residencial", "Industrial"};
    private static int idCounter = 1;

    public static Casa generarCasa() {
        return new Casa(
                idCounter++,
                DIRECCIONES[random.nextInt(DIRECCIONES.length)],
                50000 + (500000 - 50000) * random.nextDouble(),
                50 + (200 - 50) * random.nextDouble(),
                random.nextInt(5) + 1,
                10 + (100 - 10) * random.nextDouble()
        );
    }

    public static Departamento generarDepartamento() {
        return new Departamento(
                idCounter++,
                DIRECCIONES[random.nextInt(DIRECCIONES.length)],
                50000 + (300000 - 50000) * random.nextDouble(),
                30 + (150 - 30) * random.nextDouble(),
                random.nextInt(20) + 1,
                Character.toString((char) ('A' + random.nextInt(26))),
                5000 + (20000 - 5000) * random.nextDouble(),
                random.nextBoolean(),
                random.nextBoolean()
        );
    }

    public static LocalComercial generarLocalComercial() {
        return new LocalComercial(
                idCounter++,
                DIRECCIONES[random.nextInt(DIRECCIONES.length)],
                100000 + (800000 - 100000) * random.nextDouble(),
                20 + (500 - 20) * random.nextDouble(),
                ZONAS[random.nextInt(ZONAS.length)],
                random.nextBoolean()
        );
    }

    public static Cliente generarCliente() {
        String nombre = NOMBRES[random.nextInt(NOMBRES.length)];
        String apellido1 = APELLIDOS[random.nextInt(APELLIDOS.length)];
        String apellido2 = APELLIDOS[random.nextInt(APELLIDOS.length)];

        int numeroDNI = random.nextInt(100000000);

        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        char letraDNI = letras.charAt(numeroDNI % 23);

        String dni = String.format("%08d%c", numeroDNI, letraDNI);

        return new Cliente(nombre, apellido1, apellido2, dni);
    }

}

