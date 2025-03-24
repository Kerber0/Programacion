public class Operaciones {
    private Cliente cliente;
    private Inmueble inmueble;
    public Tipo tipo;
    public  enum Tipo {VENTA, COMPRA}

    public Operaciones(Cliente cliente, Inmueble inmueble, Tipo tipo) {
        this.cliente = cliente;
        this.inmueble = inmueble;
        this.tipo = tipo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Inmueble getInmueble() {
        return inmueble;
    }

    public void setInmueble(Inmueble inmueble) {
        this.inmueble = inmueble;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }



    @Override
    public String toString() {
        return "Operacion: " + tipo + " de " + inmueble + " al cliente " + cliente;}


    }