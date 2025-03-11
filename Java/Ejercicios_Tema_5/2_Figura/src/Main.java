import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

        LinkedList<Figura> figuras = new LinkedList<>();
        figuras.add(new Circulo(5));
        figuras.add(new Rectangulo(3, 4));
        figuras.add(new Triangulo(3, 4));

        for (Figura formas : figuras) {
            System.out.println("Área: " + formas.calcularArea());
        }
    }
}