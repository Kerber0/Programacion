# Control de excepciones.

# 1.

def division(a: float, b: float) -> float:
    try:
        if not isinstance(a, (int, float)) or not isinstance(b, (int, float)):
            raise TypeError
        return round(a / b, 2)
    except ZeroDivisionError:
        print("No se puede dividir por 0.")
        return None
    except TypeError:
        print("Los argumentos deben ser numeros")
        return None
    except:
        print("Error desconocido")
        return None


print(division(3, 2))
print(division(4, 0))
print(division("Hola", 3))
print(division(3.2, 4.3))

print("-"*80)

# 2.


def media(lista: list) -> float:
    try:
        if not isinstance(lista, list):
            raise ValueError("El argumento debe ser una lista")
        if len(lista) == 0:
            raise ZeroDivisionError
        if not all(isinstance(i, (int, float)) for i in lista):
            raise TypeError
        return round(sum(lista)/len(lista), 2)
    except ZeroDivisionError:
        print("Error: La lista no puede estar vacia")
        return None
    except TypeError:
        print("Error: los valores deben ser numeros")
        return None
    except ValueError as e:
        print(e)
        return None
    except:
        print("Error inesperado")
        return None


print(media((5, 2, 3, 4, 5)))
print(media([5, 3, 2, 3, 2]))
print(media([]))
print(media({3: 2, 4: 3, 7: 1}))
print(media({3: 2, 4: 3, 3: "Hola"}))
print(media(["hola", 5, 2]))
print(media([2, 3, 5.5]))

print("-"*80)

# 3.


def cadena_repetida(cadena: str, n: int) -> str:
    try:
        if not isinstance(cadena, str):
            raise ValueError("Error: el argumento debe ser una cadena")
        if len(cadena) == 0:
            raise ValueError("Error: el argumento no puede estar vacio")
        if not isinstance(n, int) or n <= 0:
            raise TypeError
        return cadena * n
    except ValueError as e:
        print(e)
        return ""
    except TypeError:
        print("Error: n debe ser un número positivo")
        return ""
    except:
        print("Error inesperado")
        return ""


print(cadena_repetida("", 3))
print(cadena_repetida("Hola que tal", 3))
print(cadena_repetida(3, 3))
print(cadena_repetida(3, "Hola"))

print("-"*80)

# 4.


def cuadrados_numeros(lista: list) -> list:
    try:
        if not isinstance(lista, list):
            raise ValueError("Error: El argumento debe ser una lista")
        if len(lista) == 0:
            raise ValueError("Error: La lista no puede estar vacia")
        if not all(isinstance(palabra, (int, float)) for palabra in lista):
            raise TypeError("Error: Los valores de la lista deben ser numeros")
        return [round(palabra ** 2, 2) for palabra in lista]
    except ValueError as e:
        print(e)
        return []
    except TypeError as e:
        print(e)
        return []
    except:
        print("Error inesperado")
        return []


print(cuadrados_numeros([]))
print(cuadrados_numeros("hola"))
print(cuadrados_numeros({3: 2, "Hola": 3}))
print(cuadrados_numeros(["hola", 5, 4, 2]))
print(cuadrados_numeros([5, 3, 2, 5]))
print(cuadrados_numeros([5.2, 3, 2]))

print("-"*80)

# 5.


def buscar_elemento(tupla: tuple, posicion: int) -> int:
    try:
        if not isinstance(tupla, tuple):
            raise ValueError("Error: El argumento debe ser una tupla")
        if len(tupla) == 0:
            raise ValueError("Error: La tupla no puede estar vacia")
        if posicion >= len(tupla) or posicion < 0:
            raise IndexError("Error: La posicion está fuera de rango")
        return (tupla[posicion])
    except ValueError as e:
        print(e)
        return ()
    except IndexError as e:
        print(e)
        return ()
    except:
        print("Error desconocido")
        return None


print(buscar_elemento((1, 2, 5, 3), 2))
print(buscar_elemento([1, 2, 3], 2))
print(buscar_elemento((), 2))
print(buscar_elemento((1, 2, "Hola"), 5))
print(buscar_elemento((1, 2, "Hola"), 2))

print("-"*80)

# 6.


def buscar_valor_diccionario(dicc: dict, clave: any):
    try:
        if not isinstance(dicc, dict):
            raise ValueError("Error: El argumento debe ser un diccionario")
        if len(dicc) == 0:
            raise ValueError("Error el diccionario no puede estar vacio")
        if not clave in dicc:
            raise KeyError("Error: La clave no está en el diccionario")
        return dicc[clave]
    except ValueError as e:
        print(e)
        return {}
    except TypeError as e:
        print(e)
        return {}
    except KeyError as e:
        print(e)
        return {}
    except:
        print("Error desconocido")
        return {}


