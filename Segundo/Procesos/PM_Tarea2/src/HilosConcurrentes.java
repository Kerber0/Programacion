static class HiloSimple extends Thread {
    private String nombre;

    public HiloSimple(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Ejecución " + i + " del " + nombre);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(nombre + " interrumpido.");
            }
        }
        System.out.println(nombre + " ha terminado.");
    }
}

public static void main(String[] args) {
    HiloSimple h1 = new HiloSimple("Hilo A");
    HiloSimple h2 = new HiloSimple("Hilo B");
    HiloSimple h3 = new HiloSimple("Hilo C");

    h1.start();
    h2.start();
    h3.start();

    for (int i = 1; i <= 5; i++) {
        System.out.println(">> Hilo principal (main) ejecución " + i);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("Hilo principal interrumpido.");
        }
    }

    System.out.println("Hilo principal terminado.");
}
