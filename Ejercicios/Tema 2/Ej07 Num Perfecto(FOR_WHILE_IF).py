# Diseñar una función que dado un número entero positivo, diga si es o no un número perfecto.
# Un número perfecto es aquel que es igual a la suma de sus divisores propios positivos. Por ejemplo,
# 6 es perfecto porque sus divisores propios son 1, 2 y 3, que suman 6. Incluir el algoritmo principal
# que realice la llamada a dicha función.


def num_perfecto(n):
    suma_div = 0
    for i in range(1, n):
        if n % i == 0:
            suma_div += i
    return suma_div


n = int(input("Ingrese un número para anlizar: "))
while n < 0:
    print("El número a analizar debe ser positivo, pruebe otra vez.")
    n = int(input(""))
if num_perfecto(n) == n:
    print("El número es perfecto")
else:
    print("El número no es perfecto")
