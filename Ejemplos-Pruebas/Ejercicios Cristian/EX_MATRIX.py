# Ejercicios tipo examen complejos con matrices.

# Diseñar una función que devuelva el número de elementos de una matriz. La función debe recibir una matriz como argumento
#  y devolver un entero con el número total de elementos.

def numero_elementos_matriz(matriz: list) -> int:
    if matriz == []:
        return 0
    return len(matriz[0]) + numero_elementos_matriz(matriz[1:])

# Mucho más complejo.

def numero_elementos_matriz(matriz: list) -> int:
    return sum([len(fila) for fila in matriz])

# Diseñar una función que devuelva el número de filas de una matriz. La función debe recibir una matriz como argumento
#  y devolver un entero con el número total de filas.

def numero_filas_matriz(matriz: list) -> int:
    if matriz == []:
        return 0
    return 1 + numero_filas_matriz(matriz[1:])

# Mucho más complejo.

def numero_filas_matriz(matriz: list) -> int:
    return len(matriz)

# Diseñar una función que devuelva el número de columnas de una matriz. La función debe recibir una matriz como argumento 
# y devolver un entero con el número total de columnas.

def numero_columnas_matriz(matriz: list) -> int:
    if matriz == []:
        return 0
    return len(matriz[0])

# Mucho más complejo.

def numero_columnas_matriz(matriz: list) -> int:
    return len(matriz[0])

# Diseñar una función que devuelva el número de elementos de la fila más larga de una matriz. La función debe recibir una 
# matriz como argumento y devolver un entero con el número total de elementos de la fila más larga.

def elementos_fila_mas_larga(matriz: list) -> int:
    if matriz == []:
        return 0
    return max(len(matriz[0]), elementos_fila_mas_larga(matriz[1:]))
               
# Mucho más complejo.

def elementos_fila_mas_larga(matriz: list) -> int:
    return max([len(fila) for fila in matriz])

# Matriz de ceros.

# Diseñar una función que devuelva una matriz de ceros. La función debe recibir dos números enteros como argumentos y 
# devolver una matriz de ceros con el número de filas y columnas indicado.

def matriz_ceros(filas: int, columnas: int) -> list:
    if filas == 0:
        return []
    return [[0] * columnas] + matriz_ceros(filas - 1, columnas)

# Mucho más complejo.

def matriz_ceros(filas: int, columnas: int) -> list:
    return [[0] * columnas for i in range(filas)]

# Matriz identidad.

# Diseñar una función que devuelva una matriz identidad. La función debe recibir un número entero como argumento y 
# devolver una matriz identidad de ese tamaño.

def matriz_identidad(tamano: int) -> list:
    if tamano == 0:
        return []
    return [matriz_identidad_columnas(tamano, tamano)] + matriz_identidad(tamano - 1)

def matriz_identidad_columnas(columnas: int, tamano: int) -> list:
    if columnas == 0:
        return []
    return [1 if columnas == tamano else 0] + matriz_identidad_columnas(columnas - 1, tamano)


