# Escribir una función que reciba un diccionario y una clave y devuelva el
# valor asociado a la clave. Si la clave no existe debe devolver un mensaje de error.

def valor(dicc, a):
    try:
        if a in dicc:
            print(dicc[a])
        else:
            raise KeyError
    except KeyError:
        print("Error: la clave no existe")


# Pruebas
print(valor({"a": 1, "b": 2, "c": 3}, "b"))  # 2
print(valor({"a": 1, "b": 2, "c": 3}, "d"))  # Error: La clave no existe
# Error: El segundo argumento debe ser una string
print(valor({"a": 1, "b": 2, "c": 3}, 2))
