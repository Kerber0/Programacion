# Escribir una función que reciba una lista de números y devuelva 
# su media. Si la lista está vacía debe devolver un mensaje de error.

def media(lista: list) -> float:
  try:                               # sum(lista) / len(lista)
    suma = 0
    for i in lista:
      suma += i
    return (suma / len(lista))
  except ZeroDivisionError:
    if len(lista) == 0:
      print("Error: Lista vacía")
      return None
  except TypeError:
    print("Error: Los elementos de la lista deben ser números")
    return None
  except Exception:
    print("Error inesperado")
    return None
  
# Pruebas
print(media([1, 2, 3, 4, 5])) # 3.0
print(media([])) # Error: Lista vacía
print(media([1, "a", 3, 4, 5])) # Error: Los elementos de la lista deben ser número