package main.java.com.resuadam2.cli;

import java.sql.SQLException;
import java.util.Scanner;

public class ContactoCLI {
    private ContactoService contactoService;
    private Scanner scanner;

    public ContactoCLI() {
        contactoService = new ContactoService();
        scanner = new Scanner(System.in);
    }

    public void showMenu() throws SQLException {
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

            int option = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (option) {
                case 1:
                    contactoService.addContacto();
                    break;
                case 2:
                    contactoService.updateContacto();
                    break;
                case 3:
                    contactoService.deleteContacto();
                    break;
                case 4:
                    contactoService.listContactos();
                    break;
                case 5:
                    contactoService.searchContactoByNombre();
                    break;
                case 6:
                    contactoService.searchContactoByTelefono();
                    break;
                case 7:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    public void close() {
        contactoService.close();
        scanner.close();
    }


}