import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Juego {


    public ArrayList<Carta> crearBaraja() {
        ArrayList<Carta> baraja = new ArrayList<>();
        String[] palos = {"Corazones", "Diamantes", "Tréboles", "Picas"};

        for (String palo : palos) {
            for (int valor = 1; valor <= 13; valor++) {
                baraja.add(new Carta(valor, palo));
            }
        }
        return baraja;
    }

    public void repartir(List<Jugador> jugadores) {
        ArrayList<Carta> baraja = crearBaraja();
        Collections.shuffle(baraja);

        int turno = 0;
        while (!baraja.isEmpty()) {
            Carta carta = baraja.remove(0);
            jugadores.get(turno).agregarAPila(carta);
            jugadores.get(turno).agregarAPila(carta);
            turno = (turno + 1) % jugadores.size();
        }
    }


    public void jugar(List<Jugador> jugadores) {
        boolean ganador = false;
        Objects carta;

        // hacer número de rondas con division entera de cartas por jugadores
        // verificar cada carta y quien va a ser el ganador de cada ronda antes de jugar cada rona con .peek()
        // hacer una pila central donde poner las cartas para depsues repartirlas al  ganador al final de cada ronda
        do {
            for (Jugador jugador : jugadores) {
                jugador.sacarCarta();
                if (carta == null) {
                    System.out.println("El jugador: " + jugador.getNombre() + "ha sido eliminado");
                    jugadores.remove(jugador);
                } else if (carta ) {

                }
            }
        }while (!ganador);


    }


}
