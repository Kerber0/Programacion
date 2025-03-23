public interface Menu {

    public default void menuPrinpial() {

        System.out.println("Bienvenido al Gestor de Inmuebles!");
        System.out.println(""" 
                            
                            [1] - Registrar un nuevo inmueble.
                            [2] - Realizar una venta o alquiler.
                            [3] - Agregar clientes a la lista de espera.
                            [4] - Buscar inmuebles disponibles.
                            [5] - Buscar cliente.
                            [6] - Mostrar el historial de tracciones recientes.
                            [7] - Asignar un inmueble a un cliente en espera.
                            [0] - Salir.
                            
                            """);
    }

     default void despedida() {
        System.out.println("Espero haberle sido de ayuda. Adios!");

    }

     default void Busqueda() {
        System.out.println("""
                Seleccione que desea buscar:
                [1] - Casa.
                [2] - Departamento.
                [2] - Local Comercial.
                [0] - Atrás.
                """);
    }

     default void accion() {

         System.out.println("""
                 Ingrese:
                  [1] - Para venta.
                  [2] - Para alquiler.
                  [0] - Atrás.
                 """);
     }

     default void tipoInmueble() {
         System.out.println("""
                [1] - Casa.
                [2] - Departamento.
                [3] - Local comercial.
                [0] - Atrás.
                """);
     }
}
