public class Album {

    private String titulo;
    private String autor;
    private int year;
    private int numSong;

    public Album(String titulo, String autor, int year, int numSong) {
        this.titulo = titulo;
        this.autor = autor;
        this.year = year;
        this.numSong = numSong;
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

    public int getNumSong() {
        return numSong;
    }

    public void setNumSong(int numSong) {
        this.numSong = numSong;
    }

    @Override
    public String toString() {
        return  "Título: " + titulo +
                ", Autor: " + autor +
                ", Año publicación: " + year +
                ", Número canciones: " + numSong;
    }
}
