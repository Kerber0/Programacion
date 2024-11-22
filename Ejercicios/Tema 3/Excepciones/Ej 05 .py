# Escribir una función que reciba una tupla y una posición y devuelva 
# el elemento de la tupla en la posición indicada. Si la posición es mayor
# que la longitud de la tupla debe devolver un mensaje de error.



# Pruebas
print(elemento((1, 2, 3, 4, 5), 2)) # 3
print(elemento((1, 2, 3, 4, 5), 5)) # Error: La posición no existe
print(elemento((1, 2, 3, 4, 5), "a")) # Error: El segundo argumento debe ser un