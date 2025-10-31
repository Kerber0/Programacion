import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        menu();
    }

    private static void menu() {
        int opcion;
        String menu = """
                #############################
                
                Seleccione la opcion deseada:
                1 Ejecutar un comando.
                2 Ejecutar un proceso.
                3 Ejecutar proceso que no existe.
                4 Ejecutar proceso con error.
                5 Ejecutar dir en distintos directorios.
                6 Mostrar entorno del proceso.
                0 Salir.
                """;

        do {
            opcion = Inputs.inputInt(menu);
            switch (opcion) {
                case 1 -> ejecutarComando();
                case 2 -> ejecutarYReportar("cmd.exe", "/c", "dir");
                case 3 -> ejecutarYReportar("cmd.exe", "/c", "programa_que_no_existe");
                case 4 -> ejecutarYReportar("cmd.exe", "/c", "dir /e");
                case 5 -> ejecutarDirEnDistintosDirectorios();
                case 6 -> mostrarEntornoProceso();
                case 0 -> System.out.println("Adios.");

            }

        } while (opcion != 0);

    }


    private static void ejecutarComando() {
        try {
            String comando = Inputs.input("Indique el comando: ");
            Process proceso = Runtime.getRuntime().exec(new String[]{"cmd.exe", "/c", comando});
            int codigoSalida = proceso.waitFor();
            System.out.println("El proceso terminó con código: " + codigoSalida);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("\n--- Fin de la opción ---\n");
    }

    private static void ejecutarYReportar(String... cmdArray) {
        try {
            Process p = Runtime.getRuntime().exec(cmdArray);
            try (Scanner sc = new Scanner(p.getInputStream())) {
                while (sc.hasNextLine()) {
                    System.out.println(sc.nextLine());
                }
            }
            int code = p.waitFor();

            if (code != 0) {
                try (Scanner err = new Scanner(p.getErrorStream())) {
                    while (err.hasNextLine()) {
                        System.out.println("ERR> " + err.nextLine());
                    }
                }
            }

            System.out.println("Código de salida: " + code);

        }catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n--- Fin de la opción ---\n");
    }

    private static void ejecutarDirEnDistintosDirectorios() {
        ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "dir");
        File dir = pb.directory();
         if (dir == null) {
             System.out.println("Hereda el directorio actual de tu programa");
         } else System.out.println(dir);
        File[] directorios = {
                new File("C:\\"),
                new File(System.getProperty("user.home")),
                new File("C:\\Windows")
        };
        try {
            for (File d : directorios) {
                pb.directory(d);
                System.out.println("\n=== Ejecutando en: " + d.getAbsolutePath() + " ===");
                Process p = pb.start();

                try (Scanner sc = new Scanner(p.getInputStream())) {
                    while (sc.hasNextLine()) {
                        System.out.println(sc.nextLine());
                    }
                }
                p.waitFor();
            }
        }catch (Exception e ){
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void mostrarEntornoProceso() {
        ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "echo Entorno de ejecución");
        Map<String, String> env = pb.environment();

        System.out.println("=== VARIABLES DE ENTORNO DEL PROCESO ===");
        for (String clave : env.keySet()) {
            String valor = env.get(clave);
            System.out.println(clave + " = " + valor);
        }
        env.put("MI_VAR", "Hola desde Java!");
        pb.command("cmd.exe", "/c", "echo %MI_VAR%");

        try {
            Process proceso = pb.start();

            try (Scanner sc = new Scanner(proceso.getInputStream())) {
                while (sc.hasNextLine()) {
                    System.out.println(sc.nextLine());
                }
            }

            int codigo = proceso.waitFor();
            System.out.println("Código de salida: " + codigo);

        } catch (Exception e) {
            System.out.println("Error al mostrar el entorno: " + e.getMessage());
        }
    }

}