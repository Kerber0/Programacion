package main.java.com.resuadam2.bbdd;

import com.resuadam2.model.Contacto;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

interface ContactoDAO {
    void addContacto(Contacto contacto) throws SQLException;
    void updateContacto(Contacto contacto);
    void deleteContacto(int id);
    List<Contacto> getAllContactos();
    Contacto getContactoById(int id);
    List<Contacto> getContactosByNombre(String nombre);
    List<Contacto> getContactosByTelefono(String telefono);
}

public class ContactoDAOImpl implements ContactoDAO {
    private Connection connection;

    private static final String PATH_PROPERTIES = "contacto.properties";
    private static final String URL_KEY = "db.url";
    private static final String USER_KEY = "db.user";
    private static final String PASS_KEY = "db.password";

    private static final String TABLE_CREATION_SQL = "" +
            "CREATE TABLE contactos (\n" +
            "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "    nombre TEXT NOT NULL,\n" +
            "    apellido TEXT NOT NULL,\n" +
            "    telefono TEXT NOT NULL,\n" +
            "    correo TEXT NOT NULL\n" +
            ");";

    private static final String ID_COL_NAME = "id";
    private static final String NAME_COL_NAME = "nombre";
    private static final String SURNAME_COL_NAME = "apellido";
    private static final String TELF_COL_NAME = "telefono";
    private static final String EMAIL_COL_NAME = "correo";




    public ContactoDAOImpl() {

        Properties properties = new Properties();
        try(InputStream input = new FileInputStream(PATH_PROPERTIES)) {
            properties.load(input);
            String url = properties.getProperty(URL_KEY);
            String user = properties.getProperty(USER_KEY);
            String pass = properties.getProperty(PASS_KEY);
            connection = DriverManager.getConnection(url, user, pass);
            try(Statement st = connection.createStatement()) {
                st.executeUpdate(TABLE_CREATION_SQL);
            }
        } catch (FileNotFoundException e) {
            System.out.println("ERROR CREANDO LA CONEXIÓN FILE NOT FOUND");
        } catch (IOException e) {
            System.out.println("ERROR CREANDO LA CONEXIÓN IO EXC");
        } catch (SQLException e) {
            System.out.println("ERROR CREANDO LA CONEXIÓN SQL EXC");
        }
    }

    @Override
    public void addContacto(Contacto contacto) throws SQLException {
        String sql = "INSERT INTO contactos (nombre, apellido, telefono, correo) VALUES (?,?,?,?)";
        try(PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, contacto.getNombre());
            ps.setString(2, contacto.getApellido());
            ps.setString(3, contacto.getTelefono());
            ps.setString(4, contacto.getCorreo());
            ps.executeUpdate();
        }
    }

    public void addContactoModificaId(Contacto contacto) throws SQLException {
        String sql = "INSERT INTO contactos (nombre, apellido, telefono, correo) VALUES (?,?,?,?)";
        try(PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, contacto.getNombre());
            ps.setString(2, contacto.getApellido());
            ps.setString(3, contacto.getTelefono());
            ps.setString(4, contacto.getCorreo());
            ps.executeUpdate();
            try(ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    contacto.setId(rs.getInt(1));
                }
            }
        }
    }

    public void addContactoVariante(Contacto contacto) throws SQLException {
        String sql = "INSERT INTO contactos (nombre, apellido, telefono, correo) VALUES (?,?,?,?)";
        if (contacto.getNombre().isBlank() || contacto.getApellido().isBlank()) {
            throw new SQLIntegrityConstraintViolationException();
        } else {
            try(PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, contacto.getNombre());
                ps.setString(2, contacto.getApellido());
                ps.setString(3, contacto.getTelefono());
                ps.setString(4, contacto.getCorreo());
                ps.executeUpdate();
            }
        }
    }

    @Override
    public void updateContacto(Contacto contacto) {
        String sql = "UPDATE contactos SET nombre = ?, apellido = ?, telefono = ?, correo = ? WHERE id = ?";
        try(PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, contacto.getNombre());
            ps.setString(2, contacto.getApellido());
            ps.setString(3, contacto.getTelefono());
            ps.setString(4, contacto.getCorreo());
            ps.setInt(5, contacto.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ERROR AL HACER EL UPDATE EN BD");
        }
    }

    @Override
    public void deleteContacto(int id) {
        String sql = "DELETE FROM contactos WHERE id = ?";
        try(PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ERROR EN DELETE BD");
        }
    }

    public boolean deleteContactoVariante(int id) {
        String sql = "DELETE FROM contactos WHERE id = ?";
        try(PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            int afectadas = ps.executeUpdate();
            if (afectadas != 1) return false;
            else return true;
        } catch (SQLException e) {
            System.out.println("ERROR EN DELETE BD");
            return false;
        }
    }

    @Override
    public List<Contacto> getAllContactos() {
        List<Contacto> contactos = new ArrayList<>();
        String sql = "SELECT * FROM contactos";
        try (Statement st = connection.createStatement();
                ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Contacto contacto = new Contacto(
                        rs.getInt(ID_COL_NAME),
                        rs.getString(NAME_COL_NAME),
                        rs.getString(SURNAME_COL_NAME),
                        rs.getString(TELF_COL_NAME),
                        rs.getString(EMAIL_COL_NAME)
                );
                contactos.add(contacto);
            }
        } catch (SQLException e) {
            System.out.println("ERROR EN GETALL EN BD");
        }
        return contactos;
    }

    @Override
    public Contacto getContactoById(int id) {
        String sql = "SELECT * FROM contactos WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Contacto(
                        rs.getInt(ID_COL_NAME),
                        rs.getString(NAME_COL_NAME),
                        rs.getString(SURNAME_COL_NAME),
                        rs.getString(TELF_COL_NAME),
                        rs.getString(EMAIL_COL_NAME)
                );
            }
        } catch (SQLException e) {
            System.out.println("ERROR EN get by id EN BD");
        }
        return null;
    }

    @Override
    public List<Contacto> getContactosByNombre(String nombre) {
        List<Contacto> contactos = new ArrayList<>();
        String sql = "SELECT * FROM contactos WHERE nombre LIKE ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, "%" + nombre + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Contacto contacto = new Contacto(
                        rs.getInt(ID_COL_NAME),
                        rs.getString(NAME_COL_NAME),
                        rs.getString(SURNAME_COL_NAME),
                        rs.getString(TELF_COL_NAME),
                        rs.getString(EMAIL_COL_NAME)
                );
                contactos.add(contacto);
            }
        } catch (SQLException e) {
            System.out.println("ERROR EN GETALL by nombre EN BD");
        }
        return contactos;
    }

    @Override
    public List<Contacto> getContactosByTelefono(String telefono) {
        List<Contacto> contactos = new ArrayList<>();
        String sql = "SELECT * FROM contactos WHERE telefono LIKE ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, "%" + telefono + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Contacto contacto = new Contacto(
                        rs.getInt(ID_COL_NAME),
                        rs.getString(NAME_COL_NAME),
                        rs.getString(SURNAME_COL_NAME),
                        rs.getString(TELF_COL_NAME),
                        rs.getString(EMAIL_COL_NAME)
                );
                contactos.add(contacto);
            }
        } catch (SQLException e) {
            System.out.println("ERROR EN GETALL by nombre EN BD");
        }
        return contactos;
    }

    public void close() {
        try {
            if (connection != null) connection.close();
        } catch (SQLException e) {
            System.out.println("ERROR CERRANDO LA CONEXIÓN CON BD");
        }
    }
}
