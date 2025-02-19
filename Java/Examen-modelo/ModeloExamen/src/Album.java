import java.util.List;

public class Album {

  public  List<Album> albums;
  private String nombre;
  private String artista;
  private int year;
  private int numCanciones;

  public Album(String nombre, String artista, int year, int numCanciones) {
    this.nombre = nombre;
    this.artista = artista;
    setYear(year);
    setNumCanciones(numCanciones);
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getArtista() {
    return artista;
  }

  public void setArtista(String artista) {
    this.artista = artista;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    boolean aniocorrecto = false;
    do{
      if (year>1800 && year<2026){
        this.year = year;
        aniocorrecto = true;
      }else {
        System.out.println("Año invalido, pruebe otra vez:");
      }
    } while(!aniocorrecto);
  }

  public int getNumCanciones() {
    return numCanciones;
  }

  public void setNumCanciones(int numCanciones) {
    boolean cantidadcorrecta = false;
    do{
      if (numCanciones >0){
        this.numCanciones = numCanciones;
        cantidadcorrecta = true;
      }
    } while (!cantidadcorrecta);

  }

  @Override
  public String toString() {
    return "Album{" +
        "nombre='" + nombre + '\'' +
        ", artista='" + artista + '\'' +
        ", year=" + year +
        ", numCanciones=" + numCanciones +
        '}';
  }
}
