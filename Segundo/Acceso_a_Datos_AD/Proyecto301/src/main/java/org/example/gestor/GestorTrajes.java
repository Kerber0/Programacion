package org.example.gestor;

import org.example.entities.PersonajeDO;
import org.example.entities.TrajeDO;
import org.example.menu.Inputs;
import org.example.repositories.Repository;
import org.hibernate.Session;

public class GestorTrajes {
    private static GestorTrajes traje;

    public static GestorTrajes instance() {
        if (traje == null) {
            traje = new GestorTrajes();
        }
        return traje;
    }



    public void cambiarTrajeDePersonaje(Session session) {

        Repository<PersonajeDO> repoPersonaje = new Repository<>(session);
        Repository<TrajeDO> repoTraje = new Repository<>(session);

        // 1️⃣ Pedimos personaje
        String nombrePersonaje = Inputs.input("Nombre del personaje: ")
                .trim().toUpperCase();

        var personajeOpt =
                repoPersonaje.findOneByField(PersonajeDO.class, "nombre", nombrePersonaje);

        if (personajeOpt.isEmpty()) {
            System.out.println("No existe un personaje con ese nombre.");
            return;
        }

        PersonajeDO personaje = personajeOpt.get();

        String especificacion = Inputs.input("Especificación del traje: ").trim();

        var trajeOpt =
                repoTraje.findOneByField(TrajeDO.class, "especificacion", especificacion);

        TrajeDO traje;

        if (trajeOpt.isEmpty()) {
            System.out.println("El traje no existe. Se creará uno nuevo.");

            int nuevoIdTraje = repoTraje.nextId(TrajeDO.class);

            traje = new TrajeDO();
            traje.setId(nuevoIdTraje);
            traje.setEspecificacion(especificacion);

            repoTraje.persist(traje);

        } else {
            traje = trajeOpt.get();

            if (traje.getPersonaje() != null) {
                System.out.println("Ese traje ya está asignado a otro personaje.");
                return;
            }
        }

        if (personaje.getTraje() != null) {
            TrajeDO trajeAnterior = personaje.getTraje();
            personaje.setTraje(null);
            trajeAnterior.setPersonaje(null);
        }

        personaje.setTraje(traje);
        traje.setPersonaje(personaje);

        System.out.println("Traje asignado correctamente a " + personaje.getNombre());
    }


}
