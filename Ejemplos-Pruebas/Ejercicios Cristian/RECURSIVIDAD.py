# Ponme todo tipo diferente de ejercicios que se te ocurran sobre recursividad con funciones y listas de listas.

# Diseñar una función que devuelva el número de elementos de una lista de listas. La función debe recibir una lista de listas
#  como argumento y devolver un entero con el número total de elementos.
# Detalla lo que haces en cada línea de código.

def numero_elementos(lista: list) -> int:
    if lista == []:
        return 0
    return len(lista[0]) + numero_elementos(lista[1:])

# Diseñar una función que devuelva el número de listas que contiene una lista de listas. La función debe recibir una lista de 
# listas como argumento y devolver un entero con el número total de listas.

def numero_listas(lista: list) -> int:
    if lista == []:
        return 0
    return 1 + numero_listas(lista[1:])

# Diseñar una función que devuelva el número de elementos de la lista más larga de una lista de listas. La función debe
#  recibir una lista de listas como argumento y devolver un entero con el número total de elementos de la lista más larga.

def elementos_lista_mas_larga(lista: list) -> int:
    if lista == []:
        return 0
    return max(len(lista[0]), elementos_lista_mas_larga(lista[1:]))

# Otro ejercicio sobre recursividad sin listas.

# Diseñar una función que devuelva el número de veces que se repite un número en una lista. La función debe recibir una lista 
# y un número como argumentos y devolver un entero con el número de veces que se repite el número en la lista.

def repeticiones(lista: list, numero: int) -> int:
    if lista == []:
        return 0
    return (1 if lista[0] == numero else 0) + repeticiones(lista[1:], numero)

# Recursividad tipo factorial.

# Diseñar una función que devuelva el factorial de un número. La función debe recibir un número entero como argumento y
#  devolver un entero con el factorial del número.

def factorial(numero: int) -> int:
    if numero == 0:
        return 1
    return numero * factorial(numero - 1)

# Fibonacci.

# Diseñar una función que devuelva el número de la serie de Fibonacci en una posición determinada. La función debe recibir
#  un número entero como argumento y devolver un entero con el número de la serie de Fibonacci en la posición indicada.

def fibonacci(numero: int) -> int:
    if numero == 0:
        return 0
    if numero == 1:
        return 1
    return fibonacci(numero - 1) + fibonacci(numero - 2)

# Potencia.

# Diseñar una función que devuelva la potencia de un número. La función debe recibir dos números enteros como argumentos 
# y devolver un entero con el resultado de elevar el primer número al segundo número.

def potencia(base: int, exponente: int) -> int:
    if exponente == 0:
        return 1
    return base * potencia(base, exponente - 1)

# Suma de los elementos de una lista.

# Diseñar una función que devuelva la suma de los elementos de una lista. La función debe recibir una lista de enteros 
# como argumento y devolver un entero con la suma de los elementos de la lista.

def suma_lista(lista: list) -> int:
    if lista == []:
        return 0
    return lista[0] + suma_lista(lista[1:])

# Inversión de una lista.

# Diseñar una función que devuelva una lista invertida. La función debe recibir una lista como argumento y devolver una 
# lista con los elementos de la lista original en orden inverso.

def invertir_lista(lista: list) -> list:
    if lista == []:
        return []
    return invertir_lista(lista[1:]) + [lista[0]]

# Diseñar una función que devuelva una lista con los elementos de una lista de listas en orden inverso. La función debe
#  recibir una lista de listas como argumento y devolver una lista con los elementos de la lista original en orden inverso.

def invertir_lista_de_listas(lista: list) -> list:
    if lista == []:
        return []
    return invertir_lista_de_listas(lista[1:]) + [invertir_lista(lista[0])]

# Más ejemplos diferentes de ejercicios sobre recursividad con funciones y listas de listas.

# Tablero de ajedrez.

# Diseñar una función que devuelva un tablero de ajedrez. La función debe recibir dos números enteros como argumentos y
#  devolver una lista de listas con el tablero de ajedrez.

def tablero_ajedrez(filas: int, columnas: int) -> list:
    if filas == 0:
        return []
    return [tablero_ajedrez(filas - 1, columnas)] + [tablero_ajedrez_columnas(columnas, filas)]

def tablero_ajedrez_columnas(columnas: int, fila: int) -> list:
    if columnas == 0:
        return []
    return [(fila + columnas) % 2] + tablero_ajedrez_columnas(columnas - 1, fila)

# Con matrices.

# Diseñar una función que devuelva el número de elementos de una matriz. La función debe recibir una matriz como argumento 
# y devolver un entero con el número total de elementos.

def numero_elementos_matriz(matriz: list) -> int:
    if matriz == []:
        return 0
    return len(matriz[0]) + numero_elementos_matriz(matriz[1:])

# Diseñar una función que devuelva el número de filas de una matriz. La función debe recibir una matriz como argumento y
#  devolver un entero con el número total de filas.

def numero_filas_matriz(matriz: list) -> int:
    if matriz == []:
        return 0
    return 1 + numero_filas_matriz(matriz[1:])

