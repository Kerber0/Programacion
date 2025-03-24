import java.util.Scanner;

public class Cliente {
    private String nombre;
    private final String apellido1;
    private final String apellido2;
    private String dni;

    public Cliente(String nombre, String apellido1, String apellido2, String dni) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.dni = validarDNI(dni);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellido1 + " " + apellido2;
    }


    public String getDni() {
        return dni;
    }

    public static String validarDNI(String dni) {
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

        return dni;
    }

    @Override
    public String toString() {
        return "Nombre completo: " + nombre + ", " +
                apellido1 + " " + apellido2 + ". " +
                "DNI: " + dni
                ;
    }
}
