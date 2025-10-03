# Diseñar una función que decida si dos números enteros positivos son amigos. Dos números 
# amigos si la suma de los divisores propios de uno es igual al otro número y viceversa. 
# Por ejemplo, los divisores propios de 220 son 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 y 110, que suman 284. 
# Los divisores propios de 284 son 1, 2, 4, 71 y 142, que suman 220. Incluir el algoritmo 
# principal que realice la llamada a dicha función.

def amigos(a : int, b : int) -> bool:

    if a < 0 or b < 0:
        print("Los números deben ser positivos")
        return None
    divisores_a = 0
    divisores_b = 0
    for i in range(1,a):
        if a % i == 0:
            divisores_a += i
    for j in range(1,b):
        if b % j == 0:
            divisores_b += j

    if divisores_a == b and divisores_b == a:
        return True
    else:
        return False


print(amigos(220, 284))  # True, son números amigos
print(amigos(1184, 1210))  # True, son números amigos
print(amigos(10, 20))  # False, no son números amigos
