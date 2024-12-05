"""DICCIONARIOS Intermedio"""

# 6.2. Escribe un programa que invierta las claves y valores de un diccionario.
# Ejemplo de Entrada:
# {'a': 1, 'b': 2}
# Ejemplo de Salida:
# {1: 'a', 2: 'b'}


def invertir_dicc(dicc: dict) -> dict:
    dicc_invertido = {}
    for clave, valor in dicc.items():
        dicc_invertido[valor] = clave
    return dicc_invertido


print(invertir_dicc({'a': 1, 'b': 2}))


print("-----------------------------------------------------------------")

# 7.3. Implementa un programa que elimine un par clave-valor si la clave cumple con una condición específica.
# Ejemplo de Entrada:
# {'abc': 1, 'bcd': 2, 'cde': 3}
# Condición: clave empieza con 'b'
# Ejemplo de Salida:
# {'abc': 1, 'cde': 3}


def eliminar(dicc: dict) -> dict:
    nuevo_dicc = {}
    for clave, valor in dicc.items():
        if isinstance(clave, str):
            clave_min = clave.lower()  # Convertimos a minúsculas
            # Verificamos la primera letra
            if len(clave_min) > 0 and clave_min[0] != 'b':
                # Si no empieza con 'b', la agregamos al nuevo diccionario
                nuevo_dicc[clave] = valor
        else:
            # Si no es una cadena, se agrega sin cambios
            nuevo_dicc[clave] = valor
    return nuevo_dicc


print(eliminar({'abc': 1, 'bcd': 2, 'cde': 3}))

print("-----------------------------------------------------------------")


# 8.4. Convierte dos listas (una de claves y otra de valores) en un diccionario.
# Ejemplo de Entrada:
# Claves: ['a', 'b']
# Valores: [1, 2]
# Ejemplo de Salida:
# {'a': 1, 'b': 2}

def dicc_de_listas(claves: list, valores: list) -> dict:
    if len(claves) != len(valores):
        raise ValueError(
            "Las listas de claves y valores deben tener la misma longitud.")

    dicc = {}
    for i in range(len(claves)):
        # como claves y valores tienen la misma longitud, la posicion i en claves corresponde a la misma posicion en valores
        dicc[claves[i]] = valores[i]
    return dicc


print(dicc_de_listas(['a', 'b'], [1, 2]))


print("-----------------------------------------------------------------")

"""Difícil"""


# 9.1. Escribe una función que combine dos diccionarios. Si hay claves repetidas, suma los valores.
# Ejemplo de Entrada:
# Dic1: {'a': 1, 'b': 2}
# Dic2: {'b': 3, 'c': 4}
# Ejemplo de Salida:
# {'a': 1, 'b': 5, 'c': 4}


def suma_dicc(dicc1: dict, dicc2: dict) -> dict:
    nuevo_dicc = {}
    for clave in dicc1:
        if clave in dicc2:
            nuevo_dicc[clave] = dicc1[clave] + dicc2[clave]
        else:
            nuevo_dicc[clave] = dicc1[clave]

    for clave in dicc2:
        if clave not in dicc1:
            nuevo_dicc[clave] = dicc2[clave]

    return nuevo_dicc


print(suma_dicc({'a': 1, 'b': 2}, {'b': 3, 'c': 4}))

print("-----------------------------------------------------------------")


# 10.2. Crea un diccionario anidado para representar un grupo de estudiantes y sus notas.
# Escribe una función para calcular el promedio de notas de un estudiante dado.
# Ejemplo de Entrada:
# {'Juan': [5, 6], 'Ana': [7, 8]}
# Estudiante: 'Ana'
# Ejemplo de Salida:
# Promedio: 7.5

def promedio_notas(dicc: dict, n: str) -> float:
    try:
        for clave, valor in dicc.items():
            if n not in dicc:
                raise UnboundLocalError
            if isinstance(clave, str):
                clave_min = clave.lower()  # Convertimos a minúsculas
                if clave_min == n.lower():
                    media = sum(valor) / len(valor)
                    break
        return media
    except UnboundLocalError:
        print("Error, no se encuentra el nombre del alumno proporcionado")


print(promedio_notas({'Juan': [5, 6], 'Ana': [7, 8]}, 'Ana'))
print(promedio_notas({'Juan': [5, 6], 'Ana': [7, 8]}, 'Paco'))

print("-----------------------------------------------------------------")

# 11.3. Dado un diccionario de palabras y su frecuencia, encuentra la palabra más frecuente.
# Ejemplo de Entrada:
# {'hola': 3, 'mundo': 5, 'python': 2}
# Ejemplo de Salida:
# 'mundo'


