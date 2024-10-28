# Diseñar una función que permita calcular el número e, o número de Euler, mediante la siguiente
# serie infinita: e = 1/0! + 1/1! + 1/2! + 1/3! + 1/4! + ... para una precisión dada por el usuario, 
# la precisión indicará las vueltas que debe dar el algoritmo a la serie infinita. Incluir el algoritmo 
# principal que realice la llamada a dicha función. Como paso previo, se puede diseñar una función que 
# calcule el factorial de un número entero.

"""
Funcion factorial

numero = int(input("Introduzca el número: "))
factorial = 1
for x in range (1, numero+1): 
    factorial *= x
"""
def factorial(n):
  if n == 0:
    return 1
  else:
    return n * factorial(n-1)
print(factorial(5))