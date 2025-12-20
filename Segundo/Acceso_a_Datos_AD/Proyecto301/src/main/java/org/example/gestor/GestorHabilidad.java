package org.example.gestor;

import org.example.entities.EventoDO;
import org.example.entities.HabilidadDO;
import org.example.entities.PersonajeDO;
import org.example.menu.Inputs;
import org.example.repositories.Repository;
import org.hibernate.Session;

import java.util.Optional;

public class GestorHabilidad {
    private static GestorHabilidad habilidad;

    public static GestorHabilidad instance() {
        if (habilidad == null) {
            habilidad = new GestorHabilidad();
        }
        return habilidad;
    }

    public void crearHabilidad(Session session) {
        Repository<HabilidadDO> repo = new Repository<>(session);

        int id = repo.nextId(HabilidadDO.class);

        String nombre = Inputs.input("Nombre: ").trim().toUpperCase();
        ;
        if (repo.existsByField(HabilidadDO.class, "nombre", nombre)) {
            System.out.println("Ya existe una habilidad con ese nombre.");
            return;
        }

        String descripcion = Inputs.input("Descripcion habilidad: ").trim().toUpperCase();
        ;

        HabilidadDO nuevaHabilidad = new HabilidadDO(id, nombre, descripcion);

        repo.persist(nuevaHabilidad);
        System.out.println("Habilidad creada con ID: " + nuevaHabilidad.getId());
    }

    public void borrarHabilidadPorNombre(Session session) {
        Repository<HabilidadDO> repo = new Repository<>(session);

        String nombre = Inputs.input("Nombre: ").trim().toUpperCase();

        Optional<HabilidadDO> habilidadOpt =
                repo.findOneByField(HabilidadDO.class, "nombre", nombre);

        if (habilidadOpt.isEmpty()) {
            System.out.println("No existe una habilidad con el nombre " + nombre);
            return;
        }

        HabilidadDO habilidad = habilidadOpt.get();


        new java.util.HashSet<>(habilidad.getPersonajes())
                .forEach(p -> p.getHabilidades().remove(habilidad));

        habilidad.getPersonajes().clear();

        repo.remove(habilidad);

        System.out.println("Habilidad eliminada con éxito.");
    }


    public void modificarHabilidadPorNombre(Session session) {
        Repository<HabilidadDO> repo = new Repository<>(session);

        String nombre = Inputs.input("Nombre: ").trim().toUpperCase();
        ;
        Optional<HabilidadDO> habilidadOpt =
                repo.findOneByField(HabilidadDO.class, "nombre", nombre);

        if (habilidadOpt.isEmpty()) {
            System.out.println("No existe habilidad con el nombre " + nombre);
            return;
        }

        HabilidadDO habilidad = habilidadOpt.get();

        System.out.println("Actual: Nombre: " + habilidad.getNombre() + ", descripcion :" + habilidad.getDescripcion());

        String nuevoNombre = Inputs.input("Nuevo nombre: ").trim().toUpperCase();
        ;
        if (!nuevoNombre.isBlank()) {
            if (repo.existsByField(HabilidadDO.class, "nombre", nuevoNombre)) {
                System.out.println("Ya existe una habilidad con ese nombre.");
                return;
            }
            habilidad.setNombre(nuevoNombre);
        }

        String nuevoDescripcion = Inputs.inputOpcional("Nueva descripcion (Enter para mantener): ").trim().toUpperCase();
        ;
        if (!nuevoDescripcion.isBlank()) {
            habilidad.setDescripcion(nuevoDescripcion);
        }

        System.out.println("Habilidad actualizada.");
    }

    public void asignarHabilidadAPersonaje(Session session) {
        Repository<PersonajeDO> repoPer = new Repository<>(session);
        Repository<HabilidadDO> repoHab = new Repository<>(session);

        String nombrePersonaje = Inputs.input("Nombre del personaje: ").trim().toUpperCase();
        String nombreHabilidad = Inputs.input("Nombre de la habilidad: ").trim().toUpperCase();

        Optional<PersonajeDO> personajeOpt =
                repoPer.findOneByField(PersonajeDO.class, "nombre", nombrePersonaje);

        if (personajeOpt.isEmpty()) {
            System.out.println("No existe personaje con nombre: " + nombrePersonaje);
            return;
        }

        Optional<HabilidadDO> habilidadOpt =
                repoHab.findOneByField(HabilidadDO.class, "nombre", nombreHabilidad);

        if (habilidadOpt.isEmpty()) {
            System.out.println("No existe habilidad con nombre: " + nombreHabilidad);
            return;
        }

        PersonajeDO personaje = personajeOpt.get();
        HabilidadDO habilidad = habilidadOpt.get();

        // Evitar duplicados
        if (personaje.getHabilidades().contains(habilidad)) {
            System.out.println("Ese personaje ya tiene asignada esa habilidad.");
            return;
        }

        personaje.getHabilidades().add(habilidad);
        habilidad.getPersonajes().add(personaje);

        System.out.println("Habilidad asignada correctamente.");
    }

    public void contarPersonajesConHabilidad(Session session) {

        String nombre = Inputs.input("Nombre de la habilidad: ")
                .trim()
                .toUpperCase();

        Long total = session.createQuery("""
        select count(p)
        from PersonajeDO p
        join p.habilidades h
        where h.nombre = :nombre
    """, Long.class)
                .setParameter("nombre", nombre)
                .getSingleResult();

        if (total == 0) {
            System.out.println("No hay personajes con la habilidad " + nombre);
        } else {
            System.out.println(
                    "Cantidad de personajes con la habilidad " + nombre + ": " + total
            );
        }
    }


}
