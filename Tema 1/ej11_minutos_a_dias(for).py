#Diseñar un algoritmo que lea del teclado un número entero correspondiente 
# a una cantidad de minutos y nos diga cuántos días, horas y minutos son.
#Por ejemplo, si introducimos 1000 minutos, el algoritmo mostrará por 
# pantalla que son 0 días, 16 horas y 40 minutos.

minutos = input("Introduce los minutos: ")

if minutos.isdigit(): #isdigit es para definir minutos como digitos numerales
    minutos = int(minutos)
    horas = minutos // 60
    minutos = minutos % 60
    dias = horas // 24 
    dias = horas % 24
    print(f"{dias}dias, {horas}horas y {minutos}minutos")
else:
    print("Por favor, introrduce un número entero")