print(buscar_valor_diccionario({}, 2))
print(buscar_valor_diccionario({"Hola": 2, 3: 4}, 3))
print(buscar_valor_diccionario((1, 2), "Hola"))
print(buscar_valor_diccionario({"Si": "A", "No": "B"}, "B"))

print("-"*80)

# 7


def max_numero(lista: list) -> float:
    try:
        if not isinstance(lista, list):
            raise ValueError("Error: El argumento debe ser una lista")
        if len(lista) == 0:
            raise ValueError("Error: La lista no puede estar vacia")
        if not all(isinstance(i, (int, float)) for i in lista):
            raise TypeError("Error: Los valores deben de ser numeros")
        return max(lista)
    except ValueError as e:
        print(e)
        return []
    except TypeError as e:
        print(e)
        return []
    except:
        print("Error desconocido")
        return []


print(max_numero([1, 2, 3, 4, 5, 8, 2]))
print(max_numero([]))
print(max_numero({}))
print(max_numero([1, 2, "hola"]))

print("-"*80)

# Conjuntos.

# 1.


def elementos_comunes_conjuntos(conjunto1: set, conjunto2: set) -> set:
    try:
        if not isinstance(conjunto1, set) or not isinstance(conjunto2, set):
            raise ValueError("Error: Los argumentos deben de ser conjuntos")
        return conjunto1.intersection(conjunto2)
    except ValueError as e:
        print(e)
        return set()
    except:
        print("Error desconocido")
        return set()


print(elementos_comunes_conjuntos({1, 2, 3}, {3, 4, 1, 5}))
print(elementos_comunes_conjuntos({3}, {2, 3}))
print(elementos_comunes_conjuntos({1, 2}, [1, 3]))

print("-"*80)

# 2.


def elementos_primer_conjunto(conjunto1: set, conjunto2: set) -> set:
    try:
        if not isinstance(conjunto1, set) or not isinstance(conjunto2, set):
            raise ValueError("Error: Los argumentos deben de ser conjuntos")
        return conjunto1.difference(conjunto2)
    except ValueError as e:
        print(e)
        return set()
    except:
        print("Error desconocido")
        return set()


print(elementos_primer_conjunto({1, 2, 3}, {3, 4, 1, 5}))
print(elementos_primer_conjunto({3}, {2, 3}))
print(elementos_primer_conjunto({1, 2}, [1, 3]))

print("-"*80)

# 3.


def diferencia_simetrica(conjunto1: set, conjunto2: set) -> set:
    try:
        if not isinstance(conjunto1, set) or not isinstance(conjunto2, set):
            raise ValueError("Error: Los argumentos deben de ser conjuntos")
        return conjunto1.symmetric_difference(conjunto2)
    except ValueError as e:
        print(e)
        return set()
    except:
        print("Error desconocido")
        return set()


print(diferencia_simetrica({1, 2, 3}, {3, 4, 1, 5}))
print(diferencia_simetrica({3}, {2, 3}))
print(diferencia_simetrica({1, 2}, [1, 3]))

print("-"*80)

# 4.


def eliminar_repetidos(lista: list) -> list:
    try:
        if not isinstance(lista, list):
            raise ValueError("Error: El argumento debe de ser una lista")
        return list(set(lista))
    except ValueError as e:
        print(e)
        return []
    except:
        print("Error inesperado")
        return []


print(eliminar_repetidos({1, 3, 4, 5, 3, 2}))
print(eliminar_repetidos([1, 2, 3, 5, 2, 3, 4]))
print(eliminar_repetidos([]))

print("-"*80)

# 5.


def lista_palabras(lista: list, n: int) -> set:
    try:
        if not isinstance(lista, list):
            raise ValueError("Error: El argumento debe ser una lista")
        if n <= 0:
            raise ValueError("N debe ser mayor que 0")
        return set([palabra for palabra in lista if len(palabra) > n])
    except ValueError as e:
        print(e)
        return set()
    except:
        print("Error inesperado")
        return set()


print(lista_palabras(["hola", "yo", "tu", "aprobado"], 3))
print(lista_palabras({}, 3))
print(lista_palabras([], 1))

print("-"*80)

# 6.


