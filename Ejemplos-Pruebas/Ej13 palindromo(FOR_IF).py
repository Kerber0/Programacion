# Escribe una función que reciba un texto y retorne verdadero o
# falso (Boolean) según sean o no palíndromos.
# Un Palíndromo es una palabra o expresión que es igual si se lee
# de izquierda a derecha que de derecha a izquierda.
# NO se tienen en cuenta los espacios, signos de puntuación y tildes.

# Ejemplo: Ana lleva al oso la avellana.


text = input("Escriba un texo para verificar si es palíndromo: ")
t = ""

for i in range(len(text)-1,-1,-1):
  text = text.lower()
  t += text[i]
ver1 = "".join(t)
ver2 = "".join(text)
if ver1 == ver2:
  print(True)
else:
  print(False)
# print(t)
  # if t == text:
  #   print(True)
  #   print(t)


