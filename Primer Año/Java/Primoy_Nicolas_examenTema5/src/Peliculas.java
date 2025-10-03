public class Peliculas extends Multimedia {
    int duracion;

    public Peliculas(String nombre, String plataforma, int duracion) {
        super(nombre, plataforma);
        this.duracion = duracion;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "Pelicula: " + getNombre() + "\n"+
            "Plataforma: " + getPlataforma() + "\n" +
            "Duracion: " + duracion;
    }
}
