import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    DNI persona1 = new DNI();
    persona1.leer(); // Ahora sí modifica el objeto
    System.out.println(persona1);

    DNI persona2 = new DNI(12345678);
    System.out.println(persona2);
  }
}