def mayor_frec(dicc: dict) -> str:
    maximo = 0
    for valor in dicc.values():
        if maximo < valor:
            maximo = valor
    for clave, valor in dicc.items():
        if valor == maximo:
            return clave


def mayor_frecV2(dicc: dict) -> str:
    maximo = 0
    clave_maxima = ''  # Inicializamos la clave que tendrá el valor máximo
    for clave, valor in dicc.items():
        if valor > maximo:  # Si encontramos un valor mayor
            maximo = valor  # Actualizamos el valor máximo
            clave_maxima = clave  # Guardamos la clave correspondiente
    return clave_maxima


print(mayor_frec({'hola': 3, 'mundo': 5, 'python': 2}))

print("-----------------------------------------------------------------")

# 12.4. Implementa un programa que ordene un diccionario por sus valores en orden descendente.
# Ejemplo de Entrada:
# {'a': 3, 'b': 1, 'c': 2}
# Ejemplo de Salida:
# {'a': 3, 'c': 2, 'b': 1}


def ordenar_dicc(dicc: dict) -> dict:
    ordenado = {}
    while len(dicc) > 0:
        actual = float('-inf')
        mayor_clave = None

        for clave, valor in dicc.items():
            if valor > actual:
                actual = valor
                mayor_clave = clave

        ordenado[mayor_clave] = actual

        dicc.pop(mayor_clave)

    return ordenado


print(ordenar_dicc({'a': 3, 'b': 1, 'c': 2}))


print("-----------------------------------------------------------------")

# Ejercicio 1: Dado un diccionario de estudiantes con sus calificaciones, selecciona un estudiante aleatorio
# y su calificación.
# Entrada esperada: {'Juan': 85, 'María': 90, 'Carlos': 78, 'Ana': 92}
# Salida esperada: Ejemplo de salida esperada: 'Carlos' -> 78

print("-----------------------------------------------------------------")

# Ejercicio 2: Crea un diccionario con países y sus capitales. Selecciona un país y muestra su capital.
# Entrada esperada: {'España': 'Madrid', 'Francia': 'París', 'Alemania': 'Berlín', 'Italia': 'Roma'}
# Salida esperada: Ejemplo de salida esperada: 'Francia' -> 'París'

print("-----------------------------------------------------------------")

# Ejercicio 3: Usa un diccionario con colores y sus códigos hexadecimales. Selecciona un color y muestra su código.
# Entrada esperada: {'Rojo': '#FF0000', 'Verde': '#00FF00', 'Azul': '#0000FF'}
# Salida esperada: Ejemplo de salida esperada: 'Azul' -> '#0000FF'

print("-----------------------------------------------------------------")

# Ejercicio 4: Dado un diccionario con productos y sus precios, selecciona un producto y muestra su precio.
# Entrada esperada: {'Café': 2.5, 'Pan': 1.0, 'Leche': 1.2, 'Azúcar': 0.8}
# Salida esperada: Ejemplo de salida esperada: 'Pan' -> 1.0

print("-----------------------------------------------------------------")

# Ejercicio 5: Crea un diccionario con nombres de personas y sus edades. Selecciona aleatoriamente una persona y muestra su edad.
# Entrada esperada: {'José': 30, 'Laura': 25, 'Pedro': 28, 'Ana': 35}
# Salida esperada: Ejemplo de salida esperada: 'Pedro' -> 28

print("-----------------------------------------------------------------")


# Ejercicio 6: Dado un diccionario con números y sus cuadrados, selecciona un número y muestra su cuadrado.
# Entrada esperada: {1: 1, 2: 4, 3: 9, 4: 16, 5: 25}
# Salida esperada: Ejemplo de salida esperada: 3 -> 9

print("-----------------------------------------------------------------")

# Ejercicio 7: Crea un diccionario con estudiantes y sus asignaturas favoritas. Selecciona un estudiante y muestra su asignatura favorita.
# Entrada esperada: {'Pedro': 'Matemáticas', 'Ana': 'Ciencias', 'Luis': 'Historia'}
# Salida esperada: Ejemplo de salida esperada: 'Luis' -> 'Historia'

print("-----------------------------------------------------------------")

# Ejercicio 8: Usa un diccionario con meses y el número de días que tiene cada uno. Selecciona un mes y muestra el número de días.
# Entrada esperada: {'Enero': 31, 'Febrero': 28, 'Marzo': 31, 'Abril': 30}
# Salida esperada: Ejemplo de salida esperada: 'Marzo' -> 31

print("-----------------------------------------------------------------")


# Ejercicio 9: Dado un diccionario con palabras y sus definiciones, selecciona una palabra y muestra su definición.
# Entrada esperada: {'Python': 'Lenguaje de programación', 'Diccionario': 'Colección de palabras y definiciones'}
# Salida esperada: Ejemplo de salida esperada: 'Python' -> 'Lenguaje de programación'

