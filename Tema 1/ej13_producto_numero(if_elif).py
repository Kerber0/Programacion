#Diseñar un algoritmo, que dados dos números, determine si su producto es positivo, 
# nulo o negativo, sin realizar la multiplicación.

num1 = int((input("Introducir primer numero:")))
num2 = int((input("Introducir segundo numero:")))

if (num1 > 0 and num2 > 0) or (num1 < 0 and num2 < 0):
    print("El producto de los dos números es positivo")
elif num1 == 0 or num2 == 0 :
    print("El producto de los dos números es nulo, 0")
else :
    print("El producto de los dos números es negativo")
    