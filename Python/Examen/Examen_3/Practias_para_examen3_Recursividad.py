"""Recursividad"""
"""Fácil"""

# 13.1. Escribe una función recursiva que calcule el factorial de un número.
# Ejemplo de Entrada:
# Número: 5
# Ejemplo de Salida:
# Factorial: 120


def factorial(n: int) -> int:
    if n == 0:
        return 1
    else:
        return n * factorial(int(n) - 1)


print(factorial(5))


print("-----------------------------------------------------------------")

# 14.2. Implementa una función recursiva para imprimir los números del 1 al n.
# Ejemplo de Entrada:
# n: 4
# Ejemplo de Salida:
# 1 2 3 4


def imprimir_1_a_n(n, actual=1):
    # Caso base: si actual supera a n, terminamos la recursión
    if actual > n:
        return
    if actual == n:
        print(actual)
    else:
        print(actual, end=" ")
    imprimir_1_a_n(n, actual + 1)


# Ejemplo de uso
imprimir_1_a_n(4)

print("-----------------------------------------------------------------")

# 15.3. Escribe una función recursiva que sume los elementos de una lista.
# Ejemplo de Entrada:
# Lista: [1, 2, 3, 4]
# Ejemplo de Salida:
# Suma: 10


def suma_lista(lista: list) -> int:
    if len(lista) == 0:
        return 0
    primer_elemento = lista[0]
    del lista[0]
    return primer_elemento + suma_lista(lista)


print(suma_lista([1, 2, 3, 4]))


print("-----------------------------------------------------------------")

# 16.4. Crea una función recursiva que determine si una palabra es un palíndromo.
# Ejemplo de Entrada:
# Palabra: 'radar'
# Ejemplo de Salida:
# Es palíndromo: True


def es_palindromo(palabra: str) -> bool:
    # Caso base: Si la longitud de la palabra es 0 o 1, es un palíndromo
    if len(palabra) <= 1:
        return True
    # Comprobar si los extremos son iguales
    if palabra[0] != palabra[-1]:
        return False
    # Llamada recursiva con la palabra sin los extremos
    return es_palindromo(palabra[1:-1])


print(es_palindromo("radar"))


print("-----------------------------------------------------------------")

"""Intermedio"""

# 17.1. Escribe una función recursiva que calcule el n-ésimo número de Fibonacci.
# Ejemplo de Entrada:
# n: 6
# Ejemplo de Salida:
# Fibonacci: 8


def fib(n):
    if n < 1:
        return None
    if n < 3:
        return 1
    return fib(n - 1) + fib(n - 2)


print(fib(6))

print("-----------------------------------------------------------------")

# 18.2. Implementa una función recursiva para encontrar el máximo común divisor (MCD) de dos números.
# Ejemplo de Entrada:
# Números: 48, 18
# Ejemplo de Salida:
# MCD: 6


def MCD(a: int, b: int) -> int:
    if b == 0:
        return a
    if b != 0:
        return MCD(b, a % b)


print(MCD(48, 18))

print("-----------------------------------------------------------------")

# 19.3. Crea una función recursiva que invierta una cadena de texto.
# Ejemplo de Entrada:
# Cadena: 'python'
# Ejemplo de Salida:
# Cadena invertida: 'nohtyp'

print("-----------------------------------------------------------------")

# 20.4. Escribe un programa recursivo para contar cuántos ceros hay en un número entero.
# Ejemplo de Entrada:
# Número: 102030
# Ejemplo de Salida:
# Cantidad de ceros: 3

print("-----------------------------------------------------------------")

"""Difícil"""

# 21.1. Implementa una función recursiva para resolver el problema de la torre de Hanoi con n discos.
# Ejemplo de Entrada:
# Número de discos: 3
# Ejemplo de Salida:
# Movimientos:
# Mover disco 1 de A a C
# Mover disco 2 de A a B
# Mover disco 1 de C a B
# Mover disco 3 de A a C
# Mover disco 1 de B a A
# Mover disco 2 de B a C
# Mover disco 1 de A a C

print("-----------------------------------------------------------------")


# 22.2. Escribe una función recursiva para generar todas las combinaciones posibles de una lista.
# Ejemplo de Entrada:
# Lista: [1, 2]
# Ejemplo de Salida:
# Combinaciones: [[], [1], [2], [1, 2]]


print("-----------------------------------------------------------------")

# 23.3. Crea una función recursiva que calcule la suma de los dígitos de un número hasta obtener un solo dígito (reducir a la raíz digital).
# Ejemplo de Entrada:
# Número: 987
# Ejemplo de Salida:
# Raíz digital: 6


print("-----------------------------------------------------------------")

# 24.4. Implementa una función recursiva que genere todas las permutaciones de una cadena.
# Ejemplo de Entrada:
# Cadena: 'abc'
# Ejemplo de Salida:
# Permutaciones: ['abc', 'acb', 'bac', 'bca', 'cab', 'cba']
