import random
#def tecla():
global numeros_salidos, menu, numero
numeros_salidos = []
menu = "n"
numero = ""


def sorteo():
    numero = random.randint(1, 99)
    if numero not in numeros_salidos:
        numeros_salidos.append(numero)
        print(numero)
        juego()
    else:
        sorteo()


def comprobar_linea():
    carton_linea = []
    contador_linea = False
    contador = 0
    numero_carton = 0
    contador_numeros = 0
    print([numeros_salidos])    
    print("Vamos a comprobar la linea  ")
    print("Introduce los 5 números de la LINEA de 1 en 1, para comprobar")
    while contador_linea == False:                                          # comprueba que no se haya cantado linea
        while len(carton_linea) != 5:                                       # comprueba que la longitud de numeros del carton sea correcta y pide números hasta que lo sea       
            numero_carton = int(input(f"numero {contador_numeros+1} de 5: "))# pide un número del carton indicando cual es
            while numero_carton < 1 or numero_carton > 99:                  # comprueba que el número esté dentro del rango correcto
                print("Número incorrecto, introduce un número correcto ")   # muestra este mensaje si no está dentro del rango
                numero_carton = int(input(f"numero {contador_numeros+1} de 5: "))# y vuelve a pedir el número
            carton_linea.append(numero_carton)                              # añade el número a una lista del carton
            contador_numeros += 1                                           # sube 1 al contador, para que solo guarde 5 números
        for j in range(5):   
            if carton_linea[j] in numeros_salidos[:]:                       # comprueba que los números del carton que canto la linea este dentro de los del sorteo
                contador += 1                                               # suma 1 a un contador cuando el número está en la lista
        if contador == 5:                                                   # si los cinco números son correctos
            print("La linea es correcta, continua para bingo")              # indica que has ganado
            contador_linea = True                                           # cambia el valor del contador de lineas para que no se pueda cantar otra linea
            juego()                                                         # vuelve funcion juego para seguir jugando para bingo
        else:
            print("La linea es incorrecta, continua para Linea")            # si la linea no es correcta lo indica y sigue para jugar y poder cantar la linea correcta
            juego()
    print("Ya se ha cantado linea, siga para bingo")                        # corresponde al primer while, muestra mensaje si ya se habia cantado linea y vuelve al juego
    juego()        


def comprobar_bingo():
    carton_bingo = []
    contador = 0    
    numero_carton = 0
    contador_numeros = 0
    print([numeros_salidos])    
    print("Vamos a comprobar la linea  ")
    print("Introduce los 15 números del BINGO de 1 en 1, para comprobar")
    while len(carton_bingo) != 15:                                      # comprueba que la longitud de numeros del carton sea correcta y pide números hasta que lo sea
        numero_carton = int(input(f"numero {contador_numeros+1} de 15: "))# pide un número del carton indicando cual es
        while numero_carton < 1 or numero_carton > 99:                  # comprueba que el número esté dentro del rango correcto
            print("Número incorrecto, introduce un número correcto ")   # muestra este mensaje si no está dentro del rango
            numero_carton = int(input(f"numero {contador_numeros+1} de 15: "))# y vuelve a pedir el número
        carton_bingo.append(numero_carton)                              # añade el número a una lista del carton
        contador_numeros += 1                                           # sube 1 al contador, para que solo guarde 5 números
    for j in range(15):                                                  
        if carton_bingo[j] in numeros_salidos[:]:                       # comprueba que los números del carton que canto la linea este dentro de los del sorteo
            contador += 1                                               # suma 1 a un contador cuando el número está en la lista
    if contador == 15:                                                  # si los quince números son correctos
        print("Has ganado el bingo")
        return                            
    else:
        print("Se ha cantado un bingo erroneo, seguimos con el juego")
        juego()


def juego():
    menu = input("Pulsa intro para sacar NÚMERO, L para linea o B para bingo ").lower()    
    match menu:
        case "l":
            comprobar_linea()
        case "b":
            comprobar_bingo()
            return True
        case _:
            sorteo()


if __name__ == "__main__":
    while not juego():
        print("El juego esta finalizado")
        break

  