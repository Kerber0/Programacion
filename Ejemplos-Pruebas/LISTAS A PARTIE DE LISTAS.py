# Escriba un programa que permita crear dos listas de palabras y que,
#  a continuación, escriba las siguientes listas (en las que no debe
#  haber repeticiones):

# Lista de palabras que aparecen en las dos listas.
# Lista de palabras que aparecen en la primera lista, pero no en la segunda.
# Lista de palabras que aparecen en la segunda lista, pero no en la primera.
# Lista de palabras que aparecen en ambas listas.
# Nota: Para evitar las repeticiones, el programa deberá empezar eliminando
#  los elementos repetidos en cada lista.

# Dígame cuántas palabras tiene la primera lista: 4
# Dígame la palabra 1: Carmen
# Dígame la palabra 2: Alberto
# Dígame la palabra 3: Benito
# Dígame la palabra 4: Carmen
# La primera lista es: ['Carmen', 'Alberto', 'Benito', 'Carmen']
# Dígame cuántas palabras tiene la segunda lista: 3
# Dígame la palabra 1: Benito
# Dígame la palabra 2: Juan
# Dígame la palabra 3: Carmen
# La segunda lista es: ['Benito', 'Juan', 'Carmen']
# Palabras que aparecen en las dos listas: ['Carmen', 'Benito']
# Palabras que sólo aparecen en la primera lista: ['Alberto']
# Palabras que sólo aparecen en la segunda lista: ['Juan']
# Todas las palabras: ['Carmen', 'Benito', 'Alberto', 'Juan']


def crear_lista_palabras(num_palabras, lista_num):
    lista = []
    for i in range(1, num_palabras + 1):
        palabra = input(f"Dígame la palabra {i} para la lista {lista_num}: ")
        lista.append(palabra)
    return lista

def procesar_listas():
    # Crear la primera lista
    num_palabras1 = int(input("Dígame cuántas palabras tiene la primera lista: "))
    lista1 = crear_lista_palabras(num_palabras1, 1)
    lista1 = list(set(lista1))  # Eliminar duplicados en la primera lista
    print("La primera lista es:", lista1)

    # Crear la segunda lista
    num_palabras2 = int(input("Dígame cuántas palabras tiene la segunda lista: "))
    lista2 = crear_lista_palabras(num_palabras2, 2)
    lista2 = list(set(lista2))  # Eliminar duplicados en la segunda lista
    print("La segunda lista es:", lista2)

    # Calcular las listas solicitadas
    en_ambas = list(set(lista1) & set(lista2))  # Palabras en ambas listas
    solo_en_primera = list(set(lista1) - set(lista2))  # Solo en la primera lista
    solo_en_segunda = list(set(lista2) - set(lista1))  # Solo en la segunda lista
    todas = list(set(lista1) | set(lista2))  # Todas las palabras

    # Mostrar los resultados
    print("Palabras que aparecen en las dos listas:", en_ambas)
    print("Palabras que sólo aparecen en la primera lista:", solo_en_primera)
    print("Palabras que sólo aparecen en la segunda lista:", solo_en_segunda)
    print("Todas las palabras:", todas)

# Llamar a la función
procesar_listas()
