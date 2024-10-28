#Diseñar un algoritmo que lea del teclado tres números enteros y escriba
#en pantalla un mensaje indicando si al menos dos de esos tres números 
#son pares.

a = int(input("Introduce un número: "))
b = int(input("Introduce otro número: "))
c = int(input("Introduce otro número: "))

if(a % 2 == 0 and b % 2 ==0) or (a % 2 ==0 and c % 2 == 0) or (b % 2 ==0 and c % 2 == 0):
    print("Dos de los números son pares")
elif a % 2 == 0 or b % 2 == 0 or c % 2 == 0:
    print("Al menos uno de los números es par")
elif a % 2 != 0 and b % 2 != 0 and c % 2 != 0:
    print("Los tres numeros son impares")
else:
    print("Al menos dos de los números son impares")