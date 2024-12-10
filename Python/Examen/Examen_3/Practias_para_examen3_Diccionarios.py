"""DICCIONARIOS Intermedio"""

# 6.2. Escribe un programa que invierta las claves y valores de un diccionario.
# Ejemplo de Entrada:
# {'a': 1, 'b': 2}
# Ejemplo de Salida:
# {1: 'a', 2: 'b'}


import random


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


def seleccionar_estudiante_aleatorio(diccionario: dict):
    # Selecciona una clave (estudiante) aleatoria del diccionario
    estudiante = random.choice(list(diccionario.keys()))

    # Obtiene la calificación del estudiante seleccionado
    calificacion = diccionario[estudiante]

    # Imprime el resultado
    print(f"{estudiante} -> {calificacion}")


# Diccionario de estudiantes y sus calificaciones
estudiantes = {'Juan': 85, 'María': 90, 'Carlos': 78, 'Ana': 92}

# Llamar a la función
seleccionar_estudiante_aleatorio(estudiantes)


print("-----------------------------------------------------------------")

# Ejercicio 2: Crea un diccionario con países y sus capitales. Selecciona un país y muestra su capital.
# Entrada esperada: {'España': 'Madrid', 'Francia': 'París', 'Alemania': 'Berlín', 'Italia': 'Roma'}
# Salida esperada: Ejemplo de salida esperada: 'Francia' -> 'París'


def seleccionar_pais_aleatorio(diccionario: dict):
    # Selecciona una clave (país) aleatoria del diccionario
    pais = random.choice(list(diccionario.keys()))

    # Obtiene la capital del país seleccionado
    capital = diccionario[pais]

    # Imprime el resultado
    print(f"{pais} -> {capital}")


# Diccionario de países y sus capitales
paises = {'España': 'Madrid', 'Francia': 'París',
          'Alemania': 'Berlín', 'Italia': 'Roma'}

# Llamar a la función
seleccionar_pais_aleatorio(paises)

print("-----------------------------------------------------------------")

# Ejercicio 3: Usa un diccionario con colores y sus códigos hexadecimales. Selecciona un color y muestra su código.
# Entrada esperada: {'Rojo': '#FF0000', 'Verde': '#00FF00', 'Azul': '#0000FF'}
# Salida esperada: Ejemplo de salida esperada: 'Azul' -> '#0000FF'


def seleccionar_color_aleatorio(diccionario: dict):
    # Selecciona una clave (color) aleatoria del diccionario
    color = random.choice(list(diccionario.keys()))

    # Obtiene el código hexadecimal del color seleccionado
    codigo_hex = diccionario[color]

    # Imprime el resultado
    print(f"{color} -> {codigo_hex}")


# Diccionario de colores y sus códigos hexadecimales
colores = {'Rojo': '#FF0000', 'Verde': '#00FF00', 'Azul': '#0000FF'}

# Llamar a la función
seleccionar_color_aleatorio(colores)

print("-----------------------------------------------------------------")

# Ejercicio 4: Dado un diccionario con productos y sus precios, selecciona un producto y muestra su precio.
# Entrada esperada: {'Café': 2.5, 'Pan': 1.0, 'Leche': 1.2, 'Azúcar': 0.8}
# Salida esperada: Ejemplo de salida esperada: 'Pan' -> 1.0


def seleccionar_producto_aleatorio(diccionario: dict):
    # Selecciona una clave (producto) aleatoria del diccionario
    producto = random.choice(list(diccionario.keys()))

    # Obtiene el precio del producto seleccionado
    precio = diccionario[producto]

    # Imprime el resultado
    print(f"{producto} -> {precio}")


# Diccionario de productos y sus precios
productos = {'Café': 2.5, 'Pan': 1.0, 'Leche': 1.2, 'Azúcar': 0.8}

# Llamar a la función
seleccionar_producto_aleatorio(productos)


print("-----------------------------------------------------------------")

# Ejercicio 5: Crea un diccionario con nombres de personas y sus edades. Selecciona aleatoriamente una persona y muestra su edad.
# Entrada esperada: {'José': 30, 'Laura': 25, 'Pedro': 28, 'Ana': 35}
# Salida esperada: Ejemplo de salida esperada: 'Pedro' -> 28


