package org.example.menu;

import org.example.gestor.*;
import org.example.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.function.Consumer;

public class Menu {

    public void inicio() {
        int opcion;

        do {
            opcion = Inputs.inputInt("""
                    
                    ------------------------------------------------
                    
                    INGRESE LA OPCION DESEADA.
                    
                      |01| - Crear personaje.
                      |02| - Borrar personaje(por id).
                      |03| - Modificar personaje(por id).
                      |04| - Crear habilidad.
                      |05| - Borrar habilidad(por nombre).
                      |06| - Modificar habilidad(por nombre).
                      |07| - Asignar habilidad a un personaje.
                      |08| - Registrar la participación de un personaje en un evento.
                      |09| - Crear un traje.
                      |10| - Cambiar el traje de un personaje.
                      |11| - Mostrar los datos de un personaje.
                      |12| - Mostrar los personajes que participaron en un evento determinado.
                      |13| - Mostrar cuantos personajes tienen una habilidad concreta.
                      |0| - Salir.
                    
                    -----------------------------------------------
                    
                    Opcion:
                    """);

            switch (opcion) {
                case 1 -> ejecutarConTransaccion(GestorPersonaje.instance()::crearPersonaje);
                case 2 -> ejecutarConTransaccion(GestorPersonaje.instance()::borrarPersonajePorId);
                case 3 -> ejecutarConTransaccion(GestorPersonaje.instance()::modificarPersonajePorId);

                case 4 -> ejecutarConTransaccion(GestorHabilidad.instance()::crearHabilidad);
                case 5 -> ejecutarConTransaccion(GestorHabilidad.instance()::borrarHabilidadPorNombre);
                case 6 -> ejecutarConTransaccion(GestorHabilidad.instance()::modificarHabilidadPorNombre);
                case 7 -> ejecutarConTransaccion(GestorHabilidad.instance()::asignarHabilidadAPersonaje);

                case 8 -> ejecutarConTransaccion(GestorParticipa.instance()::registrarParticipacion);

                case 10 -> ejecutarConTransaccion(GestorTrajes.instance()::cambiarTrajeDePersonaje);

                case 11 -> ejecutarConTransaccion(GestorPersonaje.instance()::mostrarDatosDePersonaje);

                case 12 -> ejecutarConTransaccion(GestorEvento.instance()::mostrarParticipantesDeEvento);

                case 13 -> ejecutarConTransaccion(GestorHabilidad.instance()::contarPersonajesConHabilidad);

                case 0 -> System.out.println("Adios.");
                default -> System.out.println("Se debe ingresar una de las opciones anteriores: ");
            }


        } while (opcion != 0);
    }


    private void ejecutarConTransaccion(Consumer<Session> accion) {
        try (Session session = HibernateUtil.get().openSession()) {
            Transaction tx = session.beginTransaction();
            try {
                accion.accept(session);
                tx.commit();
            } catch (Exception e) {
                tx.rollback();
                System.out.println("Error: " + e.getMessage());
            }
        }
    }


}
