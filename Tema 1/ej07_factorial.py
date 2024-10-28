# Diseñar un algoritmo que calcule y muestre en pantalla el factorial 
# de un número entero dado.


#numero = int(input("Introduzca el número: "))
#factorial = 1
#i = 1
#while (i <= numero):
#    factorial = factorial * i
#    i = i + 1
#print ("El factorial de " + str(numero) + " es " + str(factorial))


###########################################################################

numero = int(input("Introduzca el número: "))
factorial = 1
for x in range (1, numero+1): 
    factorial *= x
print("El factorial de " + str(numero) + " es " + str(factorial))

############################################################################

numero = int(input("Introduzca el número: "))
factorial = numero
i = numero
while i > 1:
    i -= 1
print(f"El factorial de {numero} es {factorial}")


