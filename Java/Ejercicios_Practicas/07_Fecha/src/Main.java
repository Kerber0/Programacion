public class Main {

  public static void main(String[] args) {
    // Crear fechas de prueba
    Fecha fecha1 = new Fecha(28, 2, 2024); // Año bisiesto
    Fecha fecha2 = new Fecha(29, 2, 2023); // Fecha inválida (2023 no es bisiesto)
    Fecha fecha3 = new Fecha(31, 12, 2023); // Último día del año

    // Verificar si la fecha es válida
    System.out.println("Fecha 1 (28/02/2024) es correcta: " + fecha1.fechaCorrecta(fecha1.getDia(),
        fecha1.getMes(), fecha1.getAnio()));
    System.out.println("Fecha 2 (29/02/2023) es correcta: " + fecha2.fechaCorrecta(fecha2.getDia(),
        fecha2.getMes(), fecha2.getAnio()));

    // Calcular la fecha siguiente con 1 día de adelanto
    System.out.println(
        "Día siguiente a 28/02/2024 (bisiesto): " + fecha1.fechaSiguiente(fecha1.getDia(),
            fecha1.getMes(), fecha1.getAnio(), 1));
    System.out.println(
        "Día siguiente a 31/12/2023: " + fecha3.fechaSiguiente(fecha3.getDia(), fecha3.getMes(),
            fecha3.getAnio(), 1));

    // Calcular fecha con varios días de adelanto
    System.out.println("10 días después de 25/12/2023: " + fecha3.fechaSiguiente(25, 12, 2023, 10));
    System.out.println("100 días después de 01/01/2024: " + fecha1.fechaSiguiente(1, 1, 2024, 100));

    // Comparar fechas
    System.out.println("¿28/02/2024 es mayor que 27/02/2024?: " + fecha1.esMayorQue(27, 2, 2024));
    System.out.println("¿31/12/2023 es mayor que 01/01/2024?: " + fecha3.esMayorQue(1, 1, 2024));
  }
}
