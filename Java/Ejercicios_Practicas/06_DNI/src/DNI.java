import java.util.Scanner;

public class DNI {

  private int numero;
  private String letra;

  public DNI() {
    this.letra = " ";
  }

  public DNI(int numero) {
    this.numero = numero;
    this.letra = calculoLetra(numero);
  }

  public int getNumero() {
    return numero;
  }

  public String getLetra() {
    return letra;
  }

  public void leer() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Ingrese el número de DNI: ");
    this.numero = sc.nextInt();
    this.letra = calculoLetra(this.numero);
    sc.close();
  }

  private String calculoLetra(int num) {
    return switch (num % 23) {
      case 0 -> "T";
      case 12 -> "N";
      case 1 -> "R";
      case 13 -> "J";
      case 2 -> "W";
      case 14 -> "Z";
      case 3 -> "A";
      case 15 -> "S";
      case 4 -> "G";
      case 16 -> "Q";
      case 5 -> "M";
      case 17 -> "V";
      case 6 -> "Y";
      case 18 -> "H";
      case 7 -> "F";
      case 19 -> "L";
      case 8 -> "P";
      case 20 -> "C";
      case 9 -> "D";
      case 21 -> "K";
      case 10 -> "X";
      case 22 -> "E";
      case 11 -> "B";
      default -> throw new IllegalStateException("Valor inesperado: " + num);
    };
  }

  @Override
  public String toString() {
    return "DNI: " + numero + "-" + letra;
  }
}
