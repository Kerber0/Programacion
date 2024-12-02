# Diseñar un algoritmo que lea del teclado dos números enteros
# y un carácter. El caracter puede ser +, -, *, /, %, ^, y en
# función del carácter introducido se mostrará el resultado de
# la operación correspondiente.
# Por ejemplo, si se introduce '7', '3' y '+' se mostrará 10.

numero1 = int(input("introducir primer numero: "))
operacion = input("introducir operacion(+,-,*,/,%,^): ")
numero2 = int(input("introducir segundo numero: "))


if operacion == "+":
    resultado = numero1 + numero2
elif operacion == "-":
    resultado = numero1 - numero2
elif operacion == "*":
    resultado = numero1 * numero2
elif operacion == "^":
    resultado = numero1 ** numero2
elif operacion == "%":
    if numero2 != 0:
        resultado = numero1 / numero2
    else:
        resultado = "No se puede dividir entre 0"
elif operacion == "/":
    if numero2 != 0:
        resultado = numero1 / numero2
    else:
        resultado = "No se puede dividir entre 0"
else:
    resultado = "Operación no válida"

print("El resultado de ",  numero1,  operacion, numero2, "es :", resultado)
