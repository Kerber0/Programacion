package org.example.gestor;

import org.example.menu.Inputs;
import org.hibernate.Session;

import java.util.List;

public class GestorEvento {
    private static GestorEvento evento;

    public static GestorEvento instance() {
        if (evento == null) {
            evento = new GestorEvento();
        }
        return evento;
    }

    public void mostrarParticipantesDeEvento(Session session) {
        String nombreEvento = Inputs.input("Nombre del evento: ").trim().toUpperCase();

        List<Object[]> filas = session.createQuery("""
                select p.personaje.nombre, p.personaje.alias, p.rol, p.fecha
                from ParticipaDO p
                join p.evento e
                where upper(e.nombre) = :nombre
                order by p.fecha asc, p.personaje.nombre asc
                """, Object[].class)
                .setParameter("nombre", nombreEvento)
                .getResultList();

        if (filas.isEmpty()) {
            System.out.println("No existe el evento o no tiene participaciones: " + nombreEvento);
            return;
        }

        System.out.println("===== Participantes del evento: " + nombreEvento + " =====");
        for (Object[] f : filas) {
            String nombre = (String) f[0];
            String alias  = (String) f[1];
            String rol    = (String) f[2];
            Object fecha  = f[3]; // LocalDate
            System.out.println("- " + nombre + " (" + alias + ") | Rol: " + rol + " | Fecha: " + fecha);
        }
    }

}
