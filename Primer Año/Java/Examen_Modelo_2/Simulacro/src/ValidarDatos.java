import java.util.LinkedList;
import java.util.Scanner;

public interface ValidarDatos {
    Scanner sc = new Scanner(System.in);

//***************verificación datos inmueble

    default int idInmueble(int id, LinkedList<Inmueble> inmuebles) {
        boolean valido = false;

        do {
            try {
                if (id == 0) {
                    System.out.println("El ID del inmueble debe ser un número entero mayor que 0");
                    id = inputInt("Ingrese un nuevo ID para el inmueble");
                    break;
                }
                for (Inmueble inmueble : inmuebles) {
                    if (inmueble.getId() == id) {
                        System.out.println("El ID ya existe. Ingrese un ID único.");
                        id = inputInt("Ingrese un nuevo ID para el inmueble");
                        break;
                    }
                }


                valido = true;

            } catch (Exception e) {
                System.out.println("Error: El ID debe ser un número válido.");
                id = inputInt("Ingrese un ID válido para el inmueble");
            }
        } while (!valido);

        return id;
    }

    default String direccionInmueble (String ubicacion) {
        boolean valido = false;
        do {
            try {
                if (ubicacion == null || ubicacion.trim().isEmpty()) {
                    ubicacion = input("La calle no puede estar vacía. Intenta nuevamente.");
                } else {
                    valido = true;                 }
            } catch (NullPointerException e) {
                System.out.println("Hubo un error con la entrada. Por favor, intente nuevamente.");
            } catch (IllegalArgumentException e) {
                System.out.println("La calle es incorrecta, inténtelo de nuevo.");
            } catch (Exception e) {
                System.out.println("Ocurrió un error inesperado: " + e.getMessage());
            }
        } while (!valido);

        return ubicacion;
    }

    default int numeroInmueble (int superficie) {
        boolean valido = false;

        do {
            try {
                if (superficie <= 0) {
                    throw new IllegalArgumentException("El número debe ser mayor que 0.");
                } else {
                    valido = true;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                superficie = inputInt("Ingrese un número válid para el inmueble: ");
            }
        } while (!valido);

        return superficie;
    }

    default int superficieInmueble(int superficie) {
        boolean valido = false;

        do {
            try {
                if (superficie <= 0) {
                    throw new IllegalArgumentException("La superficie debe ser mayor que 0.");
                } else {
                    valido = true;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                superficie = inputInt("Ingrese una superficie válida para el inmueble: ");
            }
        } while (!valido);

        return superficie;
    }

//***************verificación datos casa

    default int pisosCasa(int num) {
        boolean valido = false;
        do {
            try {
                if (num <= 0) {
                    System.out.println("La casa debe tener un número de pisos igual o  mayor que 0.");
                    num = inputInt("Ingrese un número de pisos válido");
                } else {
                    valido = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Se debe ingresar un número válido.");
                num = inputInt("Ingrese un número de número válido");
            }
        } while (!valido);
        return num;
    }

//***************verificación datos departamento

    default int pisoDepartamento() {
        boolean valido = false;
        int piso = inputInt("Ingrese el piso del apartamento: ");
        do {

            try {
                if (piso <=  0) {
                    System.out.println("El número de pisos del apartamento debe ser positivo.");
                    piso = inputInt("Ingrese un número de piso válido");
                } else {
                    valido = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Se debe ingresar un número válido.");
                piso = inputInt("Ingrese un número de piso válido");
            }
        } while (!valido);
        return piso;
    }

    default String letraDepartamento () {
        boolean valido = false;
        String letra = input("ingrese la letra del departamento: ");
        do {
            try {
                if (letra == null || letra.trim().isEmpty()) {
                    letra = input("La letra del departamento no puede estar vacía. Intenta nuevamente.");
                } else if (letra.length() > 2) {
                    letra =input("Solo se puede ingresar una letra. Intente nuevamente.");
                } else {
                    valido = true;
                }
            } catch (NullPointerException e) {
                System.out.println("Hubo un error con la entrada. Por favor, intente nuevamente.");
            } catch (IllegalArgumentException e) {
                System.out.println("La letra es incorrecta, inténtelo de nuevo.");
            } catch (Exception e) {
                System.out.println("Ocurrió un error inesperado: " + e.getMessage());
            }
        } while (!valido);

        return letra;
    }


//***************inputs

    private static String input(String text) {
        System.out.println(text);
        return sc.nextLine();
    }

    private static int inputInt(String text) {
        int num = 0;
        boolean valido = false;
        do {
            try {
                System.out.println(text);
                num = Integer.parseInt(sc.nextLine());
                valido = true;
            } catch (NumberFormatException e) {
                System.out.println("Error: Se debe ingresar un número válido.");
            }
        } while (!valido);
        return num;
    }

    private static Double inputDouble(String text) {
        double num = 0.0;
        boolean valido = false;
        do {
            try {
                System.out.println(text);
                num = Double.parseDouble(sc.nextLine());
                valido = true;
            } catch (NumberFormatException e) {
                System.out.println("Error: Se debe ingresar un número válido.");
            }
        } while (!valido);
        return num;
    }


}
