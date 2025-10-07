public class Tareas {
    private int id;
    private String descripcion;
    private boolean completada;

    public Tareas(int id, String descripcion, boolean completada) {
        this.id = id;
        this.descripcion = descripcion;
        this.completada = completada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }

    @Override
    public String toString() {
        return "Tarea" +
            "Id: " + id +
            ", Descripción de la tarea: " + descripcion +
            ", Completada: " + completada;
    }
}
