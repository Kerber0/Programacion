public class Camion extends Vehiculo {
    private int cargaMaxima;
    private Motor motor;


    public Camion(String marca, String modelo, double cargaMaxima, Motor motor) {
        super(marca, modelo);
        this.cargaMaxima = (int) cargaMaxima;
        this.motor = motor;
    }

    public double getCargaMaxima() {
        return cargaMaxima;
    }

    public void setCargaMaxima(double cargaMaxima) {
        this.cargaMaxima = (int) cargaMaxima;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }
}
