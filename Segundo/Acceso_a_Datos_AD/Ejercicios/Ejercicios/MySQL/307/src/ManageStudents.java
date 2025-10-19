import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ManageStudents {
    private Connection connection;
    private final String user = "root";
    private final String clave = "abc123";
    private final String url = "jdbc:mysql://localhost:3306/school";

    void openConnection() {
        try {
            this.connection = DriverManager.getConnection(url, user, clave);
            System.out.println("Conexión establecida correctamente.");
        } catch (SQLException e) {
            System.out.println("Error en la conexión.");
            e.printStackTrace();
        }
    }

    void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Conexión cerrada.");
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión.");
            e.printStackTrace();
        }
    }

    public boolean addStudent(String id) {
        boolean agregado = false;
        int opcion;

        do {
            opcion = Datos.inputInt("Seleccione 1 para ingresar un nuevo estudiante o 0 para volver:");

            if (opcion == 1) {
                Student nuevo = createStudent();

                try (PreparedStatement ps = this.connection.prepareStatement(
                        "INSERT INTO student (id, name, surname, age) VALUES (?, ?, ?, ?)")) {

                    ps.setString(1, nuevo.getId());
                    ps.setString(2, nuevo.getName());
                    ps.setString(3, nuevo.getSurname());
                    ps.setInt(4, nuevo.getAge());

                    if (ps.executeUpdate() > 0) {
                        System.out.println("Estudiante agregado correctamente.");
                        agregado = true;
                    }

                } catch (SQLException e) {
                    System.out.println("Error al agregar estudiante:");
                    e.printStackTrace();
                }
            }

        } while (opcion != 0);

        return agregado;
    }

    private Student createStudent() {
        String id = Datos.input("Ingrese el ID del nuevo estudiante:");
        String name = Datos.input("Ingrese el nombre del nuevo estudiante:");
        String surname = Datos.input("Ingrese el apellido del nuevo estudiante:");
        int age = Datos.inputInt("Ingrese la edad del nuevo estudiante:");
        return new Student(id, name, surname, age);
    }

    public boolean deleteStudent() {
        String id = Datos.input("Ingrese el id del alumno a borrar: ");
        try {
            PreparedStatement ps = this.connection.prepareStatement("DELETE FROM student WHERE id = ?");
            ps.setString(1, id);

            if (ps.executeUpdate() > 0) {
                System.out.println("El alumno se ha eliminado correctamente.");
            } else {
                System.out.println("Error al eliminar el alumno.");
            }

        }catch (SQLException e) {
            e.printStackTrace();
            closeConnection();
            return false;
        }
        return true;
    }

    public void modifyStudent() {

    }

    public Student getStudent() {
        getStudentList();
        String id = Datos.input("Ingrese el id del estudiante: ");

        try (PreparedStatement ps = this.connection.prepareStatement(
                "SELECT * FROM student WHERE id = ?")) {

            ps.setString(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Student(
                            rs.getString("id"),
                            rs.getString("name"),
                            rs.getString("surname"),
                            rs.getInt("age")
                    );
                } else {
                    System.out.println("No se encontró un estudiante con ese ID.");
                    return null;
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al buscar el estudiante:");
            e.printStackTrace();
            return null;
        }
    }


    public List<Student> getStudentList() {
        try {
            PreparedStatement ps = this.connection.prepareStatement("SELECT * FROM student");
            ResultSet rs = ps.executeQuery();

            ArrayList<Student> listaEstudiantes = new ArrayList<Student>();
            while (rs.next()) {
                listaEstudiantes.add(new Student(rs.getString("id"), rs.getString("name"),
                        rs.getString("surname"),rs.getInt("age")));
            }
            return listaEstudiantes;


        } catch (SQLException e) {
            e.printStackTrace();
            closeConnection();
            return new ArrayList<Student>();
        }
    }
}
