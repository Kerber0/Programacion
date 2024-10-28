#Diseñar un algoritmo que calcule la potencia para dos números naturales x e y mediante 
#una acumulación sucesiva de productos. Previo al cálculo se verificará que ambos valores
# son positivos.

valores_positivos = False

while not valores_positivos:
    x = input("introducir primer número:")
    y = input("introducir segundo número:")
    if x.isdigit() and y.isdigit() :
        x = int (x)
        y = int (y)
        if(x > 0 and y > 0):
           valores_positivos = True
        else:
            print("Ingrese números positivos")    
    else :
        print("Ingrese solo números")


potencia = x
for i in range(1, y):
    potencia = potencia * x

print("El resultado de la potencia es", potencia)