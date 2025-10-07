# Escribir una función que reciba una lista de palabras y devuelva
# un diccionario con las palabras como claves y su longitud como valor.

def longitud_palabras(lista_palabras: list) -> dict:

    longitudes = {}
    for palabras in lista_palabras:
        longitudes[palabras] = len(palabras)
    return longitudes


# Pruebas
# {'hola': 4, 'adiós': 5, 'buenos días': 10, 'buenas noches': 13}
print(longitud_palabras(["hola", "adiós", "buenos días", "buenas noches"]))
# {'hola': 4, 'adiós': 5, 'buenos días': 10, 'buenas noches': 13, '': 0
print(longitud_palabras(["hola", "adiós", "buenos días", "buenas noches", ""]))
