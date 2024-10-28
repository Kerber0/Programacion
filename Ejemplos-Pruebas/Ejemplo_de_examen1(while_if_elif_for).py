# Realizar un algoritmo que pinte unaletra U por pantalla hecha con asteriscos. El programa 
# pedirá la altura. Fijate que el programa inserta un espacio y pinta dos asteriscos para
# simular la curva de la letra.
# Es importante indicar al usuario que la altura minima deber ser de 4.

# Ejemplo 1 :
# Introduzca la altura de la U : 5
#
# *     *
# *     *
# *     *
# *     *
#   ***

# Ejemplo 2 :
# Introduzca la altura de la U : 4

# *    *
# *    *
# *    *
#   **  


# altura = int(input("Introduzca la altura de la U: "))

# while altura < 4 :
#         input("La altura minima debe ser mayor: ")

# for i in range(altura - 1):
#     print("*" + " " * (altura) + "*")
# print("  " + "*" * (altura - 2))



##########################################

# Intentar a hacer una X
  

#   *     *
#    *   *
#     * * 
#      *
#     * * 
#    *   *
#   *     *

altura = None
valor_inicial = False
while valor_inicial == False:
  altura = int(input("Introducir altura: "))
  if altura < 3:
    print("Error: altura insuficiente!")
  elif altura % 2 == 0:
    print("Error: altura debe ser impar!")
  else:
    valor_inicial = True

for i in range(1, altura, 2):
  print(" "*(i+1) + "*" + " "*(((altura-i)*2)-1) + "*")

print(" "*(altura+1) + "*" )

for i in range(1, altura, 2):
  print(" "*(altura-i) + "*" +" "*((i*2)+1) + "*")
  

#########################################################################

  altura = int(input("La altura debe ser superiro a 3 e impar: "))
while altura < 3 or altura % 2 ==0 :
        if altura < 3 :
                altura = input("Altura insuficiente, ingrese nuevo valor: ")
        if altura % 2 == 0 :
                altura = input("Alutra inválida, debe ser impar: ")

for i in range(altura):
    # Para cada fila, ponemos un "*" en la posición i y en la posición altura - i - 1
    for j in range(altura):
        if j == i or j == (altura - i - 1):
            print("*", end="")
        else:
            print(" ", end="")
    print() 

 