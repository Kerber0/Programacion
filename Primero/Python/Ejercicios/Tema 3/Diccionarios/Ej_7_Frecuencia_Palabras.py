# Escribir una función que reciba una lista de palabras y devuelva un
# diccionario con las palabras como claves y el número de veces que aparecen como valor.

def frecuencia_palabras(lista_palabras: list) -> dict:
    
    frecuencia = {}
    for palabra in lista_palabras:
        if palabra not in frecuencia:
            frecuencia[palabra]


# Pruebas
# {'hola': 2, 'adiós': 1, 'buenos días': 1, 'buenas noches': 1}
print(frecuencia_palabras(
    ["hola", "adiós", "hola", "buenos días", "buenas noches"]))
# {'hola': 2, 'adiós': 1, 'buenos días': 1, 'buenas noches': 1, '': 1}
print(frecuencia_palabras(
    ["hola", "adiós", "hola", "buenos días", "buenas noches", ""]))
