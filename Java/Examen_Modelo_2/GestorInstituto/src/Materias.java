public  class Materias {
    private String nombre;
    private int primerNota;
    private int segundaNota;
    private int terceraNota;
    private double promedio;

    public Materias(String nombre, int primerNota, int segundaNota, int terceraNota) {
        this.nombre = nombre;
        this.primerNota = primerNota;
        this.segundaNota = segundaNota;
        this.terceraNota = terceraNota;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrimerNota() {
        return primerNota;
    }

    public void setPrimerNota(int primerNota) {
        this.primerNota = primerNota;
    }

    public int getSegundaNota() {
        return segundaNota;
    }

    public void setSegundaNota(int segundaNota) {
        this.segundaNota = segundaNota;
    }

    public int getTerceraNota() {
        return terceraNota;
    }

    public void setTerceraNota(int terceraNota) {
        this.terceraNota = terceraNota;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

     public double calcularPromedio() {
        return  (double) (primerNota + segundaNota + terceraNota) / 3;
     }

    @Override
    public String toString() {
        return  nombre +
                " Primer nota: " + primerNota +
                ", Segunda nota: " + segundaNota +
                ", Tercera nota: " + terceraNota +
                ", promedio: " + calcularPromedio()
                + "\n";
    }
}
