#Diseñar un algoritmo que lea un conjunto de números reales, los cuente y calcule y 
#muestre la media, varianza y la desviación típica del conjunto de números. La media y la
# varianza se calculan con las fórmulas:

#Media = (suma de los números) / (cantidad de números).
#Varianza = ((suma de los cuadrados de los números) - (suma de los números)^2 / (cantidad de números)).
#La desviación típica es la raíz cuadrada de la varianza.

suma_cuadrados =0
suma_num = 0
cantidad_num = 0


for i in range (5):
    num = float(input("Ingrese un número real: "))    
    cantidad_num += 1
    suma_num += num
    suma_cuadrados += num**2
media = suma_num / cantidad_num
varianza= float((suma_cuadrados / cantidad_num) - (suma_num ** 2 / cantidad_num ** 2))
desviacion = varianza **0.5

print("media", media, "varianza", varianza, "desviación", desviacion)
