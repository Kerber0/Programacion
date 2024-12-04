# Escribir una función que reciba una tupla de elementos e indique si es capicúa o no.


def capicua(tupla: tuple) -> bool:
    try:
        if not isinstance(tupla, tuple):
            raise TypeError
        return tupla == tupla[::-1]
    except TypeError:
        print("Error: esta función solo admite tuplas")
        return None


def capicua_v2(tupla: tuple) -> bool:
    try:
        if not isinstance(tupla, tuple):
            raise TypeError
        for i in range(len(tupla)//2):
            if tupla[i] != tupla[-i-1]:
                return False
        return True
    except TypeError:
        print("Error: esta función solo admite tuplas")
        return None

# Pruebas


print(capicua((1, 2, 3, 2, 1)))  # True
print(capicua((1, 2, 3, 4, 5)))  # False
print(capicua(1234))  # None # Error
print(capicua([1, 2, 3, 2, 1]))  # None # Error

print(capicua_v2((1, 2, 3, 2, 1)))  # True
print(capicua_v2((1, 2, 3, 4, 5)))  # False
print(capicua_v2(1234))  # None # Error
print(capicua_v2([1, 2, 3, 2, 1]))  # None # Error
