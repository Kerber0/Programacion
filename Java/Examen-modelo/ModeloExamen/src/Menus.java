public class Menus {

  private final Album album;

  public Menus(Album album) {
    this.album = album;
  }

  public static void principal(){
    System.out.println("Bienvenido a su discografia!");
    System.out.println("""
                        Seleccione la opción deseada:
                          [1] - Mostrar todos los album.
                          [2] - Añadir un nuebo álbum a la colección.
                          [3] - Editar un álbum existente.
                          [4] - Eliminar un álbum de la colección.
                          [5] - Salir del programa.
                        """);

  }

  public void editar(){
    System.out.println("""
        Seleccione lo que desea editar:
        [1] - Nombre del álbum.
        [2] - Nombre del artista/grupo.
        [3] - Año de publicación.
        [4] - Número de canciones del álbum.
        [5] - Salir.
        """);
  }
}
