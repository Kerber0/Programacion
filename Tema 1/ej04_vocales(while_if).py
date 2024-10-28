#Diseñar un algoritmo que lea 20 caracteres de teclado y muestre por pantalla el 
#número de veces que se repiten cada una de las vocales.

vocales = ['a', 'e', 'i', 'o', 'u']
cantidad_vocales = 0
caracteres = 0
while caracteres <= 20:
    input("insertar caracter: ")
    print(caracteres)
    caracteres += 1
    if caracteres == vocales:
       cantidad_vocales += 1
    print(cantidad_vocales)
print(cantidad_vocales)