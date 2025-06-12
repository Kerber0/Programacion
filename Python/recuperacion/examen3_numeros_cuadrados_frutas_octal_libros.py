import random
import math

# Ejercicio 1
# Enunciado:
# Generar una tupla de N números aleatorios entre 1 y 50,
# luego devolver un diccionario con el número y su cuadrado.


def generarYCuadrados(n: int) -> tuple:
    """
    Retorna tupla de n números aleatorios y un dict {n: n^2}.
    """
    if not isinstance(n, int) or n <= 0:
        raise ValueError("n positivo")
    nums = tuple(random.randint(1, 50) for _ in range(n))
    cuadrados = {x: x**2 for x in nums}
    return nums, cuadrados


# Ejercicio 2
# Enunciado:
# A partir de dos conjuntos de frutas, calcular:
# - Conjunto total
# - Pertenecen solo al primero
# - Pertenecen solo al segundo

frutas1 = {"Manzana", "Pera", "Naranja", "Plátano"}
frutas2 = {"Fresa", "Uva", "Manzana", "Kiwi"}


def compararDos(fr1: set, fr2: set) -> dict:
    """
    Unión, diferencia fr1-fr2, diferencia fr2-fr1.
    """
    if not isinstance(fr1, set) or not isinstance(fr2, set):
        raise TypeError("Conjuntos esperados")
    return {
        "Union": fr1 | fr2,
        "SoloEn1": fr1 - fr2,
        "SoloEn2": fr2 - fr1
    }


# Ejercicio 3
# Enunciado:
# Función recursiva para convertir un número entero en su representación octal.

def decimalAOctal(n: int) -> str:
    """
    Convierte entero >=0 a cadena en base 8.
    """
    if not isinstance(n, int):
        raise TypeError("Entero")
    if n < 0:
        raise ValueError(">=0")
    if n < 8:
        return str(n)
    return decimalAOctal(n//8) + str(n % 8)


# Ejercicio 4
# Enunciado:
# Pedir datos de un libro: título, autor, año (>=1900 y <=2025),
# género de lista. Para P libros, devolver conteo por género.

def datosLibro() -> dict:
    """
    Solicita datos de un libro y valida.
    """
    libro = {}
    # Título
    while True:
        t = input("Título: ").strip()
        if t:
            libro["Título"] = t
            break
        print("No vacío.")
    # Autor
    while True:
        a = input("Autor: ").strip()
        if a:
            libro["Autor"] = a
            break
        print("No vacío.")
    # Año
    while True:
        try:
            y = int(input("Año (1900-2025): "))
            if 1900 <= y <= 2025:
                libro["Año"] = y
                break
        except ValueError:
            pass
        print("Inválido.")
    # Género
    generos = ["Novela", "Poesía", "Ensayo", "Teatro"]
    while True:
        print("Géneros:")
        for i, g in enumerate(generos, 1):
            print(f"{i}. {g}")
        try:
            sel = int(input("Opción: "))
            if 1 <= sel <= len(generos):
                libro["Género"] = generos[sel-1]
                break
        except ValueError:
            pass
        print("Inválido.")
    return libro


def contarGeneros(p: int) -> dict:
    """
    Solicita p libros y cuenta por género.
    """
    if not isinstance(p, int) or p <= 0:
        raise ValueError("p entero positivo")
    cnt = {g: 0 for g in ["Novela", "Poesía", "Ensayo", "Teatro"]}
    for _ in range(p):
        lb = datosLibro()
        cnt[lb["Género"]] += 1
    return cnt


if __name__ == "__main__":
    pass
