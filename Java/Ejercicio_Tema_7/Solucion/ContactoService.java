
import java.util.List;
import java.util.Scanner;


public class ContactoService {
    private ContactoDAO contactoDAO;
    private Scanner scanner;

    public ContactoService() {
        contactoDAO = new ContactoDAO();
        scanner = new Scanner(System.in);
    }

    public void addContacto() {
        System.out.println("Añadir nuevo contacto:");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();
        System.out.print("Correo electrónico: ");
        String correo = scanner.nextLine();

        Contacto contacto = new Contacto(0, nombre, apellido, telefono, correo);
        contactoDAO.addContacto(contacto);
        System.out.println("Contacto añadido correctamente.");
    }

    public void updateContacto() {
        System.out.println("Modificar contacto:");
        System.out.print("ID del contacto a modificar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        Contacto contacto = contactoDAO.getContactoById(id);
        if (contacto == null) {
            System.out.println("Contacto no encontrado.");
            return;
        }

        System.out.print("Nuevo nombre (actual: " + contacto.getNombre() + "): ");
        String nombre = scanner.nextLine();
        System.out.print("Nuevo apellido (actual: " + contacto.getApellido() + "): ");
        String apellido = scanner.nextLine();
        System.out.print("Nuevo teléfono (actual: " + contacto.getTelefono() + "): ");
        String telefono = scanner.nextLine();
        System.out.print("Nuevo correo electrónico (actual: " + contacto.getCorreo() + "): ");
        String correo = scanner.nextLine();

        contacto.setNombre(nombre);
        contacto.setApellido(apellido);
        contacto.setTelefono(telefono);
        contacto.setCorreo(correo);

        contactoDAO.updateContacto(contacto);
        System.out.println("Contacto modificado correctamente.");
    }

    public void deleteContacto() {
        System.out.println("Eliminar contacto:");
        System.out.print("ID del contacto a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        Contacto contacto = contactoDAO.getContactoById(id);
        if (contacto == null) {
            System.out.println("Contacto no encontrado.");
            return;
        }

        contactoDAO.deleteContacto(id);
        System.out.println("Contacto eliminado correctamente.");
    }

    public void listContactos() {
        System.out.println("Lista de contactos:");
        List<Contacto> contactos = contactoDAO.getAllContactos();
        for (Contacto contacto : contactos) {
            System.out.println(contacto);
        }
    }

    public void searchContactoByNombre() {
        System.out.println("Buscar contacto por nombre:");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        List<Contacto> contactos = contactoDAO.getContactosByNombre(nombre);
        if (contactos.isEmpty()) {
            System.out.println("No se encontraron contactos con ese nombre.");
            return;
        }
        for (Contacto contacto : contactos) {
            System.out.println(contacto);
        }
    }

    public void searchContactoByTelefono() {
        System.out.println("Buscar contacto por teléfono:");
        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();
        List<Contacto> contactos = contactoDAO.getContactosByTelefono(telefono);
        if (contactos.isEmpty()) {
            System.out.println("No se encontraron contactos con ese teléfono.");
            return;
        }
        for (Contacto contacto : contactos) {
            System.out.println(contacto);
        }
    }

    public void close() {
        contactoDAO.close();
        scanner.close();
    }

    public static void main(String[] args) {
        ContactoService service = new ContactoService();
        boolean exit = false;
        while (!exit) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Añadir contacto");
            System.out.println("2. Modificar contacto");
            System.out.println("3. Eliminar contacto");
            System.out.println("4. Listar contactos");
            System.out.println("5. Buscar contacto por nombre");
            System.out.println("6. Buscar contacto por teléfono");
            System.out.println("7. Salir");

            int option = service.scanner.nextInt();
            service.scanner.nextLine(); // Limpiar el buffer

            switch (option) {
                case 1:
                    service.addContacto();
                    break;
                case 2:
                    service.updateContacto();
                    break;
                case 3:
                    service.deleteContacto();
                    break;
                case 4:
                    service.listContactos();
                    break;
                case 5:
                    service.searchContactoByNombre();
                    break;
                case 6:
                    service.searchContactoByTelefono();
                    break;
                case 7:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
        service.close();
    }
}