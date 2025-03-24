import java.util.Stack;

public class Jugador {

    private String nombre;
    private Stack<Carta> pila;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.pila = new Stack<>();
    }

    public String getNombre() {
        return nombre;
    }

    public Stack<Carta> getPila() {
        return pila;
    }

    public void agregarAPila(Carta carta){
        pila.push(carta);
    }

    public Carta sacarCarta() {
        if(!pila.isEmpty()) {
            return pila.pop();
        }
        return null;
    }

}
