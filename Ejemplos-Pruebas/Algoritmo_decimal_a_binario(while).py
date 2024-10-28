# Escribe un algoritmo que convierta un número decimal ingresado por el usuario
# a su equivalente en número binario.
num_bin = 0
mult = 1
num_decimal = input(int("Introducir el número decimal para convertir en binario: "))

while num_decimal > 0 :
    num_bin = num_bin + num_decimal % 2 * mult
    num_decimal = num_decimal // 2
    mult = mult * 10
print("El numero ingresado en binario sería", num_bin)
