package com.examen.dao;
import com.examen.model.Videojuego;
import com.examen.DatabaseFactory;
import org.junit.jupiter.api.*;
import java.nio.file.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class VideojuegoDAOTest {
    private static final String DB = "test_gameshelf.db";
    private VideojuegoDAO dao;
    private Connection conn;

    @BeforeAll
    void load() throws ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
    }

    @BeforeEach
    void setup() throws Exception {
        Files.deleteIfExists(Path.of(DB));
        conn = DriverManager.getConnection("jdbc:sqlite:" + DB);
        try (var st = conn.createStatement()) {
            st.executeUpdate("PRAGMA foreign_keys = ON;");
        }
        DatabaseFactory.initialize(DB);
        dao = new VideojuegoDAOImpl(conn);
    }

    @AfterEach
    void tear() throws Exception {
        conn.close();
        Files.deleteIfExists(Path.of(DB));
    }

    @Test
    void testCrear() throws SQLException {
        int antes = dao.listarTodos().size();
        Videojuego v = new Videojuego(0, "Zelda", "Switch", 60.0, 5);
        dao.crear(v);
        int despues = dao.listarTodos().size();
        assertEquals(antes + 1, despues);

        boolean existe = dao.listarTodos().stream()
                .anyMatch(j -> j.getTitulo().equals("Zelda") && j.getPlataforma().equals("Switch") && j.getPrecio() == 60.0 && j.getStock() == 5);
        assertTrue(existe, "El videojuego debe existir tras la inserción");
    }

    @Test
    void testBuscarPorId() throws SQLException {
        Videojuego v = new Videojuego(0, "Halo", "Xbox", 50.0, 3);
        dao.crear(v);
        // Buscar el videojuego insertado por sus atributos
        Videojuego encontrado = dao.listarTodos().stream()
                .filter(j -> j.getTitulo().equals("Halo") && j.getPlataforma().equals("Xbox") && j.getPrecio() == 50.0 && j.getStock() == 3)
                .findFirst().orElse(null);
        assertNotNull(encontrado);
        assertEquals("Halo", encontrado.getTitulo());
    }

    @Test
    void testActualizar() throws SQLException {
        Videojuego v = new Videojuego(0, "GTA", "PC", 45.0, 4);
        dao.crear(v);
        // Buscar el videojuego insertado
        Videojuego original = dao.listarTodos().stream()
                .filter(j -> j.getTitulo().equals("GTA") && j.getPlataforma().equals("PC"))
                .findFirst().orElseThrow();
        original.setPrecio(35.0);
        dao.actualizar(original);
        // Comprobar que se ha actualizado el precio
        Videojuego actualizado = dao.listarTodos().stream()
                .filter(j -> j.getTitulo().equals("GTA") && j.getPlataforma().equals("PC"))
                .findFirst().orElseThrow();
        assertEquals(35.0, actualizado.getPrecio());
    }

    @Test
    void testListarTodos() throws SQLException {
        dao.crear(new Videojuego(0, "A", "PC", 10, 1));
        dao.crear(new Videojuego(0, "B", "PS", 20, 1));
        List<Videojuego> lista = dao.listarTodos();
        assertEquals(2, lista.size());
    }

    @Test
    void testBorrar() throws SQLException {
        int antes = dao.listarTodos().size();
        Videojuego v = new Videojuego(0, "Mario", "Switch", 55.0, 2);
        dao.crear(v);
        // Buscar el videojuego insertado
        Videojuego insertado = dao.listarTodos().stream()
                .filter(j -> j.getTitulo().equals("Mario") && j.getPlataforma().equals("Switch"))
                .findFirst().orElseThrow();
        dao.borrar(insertado.getId());
        int despues = dao.listarTodos().size();
        assertEquals(antes, despues);
        boolean existe = dao.listarTodos().stream()
                .anyMatch(j -> j.getTitulo().equals("Mario") && j.getPlataforma().equals("Switch"));
        assertFalse(existe);
    }

    @Test
    void testCRUD() throws SQLException {
        int antes = dao.listarTodos().size();
        Videojuego v1 = new Videojuego(0, "A", "PC", 10, 1);
        dao.crear(v1);
        int despues = dao.listarTodos().size();
        assertEquals(antes + 1, despues);

        Videojuego read = dao.listarTodos().stream()
                .filter(j -> j.getTitulo().equals("A") && j.getPlataforma().equals("PC"))
                .findFirst().orElseThrow();
        assertEquals("A", read.getTitulo());

        read.setPrecio(5);
        dao.actualizar(read);
        Videojuego actualizado = dao.listarTodos().stream()
                .filter(j -> j.getTitulo().equals("A") && j.getPlataforma().equals("PC"))
                .findFirst().orElseThrow();
        assertEquals(5, actualizado.getPrecio());

        dao.borrar(actualizado.getId());
        boolean existe = dao.listarTodos().stream()
                .anyMatch(j -> j.getTitulo().equals("A") && j.getPlataforma().equals("PC"));
        assertFalse(existe);
    }

    @Test
    void testCrearDatosInvalidos() {
        assertThrows(IllegalArgumentException.class, () ->
                dao.crear(new Videojuego(0, null, "PC", 10, 1))
        );
        assertThrows(IllegalArgumentException.class, () ->
                dao.crear(new Videojuego(0, "", "PC", 10, 1))
        );
        assertThrows(IllegalArgumentException.class, () ->
                dao.crear(new Videojuego(0, "A", null, 10, 1))
        );
        assertThrows(IllegalArgumentException.class, () ->
                dao.crear(new Videojuego(0, "A", "", 10, 1))
        );
        assertThrows(IllegalArgumentException.class, () ->
                dao.crear(new Videojuego(0, "A", "PC", 0, 1))
        );
        assertThrows(IllegalArgumentException.class, () ->
                dao.crear(new Videojuego(0, "A", "PC", -5, 1))
        );
        assertThrows(IllegalArgumentException.class, () ->
                dao.crear(new Videojuego(0, "A", "PC", 10, -1))
        );
    }

    @Test
    void testActualizarDatosInvalidos() throws SQLException {
        Videojuego v = new Videojuego(0, "B", "PC", 10, 1);
        dao.crear(v);
        Videojuego creado = dao.listarTodos().get(0);

        creado.setTitulo(null);
        assertThrows(IllegalArgumentException.class, () -> dao.actualizar(creado));
        creado.setTitulo("B");
        creado.setPlataforma("");
        assertThrows(IllegalArgumentException.class, () -> dao.actualizar(creado));
        creado.setPlataforma("PC");
        creado.setPrecio(0);
        assertThrows(IllegalArgumentException.class, () -> dao.actualizar(creado));
        creado.setPrecio(10);
        creado.setStock(-1);
        assertThrows(IllegalArgumentException.class, () -> dao.actualizar(creado));
    }

    @Test
    void testPrecioMedio() throws SQLException {
        dao.crear(new Videojuego(0, "X", "PS", 20, 1));
        dao.crear(new Videojuego(0, "Y", "PS", 40, 1));
        dao.crear(new Videojuego(0, "Z", "PC", 30, 1));
        Map<String, Double> m = dao.precioMedioPorPlataforma();
        assertEquals(30.0, m.get("PS"));
        assertEquals(30.0, m.get("PC"));
    }

    @Test
    void testRegistrarVenta() throws SQLException {
        dao.crear(new Videojuego(0, "FIFA", "PS5", 59.99, 2));

        Videojuego fifa = dao.listarTodos().stream()
                .filter(j -> j.getTitulo().equals("FIFA") && j.getPlataforma().equals("PS5"))
                .findFirst().orElseThrow();

        dao.registrarVenta(fifa.getId());
        int stock1 = dao.listarTodos().stream()
                .filter(j -> j.getTitulo().equals("FIFA") && j.getPlataforma().equals("PS5"))
                .findFirst().orElseThrow().getStock();
        assertEquals(1, stock1);

        dao.registrarVenta(fifa.getId());
        int stock2 = dao.listarTodos().stream()
                .filter(j -> j.getTitulo().equals("FIFA") && j.getPlataforma().equals("PS5"))
                .findFirst().orElseThrow().getStock();
        assertEquals(0, stock2);

        assertThrows(SQLException.class, () -> dao.registrarVenta(fifa.getId()));
    }
}
