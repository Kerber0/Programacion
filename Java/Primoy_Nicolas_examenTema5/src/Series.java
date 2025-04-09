public class Series extends Multimedia {
    public int temporadas;
    public String capitulos;

    public Series(String nombre, String plataforma, int temporadas, String capitulos) {
        super(nombre, plataforma);
        this.temporadas = temporadas;
        this.capitulos = capitulos;
    }

    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public String getCapitulos() {
        return capitulos;
    }

    public void setCapitulos(String capitulos) {
        this.capitulos = capitulos;
    }

    @Override
    public String toString() {
        return "Serie: " + getNombre() + "\n" +
            "Plataforma: " + getPlataforma() + "\n" +
            "Temporada/s: " + getTemporadas() + "\n" +
            "Capítulos: " + capitulos;
    }
}
