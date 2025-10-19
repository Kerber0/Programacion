import java.sql.*;
import java.util.Scanner;

public class BorradoEmpleados {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String user = "root";
        String clave = "abc123";
        String url = "jdbc:mysql://localhost:3306/";
        String bd = "empleados";

        try (Connection conn = DriverManager.getConnection(url + bd, user, clave);
             Statement stm = conn.createStatement();
             PreparedStatement ps = conn.prepareStatement("DELETE FROM empleado WHERE NSS = ?")) {

            int numero = inputInt("Introduzca el número del empleado que desea borrar:");

            // Desactivamos las foreign keys
            stm.execute("SET FOREIGN_KEY_CHECKS=0");

            // Ejecutamos el borrado
            ps.setInt(1, numero);
            int numTuplas = ps.executeUpdate();

            System.out.println("Sentencia: " + ps);
            System.out.println("Tuplas afectadas: " + numTuplas);

            // Volvemos a activar las foreign keys
            stm.execute("SET FOREIGN_KEY_CHECKS=1");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static int inputInt(String text) {
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
