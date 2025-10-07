package com.examen.dao;

import com.examen.model.Videojuego;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface VideojuegoDAO {
    void crear(Videojuego v) throws SQLException;
    Videojuego buscarPorId(int id) throws SQLException;
    List<Videojuego> listarTodos() throws SQLException;
    void actualizar(Videojuego v) throws SQLException;
    void borrar(int id) throws SQLException;
    Map<String, Double> precioMedioPorPlataforma() throws SQLException;
    void registrarVenta(int juegoId) throws SQLException;
}
