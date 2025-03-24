import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        HashMap<String, Double> areas = new HashMap<>();
        HashMap<String, Double> perimetros = new HashMap<>();

        Figura circulo = new Circulo(5);
        Figura rectangulo = new Rectangulo(3, 4);
        Figura triangulo = new Triangulo(3, 4,5);

        areas.put("Círculo", circulo.calcularArea());
        areas.put("Rectángulo", rectangulo.calcularArea());
        areas.put("Triángulo", triangulo.calcularArea());

        perimetros.put("Círculo", circulo.calcularPerimetro());
        perimetros.put("Rectángulo", circulo.calcularPerimetro());
        perimetros.put("Triángulo", circulo.calcularPerimetro());

        for (String figura : areas.keySet()) {
            System.out.println("Área de " + figura + ": " + areas.get(figura));
        }
        for (String figura : perimetros.keySet()) {
            System.out.println("Perímetro de " + figura + ": " + perimetros.get(figura));
        }

    }

    }


