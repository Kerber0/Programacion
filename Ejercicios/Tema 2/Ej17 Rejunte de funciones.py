# Diseñar varias funciones para cumplir con los siguientes requisitos:

# 1  Función que lea una serie de números enteros positivos desde teclado y los almacene en una lista.
# 2  Función que reciba una lista de enteros y devuelva la suma de los elementos.
# 3  Función que reciba una lista de enteros y devuelva el mayor.
# 4  Función que reciba una lista de enteros y devuelva el menor.
# 5  Función que reciba una lista de enteros y devuelva la media.  #####
# 6  Función que reciba una lista de enteros y devuelva la mediana.
# 7  Función que reciba una lista de enteros y devuelva la varianza.
# 8  Función que reciba una lista de enteros y devuelva la desviación típica.
# 9  función que reciba una lista de enteros y devuelva si es simétrica o no.
# 10 Función que reciba una lista de enteros y devuelva si cada elemento es un número primo o no.
# 11 Función que reciba una lista de enteros y devuelva si cada elemento es un número capicúa o no.
# Incluir un programa que pruebe todas las funciones.


def agregar_a_lista():
    global lista
    lista = []
    while True:
        n = int(input(
            "Ingrese números enteros positivos para agregar a la lista y 0 para terminar: "))
        if n > 0:
            lista.append(n)
        elif n == 0:
            print("Se terminaron de agregar los números, esta es su lista: ", lista)
            break
        else:
            n = int(input("El número ingresado no es válido, pruebe otro: "))
    return lista


def suma_lista(lista):
    suma = 0
    for i in lista:
        suma += i
    print("El resultado de la suma de su lista es: ", suma)
    return suma


def mayor_lista(lista):
    mayor = lista[0]
    for i in lista:
        if i > mayor:
            mayor = i
    return mayor


def menor_lista(lista):
    menor = lista[0]
    for i in lista:
        if i < menor:
            menor = i
    return menor


def media_lista(lista):
    media = suma_lista(lista)/len(lista)
    return media


if __name__ == "__main__":
    agregar_a_lista()
    suma_lista(lista)
