import string
import random

# Ejercicio 1
# Enunciado:
# Generar una lista de N números aleatorios entre 1 y 100,
# devolverla como tupla y contar cuántos múltiplos de 5 hay.


def generarNumerosTupla(n: int) -> tuple:
    """
    Genera una tupla con n números aleatorios 1–100.
    """
    if not isinstance(n, int) or n <= 0:
        raise ValueError("n debe ser entero positivo")
    return tuple(random.randint(1, 100) for _ in range(n))


def contarMultiplos5(t: tuple) -> int:
    """
    Cuenta los elementos de la tupla que son múltiplos de 5.
    """
    if not isinstance(t, tuple):
        raise TypeError("Se esperaba una tupla")
    return sum(1 for x in t if x % 5 == 0)


# Ejercicio 2
# Enunciado:
# Generar tres conjuntos de letras aleatorias de la A a la Z,
# de tamaño N sin reemplazo, y calcular:
# - Conjunto total (unión)
# - Letras comunes (intersección de los tres)
# - Letras exclusivas (aparecen en exactamente uno).


def generarConjuntoLetras(n: int) -> set:
    """
    Genera un conjunto de n letras mayúsculas distintas.
    """
    if not isinstance(n, int) or n <= 0 or n > len(string.ascii_uppercase):
        raise ValueError("n debe estar entre 1 y 26")
    return set(random.sample(string.ascii_uppercase, n))


def compararLetras(a: set, b: set, c: set) -> dict:
    """
    Devuelve unión, intersección y exclusivas de tres conjuntos.
    """
    if not all(isinstance(s, set) for s in (a, b, c)):
        raise TypeError("Se esperaban conjuntos")
    tot = a | b | c
    com = a & b & c
    # Exclusivas: conteo==1
    exclusivas = {letra for letra in tot
                  if [letra in a, letra in b, letra in c].count(True) == 1}
    return {"Totales": tot, "Comunes": com, "Exclusivas": exclusivas}


# Ejercicio 3
# Enunciado:
# Escribir función recursiva para calcular el n-ésimo término de la
# sucesión de Fibonacci (F0=0, F1=1).

def fibonacci(n: int) -> int:
    """
    Retorna el n-ésimo término de Fibonacci.
    """
    if not isinstance(n, int):
        raise TypeError("n debe ser entero")
    if n < 0:
        raise ValueError("n >= 0")
    if n in (0, 1):
        return n
    return fibonacci(n-1) + fibonacci(n-2)


# Ejercicio 4
# Enunciado:
# Pedir datos de un estudiante: nombre, edad (>= 0), carrera
# de una lista. Luego, para M estudiantes, contar cuántos por carrera.

def datosEstudiante() -> dict:
    """
    Solicita y valida datos de un estudiante.
    """
    est = {}
    # Nombre
    while True:
        n = input("Nombre: ").strip()
        if n:
            est["Nombre"] = n
            break
        print("No vacío.")
    # Edad
    while True:
        try:
            e = int(input("Edad: "))
            if e >= 0:
                est["Edad"] = e
                break
        except ValueError:
            pass
        print("Edad ≥ 0.")
    # Carrera
    carreras = ["Informática", "Matemáticas", "Física", "Química"]
    while True:
        print("Carrera:")
        for i, c in enumerate(carreras, 1):
            print(f"{i}. {c}")
        try:
            sel = int(input("Opción: "))
            if 1 <= sel <= len(carreras):
                est["Carrera"] = carreras[sel-1]
                break
        except ValueError:
            pass
        print("Inválido.")
    return est


def contarCarreras(m: int) -> dict:
    """
    Solicita m estudiantes y cuenta por carrera.
    """
    if not isinstance(m, int) or m <= 0:
        raise ValueError("m entero positivo")
    cnt = {c: 0 for c in ["Informática", "Matemáticas", "Física", "Química"]}
    for _ in range(m):
        e = datosEstudiante()
        cnt[e["Carrera"]] += 1
    return cnt


if __name__ == "__main__":
    pass
