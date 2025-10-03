
# Escriba un programa que permita crear una lista de palabras. 
# Para ello, el programa tiene que pedir un número y luego solicitar 
# ese número de palabras para crear la lista. Por último, el programa 
# tiene que escribir la lista.

# Dígame cuántas palabras tiene la lista: 3
# Dígame la palabra 1: Alberto
# Dígame la palabra 2: Benito
# Dígame la palabra 3: Carmen
# La lista creada es: ['Alberto', 'Benito', 'Carmen']
# Dígame cuántas palabras tiene la lista: 0
# ¡Imposible!

def crear_lista_palabras():
    # Pedir al usuario el número de palabras que desea ingresar
    num_palabras = int(input("Dígame cuántas palabras tiene la lista: "))
    
    # Verificar si el número de palabras es válido
    if num_palabras <= 0:
        print("¡Imposible!")
    else:
        global lista_palabras
        lista_palabras = []
        
        
        # Pedir las palabras y agregarlas a la lista
        for i in range(1, num_palabras + 1):
            palabra = input(f"Dígame la palabra {i}: ")
            lista_palabras.append(palabra)
        
        # Mostrar la lista creada
        print("La lista creada es:", lista_palabras)

lista_ordenada = sorted(lista_palabras)
      


# Llamar a la función
crear_lista_palabras()