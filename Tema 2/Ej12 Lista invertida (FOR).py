# Diseñar una función que devuelva una lista invertida a partir de otra. Incluir un 
# programa que pruebe la función.


def invertir_lista(lista):
    lista_invertida = []  # Inicializar la lista vacía
    for i in range(len(lista) - 1, -1, -1):  # Iterar desde el final hasta el principio
        lista_invertida.append(lista[i])  # Agregar elementos en orden inverso
    return lista_invertida  # Retornar la lista invertida

if __name__ == "__main__":
    entrada = input("Ingrese los elementos de la lista separados por espacios: ")
    lista_original = entrada.split()
    
    lista_invertida = invertir_lista(lista_original)
    
    print("Lista original:", lista_original)
    print("Lista invertida:", lista_invertida)