def seleccionar_persona_aleatoria(diccionario: dict):
    # Selecciona una clave (persona) aleatoria del diccionario
    persona = random.choice(list(diccionario.keys()))

    # Obtiene la edad de la persona seleccionada
    edad = diccionario[persona]

    # Imprime el resultado
    print(f"{persona} -> {edad}")


# Diccionario de personas y sus edades
personas = {'José': 30, 'Laura': 25, 'Pedro': 28, 'Ana': 35}

# Llamar a la función
seleccionar_persona_aleatoria(personas)

print("-----------------------------------------------------------------")


# Ejercicio 6: Dado un diccionario con números y sus cuadrados, selecciona un número y muestra su cuadrado.
# Entrada esperada: {1: 1, 2: 4, 3: 9, 4: 16, 5: 25}
# Salida esperada: Ejemplo de salida esperada: 3 -> 9

def seleccionar_numero_aleatorio(diccionario: dict):
    # Selecciona una clave (número) aleatoria del diccionario
    numero = random.choice(list(diccionario.keys()))

    # Obtiene el cuadrado del número seleccionado
    cuadrado = diccionario[numero]

    # Imprime el resultado
    print(f"{numero} -> {cuadrado}")


# Diccionario de números y sus cuadrados
numeros = {1: 1, 2: 4, 3: 9, 4: 16, 5: 25}

# Llamar a la función
seleccionar_numero_aleatorio(numeros)

print("-----------------------------------------------------------------")

# Ejercicio 7: Crea un diccionario con estudiantes y sus asignaturas favoritas. Selecciona un estudiante y muestra su asignatura favorita.
# Entrada esperada: {'Pedro': 'Matemáticas', 'Ana': 'Ciencias', 'Luis': 'Historia'}
# Salida esperada: Ejemplo de salida esperada: 'Luis' -> 'Historia'


def seleccionar_estudiante(diccionario: dict):
    # Selecciona una clave (estudiante) aleatoria del diccionario
    estudiante = random.choice(list(diccionario.keys()))

    # Obtiene la asignatura favorita del estudiante seleccionado
    asignatura = diccionario[estudiante]

    # Imprime el resultado
    print(f"{estudiante} -> {asignatura}")


# Diccionario de estudiantes y sus asignaturas favoritas
estudiantes = {'Pedro': 'Matemáticas', 'Ana': 'Ciencias', 'Luis': 'Historia'}

# Llamar a la función
seleccionar_estudiante(estudiantes)

print("-----------------------------------------------------------------")

# Ejercicio 8: Usa un diccionario con meses y el número de días que tiene cada uno. Selecciona un mes y muestra el número de días.
# Entrada esperada: {'Enero': 31, 'Febrero': 28, 'Marzo': 31, 'Abril': 30}
# Salida esperada: Ejemplo de salida esperada: 'Marzo' -> 31


def seleccionar_mes(diccionario: dict):
    # Selecciona una clave (mes) aleatoria del diccionario
    mes = random.choice(list(diccionario.keys()))

    # Obtiene el número de días del mes seleccionado
    dias = diccionario[mes]

    # Imprime el resultado
    print(f"{mes} -> {dias} días")


# Diccionario de meses y el número de días
meses = {'Enero': 31, 'Febrero': 28, 'Marzo': 31, 'Abril': 30}

# Llamar a la función
seleccionar_mes(meses)

print("-----------------------------------------------------------------")


# Ejercicio 9: Dado un diccionario con palabras y sus definiciones, selecciona una palabra y muestra su definición.
# Entrada esperada: {'Python': 'Lenguaje de programación', 'Diccionario': 'Colección de palabras y definiciones'}
# Salida esperada: Ejemplo de salida esperada: 'Python' -> 'Lenguaje de programación'

def mostrar_definicion(diccionario: dict):
    # Selecciona aleatoriamente una palabra
    palabra = random.choice(list(diccionario.keys()))

    # Obtiene la definición correspondiente a la palabra
    definicion = diccionario[palabra]

    print(f"'{palabra}' -> '{definicion}'")


