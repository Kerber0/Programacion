import java.util.ArrayList;

public class Videojuego {
    private String nombre;
    private ArrayList<Integer> valoracion;
    private Genero genero;

    public enum Genero {
        ACCION,
        AVENTURA,
        ESTRATEGIA,
        ROL,
        SIMULACION,
        DEPORTE,
        LUGAR_ABIERTO,
        PUZZLE,
        LUCHA,
        FANTASIA,
        CIENCIA_FICCION,
        MUNDO_ABIERTO,
        HORROR,
        MUSICAL,
        PLATAFORMERO
    }

    public Videojuego(String nombre, Genero genero) {
        this.nombre = nombre;
        this.valoracion = new ArrayList<>();
        this.genero = genero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Integer> getValoracion() {
        return valoracion;
    }

    public void setValoracion(ArrayList<Integer> valoracion) {
        this.valoracion = valoracion;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public int calcularValoracion() {
        if (valoracion.isEmpty()) {
            System.out.println("El juego " + getNombre() + " no tiene valoraciones todavía.");
            return 0;
        }

        int resultado = 0;

        for (int valor : valoracion) {
            resultado += valor;
        }

        return (int) ((double) resultado / valoracion.size() * 10);
    }


    @Override
    public String toString() {
        return "Nombre videojuego: " + nombre +
                ", Genero: " + genero +
                ", Valoracion: " + (calcularValoracion() * 10) + "/10";
    }
}
