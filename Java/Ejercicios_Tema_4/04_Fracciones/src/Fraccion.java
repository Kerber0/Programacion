public class Fraccion {

  private int numerador;
  private int denominador;

  public Fraccion(int numerador, int denominador) {
    if (denominador == 0) {
      this.denominador = 1;
      System.out.println("Error, el denominador no puede ser 0");

    } else {
      simplificar(numerador, denominador);
    }
  }

  private int mcd(int a, int b) {
    return (b == 0) ? Math.abs(a) : mcd(b, a % b);
  }

  private void simplificar(int num, int den) {
    int mcd = mcd(num, den);
    this.numerador = num / mcd;
    this.denominador = den / mcd;
    if (this.denominador < 0) {
      this.numerador *= -1;
      this.denominador *= -1;
    }
  }

  public int getNumerador() {
    return numerador;
  }

  public int getDenominador() {
    return denominador;
  }

  public void setNumerador(int numerador) {
    simplificar(numerador, this.denominador);
  }

  public void setDenominador(int denominador) {
    if (denominador == 0) {
      System.out.println("Error, el denominador no puede ser 0");
    } else {
      simplificar(this.numerador, denominador);
    }
  }

  public Fraccion sumar(Fraccion otra) {
    int num = this.numerador * otra.denominador + otra.numerador * this.denominador;
    int den = this.denominador * otra.denominador;
    return new Fraccion(num, den);
  }

  public Fraccion restar(Fraccion otra) {
    int num = this.numerador * otra.denominador - otra.numerador * this.denominador;
    int den = this.denominador * otra.denominador;
    return new Fraccion(num, den);
  }

  public Fraccion multiplicar(Fraccion otra) {
    int num = this.numerador * otra.numerador;
    int den = this.denominador * otra.denominador;
    return new Fraccion(num, den);
  }

  public Fraccion dividir(Fraccion otra) {
    if (otra.numerador == 0) {
      System.out.println("Error, el denominador no puede ser 0");
    }
    int num = this.numerador * otra.denominador;
    int den = this.denominador * otra.denominador;
    return new Fraccion(num, den);
  }

  @Override
  public String toString() {
    return numerador + "/" + denominador;
  }
}
