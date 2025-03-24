import java.util.List;

public class Main {

    public static void main(String[] args) {
        Juego juego = new Juego();

        List<Jugador> jugadores = new java.util.ArrayList<>(List.of());
        Jugador jugador1 = new Jugador("Nico");
        Jugador jugador2 = new Jugador("Jon");
        Jugador jugador3 = new Jugador("Angi");
        Jugador jugador4 = new Jugador("Nan");
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        jugadores.add(jugador3);
        jugadores.add(jugador4);

        juego.repartir(jugadores);



    }

}
