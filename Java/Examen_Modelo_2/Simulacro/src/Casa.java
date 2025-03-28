public class Casa extends Inmueble{
    private int numPisos;
    private boolean piscina;

    public Casa(int id, int numHabitaciones, boolean garaje, String calle, int numero,
        Estado estado,
        double precio, int superficie, int numPisos, boolean piscina) {
        super(id, numHabitaciones, garaje, calle, numero, estado, precio, superficie);
        this.numPisos = numPisos;
        this.piscina = this.piscina;
    }

    public int getNumPisos() {
        return numPisos;
    }

    public void setNumPisos(int numPisos) {
        this.numPisos = numPisos;
    }

    public boolean isPicina() {
        return piscina;
    }

    public void setPicina(boolean picina) {
        this.piscina = picina;
    }

    public double precioVenta(Inmueble inmueble) {
        double precio = inmueble.getSuperficie() * 1000 + getNumPisos() * 20000;
        if(isPicina()) {
            precio += 50000;
        } else if (isGaraje()) {
            precio += 30000;
        }
        return precio;
    }

    @Override
    public String toString() {
        return "Casa{" +
            "numPisos=" + numPisos +
            ", piscina=" + piscina +
            '}';
    }

}
