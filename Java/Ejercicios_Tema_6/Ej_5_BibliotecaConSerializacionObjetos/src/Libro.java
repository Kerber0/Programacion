import java.io.Serializable;

public class Libro implements Serializable {
    private String codigo;
    private String titulo;
    private String autor;
    private int anioPublicacion;

    public Libro(String codigo, String titulo, String autor, int anioPublicacion) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
    }

    public String getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return "Código: " + codigo + ", Título: " + titulo + ", Autor: " + autor + ", Año: " + anioPublicacion;
    }
}