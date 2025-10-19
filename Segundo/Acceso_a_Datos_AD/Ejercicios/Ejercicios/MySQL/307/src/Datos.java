import java.util.Scanner;

public class Datos {
    static Scanner sc = new Scanner(System.in);

    public static String input(String text) {
        String resultado;
        do {
            System.out.println(text);
            resultado = sc.nextLine();
            if (resultado.isEmpty()) {
                System.out.println("Se debe ingresar algo.");
            }
        } while (resultado.isEmpty());
        return resultado;
    }

    public static int inputInt(String text) {
        int num = -1;
        boolean valido = false;
        while (!valido) {
            try {
                System.out.println(text);
                num = Integer.parseInt(sc.nextLine());
                valido = true;
            } catch (NumberFormatException e) {
                System.out.println("Error: Por favor ingrese un número válido.");
            }
        }
        return num;
    }
}
