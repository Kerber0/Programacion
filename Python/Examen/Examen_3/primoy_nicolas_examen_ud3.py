# Examen UD3

# Ejercicio 1 - 2,5 puntos

# Crea una función que reciba un número entero y devuelva una tupla con tantos elementos como el número introducido.
# Cada elemento de la tupla debe ser una fruta aleatoria entre las siguientes posibilidades:
# - Manzana
# - Pera
# - Naranja
# - Plátano
# - Fresa
# - Uva
# - Melocotón
# - Sandía
# - Piña

# La función debe devolver la tupla con todas las frutas.

# Para generar frutas aleatorias, puedes utilizar la función random.choice() del módulo random.

# Ejemplo de uso del módulo random:
# import random
# frutas = ["Manzana", "Pera", "Naranja", "Plátano", "Fresa", "Uva", "Melocotón", "Sandía", "Piña"]
# fruta = random.choice(frutas)
# print(fruta)

# Una vez realizada esa función, crea otra función que reciba una tupla con frutas y devuelva un diccionario con el número de veces que aparece cada fruta en la tupla.
# Las claves del diccionario deben ser las frutas y los valores el número de veces que aparecen.

# Ejemplo de uso:
# frutas = generarFrutas(10)
# print(frutas)
# print(contarFrutas(frutas))

# Ejemplo de diccionario devuelto:
# {'Manzana': 3, 'Pera': 2, 'Naranja': 2, 'Plátano': 3}

# Nota: La función no debe devolver nada por pantalla, solo el diccionario.

# Deben controlarse las posibles excepciones en ambas funciones.
# En caso de que ocurra una excepción en la primera función, se debe devolver una tupla vacía.
# En caso de que ocurra una excepción en la segunda función, se debe devolver un diccionario vacío.

import random

frutas = ["Manzana", "Pera", "Naranja", "Plátano",
          "Fresa", "Uva", "Melocotón", "Sandía", "Piña"]


def generarFrutasEnTupla(numFrutas: int) -> tuple:
    frutasrandom = []
    vueltas = 0
    try:
        if not isinstance(numFrutas, int):
            raise ValueError(
                "Error: El argumento debe ser  un número entero y mayor que cero")
        if numFrutas == 0:
            raise ValueError(
                "Error: El argumento debe ser  un número entero y mayor que cero")
        while vueltas < numFrutas:
            i = (random.choice(frutas))
            frutasrandom = frutasrandom+[i]
            vueltas += 1
        return tuple(frutasrandom)
    except TypeError as e:
        print(e)
        return ()
    except ValueError as e:
        print(e)
        return ()


def contarFrutas(frutas: tuple) -> dict:
    frecuencia = {}
    try:
        if not isinstance(frutas, tuple):
            raise AttributeError
        for fruta in frutas:
            if fruta in frecuencia:
                frecuencia[fruta] += 1
            else:
                fruta[fruta] = 1
        return frecuencia
    except TypeError:
        return {}
    except AttributeError:
        return {}
    except:
        return {}


# Ejemplo de uso:
print("Probando funciones ejercicio 1:")
print("Probando función generarFrutasEnTupla:")
print(generarFrutasEnTupla(10))  # Devuelve una tupla con 10 frutas aleatorias
print(generarFrutasEnTupla("asdf"))  # Devuelve una tupla vacía
print(generarFrutasEnTupla(3.4))  # Devuelve una tupla vacía
print(generarFrutasEnTupla(0))  # Devuelve una tupla vacía
print("Probando función contarFrutas:")
frutitas = generarFrutasEnTupla(10)
print("Frutitas para probar a contarlas: ", frutitas)
# Devuelve un diccionario con las frutas generadas
print(contarFrutas(frutitas))
print(contarFrutas(()))  # Devuelve un diccionario vacío
print(contarFrutas("asdf"))  # Devuelve un diccionario vacío

print("-" * 50)

# Ejercicio 2 - 2,5 puntos

# Usando la función generarFrutas del ejercicio anterior, crea una función que reciba un número entero y devuelva un conjunto
# con todas las frutas que han aparecido en las tuplas generadas por la función generarFrutas.

# La función debe devolver el conjunto con todas las frutas de la tupla generada.
# La función debe controlar las posibles excepciones y devolver un conjunto vacío en caso de que ocurra una excepción.

# Ejemplo de uso:
# print(generarFrutasEnConjunto(10))

# Una vez creada esta función, crea otra función que reciba tres conjuntos.
# La función debe crear un diccionario que tenga como claves las siguientes:
# - 'FrutasTotales': Conjunto con todas las frutas de los tres conjuntos.
# - 'FrutasComunes': Conjunto con las frutas que aparecen en los tres conjuntos.
# - 'FrutasUnicas': Conjunto con las frutas que solo aparecen en uno de los tres conjuntos.

