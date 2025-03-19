public class Triangulo implements Figura {
    private double base;
    private double altura;
    private double lado;

    public Triangulo(double base, double altura, double lado) {
        this.base = base;
        this.altura = altura;
        this.lado = lado;
    }

    @Override
    public double calcularArea(){
        return  (base * altura) / 2;
    }

    @Override
    public double calcularPerimetro(){
        return base + altura + lado;

    }

}
