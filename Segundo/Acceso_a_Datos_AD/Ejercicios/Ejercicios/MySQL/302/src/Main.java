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

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String user = "root";
        String clave = "abc123.";
        String url = "jdbc:mysql://localhost:3306/";
        String bd = "empleados";
        Connection conn;

        try {
            conn = DriverManager.getConnection(url+bd, user, clave);




        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private static void infoBD (Connection conn) {

    }


public static String input(String text) {
        boolean textcorrect = false;
        String resultado;
        do {
            System.out.println(text);
            resultado = sc.nextLine();
            if (resultado.isEmpty()){
                System.out.println("Se debe ingresar algo.");
            } else {
                textcorrect = true;
            }
        }while (!textcorrect);
        return resultado;
    }

       import Connection;
       import DriverManager;
       import SQLException;
       import Level;
       import Logger;

       /**
        * TEMPLATE DE CONEXIÓN JDBC
        *
        * Este modelo permite conectar fácilmente a bases de datos MySQL o PostgreSQL.
        * Solo se deben editar las variables marcadas según el tipo de conexión.
        *
        * Ejemplo de uso:
        *   Connection conn = DBConnectionTemplate.getConnection();
        */
       public class DBConnectionTemplate {

           // ===============================
           // 🔧 CONFIGURACIÓN GENERAL
           // ===============================

           // 👉 Tipo de base de datos: "mysql" o "postgresql"
           private static final String DB_TYPE = "mysql";

           // 👉 Nombre del host o IP del servidor de base de datos
           private static final String HOST = "localhost";

           // 👉 Puerto por defecto:
           // MySQL → 3306
           // PostgreSQL → 5432
           private static final String PORT = "3306";

           // 👉 Nombre de la base de datos a conectar
           private static final String DATABASE = "nombre_de_tu_base";

           // 👉 Credenciales de acceso
           private static final String USER = "tu_usuario";
           private static final String PASSWORD = "tu_contraseña";

           // ===============================
           // ⚙️ MÉTODO DE CONEXIÓN
           // ===============================

           /**
            * Devuelve una conexión JDBC según el tipo de base de datos configurado.
            */
           public static Connection getConnection() {
               Connection conn = null;
               String url = "";

               try {
                   switch (DB_TYPE.toLowerCase()) {
                       case "mysql":
                           // Formato URL MySQL: jdbc:mysql://HOST:PORT/DATABASE
                           url = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE
                                   + "?useSSL=false&serverTimezone=UTC";
                           // Cargar driver de MySQL (opcional con JDBC 4.0+)
                           Class.forName("com.mysql.cj.jdbc.Driver");
                           break;

                       case "postgresql":
                           // Formato URL PostgreSQL: jdbc:postgresql://HOST:PORT/DATABASE
                           url = "jdbc:postgresql://" + HOST + ":" + PORT + "/" + DATABASE;
                           // Cargar driver de PostgreSQL (opcional con JDBC 4.0+)
                           Class.forName("org.postgresql.Driver");
                           break;

                       default:
                           throw new IllegalArgumentException("Tipo de base de datos no soportado: " + DB_TYPE);
                   }

                   conn = DriverManager.getConnection(url, USER, PASSWORD);
                   System.out.println("✅ Conexión exitosa a " + DB_TYPE.toUpperCase() + " → " + DATABASE);

               } catch (ClassNotFoundException ex) {
                   Logger.getLogger(DBConnectionTemplate.class.getName())
                         .log(Level.SEVERE, "❌ No se encontró el driver JDBC.", ex);
               } catch (SQLException ex) {
                   Logger.getLogger(DBConnectionTemplate.class.getName())
                         .log(Level.SEVERE, "❌ Error al conectar con la base de datos.", ex);
               }
               return conn;
           }

           /**
            * Cierra una conexión abierta de forma segura.
            */
           public static void closeConnection(Connection conn) {
               if (conn != null) {
                   try {
                       conn.close();
                       System.out.println("🔒 Conexión cerrada correctamente.");
                   } catch (SQLException ex) {
                       Logger.getLogger(DBConnectionTemplate.class.getName())
                             .log(Level.WARNING, "⚠️ Error al cerrar la conexión.", ex);
                   }
               }
           }
       }



}