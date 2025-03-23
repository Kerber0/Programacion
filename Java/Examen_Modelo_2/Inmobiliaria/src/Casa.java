public class Casa extends Inmueble {
    private int numhabitaciones;
    private double gardensize;

    public Casa(int id, String ubicacion, double precio,double superficie, int numhabitaciones, double gardensize) {
        super(id, ubicacion, precio, superficie);
        this.numhabitaciones = numhabitaciones;
        this.gardensize = gardensize;
    }

    public int getNumhabitaciones() {
        return numhabitaciones;
    }

    public void setNumhabitaciones(int numhabitaciones) {
        this.numhabitaciones = numhabitaciones;
    }

    public double getGardensize() {
        return gardensize;
    }

    public void setGardensize(double gardensize) {
        this.gardensize = gardensize;
    }



}
