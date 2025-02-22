public class Menus {

  public static void principal(){
    System.out.println("Bienvenido a su discografia!");
    System.out.println();
    switch(Integer.parseInt(Coleccion.input("""
                        Seleccione la opción deseada:
                          [1] - Mostrar todos los album.
                          [2] - Añadir un nuevo álbum a la colección.
                          [3] - Editar un álbum existente.
                          [4] - Eliminar un álbum de la colección.
                          [0] - Salir del programa.
                        """))){
      case 1 : Coleccion.mostrar();
      case 2 : Coleccion.agregar();
        break;

    }
  }

  public void editar(){
    System.out.println("""
        Seleccione lo que desea editar:
        [1] - Nombre del álbum.
        [2] - Nombre del artista/grupo.
        [3] - Año de publicación.
        [4] - Número de canciones del álbum.
        [0] - Salir.
        """);
  }

}
