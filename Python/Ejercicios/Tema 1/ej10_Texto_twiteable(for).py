# Implementar un programa que verifique si un texto es "Twiteable" (tiene 280 caracteres o
# menos) o no. El programa debe pedir un texto por teclado y mostrar un mensaje indicando
# si el texto es Twiteable o no.

n = input(print("Introducir texto: "))
if len(n) < 280:
    print("El texto es válido!")
else:
    print("El texo es invalido")