def letras_comunes(palabra1: str, palabra2: str) -> set:
    try:
        if not isinstance(palabra1, str) or not isinstance(palabra2, str):
            raise ValueError(
                "Error: El argumento debe de ser una cadena de texto")
        conjunto1 = set(palabra1)
        conjunto2 = set(palabra2)
        return conjunto1.intersection(conjunto2)
    except ValueError as e:
        print(e)
        return set()
    except:
        print("Error desconocido")
        return set()


print(letras_comunes("hola", "lado"))
print(letras_comunes(3, "hola"))
print(letras_comunes("", ""))

print("-"*80)

# 7.


def lista_contenida(lista1: list, lista2: list) -> list:
    try:
        if not isinstance(lista1, list) or not isinstance(lista2, list):
            raise ValueError("Error: El argumento debe ser una lista")
        conjunto1 = set(lista1)
        conjunto2 = set(lista2)
        return conjunto1.issubset(conjunto2)
    except ValueError as e:
        print(e)
        return set()
    except:
        print("Error inesperado")
        return set()


print(lista_contenida([1, 2, 3, 8], [1, 2, 5, 6, 7, 3]))
print(lista_contenida([], []))
print(lista_contenida(["hola", 2, 3, 4], [1, 5, 6, "hola", 4, 3, 2]))
print(lista_contenida({"hola": 3, 4: 2}, [1, 2, 3]))

print("-"*80)

# Tuplas.

# 1.


def tupla_ordenada(tupla: tuple) -> bool:
    try:
        if not isinstance(tupla, tuple):
            raise ValueError("Error: El argumento debe de ser una tupla")
        if not all(isinstance(i, (int, float))for i in tupla):
            raise TypeError("Error: Los valores deben de ser números")
        if len(tupla) <= 1:
            return True
        lista = list(tupla)
        for i in range(len(lista)):
            for j in range(0, len(lista) - i - 1):
                if lista[j] > lista[j + 1]:
                    lista[j], lista[j + 1] = lista[j + 1], lista[j]
        tupla_ordenada = tuple(lista)
        return tupla == tupla_ordenada
    except ValueError as e:
        print(e)
        return ()
    except TypeError as e:
        print(e)
        return ()
    except:
        print("Error desconocido")
        return ()


print(tupla_ordenada((1, 2, 5, 7, 3)))
print(tupla_ordenada(()))
print(tupla_ordenada([]))
print(tupla_ordenada((1, 2, 3, 4, 5)))

print("-"*80)

# También se puede hacer con: tupla_ordenada = tuple(sorted(tupla))


def tupla_ordenada2(tupla: tuple) -> bool:
    try:
        if not isinstance(tupla, tuple):
            raise ValueError("Error: El argumento debe de ser una tupla")
        if not all(isinstance(i, (int, float))for i in tupla):
            raise TypeError("Error: Los valores deben de ser números")
        if len(tupla) <= 1:
            return True
        return tupla == tuple(sorted(tupla))
    except ValueError as e:
        print(e)
        return ()
    except TypeError as e:
        print(e)
        return ()
    except:
        print("Error desconocido")
        return ()


print(tupla_ordenada2((1, 2, 5, 7, 3)))
print(tupla_ordenada2(()))
print(tupla_ordenada2([]))
print(tupla_ordenada2((1, 2, 3, 4, 5)))

print("-"*80)

# 2.


def tupla_ordenada_reves(tupla: tuple) -> bool:
    try:
        if not isinstance(tupla, tuple):
            raise ValueError("Error: El argumento debe de ser una tupla")
        if not all(isinstance(i, (int, float)) for i in tupla):
            raise TypeError("Error: Los valores deben de ser números")
        if len(tupla) <= 1:
            return True
        lista = list(tupla)
        for i in range(len(lista)):
            for j in range(len(lista) - i - 1):
                if lista[j] < lista[j+1]:
                    lista[j], lista[j+1] = lista[j+1], lista[j]
        tupla_ordenada = tuple(lista)
        return tupla == tupla_ordenada
    except ValueError as e:
        print(e)
        return ()
    except TypeError as e:
        print(e)
        return ()
    except:
        print("Error inesperado")
        return ()


print(tupla_ordenada_reves((5, 4, 3, 2, 1)))
print(tupla_ordenada_reves(()))
print(tupla_ordenada_reves([]))
print(tupla_ordenada_reves((3, 4, 6, 2, 1)))

print("-"*80)

# También se puede hacer con: tupla(sorted(tupla, reverse=True))


def tupla_ordenada_reves2(tupla: tuple) -> bool:
    try:
        if not isinstance(tupla, tuple):
            raise ValueError("Error: El argumento debe de ser una tupla")
        if not all(isinstance(i, (int, float))for i in tupla):
            raise TypeError("Error: Los valores deben de ser números")
        if len(tupla) <= 1:
            return True
        return tupla == tuple(sorted(tupla, reverse=True))
    except ValueError as e:
        print(e)
        return ()
    except TypeError as e:
        print(e)
        return ()
    except:
        print("Error desconocido")
        return ()


