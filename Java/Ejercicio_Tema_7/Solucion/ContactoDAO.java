import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.io.InputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.util.logging.Logger;

public class ContactoDAO implements ContactoDAOInterface {
    private static final Logger LOGGER = Logger.getLogger(ContactoDAO.class.getName());
    private Connection connection;

    public ContactoDAO() {
        try {
            Properties properties = new Properties();
            InputStream input = new FileInputStream("contacto.properties");
            properties.load(input);
            String url = properties.getProperty("db.url");
            String user = properties.getProperty("db.user");
            String password = properties.getProperty("db.password");
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addContacto(Contacto contacto) {
        String sql = "INSERT INTO contactos (nombre, apellido, telefono, correo) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, contacto.getNombre());
            pstmt.setString(2, contacto.getApellido());
            pstmt.setString(3, contacto.getTelefono());
            pstmt.setString(4, contacto.getCorreo());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateContacto(Contacto contacto) {
        String sql = "UPDATE contactos SET nombre = ?, apellido = ?, telefono = ?, correo = ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, contacto.getNombre());
            pstmt.setString(2, contacto.getApellido());
            pstmt.setString(3, contacto.getTelefono());
            pstmt.setString(4, contacto.getCorreo());
            pstmt.setInt(5, contacto.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteContacto(int id) {
        String sql = "DELETE FROM contactos WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Contacto> getAllContactos() {
        List<Contacto> contactos = new ArrayList<>();
        String sql = "SELECT * FROM contactos";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Contacto contacto = new Contacto(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("telefono"), rs.getString("correo"));
                contactos.add(contacto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contactos;
    }

    @Override
    public Contacto getContactoById(int id) {
        String sql = "SELECT * FROM contactos WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Contacto(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("telefono"), rs.getString("correo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Contacto> getContactosByNombre(String nombre) {
        List<Contacto> contactos = new ArrayList<>();
        String sql = "SELECT * FROM contactos WHERE nombre LIKE ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, "%" + nombre + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Contacto contacto = new Contacto(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("telefono"), rs.getString("correo"));
                contactos.add(contacto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contactos;
    }

    @Override
    public List<Contacto> getContactosByTelefono(String telefono) {
        List<Contacto> contactos = new ArrayList<>();
        String sql = "SELECT * FROM contactos WHERE telefono LIKE ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, "%" + telefono + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Contacto contacto = new Contacto(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("telefono"), rs.getString("correo"));
                contactos.add(contacto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contactos;
    }

    public void close() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}