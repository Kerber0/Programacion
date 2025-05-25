import java.util.List;

public interface ContactoDAOInterface {
    void addContacto(Contacto contacto);
    void updateContacto(Contacto contacto);
    void deleteContacto(int id);
    List<Contacto> getAllContactos();
    Contacto getContactoById(int id);
    List<Contacto> getContactosByNombre(String nombre);
    List<Contacto> getContactosByTelefono(String telefono);
}
