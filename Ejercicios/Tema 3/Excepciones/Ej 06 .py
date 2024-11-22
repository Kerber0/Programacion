# Escribir una función que reciba un diccionario y una clave y devuelva el 
# valor asociado a la clave. Si la clave no existe debe devolver un mensaje de error.  



# Pruebas
print(valor({"a": 1, "b": 2, "c": 3}, "b")) # 2
print(valor({"a": 1, "b": 2, "c": 3}, "d")) # Error: La clave no existe
print(valor({"a": 1, "b": 2, "c": 3}, 2)) # Error: El segundo argumento debe ser una cadena