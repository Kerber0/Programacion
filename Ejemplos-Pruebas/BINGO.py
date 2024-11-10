import random
import time
canto_linea = True

def inicio() -> bool:
  while True:
    inicio = input("Te gustaría jugar al Bingo? Y/N: ").upper()
    if inicio == "Y":
      input("Elige un cartón del 1 al 100: ")
      return True
    elif inicio == "N":
      print("Que pena, es muy divertido.")
      return False
    else:
      print("No te entendí. Por favor, responde con 'Y' o 'N'.")
    
def generacion_de_carton(size):
  numero_salidos= []
  matriz= []
  for i in range(size):
    fila = []
    matriz.append(fila)
    for j in range(size):
      numero_aleatorio = random.randint(0,99)
      while numero_aleatorio in numero_salidos:
        numero_aleatorio = random.randint(0,99) 
      numero_salidos.append(numero_aleatorio)
      fila.append(numero_aleatorio)
  return matriz

def imprimir_carton(carton):
  for x in range(5):
    for y in range(5):
      print(str(carton[x][y]) + "\t" , end="")
    print()

def sacar_numeros(carton):
  numeros_retirados=[]
  while len(numeros_retirados)<=100 or revisar_Bingo == False:
    numero = random.randint(0,100)
    if numero not in numeros_retirados:
      numeros_retirados.append(numero)
      time.sleep(1)
      print(f"Número {numero}: ¿Alguien lo tiene?")
      if revisar_carton(carton,numero) == True:
        time.sleep(1)
        imprimir_carton(carton)
      if revisar_Bingo(carton):
        print("TENEMOS UN GANADOR!!")
        return

def revisar_carton(carton,numero):
  for i in range(len(carton)):
    for j in range(len(carton[i])):
      if carton[i][j] == numero:
        carton[i][j] = "X"
        return True
  global canto_linea    
  if canto_linea:    
    if revisar_linea(carton):
      print("TENEMOS UNA LINEA!!")
      canto_linea = False
     
def revisar_linea(carton):
  for i in range(len(carton)):
    for j in range(len(carton[i])):
      if carton[i][j] != "X":
        break
    else:
      return True
  else:
    return False  
      
def revisar_Bingo(carton):
  for i in range(len(carton)):
      for j in range(len(carton[i])):
        if carton[i][j] != "X":
          return False
  else:
    return True

if __name__ == "__main__":
  while inicio():
    carton = generacion_de_carton(5)
    print("Genial! Este es tu carton de Bingo: ")
    imprimir_carton(carton)
    print("Bien! Si todo el mundo tiene su cartón, vamos a comenzar!")
    sacar_numeros(carton)
    break

