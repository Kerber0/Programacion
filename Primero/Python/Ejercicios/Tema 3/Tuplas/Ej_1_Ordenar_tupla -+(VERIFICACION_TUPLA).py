# Escribir una función que reciba una tupla de elementos e indique
# si se encuentran ordenados de menor a mayor o no.


# Verifica la tupla con funcion isinstance
def ordenado_menor(tupla: tuple) -> bool:
    if len(tupla) == 0:
        print("La tupla está vacía")
        return True
    if not isinstance(tupla, tuple):
        print("El argumento debe ser una tupla.")
        return None

    try:
        # Comprobar orden
        for i in range(len(tupla) - 1):
            if tupla[i] > tupla[i + 1]:
                return False
        return True
    except TypeError:
        print("Error: los elementos no son comparables")
        return None

# Pruebas:


print(ordenado_menor((1, 2, 3, 4)))  # True
print(ordenado_menor((4, 3, 2, 1)))  # False
print(ordenado_menor([1, 2, 3, 4]))  # Lanza TypeError
# True pero ponemos mensaje avisando que la tupla esta vacia
print(ordenado_menor(()))
print(ordenado_menor(("a", "b", "c", "d")))  # True
print(ordenado_menor((1, "a")))  # None Error
