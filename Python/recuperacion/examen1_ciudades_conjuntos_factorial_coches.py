import random
import string

# Ejercicio 1
# Enunciado:
# A partir de una lista de ciudades, generar una tupla con N ciudades aleatorias
# (con reemplazo). Luego, contar cuántas veces aparece cada ciudad en la tupla.

ciudades = ["Madrid", "Barcelona", "Valencia", "Sevilla", "Zaragoza",
            "Málaga", "Murcia", "Palma", "Bilbao"]


def generarCiudadesTupla(n: int) -> tuple:
    """
    Genera una tupla con n ciudades aleatorias de la lista ciudades.
    """
    if not isinstance(n, int) or n <= 0:
        raise ValueError("n debe ser un entero positivo")
    # random.choice elige con reemplazo
    return tuple(random.choice(ciudades) for _ in range(n))


def contarCiudades(tuplaC: tuple) -> dict:
    """
    Cuenta la frecuencia de cada ciudad en la tupla.
    """
    if not isinstance(tuplaC, tuple):
        raise TypeError("Se esperaba una tupla")
    # set(tuplaC) elimina duplicados para iterar sólo una vez por ciudad
    return {ciudad: tuplaC.count(ciudad) for ciudad in set(tuplaC)}


# Ejercicio 2
# Enunciado:
# Generar dos conjuntos de números enteros aleatorios entre 1 y 20, de tamaño N
# (sin reemplazo). Luego, calcular la unión, intersección y diferencia simétrica.

def generarConjuntoNumeros(n: int) -> set:
    """
    Genera un conjunto de n números aleatorios del 1 al 20.
    """
    if not isinstance(n, int) or n <= 0:
        raise ValueError("n debe ser un entero positivo")
    # random.sample sin reemplazo del rango 1-20
    return set(random.sample(range(1, 21), n))


def compararConjuntos(a: set, b: set) -> dict:
    """
    Calcula unión, intersección y diferencia simétrica de dos conjuntos.
    """
    if not isinstance(a, set) or not isinstance(b, set):
        raise TypeError("Ambos argumentos deben ser conjuntos")
    return {
        "Union": a | b,                 # Elementos en a o en b
        "Interseccion": a & b,          # Elementos comunes
        "DiferenciaSimetrica": a ^ b    # Elementos en uno u otro, pero no en ambos
    }


# Ejercicio 3
# Enunciado:
# Implementar una función recursiva para calcular el factorial de un número n >= 0.

def factorial(n: int) -> int:
    """
    Retorna n! de forma recursiva.
    """
    if not isinstance(n, int):
        raise TypeError("n debe ser un entero")
    if n < 0:
        raise ValueError("n debe ser >= 0")
    if n in (0, 1):
        return 1
    # Paso recursivo: n * factorial(n-1)
    return n * factorial(n-1)


# Ejercicio 4
# Enunciado:
# Solicitar por consola los datos de un coche: marca, modelo, año (entre 1990 y 2025)
# y tipo de combustible (Gasolina, Diésel, Eléctrico). Luego, pedir M coches y
# contar cuántos de cada tipo de combustible hay.

def datosCoche() -> dict:
    """
    Pide datos de un coche y los devuelve en un diccionario.
    """
    coche = {}
    # Marca
    while True:
        m = input("Marca del coche: ").strip()
        if m:
            coche["Marca"] = m
            break
        print("No puede estar vacío.")
    # Modelo
    while True:
        mod = input("Modelo del coche: ").strip()
        if mod:
            coche["Modelo"] = mod
            break
        print("No puede estar vacío.")
    # Año
    while True:
        try:
            año = int(input("Año (1990-2025): "))
            if 1990 <= año <= 2025:
                coche["Año"] = año
                break
            print("Debe estar entre 1990 y 2025.")
        except ValueError:
            print("Introduce un entero.")
    # Combustible
    tipos = ["Gasolina", "Diésel", "Eléctrico"]
    while True:
        print("Tipo de combustible:")
        for i, t in enumerate(tipos, 1):
            print(f"{i}. {t}")
        try:
            sel = int(input("Opción: "))
            if 1 <= sel <= len(tipos):
                coche["Combustible"] = tipos[sel-1]
                break
        except ValueError:
            pass
        print("Opción inválida.")
    return coche


def contarCombustible(m: int) -> dict:
    """
    Solicita m coches y cuenta tipos de combustible.
    """
    if not isinstance(m, int) or m <= 0:
        raise ValueError("m debe ser un entero positivo")
    contador = {"Gasolina": 0, "Diésel": 0, "Eléctrico": 0}
    for _ in range(m):
        c = datosCoche()
        contador[c["Combustible"]] += 1
    return contador


if __name__ == "__main__":
    # Aquí podrías probar cada función
    pass
