public class Taxi extends TransportePublico{
    double tarifaBase;

    public Taxi(String matricula, int capacidadPasajeros, int velocidadMaxima, double tarifaBase) {
        super(matricula, capacidadPasajeros, velocidadMaxima);
        this.tarifaBase = tarifaBase;
    }

    public double getTarifaBase() {
        return tarifaBase;
    }

    public void setTarifaBase(double tarifaBase) {
        this.tarifaBase = tarifaBase;
    }


    @Override
    double calcularTarifa() {
        double tarifa = tarifaBase;
        boolean tarifaValida = false;

        while (!tarifaValida) {
            double distancia = JavaCiudad.inputDouble("Ingrese la distancia a recorrer: ");

            if (distancia <= 0) {
                System.out.println("La distancia debe ser positiva. Pruebe otra vez.");
                continue;
            }
            tarifa = distancia * 1.5;
            tarifaValida = true;
        }

        return tarifa;
    }

    @Override
    public String toString() {
        return "Taxi: \n" +
                "Matricula: " + matricula +
                ", Capacidad de pasajeros: " + capacidadPasajeros +
                ", Velocidad maxima: " + velocidadMaxima;
    }
}
