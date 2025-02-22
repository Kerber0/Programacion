package java.Simulacro;

public class Album {
    private String title;
    private String artist;
    private Integer year;
    private Integer songs;

    public Album(final String title, final String artist, final Integer year, final Integer songs) {
        this.title = title;
        this.artist = artist;
        this.year = year;
        this.songs = songs;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(final String artist) {
        this.artist = artist;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(final Integer year) {
        this.year = year;
    }

    public Integer getSongs() {
        return songs;
    }

    public void setSongs(final Integer songs) {
        this.songs = songs;
    }

    @Override
    public String toString() {
        return "Album{" +
                "title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", year=" + year +
                ", songs=" + songs +
                '}';
    }
}