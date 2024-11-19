#Diseñar un algoritmo que pida una nota (valor entero) por teclado y dependiendo de su valor visualice la nota en letras. 
#Por ejemplo, si nota es igual a 7 tiene que mostrar el texto "Notable".

# Solucion 1

print("Introduzca la nota (0-10 valores enteros): ") # Pedimos la nota  
nota = int(input()) # Leemos la nota
if nota >= 0 and nota < 5: # Comprobamos si la nota es insuficiente
    print("Insuficiente") # Mostramos un mensaje
if nota >= 5 and nota < 6:
    print("Suficiente")
if nota >= 6 and nota < 7:
    print("Bien")
if nota >= 7 and nota < 9:
    print("Notable")
if nota >= 9 and nota <= 10:
    print("Sobresaliente")
if nota < 0 or nota > 10:
    print("Nota no válida")
print("Fin de programa")


#Solucion 2

print("Introduzca la nota (0-10 valores enteros): ") 
nota = int(input()) # Leemos la nota
match nota: # Comprobamos la nota
    case 0 | 1 | 2 | 3 | 4: # Si la nota es menor que 5
        print("Insuficiente") # Mostramos un mensaje
    case 5: 
        print("Suficiente")
    case 6:
        print("Bien")
    case 7 | 8:
        print("Notable")
    case 9 | 10:
        print("Sobresaliente")
    case _:
        print("Nota no válida")
print("fin de programa")

# Solucion 3

print("Introduzca la nota (0-10 valores enteros): ") # Pedimos la nota  
nota = int(input()) # Leemos la nota
if nota < 0 or nota > 10: # Comprobamos si la nota es válida
    print("Nota no válida") # Mostramos un mensaje de error
else: # Si la nota es válida
    if nota < 5: # Comprobamos si la nota es insuficiente
        print("Insuficiente") # Mostramos un mensaje
    elif nota == 5: # Comprobamos si la nota es suficiente
        print("Suficiente") # Mostramos un mensaje
    elif nota == 6:
        print("Bien")
    elif nota < 9:
        print("Notable")
    else:
        print("Sobresaliente")
print("Fin de programa")