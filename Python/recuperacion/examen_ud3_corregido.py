import random

# Ejercicio 1
frutas = ["Manzana", "Pera", "Naranja", "Plátano", "Fresa", "Uva", "Melocotón", "Sandía", "Piña"]

def generarFrutasEnTupla(numFrutas: int) -> tuple:
    """
    Genera una tupla con numFrutas aleatorias (con reemplazo) de la lista frutas.
    """
    if not isinstance(numFrutas, int) or numFrutas <= 0:
        raise ValueError("El número de frutas debe ser un entero positivo mayor que 0")
    return tuple(random.choice(frutas) for _ in range(numFrutas))


def contarFrutas(frutasTupla: tuple) -> dict:
    """
    Cuenta cuántas veces aparece cada fruta en la tupla frutasTupla.
    """
    if not isinstance(frutasTupla, tuple):
        raise ValueError("El argumento debe ser una tupla")
    return {fruta: frutasTupla.count(fruta) for fruta in set(frutasTupla)}


# Ejercicio 2
def generarFrutasEnConjunto(numFrutas: int) -> set:
    """
    Genera un conjunto con numFrutas aleatorias (sin reemplazo).
    Nota: si se eligen frutas repetidas al azar, el conjunto final tendrá menos elementos.
    """
    if not isinstance(numFrutas, int) or numFrutas <= 0:
        raise ValueError("El número de frutas debe ser un entero positivo mayor que 0")
    return set(generarFrutasEnTupla(numFrutas))


def compararFrutas(frutas1: set, frutas2: set, frutas3: set) -> dict:
    """
    Compara tres conjuntos de frutas y devuelve:
      - FrutasTotales: unión de los tres conjuntos
      - FrutasComunes: intersección de los tres conjuntos
      - FrutasUnicas: frutas que aparecen en exactamente uno de los conjuntos
    """
    if not all(isinstance(f, set) for f in (frutas1, frutas2, frutas3)):
        raise ValueError("Todos los argumentos deben ser conjuntos")
    totales = frutas1 | frutas2 | frutas3
    comunes = frutas1 & frutas2 & frutas3
    unicas = {f for f in totales if [f in frutas1, f in frutas2, f in frutas3].count(True) == 1}
    return {
        "FrutasTotales": totales,
        "FrutasComunes": comunes,
        "FrutasUnicas": unicas,
    }


# Ejercicio 3
def decimalABinario(decimal: int) -> str:
    """
    Convierte un entero no negativo en su representación binaria como cadena.
    """
    if not isinstance(decimal, int):
        raise TypeError("El número debe ser un entero")
    if decimal < 0:
        raise ValueError("El número debe ser un entero positivo")
    if decimal < 2:
        return str(decimal)
    return decimalABinario(decimal // 2) + str(decimal % 2)


# Ejercicio 4
def datosJugador() -> dict:
    """
    Solicita por consola los datos de un jugador de baloncesto:
    Nombre, Dorsal (0-99) y Posición.
    """
    jugador = {}
    while True:
        nombre = input("Introduce el nombre del jugador: ").strip()
        if nombre:
            jugador["Nombre"] = nombre
            break
        print("El nombre no puede estar vacío. Intenta de nuevo.")

    while True:
        try:
            dorsal = int(input("Introduce el dorsal (0-99): "))
            if 0 <= dorsal <= 99:
                jugador["Dorsal"] = dorsal
                break
            print("El dorsal debe estar entre 0 y 99. Intenta de nuevo.")
        except ValueError:
            print("El dorsal debe ser un número entero. Intenta de nuevo.")

    posiciones = ["Base", "Escolta", "Alero", "Ala-Pívot", "Pívot"]
    while True:
        print("Selecciona la posición del jugador:")
        for i, posicion in enumerate(posiciones, 1):
            print(f"{i} - {posicion}")
        try:
            eleccion = int(input("Introduce el número correspondiente: "))
            if 1 <= eleccion <= len(posiciones):
                jugador["Posición"] = posiciones[eleccion - 1]
                break
            print("Opción no válida. Intenta de nuevo.")
        except ValueError:
            print("Debes introducir un número válido. Intenta de nuevo.")

    return jugador


def contarPosiciones(numJugadores: int) -> dict:
    """
    Solicita los datos de numJugadores jugadores y cuenta cuántos hay en cada posición.
    """
    if not isinstance(numJugadores, int) or numJugadores <= 0:
        raise ValueError("El número de jugadores debe ser un entero positivo mayor que 0")
    posiciones = ["Base", "Escolta", "Alero", "Ala-Pívot", "Pívot"]
    contador = {pos: 0 for pos in posiciones}
    for _ in range(numJugadores):
        jugador = datosJugador()
        if jugador:
            contador[jugador["Posición"]] += 1
    return contador


if __name__ == "__main__":
    # Código de ejemplo o pruebas aquí
    pass
