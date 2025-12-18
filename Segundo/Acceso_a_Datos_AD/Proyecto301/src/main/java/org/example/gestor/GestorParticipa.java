package org.example.gestor;

import org.example.entities.EventoDO;
import org.example.entities.ParticipaDO;
import org.example.entities.ParticipaId;
import org.example.entities.PersonajeDO;
import org.example.menu.Inputs;
import org.example.repositories.Repository;
import org.hibernate.Session;

import java.time.LocalDate;
import java.util.Optional;

public class GestorParticipa {
    private static GestorParticipa participa;

    public static GestorParticipa instance() {
        if (participa == null) {
            participa = new GestorParticipa();
        }
        return participa;
    }

    public void registrarParticipacion(Session session) {
        Repository<PersonajeDO> repoPersonaje = new Repository<>(session);
        Repository<EventoDO> repoEvento = new Repository<>(session);
        Repository<ParticipaDO> repoParticipa = new Repository<>(session);

        // 1) Pedir datos base
        String nombrePersonaje = Inputs.input("Nombre del personaje: ").trim().toUpperCase();
        String nombreEvento = Inputs.input("Nombre del evento: ").trim().toUpperCase();

        // 2) Buscar personaje
        Optional<PersonajeDO> personajeOpt =
                repoPersonaje.findOneByField(PersonajeDO.class, "nombre", nombrePersonaje);

        if (personajeOpt.isEmpty()) {
            System.out.println("No existe el personaje: " + nombrePersonaje);
            int op = Inputs.inputInt("1) Crear personaje  0) Cancelar: ");
            switch (op) {
                case 1 -> {
                    // Si ya tienes GestorPersonaje: GestorPersonaje.instance().crearPersonaje(session);
                    // O crea mínimo:
                    int nuevoId = repoPersonaje.nextId(PersonajeDO.class);
                    String alias = Inputs.input("Alias del personaje: ").trim().toUpperCase();
                    PersonajeDO nuevo = new PersonajeDO(nuevoId, nombrePersonaje, alias);
                    repoPersonaje.persist(nuevo);
                    personajeOpt = Optional.of(nuevo);
                }
                default -> {
                    return;
                }
            }
        }

        // 3) Buscar evento
        Optional<EventoDO> eventoOpt =
                repoEvento.findOneByField(EventoDO.class, "nombre", nombreEvento);

        if (eventoOpt.isEmpty()) {
            System.out.println("No existe el evento: " + nombreEvento);
            int op = Inputs.inputInt("1) Crear evento  0) Cancelar: ");
            switch (op) {
                case 1 -> {
                    int nuevoId = repoEvento.nextId(EventoDO.class);
                    String lugar = Inputs.input("Lugar del evento: ").trim().toUpperCase();
                    EventoDO nuevo = new EventoDO();
                    nuevo.setId(nuevoId);
                    nuevo.setNombre(nombreEvento);
                    nuevo.setLugar(lugar);
                    repoEvento.persist(nuevo);
                    eventoOpt = Optional.of(nuevo);
                }
                default -> {
                    return;
                }
            }
        }

        PersonajeDO personaje = personajeOpt.get();
        EventoDO evento = eventoOpt.get();

        // 4) Pedir rol y fecha
        String rol = Inputs.input("Rol: ").trim().toUpperCase();
        LocalDate fecha = Inputs.inputFecha("Fecha (dd/MM/yyyy): ");

        // 5) Crear ID compuesto
        ParticipaId id = new ParticipaId();
        id.setIdPersonaje(personaje.getId());
        id.setIdEvento(evento.getId());

        // 6) Si ya existe la participación (misma PK), decidir qué hacer
        ParticipaDO yaExiste = session.get(ParticipaDO.class, id);
        if (yaExiste != null) {
            System.out.println("Ya existe participación de " + nombrePersonaje + " en " + nombreEvento);
            int op = Inputs.inputInt("1) Actualizar rol/fecha  0) Cancelar: ");
            switch (op) {
                case 1 -> {
                    yaExiste.setRol(rol);
                    yaExiste.setFecha(fecha);
                    // No hace falta merge si está managed (lo está si lo obtuviste con session.get)
                    System.out.println("Participación actualizada.");
                }
                default -> {
                    return;
                }
            }
            return;
        }

        // 7) Crear ParticipaDO y persistir
        ParticipaDO participa = new ParticipaDO();
        participa.setId(id);
        participa.setPersonaje(personaje);
        participa.setEvento(evento);
        participa.setRol(rol);
        participa.setFecha(fecha);

        // Mantener consistencia bidireccional (recomendado)
        personaje.getParticipaciones().add(participa);
        evento.getParticipaciones().add(participa);

        repoParticipa.persist(participa);

        System.out.println("Participación registrada correctamente.");
    }


}