# La función debe devolver el diccionario con las claves y conjuntos indicados.

# Ejemplo de uso:
# frutas1 = generarFrutasEnConjunto(10)
# frutas2 = generarFrutasEnConjunto(10)
# frutas3 = generarFrutasEnConjunto(10)
# print(compararFrutas(frutas1, frutas2, frutas3))

# Ejemplo de diccionario devuelto:
# {'FrutasTotales': {'Manzana', 'Pera', 'Naranja', 'Plátano', 'Fresa', 'Uva', 'Melocotón', 'Sandía', 'Piña'}, 'FrutasComunes': {'Manzana', 'Pera', 'Naranja', 'Plátano', 'Fresa', 'Uva', 'Melocotón', 'Sandía', 'Piña'}, 'FrutasUnicas': set()}

# Nota: La función no debe devolver nada por pantalla, solo el diccionario.

# Deben controlarse las posibles excepciones en ambas funciones.
# En caso de que ocurra una excepción en la primera función, se debe devolver un conjunto vacío.
# En caso de que ocurra una excepción en la segunda función, se debe devolver un diccionario vacío.


def generarFrutasEnConjunto(numFrutas: int) -> set:
    try:
        vueltas = 0
        conjuntos = []
        while vueltas < numFrutas:
            conjuntos = generarFrutasEnTupla(5)
            vueltas += 1
        return set(conjuntos)
    except TypeError:
        return set()
    except AttributeError:
        return set()


def compararFrutas(frutas1: set, frutas2: set, frutas3: set) -> dict:
    try:
        if not isinstance(frutas1, set):
            raise AttributeError
        if not isinstance(frutas2, set):
            raise AttributeError
        if not isinstance(frutas3, set):
            raise AttributeError

        diccionario = {}
        union = frutas1.union(frutas2)
        comunes = frutas1.intersection(frutas2)
        unicas = frutas1.symmetric_difference(frutas2)
        diccionario['FrutastoTales'] = union.union(frutas3)
        diccionario['FrutasComunes'] = comunes.intersection(frutas3)
        diccionario['FrutasUnicas'] = unicas.symmetric_difference(frutas3)
        return diccionario
    except AttributeError:
        return {}


# Ejemplo de uso:
print("Probando funciones ejercicio 2:")
print("Probando función generarFrutasEnConjunto:")
# Devuelve un conjunto con las frutas generadas
print(generarFrutasEnConjunto(10))
print(generarFrutasEnConjunto("asdf"))  # Devuelve un conjunto vacío
print(generarFrutasEnConjunto(3.4))  # Devuelve un conjunto vacío
print(generarFrutasEnConjunto(0))  # Devuelve un conjunto vacío
print("Probando función compararFrutas:")
frutas1 = generarFrutasEnConjunto(3)
frutas2 = generarFrutasEnConjunto(3)
frutas3 = generarFrutasEnConjunto(3)
print(f"frutas1: {frutas1}")
print(f"frutas2: {frutas2}")
print(f"frutas3: {frutas3}")

dict_frutas = compararFrutas(
    # Devuelve un diccionario con los conjuntos de frutas generados
    frutas1, frutas2, frutas3)
for key, value in dict_frutas.items():
    print(f"{key}: {value}")

print(compararFrutas(set(), set(), set())
      )  # Devuelve un diccionario con conjuntos vacíos
print(compararFrutas("asdf", "asdf", "asdf"))  # Devuelve un diccionario vacío

print("-" * 50)
# Ejercicio 3 - 2,5 puntos

# Crear una función recursiva que reciba un número entero decimal y devuelva su representación en binario.
# La función debe devolver una cadena con el número en binario.

# Ejemplo de uso:
# print(decimalABinario(10))

# Ejemplo de cadena devuelta:
# '1010'

# Nota: La función no debe devolver nada por pantalla, solo la cadena con el número en binario.

# Deben controlarse las posibles excepciones en la función.
# En cada excepción se debe printear un mensaje de error correspondiente y devolver una cadena vacía.
# En caso de recibir un número entero negativo, se debe lanzar una excepción ValueError y devolver una cadena vacía.
# En caso de recibir un número que no sea un entero, se debe lanzar una excepción TypeError y devolver una cadena vacía.


