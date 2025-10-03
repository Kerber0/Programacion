# Crea un programa que cuente cuantas veces se repite cada palabra
# y que muestre el recuento final de todas ellas.
# - Los signos de puntuación no forman parte de la palabra.
# - Una palabra es la misma aunque aparezca en mayúsculas y minúsculas.
# - No se pueden utilizar funciones propias del lenguaje que
#   lo resuelvan automáticamente.

# lo hacemos en funcion:

def contar_palabra(texto):
  minuscula = ""
  for char in texto:
    if 'A' <= char <='Z': #Verificamos si el caracter es una mayuscula
      minuscula += chr(ord(char)+32) #convertimos a mayusculas usando Acii
    else:
      minuscula += char

  #eliminamos los signos de puntuacion:

  signos_puntuacion = ".,;:!?/"
  texto_limpio = ""

  for char in minuscula:    # Recorremos el texto para separar las palabras
    if char not in signos_puntuacion:
      texto_limpio += char

      palabras = []
      palabra =""
      for char in texto_limpio:
        if char == " ":
          palabras.append(palabra)
          palabra = " "
        
