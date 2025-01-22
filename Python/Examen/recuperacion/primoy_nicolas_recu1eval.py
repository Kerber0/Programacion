# A continuación veréis una serie de enunciados repartidos en bloques por temas.
"""
 Cada bloque contiene entre 2 y 4 ejercicios, cada alumno debe resolver tantos ejercicios de cada 
 bloque según los temas que tenga pendientes siguiendo el siguiente criterio:
 
 - Si tiene suspenso un solo tema, debe resolver TODOS los ejercicios del bloque correspondiente al tema suspenso.
 - Si tiene suspenso el tema 1 y el tema 3, debe resolver dos ejercicios del bloque 1 y dos ejercicios del bloque 3.
 - Si tiene suspenso el tema 1 y el tema 2, debe resolver dos ejercicios del bloque 1 y dos ejercicios del bloque 2.
 - Si tiene suspenso el tema 2 y el tema 3, debe resolver dos ejercicios del bloque 2 y dos ejercicios del bloque 3.
 - Si tiene suspensos los tres temas, debe resolver un ejercicio del bloque 1, otro del bloque 2 y dos del bloque 3.

 Nota: En los casos en los que no se deban resolver todos los ejercicios de un bloque, el alumno/a puede elegir cuáles hacer.
 Atención: En todos los casos deben resolverse 4 ejercicios en total. Para aprobar cada tema, es necesario, 
 al menos, resolver correctamente la mitad de los ejercicios de ese tema. 

 La nota de recuperación de los temas será la nota del examen de recuperación, esta se calculará de forma que cada 
 ejercicio resuelto vale 2.5 puntos.

 Al terminar el examen, el alumno deberá subir el archivo a la plataforma Moodle con el siguiente nombre:
    apellido_nombre_recu1eval.py

    Ejemplo:
    si el alumno se llama Juan Pérez García, el nombre del archivo será:
    perez_garcia_juan_recu1eval.py

    En caso de no seguir este formato, se restarán 10 puntos de la nota final.

A la hora de entregar el examen se deben seguir las siguientes indicaciones:
 - Se deben borrar TODOS los ejercicios que no se hayan resuelto. Tanto el código como el enunciado.
 - De los ejercicios resueltos NO SE PUEDE BORRAR el enunciado ni el código proporcionado.
    - El código proporcionado en los ejercicios NO SE PUEDE MODIFICAR.
"""

# Bloque 1 (Tema 1):

# Bloque 2 (Tema 2):

# Ejercicio 1:
"""Diseñar una función que reciba un número entero como parámetro y devuelva si este número es primo o no lo es.
Una vez realizada esta función, crea otra que reciba un número entero como parámetro e imprima por pantalla lo siguiente:
- La suma de los números primos menores que el número recibido (sin incluirlo).
- La cantidad de números primos menores que el número recibido (sin incluirlo).
- La media de los números primos menores que el número recibido (sin incluirlo).

Nota: En caso de que el número recibido en la segunda función sea menor o igual a 2, se debe imprimir un mensaje de error.
"""




import random

def es_primo(numero: int) -> bool:  # TIRA EL MENSAJE DE ERROR DE SER MENOR DE 2 PERO AUN ASI ME LANZA UN ERROR
    if numero <= 2:
        return False
    for i in range(2, int(numero**0.5) + 1):
        if numero % i == 0:
            return False
    return True


def datos_primos(numero: int):
    primos = 0
    contador = 0
    if numero <= 2:
        print("Error! Número no válido, debe ser mayor que 2")

    else:

        for i in range(numero):
            if es_primo(i):
                primos += i
                contador += 1
            else:
                continue
    return print("Suma: ", primos, "Cantidad: ", contador, "Media: ", (primos/contador))


print("Ejercicio 1 - Números primos")
print(es_primo(7))  # True
print(es_primo(10))  # False
datos_primos(10)  # Suma: 17, Cantidad: 4, Media: 4.5
datos_primos(20)  # Suma: 77, Cantidad: 8, Media: 9.625
datos_primos(2)  # Número no válido
print("-"*20)


# Ejercicio 4:
"""
Realizar una función que reciba una lista de números enteros positivos y la devuelva ordenada de mayor a menor.

La función TIENE QUE RESOLVERSE DE FORMA RECURSIVA.

Nota: No se puede utilizar el método sort() de las listas.
"""


