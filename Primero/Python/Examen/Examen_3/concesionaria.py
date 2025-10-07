# Enunciado completo: Gestión de una concesionaria de coches
# Escribe un programa en Python para gestionar los datos de una concesionaria de coches. El sistema
# debe permitir almacenar, organizar y consultar información de los vehículos disponibles
# en la concesionaria utilizando diccionarios, listas, tuplas y/o conjuntos.

# Requisitos funcionales:

# Estructura de los datos:
# Cada coche debe representarse mediante un diccionario con los siguientes campos:
# marca (cadena): Marca del coche (e.g., "Toyota").
# modelo (cadena): Modelo del coche (e.g., "Corolla").
# año (entero): Año de fabricación (e.g., 2020).
# matricula (cadena): Matrícula del coche (e.g., "ABC123").
# estado (cadena): Indica si el coche es "nuevo" o "usado".
# color (cadena): Color del coche (e.g., "Rojo").
# precio (flotante): Precio del coche (e.g., 15000.50).
# Todos los coches deben almacenarse en una lista.

# Funciones requeridas:
# Agregar un coche: Solicitar al usuario los datos de un coche y añadirlo a la lista.
# Listar coches: Mostrar todos los coches almacenados, ordenados por año de fabricación.
# Filtrar coches:
# Por marca.
# Por estado (nuevo o usado).
# Eliminar un coche: Permitir eliminar un coche por su matrícula.
# Estadísticas básicas:
# Cantidad total de coches.
# Precio promedio de los coches.
# Datos de entrada y salida esperados
# Ejemplo 1: Agregar coches

# Entrada del usuario:

# Agregar un coche:
# Marca: Toyota
# Modelo: Corolla
# Año: 2020
# Matrícula: ABC123
# Estado (nuevo/usado): usado
# Color: Blanco
# Precio: 15000.50
# Salida esperada:

# Coche agregado con éxito.
# Ejemplo 2: Listar coches
# Entrada del usuario:

# Listar coches

# Salida esperada (ordenados por año):
# Listado de coches disponibles:
# 1. Marca: Honda | Modelo: Civic | Año: 2018 | Matrícula: XYZ789 | Estado: usado | Color: Gris | Precio: 12000.00
# 2. Marca: Toyota | Modelo: Corolla | Año: 2020 | Matrícula: ABC123 | Estado: usado | Color: Blanco | Precio: 15000.50
# Ejemplo 3: Filtrar coches por marca
# Entrada del usuario:

# Filtrar por marca:
# Marca: Toyota

# Salida esperada:
# Coches de la marca Toyota:
# 1. Marca: Toyota | Modelo: Corolla | Año: 2020 | Matrícula: ABC123 | Estado: usado | Color: Blanco | Precio: 15000.50
# Ejemplo 4: Eliminar un coche
# Entrada del usuario:

# Eliminar coche
# Matrícula: ABC123
# Salida esperada:

# Coche con matrícula ABC123 eliminado con éxito.
# Ejemplo 5: Estadísticas básicas
# Entrada del usuario:

# Ver estadísticas
# Salida esperada:

# Estadísticas de la concesionaria:
# - Total de coches: 3
# - Precio promedio: 14000.33
# Instrucciones adicionales:
# Usa funciones para cada operación (agregar, listar, filtrar, eliminar, estadísticas).
# Organiza los datos de forma eficiente utilizando listas, diccionarios, tuplas y/o conjuntos según el caso.
# Asegúrate de manejar entradas incorrectas, como años no válidos o precios negativos.


import random
import string
import datetime
from collections import Counter


color_disp = ["blanco", "negro", "azul",
              "amarillo", "rojo", "gris", "verde", "naranja"]
actual_year = datetime.datetime.now().year


def agregar_coche(coches: dict) -> dict:
    """Menu de opciones para la funcion de agregar vehiculos al diccionario

    Args:
        coches (dict): diccionario de coches con sus codigos como clave y atributos como valores.

    Returns:
        dict: devuelve el diccionario "coches", con un elemento agregado
    """
    agregar = str(input(
        "Seleccione 1 para agregar un vehiculo o 0 para volver al menú: "))

    while agregar not in ["1", "0"]:
        agregar = input(
            "Error: debe seleccionar una de las opciones aportadas. Vuelva a intentarlo: ")

    if agregar == "1":
        agregar_a_stock(coches)

    elif agregar == "0":
        print("Volviendo al menú.")
        return menu()


def listar(coches: dict) -> str:
    """Imprime el diccionario completo de coches.

    Args:
        coches (dict): diccionario de coches con sus codigos como clave y atributos como valores.

    Returns:
        str: impresion del diccionario de coches
    """

    print("\nLista de vehículos disponibles:")
    if not coches:
        print("No hay vehículos en el inventario.")
    else:
        for codigo, vehiculo in coches.items():
            print(f"{codigo}: {vehiculo}")

    input("\nPresione Enter para volver al menú.")


def filtrar(coches: dict, filtro: str) -> dict:
    """    Filtra e imprime las claves cuyos valores contienen el string proporcionado.


    Args:
        oches (dict): Diccionario de coches con sus códigos como claves y atributos como valores.
        filtro (str): El string que se busca dentro de los valores del diccionario.
    """

    print(f"Resultados de la búsqueda para '{filtro}':")
    encontrados = False

    for clave, atributos in coches.items():
        for v in atributos.values():
            if filtro.lower() in str(v).lower():
                print(f"Código: {clave}, Detalles: {atributos}")
                encontrados = True
                break

    if not encontrados:
        print("No se encontraron coincidencias.")


