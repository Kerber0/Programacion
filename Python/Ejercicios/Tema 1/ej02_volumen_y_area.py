# Diseñar un algoritmo que calcule y
# muestre en pantalla el volumen y el área de una esfera para un radio dado

print("Radio de volumen a calcular:")
radio = float(input())
PI = 3.141592
volumen = (4/3)*PI*(radio**3)
print("El volumen de una Esfera con radio", radio, "es", int(volumen))
area = 4*PI*(radio**2)
print("Y esta es el Area de esa misma Esfera", int(area))
print("Fin de programa")
