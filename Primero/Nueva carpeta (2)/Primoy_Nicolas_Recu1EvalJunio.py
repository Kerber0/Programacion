import random
import math

# Recuperación de Evaluación 1 - Junio 2025
# ---

# A continuación veréis una serie de enunciados repartidos en bloques por temas.
"""
 Cada bloque contiene entre 2 y 3 ejercicios, cada alumno debe resolver tantos ejercicios de cada 
 bloque según los temas que tenga pendientes siguiendo el siguiente criterio:
 
 - Si tiene suspenso un solo tema, debe resolver TODOS los ejercicios del bloque correspondiente al tema suspenso.
 - Si tiene suspenso el tema 1 y el tema 3, debe resolver los dos ejercicios del bloque 1 y dos ejercicios del bloque 3.
 - Si tiene suspenso el tema 1 y el tema 2, debe resolver los dos ejercicios del bloque 1 y dos ejercicios del bloque 2.
 - Si tiene suspenso el tema 2 y el tema 3, debe resolver dos ejercicios del bloque 2 y dos ejercicios del bloque 3.
 - Si tiene suspensos los tres temas, debe resolver un ejercicio del bloque 1, dos del bloque 2 y dos del bloque 3.

 Nota: En los casos en los que no se deban resolver todos los ejercicios de un bloque, el alumno/a puede elegir cuáles hacer.
 Atención:  Para aprobar cada tema, es necesario, al menos, resolver correctamente la mitad de los ejercicios de ese tema. 

 La nota de recuperación de los temas será la nota proporcional a la nota obtenida en los ejercicios resueltos, teniendo 
 todos los ejercicios tienen el mismo peso en la nota final del tema.

 Al terminar el examen, el alumno deberá subir el archivo a la plataforma Moodle con el siguiente nombre:
    apellido_nombre_recu1evalJunio.py

    Ejemplo:
    si el alumno se llama Juan Pérez García, el nombre del archivo será:
    perez_garcia_juan_recu1evalJunio.py

    En caso de no seguir este formato, se restarán 10 puntos de la nota final.

A la hora de entregar el examen se deben seguir las siguientes indicaciones:
 - Se deben borrar TODOS los ejercicios que no se hayan resuelto. Tanto el código como el enunciado.
 - De los ejercicios resueltos NO SE PUEDE BORRAR el enunciado ni el código proporcionado.
"""


# Tema 1: Fundamentos de Programación

# Ejercicio 1.1: Calculadora de Descuentos
'''
Crea un script en Python que simule una calculadora de descuentos. El programa debe hacer lo siguiente:

1.  Solicitar al usuario el precio original de un producto (número flotante).
2.  Solicitar al usuario el porcentaje de descuento a aplicar (número entero entre 0 y 100).
3.  Validar que el porcentaje de descuento sea un número válido. Si no lo es, debe mostrar un mensaje de error y volver a solicitarlo hasta que sea correcto.
4.  Calcular el precio final después de aplicar el descuento.
5.  Mostrar en pantalla el precio original, el porcentaje de descuento aplicado y el precio final, formateado a dos decimales.

Ejemplo de ejecución:

Introduce el precio original del producto: 120.50
Introduce el porcentaje de descuento (0-100): 15
Precio original: 120.50€
Descuento aplicado: 15%
Precio final: 102.42€
'''

# Prints para probar el Ejercicio 1.1:
print("--- Ejercicio 1.1: Calculadora de Descuentos ---")
print("Este ejercicio requiere interacción del usuario por consola.")
print("Por favor, ejecuta el script y sigue las instrucciones.")
print("\n")


# Ejercicio 1.2: Adivina el Número Secreto
'''
Crea un juego simple de adivinar un número. El programa debe:

1.  Generar un número entero aleatorio entre 1 y 100 (ambos inclusive). Para esto, necesitarás importar el módulo `random`.
2.  Solicitar al usuario que adivine el número.
3.  Utilizar una estructura repetitiva (un bucle `while`) para permitir al usuario intentar adivinar el número hasta que acierte.
4.  En cada intento, el programa debe indicar al usuario si su número es "Demasiado alto", "Demasiado bajo" o "¡Felicidades! Has adivinado el número en X intentos.".
5.  Contar y mostrar el número de intentos que le tomó al usuario adivinar el número.
'''