print(tupla_ordenada_reves2((5, 4, 3, 2, 1)))
print(tupla_ordenada_reves2(()))
print(tupla_ordenada_reves2([]))
print(tupla_ordenada_reves2((1, 6, 2, 7, 8)))

print("-"*80)

# Más resumido ya que no hace falta ordenarla.


def tupla_ordenada(tupla: tuple) -> bool:
    try:
        # Verificar si el argumento es una tupla
        if not isinstance(tupla, tuple):
            raise ValueError("El argumento debe ser una tupla")

        # Verificar si todos los elementos son números (int o float)
        if not all(isinstance(i, (int, float)) for i in tupla):
            raise TypeError("Todos los elementos deben ser números")

        # Si la tupla tiene menos de dos elementos, se considera ordenada
        if len(tupla) <= 1:
            return True

        # Verificar si la tupla está ordenada de menor a mayor
        for i in range(len(tupla) - 1):
            if tupla[i] > tupla[i + 1]:  # Si un elemento es mayor que el siguiente, no está ordenada
                return False

        # Si no encontramos ningún problema, significa que está ordenada
        return True

    except ValueError as e:
        print(e)
        return ()
    except TypeError as e:
        print(e)
        return ()
    except Exception as e:
        print("Error inesperado:", e)
        return ()


# Ejemplos de uso
print(tupla_ordenada((1, 2, 3, 4, 5)))  # True, está ordenada
print(tupla_ordenada((5, 3, 2, 4, 1)))  # False, no está ordenada
# True, todos son iguales, lo que también se considera ordenado
print(tupla_ordenada((1, 1, 1, 1)))
# True, una tupla vacía se considera ordenada
print(tupla_ordenada(()))
print(tupla_ordenada([1, 2, 3]))        # False, no es una tupla

print("-"*80)

# 3.


def elementos_distintos(tupla: tuple) -> bool:
    try:
        if not isinstance(tupla, tuple):
            raise ValueError("Error: El argumento debe ser una tupla")
        if len(tupla) <= 1:
            return True
        for i in range(len(tupla) - 1):
            if tupla[i] == tupla[i+1]:
                return False
        return True
    except ValueError as e:
        print(e)
        return ()
    except:
        print("Error inesperado")
        return ()


print(elementos_distintos(("hola", "hola")))
print(elementos_distintos(()))
print(elementos_distintos([]))
print(elementos_distintos((1, 2, 3)))
print(elementos_distintos((1, 1, 1)))

print("-"*80)

# 4.


def elementos_capicua(tupla: tuple) -> bool:
    try:
        if not isinstance(tupla, tuple):
            raise ValueError("Error: El argumento debe de ser una tupla")
        if len(tupla) <= 1:
            return True
        if tupla != tupla[::-1]:
            return False
        return True
    except ValueError as e:
        print(e)
        return ()
    except:
        print("Error inesperado")
        return ()


print(elementos_capicua(("o", "s", "o")))
print(elementos_capicua(()))
print(elementos_capicua([]))
print(elementos_capicua(("o", "s", "i", "t", "o")))
print(elementos_capicua((1, 2, 1)))

print("-"*80)

# 5.


def multiplos(tupla: tuple, n: int) -> list:
    try:
        if not isinstance(tupla, tuple):
            raise ValueError("Error: El argumento debe de ser una tupla")
        if n <= 0:
            raise TypeError("Error: n debe de ser un numero entero positivo")
        return [numero for numero in tupla if numero % n == 0]
    except ValueError as e:
        print(e)
        return []
    except TypeError as e:
        print(e)
        return []
    except:
        print("Error inesperado")
        return []


print(multiplos((), 3))
print(multiplos((3, 6, 9), 3))
print(multiplos((4, 8, 15, 3, 7), 2))
print(multiplos([], 1))

print("-"*80)

# Ejercicio Recursivo.


def suma_lista(lista: list) -> list:
    try:
        if not isinstance(lista, list):
            raise ValueError("Error: El argumento debe de ser una lista")
        if not all(isinstance(i, (int, float)) for i in lista):
            raise TypeError("Error: Los valores deben ser números")
        if len(lista) == 0:
            return 0
        return lista[0] + suma_lista(lista[1:])
    except ValueError as e:
        print(e)
        return []
    except TypeError as e:
        print(e)
        return []
    except:
        print("Error inesperado")
        return []


