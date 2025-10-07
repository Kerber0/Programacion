public class Autobus extends TransportePublico {
    boolean wifi;

    public Autobus(String matricula, int capacidadPasajeros, int velocidadMaxima, boolean wifi) {
        super(matricula, capacidadPasajeros, velocidadMaxima);
        this.wifi = wifi;
    }

    public boolean isWifi() {
        return wifi;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }


    @Override
     public double calcularTarifa() {
        double tarifa = 0;
        boolean tarifaValida = false;

        while (!tarifaValida) {
            double distancia = JavaCiudad.inputDouble("Ingrese la distancia a recorrer: ");

            if (distancia <= 0) {
                System.out.println("La distancia debe ser positiva. Pruebe otra vez.");
                continue;
            }
            tarifa = distancia * 1.5;
            if (isWifi()) {
                tarifa *= 2;
            }
            tarifaValida = true;
        }

        return tarifa;
    }



    @Override
    public String toString() {
        return "Autobus: \n" +
                "Matricula: " + matricula +
                ", Capacidad de Pasajeros: " + capacidadPasajeros + ", " +
                "Velocidad Maxima: " + velocidadMaxima +
                ", Wifi: " +(isWifi() ? "Si." : "No.");
    }
}
