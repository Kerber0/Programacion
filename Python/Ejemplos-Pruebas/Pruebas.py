import random
def letra_aleatoria() -> str:
    return chr(random.randint(65, 90))

def contar_letras(tupla1: tuple, tupla2: tuple) -> dict:
    dic1 = {}
    dic2 = {}
    for i in range (len(tupla1)): 
        if i in dic1:
            dic1[tupla1[i]] += 1
        else:
            dic1[tupla1[i]] = 1
    for j in range (len(tupla2)):       
        if j in dic2:
            dic2[tupla2[j]] += 1
        else:
            dic2[tupla2[j]] = 1 
          
    return print(dic1, dic2)

tupla1 = ("A", "B", "C", "D", "E")
tupla2 = ("A", "B", "C", "D", "E", "E", "G", "H", "I", "J")
print(contar_letras(tupla1, tupla2)) # Diccioanrio con las letras y el número de veces que aparecen
tupla1 = ()
tupla2 = ()
print(contar_letras(tupla1, tupla2)) # Diccionario vacío
