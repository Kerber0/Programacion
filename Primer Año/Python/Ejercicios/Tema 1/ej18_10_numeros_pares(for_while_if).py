#Diseñar un algoritmo que lea una lista de 10 números enteros, visualice la suma de 
#los pares, cuántos pares existen y cuál es la media aritmética de los números impares.

sumadeimpares = 0
contadoresimpares = 0
contadorpares = 0
sumadepares = 0
media = 0

for i in range (10):
    num = int(input(f"Ingrese un número entero {i+1}/10 :"))
    while num <= 0 : 
        num = int(input("El numero no es válido, ingrese un número entero: "))
    if num % 2 != 0:
        contadoresimpares += 1
        sumadeimpares += num
    else :
        contadorpares += 1
        sumadepares += num
    media = sumadeimpares / contadoresimpares

print("La suma de los", contadorpares, "números pares ingresados es de:", sumadepares)
print("La media de los", contadoresimpares, "numeros impares ingresados es de: ", media)