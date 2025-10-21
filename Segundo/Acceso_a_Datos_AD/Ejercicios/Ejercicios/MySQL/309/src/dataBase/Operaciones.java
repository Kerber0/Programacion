package dataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Operaciones {
    List<Integer> borrowed = new ArrayList<>();

    private static Connection conn;
    private final String user = "root";
    private final String clave = "abc123";
    private final String url = "jdbc:mysql://localhost:3306/library";

    void openConnection() {
        try {
            conn = DriverManager.getConnection(url, user, clave);
            System.out.println("Conexión establecida correctamente.");
        } catch (SQLException e) {
            System.out.println("Error en la conexión.");
            e.printStackTrace();
        }
    }

    void closeConnection() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Conexión cerrada.");
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión.");
            e.printStackTrace();
        }
    }


    public boolean existsBook(int idBook) {
        boolean exist = false;
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "SELECT idBook FROM Book WHERE idBook = ?"
            );
            ps.setInt(1, idBook);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                exist = true;
            }

            rs.close();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return exist;
    }


    public boolean existsClient(int idClient) {
        boolean exist = false;
        try {
            PreparedStatement ps = this.conn.prepareStatement(
                    "SELECT idClient FROM Client WHERE idCiente = ?"
            );
            ps.setInt(1, idClient);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                exist = true;
            }
            rs.close();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exist;
    }

    public boolean isBorrowed(int idBook) {

    }

    public void addLoan(int idBook) {
    }

    public void addReturn(int idBook) {
    }

    public void borrowedBooksList() {
        if(borrowed.isEmpty()) {
            System.out.println("No hay libros prestados actualmente.");
        }


        try {
            PreparedStatement ps = conn.prepareStatement(
                    "SELECT idBook, title FROM Book WHERE idBook = ?"
            );
            for (int idBooks : borrowed) {
                ps.setInt(1, idBooks);
                ResultSet rs = ps.executeQuery();
                System.out.println("Id libros prestados:");

                while (rs.next()) {
                    System.out.println("ID: " + rs.getInt("idBook") +
                            " - Title: " + rs.getString("title")
                    );
                }
                rs.close();
            }
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void availableBooksList() {

    }
}