def eliminar(coches: dict) -> dict:
    """Elimina un elemento seleccionado por un input del diccionario coches.

    Args:
        coches (dict): diccionario de coches con sus codigos como clave y atributos como valores.

    Returns:
        dict: devuelve el diccionario coches modificado.
    """
    borrar = input(
        'Indique el código del vehiculo a eliminar o "Salir" para salir: ')

    if str(borrar).lower() == "salir":
        print("Volviendo al menu")
        return

    while borrar not in coches:
        borrar = input(
            "El codigo proporcionado no está disponible, intentelo de nuevo: ")

    coches.pop(borrar)
    print(f"El vehiculo con el codigo {borrar} ha sido eliminado ")
    return coches


def estadistica(coches: dict):
    """Función que imprime las existencias totales.

    Args:
        coches (dict): diccionario de coches con sus codigos como clave y atributos como valores.
    """

    existencias_totales = []
    for listas in coches.values():  # Une todas las listas del diccionario en una sola
        existencias_totales.extend(listas)

    # Counter cuenta las ocurrencias de cada valor
    conteo = Counter(existencias_totales)

    print("Conteo de valores:")
    for valor, cantidad in conteo.items():
        if valor == "precio":
            continue
        else:
            print(f"{valor}: {cantidad} de veces.")


def agregar_a_stock(coches: dict):
    """Agrega un vehiculo al diccionario y sus elementos.

    Args:
        coches (dict): diccionario de coches con sus codigos como clave y atributos como valores.

    Returns:
        _type_: devuelve el diccionario con el elemento agregado.
    """
    codigo = generar_codigo()
    while codigo in coches:
        codigo = generar_codigo()

    marca = input("Indicar marca del coche: ")
    modelo = input("Indicar modelo del coche: ")
    year = int(input("Indicar año del coche: ")) # ValueError : si se introduce un string
    matricula = input(
        "Indicar matrícula del coche: ") if year <= actual_year else "Vehiculo por matricular."
    estado = "nuevo" if year >= actual_year else "usado"
    color = elegir_color()

    while True:
        precio_input = input(
            "Indicar precio del coche (o escriba 'salir' para cancelar): ")

        # Permitir al usuario salir del proceso de agregar coche
        if precio_input.lower() == 'salir':
            print("No se ha agregado el precio. El coche será registrado sin precio.")
            precio = None
            break  # Salir de la función si el usuario decide cancelar

        # Verificación básica de que el precio sea un número flotante válido
        if precio_input.replace('.', '', 1).isdigit() and precio_input.count('.') <= 1:
            precio = float(precio_input)
            break  # Si el precio es válido, salir del bucle
        else:
            print("Por favor, ingrese un valor numérico válido para el precio.")

    coches[codigo] = {'marca': marca, 'modelo': modelo, 'año': year,
                      'matricula': matricula, 'estado': estado, 'color': color, 'precio': precio}
    print(f"Coche con código {codigo} agregado correctamente.")
    return coches


def elegir_color():
    """Funcion para verificar que la eleccion del color se encuentra dentro de los colores disponibles

    Returns:
        str: color seleccionado
    """
    color = input(
        f"Seleccione un color dentro de la siguiente lista {color_disp}: ")
    while color not in color_disp:
        print("Color no válido. Intente de nuevo.")
        color = input(
            f"Seleccione un color dentro de la siguiente lista {color_disp}: ")

    return str(color)


def generar_codigo():
    """Genera codigo alfanumerico de 4 cifras aleatoriamente
    """
    longitud_codigo = 4
    codigo_aleatorio = ''.join(random.choices(
        string.ascii_letters + string.digits, k=longitud_codigo))

    return (codigo_aleatorio)


def menu():
    """Funcion de menu, para la seleccion de operaciones.   
    """
    print("""
    1- Agregar vehículo
    2- Listar vehículos disponibles
    3- Filtrar
    4- Eliminar vehículo
    5- Estadísticas de la concesionaria
    0- Salir
    """)
    inicio = input("Seleccione el número de lo que desea realizar: ")
    coches = {
        "A123": {
            "marca": "Toyota",
            "modelo": "Corolla",
            "año": 2020,
            "matricula": "ABC123",
            "estado": "usado",
            "color": "negro",
            "precio": 15000.0
        },
        "B456": {
            "marca": "Ford",
            "modelo": "Fiesta",
            "año": 2018,
            "matricula": "XYZ456",
            "estado": "usado",
            "color": "rojo",
            "precio": 12000.0
        },
        "C789": {
            "marca": "Honda",
            "modelo": "Civic",
            "año": 2022,
            "matricula": "DEF789",
            "estado": "nuevo",
            "color": "azul",
            "precio": 20000.0
        },
        "D012": {
            "marca": "Chevrolet",
            "modelo": "Onix",
            "año": 2019,
            "matricula": "GHI012",
            "estado": "usado",
            "color": "gris",
            "precio": 14000.0
        },
        "E345": {
            "marca": "Volkswagen",
            "modelo": "Golf",
            "año": 2021,
            "matricula": "JKL345",
            "estado": "nuevo",
            "color": "blanco",
            "precio": 22000.0
        }
    }
    while True:
        match int(inicio):
            case 1:
                agregar_coche(coches)

            case 2:
                listar(coches)

            case 3:
                filtrar(coches, "Mercedes")

            case 4:
                eliminar(coches)

            case 5:
                estadistica(coches)

            case 0:
                return print("Adios. Fin de programa")
            case _:
                inicio = input(
                    "La opcion ingresada no esta dentro del menu.Por favor, pruebe de nuevo: ")


if __name__ == "__main__":
    menu()
