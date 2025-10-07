package com.examen;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseFactory {
    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("No se encontró el driver de SQLite", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:gameshelf.db");
    }

    public static void initialize(String dbFile) throws SQLException {
        String url = "jdbc:sqlite:" + dbFile;
        try (Connection conn = DriverManager.getConnection(url);
             Statement st = conn.createStatement()) {
            st.executeUpdate("""
                CREATE TABLE IF NOT EXISTS videojuegos (
                  id INTEGER PRIMARY KEY AUTOINCREMENT,
                  titulo TEXT NOT NULL,
                  plataforma TEXT NOT NULL,
                  precio REAL NOT NULL,
                  stock INTEGER NOT NULL DEFAULT 0
                );
            """);
            st.executeUpdate("""
                CREATE TABLE IF NOT EXISTS ventas (
                  id INTEGER PRIMARY KEY AUTOINCREMENT,
                  juego_id INTEGER NOT NULL,
                  fecha TEXT NOT NULL,
                  FOREIGN KEY (juego_id) REFERENCES videojuegos(id)
                );
            """);
        }
    }
}
