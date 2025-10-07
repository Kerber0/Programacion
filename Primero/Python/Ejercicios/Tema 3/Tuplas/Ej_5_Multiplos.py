# Escribir una función que reciba una tupla de números y un valor n y
# devuelva una lista con los elementos de la tupla que son múltiplos de n.

def multiplos(tupla: tuple, n: int) -> list:
    "Elementos de la tupla que son multiplos de n"
    try:
        return [i for i in tupla if i % n == 0]
    except ZeroDivisionError:
        print("Error: el divisor no puede ser 0")
    except TypeError:
        print("Error: la tupla debe ener solo números")
    except:
        print("Error inesperado")


# Pruebas
print(multiplos((1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 2))  # [2, 4, 6, 8, 10]
print(multiplos((1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 3))  # [3, 6, 9]
