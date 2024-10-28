 # Crea una única función (importante que sólo sea una) que sea capaz
 # de calcular y retornar el área de un polígono.
 # - La función recibirá por parámetro sólo UN polígono a la vez.
 # - Los polígonos soportados serán Triángulo, Cuadrado y Rectángulo.
 # - Imprime el cálculo del área de un polígono de cada tipo.

base = 0
altura = 0
incorrecto = True


while incorrecto == True:
  poligono = input("Indique la primera letra de su polígono: ")
  print(poligono)
  if poligono.lower() not in ('t', 'c', 'r'):
    print("Error, polígono incorrecro!")
  else:
    incorrecto = False
    
base = int(input("Inserte la base de su polígono: "))
altura = int(input("Inserte la altura: "))


if poligono == 't':
  area_triangulo = (base * altura)/2
  print(area_triangulo)
elif poligono == 'c':
  area_cuadrado = base * altura
  print(area_cuadrado)
elif poligono == 'r':
  area_rectangulo = base * altura
  print(area_rectangulo)