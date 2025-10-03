public class Main {
    public static void main(String[] args) {

        PreguntaCorta preguntaCorta = new PreguntaCorta("¿Capital de Italia?", "Roma");
        PreguntaNumerica preguntaNumerica = new PreguntaNumerica("¿Cuánto es 2 + 2?", 4);
        PreguntaBool preguntaBooleana = new PreguntaBool("¿Es Madrid la capital de Italia?", false);

        Pregunta<String> preguntaCortaG = new Pregunta<>("¿Capital de Portugal?", "Lisboa");
        Pregunta<Integer> preguntaNumericaG = new Pregunta<>("¿Cuánto es 2 + 6?", 8);
        Pregunta<Boolean> preguntaBooleanaG = new Pregunta<>("¿Es Oporto la capital de Portugal?", false);

        System.out.println("Preguntas no genéricas:");

        System.out.println(preguntaCorta.getPregunta() + " Respuesta: " + preguntaCortaG.getRespuesta());
        System.out.println(preguntaNumerica.getPregunta() + " Respuesta: " + preguntaNumerica.getRespuesta());
        System.out.println(preguntaBooleana.getPregunta() + " Respuesta: " + preguntaBooleana.getRespuesta());

        System.out.println("Preguntas genéricas:");

        System.out.println(preguntaCortaG.getPregunta() + " Respuesta: " + preguntaCortaG.getRespuesta());
        System.out.println(preguntaNumericaG.getPregunta() + " Respuesta: " + preguntaNumerica.getRespuesta());
        System.out.println(preguntaBooleanaG.getPregunta() + " Respuesta: " + preguntaBooleana.getRespuesta());

    }
}