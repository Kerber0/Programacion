package com.examen.dao;

import com.examen.model.Videojuego;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class VideojuegoDAOImpl implements VideojuegoDAO {
    private final Connection conn;

    public VideojuegoDAOImpl() throws SQLException {
        this.conn = com.examen.DatabaseFactory.getConnection();
    }

    public VideojuegoDAOImpl(Connection conn) {
        this.conn = conn;
    }

    /**
     * Método para validar los datos de un videojuego.
     * Si no cumple alguna de las validaciones, lanzará una IllegalArgumentException.
     * @param v Videojuego a validar
     */
    private void validarDatos(Videojuego v) throws IllegalArgumentException {
        if(v.getTitulo().isEmpty() || v.getTitulo() == null) {
                throw new IllegalArgumentException();
        }
        if(v.getPlataforma().isEmpty() || v.getPlataforma() == null) {
            throw new IllegalArgumentException();
        }
        if(v.getPrecio() <= 0) {
            throw new IllegalArgumentException();
        }
        if(v.getStock()< 0) {
            throw new IllegalArgumentException();

        }

    }

    /**
     * Método para crear un nuevo videojuego.
     * Si no cumple alguna de las validaciones, lanzará una IllegalArgumentException.
     * @param v Videojuego a crear
     * @throws SQLException Si ocurre un error al acceder a la base de datos
     */
    @Override
    public void crear(Videojuego v) throws SQLException {
        try{
            validarDatos(v);

            String sql = "INSERT INTO videojuegos (titulo, plataforma, precio, stock) VALUES (?,?,?,?)";
            try(PreparedStatement ps = conn.prepareStatement(sql)){
                ps.setString(1, v.getTitulo());
                ps.setString(2,v.getPlataforma());
                ps.setDouble(3, v.getPrecio());
                ps.setInt(4, v.getStock());
                ps.executeUpdate();

            }
        }catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Método para buscar un videojuego por su ID.
     * @param id ID del videojuego a buscar
     * @return El videojuego encontrado o null si no existe
     * @throws SQLException Si ocurre un error al acceder a la base de datos
     */
    @Override
    public Videojuego buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM videojuegos WHERE id=?";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, id);
            try(ResultSet rs = ps.executeQuery()) {
                if(rs.next()){
                    return new Videojuego (rs.getInt("id"), rs.getString("Titulo"), rs.getString("Plataforma"), rs.getDouble("Precio"), rs.getInt("Stock"));
                }
            }
        return null;
        }
    }

    /**
     * Método para listar todos los videojuegos.
     * @return Lista de videojuegos
     * @throws SQLException Si ocurre un error al acceder a la base de datos
     */
    @Override
    public List<Videojuego> listarTodos() throws SQLException {
        List<Videojuego> videojuegos = new ArrayList<>();
        String sql = "SELECT * FROM videojuegos";
        try(PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while(rs.next()){
                Videojuego nuevo = new Videojuego(rs.getInt("id"), rs.getString("Titulo"), rs.getString("Plataforma"), rs.getDouble("Precio"), rs.getInt("Stock"));
                videojuegos.add(nuevo);
            }
        }
        return videojuegos;
    }

    /**
     * Método para actualizar un videojuego.
     * Si no cumple alguna de las validaciones, lanzará una IllegalArgumentException.
     * @param v Videojuego a actualizar
     * @throws SQLException Si ocurre un error al acceder a la base de datos
     */
    @Override
    public void actualizar(Videojuego v) throws SQLException {


        String sql = "UPDATE videojuegos SET titulo=?, plataforma=?, precio=?, stock=? WHERE id=?";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, v.getTitulo());
            ps.setString(2,v.getPlataforma());
            ps.setDouble(3, v.getPrecio());
            ps.setInt(4, v.getStock());
            ps.setInt(5, v.getId());
            ps.executeUpdate();
        }catch (Exception e) {
            throw new IllegalArgumentException();
        }
        validarDatos(v);


    }

    /**
     * Método para borrar un videojuego por su ID.
     * @param id ID del videojuego a borrar
     * @throws SQLException Si ocurre un error al acceder a la base de datos
     */
    @Override
    public void borrar(int id) throws SQLException {
        String sql = "DELETE FROM videojuegos WHERE id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    /**
     * Método para calcular el precio medio de los videojuegos por plataforma.
     * @return Un mapa donde la clave es el nombre de la plataforma y el valor es el precio medio.
     * @throws SQLException Si ocurre un error al acceder a la base de datos
     */
    @Override
    public Map<String, Double> precioMedioPorPlataforma() throws SQLException {

        return Map.of();
    }

    /**
     * Método para registrar una venta de un videojuego.
     * Este método debería actualizar el stock del videojuego y registrar la venta.
     *
     * @param juegoId ID del videojuego vendido
     * @throws SQLException Si ocurre un error al acceder a la base de datos
     */
    @Override
    public void registrarVenta(int juegoId) throws SQLException {
       if (buscarPorId(juegoId)== null){
           System.out.println("Id inválido");
           throw new SQLException();
       }

       Videojuego juego = buscarPorId(juegoId);

       if(juego.getStock() == 0) {
           System.out.println("No hay copias disponibles para la venta.");
           throw new SQLException();
       } else {

               conn.setAutoCommit(false);

               String sql = "UPDATE videojuegos SET stock = stock - 1 WHERE id = ?";
               try(PreparedStatement ps = conn.prepareStatement(sql)){
                   ps.setInt(1, juegoId);
                   ps.executeUpdate();
               }catch (SQLException e) {
                   System.out.println("Error: " + e);
               }

               conn.setAutoCommit(true);

       }

    }

}