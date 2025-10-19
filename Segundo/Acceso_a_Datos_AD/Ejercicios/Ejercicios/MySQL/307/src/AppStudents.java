import java.util.Scanner;

public class AppStudents {
    static Scanner sc = new Scanner(System.in);
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
        System.out.println("🎓 Bienvenido a APPStudents");
        int opcion;
        do {
            opcion = Datos.inputInt(opciones);
            switch (opcion) {
                case 1 -> manage.addStudent(inputID());
                case 2 -> manage.deleteStudent();
                case 3 -> manage.modifyStudent();
                case 4 -> manage.getStudent();
                case 5 -> manage.getStudentList();
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
