import java.sql.*;

public class TransaccionEmpleado {

    public static void main(String[] args) {
        String usuario = "root";
        String clave = "abc123";
        String url = "jdbc:mysql://localhost:3306/empleados";

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, usuario, clave);
            conn.setAutoCommit(false); // desactivamos autocommit

            try (PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO empleado(NSS, Nombre, Numdept) VALUES (?, ?, ?)")) {

                ps.setInt(1, 1);
                ps.setString(2, "Pedro");
                ps.setInt(3, 1);
                ps.executeUpdate();

                ps.setInt(1, 2);
                ps.setString(2, "Lucia");
                ps.setInt(3, 2);
                ps.executeUpdate();

                ps.setInt(1, 3);
                ps.setString(2, "Daniel");
                ps.setInt(3, 3);
                ps.executeUpdate();

                conn.commit(); // si todo sale bien, confirmamos
                System.out.println("Todos los datos han sido introducidos");
            }

        } catch (SQLException ex) {
            System.out.println("Ocurrió un error, deshaciendo transacción...");
            try {
                if (conn != null) {
                    conn.rollback(); // rollback directo en el catch
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ex.printStackTrace(); // mostramos el error original
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
