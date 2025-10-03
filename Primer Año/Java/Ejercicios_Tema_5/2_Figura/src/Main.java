import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {


        LinkedList<Figura> figuras = new LinkedList<>();
        figuras.add(new Circulo(3));
        figuras.add(new Rectangulo(3, 2));
        figuras.add(new Triangulo(3, 2));

        for (Figura formas : figuras) {
            System.out.println("Área: " + formas.calcularArea());
        }
    }
}