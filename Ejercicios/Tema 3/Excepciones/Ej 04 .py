# Escribir una función que reciba una lista de números y devuelva 
# una lista con los cuadrados de los números. Si la lista contiene algún 
# elemento que no es un número debe devolver un mensaje de error.    


# Pruebas
print(cuadrados([1, 2, 3, 4, 5])) # [1, 4, 9, 16, 25]
print(cuadrados([1, "a", 3, 4, 5])) # Error: Los elementos de la lista deben ser números
print(cuadrados([])) # []