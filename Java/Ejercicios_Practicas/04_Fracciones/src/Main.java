public class Main {

  public static void main(String[] args) {
    Fraccion f1 = new Fraccion(4, 8); // Se simplifica automáticamente a 1/2
    Fraccion f2 = new Fraccion(3, 9); // Se simplifica a 1/3
    Fraccion f3 = new Fraccion(5, 0);

    System.out.println(f1);
    System.out.println(f2);
    System.out.println(f3);

    System.out.println("Fracción 1: " + f1);
    System.out.println("Fracción 2: " + f2);

    // Operaciones
    System.out.println("Suma: " + f1.sumar(f2));          // 1/2 + 1/3 = 5/6
    System.out.println("Resta: " + f1.restar(f2));        // 1/2 - 1/3 = 1/6
    System.out.println("Multiplicación: " + f1.multiplicar(f2)); // 1/2 * 1/3 = 1/6
    System.out.println("División: " + f1.dividir(f2));    // (1/2) ÷ (1/3) = 3/2
  }
}