# Diseñar una función que devuelva el número de columnas de una matriz. La función debe recibir una matriz como argumento
#  y devolver un entero con el número total de columnas.

def numero_columnas_matriz(matriz: list) -> int:
    if matriz == []:
        return 0
    return len(matriz[0])  

# Diseñar una función que devuelva el número de elementos de la fila más larga de una matriz. La función debe recibir una
#  matriz como argumento y devolver un entero con el número total de elementos de la fila más larga.

def elementos_fila_mas_larga(matriz: list) -> int:
    if matriz == []:
        return 0
    return max(len(matriz[0]), elementos_fila_mas_larga(matriz[1:]))

# Matriz de ceros.

# Diseñar una función que devuelva una matriz de ceros. La función debe recibir dos números enteros como argumentos y 
# devolver una matriz de ceros con el número de filas y columnas indicado.

def matriz_ceros(filas: int, columnas: int) -> list:
    if filas == 0:
        return []
    return [[0] * columnas] + matriz_ceros(filas - 1, columnas)

# Matriz identidad.

# Diseñar una función que devuelva una matriz identidad. La función debe recibir un número entero como argumento y devolver
#  una matriz identidad de ese tamaño.

def matriz_identidad(tamano: int) -> list:
    if tamano == 0:
        return []
    return [matriz_identidad_columnas(tamano, tamano)] + matriz_identidad(tamano - 1)

def matriz_identidad_columnas(columnas: int, tamano: int) -> list:
    if columnas == 0:
        return []
    return [(1 if columnas == tamano else 0)] + matriz_identidad_columnas(columnas - 1, tamano)


# Función factorial con try except.

def factorial(numero: int) -> int:
    try:
        if numero == 0:
            return 1
        return numero * factorial(numero - 1)
    except RecursionError:
        return "Número demasiado grande."
    
# Error de la función factorial con un número negativo.

def factorial(numero: int) -> int:
    if numero < 0:
        return "Número negativo."
    if numero == 0:
        return 1
    return numero * factorial(numero - 1)

# Try except tabla de multiplicar.

def tabla_multiplicar(numero: int) -> int:
    try:
        if numero == 0:
            return 0
        return f"{numero} x {numero} = {numero * numero}\n{tabla_multiplicar(numero - 1)}"
    except RecursionError:
        return "Número demasiado grande."
    
# Tabla de multiplicar que el número salga de un input introducido por el usuario.

def tabla_multiplicar(numero: int) -> int:
    if numero == 0:
        return 0
    return f"{numero} x {numero} = {numero * numero}\n{tabla_multiplicar(numero - 1)}"

if __name__ == "__main__":
    print(tabla_multiplicar(int(input("Introduce un número: "))))
    
# Tabla de multiplicar del 1 al 10.

def tabla_multiplicar(numero: int) -> int:
    if numero == 0:
        return 0
    return f"{numero} x {numero} = {numero * numero}\n{tabla_multiplicar(numero - 1)}"

if __name__ == "__main__":
    print(tabla_multiplicar(10))

# Tabla de multiplicar del 1*1, 1*2, 1*3, 1*4, 1*5, 1*6, 1*7, 1*8, 1*9, 1*10, hasta 10*10.

def tabla_multiplicar(numero: int) -> int:
    if numero == 0:
        return 0
    return f"{numero} x {numero} = {numero * numero}\n{tabla_multiplicar(numero - 1)}"

if __name__ == "__main__":
    print(tabla_multiplicar(100))
    
# Que solo sea recursivo en un lado de la multiplicación.

def tabla_multiplicar(numero: int) -> int:
    if numero == 0:
        return 0
    return f"{numero} x 10 = {numero * 10}\n{tabla_multiplicar(numero - 1)}"

if __name__ == "__main__":
    print(tabla_multiplicar(10))

# Ahora para que el número salga de un input introducido por el usuario.

def tabla_multiplicar(numero: int) -> int:
    if numero == 0:
        return 0
    return f"{numero} x 10 = {numero * 10}\n{tabla_multiplicar(numero - 1)}"

if __name__ == "__main__":
    print(tabla_multiplicar(int(input("Introduce un número: "))))
    
# Ahora un menú con las diferenes tablas de multiplicar. La tabla del 1, la tabla del 2, la tabla del 3, la tabla del 4, 
# la tabla del 5, la tabla del 6, la tabla del 7, la tabla del 8, la tabla del 9, la tabla del 10.

def tabla_multiplicar(numero: int) -> int:
    if numero == 0:
        return 0
    return f"{numero} x 10 = {numero * 10}\n{tabla_multiplicar(numero - 1)}"


def tabla_multiplicar_menu(numero: int) -> int:
    if numero == 0:
        return 0
    return f"Tabla del {numero}\n{tabla_multiplicar(numero)}\n{tabla_multiplicar_menu(numero - 1)}"



if __name__ == "__main__":
    print(tabla_multiplicar_menu(10))
    

          
        