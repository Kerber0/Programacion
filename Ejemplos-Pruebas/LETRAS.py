def imprimir_letra_a(altura):
  if altura < 3:
      print("La altura debe ser al menos 3.")
      return
    
  ancho = 2 * altura - 1
  medio = ancho // 2
  for i in range(altura):
      # Genera cada línea de la letra "A" usando comprensión de lista
      linea = ''.join(
          "*" if j == medio - i or j == medio + i or (i == altura // 2 and medio - i < j < medio + i) else " "
          for j in range(ancho)
      )
      print(linea)

def imprimir_letra_b(altura):
  if altura < 3:
      print("La altura debe ser al menos 3.")
      return
  
  for i in range(altura):
      linea = ''.join(
          "*" if j == 0 or (i == 0 and j < altura - 1) or (i == altura // 2 and j < altura - 1) or 
                (i == altura - 1 and j < altura - 1) or (j == altura - 1 and i != 0 and i != altura // 2 and i != altura - 1)
          else " "
          for j in range(altura)
      )
      print(linea)

def imprimir_letra_c(altura):
  if altura < 3:
      print("La altura debe ser al menos 3.")
      return
  
  for i in range(altura):
      linea = ''.join(
          "*" if (i == 0 and j > 0) or (i == altura - 1 and j > 0) or (j == 0 and i != 0 and i != altura - 1)
          else " "
          for j in range(altura)
      )
      print(linea)

def imprimir_letra_d(altura):
  if altura < 3:
      print("La altura debe ser al menos 3.")
      return
  
  for i in range(altura):
      linea = ''.join(
          "*" if j == 0 or (j == altura - 1 and i != 0 and i != altura - 1) or 
                (i == 0 and j < altura - 1) or (i == altura - 1 and j < altura - 1)
          else " "
          for j in range(altura)
      )
      print(linea)

def imprimir_letra_e(altura):  # REVISAR
  if altura < 3:
          print("La altura debe ser al menos 3.")
          return

  for i in range(altura):
            if i == 0 or i == altura - 1 or i == altura // 2:
                print('*' * altura)  # Partes superior, inferior y media de la E
            else:
                print('*')  # Lado de la E

      """"
      for i in range(altura):
  if i == 0 or i == altura - 1:
      print('*' * (altura - 1))  # Parte superior e inferior de la S
  elif i == altura // 2:
      print('*' * (altura // 2))  # Parte media de la S
  else:
      print('*')  # Lados de la S
      
      """

def imprimir_letra_f(altura):
  if altura < 3:
    print("La altura debe ser al menos 3.")
    return

  for i in range(altura):
    if i == 0 or i == altura // 2:
        print('*' * altura)  # Parte superior y media de la F
    else:
        print('*')  # Lado de la F

# def imprimir_letra_g(altura):

# def imprimir_letra_h(altura):

def imprimir_letra_i(altura):
  for i in range(altura):
    if i == 0 or i == altura - 1:
        print('*' * altura)  # Parte superior e inferior de la I
    else:
        print(' ' * (altura // 2) + '*')  # Centro de la 

def imprimir_letra_j(altura):
  for i in range(altura):
    if i == 0:
        print('*' * (altura - 1) + '*')  # Parte superior de la J
    elif i == altura - 1:
        print('*' * (altura // 2))  # Parte inferior de la J
    else:
        print(' ' * (altura // 2) + '*')  # Lados de la J

# def imprimir_letra_K(altura):

def imprimir_letra_l(altura):
  for i in range(altura):
    if i == altura - 1:
        print('*' * altura)  # Parte inferior de la L
    else:
        print('*')  # Lado de la L

# def imprimir_letra_m(altura):
    
def imprimir_letra_n(altura):
  for i in range(altura):
    if i == 0 or i == altura - 1:
        print('*' + ' ' * (altura - 2) + '*')  # Lados de la N
    else:
        print('*' + ' ' * (i - 1) + '*' + ' ' * (altura - i - 2) + '*')  # Diagonal de la N

def imprimir_letra_o(altura):  # REVISAR
  for i in range(altura):
    if i == 0 or i == altura - 1:
        print('*' * altura)  # Parte superior e inferior de la Q
    elif i == altura // 2:
        print('*' + ' ' * (altura - 2) + '*')  # Parte media de la Q
    else:
        print('*' + ' ' * (altura - 2) + '*')  # Lados de la Q

     
# def imprimir_letra_p(altura):
     
# def imprimir_letra_q(altura):
     
# def imprimir_letra_r(altura):
     
# def imprimir_letra_s(altura):
     
def imprimir_letra_t(altura):
  for i in range(altura):
    if i == 0:
        print('*' * (altura*2))  # Parte superior de la T
    else:
        print(' ' * (altura*2 // 2) + '*')  # Lado de la T

def imprimir_letra_u(altura):
  for i in range(altura):
    if i == altura - 1:
        print('*' * altura)  # Parte inferior de la U
    else:
        print('*' + ' ' * (altura - 2) + '*')  # Lados de la U  

# def imprimir_letra_v(altura):

# def imprimir_letra_w(altura):

# def imprimrir_letra_x(altura):
     
def imprimir_letra_z(altura):
   for i in range(altura):
      if i == 0 or i == altura - 1:
          # Parte superior e inferior de la Z
          print('*' * altura)
      else:
          # Lados diagonales de la Z
          print(' ' * (altura - i - 1) + '*')
     


# Función para imprimir todas las letras deseadas
def imprimir_abecedario(altura):
    print("Letra A:")
    imprimir_letra_a(altura)
    print("\nLetra B:")
    imprimir_letra_b(altura)
    print("\nLetra C:")
    imprimir_letra_c(altura)
    print("\nLetra D:")
    imprimir_letra_d(altura)
    print("\nLetra E:")
    imprimir_letra_e(altura)
    print("\nLetra F:")
    imprimir_letra_f(altura)
    print("\nLetra G:")
    # imprimir_letra_g(altura)
    print("\nLetra H:")
    # imprimir_letra_h(altura)
    print("\nLetra I:")
    imprimir_letra_i(altura)
    print("\nLetra J:")
    imprimir_letra_j(altura)
    print("\nLetra K:")
    # imprimir_letra_k(altura)
    print("\nLetra L:")
    imprimir_letra_l(altura)
    print("\nLetra M:")
    # imprimir_letra_m(altura)
    print("\nLetra N:")
    imprimir_letra_n(altura)
    print("\nLetra Ñ:")
    # imprimir_letra_ñ(altura)
    print("\nLetra O:")
    imprimir_letra_o(altura)
    print("\nLetra P:")
    # imprimir_letra_p(altura)
    print("\nLetra Q:")
    # imprimir_letra_q(altura)
    print("\nLetra R:")
    # imprimir_letra_r(altura)
    print("\nLetra S:")
    # imprimir_letra_s(altura)
    print("\nLetra T:")
    imprimir_letra_t(altura)
    print("\nLetra U:")
    imprimir_letra_u(altura)
    print("\nLetra V:")
    # imprimir_letra_v(altura)
    print("\nLetra W:")
    # imprimir_letra_w(altura)
    print("\nLetra X:")
    # imprimir_letra_x(altura)
    print("\nLetra Y:")
    # imprimir_letra_y(altura)
    print("\nLetra Z:")
    imprimir_letra_z(altura)



    # Agregar más letras según el mismo formato



if __name__ == "__main__":
  letra = input("Introduzca la Letra que desea imprimir: ")
  letra = letra.upper()
  altura = int(input("Introduzca la alutra de la letra a imprmir: "))
match letra :
    case "A":
        imprimir_letra_a(altura)
    case "B":
      imprimir_letra_b(altura)
    case "C":
        imprimir_letra_c(altura)
    case "D":
        imprimir_letra_d(altura)
    case "E":
      imprimir_letra_e(altura)
    case "F":
        imprimir_letra_f(altura)
    #case "G":
      #imprimir_letra_g(altura)
    #case "H":
      #imprimir_letra_h(altura)
    case "I":
        imprimir_letra_i(altura)
    case "J":
      imprimir_letra_j(altura)
     #case "K":
      #  imprimir_letra_k(altura)
    case "L":
      imprimir_letra_l(altura)
    #case "M":
     #   imprimir_letra_m(altura)
    case "N":
      imprimir_letra_n(altura)
    #case "O":
      #imprimir_letra_o(altura)
    case "i":
        imprimir_letra_i(altura)
    case "j":
      imprimir_letra_j(altura)


    case _:
      