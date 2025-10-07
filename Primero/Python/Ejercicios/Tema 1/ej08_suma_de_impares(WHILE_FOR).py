# Realizar un algoritmo que calcule y muestre en la pantalla la suma de los n primeros enteros
# impares. El valor de n se solicitará al usuario.

n = print(int(input("Que cantidad de impartes quieres que sume?: ")))
suma = 0
i = 1
while i <= n*2:
    if n % 2 != 0:
        suma += i
    i += 1
print(f"la suma de los {n} primeros impares es {suma}")


################################################################

n = print(int(input("Que cantidad de impartes quieres que sume?: ")))
suma = 0

for i in range(1, n*2, 2):
    suma += i
print(f"la suma de los {n} primeros impares es {suma}")

#####################################################################

n = print(int(input("Que cantidad de impartes quieres que sume?: ")))
suma = 0

for i in range(1, n+1):
    suma += 2*i-1
print(f"la suma de los {n} primeros impares es {suma}")

#####################################################################

suma = 0
i = 1
while i <= n:
    suma = 2*i-1
    i += 1
print(f"la suma de los {n} primeros impares es {suma}")
