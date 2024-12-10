# Diseñar una función que intercambie el valor de dos variables de tipo entero. Incluir el algoritmo 
# principal que realice la llamada a dicha función.


def cambio_de_valores (a,b) -> int:
  aux = a
  a = b
  a = aux
  return(a,b)

def intercambio (a,b) -> int:
  a,b=b,a
  return(a,b)

def intercambiar_con_cuentas(a, b):
    a = a + b
    b = a - b
    a = a - b
    return a, b


a = 1 
b = 2 
a,b = intercambio(a,b)
print(a,b)
a,b = cambio_de_valores(a,b)
print(a,b)
a,b = intercambiar_con_cuentas(a,b)
