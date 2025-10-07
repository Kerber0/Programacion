'''
Crea un programa que analice una frase introducida por el usuario. El programa debe:

1.  Solicitar al usuario que introduzca una frase.
2.  Convertir la frase a minúsculas y dividirla en palabras.
3.  Utilizar un **conjunto** para almacenar todas las palabras únicas de la frase.
4.  Utilizar un **diccionario** para contar la frecuencia de cada palabra. Las claves serán las palabras y los valores serán sus conteos.
5.  Utilizar una **tupla** para almacenar las 3 palabras más frecuentes junto con sus conteos (por ejemplo, `("palabra1", 5)`). 
Si hay menos de 3 palabras únicas, almacenar todas las disponibles.
6.  Mostrar:
    * El número total de palabras en la frase.
    * El número de palabras únicas.
    * La lista de palabras únicas (el conjunto).
    * La frecuencia de cada palabra (el diccionario).
    * Las 3 palabras más frecuentes (la tupla).
'''
def analizador_de_frases():
 
    frase = input("Ingrese la frase que quiere analizar: ")
    palabras = frase.lower().split()
    conjunto = set(palabras)
    diccionario = {}
    
    for palabra in palabras:
        if palabra in diccionario:
            diccionario[palabra] +=1
        else:
            diccionario[palabra] = 1
    
    print("Número total de palabras en la frase: ")
    print(len(palabras))
    print("Número de palabras únicas: ")
    print(len(conjunto))
    print("La lista de frecuencia de palabras: ")
    print(diccionario)
    
if __name__ == "__main__":
    analizador_de_frases()