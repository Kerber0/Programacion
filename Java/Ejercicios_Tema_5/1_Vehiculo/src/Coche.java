public class Coche extends Vehiculo {
    private int numeroPuertas;
    private Motor motor;

    public Coche(String marca, String modelo, int numeroPuertas, Motor motor) {
        super(marca, modelo);
        this.numeroPuertas = numeroPuertas;
        this.motor = motor;
    }

    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public void setNumeroPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }


    @Override
    public String toString() {
        return "Coche{" +
            ", marca: " + getMarca() +
            ", modelo: " + getModelo() +
            ", numeroPuertas: " + numeroPuertas +
            "y motor: " + motor +
            '}';
    }
}




