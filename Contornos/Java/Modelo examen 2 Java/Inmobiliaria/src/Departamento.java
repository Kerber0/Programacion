public class Departamento extends Inmueble {
    private int piso;
    private String letra;
    private  double expensas;
    private final boolean tieneAscensor;
    private final boolean tieneGaraje;



    public Departamento(int id, String ubicacion, double precio, double superficie, int piso, String letra, double expensas, boolean tieneAscensor, boolean tieneGaraje) {
        super(id, ubicacion, precio, superficie);
        this.piso = piso;
        this.letra = letra;
        this.expensas = expensas;
        this.tieneAscensor = tieneAscensor;
        this.tieneGaraje = tieneGaraje;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public double getExpensas() {
        return expensas;
    }

    public void setExpensas(double expensas) {
        this.expensas = expensas;
    }

    public boolean getTieneAscensor() {
        return tieneAscensor;
    }

    public boolean getTieneGaraje() {
        return tieneGaraje;
    }

}
