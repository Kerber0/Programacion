public class Tranvia  extends TransportePublico{
    int numeroVagones;

    public Tranvia(String matricula, int capacidadPasajeros, int velocidadMaxima, int numeroVagones) {
        super(matricula, capacidadPasajeros, velocidadMaxima);
        this.numeroVagones = numeroVagones;
    }

    public int getNumeroVagones() {
        return numeroVagones;
    }

    public void setNumeroVagones(int numeroVagones) {
        this.numeroVagones = numeroVagones;
    }


    @Override
    double calcularTarifa() {
        double tarifa = 0;
        boolean tarifaValida = false;

        while (!tarifaValida) {
            double distancia = JavaCiudad.inputDouble("Ingrese la distancia a recorrer: ");

            if (distancia <= 0) {
                System.out.println("La distancia debe ser positiva. Pruebe otra vez.");
                continue;
            }
            tarifa = (distancia * 1.2) + (numeroVagones * 0.5);
            tarifaValida = true;
        }

        return tarifa;
    }

    @Override
    public String toString() {
        return "Tranvia: \n" +
                "Matricula: " + matricula +
                ", Numero de vagones: " + numeroVagones +
                ", Capacidad de pasajeros: " + capacidadPasajeros +
                ", Velocidad maxima: " + velocidadMaxima;
    }
}