print("-----------------------------------------------------------------")

# Ejercicio 10: Crea un diccionario con nombres de ciudades y sus países. Selecciona una ciudad y muestra su país.
# Entrada esperada: {'Madrid': 'España', 'París': 'Francia', 'Roma': 'Italia'}
# Salida esperada: Ejemplo de salida esperada: 'Roma' -> 'Italia'

print("-----------------------------------------------------------------")

# Ejercicio 1: Dado un diccionario de ventas mensuales por empleado, selecciona aleatoriamente un empleado y calcula el promedio de sus ventas.
# Entrada esperada: {'Juan': [1200, 1500, 1300], 'María': [1700, 1600, 1800], 'Carlos': [1100, 1050, 1150]}
# Salida esperada: Ejemplo de salida esperada: 'Juan' -> Promedio: 1333.33

print("-----------------------------------------------------------------")

# Ejercicio 2: Usa un diccionario con estudiantes y sus calificaciones en varias materias. Selecciona un estudiante y calcula su calificación promedio.
# Entrada esperada: {'Pedro': {'Matemáticas': 85, 'Ciencias': 90}, 'Ana': {'Historia': 88, 'Ciencias': 92}}
# Salida esperada: Ejemplo de salida esperada: 'Pedro' -> Promedio: 87.5

print("-----------------------------------------------------------------")

# Ejercicio 3: Crea un diccionario con productos y listas de precios históricos. Selecciona un producto y encuentra su precio más alto.
# Entrada esperada: {'Café': [2.5, 2.8, 2.6], 'Pan': [1.0, 1.2, 1.1]}
# Salida esperada: Ejemplo de salida esperada: 'Café' -> Precio máximo: 2.8

print("-----------------------------------------------------------------")

# Ejercicio 4: Dado un diccionario de palabras y sus frecuencias en un texto, selecciona una palabra y muestra su frecuencia.
# Entrada esperada: {'Python': 45, 'es': 30, 'genial': 15}
# Salida esperada: Ejemplo de salida esperada: 'genial' -> Frecuencia: 15

print("-----------------------------------------------------------------")

# Ejercicio 5: Crea un diccionario con países, sus ciudades principales y las poblaciones de estas ciudades. Selecciona un país y calcula la población total de sus ciudades.
# Entrada esperada: {'España': {'Madrid': 3200000, 'Barcelona': 1600000}, 'Francia': {'París': 2200000, 'Lyon': 520000}}
# Salida esperada: Ejemplo de salida esperada: 'España' -> Población total: 4800000

print("-----------------------------------------------------------------")

# Ejercicio 6: Usa un diccionario con películas, sus géneros y las calificaciones. Selecciona una película y muestra su género y calificación.
# Entrada esperada: {'Inception': {'Género': 'Ciencia ficción', 'Calificación': 9.0}, 'Titanic': {'Género': 'Romance', 'Calificación': 8.5}}
# Salida esperada: Ejemplo de salida esperada: 'Titanic' -> Género: Romance, Calificación: 8.5

print("-----------------------------------------------------------------")

# Ejercicio 7: Dado un diccionario con empleados y su historial de horas trabajadas por semana, selecciona un empleado y calcula sus horas totales trabajadas.
# Entrada esperada: {'Laura': [40, 42, 38], 'José': [45, 48, 50]}
# Salida esperada: Ejemplo de salida esperada: 'José' -> Total: 143 horas

print("-----------------------------------------------------------------")

# Ejercicio 8: Crea un diccionario con categorías de productos y listas de productos. Selecciona una categoría y muestra todos sus productos.
# Entrada esperada: {'Frutas': ['Manzana', 'Banana'], 'Verduras': ['Zanahoria', 'Lechuga']}
# Salida esperada: Ejemplo de salida esperada: 'Verduras' -> ['Zanahoria', 'Lechuga']

print("-----------------------------------------------------------------")

# Ejercicio 9: Usa un diccionario de meses con listas de temperaturas diarias. Selecciona un mes y calcula la temperatura promedio del mes.
# Entrada esperada: {'Enero': [15, 16, 15, 14], 'Febrero': [13, 14, 15]}
# Salida esperada: Ejemplo de salida esperada: 'Enero' -> Promedio: 15.0°C

print("-----------------------------------------------------------------")

# Ejercicio 10: Dado un diccionario con nombres de equipos y sus puntuaciones en diferentes partidos, selecciona un equipo y encuentra su puntuación máxima.
# Entrada esperada: {'Equipo A': [3, 1, 4, 2], 'Equipo B': [5, 2, 3, 1]}
# Salida esperada: Ejemplo de salida esperada: 'Equipo A' -> Máximo: 4
