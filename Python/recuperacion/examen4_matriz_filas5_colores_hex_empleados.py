import random

# Ejercicio 1
# Enunciado:
# Dada una matriz (lista de listas) de tamaño M×N con valores aleatorios 0–9,
# convertirla en tupla de tuplas y contar cuántas filas contienen al menos un 5.


def generarMatrizTupla(m: int, n: int) -> tuple:
    """
    Retorna tupla de m filas, cada fila tupla de n números 0–9.
    """
    if not all(isinstance(x, int) and x > 0 for x in (m, n)):
        raise ValueError("m y n enteros positivos")
    mat = tuple(tuple(random.randint(0, 9) for _ in range(n))
                for _ in range(m))
    return mat


def contarFilasCon5(mat: tuple) -> int:
    """
    Cuenta filas de la matriz que contienen al menos un 5.
    """
    if not isinstance(mat, tuple):
        raise TypeError("Matriz como tupla")
    return sum(1 for fila in mat if 5 in fila)


# Ejercicio 2
# Enunciado:
# Crear tres conjuntos de colores (strings), calcular:
# - Colores comunes a los tres
# - Colores que solo aparecen en dos de los tres

def compararColores(a: set, b: set, c: set) -> dict:
    """
    Intersección de tres y pares exactos.
    """
    if not all(isinstance(s, set) for s in (a, b, c)):
        raise TypeError("Conjuntos esperados")
    comunes = a & b & c
    # Aparecen en exactamente dos conjuntos
    pares = {x for x in (a | b | c)
             if [x in a, x in b, x in c].count(True) == 2}
    return {"Comunes": comunes, "EnDos": pares}


# Ejercicio 3
# Enunciado:
# Función para convertir un entero no negativo a hexadecimal (recursiva).

def decimalAHex(decimal: int) -> str:
    """
    Convierte entero >=0 a cadena hex en mayúsculas.
    """
    if not isinstance(decimal, int):
        raise TypeError("Entero")
    if decimal < 0:
        raise ValueError(">=0")
    hex_digits = "0123456789ABCDEF"
    if decimal < 16:
        return hex_digits[decimal]
    return decimalAHex(decimal//16) + hex_digits[decimal % 16]


# Ejercicio 4
# Enunciado:
# Pedir datos de un empleado: nombre, ID (positivo), departamento de lista.
# Para Q empleados, contar cuántos por departamento.

def datosEmpleado() -> dict:
    """
    Solicita y valida datos de un empleado.
    """
    emp = {}
    # Nombre
    while True:
        n = input("Nombre empleado: ").strip()
        if n:
            emp["Nombre"] = n
            break
        print("No vacío.")
    # ID
    while True:
        try:
            i = int(input("ID (entero positivo): "))
            if i > 0:
                emp["ID"] = i
                break
        except ValueError:
            pass
        print("Inválido.")
    # Departamento
    deps = ["Ventas", "RRHH", "IT", "Marketing"]
    while True:
        print("Departamentos:")
        for idx, d in enumerate(deps, 1):
            print(f"{idx}. {d}")
        try:
            sel = int(input("Opción: "))
            if 1 <= sel <= len(deps):
                emp["Departamento"] = deps[sel-1]
                break
        except ValueError:
            pass
        print("Inválido.")
    return emp


def contarDepartamentos(q: int) -> dict:
    """
    Solicita q empleados y cuenta por departamento.
    """
    if not isinstance(q, int) or q <= 0:
        raise ValueError("q entero positivo")
    cnt = {d: 0 for d in ["Ventas", "RRHH", "IT", "Marketing"]}
    for _ in range(q):
        e = datosEmpleado()
        cnt[e["Departamento"]] += 1
    return cnt


if __name__ == "__main__":
    pass
