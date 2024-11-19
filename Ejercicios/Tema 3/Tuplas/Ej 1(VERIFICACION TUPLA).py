# Escribir una función que reciba una tupla de elementos e indique
# si se encuentran ordenados de menor a mayor o no. 


   
def ordenado_menor(tupla: tuple) -> bool:    # Verifica la tupla con funcion isinstance
 
  if not isinstance(tupla, tuple):
        raise TypeError("El argumento debe ser una tupla.")
     # Comprobar orden
  for i in range(len(tupla) - 1):
      if tupla[i] > tupla[i + 1]:
          return False
  return True

try:
    print(ordenado_menor((1, 2, 3, 4)))  # True
    print(ordenado_menor((4, 3, 2, 1)))  # False
    print(ordenado_menor([1, 2, 3, 4]))  # Lanza TypeError
except TypeError as e:
    print(f"Error: {e}")