package com.examen.model;

public class Videojuego {
    private int id;
    private String titulo;
    private String plataforma;
    private double precio;
    private int stock;

    public Videojuego(int id, String titulo, String plataforma, double precio, int stock) {
        this.id = id;
        this.titulo = titulo;
        this.plataforma = plataforma;
        this.precio = precio;
        this.stock = stock;
    }
    public Videojuego() {}



    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getPlataforma() { return plataforma; }
    public void setPlataforma(String plataforma) { this.plataforma = plataforma; }
    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }
    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    @Override
    public String toString() {
        return String.format("[ID=%d] %s (%s) - %.2f€ [%d disponibles]",
                id, titulo, plataforma, precio, stock);
    }
}

