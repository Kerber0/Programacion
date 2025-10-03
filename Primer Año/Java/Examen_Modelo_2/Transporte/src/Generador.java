import java.util.HashMap;
import java.util.Random;

public interface Generador {

    Random random = new Random();
    String[] MATRICULAS = {
            "AB123CD", "EF456GH", "IJ789KL", "MN012OP", "QR345ST",
            "UV678WX", "YZ901AB", "CD234EF", "GH567IJ", "KL890MN",
            "LP112QR", "MN223ST", "PQ334UV", "RS445WX", "TU556YZ",
            "VW667AB", "XY778CD", "ZA889EF", "BC990GH", "DE101IJ"
    };

    static void generar(HashMap<TransportePublico, String> vehiculos) {
        for (int i = 0; i < 2; i++) { // Generar exactamente 2 vehículos de cada tipo
            String matricula = MATRICULAS[random.nextInt(MATRICULAS.length)];
            int velocidadMaxima = random.nextInt(120) + 50; // Velocidad aleatoria entre 50 y 170

            // Autobús
            boolean wifi = random.nextBoolean();
            TransportePublico autobus = new Autobus(matricula, 102, velocidadMaxima, wifi);
            vehiculos.put(autobus, matricula);

            // Taxi
            int pasajerosTaxi = (random.nextBoolean()) ? 3 : 6; // Aleatoriamente elige entre 3 o 6 pasajeros
            double tarifaBase = random.nextDouble() * 50 + 10; // Tarifa entre 10 y 60
            TransportePublico taxi = new Taxi(matricula, pasajerosTaxi, velocidadMaxima, tarifaBase);
            vehiculos.put(taxi, matricula);

            // Tranvía
            int vagones = random.nextInt(5) + 1; // Entre 1 y 5 vagones
            TransportePublico tranvia = new Tranvia(matricula, 200, velocidadMaxima, vagones);
            vehiculos.put(tranvia, matricula);
        }
    }


    // Método para validar la capacidad de pasajeros según el tipo de vehículo
    static int validarPasajeros(int choice) {
        int pasajeros = 0;

        switch (choice) {
            case 1: // Autobus
                pasajeros = 102; // Capacidad máxima para el autobús
                break;
            case 2: // Taxi
                // Aleatorio entre 3 o 6 pasajeros
                pasajeros = random.nextBoolean() ? 3 : 6;
                break;
            case 3: // Tranvia
                pasajeros = 510; // Capacidad máxima para el tranvía es 510
                break;
        }

        return pasajeros;
    }
}