# Prints para probar el Ejercicio 1.2:
print("--- Ejercicio 1.2: Adivina el Número Secreto ---")
print("Este ejercicio requiere interacción del usuario por consola.")
print("El juego generará un número aleatorio entre 1 y 100 y te pedirá que lo adivines.")
print("\n")

# ---

# Tema 2: Estructuras de Datos, Funciones y Recursividad

# Ejercicio 2.1: Gestión de Tareas Pendientes
'''
Crea un programa que permita gestionar una lista de tareas pendientes. El programa debe utilizar una lista para almacenar las tareas y ofrecer las siguientes funcionalidades mediante un menú interactivo:

1.  **Añadir tarea:** Solicitar al usuario una nueva tarea y añadirla al final de la lista.
2.  **Ver tareas:** Mostrar todas las tareas numeradas. Si la lista está vacía, indicarlo.
3.  **Marcar tarea como completada:** Solicitar al usuario el número de la tarea a marcar como completada y reemplazarla por `"[COMPLETADA] " + tarea_original`. Validar que el número de tarea sea válido.
4.  **Salir:** Terminar el programa.
'''

# Prints para probar el Ejercicio 2.1:
print("--- Ejercicio 2.1: Gestión de Tareas Pendientes ---")
print("Este ejercicio simulará un gestor de tareas interactivo.")
print("Ejecuta el script y sigue el menú de opciones para añadir, ver o marcar tareas.")
print("\n")


# Ejercicio 2.2: Generador de Contraseñas Seguras
'''
Define una función llamada `generar_contrasena` que reciba un entero `longitud` como argumento y devuelva una cadena de texto que sea una contraseña aleatoria. La contraseña debe cumplir los siguientes requisitos:

* Debe tener la `longitud` especificada.
* Debe contener al menos una letra mayúscula.
* Debe contener al menos una letra minúscula.
* Debe contener al menos un dígito.
* Debe contener al menos un carácter especial (por ejemplo, `!@#$%^&*()`).

Utiliza el módulo `random` para generar los caracteres. La función debe asegurar que se cumplen los requisitos mínimos y rellenar el resto de la contraseña con caracteres aleatorios de cualquiera de las categorías.
'''

# Prints para probar el Ejercicio 2.2:
print("--- Ejercicio 2.2: Generador de Contraseñas Seguras ---")
print("Se espera una función `generar_contrasena(longitud)`.")
print("Prueba con distintas longitudes:")
# Comenta o descomenta las siguientes líneas para ver los resultados cuando implementes la función:
# print(f"Contraseña de 8 caracteres: {generar_contrasena(8)}")
# print(f"Contraseña de 12 caracteres: {generar_contrasena(12)}")
# try:
#     print(f"Contraseña de 3 caracteres (debería dar error): {generar_contrasena(3)}")
# except ValueError as e:
#     print(f"Error esperado: {e}")
print("\n")


# Ejercicio 2.3: Suma Recursiva de Dígitos
'''
Define una función recursiva llamada `suma_digitos_recursiva` que reciba un número entero positivo `n` como argumento y devuelva la suma de sus dígitos.

Ejemplos:
* `suma_digitos_recursiva(123)` debería devolver `6` (1 + 2 + 3)
* `suma_digitos_recursiva(9)` debería devolver `9`
* `suma_digitos_recursiva(4567)` debería devolver `22` (4 + 5 + 6 + 7)
'''

# Prints para probar el Ejercicio 2.3:
print("--- Ejercicio 2.3: Suma Recursiva de Dígitos ---")
print("Se espera una función `suma_digitos_recursiva(n)`.")
print("Prueba con los siguientes números:")
# Comenta o descomenta las siguientes líneas para ver los resultados cuando implementes la función:
# print(f"Suma de dígitos de 123: {suma_digitos_recursiva(123)}")
# print(f"Suma de dígitos de 9: {suma_digitos_recursiva(9)}")
# print(f"Suma de dígitos de 4567: {suma_digitos_recursiva(4567)}")
# print(f"Suma de dígitos de 0: {suma_digitos_recursiva(0)}")
print("\n")

