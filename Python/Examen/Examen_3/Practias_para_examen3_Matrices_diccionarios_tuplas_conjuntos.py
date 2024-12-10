"""Principiante: Matrices, diccionarios y tuplas"""
# 1.1. Crea una matriz 3x3 y almacena la suma de cada fila en un diccionario, donde las claves sean tuplas con los índices de cada fila.
#    Ejemplo de entrada: [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
#    Salida esperada: {(0,): 6, (1,): 15, (2,): 24}

# Crear la matriz 3x3
import random
matriz = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]

# Crear el diccionario para almacenar las sumas
suma_filas = {}

# Calcular la suma de cada fila y almacenarla en el diccionario
for i, fila in enumerate(matriz):
    suma_filas[(i,)] = sum(fila)

print(suma_filas)


print("-----------------------------------------------------------------")


# 2.2. Dado un diccionario que asocia números con tuplas de coordenadas, crea una matriz de ceros y llena las posiciones indicadas por las tuplas con los números correspondientes.
#    Ejemplo de entrada: {1: (0, 0), 2: (1, 1), 3: (2, 2)}
#    Salida esperada: [[1, 0, 0], [0, 2, 0], [0, 0, 3]]

# Diccionario de entrada
diccionario = {1: (0, 0), 2: (1, 1), 3: (2, 2)}

# Determinar el tamaño de la matriz
n = 0
for _, (fila, columna) in diccionario.items():
    n = max(n, fila, columna)  # n = al mayor de tres valores(n, fila, columna)
n += 1  # Incrementar en 1 porque los índices comienzan desde 0

# Crear una matriz de ceros de tamaño n x n
matriz = []
for i in range(n):
    fila = []
    for j in range(n):
        fila.append(0)
    matriz.append(fila)

# Llenar la matriz con los números del diccionario
for numero, (fila, columna) in diccionario.items():
    matriz[fila][columna] = numero

# Imprimir la matriz
for fila in matriz:
    print(fila)

print("-----------------------------------------------------------------")

# 3.3. Convierte una matriz 2x3 en un diccionario donde las claves sean tuplas de índices (i, j) y los valores sean los elementos de la matriz.
#    Ejemplo de entrada: [[5, 6], [7, 8], [9, 10]]
#    Salida esperada: {(0, 0): 5, (0, 1): 6, (1, 0): 7, (1, 1): 8, (2, 0): 9, (2, 1): 10}

# Matriz de entrada
matriz = [[5, 6], [7, 8], [9, 10]]

# Crear el diccionario
diccionario = {}
for i in range(len(matriz)):  # Recorrer filas
    for j in range(len(matriz[i])):  # Recorrer columnas
        diccionario[(i, j)] = matriz[i][j]

# Imprimir el diccionario resultante
print(diccionario)

print("-----------------------------------------------------------------")


# 4.4. Genera una matriz de 4x4 con números aleatorios entre 1 y 10, luego guarda en un diccionario cuántas veces aparece cada número.
#    Ejemplo de entrada: [[1, 2], [2, 3], [3, 4], [4, 5]]
#    Salida esperada: {1: 1, 2: 2, 3: 2, 4: 2, 5: 1}


# Generar matriz 4x4 con números aleatorios entre 1 y 10
matriz = [[random.randint(1, 10) for _ in range(4)] for _ in range(4)]

# Imprimir la matriz generada
print("Matriz generada:")
for fila in matriz:
    print(fila)

# Crear el diccionario para contar las ocurrencias
conteo = {}

# Contar los números en la matriz
for fila in matriz:
    for numero in fila:
        if numero in conteo:
            conteo[numero] += 1
        else:
            conteo[numero] = 1

# Imprimir el diccionario con las ocurrencias
print("\nConteo de ocurrencias:")
print(conteo)

print("-----------------------------------------------------------------")


"""Avanzado: Matrices, diccionarios y conjuntos"""


