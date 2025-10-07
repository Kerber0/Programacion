"""
Escucha esta historia: Un niño y su padre, un programador de computadoras, juegan 
con bloques de madera. Están construyendo una pirámide.

Su pirámide es un poco rara, ya que en realidad es una pared en forma de pirámide, es plana.
 La pirámide se apila de acuerdo con un principio simple: cada capa inferior contiene un 
bloque más que la capa superior.


La figura ilustra la regla utilizada por los constructores:



Tu tarea es escribir un programa que lea la cantidad de bloques que tienen los constructores, 
y generar la altura de la pirámide que se puede construir utilizando estos bloques.

Nota: La altura se mide por el número de capas completas: si los constructores no tienen 
la cantidad suficiente de bloques y no pueden completar la siguiente capa, terminan 
su trabajo inmediatamente.

Prueba tu código con los datos que hemos proporcionado.


Datos de Prueba

Entrada de muestra: 6

Salida esperada: La altura de la pirámide es: 3

Entrada de muestra: 20

Salida esperada: La altura de la pirámide es: 5

Entrada de muestra: 1000

Salida esperada: La altura de la pirámide es: 44

Entrada de muestra: 2

Salida esperada: La altura de la pirámide es: 1
"""

def calcular_altura_y_dibujar_piramide(bloques):
    altura = 0
    bloques_necesarios = 1  # Bloques necesarios para la primera capa
    piramide = []  # Lista para almacenar cada capa de la pirámide
    
    # Calcular la altura y construir las capas
    while bloques >= bloques_necesarios:
        bloques -= bloques_necesarios  # Usamos los bloques para esta capa
        altura += 1  # Aumentamos la altura en una capa
        
        # Crear la capa actual con asteriscos
        capa = '*' * bloques_necesarios
        piramide.append(capa)  # Agregar la capa a la lista de la pirámide
        
        # Aumentar la cantidad de bloques necesarios para la siguiente capa
        bloques_necesarios += 1

    # Mostrar la altura de la pirámide
    print(f"La altura de la pirámide es: {altura}")
    
    # Dibujar la pirámide centrada
    ancho_piramide = len(piramide[-1]) if piramide else 0
    for capa in piramide:
        print(capa.center(ancho_piramide))

# Pruebas con los datos proporcionados
bloques = int(input("Ingrese la cantidad de bloques: "))
calcular_altura_y_dibujar_piramide(bloques)