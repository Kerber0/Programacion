import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Crear un NIF con constructor vacío y usar leer()
        DNI persona1 = new DNI();
        persona1.leer(); // Ahora sí modifica el objeto
        System.out.println(persona1);

        // Crear un NIF con un número dado
        DNI persona2 = new DNI(12345678);
        System.out.println(persona2);
    }
}
