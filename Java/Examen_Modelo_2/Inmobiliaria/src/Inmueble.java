import java.util.LinkedList;

public class Inmueble extends LinkedList<Inmueble> {
    private int id;
    private String ubicacion;
    private double precio;
    private double superficie;
    private Estado estadoActual;

    public enum Estado {
        Disponible, Vendido, Alquilado
    }

    public Inmueble(int id, String ubicacion, double precio, double superficie) {
        this.id = id;
        this.ubicacion = ubicacion;
        this.precio = precio;
        this.superficie = superficie;
        this.estadoActual = Estado.Disponible; // Valor predeterminado
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    public Estado getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(Estado estadoActual) {
        this.estadoActual = estadoActual;
    }

    @Override
    public String toString() {
        String tipoInmueble = "Inmueble";
        String detallesEspecificos = "";

        if (this instanceof Casa) {
            tipoInmueble = "Casa";
            Casa casa = (Casa) this;
            String gardensizeFormateado = String.format("%.2f", casa.getGardensize());
            detallesEspecificos = ", Cantidad habitaciones: " + casa.getNumhabitaciones() +
                    ", Tamaño jardin: " + gardensizeFormateado + "mts";
        } else if (this instanceof Departamento) {
            tipoInmueble = "Departamento";
            Departamento departamento = (Departamento) this;
            String expensasFormateadas = String.format("%.2f", departamento.getExpensas());
            detallesEspecificos = ", Piso: " + departamento.getPiso() +
                    ", Letra: " + departamento.getLetra() +
                    ", Expensas: " + expensasFormateadas + "€" +
                    ", Ascensor: " + departamento.getTieneAscensor() +
                    ", Garaje: " + departamento.getTieneGaraje();
        } else if (this instanceof LocalComercial) {
            tipoInmueble = "Local Comercial";
            LocalComercial local = (LocalComercial) this;
            detallesEspecificos = ", Zona: " + local.getZona() +
                    ", Terraza: " + local.isTerraza();
        }

        // Formatear el precio a dos decimales
        String precioFormateado = String.format("%.2f", precio);
        String superficieFormateada = String.format("%.2f", superficie);


        return tipoInmueble + " con id:" +
                id + "\n" +
                "Dirección: " + ubicacion +
                ", precio: " + precioFormateado + "€"+
                ", superficie: " + superficieFormateada + "mts"+
                detallesEspecificos +
                ", Estado: " + estadoActual
                ;
    }
}
