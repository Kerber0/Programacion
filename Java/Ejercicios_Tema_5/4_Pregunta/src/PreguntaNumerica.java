public class PreguntaNumerica {

    private String pregunta;
    private Integer respuesta;

    public PreguntaNumerica(String pregunta, Integer respuesta) {
        this.pregunta = pregunta;
        this.respuesta = respuesta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public Integer getRespuesta() {
        return respuesta;
    }
}
