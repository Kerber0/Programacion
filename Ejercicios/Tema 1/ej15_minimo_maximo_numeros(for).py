# Diseñar un algoritmo que lea una secuencia de 20 números reales introducidos por teclado.
# Al acabar la secuencia, debe mostrar el valor máximo y mínimo introdcidos.
x = 0
maximo = None  # "None" es una función solo de python, en otros lenguajes no funcionaria
minimo = None
for x in range(20):
    # n = float(input("Ingrese numeros reales:", str(x+1), "/20:"))
    n = input(f"Ingrese numeros reales: {x}/20: ")
    if maximo is None or maximo < n:
        maximo = n
    if minimo is None or minimo > n:
        minimo = n

print("el numero máximo es", maximo, "y el mínimo", minimo)

############################################################################

max = float(input("intrudzca un número: "))
min = max
for i in range(19):  # son 19 vueltas por que la primera ya se hace al asignarle el primer valor a min y max
    num = float(input("Introduzca el siguiente número: "))
    if num > max:
        max = num
    elif num < min:
        min = num
