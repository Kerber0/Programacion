# Diseñar un lgoritmo que calcule la suma de todos los números comprendidos entre 1 y 500
# que cumplan la condición de ser múltiplos de 5 y de 7. Para verificar si un número X es
# múltiplo de otro número Y, basta con comprobar si el resto de la división entera de X
# entre Y es igual a 0.

suma = 0
for i in range(1, 500 + 1):
    if i % 5 == 0 and i % 7 == 0:
        suma += i
print(
    f"La suma de los numeros entre 1 y 500 que son multiplos de 5 y 7 es {suma}")
