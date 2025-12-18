package org.example.gestor;

import org.hibernate.Session;

public class GestorEvento {
    private static GestorEvento evento;

    public static GestorEvento instance() {
        if (evento == null) {
            evento = new GestorEvento();
        }
        return evento;
    }

    public void mostrarParticipantesDeEvento(Session session) {
    } //TODO Se pedirá por teclado el nombre del personaje, el nombre del evento,
    // TODO el rol y la fecha de participación

}
