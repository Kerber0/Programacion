import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ManageStudents {
    private static Connection connection;
    private static final String user = "root";
    private static final String clave = "abc123";
    private static final String url = "jdbc:mysql://localhost:3306/school";

    static void openConnection() {
        try {
            connection = DriverManager.getConnection(url, user, clave);
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
        try (PreparedStatement ps = this.connection.prepareStatement(
                "DELETE FROM student WHERE id = ?")) {
            ps.setString(1, id);

            if (ps.executeUpdate() > 0) {
                System.out.println("El alumno se ha eliminado correctamente.");
            } else {
                System.out.println("No se encontró un alumno con ese ID.");
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void modifyStudent() {
        String id = Datos.input("Ingrese el id del estudiante a modificar: ");
        Student s = null;

        try (PreparedStatement ps = this.connection.prepareStatement(
                "SELECT * FROM student WHERE id = ?")) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    s = new Student(rs.getString("id"),
                            rs.getString("name"),
                            rs.getString("surname"),
                            rs.getInt("age"));
                } else {
                    System.out.println("No se encontró un estudiante con ese ID.");
                    return;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }

        System.out.println("Deje vacío si no quiere cambiar el campo.");
        String nuevoNombre = Datos.input("Nombre actual: " + s.getName() + " - Nuevo nombre:");
        String nuevoApellido = Datos.input("Apellido actual: " + s.getSurname() + " - Nuevo apellido:");
        String nuevaEdadStr = Datos.input("Edad actual: " + s.getAge() + " - Nueva edad:");

        if (!nuevoNombre.isEmpty()) s.setName(nuevoNombre);
        if (!nuevoApellido.isEmpty()) s.setSurname(nuevoApellido);
        if (!nuevaEdadStr.isEmpty()) s.setAge(Integer.parseInt(nuevaEdadStr));

        try (PreparedStatement ps = this.connection.prepareStatement(
                "UPDATE student SET name = ?, surname = ?, age = ? WHERE id = ?")) {
            ps.setString(1, s.getName());
            ps.setString(2, s.getSurname());
            ps.setInt(3, s.getAge());
            ps.setString(4, s.getId());

            if (ps.executeUpdate() > 0) {
                System.out.println("Estudiante modificado correctamente.");
            } else {
                System.out.println("No se pudo modificar el estudiante.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
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
        ArrayList<Student> listaEstudiantes = new ArrayList<>();
        try (PreparedStatement ps = this.connection.prepareStatement("SELECT * FROM student");
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                listaEstudiantes.add(new Student(rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getInt("age")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaEstudiantes;
    }
}