# ---

# Tema 3: Control de Excepciones y Estructuras de Datos Avanzadas

# Ejercicio 3.1: Conversor de Unidades de Longitud con Manejo de Errores
'''
Crea un programa que convierta una longitud entre metros (m), centímetros (cm) y kilómetros (km). El programa debe:

1.  Preguntar al usuario la unidad de origen y la unidad de destino (por ejemplo, "m a cm", "km a m", etc.).
2.  Solicitar la longitud a convertir.
3.  Utilizar bloques `try-except` para manejar posibles errores:
    * `ValueError`: Si el usuario introduce algo que no es un número para la longitud.
    * Manejar el caso donde las unidades de origen o destino no son válidas (es decir, no son 'm', 'cm' o 'km').
    * Cualquier otra excepción general que pueda surgir.
4.  Define una función `convertir_longitud(valor, unidad_origen, unidad_destino)` que realice la conversión. Esta función debe devolver el valor convertido.
5.  Mostrar el resultado de la conversión, formateado a dos decimales.

Factores de Conversión:
* $1 \text{ m} = 100 \text{ cm}$
* $1 \text{ km} = 1000 \text{ m}$
'''


def convertir_longitud():

    try:
        valor_str = input("Ingrese el valor númerico positivo a convertir: ")

        valor = float(valor_str)
        if valor < 0:
            raise ValueError("El número debe ser positivo")

        unidad_origen = input("\nIngrese la unidad de ORIGEN de la longitud, m para metros, cm para centrimetros o km para kilometros: "
                              ).strip().lower()
        unidad_destino = input("\nIngrese la unidad de DESTINO de la longitud, m para metros, cm para centrimetros o km para kilometros: "
                               ).strip().lower()

        unidades_validas = ("m", "cm", "km")

        if unidad_origen not in unidades_validas or unidad_destino not in unidades_validas:
            raise ValueError("Unidades no validas.")

        a_metros = {"m": 1, "cm": 0.01, "km": 1000}
        valor_en_metros = valor * a_metros[unidad_origen]
        valor_convertido = valor_en_metros / a_metros[unidad_destino]
        print(valor_convertido)
    except ValueError as e:
        print(f"Error: {e}")
    except Exception:
        print("Ocurrio un error inesperado.")


if __name__ == "__main__":
    convertir_longitud()


# Prints para probar el Ejercicio 3.1:
print("--- Ejercicio 3.1: Conversor de Unidades de Longitud ---")
print("Este ejercicio requiere interacción del usuario por consola.")
print("El programa pedirá las unidades de origen y destino, y el valor a convertir.")
print("Deberá manejar entradas no numéricas o unidades inválidas.")
print("\n")


# Ejercicio 3.2: Gestión de Inventario con Diccionarios
'''
Crea un programa que gestione un inventario simple utilizando un diccionario donde las claves sean los nombres de los productos y los valores sean la cantidad disponible. El programa debe ofrecer las siguientes funcionalidades mediante un menú interactivo:

1.  **Añadir/Actualizar producto:** Solicitar el nombre del producto y la cantidad. Si el producto ya existe, actualizar su cantidad; si no, añadirlo.
2.  **Ver inventario:** Mostrar todos los productos y sus cantidades en el inventario.
3.  **Eliminar producto:** Solicitar el nombre de un producto y eliminarlo del inventario. Si el producto no existe, mostrar un mensaje de error.
4.  **Buscar producto:** Solicitar el nombre de un producto y mostrar su cantidad si existe, o un mensaje de que no se encuentra.
5.  **Salir:** Terminar el programa.
'''


def menu():
    productos = {"Banana": 1, "Manzana": 2, "Pera": 5}
    valido = ("1", "2", "3", "4", "0")
    try:
        while True:
            opcion = input("""
                            Seleccione la opcion deseada:
                            1- Añadir/Actualizar producto
                            2- Ver inventario
                            3- Eliminar producto
                            4- Buscar producto
                            0- Salir
                            """)

            match opcion:
                case "1":
                    agregar_actualizar(productos)
                case "2":
                    mostrar(productos)
                case "3":
                    eliminar(productos)
                case "4":
                    buscar(productos)
                case "0":
                    print("Adios.")
                    break

    except Exception:
        print("error")


