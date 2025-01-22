public class Libro {

    private String titulo;
    private String autor;
    private int numPaginas;
    private String ISBN;


    public Libro(String titulo, String autor, int numPaginas, String ISBN) {
        this.titulo = titulo;
        this.autor = autor;
        this.numPaginas = numPaginas;
        this.ISBN = ISBN;
    }

    public String getTitulo(){
        return titulo;
    }
    public  void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public String getAutor(){
        return autor;
    }
    public void setAutor(String autor){
        this.autor = autor;
    }
    public int getNumPaginas(){
        return numPaginas;
    }
    public void setNumPaginas(int numPaginas){
        this.numPaginas = numPaginas;
    }
    public String getISBN(){
        return ISBN;
    }
    public void setISBN(String ISBN){
        this.ISBN = ISBN;
    }

    @Override
    public String toString(){
        return "El libro " + titulo + "con ISBN " + ISBN + "creado por" +
                " el autor " + autor + "tiene " + numPaginas + " páginas.";
    }
}


