#Diseñar un algoritmo que pida al usuario un número del 1 al 9 y le conteste diciendo si 
#el número es primo o no. Por ejemplo, si el usuario introduce el número 7, el algoritmo 
#le responderá que 7 es un número primo.

num = int(input("Ingresar un número del 1 al 9:"))
while num <= 0 or num >= 10:
 num = int(input("El número no es valido, ingrese un nuevo numero:")) #vuelvo a poner el "num =" para actualizar el valor de num

if num != 2 and num != 3 and num != 5 and num != 7:
  print("El número no es primo")
else:
  print("El número es primo")


#######################

num = int(input("Ingresar un número: "))
while num <= 0 or num <= 100:
  num = int(input("El número no es valido, ingrese un nuevo numero:"))
  if num % num == 0:
    print("No es un número primo")
  else:
    print("Es un número primo")



    ###################

num = int(input("Ingresar un número del 1 al 9:"))
for i in range (2, num): 
  if num % i == 0:
    print("No es primo")
    break
else:
  print("Es primo")


###########################

# hacer uno que sea con la raiz cuadrada del número para comprobar si es primo o no