# Diccionario con palabras y sus definiciones
diccionario = {
    'Python': 'Lenguaje de programación',
    'Diccionario': 'Colección de palabras y definiciones'
}

# Llamar a la función para mostrar la palabra y su definición
mostrar_definicion(diccionario)

print("-----------------------------------------------------------------")

# Ejercicio 10: Crea un diccionario con nombres de ciudades y sus países. Selecciona una ciudad y muestra su país.
# Entrada esperada: {'Madrid': 'España', 'París': 'Francia', 'Roma': 'Italia'}
# Salida esperada: Ejemplo de salida esperada: 'Roma' -> 'Italia'


def mostrar_pais(diccionario: dict):
    # Selecciona aleatoriamente una ciudad
    ciudad = random.choice(list(diccionario.keys()))

    # Obtiene el país correspondiente a la ciudad
    pais = diccionario[ciudad]

    print(f"'{ciudad}' -> '{pais}'")


# Diccionario con ciudades y sus países
ciudades = {
    'Madrid': 'España',
    'París': 'Francia',
    'Roma': 'Italia'
}

# Llamar a la función para mostrar la ciudad y su país
mostrar_pais(ciudades)

print("-----------------------------------------------------------------")

# Ejercicio 1: Dado un diccionario de ventas mensuales por empleado, selecciona aleatoriamente un empleado y calcula el promedio de sus ventas.
# Entrada esperada: {'Juan': [1200, 1500, 1300], 'María': [1700, 1600, 1800], 'Carlos': [1100, 1050, 1150]}
# Salida esperada: Ejemplo de salida esperada: 'Juan' -> Promedio: 1333.33


def calcular_promedio_ventas(diccionario: dict):
    # Selecciona aleatoriamente un empleado
    empleado = random.choice(list(diccionario.keys()))

    # Obtiene las ventas del empleado seleccionado
    ventas = diccionario[empleado]

    # Calcula el promedio de ventas
    promedio = sum(ventas) / len(ventas)

    print(f"'{empleado}' -> Promedio: {promedio:.2f}")


# Diccionario con ventas mensuales por empleado
ventas = {
    'Juan': [1200, 1500, 1300],
    'María': [1700, 1600, 1800],
    'Carlos': [1100, 1050, 1150]
}

# Llamar a la función para calcular y mostrar el promedio
calcular_promedio_ventas(ventas)


print("-----------------------------------------------------------------")

# Ejercicio 2: Usa un diccionario con estudiantes y sus calificaciones en varias materias. Selecciona un estudiante y calcula su calificación promedio.
# Entrada esperada: {'Pedro': {'Matemáticas': 85, 'Ciencias': 90}, 'Ana': {'Historia': 88, 'Ciencias': 92}}
# Salida esperada: Ejemplo de salida esperada: 'Pedro' -> Promedio: 87.5


def calcular_promedio(diccionario: dict, estudiante: str):
    # Obtiene las calificaciones del estudiante seleccionado
    calificaciones = diccionario.get(estudiante, {})

    # Si el estudiante existe y tiene calificaciones
    if calificaciones:
        promedio = sum(calificaciones.values()) / \
            len(calificaciones)  # Calcula el promedio
        print(f"'{estudiante}' -> Promedio: {promedio:.2f}")
    else:
        print(
            f"El estudiante '{estudiante}' no se encuentra en el diccionario.")


# Diccionario con estudiantes y sus calificaciones en varias materias
estudiantes = {
    'Pedro': {'Matemáticas': 85, 'Ciencias': 90},
    'Ana': {'Historia': 88, 'Ciencias': 92}
}

# Llamar a la función con el estudiante deseado
calcular_promedio(estudiantes, 'Pedro')


print("-----------------------------------------------------------------")

# Ejercicio 3: Crea un diccionario con productos y listas de precios históricos. Selecciona un producto y encuentra su precio más alto.
# Entrada esperada: {'Café': [2.5, 2.8, 2.6], 'Pan': [1.0, 1.2, 1.1]}
# Salida esperada: Ejemplo de salida esperada: 'Café' -> Precio máximo: 2.8


