# Diseñar una función que permita calcular el número e, o número de Euler, mediante la siguiente
# serie infinita: e = 1/0! + 1/1! + 1/2! + 1/3! + 1/4! + ... para una precisión dada por el usuario, 
# la precisión indicará las vueltas que debe dar el algoritmo a la serie infinita. Incluir el algoritmo 
# principal que realice la llamada a dicha función. Como paso previo, se puede diseñar una función que 
# calcule el factorial de un número entero.


def factorial_recursivo(n: int) -> int:
  if n == 0:
    return 1
  else:
    return n * factorial_recursivo (int(n) -1)
    
def factorial_iterativo(n: int) -> int:
    resultado = 1
    for i in range(1, int(n) + 1):
        resultado *= i
    return resultado

if __name__ == "__main__":
  n= int(input("Ingrese el numero que desea saber su factorial: "))
  resultado1 = factorial_recursivo(n)
  resultado2 = factorial_iterativo(n)

print(resultado1)
print(resultado2)