# 21.1. Crea una matriz 5x5 y llena un conjunto con los elementos únicos de la matriz.
#    Ejemplo de entrada: [[1, 2], [2, 3], [3, 1], [1, 2]]
#    Salida esperada: {1, 2, 3}

matriz = [[1, 2], [2, 3], [3, 1], [1, 2]]

elementos_unicos = set()

# Recorrer la matriz y agregar los elementos al conjunto
for fila in matriz:
    for elemento in fila:
        elementos_unicos.add(elemento)

# Imprimir el conjunto con los elementos únicos
print(elementos_unicos)


print("-----------------------------------------------------------------")


# Dada una lista de listas que contiene pares de números, escribe un programa que elimine las sublistas duplicadas
# y luego convierta la lista restante en un diccionario. Cada sublista debe ser convertida en una tupla, y las tuplas
# únicas deben convertirse en un diccionario donde la primera parte de la tupla se usará como clave y la segunda parte como valor.


# Lista de listas original
diccionario = [[1, 2], [2, 3], [3, 1], [1, 2]]

# Convertir las sublistas en tuplas y usar un conjunto para eliminar duplicados
conjunto = set(tuple(item) for item in diccionario)

# Convertir el conjunto a un diccionario (asumimos que las tuplas tienen 2 elementos: clave y valor)
diccionario = dict(conjunto)

# Imprimir el resultado
print(diccionario)
print("-----------------------------------------------------------------")


# 22.2. Genera una matriz aleatoria 3x3 y crea un diccionario que relacione cada valor único con su posición (en forma de conjunto de tuplas).
#    Ejemplo de entrada: [[1, 1, 2], [3, 3, 3], [2, 2, 2]]
#    Salida esperada: {1: {(0, 0), (0, 1)}, 2: {(0, 2), (2, 0), (2, 1), (2, 2)}, 3: {(1, 0), (1, 1), (1, 2)}}

# Generar una matriz aleatoria 3x3 con números entre 1 y 5
matriz = [[random.randint(1, 5) for _ in range(3)] for _ in range(3)]

# Crear un diccionario vacío para almacenar los valores y sus posiciones
diccionario = {}

# Recorrer la matriz y agregar las posiciones a un conjunto para cada valor único
for i in range(3):
    for j in range(3):
        valor = matriz[i][j]
        if valor not in diccionario:
            diccionario[valor] = set()
        diccionario[valor].add((i, j))

# Imprimir la matriz y el diccionario
print("Matriz generada:")
for fila in matriz:
    print(fila)

print("\nDiccionario de valores con sus posiciones:")
print(diccionario)

print("-----------------------------------------------------------------")


# 23.3. Llena una matriz 4x4 con números aleatorios entre 1 y 5 y elimina los duplicados utilizando conjuntos.
#    Ejemplo de entrada: [[1, 1, 1], [1, 1, 1], [1, 1, 1]]
#    Salida esperada: {1}

matriz = [
    [random.randint(1, 5) for _ in range(4)] for _ in range(4)
]

# Crear un conjunto para almacenar los elementos únicos
elementos_unicos = set()

# Recorrer la matriz y agregar los elementos al conjunto
for fila in matriz:
    for elemento in fila:
        elementos_unicos.add(elemento)

# Imprimir el conjunto con los elementos únicos
print("Matriz:")
for fila in matriz:
    print(fila)

print("\nElementos únicos en la matriz:", elementos_unicos)

print("-----------------------------------------------------------------")


# 24.4. Convierte una matriz 2x3 en un conjunto con todos sus elementos únicos y muestra cuántos elementos únicos contiene.
#    Ejemplo de entrada: [[1, 2, 3], [4, 5, 6]]
#    Salida esperada: 6

matriz = [[1, 2, 2, 6, 3, 3], [4, 1, 5, 5, 4, 6]]

# Convertir la matriz a un conjunto de elementos únicos
elementos_unicos = set()

# Recorrer la matriz y agregar los elementos al conjunto
for fila in matriz:
    for elemento in fila:
        elementos_unicos.add(elemento)

# Imprimir la cantidad de elementos únicos
print(len(elementos_unicos))
