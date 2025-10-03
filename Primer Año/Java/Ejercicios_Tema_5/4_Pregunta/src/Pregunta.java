public class Pregunta <T> {

    private String pregunta;
    private T respuesta;

    public Pregunta(String pregunta, T respuesta) {
        this.pregunta = pregunta;
        this.respuesta = respuesta;
    }

    public T getRespuesta() {
        return respuesta;
    }

    public String getPregunta() {
        return pregunta;
    }
}
