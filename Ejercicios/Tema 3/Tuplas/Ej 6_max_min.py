# Escribir una función que reciba una tupla de números y devuelva su máximo y su mínimo.

def maximo_minimo(tupla: tuple)-> tuple:
    try:
        return(max(tupla), min(tupla))
    except ValueError:
        print("Error inesperado")
    except TypeError:
        print("Error: la tupla debe estar compuesta por números")

# Pruebas
print(maximo_minimo((1, 2, 3, 4, 5)))  # (5, 1)
print(maximo_minimo((1, 2, 3, 4, 5, 6, 7, 8, 9, 10)))  # (10, 1)
