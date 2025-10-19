/*
Dada la siguiente base de datos de empleados se pide desarrollar un programa Java que se conecte a la base de datos utilizando el usuario root y la contraseña abc123. y permita:

Mostrar la información de la base de datos.
Mostrar la información de la tabla proyectos.
Insertar un nuevo proyecto con los siguientes datos (11, 'Acceso a datos', 'Lugo', 3) en la tabla proyecto.
Eliminar una fila de la tabla proyecto a partir de su número de proyecto numproy.
NOTA: Sería conveniente crear una función independiente para cada una de las funcionalidades de forma que se puedan reutilizar en un futuro. NOTA: Será importante gestionar los posibles errores que pueda generar el código.

Información adicional
Algunas de las clases qeu se deberían utilizar para implementar este ejercicio son:

Statement: para gestionar las consultas
PreparedStatement: para poder reutilizar consultas.
SQLException: para gestionar las excepciones
 */


import java.sql.*;


public class Main {


    public static void main(String[] args) {
        String user = "root";
        String clave = "abc123";
        String url = "jdbc:mysql://localhost:3306/";
        String bd = "empleados";
        Connection conn;

        try {
            conn = DriverManager.getConnection(url+bd, user, clave);
            infoBD(conn);
            System.out.println(" ");
            infoProyectos(conn);
            deleteProyecto(conn, 11);
            System.out.println(" ");
            insertProyecto(conn, 11, "Bases de datos", "Lugo", 3);
            System.out.println(" ");
            infoProyectos(conn);
            System.out.println(" ");
            deleteProyecto(conn, 11);
            System.out.println(" ");
            infoProyectos(conn);




        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




    private static void infoBD(Connection conn) {
        try {
            DatabaseMetaData dbmd = conn.getMetaData();
            String gestor = dbmd.getDatabaseProductName();
            String conector = dbmd.getDriverName();
            String url = dbmd.getURL();
            String usuario = dbmd.getUserName();

            System.out.println("Informacion de base de datos: ");
            System.out.println( "-----------------------------");
            System.out.println("*Gestor : " + gestor);
            System.out.println("*Conector : " + conector);
            System.out.println("*URL : " + url);
            System.out.println("*Usiaurio : " + usuario);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    private static void infoProyectos(Connection conn) {
        Statement st;
        ResultSet rs;
        String sql = "SELECT * from proyecto;";
        try {
           st = conn.createStatement();
           rs = st.executeQuery(sql);
           while (rs.next()) {
               System.out.println("Numero: " + rs.getInt("Numproy") +
                       ", Nombre: " + rs.getString("Nombreproy") +
                       ", Lugar: " + rs.getString("Lugarproy") +
                       ", Departamento: " + rs.getInt("departamento_Numdep"));
           };
           st.close();
           rs.close();

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertProyecto(Connection conn, int num, String nombre, String lugar, int depto) {
        String sql = "INSERT INTO proyecto VALUES (?, ?, ?, ?);";
        try (PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, num);
            ps.setString(2, nombre);
            ps.setString(3, lugar);
            ps.setInt(4, depto);
            int numTuplas = ps.executeUpdate();
            System.out.println("Sentencia: " + ps);
            System.out.println("Tuplas afectadas: " + numTuplas);

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private static void deleteProyecto(Connection conn, int num) {
        String sql = "DELETE FROM  proyecto WHERE Numproy = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, num);
            int numTuplas = ps.executeUpdate();
            System.out.println("Sentencia: " + ps);
            System.out.println("Tuplas afectadas: " + numTuplas);

        }catch (SQLException e) {
            e.printStackTrace();
        }



    }



}