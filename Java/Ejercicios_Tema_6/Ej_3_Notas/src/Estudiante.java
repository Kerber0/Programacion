public class Estudiante {
    private String nombre;

    public Estudiante(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public String getArchivoNotas() {
        return "notas_" + nombre + ".txt";
    }
}
