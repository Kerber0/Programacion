# Escribir una función que reciba una tupla y una posición y devuelva
# el elemento de la tupla en la posición indicada. Si la posición es mayor
# que la longitud de la tupla debe devolver un mensaje de error.

def elemento(tupla: tuple, pos: int):
    try:
        return tupla[pos]
    except IndexError:
        print("Error: El segundo argumento debe ser un número")
    except Exception:
        print("Error inesperado")


# Pruebas
print(elemento((1, 2, 3, 4, 5), 2))  # 3
print(elemento((1, 2, 3, 4, 5), 5))  # Error: La posición no existe
# Error: El segundo argumento debe ser un
print(elemento((1, 2, 3, 4, 5), "a"))
