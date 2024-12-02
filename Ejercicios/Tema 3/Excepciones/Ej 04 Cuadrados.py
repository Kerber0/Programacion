# Escribir una función que reciba una lista de números y devuelva
# una lista con los cuadrados de los números. Si la lista contiene algún
# elemento que no es un número debe devolver un mensaje de error.

def cuadrados(lista: list) -> list:
    try:
        return [i ** 2 for i in lista]
    except TypeError:
        print("Error:")


# Pruebas
print(cuadrados([1, 2, 3, 4, 5]))  # [1, 4, 9, 16, 25]
# Error: Los elementos de la lista deben ser números
print(cuadrados([1, "a", 3, 4, 5]))
print(cuadrados([]))  # []
