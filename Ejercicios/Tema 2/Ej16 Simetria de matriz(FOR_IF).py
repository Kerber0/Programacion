# Diseñar una función que nos compruebe si una matriz bidimensional de enteros es simétrica.
#  Las matrices se representarán como listas de listas y deben pasarse como argumentos a las
#  funciones. Una matriz es simétrica si es cuadrada y es igual a su traspuesta. La traspuesta
#  de una matriz se obtiene intercambiando filas por columnas. Incluir más funciones si es
#  necesario. Incluir un programa que pruebe la función.


lista = [[1,2,1],[2,1,2],[1,2,1]]

def comprobar_simetria(matriz: list) -> bool:
  if not comprobar_cuadrado(matriz):
    return False
  return matriz == traspuesta(matriz)
                  
def comprobar_cuadrado(matriz) -> bool:
  n = len(lista)
  for fila in matriz:
        if len(fila) != n:
          return False
  return True
      
def traspuesta(matriz: list) -> list:
  if not comprobar_cuadrado(matriz):
    return None
  traspuesta = []
  for i in range(len(matriz)):
    traspuesta.append([])
    for j in range(len(matriz)):
      traspuesta[i].append(matriz[j][i])
  return traspuesta  

if __name__ == "__main__":
  print(f"La matriz es cuadrada:", comprobar_cuadrado(lista))
  print(f"La matriz es simetrica:", comprobar_simetria(lista))