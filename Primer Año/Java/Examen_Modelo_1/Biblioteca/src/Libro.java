public class Libro {

    private String titulo;
    private String autor;
    private int year;
    private int numPag;

    public Libro(String titulo, String autor, int year, int numPag) {
        this.titulo = titulo;
        this.autor = autor;
        this.year = year;
        this.numPag = numPag;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getNumPag() {
        return numPag;
    }

    public void setNumPag(int numPag) {
        this.numPag = numPag;
    }

    @Override
    public String toString() {
        return "Título: " + titulo +
                ", Autor: " + autor +
                ", Año publicación: " + year +
                ", Número de páginas: " + numPag;
    }
}
