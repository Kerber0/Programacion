# Diseñar una función que determine la posición del valor máximo de una lista de enteros y 
# otra para indicar cuál es ese valor máximo. Incluir un programa que pruebe ambas funciones.

n = [1 , 5 , 6, 8, 6, 4, 7,6, 8, 8, 9, 6, 4, 5, 3, 1]
def valor_max(n) ->int:
  max_val=n[0] 
  for i in n:
    if i > max_val:
      max_val = i
  return(max_val)

max_val = valor_max(n)

def position_max(n) -> int:
  for i in range (len(n)):
    if n[i] == max_val:
      return i
    else:
      continue

position = position_max(n)

print(max_val)
print(position)

#################################################################
