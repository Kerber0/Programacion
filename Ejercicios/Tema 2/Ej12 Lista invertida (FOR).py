# Diseñar una función que devuelva una lista invertida a partir de otra. Incluir un 
# programa que pruebe la función.


def invertir_lista(lista):
    lista_invertida = [] 
    for i in range(len(lista) - 1, -1, -1):  
        lista_invertida.append(lista[i])  
    return lista_invertida 


def invierte_lista(lista):
    return lista[::-1]

if __name__ == "__main__":
    entrada = input("Ingrese los elementos de la lista separados por espacios: ")
    lista_original = entrada.split()
    
    lista_invertida = invertir_lista(lista_original)
    lista_invertida2 = invierte_lista(lista_original)
    
    print("Lista original:", lista_original)
    print("Lista invertida:", lista_invertida)
    print("Lista invertida:", lista_invertida2)