public class Album {
    private String title;
    private String name;
    private int year;
    private int numSong;

    public Album(String title, String name, int year, int numSong) {
        this.title = title;
        this.name = name;
        this.year = year;
        this.numSong = numSong;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "Album: " +
            "Título: " + title +
            ", Nombre Autor/Grupo: " + name +
            ", Año publicación: " + year +
            ", Número de canciones: " + numSong;
    }
}
