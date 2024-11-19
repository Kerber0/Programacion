#Diseñar un algoritmo que lea un número entero de teclado, visualice sus dígitos y calcule la
# suma de los dígitos que sean pares. Para extraer los dígitos de un número usaremos un bucle que 
#divida el número por 10 sucesivamente. El resto de cada división corresponde a cada uno de los dígitos.

num = int(input("Ingrese un número entero: "))
suma_pares = 0

"""while num != 0:
    digitos = num % 10
    num = num // 10
    print("Digitos: ",digitos)
    if digitos % 2 == 0:
        suma_pares += digitos
print("La suma de los números pares es: ",suma_pares)"""


######################################################

num = int(input("Ingrese un número entero: "))
muestra = ""

while num != 0:
    digitos = num % 10
    num = num // 10
    if digitos % 2 == 0:
        suma_pares += digitos
        muestra = str(digitos) + "," + muestra   
print( "Digitos: ", muestra)
print("La suma de los números pares es: ",suma_pares)

