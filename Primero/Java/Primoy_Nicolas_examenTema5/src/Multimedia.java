public class Multimedia {
    private String nombre;
    private String plataforma;
    private  int valoracion;


    public Multimedia(String nombre, String plataforma) {
        this.nombre = nombre;
        this.plataforma = plataforma;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }

    @Override
    public String toString() {
        return "Entretenimiento{" +
            "nombre='" + nombre + '\'' +
            ", plataforma=" + plataforma +
            '}';
    }
}
