package ejercicio;

import ejercicio.menus.Menus;

import java.util.ArrayList;
import java.util.HashSet;

public class Main {
    public static void main(String[] arg) {
        final Concesionario concesionario = new Concesionario(
                Generador.vehiculos(10),
                new HashSet<>(),
                new ArrayList<>()
        );
        new Menus(concesionario).principal();
    }
}
