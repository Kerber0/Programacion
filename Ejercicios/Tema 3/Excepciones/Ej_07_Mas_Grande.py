# Escribir una función que reciba una lista de números y devuelva el número más grande.
# Si la lista está vacía debe devolver un mensaje de error.

def maximo(lista: list) -> float:
    try:
        if not lista:
            raise ValueError
        mayor = lista[0]  # Inicializamos con el primer elemento
        for num in lista:
            if num > mayor:
                mayor = num
        return mayor
    except ValueError:
        print("La lista está vacía.")
    except TypeError:
        print("Error: Los elementos de la lista deben ser números")


# Pruebas
print(maximo([1, 2, 3, 4, 5]))  # 5
print(maximo([]))  # Error: Lista vacía
# Error: Los elementos de la lista deben ser números
print(maximo([1, "a", 3, 4, 5]))
