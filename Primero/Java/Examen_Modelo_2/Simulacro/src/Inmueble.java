public abstract class  Inmueble {
    private int superficie;
    private int numHabitaciones;
    private boolean garaje;
    private String calle;
    private int numero;
    private Estado estado;
    private double precio;
    private int id;

    public enum Estado {
        DISPONIBLE, EN_VENTA, EN_ALQUILER
    }

    public Inmueble(int id, int numHabitaciones, boolean garaje, String calle, int numero,
        Estado estado, double precio, int superficie) {
        this.superficie = superficie;
        this.numHabitaciones = numHabitaciones;
        this.garaje = garaje;
        this.calle = calle;
        this.numero = numero;
        this.estado = estado;
        this.precio = precio;
        this.id = id;
    }

    public int getSuperficie() {
        return superficie;
    }

    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }

    public int getNumHabitaciones() {
        return numHabitaciones;
    }

    public void setNumHabitaciones(int numHabitaciones) {
        this.numHabitaciones = numHabitaciones;
    }

    public boolean isGaraje() {
        return garaje;
    }

    public void setGaraje(boolean garaje) {
        this.garaje = garaje;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getDireccion() {
        return calle + " " + numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public  abstract double precioVenta();

    public  double precioAlquiler() {
        double precio = getSuperficie() * 70;
        if(isGaraje()){
            return precio + 60;
        }else return precio;
    }

    @Override
    public String toString() {
        return "Inmueble{" +
            "superficie=" + superficie +
            ", numHabitaciones=" + numHabitaciones +
            ", garaje=" + garaje +
            ", calle='" + calle + '\'' +
            ", numero=" + numero +
            ", estado=" + estado +
            ", precio=" + precio +
            '}' + "id: " + id;
    }


}
