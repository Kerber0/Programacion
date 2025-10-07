public interface Menus {

    default void menuPrincipal() {
        System.out.println("""
                        [1] - Registrar un nuevo inmueble.
                        [2] - Poner un inmueble a la venta.
                        [3] - Poner inmueble en alquiler.
                        [4] - Listar inmuebles.
                        [5] - Eliminar inmueble.
                        [0] - Salir.
            """);
    }
    default void despedida() {
        System.out.println("Espero haberle sido de ayuda. Adios!");

    }
}
