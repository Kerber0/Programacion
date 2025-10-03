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

    default String ubicacionInmueble (String ubicacion) {
        boolean valido = false;
        do {
            try {
                if (ubicacion == null || ubicacion.trim().isEmpty()) {
                    ubicacion = input("La ubicación no puede estar vacía. Intenta nuevamente.");
                } else {
                    valido = true;                 }
            } catch (NullPointerException e) {
                System.out.println("Hubo un error con la entrada. Por favor, intente nuevamente.");
            } catch (IllegalArgumentException e) {
                System.out.println("La ubicación es incorrecta, inténtelo de nuevo.");
            } catch (Exception e) {
                System.out.println("Ocurrió un error inesperado: " + e.getMessage());
            }
        } while (!valido);

        return ubicacion;
    }

    default double precioInmueble (double precio) {
        boolean valido = false;

        do {
            try {
                if (precio <= 0) {
                    throw new IllegalArgumentException("El precio debe ser mayor que 0.");
                } else {
                    valido = true;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                precio = inputDouble("Ingrese un precio válido para el inmueble: ");
            }
        } while (!valido);

        return precio;
    }

    default double superficieInmueble (double superficie) {
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
                superficie = inputDouble("Ingrese una superficie válida para el inmueble: ");
            }
        } while (!valido);

        return superficie;
    }

//***************verificación datos casa

    default int habitacionCasa(int num) {
        boolean valido = false;
        do {
            try {
                if (num <= 0) {
                    System.out.println("La casa debe tener un número de habitaciones mayor que 0.");
                    num = inputInt("Ingrese un número de habitaciones válido");
                } else {
                    valido = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Se debe ingresar un número válido.");
                num = inputInt("Ingrese un número de habitaciones válido");
            }
        } while (!valido);
        return num;
    }

    default double jardinCasa(double size) {
        boolean valido = false;
        do {
            try {
                if (size < 0) {
                    System.out.println("El jardín debe tener un tamaño mayor o igual a 0.");
                    size = inputDouble("Ingrese un tamaño válido para el jardín");
                } else {
                    valido = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Se debe ingresar un número válido.");
                size = inputDouble("Ingrese un tamaño válido para el jardín");
            }
        } while (!valido);
        return size;
    }

//***************verificación datos departamento

    default int pisoDepartamento(int piso) {
        boolean valido = false;
        do {
            try {
                if (piso <=  0) {
                    System.out.println("El número de pisos del departamento debe ser positivo.");
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

    default String letraDepartamento (String letra) {
        boolean valido = false;
        do {
            try {
                if (letra == null || letra.trim().isEmpty()) {
                    letra = input("La letra del departamento no puede estar vacía. Intenta nuevamente.");
                } else {
                    valido = true;                 }
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

    default double expensasDepartamento (double expensas) {
        boolean valido = false;
        do {
            try {
                if (expensas < 0) {
                    System.out.println("Las expensas deben tener un valor mayor que 0.");
                    expensas = inputDouble("Ingrese un importe válido para las expensas");
                } else {
                    valido = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Se debe ingresar un importe válido.");
                expensas = inputDouble("Ingrese un importe válido para las expensas.");
            }
        } while (!valido);
        return expensas;
    }



//***************verificación datos local comercial

    default String zonaLocal (String zona) {
        boolean valido = false;
        do {
            try {
                if (zona == null || zona.trim().isEmpty()) {
                    zona = input("La zona del local no puede estar vacía. Intenta nuevamente.");
                } else {
                    valido = true;                 }
            } catch (NullPointerException e) {
                System.out.println("Hubo un error con la entrada. Por favor, intente nuevamente.");
            } catch (IllegalArgumentException e) {
                System.out.println("La zona es incorrecta, inténtelo de nuevo.");
            } catch (Exception e) {
                System.out.println("Ocurrió un error inesperado: " + e.getMessage());
            }
        } while (!valido);

        return zona;
    }

//***************verificación datos cliente

    default String datoCliente (String dato) {
        while (true) {

            String nombre = input("Ingrese el " + dato + " del cliente: ");

            if (nombre.matches("^[a-zA-Z]+$")) {
                return nombre; // Devuelve el nombre válido
            } else {
                System.out.println(dato + " inválido. Solo se permiten letras sin espacios, números ni caracteres especiales.");
            }
        }
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