print(suma_lista([1, 2, 3]))
print(suma_lista(["Hola", "oso"]))
print(suma_lista([]))
print(suma_lista((1, 2, 3)))

print("-"*80)

# 6.


def max_min(tupla: tuple) -> tuple:
    try:
        if not isinstance(tupla, tuple):
            raise ValueError("Error: El argumento debe de ser una tupla")
        if not all(isinstance(i, (int, float)) for i in tupla):
            raise TypeError("Error: Los valores deben de ser numeros")
        if len(tupla) == 0:
            raise ValueError("Error: La tupla no puede estar vacia")
        return max(tupla), min(tupla)
    except ValueError as e:
        print(e)
        return ()
    except TypeError as e:
        print(e)
        return ()
    except:
        print("Error inesperado")
        return ()


print(max_min((1, 2, 3, 5, 7, 2)))
print(max_min(()))
print(max_min(("hola", "oso")))
print(max_min([]))

print("-"*80)

# 7.


def media(tupla: tuple) -> tuple:
    try:
        if not isinstance(tupla, tuple):
            raise ValueError("Error: El argumento debe de ser una tupla")
        if not all(isinstance(i, (int, float)) for i in tupla):
            raise TypeError("Error: Los valores deben de ser numeros")
        if len(tupla) == 0:
            raise ValueError("Error: La tupla no puede estar vacia")
        media = sum(tupla) / len(tupla)
        varianza = sum((x - media) ** 2 for x in tupla) / len(tupla)
        return round(media, 2), round(varianza, 2)
    except ValueError as e:
        print(e)
        return ()
    except TypeError as e:
        print(e)
        return ()
    except:
        print("Error inesperado")
        return ()


print(media((1, 2, 3, 5, 7, 2)))
print(media(()))
print(media(("hola", "oso")))
print(media([]))

print("-"*80)

# 8.


def ordenaditos(tupla: tuple) -> tuple:
    try:
        if not isinstance(tupla, tuple):
            raise ValueError("Error: El argumento debe de ser una tupla")
        if not all(isinstance(i, (int, float)) for i in tupla):
            raise TypeError("Error: Los valores deben de ser numeros")
        if len(tupla) == 0:
            raise ValueError("Error: La tupla no puede estar vacia")
        tupla_ordenada = tuple(sorted(tupla))
        return tupla_ordenada
    except ValueError as e:
        print(e)
        return ()
    except TypeError as e:
        print(e)
        return ()
    except:
        print("Error inesperado")
        return ()


print(ordenaditos((1, 2, 3, 5, 7, 2)))
print(ordenaditos(()))
print(ordenaditos(("hola", "oso")))
print(ordenaditos([]))

print("-"*80)

# Diccionarios.

# 1.


def diccionario(asignatura: dict) -> dict:
    try:
        if not isinstance(asignatura, dict):
            raise ValueError("Error: El argumento debe de ser un diccionario")
        if not asignatura:
            raise KeyError("Error: El diccionario no puede estar vacío")
        resultado = {}
        for asignatura, nota in asignatura.items():
            if nota < 0 or nota > 10:
                raise ValueError(
                    f"Error: Las notas para {asignatura} deben de ser entre 0 y 10")
            if nota < 5:
                resultado[asignatura] = ("Suspenso", nota)
            elif 5 <= nota < 6:
                resultado[asignatura] = ("Suficiente", nota)
            elif nota >= 6 and nota < 8:
                resultado[asignatura] = ("Bien", nota)
            elif nota >= 8 and nota < 9:
                resultado[asignatura] = ("Notable", nota)
            elif nota >= 9 and nota < 10:
                resultado[asignatura] = ("Sobresaliente", nota)
            elif nota == 10:
                resultado[asignatura] = ("Matrícula de honor", nota)
        return resultado
    except KeyError as e:
        print(e)
        return {}
    except ValueError as e:
        print(e)
        return {}
    except:
        print("Error inesperado")
        return {}


print(diccionario({
    "Matemáticas": 8.5,
    "Lengua": 9.2,
    "Historia": 7.8,
    "Ciencias": 8.0,
    "Inglés": 9.5,
    "Física": 6.7,
    "Química": 8.3
}))
print(diccionario({}))
print(diccionario([]))
print(diccionario({
    "Matemáticas": 18.5,
    "Lengua": 9.2,
    "Historia": 7.8,
    "Ciencias": 8.0,
    "Inglés": 9.5,
    "Física": 6.7,
    "Química": 8.3
}))
print("-"*80)

# 2.
