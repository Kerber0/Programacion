# Resuelve los siguientes ejercicios sin modificar ninguna de las lineas de código existentes.
# Nota: no se pueden modificar las líneas pero si se pueden añadir líneas de código entre las de inicio y final si se necesita más espacio.

# Ejericio 1 (2 puntos)

"""
Diseña un algoritmo que calcule la cantidad de propinas que se deben dar en un restaurante.
El algoritmo debe leer de teclado el total de la cuenta y preguntarle al usuario si su servicio fue bueno, malo o regular.
Para saber la opción elegida por el usuario, se debe indicar que el usuario debe escribir "bueno", "malo" o "regular",
 puede escribirlo en minúsculas, mayúsculas o combinando ambas y debe funcionar igual.   
En caso de que el servicio haya sido bueno, el algoritmo debe calcular el 20% del total de la cuenta.   
En caso de que el servicio haya sido regular, el algoritmo debe calcular el 15% del total de la cuenta.
En caso de que el servicio haya sido malo, el algoritmo debe calcular el 10% del total de la cuenta.
Finalmente, el algoritmo debe imprimir el total de la cuenta más la propina y el total de la propina, por separado.   
"""

print("Ejercicio 1 - Calculadora de propinas")

propina = None
total_cuenta = int(input("Ingrese el total de su cuenta: "))
while total_cuenta < 0: 
   total_cuenta = int(input("Verifique el importe de la cuenta: "))

servicio = input("Valore nuestro servicio como: bueno, malo, regular: ")
servicio = servicio.lower()
while servicio != "bueno" and servicio != "regular" and servicio != "malo":
    servicio  = input("Su calificación de nuestro servicio no es válida, califiquenos de nuevo: ")
if servicio == "bueno" :
  propina = total_cuenta*0.20   
elif servicio == "regular":
  propina = total_cuenta*0.15
else: 
  propina = total_cuenta *0.1



print("El total de la cuenta es:", total_cuenta, "€ y la propina es: ", propina, "€.")

print("-"*20)

# Ejericio 2 (2 puntos)


"""
Diseñar un algoritmo que nos diga si la palabra introducida por el usuario es un palíndromo o no.   
Un palíndromo es una palabra que se lee igual de izquierda a derecha que de derecha a izquierda.    
Por ejemplo, la palabra "oso" es un palíndromo.
El algoritmo debe leer una palabra del usuario y comprobar si es un palíndromo o no.
"""
print("Ejercicio 2 - Comprobador de palíndromos")

palabra = input("Introduce una palabra: ")
inversa = ""
palabra = palabra.lower()

for i in range(len(palabra)-1,-1,-1):
  inversa += palabra[i]
palabra_inversa = "".join(inversa)  

if inversa != palabra: 
  print("La palabra ingresada no es palíndromo")
else:
  print("La palabra ingressada es un palíndromo!")


print("-"*20)

# Ejericio 3 (2 puntos)

"""
Diseñar un algoritmo que calcule la edad de una persona en función de su fecha de nacimiento.
El algoritmo debe leer el año, mes y día de nacimiento de la persona y calcular su edad a día de hoy.
Hay que comprobar que la fecha de nacimiento es válida, aunque se da por hecho que los datos introducidos
 por el usuario serán números enteros.
Finalmente, el algoritmo debe imprimir la edad de la persona.
"""

print("Ejercicio 3 - Calculadora de edad")

año = 2024
mes = 10
día = 16


año_nac = int(input("Intruduzca su año de nacimiento en números por favor: "))
mes_nac = int(input("Intruduzca su mes de nacimiento en números por favor: "))
día_nac = int(input("Intruduzca su día de nacimiento en números por favor: "))

while año_nac < 1900:
  año_nac = int(input("Año de nacimiento inválida, no creo que tenga más de 120 años. Pruebe otra vez: "))
while mes_nac > 12 and mes_nac < 1:
  mes_nac = int(input("Los años tienen de 1 a 12 meses, pruebe otra vez: "))
while día_nac > 31 and día_nac < 0:
  día_nac = int(input("Los meses tienen de 1 a 31 días, pruebe otra vez: "))

edad = año - año_nac
if mes_nac > mes or (mes_nac == mes and día_nac > día):
  edad -= 1


print("La edad de la persona es:", edad, "años")

print("-"*20)

# Ejericio 4 (2 puntos)

"""
Diseña un algoritmo que pinte por pantalla un rombo hueco con asteriscos.
El programa debe pedir la altura del rombo al usuario y pintar el rombo con esa altura.
Se debe comprobar que la altura mínima es igual o mayor a 3, y además, que la altura es un número impar.    
En caso de que no se cumplan los requisitos, el programa debe imprimir un mensaje de error y volver a pedir el dato al usuario. 
"""

# Ejemplo de salida para una altura de 5:
#   *
#  * *
# *   *
#  * *
#   *

print("Ejercicio 4 - Rombo hueco")

valor_inicial = False
while valor_inicial == False:
  altura = int(input("Introducir altura: "))
  if altura < 3:
    print("Error: altura insuficiente!")
  elif altura % 2 == 0:
    print("Error: altura debe ser impar!")
  else:
    valor_inicial = True

for i in range (altura):
  #print("-"*((altura -i)-2)+"*"+"-"*(((altura +i)//2)-2)+"*")
  print("-"*((altura-i)-1)+ "*" + " "* ((i// altura)-1) + "*")


print("-"*20)

# Ejericio 5 (2 puntos - 1 punto cada versión - Jugando con los dígitos) 

"""
Diseñar un algoritmo que pida al usuario un número entero y calcule la suma de los dígitos de ese número.
Una vez tenga la suma calculada debe dividir el resultado entre el total de dígitos que tiene el número.
Finalmente, el algoritmo debe imprimir el resultado de la división.
Hay que controlar el que el número introducido por el usuario sea positivo.
Este ejercicio hay que resolverlo de dos maneras, es decir, debes hacer dos versiones del algoritmo:
Una con un bucle while y con un bucle for. Cada versión debe tener su propio código y no se pueden mezclar.
Cada versión del algoritmo tendrá un valor de 1 punto.
"""

print("Ejercicio 5 - Jugando con los dígitos - versión while")

num = int(input("Ingrese un número entero mayor que 0: "))
contador = 0
suma = 0
digito = None


while int(num) < 0: 
  num = int(input("El número introducido es menor que 0, pruebe otra vez: "))

while num != 0:
  digito = num % 10
  num = num //10
  suma += digito
  contador += 1

print("La divsion de la suma de los numeros es: ", (suma/contador))

print("-"*20)

print("Ejercicio 5 - Jugando con los dígitos - versión for")

num = input("Ingrese un número entero mayor que 0: ")
contador = 0
suma = 0



while int(num) < 0: 
  num = int(input("El número introducido es menor que 0, pruebe otra vez: "))

for i in range (len(num)):
 suma += (int(num[i]))
 contador += 1

print("La divsion de la suma de los numeros es: ", (suma/contador))

print("-"*20)