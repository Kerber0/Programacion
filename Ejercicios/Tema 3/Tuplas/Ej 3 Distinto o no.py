# Escribir una función que reciba una tupla de elementos e indique 
# si son todos distintos o no. 

def distinto_o_no(tupla: tuple) -> bool:    
  if not isinstance(tupla, tuple): # Verifica la tupla con funcion isinstance
    print("El argumento debe ser una tupla.")
    return None 
  
  try:
    for i in range(len(tupla) - 1):
        if tupla[i] == tupla[i + 1]:
          return True
    return False
  except Exception as e:
    print(f"Error: {e}")
    return


# Pruebas:

print(distinto_o_no((1, 2, 3, 4, 5, 6, 7)))  # True
print(distinto_o_no((4, 3, 2, 1, 2, 3, 4)))  # False
print(distinto_o_no([1, 2, 3, 4]))  # Lanza TypeError
print(distinto_o_no((1, 2, 3, 3, 4)))  #  True (hay dos 3 consecutivos)
print(distinto_o_no((1, 2, 3, 4)))     #  False (no hay consecutivos iguales)
print(distinto_o_no("1234"))           #  El argumento debe ser una tupla. None
print(distinto_o_no(()))               #  False (tupla vacía, no hay consecutivos)