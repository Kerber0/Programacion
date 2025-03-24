import java.util.ArrayList;
import java.util.Random;

public class GeneracionRandom {
    private static final Random random = new Random();

    //  25 Nombres aleatorios de videojuegos
    private static final String[] NOMBRESJUEGOS = {
            "Aventura Galáctica", "Batalla Final", "Exploradores del Tiempo", "Fuerzas del Caos", "Amanecer del Guerrero",
            "Misterios Perdidos", "Desafío Total", "Reinos Olvidados", "Cazadores de Sombras", "El Último Refugio",
            "Laberinto Mortal", "El Regreso del Héroe", "Guerra Eterna", "Tierra Salvaje", "La Carrera Imparable",
            "Prueba del Valor", "Revolución Cibernética", "Torneo Supremo", "Viento de Guerra", "El Ascenso del Imperio",
            "Cielo Sangriento", "Dioses del Abismo", "Cautivos del Destino", "Venganza Mortal", "Reyes del Desierto"
    };

    public static Videojuego generarVideojuego() {
        String nombre = NOMBRESJUEGOS[random.nextInt(NOMBRESJUEGOS.length)];

        Videojuego.Genero genero = Videojuego.Genero.values()[random.nextInt(Videojuego.Genero.values().length)];

        Videojuego videojuego = new Videojuego(nombre, genero);

        // Generar valoraciones aleatorias entre 1 y 10
        int numValoraciones = random.nextInt(5) + 1;  // Al menos 1 valoración, hasta 5 valoraciones
        ArrayList<Integer> valoraciones = new ArrayList<>();
        for (int i = 0; i < numValoraciones; i++) {
            valoraciones.add(random.nextInt(10) + 1);  // Valoraciones entre 1 y 10
        }
        videojuego.setValoracion(valoraciones);

        return videojuego;
    }








}