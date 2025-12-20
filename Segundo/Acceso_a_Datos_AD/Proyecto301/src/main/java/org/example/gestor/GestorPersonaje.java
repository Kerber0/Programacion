package org.example.gestor;

import org.example.entities.ParticipaDO;
import org.example.entities.PersonajeDO;
import org.example.entities.TrajeDO;
import org.example.menu.Inputs;
import org.example.repositories.Repository;
import org.hibernate.Session;

public class GestorPersonaje {
    private static GestorPersonaje personaje;

    public static GestorPersonaje instance() {
        if (personaje == null) {
            personaje = new GestorPersonaje();
        }
        return personaje;
    }

    public void crearPersonaje(Session session) {
        Repository<PersonajeDO> repoPersonaje = new Repository<>(session);
        Repository<TrajeDO> repoTraje = new Repository<>(session);

        int nuevoId = repoPersonaje.nextId(PersonajeDO.class);

        String nombre = Inputs.input("Nombre: ").trim().toUpperCase();
        if (repoPersonaje.existsByField(PersonajeDO.class, "nombre", nombre)) {
            System.out.println("Nombre de personaje ya existe.");
            return;
        }

        String alias = Inputs.input("Alias: ").trim().toUpperCase();

        PersonajeDO personaje = new PersonajeDO(nuevoId, nombre, alias);

        System.out.println("""
            ¿Desea asignar un traje?
            1 - No asignar traje
            2 - Asignar traje existente
            3 - Crear traje nuevo
            """);

        int opcion = Inputs.inputInt("Opción: ");

        switch (opcion) {
            case 1 -> {
            }

            case 2 -> {
                int idTraje = Inputs.inputInt("ID del traje existente: ");
                TrajeDO traje = repoTraje.findById(TrajeDO.class, idTraje);

                if (traje == null) {
                    System.out.println("No existe un traje con ese ID.");
                    return;
                }

                if (traje.getPersonaje() != null) {
                    System.out.println("Ese traje ya está asignado a otro personaje.");
                    return;
                }

                personaje.setTraje(traje);
            }

            case 3 -> {
                int nuevoIdTraje = repoTraje.nextId(TrajeDO.class);
                String especificacion = Inputs.input("Especificación del traje: ");

                TrajeDO traje = new TrajeDO();
                traje.setId(nuevoIdTraje);
                traje.setEspecificacion(especificacion);

                repoTraje.persist(traje);
                personaje.setTraje(traje);
            }

            default -> {
                System.out.println("Opción inválida.");
                return;
            }
        }

        repoPersonaje.persist(personaje);
        System.out.println("Personaje creado con ID: " + personaje.getId());
    }


    public void borrarPersonajePorId(Session session) {
        int id = Inputs.inputInt("Id a eliminar: ");
        Repository<PersonajeDO> repo = new Repository<>(session);


        PersonajeDO personaje = repo.findById(PersonajeDO.class, id);
        if (personaje == null) {
            System.out.println("No se encuentra ese id");
            return;
        }
        Repository<ParticipaDO> repoParticipa = new Repository<>(session);

        personaje.getHabilidades().clear();
        personaje.setTraje(null);
        personaje.getParticipaciones().forEach(repoParticipa::remove);
        personaje.getParticipaciones().clear();

        repo.remove(personaje);
        System.out.println("Personaje eliminado correctamente.");
    }

    public void modificarPersonajePorId(Session session) {
        int id = Inputs.inputInt("Id: ");
        Repository<PersonajeDO> repo = new Repository<>(session);

        PersonajeDO personaje = repo.findById(PersonajeDO.class, id);
        if (personaje == null) {
            System.out.println("No existe un personaje con ese ID.");
            return;
        }
        System.out.println("Actual: nombre=" + personaje.getNombre() + ", alias=" + personaje.getAlias());
        String nuevoNombre = Inputs.inputOpcional("Nuevo nombre (Enter para mantener): ").trim().toUpperCase();;
        if (!nuevoNombre.isBlank()) {
            if (repo.existsByField(PersonajeDO.class, "nombre", nuevoNombre)) {
                System.out.println("Ya existe un personaje con ese nombre.");
                return;
            }
            personaje.setNombre(nuevoNombre);
        }

        String nuevoAlias = Inputs.inputOpcional("Nuevo alias (Enter para mantener): ").trim().toUpperCase();;
        if (!nuevoAlias.isBlank()) {
            personaje.setAlias(nuevoAlias);
        }

        System.out.println("Personaje actualizado.");
    }

    public void mostrarDatosDePersonaje(Session session) {
        int id = Inputs.inputInt("ID del personaje: ");
        Repository<PersonajeDO> repo = new Repository<>(session);

        PersonajeDO personaje = repo.findById(PersonajeDO.class, id);
        if (personaje == null) {
            System.out.println("No existe un personaje con ese ID.");
            return;
        }

        // ===== DATOS BÁSICOS =====
        System.out.println("=================================");
        System.out.println("ID: " + personaje.getId());
        System.out.println("Nombre: " + personaje.getNombre());
        System.out.println("Alias: " + personaje.getAlias());

        // ===== TRAJE =====
        System.out.println("\n--- Traje ---");
        if (personaje.getTraje() != null) {
            System.out.println(personaje.getTraje().getEspecificacion());
        } else {
            System.out.println("Sin traje asignado.");
        }

        // ===== HABILIDADES =====
        System.out.println("\n--- Habilidades ---");
        if (personaje.getHabilidades().isEmpty()) {
            System.out.println("No tiene habilidades.");
        } else {
            personaje.getHabilidades()
                    .forEach(h -> System.out.println("- " + h.getNombre()));
        }

        // ===== EVENTOS / PARTICIPACIONES =====
        System.out.println("\n--- Participaciones en eventos ---");
        if (personaje.getParticipaciones().isEmpty()) {
            System.out.println("No ha participado en eventos.");
        } else {
            personaje.getParticipaciones().forEach(p -> {
                System.out.println("Evento: " + p.getEvento().getNombre());
                System.out.println("Lugar: " + p.getEvento().getLugar());
                System.out.println("Rol: " + p.getRol());
                System.out.println("Fecha: " + p.getFecha());
                System.out.println("-------------------------");
            });
        }

        System.out.println("=================================");
    }

}
