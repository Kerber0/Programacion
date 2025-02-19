import java.util.Date;

public class Libro {

  private String titulo;
  private String autor;
  private Date year;
  private int numpag;

  public Libro(String titulo, String autor, Date year, int numpag) {
    this.titulo = titulo;
    this.autor = autor;
    this.year = year;
    this.numpag = numpag;
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

  public Date getYear() {
    return year;
  }

  public void setYear(Date year) {
    this.year = year;
  }

  public int getNumpag() {
    return numpag;
  }

  public void setNumpag(int numpag) {
    this.numpag = numpag;
  }

  @Override
  public String toString() {
    return "Libro{" +
        "titulo='" + titulo + '\'' +
        ", autor='" + autor + '\'' +
        ", year=" + year +
        ", numpag=" + numpag +
        '}';
  }
}
