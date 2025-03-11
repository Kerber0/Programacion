import java.util.ArrayList;
import java.util.List;

public class Taller {
    private final List <Vehiculo> vehiculos = new ArrayList<>();



    public void agregarVehiculo(Vehiculo v){
        vehiculos.add(v);
    }

    public void repararVehiculos() {
        for (Vehiculo v : vehiculos) {
            if (v instanceof Coche) {
                System.out.println("Reparando coche: " + v.getMarca() + " " + v.getModelo());
            } else if (v instanceof Camion) {
                System.out.println("Reparando camión: " + v.getMarca() + " " + v.getModelo());
            } else if (v instanceof Bicicleta) {
                System.out.println("Reparando bicicleta: " + v.getMarca() + " " + v.getModelo() + " " + ((Bicicleta) v).getTipo());
            }
        }
    }

}
