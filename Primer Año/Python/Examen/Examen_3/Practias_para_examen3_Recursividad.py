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


# Busacar un parametro en tuplas recursivamente

def recursivtup(tup: tuple, search):
    if len(tup) == 0:
        return False
    if isinstance(tup[-1], tuple):
        for i in tup[-1]:
            if i == search:
                return True
    else:
        if tup[-1] == search:
            return True
    return recursivtup(tup[0:-1], search)


print(recursivtup((1, 2, 3, (1, "este"), 4), "esta"))

print("-----------------------------------------------------------------")


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


def invertir(cadena: str) -> str:
    if len(cadena) == 0:
        return " "
    if len(cadena) > 0:
        return cadena[-1] + invertir(cadena[:-1])


print(invertir("python"))


print("-----------------------------------------------------------------")

# 20.4. Escribe un programa recursivo para contar cuántos ceros hay en un número entero.
# Ejemplo de Entrada:
# Número: 102030
# Ejemplo de Salida:
# Cantidad de ceros: 3


def contar_ceros(numero: int) -> int:

    # Convertir el número a positivo para evitar problemas con signos
    numero = abs(numero)

    # Caso base: Si el número tiene un solo dígito
    if numero == 0:
        return 1  # Si el número es 0, cuenta como un cero
    if numero < 10:
        return 0  # Un solo dígito que no es 0

    # Caso recursivo: Verificar si el último dígito es 0 y continuar con el resto
    ultimo_digito = numero % 10
    ceros_en_resto = contar_ceros(numero // 10)
    return ceros_en_resto + (1 if ultimo_digito == 0 else 0)


print(contar_ceros(102030))

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


def torre_de_hanoi(n, origen, destino, auxiliar):
    if n == 1:  # Caso base: mover un solo disco
        print(f"Mover disco 1 de {origen} a {destino}")
        return

    # Mover los n-1 discos de origen a auxiliar
    torre_de_hanoi(n - 1, origen, auxiliar, destino)

    # Mover el disco restante de origen a destino
    print(f"Mover disco {n} de {origen} a {destino}")

    # Mover los n-1 discos de auxiliar a destino
    torre_de_hanoi(n - 1, auxiliar, destino, origen)


# Ejemplo de uso con 3 discos
torre_de_hanoi(3, 'A', 'C', 'B')


print("-----------------------------------------------------------------")


# 22.2. Escribe una función recursiva para generar todas las combinaciones posibles de una lista.
# Ejemplo de Entrada:
# Lista: [1, 2]
# Ejemplo de Salida:
# Combinaciones: [[], [1], [2], [1, 2]]


def generar_combinaciones(lista):

    # Caso base: Si la lista está vacía, la única combinación es la lista vacía
    if not lista:
        return [[]]

    # Tomar el primer elemento y las combinaciones del resto de la lista
    primer_elemento = lista[0]
    combinaciones_sin_primero = generar_combinaciones(lista[1:])

    # Crear nuevas combinaciones añadiendo el primer elemento a las ya generadas
    combinaciones_con_primero = [combinacion + [primer_elemento]
                                 for combinacion in combinaciones_sin_primero]

    # Retornar la unión de ambas partes
    return combinaciones_sin_primero + combinaciones_con_primero


# Ejemplo de uso
lista = [1, 2]
print("Combinaciones posibles:", generar_combinaciones(lista))


print("-----------------------------------------------------------------")

# 23.3. Crea una función recursiva que calcule la suma de los dígitos de un número hasta obtener un solo dígito (reducir a la raíz digital).
# Ejemplo de Entrada:
# Número: 987
# Ejemplo de Salida:
# Raíz digital: 6


def raiz_digital(numero: int) -> int:

    # Convertir a positivo para manejar números negativos
    numero = abs(numero)

    # Caso base: Si el número tiene un solo dígito
    if numero < 10:
        return numero

    # Caso recursivo: Sumar los dígitos y llamar a la función de nuevo
    suma_digitos = sum(int(digito) for digito in str(numero))
    return raiz_digital(suma_digitos)


print(raiz_digital(987))

print("-----------------------------------------------------------------")

# 24.4. Implementa una función recursiva que genere todas las permutaciones de una cadena.
# Ejemplo de Entrada:
# Cadena: 'abc'
# Ejemplo de Salida:
# Permutaciones: ['abc', 'acb', 'bac', 'bca', 'cab', 'cba']


def permutaciones(cadena: str) -> list:

    # Caso base: Una cadena vacía tiene una única permutación: la vacía
    if len(cadena) == 0:
        return [""]

    # Caso recursivo
    resultado = []
    for i, letra in enumerate(cadena):
        # Excluye la letra actual y genera permutaciones del resto
        resto = cadena[:i] + cadena[i+1:]
        for permutacion in permutaciones(resto):
            resultado.append(letra + permutacion)

    return resultado


print(permutaciones('abc'))
