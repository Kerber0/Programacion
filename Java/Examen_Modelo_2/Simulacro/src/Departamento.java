public class Departamento extends Inmueble {
    private int piso;
    private String letra;

    public Departamento(int id, int numHabitaciones, boolean garaje, String calle, int numero,
        Estado estado, double precio, int superficie, int piso, String letra) {
        super(id, numHabitaciones, garaje, calle, numero, estado, precio, superficie);
        this.piso = piso;
        this.letra = letra;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }
    public double precioVenta(Inmueble inmueble) {
        double precio = inmueble.getSuperficie() * 1000 + getPiso() * 15000;
        if (isGaraje()) {
            return precio + 35000;
        }
        return precio;
    }

    @Override
    public String toString() {
        return "Departamento{" +
            "piso=" + piso +
            ", letra='" + letra + '\'' +
            '}';
    }


}