def precio_maximo(diccionario: dict, producto: str):
    # Obtiene la lista de precios del producto seleccionado
    precios = diccionario.get(producto, [])

    # Si el producto existe y tiene precios registrados
    if precios:
        precio_maximo = max(precios)  # Encuentra el precio más alto
        print(f"'{producto}' -> Precio máximo: {precio_maximo}")
    else:
        print(f"El producto '{producto}' no se encuentra en el diccionario.")


# Diccionario con productos y precios históricos
productos = {'Café': [2.5, 2.8, 2.6], 'Pan': [1.0, 1.2, 1.1]}

# Llamar a la función con el producto deseado
precio_maximo(productos, 'Café')

print("-----------------------------------------------------------------")

# Ejercicio 4: Dado un diccionario de palabras y sus frecuencias en un texto, selecciona una palabra y muestra su frecuencia.
# Entrada esperada: {'Python': 45, 'es': 30, 'genial': 15}
# Salida esperada: Ejemplo de salida esperada: 'genial' -> Frecuencia: 15


def mostrar_frecuencia(diccionario: dict, palabra: str):
    # Obtiene la frecuencia de la palabra seleccionada
    frecuencia = diccionario.get(palabra, 0)

    # Imprime el resultado
    print(f"'{palabra}' -> Frecuencia: {frecuencia}")


# Diccionario con palabras y sus frecuencias
frecuencias = {'Python': 45, 'es': 30, 'genial': 15}

# Llamar a la función con la palabra deseada
mostrar_frecuencia(frecuencias, 'genial')

print("-----------------------------------------------------------------")

# Ejercicio 5: Crea un diccionario con países, sus ciudades principales y las poblaciones de estas ciudades. Selecciona un país y calcula la población total de sus ciudades.
# Entrada esperada: {'España': {'Madrid': 3200000, 'Barcelona': 1600000}, 'Francia': {'París': 2200000, 'Lyon': 520000}}
# Salida esperada: Ejemplo de salida esperada: 'España' -> Población total: 4800000


def calcular_poblacion_total(diccionario: dict, pais: str):
    # Obtiene las ciudades del país seleccionado
    ciudades = diccionario.get(pais, {})

    # Calcula la población total sumando las poblaciones de las ciudades
    poblacion_total = sum(ciudades.values())

    # Imprime el resultado
    print(f"{pais} -> Población total: {poblacion_total}")


# Diccionario con países, sus ciudades principales y las poblaciones
paises = {
    'España': {'Madrid': 3200000, 'Barcelona': 1600000},
    'Francia': {'París': 2200000, 'Lyon': 520000}
}

# Llamar a la función con el país deseado
calcular_poblacion_total(paises, 'España')

print("-----------------------------------------------------------------")

# Ejercicio 6: Usa un diccionario con películas, sus géneros y las calificaciones. Selecciona una película y muestra su género y calificación.
# Entrada esperada: {'Inception': {'Género': 'Ciencia ficción', 'Calificación': 9.0}, 'Titanic': {'Género': 'Romance', 'Calificación': 8.5}}
# Salida esperada: Ejemplo de salida esperada: 'Titanic' -> Género: Romance, Calificación: 8.5


def mostrar_pelicula(diccionario: dict):
    # Selecciona una película aleatoria del diccionario
    pelicula = random.choice(list(diccionario.keys()))

    # Obtiene el género y la calificación de la película seleccionada
    genero = diccionario[pelicula]['Género']
    calificacion = diccionario[pelicula]['Calificación']

    # Imprime el resultado
    print(f"{pelicula} -> Género: {genero}, Calificación: {calificacion}")


# Diccionario de películas con sus géneros y calificaciones
peliculas = {
    'Inception': {'Género': 'Ciencia ficción', 'Calificación': 9.0},
    'Titanic': {'Género': 'Romance', 'Calificación': 8.5}
}

# Llamar a la función
mostrar_pelicula(peliculas)

print("-----------------------------------------------------------------")

