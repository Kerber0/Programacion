# Diseñar un algoritmo que lea 20 caracteres de teclado y muestre por pantalla el
# número de veces que se repiten cada una de las vocales.

vocales = ['a', 'e', 'i', 'o', 'u']
CANTIDAD_VOCALES = 0
CARACTERES = 0
while CARACTERES <= 20:
    input("insertar caracter: ")
    print(CARACTERES)
    CARACTERES += 1
    if CARACTERES == vocales:
        CANTIDAD_VOCALES += 1
    print(CANTIDAD_VOCALES)
print(CANTIDAD_VOCALES)
