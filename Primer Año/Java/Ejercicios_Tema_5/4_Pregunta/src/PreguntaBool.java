public class PreguntaBool {

    private String pregunta;
    private boolean respuesta;

    public PreguntaBool(String pregunta, boolean respuesta) {
        this.pregunta = pregunta;
        this.respuesta = respuesta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public boolean getRespuesta() {
        return respuesta;
    }
}