def decimalABinario(decimal: int) -> str:
    try:
        if decimal < 0:
            raise ValueError
        if not isinstance(decimal, int):
            raise TypeError

        if decimal == 0:
            return "0"
        elif decimal == 1:
            return "1"
        else:
            return decimalABinario((decimal // 2) + (decimal % 2))
    except ValueError:
        print("Error: el número debe ser un número ")
        return ()
    except TypeError:
        print("Error: el número debe ser un número entero positivo")
        return ()


# Ejemplo de uso:
print("Probando función ejercicio 3:")
print("10 en binario:")
# Devuelve la representación en binario del número decimal introducido (1010)
print(decimalABinario(10))
print("0 en binario:")
print(decimalABinario(0))  # Devuelve "0"
print("1 en binario:")
print(decimalABinario(1))  # Devuelve "1"
print("1486 en binario:")
# Devuelve la representación en binario del número decimal introducido (10111001110)
print(decimalABinario(1486))
# print("Probando excepciones:")
# print(decimalABinario(-10))  # Devuelve una cadena vacía
# print(decimalABinario("asdf"))  # Devuelve una cadena vacía
# print(decimalABinario(3.4))  # Devuelve una cadena vacía

print("-" * 50)

# Ejercicio 4 - 2,5 puntos

# Crea una función que le pida al usuario los datos de un jugador de baloncesto.
# Los datos a pedir son:
# - Nombre
# - Dorsal (0-99)
# - Posición (Base, Escolta, Alero, Ala-Pívot, Pívot)

# La función debe devolver un diccionario con los datos del jugador.
# El diccionario debe tener las claves 'Nombre', 'Dorsal' y 'Posición'.
# La función debe asegurarse de que el nombre no esté vacío.
# La función debe asegurarse de que el dorsal esté entre 0 y 99.
# La función debe asegurarse de que la posición sea una de las indicadas.
# Para asegurarse de esto último, la función puede indicar al usuario un pequeño menú con las opciones válidas y pedirle que introduzca un número.
# La función debe pedir los datos al usuario hasta que todos sean correctos.

# Ejemplo de uso:
# jugador = datosJugador()
# print(jugador)

# Ejemplo de diccionario devuelto:
# {'Nombre': 'Juan', 'Dorsal': 7, 'Posición': 'Base'}

# Nota: La función no debe devolver nada por pantalla, solo el diccionario.

# Elaborar una segunda función a la que le llegue un número de jugadores y que pida los datos de todos ellos.
# Esta función debe devolver un diccionario con las posiciones de los jugadores como claves y el número de jugadores en cada posición.
# El diccionario resultado debe incluir las posición aunque no haya jugadores en ellas.

# Deben controlarse las posibles excepciones en ambas funciones.
# En caso de ocurrir una excepción, se debe mostrar un mensaje de error y volver a pedir los datos.
# En caso de ocurrir una excepción en la segunda función, se debe devolver un diccionario vacío.


# def datosJugador() -> dict:
#     jugadores = {}
#     inicio = input("""1- Para ingresar el nombre de un jugador
#                      2- Para ingresar el dorsal de un jugador
#                      3- Para ingresar la posición de un jugador
#                      0- Para salir""")
#     try:
#         match int(inicio):
#             case 1:
#                 nombre = input(
#                     "Ingrese el nombre del jugador, este debe estar compuesto unicamente por letras: ")
#                 if not isinstance(nombre, str):
#                     print("Error el dato ingresado no esta en el formato adecuado")
#                     nombre = input(
#                         "El dato ingresado no es válido. Por favor vuelva a intentar. ")
#                 else:
#                     jugadores['Nombre'] = nombre
#                 return jugadores
#             case 2:
#                 dorsal = input(
#                     "Ingrese el dorsal del jugador, este debe ser numeros enteros positivo: ")
#                 if not isinstance(dorsal, int):
#                     raise TypeError
#                 if dorsal < 0:
#                     raise TypeError
#                 else:
#                     jugadores['Dorsal'] = dorsal
#                     return jugadores
#             case 3:
#                 jugadores['Posicion'] = input(
#                     "Ingrese la posición del jugador: ")
#                 return jugadores
#             case 0:
#                 return print("Adios. Fin de programa")
#             case _:
#                 inicio = input(
#                     "La opcion ingresada no esta dentro del menu.Por favor, pruebe de nuevo: ")

#     except TypeError:

#         return


# def contarPosiciones(numJugadores: int) -> dict:
#     equipo = {}
#     while numJugadores > 0:
#         datosJugador()
#         numJugadores -= 1
#     for jugadores
#     return


# # Ejemplo de uso:
# print("Probando funciones ejercicio 4:")
# print("Probando función datosJugador:")
# # Devuelve un diccionario con los datos del jugador introducidos
# print(datosJugador())
# print("Probando función contarPosiciones:")
# numJugadores = 3
# print(contarPosiciones("asdf"))  # Devuelve un diccionario vacío
# print(contarPosiciones(3.4))  # Devuelve un diccionario vacío
# # Devuelve un diccionario con todas las posiciones a 0
# print(contarPosiciones(0))
# # Devuelve un diccionario con las posiciones de los jugadores introducidos
# print(contarPosiciones(numJugadores))

# print("Fin.")
