# Diseñar un algoritmo que obtenga el promedio de una lista de varlores reales
# leídos por teclado. El algoritmo terminará cuándo el usuario introduzca 20 valores.

# lista = int(input("introduzca 20 valores numericos:"))

# media = sum(lista) / len(lista)
# print(media)


suma = 0
for x in range(20):
    print('Introduce el valor', x+1, 'de 20: ')
    valor = float(input())
    suma += valor
print('Suma: ', suma)
print('media = ', suma/(x+1))


###############################################

suma = 0
contador = 0

print("Ingrese un valor" + str(contador + 1) + "/20")
valor = float(input())
suma += valor
contador += 1
promedio = suma / 20

print("El promedio es:" + str(promedio))


######################################################


n = int(input("Ingrese el numero de valores reales, para calcular su promedio: "))
suma = 0
contador = 0
while contador < n:
    valor = float(input("ingrese un valor" +
                  str(contador + 1) + "/" + str(n) + ":"))
    suma += valor
    contador += 1

promedio = suma / n
print("El promedio es:" + str(promedio))