# Ejercicio 7: Dado un diccionario con empleados y su historial de horas trabajadas por semana, selecciona un empleado y calcula sus horas totales trabajadas.
# Entrada esperada: {'Laura': [40, 42, 38], 'José': [45, 48, 50]}
# Salida esperada: Ejemplo de salida esperada: 'José' -> Total: 143 horas


def calcular_horas(diccionario: dict):
    # Selecciona un empleado aleatorio del diccionario
    empleado = random.choice(list(diccionario.keys()))

    # Obtiene la lista de horas trabajadas del empleado seleccionado
    horas = diccionario[empleado]

    # Calcula las horas totales trabajadas sumando las horas de la lista
    total_horas = sum(horas)

    # Imprime el resultado
    print(f"{empleado} -> Total: {total_horas} horas")


# Diccionario de empleados con su historial de horas trabajadas por semana
empleados = {'Laura': [40, 42, 38], 'José': [45, 48, 50]}

# Llamar a la función
calcular_horas(empleados)

print("-----------------------------------------------------------------")

# Ejercicio 8: Crea un diccionario con categorías de productos y listas de productos. Selecciona una categoría y muestra todos sus productos.
# Entrada esperada: {'Frutas': ['Manzana', 'Banana'], 'Verduras': ['Zanahoria', 'Lechuga']}
# Salida esperada: Ejemplo de salida esperada: 'Verduras' -> ['Zanahoria', 'Lechuga']


def mostrar_productos(diccionario: dict):
    # Selecciona una categoría aleatoria del diccionario
    categoria = random.choice(list(diccionario.keys()))

    # Obtiene la lista de productos de la categoría seleccionada
    productos = diccionario[categoria]

    # Imprime el resultado
    print(f"{categoria} -> {productos}")


# Diccionario de categorías de productos con listas de productos
productos = {'Frutas': ['Manzana', 'Banana'],
             'Verduras': ['Zanahoria', 'Lechuga']}

# Llamar a la función
mostrar_productos(productos)

print("-----------------------------------------------------------------")

# Ejercicio 9: Usa un diccionario de meses con listas de temperaturas diarias. Selecciona un mes y calcula la temperatura promedio del mes.
# Entrada esperada: {'Enero': [15, 16, 15, 14], 'Febrero': [13, 14, 15]}
# Salida esperada: Ejemplo de salida esperada: 'Enero' -> Promedio: 15.0°C


def temperatura_promedio(diccionario: dict):
    # Selecciona un mes aleatorio del diccionario
    mes = random.choice(list(diccionario.keys()))

    # Obtiene la lista de temperaturas del mes seleccionado
    temperaturas = diccionario[mes]

    # Calcula la temperatura promedio
    promedio = sum(temperaturas) / len(temperaturas)

    # Imprime el resultado
    print(f"{mes} -> Promedio: {promedio:.1f}°C")


# Diccionario de meses con las temperaturas diarias
meses = {'Enero': [15, 16, 15, 14], 'Febrero': [13, 14, 15]}

# Llamar a la función
temperatura_promedio(meses)

print("-----------------------------------------------------------------")

# Ejercicio 10: Dado un diccionario con nombres de equipos y sus puntuaciones en diferentes partidos, selecciona un equipo y encuentra su puntuación máxima.
# Entrada esperada: {'Equipo A': [3, 1, 4, 2], 'Equipo B': [5, 2, 3, 1]}
# Salida esperada: Ejemplo de salida esperada: 'Equipo A' -> Máximo: 4


def puntuacion_maxima(diccionario: dict):
    # Selecciona un equipo aleatorio del diccionario
    equipo = random.choice(list(diccionario.keys()))

    # Obtiene la lista de puntuaciones del equipo seleccionado
    puntuaciones = diccionario[equipo]

    # Encuentra la puntuación máxima
    puntuacion_max = max(puntuaciones)

    # Imprime el resultado
    print(f"{equipo} -> Máximo: {puntuacion_max}")


# Diccionario de equipos y sus puntuaciones
equipos = {'Equipo A': [3, 1, 4, 2], 'Equipo B': [5, 2, 3, 1]}

# Llamar a la función
puntuacion_maxima(equipos)
