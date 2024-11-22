# Escribir una función que reciba una tupla de elementos e indique si se
# encuentran ordenados de mayor a menor o no.
  
def ordenado_menor(tupla: tuple) -> bool:    # Verifica la tupla con funcion isinstance
  if len(tupla) == 0:
      print("La tupla está vacía")
      return True
  if not isinstance(tupla, tuple):
    print("El argumento debe ser una tupla.")
    return None 
  
  try:
      # Comprobar orden
    for i in range(len(tupla) - 1):
      if tupla[i] < tupla[i + 1]:
        return False
    return True
  except TypeError:
    print("Error: los elementos no son comparables")
    return None



print(ordenado_menor((1, 2, 3, 4)))  # False
print(ordenado_menor((4, 3, 2, 1)))  # True
print(ordenado_menor([1, 2, 3, 4]))  # Lanza TypeError
