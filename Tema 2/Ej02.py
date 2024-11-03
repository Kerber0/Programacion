# Diseñar una función que tenga como entrada tres números enteros y nos devuelva el mayor de los tres.
#  Incluir el algoritmo principal que realice la llamada a dicha función.

def mayor(a,b,c) -> (int):
  if a > b and a > c:
    return(a)
  elif b > a and b > c:
      return(b)
  else:
      return(c)

def mayor_b(a, b, c) -> int:
    mayor = a  # Asumimos que 'a' es el mayor inicialmente
    if b > mayor:
        mayor = b  # Si 'b' es mayor que 'a', actualizamos el valor de 'mayor'
    if c > mayor:
        mayor = c  # Si 'c' es mayor que el valor actual de 'mayor', lo actualizamos nuevamente
    return mayor


if __name__ == "__main__":
    num1 = int(input("Ingrese el primer número entero: "))
    num2 = int(input("Ingrese el segundo número entero: "))
    num3 = int(input("Ingrese el tercer número entero: "))
    
    resultado1 = mayor(num1, num2, num3)
    resultado2 = mayor_b(num1, num2, num3)

    print(f"El mayor de los tres números es: {resultado1}")
    print(f"El mayor de los tres números es: {resultado2}")

