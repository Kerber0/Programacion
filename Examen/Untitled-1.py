"""
Diseña un algoritmo que pinte por pantalla un rombo hueco con asteriscos.
El programa debe pedir la altura del rombo al usuario y pintar el rombo con esa altura.
Se debe comprobar que la altura mínima es igual o mayor a 3, y además, que la altura es un número impar.    
En caso de que no se cumplan los requisitos, el programa debe imprimir un mensaje de error y volver a pedir el dato al usuario. 
"""

# Ejemplo de salida para una altura de 5:
#---*
#--* *
#-*   *
#--* *
#---*



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

# for i in range(1,altura,2):
#   print("-"*(altura +i)+"*")



# for i in range(1, altura, 2):
#   print(" "*(i+1) + "*" + " "*(((altura-i)*2)-1) + "*")

# print(" "*(altura+1) + "*" )

# for i in range(1, altura, 2):
#   print(" "*(altura-i) + "*" +" "*((i*2)+1) + "*")