def agregar_actualizar(productos: dict):
    agregar = str(input(
        "Seleccione 1 para agregar o modifciar un producto o 0 para volver al menu"))

    while agregar not in ["1", "0"]:
        agregar = input("Error: debe seleccionar una opcion válida.")

    if agregar == "1":
        agregar_stock(productos)

    if agregar == "0":
        print("Volviendo al menú.")
        return menu()


def agregar_stock(productos):
    producto = input("Ingrese el nombre del producto: ")
    cantidad = int(input("Ingrese la cantidad del producto"))
    if cantidad < 0:
        print("Error: la cantidad del producto debe ser un numero positivo.")
    if producto in productos:
        print("El producto ya existe, se actualziará su stock")
    else:
        print("Se agregara el nuevo producto")
    productos[producto] = cantidad


def eliminar(productos: dict) -> dict:
    mostrar(productos)
    borrar = input(
        'Indique el producto a eliminar o "Salir" para salir: ')

    if str(borrar).lower() == "salir":
        print("Volviendo al menu")
        return

    while borrar not in productos:
        borrar = input(
            "El producto proporcionado no está disponible, intentelo de nuevo: ")

    productos.pop(borrar)
    print(f"El producto {borrar} ha sido eliminado ")
    return productos


def mostrar(productos: dict) -> str:

    print("\nLista de productos disponibles:")
    if not productos:
        print("No hay productos en stock.")
    else:
        for producto, cantidad in productos.items():
            print(f"{producto}: {cantidad}")

    input("\nPresione Enter para volver al menú.")


def buscar(productos: dict):
    try:
        busqueda = input("Ingrese el nombre del producto que desea buscar: ")
        if not busqueda in productos:
            raise KeyError("Error: El producto no se encuentra en el stock")
        else:
            print(productos[busqueda])
    except KeyError as e:
        print(e)


if __name__ == "__main__":
    menu()


# Prints para probar el Ejercicio 3.2:
print("--- Ejercicio 3.2: Gestión de Inventario con Diccionarios ---")
print("Este ejercicio simulará un gestor de inventario interactivo.")
print("Ejecuta el script y sigue el menú de opciones para gestionar productos.")
print("\n")


# Ejercicio 3.3: Análisis de Texto con Conjuntos y Tuplas
'''
Crea un programa que analice una frase introducida por el usuario. El programa debe:

1.  Solicitar al usuario que introduzca una frase.
2.  Convertir la frase a minúsculas y dividirla en palabras.
3.  Utilizar un **conjunto** para almacenar todas las palabras únicas de la frase.
4.  Utilizar un **diccionario** para contar la frecuencia de cada palabra. Las claves serán las palabras y los valores serán sus conteos.
5.  Utilizar una **tupla** para almacenar las 3 palabras más frecuentes junto con sus conteos (por ejemplo, `("palabra1", 5)`). Si hay menos de 3 palabras únicas, almacenar todas las disponibles.
6.  Mostrar:
    * El número total de palabras en la frase.
    * El número de palabras únicas.
    * La lista de palabras únicas (el conjunto).
    * La frecuencia de cada palabra (el diccionario).
    * Las 3 palabras más frecuentes (la tupla).
'''


def analizador_de_frases():

    frase = input("Ingrese la frase que quiere analizar: ")
    palabras = frase.lower().split()
    conjunto = set(palabras)
    diccionario = {}

    for palabra in palabras:
        if palabra in diccionario:
            diccionario[palabra] += 1
        else:
            diccionario[palabra] = 1

    print("Número total de palabras en la frase: ")
    print(len(palabras))
    print("Número de palabras únicas: ")
    print(len(conjunto))
    print("La lista de frecuencia de palabras: ")
    print(diccionario)


if __name__ == "__main__":
    analizador_de_frases()

# Prints para probar el Ejercicio 3.3:
print("--- Ejercicio 3.3: Análisis de Texto con Conjuntos y Tuplas ---")
print("Este ejercicio requiere interacción del usuario. Te pedirá una frase.")
print("Luego, mostrará el análisis de la frase con palabras únicas, frecuencias y las más comunes.")
print("\n")
