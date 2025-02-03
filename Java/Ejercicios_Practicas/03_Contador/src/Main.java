public class Main {
    public static void main(String[] args) {

    Contador cont1 = new Contador();
    Contador cont2 = new Contador(5);
    Contador cont3 = new Contador(-5);

    cont1.incrementar();
    cont2.incrementar();
    cont3.incrementar();

    System.out.println("El contador1 esta en " + cont1.getCont());
    System.out.println("El contador2 esta en " + cont2.getCont());
    System.out.println("El contador3 esta en " + cont3.getCont());


    cont1.decrementar();
    cont2.decrementar();
    cont3.decrementar();

    System.out.println("El contador1 esta en " + cont1.getCont());
    System.out.println("El contador2 esta en " + cont2.getCont());
    System.out.println("El contador3 esta en " + cont3.getCont());
    }
}
