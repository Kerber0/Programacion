"""Una vez realizada esta función, se debe crear otra que reciba un número entero como parámetro.
La función debe crear 3 conjuntos con tantas letras aleatorias como el número introducido.
La función debe imprimir por pantalla los 3 conjuntos y también debe imprimir mensajes indicando lo siguiente:
- Las letras comunes entre los 3 conjuntos.
- Las letras que están en el primer conjunto pero no en los otros dos.
- Las letras que están en el segundo conjunto pero no en los otros dos.
- Las letras que están en el tercer conjunto pero no en los otros dos.

Nota: En caso de que el número introducido no sea positivo, se debe imprimir un mensaje de error."""

import random
def letra_aleatoria() -> str:
    return chr(random.randint(65, 90))


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
  

    print(con1, con2, con3, "Las letras comunes son: ", letrascomunes, "Las letras del Conjunto 1 son: ", letrascon1 )
    
print("Ejercicio 2 - Conjuntos")
print(generar_letras_conjunto(5)) # Conjunto con 5 letras aleatorias
print(generar_letras_conjunto(-5)) # Conjunto vacío
comparar_conjuntos(5) # Imprime los conjuntos y las letras comunes y diferentes
comparar_conjuntos(-5) # Imprime un mensaje de error
print("-"*20)
     
