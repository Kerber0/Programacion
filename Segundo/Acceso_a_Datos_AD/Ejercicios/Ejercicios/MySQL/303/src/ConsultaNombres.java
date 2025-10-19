import java.sql.*;
import java.util.Scanner;

public class ConsultaNombres {
   static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
        String user = "root";
        String clave = "abc123";
        String url = "jdbc:mysql://localhost:3306/";
        String bd = "empleados";
        Connection conn;

        try {
            conn = DriverManager.getConnection(url+bd, user, clave);
            String letra = input("Introduczca la inicial a buscar");
            String sql = "SELECT * FROM empleado WHERE nombre like ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, letra+"%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("nombre"));
            }

            rs.close();
            ps.close();

        }catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public static String input(String text) {
            boolean textcorrect = false;
            String resultado;
            do {
                System.out.println(text);
                resultado = sc.nextLine().trim();
                if (resultado.length() != 1 || !Character.isLetter(resultado.charAt(0))){
                    System.out.println("Se debe ingresar la letra inicial del nombre.");
                } else {
                    textcorrect = true;
                }
            }while (!textcorrect);
            return resultado.toUpperCase();
        }


}
