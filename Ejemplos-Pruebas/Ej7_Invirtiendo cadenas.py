# Crea un programa que invierta el orden de una cadena de texto
# sin usar funciones propias del lenguaje que lo hagan de forma automática.
#  Si le pasamos "Hola mundo" nos retornaría "odnum aloH"


text = input("Texto a invertir: ")
t = ""
for i in range(len(text)-1, -1, -1):
  t += text[i]
print(t, end="")