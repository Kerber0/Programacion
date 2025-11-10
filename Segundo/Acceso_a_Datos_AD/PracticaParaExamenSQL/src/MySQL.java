import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQL {

        private static Connection connection;
        private final String usuario = "root";
        private final String clave = "abc123.";
        private final String url ="jdbc:mysql://localhost:3306/school";

        private Database(){
            try {
                this.connection = DriverManager.getConnection(url, usuario, clave);
            }catch(SQLException sqle) {
                System.out.println("Error al abrir la conexión");
            }
        }

        // El método estático que controla el acceso a la instancia
        // singleton.
        public static Connection getInstance(){
            if (Database.connection == null)
                new Database();
            return Database.connection;
        }
    }

}
