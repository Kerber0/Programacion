public class Bicicleta extends Vehiculo {
    enum Tipo {MONTANA, CARRETERA, CIUDAD};
    private Tipo tipo;

    public Bicicleta(String marca, String modelo, Tipo tipo) {
        super(marca, modelo);
        this.tipo = tipo;
    }

    public Tipo getTipo() {
        return tipo;
    }
}