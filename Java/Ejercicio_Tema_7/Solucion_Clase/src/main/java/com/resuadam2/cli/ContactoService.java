package main.java.com.resuadam2.cli;




import main.java.com.resuadam2.bbdd.ContactoDAOImpl;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;


public class ContactoService {
    private ContactoDAOImpl contactoDAO;
    private Scanner scanner;

    public ContactoService() {
        contactoDAO = new ContactoDAOImpl();
        scanner = new Scanner(System.in);
    }

    public void addContacto() throws SQLException {
        System.out.println("Añadir nuevo contacto:");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();
        System.out.print("Correo electrónico: ");
        String correo = scanner.nextLine();

        com.resuadam2.model.Contacto contacto = new com.resuadam2.model.Contacto(0, nombre, apellido, telefono, correo);
        contactoDAO.addContacto(contacto);
        System.out.println("Contacto añadido correctamente.");
    }

    public void updateContacto() {
        System.out.println("Modificar contacto:");
        System.out.print("ID del contacto a modificar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        com.resuadam2.model.Contacto contacto = contactoDAO.getContactoById(id);
        if (contacto == null) {
            System.out.println("Contacto no encontrado.");
            return;
        }

        System.out.print("Nuevo nombre (actual: " + ((com.resuadam2.model.Contacto) contacto).getNombre() + "): ");
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

        com.resuadam2.model.Contacto contacto = contactoDAO.getContactoById(id);
        if (contacto == null) {
            System.out.println("Contacto no encontrado.");
            return;
        }

        contactoDAO.deleteContacto(id);
        System.out.println("Contacto eliminado correctamente.");
    }

    public void listContactos() {
        System.out.println("Lista de contactos:");
        List<com.resuadam2.model.Contacto> contactos = contactoDAO.getAllContactos();
        for (com.resuadam2.model.Contacto contacto : contactos) {
            System.out.println(contacto);
        }
    }

    public void searchContactoByNombre() {
        System.out.println("Buscar contacto por nombre:");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        List<com.resuadam2.model.Contacto> contactos = contactoDAO.getContactosByNombre(nombre);
        if (contactos.isEmpty()) {
            System.out.println("No se encontraron contactos con ese nombre.");
            return;
        }
        for (com.resuadam2.model.Contacto contacto : contactos) {
            System.out.println(contacto);
        }
    }

    public void searchContactoByTelefono() {
        System.out.println("Buscar contacto por teléfono:");
        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();
        List<com.resuadam2.model.Contacto> contactos = contactoDAO.getContactosByTelefono(telefono);
        if (contactos.isEmpty()) {
            System.out.println("No se encontraron contactos con ese teléfono.");
            return;
        }
        for (com.resuadam2.model.Contacto contacto : contactos) {
            System.out.println(contacto);
        }
    }

    public void close() {
        contactoDAO.close();
        scanner.close();
    }

}