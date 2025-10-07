package com.example;

public class Calculadora {

  public int sumar(int a, int b){
    return a + b;
  }

  public int restar(int a, int b){
    return a - b;
  }

  public int multiplicar(int a, int b){
    return a * b;
  }

  public double dividir(int a, int b){
    if(b == 0){
      throw new IllegalArgumentException("No se puede dividir por cero");
    }
    return (double) a / b;
  }

  public double raizCuadrada(int a){
    if(a < 0){
      throw new IllegalArgumentException("No se puede calcular la raiz cuadrada de un número negativo.");
    }
    return Math.sqrt(a);
  }



  public static void main(String[] args){
    Calculadora calculadora = new Calculadora();
    System.out.println("Suma: " + calculadora.sumar(5, 3));
    System.out.println("Restar: " + calculadora.restar(5, 3));
    System.out.println("Multiplicar: " + calculadora.multiplicar(5, 3));
    System.out.println("Division: " + calculadora.dividir(5, 3));
    System.out.println("Raíz cuadrada: " + calculadora.raizCuadrada(9));

    try {
      System.out.println("Division: " + calculadora.dividir(5, 0));
    }catch (IllegalArgumentException e){
      System.out.println(e.getMessage());
    }
    try {
      System.out.println("Raíz cuadrada: " + calculadora.raizCuadrada(-9));
    }catch (IllegalArgumentException e){
      System.out.println(e.getMessage());
    }
  }

}
