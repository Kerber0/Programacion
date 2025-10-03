# Escribir una función que reciba dos números y devuelva su 
# división. Si el segundo número es cero debe devolver un mensaje de error. 

def division(a: int, b: int) -> float:
  try:
    return a/b
  except ZeroDivisionError:
    print("Error: El segundo argumento debe ser positivo")
    return
  except TypeError:
    print("Error: Los argumetnos deben ser números")
    return

# Pruebas
print(division(4, 2)) # 2.0
print(division(4, 0)) # Error: División por cero
print(division("a", 2)) # Error: Los argumentos deben ser números