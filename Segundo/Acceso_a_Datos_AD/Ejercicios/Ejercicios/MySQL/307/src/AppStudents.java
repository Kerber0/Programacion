import java.util.List;

public class AppStudents {
    static ManageStudents manage = new ManageStudents();

    final String opciones = """
            Seleccione la opción deseada:
            | 1 | MATRICULAR UN ESTUDIANTE.
            | 2 | DAR DE BAJA A UN ESTUDIANTE.
            | 3 | ACTUALIZAR DATOS DE UN ESTUDIANTE.
            | 4 | VER DATOS DE UN ESTUDIANTE.
            | 5 | VER DATOS DE TODOS LOS ESTUDIANTES.
            | 0 | SALIR.
            """;

    public static void main(String[] args) {
        AppStudents app = new AppStudents();
        manage.openConnection();
        app.menu();
    }

    private void menu() {
        System.out.println("Bienvenido a APPStudents");
        int opcion;
        do {
            opcion = Datos.inputInt(opciones);
            switch (opcion) {
                case 1 -> manage.addStudent(inputID());
                case 2 -> manage.deleteStudent();
                case 3 -> manage.modifyStudent();
                case 4 -> {
                    Student s = manage.getStudent();
                    if (s != null) {
                        System.out.println("ID: " + s.getId());
                        System.out.println("Nombre: " + s.getName());
                        System.out.println("Apellido: " + s.getSurname());
                        System.out.println("Edad: " + s.getAge());
                    }
                }
                case 5 -> {
                    List<Student> lista = manage.getStudentList();
                    for (Student s : lista) {
                        System.out.println("ID: " + s.getId() + ", Nombre: " + s.getName() +
                                ", Apellido: " + s.getSurname() + ", Edad: " + s.getAge());
                    }
                }
                case 0 -> System.out.println("Adiós!");
                default -> System.out.println("Opción errónea, pruebe otra vez.");
            }
        } while (opcion != 0);
        manage.closeConnection();
    }

    private String inputID() {
        return Datos.input("Ingrese el id del estudiante: ");
    }
}