def ordenar(lista: list) -> list:
    if len(lista) <= 1:
        return (lista)

    maximo = max(lista)
    lista.remove(maximo)

    return [maximo] + ordenar(lista)


print("Ejercicio 4 - Ordenar lista")
print(ordenar([3, 1, 5, 2, 4]))  # [5, 4, 3, 2, 1]
print(ordenar([10, 20, 30, 40, 50]))  # [50, 40, 30, 20, 10]
print(ordenar([1, 2, 3, 4, 5]))  # [5, 4, 3, 2, 1]
print("-"*20)

# Bloque 3 (Tema 3):

# Esta es una función auxiliar para los siguientes ejercicios, la función genera una letra mayúscula aleatoria de entre las 26 letras del abecedario.


def letra_aleatoria() -> str:
    return chr(random.randint(65, 90))

# En todos los ejercicios de este bloque debe hacerse captura de excepciones.


# Ejercicio 2:
"""
Diseñar una función que reciba un número entero y devuelva un conjunto con tantas letras aleatorias como el número introducido.

Nota: En caso de que el número introducido no sea positivo, se debe devolver un conjunto vacío.
Además, se debe tener en cuenta que el número de letras aleatorias puede ser menor que el número introducido, debido a la repetición de letras.

Una vez realizada esta función, se debe crear otra que reciba un número entero como parámetro.
La función debe crear 3 conjuntos con tantas letras aleatorias como el número introducido.
La función debe imprimir por pantalla los 3 conjuntos y también debe imprimir mensajes indicando lo siguiente:
- Las letras comunes entre los 3 conjuntos.
- Las letras que están en el primer conjunto pero no en los otros dos.
- Las letras que están en el segundo conjunto pero no en los otros dos.
- Las letras que están en el tercer conjunto pero no en los otros dos.

Nota: En caso de que el número introducido no sea positivo, se debe imprimir un mensaje de error.
"""


def generar_letras_conjunto(num: int) -> set:
    lista = []
    try:
        if num <= 0:
            return ()
        else:
            for _ in range(num):
                lista += (letra_aleatoria())
        return set(lista)
    except TypeError:
        print("Error! Solo se pueden introducir números")


def comparar_conjuntos(num: int):
    con1 = generar_letras_conjunto(num)
    con2 = generar_letras_conjunto(num)
    con3 = generar_letras_conjunto(num)

    letrascomunes = con1.union(con2.union(con3))
    letrascon = con1.difference(con2)
    letrascon1 = letrascon.difference(con3)

    print(con1, con2, con3, "Las letras comunes son: ", letrascomunes,
          "Las letras del Conjunto 1 son: ", letrascon1)


print("Ejercicio 2 - Conjuntos")
print(generar_letras_conjunto(5))  # Conjunto con 5 letras aleatorias
print(generar_letras_conjunto(-5))  # Conjunto vacío
# Imprime los conjuntos y las letras comunes y diferentes
comparar_conjuntos(5)
comparar_conjuntos(-5)  # Imprime un mensaje de error
print("-"*20)

# Ejercicio 3:
"""
Diseñar una función para leer los datos de un piso para registrar en una inmobiliaria.
La función debe pedir al usuario los siguientes datos:
- Número de habitaciones. Debe ser un número entero positivo o 0.
- Número de metros cuadrados. Debe ser un número entero positivo y mayor a 20.
- Precio del piso. Debe ser un número flotante positivo y mayor a 30000.
- Ascensor (True o False). 
- Trastero (True o False).
- Garaje (True o False).

Una vez recogidos los datos, la función debe devolver un diccionario con los datos del piso.

Nota: Los datos deben pedirse al usuario hasta que sean correctos.
Si el número de habitaciones es 0, el piso se considera un estudio y no puede tener ascensor, trastero ni garaje, 
por lo que estos datos deben ser False y no se deben pedir al usuario.    

Realizar la captura de excepciones necesaria para que el programa no termine de forma abrupta en caso de que el usuario introduzca datos incorrectos.
"""


def registrar_piso():
    pass


print("Ejercicio 3 - Piso")
print(registrar_piso())  # Diccionario con los datos del piso
print("-"*20)

# Ejercicio 4:
