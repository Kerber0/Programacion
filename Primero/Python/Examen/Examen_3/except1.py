# Control de excepciones.

# 1.

def division(a:float, b: float) -> float:
    try:
        if not isinstance(a, (int,float)) or not isinstance(b, (int,float)):
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
print(division(3,2))
print(division(4,0))
print(division("Hola", 3))
print(division(3.2,4.3))

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

print(media((5,2,3,4,5)))
print(media([5,3,2,3,2]))
print(media([]))
print(media({3:2,4:3,7:1}))
print(media({3:2,4:3,3:"Hola"}))
print(media(["hola", 5, 2]))
print(media([2,3,5.5]))

print("-"*80)

# 3.

def cadena_repetida(cadena: str, n: int) -> str:
    try:
        if not isinstance(cadena,str):
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
print(cuadrados_numeros({3:2,"Hola":3}))
print(cuadrados_numeros(["hola",5,4,2]))
print(cuadrados_numeros([5,3,2,5]))
print(cuadrados_numeros([5.2,3,2]))

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

print(buscar_elemento((1,2,5,3),2))
print(buscar_elemento([1,2,3],2))
print(buscar_elemento((),2))
print(buscar_elemento((1,2,"Hola"),5))
print(buscar_elemento((1,2,"Hola"),2))

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
print(buscar_valor_diccionario((1,2), "Hola"))
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
    
print(max_numero([1,2,3,4,5,8,2]))
print(max_numero([]))
print(max_numero({}))
print(max_numero([1,2,"hola"]))

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
    
print(elementos_comunes_conjuntos({1,2,3},{3,4,1,5}))
print(elementos_comunes_conjuntos({3},{2,3}))
print(elementos_comunes_conjuntos({1,2},[1,3]))

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
    
print(elementos_primer_conjunto({1,2,3},{3,4,1,5}))
print(elementos_primer_conjunto({3},{2,3}))
print(elementos_primer_conjunto({1,2},[1,3]))

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

print(diferencia_simetrica({1,2,3},{3,4,1,5}))
print(diferencia_simetrica({3},{2,3}))
print(diferencia_simetrica({1,2},[1,3]))

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
    
print(eliminar_repetidos({1,3,4,5,3,2}))
print(eliminar_repetidos([1,2,3,5,2,3,4]))
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
            raise ValueError("Error: El argumento debe de ser una cadena de texto")
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

print(lista_contenida([1,2,3,8],[1,2,5,6,7,3]))
print(lista_contenida([],[]))
print(lista_contenida(["hola",2,3,4],[1,5,6,"hola",4,3,2]))
print(lista_contenida({"hola":3, 4:2},[1,2,3]))

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

print(tupla_ordenada((1,2,5,7,3)))
print(tupla_ordenada(()))
print(tupla_ordenada([]))
print(tupla_ordenada((1,2,3,4,5)))

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

print(tupla_ordenada2((1,2,5,7,3)))
print(tupla_ordenada2(()))
print(tupla_ordenada2([]))
print(tupla_ordenada2((1,2,3,4,5)))

print("-"*80)

# 2.

def tupla_ordenada_reves(tupla: tuple) -> bool:
    try:
        if not isinstance(tupla, tuple):
            raise ValueError("Error: El argumento debe de ser una tupla")
        if not all(isinstance(i, (int,float)) for i in tupla):
            raise TypeError("Error: Los valores deben de ser números")
        if len(tupla) <= 1:
            return True
        lista = list(tupla)
        for i in range (len(lista)):
            for j in range (len(lista) - i -1):
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
    
print(tupla_ordenada_reves((5,4,3,2,1)))
print(tupla_ordenada_reves(()))
print(tupla_ordenada_reves([]))
print(tupla_ordenada_reves((3,4,6,2,1)))

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

print(tupla_ordenada_reves2((5,4,3,2,1)))
print(tupla_ordenada_reves2(()))
print(tupla_ordenada_reves2([]))
print(tupla_ordenada_reves2((1,6,2,7,8)))

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
print(tupla_ordenada((1, 1, 1, 1)))     # True, todos son iguales, lo que también se considera ordenado
print(tupla_ordenada(()))               # True, una tupla vacía se considera ordenada
print(tupla_ordenada([1, 2, 3]))        # False, no es una tupla

print("-"*80)

# 3.

def elementos_distintos(tupla: tuple) -> bool:
    try:
        if not isinstance(tupla, tuple):
            raise ValueError("Error: El argumento debe ser una tupla")
        if len(tupla) <= 1:
            return True
        for i in range (len(tupla) - 1):
            if tupla[i] == tupla[i+1]:
                return False
        return True
    except ValueError as e:
        print(e)
        return ()
    except:
        print("Error inesperado")
        return ()

print(elementos_distintos(("hola","hola")))
print(elementos_distintos(()))
print(elementos_distintos([]))
print(elementos_distintos((1,2,3)))
print(elementos_distintos((1,1,1)))

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

print(elementos_capicua(("o","s","o")))
print(elementos_capicua(()))
print(elementos_capicua([]))
print(elementos_capicua(("o","s","i","t","o")))
print(elementos_capicua((1,2,1)))

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
print(multiplos((3,6,9),3))
print(multiplos((4,8,15,3,7),2))
print(multiplos([],1))

print("-"*80)

# Ejercicio Recursivo.

def suma_lista(lista: list) -> list:
    try:
        if not isinstance(lista, list):
            raise ValueError("Error: El argumento debe de ser una lista")
        if not all(isinstance(i, (int,float)) for i in lista):
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
print(suma_lista([1,2,3]))
print(suma_lista(["Hola", "oso"]))
print(suma_lista([]))
print(suma_lista((1,2,3)))

print("-"*80)

# 6.

def max_min(tupla: tuple) -> tuple:
    try:
        if not isinstance(tupla, tuple):
            raise ValueError("Error: El argumento debe de ser una tupla")
        if not all(isinstance(i, (int,float)) for i in tupla):
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
print(max_min((1,2,3,5,7,2)))
print(max_min(()))
print(max_min(("hola", "oso")))
print(max_min([]))

print("-"*80)

# 7.

def media(tupla: tuple) -> tuple:
    try:
        if not isinstance(tupla, tuple):
            raise ValueError("Error: El argumento debe de ser una tupla")
        if not all(isinstance(i, (int,float)) for i in tupla):
            raise TypeError("Error: Los valores deben de ser numeros")
        if len(tupla) == 0:
            raise ValueError("Error: La tupla no puede estar vacia")
        media = sum(tupla) / len(tupla)
        varianza = sum((x - media) ** 2 for x in tupla) / len(tupla)
        return round(media,2), round(varianza, 2)
    except ValueError as e:
        print(e)
        return ()
    except TypeError as e:
        print(e)
        return ()
    except:
        print("Error inesperado")
        return ()
print(media((1,2,3,5,7,2)))
print(media(()))
print(media(("hola", "oso")))
print(media([]))

print("-"*80)

# 8.

def ordenaditos(tupla: tuple) -> tuple:
    try:
        if not isinstance(tupla, tuple):
            raise ValueError("Error: El argumento debe de ser una tupla")
        if not all(isinstance(i, (int,float)) for i in tupla):
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
print(ordenaditos((1,2,3,5,7,2)))
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
            asignatura = asignatura.strip().lower()
            if nota < 0 or nota > 10:
                raise ValueError(f"Error: Las notas para {asignatura} deben de ser entre 0 y 10")
            if not isinstance(nota, (int, float)):
                raise TypeError(f"Error: La nota para {asignatura} debe ser un número.")
            if nota < 5:
                resultado[asignatura.capitalize()] = ("Suspenso", nota)
            elif 5 <= nota < 6:
                resultado[asignatura.capitalize()] = ("Suficiente", nota)
            elif nota >= 6 and nota < 8:
                resultado[asignatura.capitalize()] = ("Bien", nota)
            elif nota >= 8 and nota < 9:
                resultado[asignatura.capitalize()] = ("Notable", nota)
            elif nota >= 9 and nota < 10:
                resultado[asignatura.capitalize()] = ("Sobresaliente", nota)
            elif nota == 10:
                resultado[asignatura.capitalize()] = ("Matrícula de honor", nota)
        return resultado
    except KeyError as e:
        print(e)
        return {}
    except ValueError as e:
        print(e)
        return {}
    except TypeError as e:
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

def validar_notas(asignaturas: dict) -> bool:
    """
    Función para validar que las notas sean números entre 0 y 10.
    Retorna True si todas las notas son válidas, de lo contrario lanza un error.
    """
    try:
        if not isinstance(asignaturas, dict):
            raise ValueError("Error: El argumento debe ser un diccionario.")
        if not asignaturas:
            raise KeyError("Error: El diccionario no puede estar vacío.")

        for asignatura, nota in asignaturas.items():
            if nota < 0 or nota > 10:
                raise ValueError(f"Error: La nota para {asignatura} debe ser entre 0 y 10.")
            if not isinstance(nota, (int, float)):
                raise TypeError(f"Error: La nota para {asignatura} debe ser un número.")
        
        return True
    
    except (KeyError, ValueError, TypeError) as e:
        print(e)
        return False


def asignar_calificacion(asignaturas: dict) -> dict:
    """
    Función para asignar una calificación según la nota de cada asignatura.
    """
    try:
        resultado = {}
        for asignatura, nota in asignaturas.items():
            if nota < 5:
                resultado[asignatura] = ("Suspenso", nota)
            elif 5 <= nota < 6:
                resultado[asignatura] = ("Suficiente", nota)
            elif 6 <= nota < 8:
                resultado[asignatura] = ("Bien", nota)
            elif 8 <= nota < 9:
                resultado[asignatura] = ("Notable", nota)
            elif 9 <= nota < 10:
                resultado[asignatura] = ("Sobresaliente", nota)
            elif nota == 10:
                resultado[asignatura] = ("Matrícula de honor", nota)
        return resultado
    except Exception as e:
        print("Error inesperado:", e)
        return {}

def procesar_notas(asignaturas: dict) -> dict:
    """
    Función principal que valida las notas y luego asigna las calificaciones.
    """
    if validar_notas(asignaturas):
        return asignar_calificacion(asignaturas)
    else:
        return {}

# Ejemplo de uso
print(procesar_notas({
    "Matemáticas": 8.5,
    "Lengua": 9.2,
    "Historia": 7.8,
    "Ciencias": 8.0,
    "Inglés": 9.5,
    "Física": 6.7,
    "Química": 8.3
}))

# Casos de prueba
print(procesar_notas({}))  # Diccionario vacío
print(procesar_notas([]))  # Lista no válida
print(procesar_notas({
    "Matemáticas": 18.5,  # Nota fuera de rango
    "Lengua": 9.2,
    "Historia": 7.8,
    "Ciencias": 8.0,
    "Inglés": 9.5,
    "Física": 6.7,
    "Química": 8.3
}))

print("-"*80)

# Otra version mas.

def validar_notas(asignaturas: dict) -> bool:
    """
    Función para validar que las notas sean números entre 0 y 10.
    Retorna True si todas las notas son válidas, de lo contrario lanza un error.
    """
    try:
        if not isinstance(asignaturas, dict):
            raise ValueError("Error: El argumento debe ser un diccionario.")
        if not asignaturas:
            raise KeyError("Error: El diccionario no puede estar vacío.")

        for asignatura, nota in asignaturas.items():
            # Convertimos la asignatura a minúsculas para evitar problemas con mayúsculas/minúsculas
            asignatura = asignatura.strip().lower()
            if nota < 0 or nota > 10:
                raise ValueError(f"Error: La nota para {asignatura} debe ser entre 0 y 10.")
            if not isinstance(nota, (int, float)):
                raise TypeError(f"Error: La nota para {asignatura} debe ser un número.")
        
        return True
    
    except (KeyError, ValueError, TypeError) as e:
        print(e)
        return False


def asignar_calificacion(asignaturas: dict) -> dict:
    """
    Función para asignar una calificación según la nota de cada asignatura.
    """
    try:
        resultado = {}
        for asignatura, nota in asignaturas.items():
            # Convertir las asignaturas a mayúsculas para el resultado final
            asignatura = asignatura.strip().capitalize()
            if nota < 5:
                resultado[asignatura] = ("Suspenso", nota)
            elif 5 <= nota < 6:
                resultado[asignatura] = ("Suficiente", nota)
            elif 6 <= nota < 8:
                resultado[asignatura] = ("Bien", nota)
            elif 8 <= nota < 9:
                resultado[asignatura] = ("Notable", nota)
            elif 9 <= nota < 10:
                resultado[asignatura] = ("Sobresaliente", nota)
            elif nota == 10:
                resultado[asignatura] = ("Matrícula de honor", nota)
        return resultado
    except Exception as e:
        print("Error inesperado:", e)
        return {}

def procesar_notas(asignaturas: dict) -> dict:
    """
    Función principal que valida las notas y luego asigna las calificaciones.
    """
    if validar_notas(asignaturas):
        return asignar_calificacion(asignaturas)
    else:
        return {}

# Ejemplo de uso
print(procesar_notas({
    "matemáticas": 8.5,
    "lengua": 9.2,
    "historia": 7.8,
    "ciencias": 8.0,
    "inglés": 9.5,
    "física": 6.7,
    "química": 8.3
}))

# Casos de prueba
print(procesar_notas({}))  # Diccionario vacío
print(procesar_notas([]))  # Lista no válida
print(procesar_notas({
    "matemáticas": 18.5,  # Nota fuera de rango
    "lengua": 9.2,
    "historia": 7.8,
    "ciencias": 8.0,
    "inglés": 9.5,
    "física": 6.7,
    "química": 8.3
}))

print("-"*80)

# Versión buena.

def validar_notas(asignaturas: dict) -> dict:
    """
    Función que valida las notas de las asignaturas, asegurándose de que están en el rango correcto.
    Devuelve un diccionario con las asignaturas y sus notas.
    """
    try:
        # Validar que la entrada es un diccionario
        if not isinstance(asignaturas, dict):
            raise ValueError("Error: El argumento debe de ser un diccionario")
        
        # Verificar que el diccionario no está vacío
        if not asignaturas:
            raise KeyError("Error: El diccionario no puede estar vacío")

        resultado = {}
        
        # Validar las notas
        for asignatura, nota in asignaturas.items():
            # Convertir la clave de asignatura a minúsculas para comparación uniforme
            asignatura = asignatura.strip().lower()

            # Validar que la nota esté entre 0 y 10
            if nota < 0 or nota > 10:
                raise ValueError(f"Error: Las notas para {asignatura} deben ser entre 0 y 10")
            
            # Validar que la nota sea un número (entero o flotante)
            if not isinstance(nota, (int, float)):
                raise TypeError(f"Error: La nota para {asignatura} debe ser un número.")
            
            # Guardar la asignatura y su nota
            resultado[asignatura] = nota
        
        return resultado
    except KeyError as e:
        print(e)
        return {}
    except ValueError as e:
        print(e)
        return {}
    except TypeError as e:
        print(e)
        return {}
    except Exception as e:
        print("Error inesperado", e)
        return {}

def calificar_asignaturas(asignaturas_validadas: dict) -> dict:
    """
    Función que recibe las asignaturas y las notas validadas, y devuelve un diccionario con las calificaciones.
    """
    try:
        resultado = {}
        
        # Asignar la calificación según la nota de cada asignatura
        for asignatura, nota in asignaturas_validadas.items():
            if nota < 5:
                resultado[asignatura.capitalize()] = ("Suspenso", nota)
            elif 5 <= nota < 6:
                resultado[asignatura.capitalize()] = ("Suficiente", nota)
            elif 6 <= nota < 8:
                resultado[asignatura.capitalize()] = ("Bien", nota)
            elif 8 <= nota < 9:
                resultado[asignatura.capitalize()] = ("Notable", nota)
            elif 9 <= nota < 10:
                resultado[asignatura.capitalize()] = ("Sobresaliente", nota)
            elif nota == 10:
                resultado[asignatura.capitalize()] = ("Matrícula de honor", nota)
        
        return resultado
    except Exception as e:
        print("Error inesperado", e)
        return {}

# Ejemplo de uso:
asignaturas = {
    "matemáticas": 8.5,
    "lengua": 9.2,
    "historia": 7.8,
    "ciencias": 8.0,
    "inglés": 9.5,
    "física": 6.7,
    "química": 8.3
}

# Validar las notas
asignaturas_validadas = validar_notas(asignaturas)

# Calificar las asignaturas con las notas validadas
calificaciones = calificar_asignaturas(asignaturas_validadas)

# Mostrar el resultado final
print(calificaciones)

# Casos de prueba
print(calificar_asignaturas(validar_notas({})))  # Diccionario vacío
print(calificar_asignaturas(validar_notas([])))  # Lista no válida
print(calificar_asignaturas(validar_notas({
    "matemáticas": 18.5,  # Nota fuera de rango
    "lengua": 9.2,
    "historia": 7.8,
    "ciencias": 8.0,
    "inglés": 9.5,
    "física": 6.7,
    "química": 8.3
})))  # Nota fuera de rango

print("-"*80)

# Con random.

import random

def generar_notas(asignaturas: list) -> dict:
    """
    Genera un diccionario con asignaturas y notas aleatorias entre 0 y 10.
    """
    return {asignatura: round(random.uniform(0, 10), 2) for asignatura in asignaturas}

def validar_notas(asignaturas: dict) -> dict:
    """
    Función que valida las notas de las asignaturas, asegurándose de que están en el rango correcto.
    Devuelve un diccionario con las asignaturas y sus notas.
    """
    try:
        if not isinstance(asignaturas, dict):
            raise ValueError("Error: El argumento debe de ser un diccionario")
        
        if not asignaturas:
            raise KeyError("Error: El diccionario no puede estar vacío")
        
        resultado = {}
        
        for asignatura, nota in asignaturas.items():
            asignatura = asignatura.strip().lower()

            if nota < 0 or nota > 10:
                raise ValueError(f"Error: Las notas para {asignatura} deben ser entre 0 y 10")
            
            if not isinstance(nota, (int, float)):
                raise TypeError(f"Error: La nota para {asignatura} debe ser un número.")
            
            resultado[asignatura] = nota
        
        return resultado
    except KeyError as e:
        print(e)
        return {}
    except ValueError as e:
        print(e)
        return {}
    except TypeError as e:
        print(e)
        return {}
    except Exception as e:
        print("Error inesperado", e)
        return {}

def calificar_asignaturas(asignaturas_validadas: dict) -> dict:
    """
    Función que recibe las asignaturas y las notas validadas, y devuelve un diccionario con las calificaciones.
    """
    try:
        resultado = {}
        
        for asignatura, nota in asignaturas_validadas.items():
            if nota < 5:
                resultado[asignatura.capitalize()] = ("Suspenso", nota)
            elif 5 <= nota < 6:
                resultado[asignatura.capitalize()] = ("Suficiente", nota)
            elif 6 <= nota < 8:
                resultado[asignatura.capitalize()] = ("Bien", nota)
            elif 8 <= nota < 9:
                resultado[asignatura.capitalize()] = ("Notable", nota)
            elif 9 <= nota < 10:
                resultado[asignatura.capitalize()] = ("Sobresaliente", nota)
            elif nota == 10:
                resultado[asignatura.capitalize()] = ("Matrícula de honor", nota)
        
        return resultado
    except Exception as e:
        print("Error inesperado", e)
        return {}

# Lista de asignaturas
asignaturas = [
    "matemáticas", "lengua", "historia", "ciencias", 
    "inglés", "física", "química"
]

# Generar notas aleatorias para las asignaturas
notas_aleatorias = generar_notas(asignaturas)

# Validar las notas generadas
asignaturas_validadas = validar_notas(notas_aleatorias)

# Calificar las asignaturas con las notas validadas
calificaciones = calificar_asignaturas(asignaturas_validadas)

# Mostrar el resultado final
print(calificaciones)

print("-"*80)

# 2.

def horario(horario: dict) -> dict:
    try:
        if not isinstance(horario, dict):
          raise ValueError("Error: El argumento debe de ser un diccionario")
        
        if not horario:
            raise KeyError("Error: El diccionario no puede estar vacío")  
        for dia, asignaturas in horario.items():
            dia_capitalizado = dia.capitalize()
            print(f"{dia_capitalizado}:")

            if isinstance(asignaturas, list) and asignaturas:
                for asignatura in asignaturas:
                    print(f"    - {asignatura}")
            else:
                print(" No hay asignaturas.")
            print("")
    except ValueError as e:
        print(e)
        return {}
    except KeyError as e:
        print(e)
        return {}
    except:
        print("Error inesperado")
        return {}
horario({
    "lunes": ["Matemáticas", "Lengua", "Historia"],
    "martes": ["Ciencias", "Inglés", "Física"],
    "miércoles": ["Química", "Educación Física", "Música"],
    "jueves": ["Lengua", "Historia", "Geografía"],
    "viernes": ["Matemáticas", "Inglés", "Filosofía"]
}
)

print("-"*80)

# Version pocha.

def imprimir_horario(diccionario: dict) -> None:
    try:
        for dia, asignaturas in diccionario.items():
            print(f"{dia}: {', '.join(asignaturas)}")
    except AttributeError:
        print("Por favor, introduzca un diccionario con los días de la semana y las asignaturas correspondientes")
    except TypeError:
        print("Por favor, introduzca un diccionario con los días de la semana y las asignaturas correspondientes")
    except:
        print("Ha ocurrido un error")

# Pruebas
imprimir_horario({"Lunes": ["Matemáticas", "Lengua"], "Martes": ["Historia", "Inglés"], "Miércoles": ["Física", "Química"]})    

print("-"*80)

# Otra version.

def imprimir_horario(diccionario: dict) -> None:
    # Verificar si el argumento es un diccionario
    if not isinstance(diccionario, dict):
        raise ValueError("El argumento debe ser un diccionario con los días de la semana y las asignaturas correspondientes.")
    
    # Verificar si el diccionario tiene las claves correctas (días de la semana)
    dias_validos = {"lunes", "martes", "miércoles", "jueves", "viernes", "sábado", "domingo"}
    for dia, asignaturas in diccionario.items():
        if dia not in dias_validos:
            raise KeyError(f"El día {dia} no es válido. Por favor, utilice un día de la semana correcto.")
        # Verificar si las asignaturas son una lista
        if not isinstance(asignaturas, list):
            raise TypeError(f"Las asignaturas para {dia} deben estar en formato de lista.")
        # Verificar si cada asignatura es una cadena
        if not all(isinstance(asignatura, str) for asignatura in asignaturas):
            raise TypeError(f"Todas las asignaturas para {dia} deben ser cadenas de texto.")

    # Si todo está correcto, imprimir el horario
    for dia, asignaturas in diccionario.items():
        print(f"{dia.capitalize()}: {', '.join(asignaturas)}")

# Ejemplo de uso
horario = {
    "lunes": ["Matemáticas", "Lengua", "Historia"],
    "martes": ["Ciencias", "Inglés", "Física"],
    "miércoles": ["Química", "Educación Física", "Música"],
    "jueves": ["Lengua", "Historia", "Geografía"],
    "viernes": ["Matemáticas", "Inglés", "Filosofía"]
}

try:
    imprimir_horario(horario)
except (ValueError, KeyError, TypeError) as e:
    print(f"Error: {e}")

print("-"*80)

# 3.

def productos(precios: dict, cantidad: dict) -> dict:
    try:
        if not isinstance(precios, dict) or not isinstance(cantidad, dict):
            return ValueError("Error: Los argumentos deben de ser diccionarios")
        if not precios or not cantidad:
            return ValueError("Error: Los diccionarios no pueden estar vacíos")
        total = {}
        for producto in precios:
            if producto in cantidad:
                total[producto] = precios[producto]*cantidad[producto]
            else:
                raise KeyError(f"Error: El producto {producto} no tiene cantidad registrada")
        return total
    except ValueError as e:
        print(e)
        return {}
    except KeyError as e:
        print(e)
        return {}
    except:
        print("Error inesperado")
        return {}
    
precios = {"manzanas": 2, "peras": 3, "plátanos": 1.5}
cantidad = {"manzanas": 5, "peras": 3, "plátanos": 10}

print(productos(precios, cantidad))    

print("-"*80)

# 4.

def media_notas(asignaturas: dict) -> dict:
    try:
        if not isinstance(asignaturas, dict):
            raise ValueError("Error: El argumento debe de ser un diccionario")
        if not asignaturas:
            raise ValueError("Error: El diccionario no puede estar vacío")
        for asignatura, nota in asignaturas.items():
            if not isinstance(nota, (int, float)):
                raise ValueError(f"Error: La nota de {asignatura} debe ser un número")
        total_notas = sum(asignaturas.values())
        cantidad_asignaturas = len(asignaturas)
        media = total_notas / cantidad_asignaturas
        return {"Media": media}
    except ValueError as e:
        print(e)
        return {}
    except:
        print("Error inesperado")
        return {}
    
notas = {
    "Matemáticas": 8.5,
    "Lengua": 9.2,
    "Historia": 7.8,
    "Ciencias": 8.0,
    "Inglés": 9.5
}

print(media_notas(notas))

# Ejemplo con un error en una de las notas
notas_con_error = {
    "Matemáticas": 8.5,
    "Lengua": "N/A",  # Error: no es un número
    "Historia": 7.8
}

print(media_notas(notas_con_error))

print("-"*80)

# 5.

def distancia_planetas(planetas: dict, planeta: str) -> float:
    try:
        if not isinstance(planetas, dict):
            raise ValueError("Error: El argumento debe de ser un diccionario")
        if not planetas:
            raise ValueError("Error: El diccionario no puede estar vacío")
        if not all(isinstance(distancia, (int, float)) for distancia in planetas.values()):
            raise ValueError("Error: Todas las distancias deben ser números")
        if planeta not in planetas:
            raise KeyError(f"Error: El planeta {planeta} no se encuentra en el diccionario")
        return round(abs(planetas[planeta] - 149.6), 2)
    except ValueError as e:
        print(e)
        return -1
    except KeyError as e:
        print(e)
        return -1
    except Exception as e:
        print(f"Error inesperado {e}")
        return -1
    
planetas_distancias = {
    "Mercurio": 57.9,
    "Venus": 108.2,
    "Tierra": 149.6,
    "Marte": 227.9
}

print(distancia_planetas(planetas_distancias, "Marte"))  # Distancia de Marte a la Tierra
print(distancia_planetas(planetas_distancias, "Plutón"))  # Planeta no encontrado

print("-"*80)

# 6.

def palabras(lista: list) -> dict:
    try:
        if not isinstance(lista, list):
            raise ValueError("Error: El argumento debe ser una lista")
        if not lista:
            raise ValueError("Error: La lista no puede estar vacía")
        if not all(isinstance(palabra, (str)) for palabra in lista):
            raise ValueError("Error: Los valores de la lista deben ser cadenas de texto")
        resultado = {palabra: len(palabra) for palabra in lista}
        return resultado 
    except ValueError as e:
        print(e)
        return {}
    except:
        print("Error inesperado")
        return {}
    
print(palabras(("hola","como","va","eso")))
print(palabras(["hola","como","va","eso"]))

print("-"*80)

# 7.

def contar_palabras(lista: list) -> dict:
    try:
        if not isinstance(lista, list):
            raise ValueError("Error: El argumento debe ser una lista")
        if not lista:
            raise ValueError("Error: La lista no puede estar vacía")
        if not all(isinstance(palabra, (str)) for palabra in lista):
            raise ValueError("Error: Los valores de la lista debeb ser cadenas de texto")
        resultado = {palabra: lista.count(palabra) for palabra in lista}
        return resultado
    except ValueError as e:
        print(e)
        return {}
    except:
        print("Error inesperado")
        return  {}

print(contar_palabras(("hola","como","va","eso")))
print(contar_palabras(["hola","como","va","eso"]))

print("-"*80)

# Examen Tema 2 con correción de errores.

# 1.

"""
Diseña un algoritmo que calcule la cantidad de propinas que se deben dar en un restaurante.
El algoritmo debe leer de teclado el total de la cuenta y preguntarle al usuario si su servicio fue bueno, malo o regular.
Para saber la opción elegida por el usuario, se debe indicar que el usuario debe escribir "bueno", "malo" o "regular",
 puede escribirlo en minúsculas, mayúsculas o combinando ambas y debe funcionar igual.   
En caso de que el servicio haya sido bueno, el algoritmo debe calcular el 20% del total de la cuenta.   
En caso de que el servicio haya sido regular, el algoritmo debe calcular el 15% del total de la cuenta.
En caso de que el servicio haya sido malo, el algoritmo debe calcular el 10% del total de la cuenta.
Finalmente, el algoritmo debe imprimir el total de la cuenta más la propina y el total de la propina, por separado.   
"""

print("Ejercicio 1 - Calculadora de propinas")
"""
def propina(propina: float) -> float:
    pass
    try:
        if not isinstance(propina, (int,float)):
            raise ValueError("Error: Debes introducir un número")
        if propina <= 0:
            raise ValueError("Error: Debe ser un número positivo")
        if not propina:
            raise ValueError("Error: La propina no puede estar vacía")
        propina = float(input("Introduce el importe de la cuenta: "))
        propina2 = input("Como ha sido el servicio? (Bueno, Malo o Regular): ").lower()
        if not propina2:
            raise ValueError("Error: El servicio no puede estar vacío")
        if not isinstance(propina2, str):
            raise ValueError("Error: Debes introducir una cadena de texto")
        match propina2:
            case "bueno":
                total = propina + propina * 0.20
            case "regular":
                total = propina + propina * 0.15
            case "malo":
                total = propina + propina * 0.10
            case _:
                raise ValueError("Error: Servicio no válido, Usa: Bueno, Malo o Regular")
        return total
    except ValueError as e:
        print(e)
        return 0
    except:
        print("Error inesperado")
        return 0

print(propina(100))
"""
print("-"*20)

# 2.

"""
Diseñar un algoritmo que nos diga si la palabra introducida por el usuario es un palíndromo o no.   
Un palíndromo es una palabra que se lee igual de izquierda a derecha que de derecha a izquierda.    
Por ejemplo, la palabra "oso" es un palíndromo.
El algoritmo debe leer una palabra del usuario y comprobar si es un palíndromo o no.
"""
print("Ejercicio 2 - Comprobador de palíndromos")

def palindromo(pal: str) -> bool:
    try:
        if not isinstance(pal, str):
            raise ValueError("Error: El argumento debe ser una cadena de texto")
        if not pal:
            raise ValueError("Error: El argumento no puede estar vacío")
        pal = pal.lower()
        if pal != pal[::-1]:
            print("No es un palíndromo")
            return False
        print("Es un palíndromo")
        return True
    except ValueError as e:
        print(e)
        return None
    except:
        print("Error inesperado")
        return None

print(palindromo("Oso"))
print(palindromo("Pez"))

"""
Diseñar un algoritmo que calcule la edad de una persona en función de su fecha de nacimiento.
El algoritmo debe leer el año, mes y día de nacimiento de la persona y calcular su edad a día de hoy.
Hay que comprobar que la fecha de nacimiento es válida, aunque se da por hecho que los datos introducidos
 por el usuario serán números enteros.
Finalmente, el algoritmo debe imprimir la edad de la persona.
"""

print("Ejercicio 3 - Calculadora de edad")

# 3.

def edad(anio: int, mes: int, dia: int) -> int:
    try:
        if not isinstance(anio, int) or not isinstance(mes, int) or not isinstance(dia, int):
            raise ValueError("Error: Los datos deben de ser números enteros")
        if not anio or not mes or not dia:
            raise ValueError("Error: Los datos no pueden estar vacíos")
        if anio < 0 or mes < 0 or dia < 0:
            raise ValueError("Error: Los valores deben ser números positivos")
        while 2024 < anio < 1900:
            print("Introduzca un año correcto (Entre 1900 y 2024): ")
            anio = int(input())
        while 1 > mes > 12:
            print("Introduzca un mes correcto (Entre 1 y 12): ")
            mes = int(input())
            while 1 > dia > 31:
                print("Introduzca un día correcto (Entre 1 y 31): ")
                dia = int(input())
        edad = 2024 - anio
        anio_ac = 2024
        mes_ac = 12
        dia_ac = 8
        if mes_ac < mes or mes_ac == mes and dia_ac < dia:
            edad = edad - 1
        return edad
    except ValueError as e:
        print(e)
        return None
    except:
        print("Error inesperado")
        return None

print(edad(1999, 12, 12))  

print("-"*20)

# 4.

"""
Diseñar un algoritmo que pida al usuario un número entero y calcule la suma de los dígitos de ese número.
Una vez tenga la suma calculada debe dividir el resultado entre el total de dígitos que tiene el número.
Finalmente, el algoritmo debe imprimir el resultado de la división.
Hay que controlar el que el número introducido por el usuario sea positivo.
Este ejercicio hay que resolverlo de dos maneras, es decir, debes hacer dos versiones del algoritmo:
Una con un bucle while y con un bucle for. Cada versión debe tener su propio código y no se pueden mezclar.
Cada versión del algoritmo tendrá un valor de 1 punto.
"""

print("Ejercicio 5 - Jugando con los dígitos - versión while")

# Con While.

def digitos(num: int) -> int: 
    try:
        if not isinstance(num, int) or num < 0:
            raise ValueError("Error: El número debe de ser un entero positivo")
        suma = 0
        contador = 0
        while num > 0:
            suma += num % 10
            num = num // 10
            contador += 1
        
        return suma / contador if contador != 0 else 0
    except ValueError as e:
        print(e)
        return 0
    except:
        print("Error inesperado")
        return 0

print(digitos(101))

print("-"*20)

# Con For.

def digitos2(num: int) -> int: 
    try:
        if not isinstance(num, int) or num < 0:
            raise ValueError("Error: El argumento debe ser un número entero positivo")
        suma = 0
        contador = 0
        for digito in str(num):
            suma += int(digito)
            contador += 1
        return suma / contador if contador != 0 else 0
    except ValueError as e:
        print(e)
        return 0
    except:
        print("Error inesperado")
        return 0

print(digitos2(101))

print("-"*20)

# Examen Tema 3 con correción de errores.

"""
Diseña una función que reciba el nombre de un planeta del Sistema Solar y devuelva el número de lunas que tiene.
La función debe devolver un número entero y debe aceptar el nombre del planeta en minúsculas, mayúsculas o combinando ambas.
Si el planeta es Plutón, la función debe devolver 5 y además debe imprimir un mensaje que diga "Plutón ya no es considerado un planeta :(". 
Si el planeta no existe, la función debe devolver None.
El número de lunas de los planetas del Sistema Solar son los siguientes:
- Mercurio: 0
- Venus: 0
- Tierra: 1
- Marte: 2
- Júpiter: 79
- Saturno: 82
- Urano: 27
- Neptuno: 14
- Plutón: 5

Una vez creada esta función, se debe crear otra que use la lista de planetas dada (planets)
 y devuelva una string con el nombre de cada planeta y el número de lunas que tiene.
 Si un planeta no lunas, se debe indicar que no tiene lunas de la siguiente manera: "Mercurio: 0 lunas".
 Si un planeta no existe, se debe indicar que no existe de la siguiente manera: "Alderaan: no existe en el Sistema Solar".        
 El formato de la string debe ser el siguiente:
 "Mercurio: 0 Lunas, Tierra: 1 Luna, Saturno: 82 Lunas, Urano: 27 Lunas, Plutón: 5 Lunas, Alderaan: no existe en el Sistema Solar".    

 Nota: para poner la primera letra de un String en mayúsculas, se puede usar el método capitalize().    
"""
planets = ["MERCURIO", "VENUS", "TIERRA", "ALDERAAN", "JUPITER", "MARTE", "SATURNO", "NEPTUNO", "PLUTON"]

def numLunas(planeta: str) -> int:
    planeta = planeta.lower()
    match planeta:
        case "mercurio":
            return 0
        case "venus":
            return 0
        case "tierra":
            return 1
        case "marte":
            return 2
        case "jupiter":
            return 79
        case "saturno":
            return 82
        case "urano":
            return 27
        case "neptuno":
            return 14
        case "pluton":
            print("Plutón ya no es considerado un planeta :(")
            return 5
        case _:
            return None

def numLunasPlanetas(planetas: list) -> str:
    resultado = ""
    for planeta in planetas:
        lunas = numLunas(planeta)
        if lunas == None:
            resultado += planeta.capitalize() + ": No existe en el Sistema Solar, "
        else:
            resultado += planeta.capitalize() + ": " + str(lunas) + " Lunas, "
    return resultado[:-2]



print(numLunas("Tierra"))
print(numLunas("Marte"))
print(numLunas("Pluton"))
print(numLunas("Alderaan"))
print(numLunasPlanetas(planets))

# Fin del ejercicio 1

print("-"*30)

# 2.

"""
Diseña una función que reciba una nota numérica y devuelva la cualificación correspondiente.
Las notas son las siguientes:
- 0-4.9: Suspenso
- 5-6.9: Aprobado
- 7-8.9: Notable
- 9-9.9: Sobresaliente
- 10: Matrícula de Honor

La función debe devolver un string con la cualificación correspondiente.
Si la nota no está en el rango 0-10, la función debe devolver None.

Una vez creada esta función, se debe crear otra que reciba dos listas, una primera lista con 
los nombres de las materias y una segunda lista con las notas de esas materias.

La función debe devolver una lista con el nombre de las materias y la cualificación correspondiente.
Las notas de esta lista a devolver deben ser strings con la siguiente forma: "Matemáticas: Sobresaliente".  
Si una nota no está en el rango 0-10, se debe indicar que la nota es incorrecta de la siguiente manera: "Inglés: Nota incorrecta".
Si las listas no tienen la misma longitud, la función debe devolver una lista con un solo elemento que sea "Error: Las listas no tienen la misma longitud".
"""

def cualificacion(nota: float) -> str:
    if 0 <= nota <= 4.9:
        return "Suspenso"
    elif 5 <= nota <= 6.9:
        return "Aprobado"
    elif 7 <= nota <= 8.9:
        return "Notable"
    elif 9 <= nota <= 9.9:
        return "Sobresaliente"
    elif nota == 10:
        return "Matrícula de honor"
    else:
        return None

def cualificacionMaterias(materias: list, notas: list) -> list:
    if len(materias) != len(notas):
        return ["Error: Las listas no tienen la misma longitud"]
    resultado = []
    for i in range(len(materias)):
        nota = cualificacion(notas[i])
        if nota == None:
            resultado.append(materias[i] + ": Nota incorrecta")
        else:
            resultado.append(materias[i] + ": " + nota)
    return resultado



materias = ["Matemáticas", "Física", "Química", "Inglés"]
notas = [9.5, 7.2, 11, 8.9]
notas2 = [9.5, 7.2, 8.9]
print(cualificacion(9.5))
print(cualificacion(7.2))
print(cualificacion(11))
print(cualificacion(8.9))
print(cualificacionMaterias(materias, notas))
print(cualificacionMaterias(materias, notas2))

# Fin del ejercicio 2

print("-"*30)

# 3.

"""
Elaborar dos funciones básicas para trabajar con listas de números enteros.
La primera debe sumar todos los elementos de la lista y devolver el resultado.
La segunda debe buscar un elemento de la lista pasado como parámetro junto con la propia lista 
y devolver si está o no el elemento en la lista.

Ambas funciones TIENE que ser recursivas.
"""

def sumaLista(lista: list) -> int:
    if len(lista) == 0:
        return 0
    return lista[0] + sumaLista(lista[1:])

def buscarElemento(lista: list, elemento: int) -> int:
    if not lista:
        return False    
    if lista[0] == elemento:
        return True
    return buscarElemento(lista[1:], elemento)





lista = [1, 2, 3, 4, 5]
print(sumaLista(lista))
print(buscarElemento(lista, 3))
print(buscarElemento(lista, 6))

# Fin del ejercicio 3

print("-"*30)

# Dado un diccionario que asocia números con tuplas de coordenadas, crea una matriz de ceros y llena las posiciones indicadas por las tuplas con los números correspondientes.
# Ejemplo de entrada: {1: (0, 0), 2: (1, 1), 3: (2, 2)}

def llenar_matriz(diccionario: dict) -> list:
    filas = max(fila[0] for fila in diccionario.values()) + 1
    columnas = max(columna[0] for columna in diccionario.values()) + 1

    matriz = [[0 for j in range(columnas)] for i in range (filas)]

    for numero, (fila, columna) in diccionario.items():
        matriz[fila][columna] = numero
    
    return matriz

diccionario = {1: (0, 0), 2: (1, 1), 3: (2, 2)}
resultado = llenar_matriz(diccionario)
print(resultado)

# Salida esperada: [[1, 0, 0], [0, 2, 0], [0, 0, 3]]

print("-"*30)

# Crea una matriz 3x3 y almacena la suma de cada fila en un diccionario, donde las claves sean tuplas con los índices de cada fila.
# Ejemplo de entrada: [[1, 2, 3], [4, 5, 6], [7, 8, 9]]

def suma_matriz(matriz: dict) -> dict:
    suma_filas= {}

    for i, fila in enumerate(matriz):
        suma_filas[(i,)] = sum(fila)
    return suma_filas



print(suma_matriz([[1, 2, 3], [4, 5, 6], [7, 8, 9]]))

# Salida esperada: {(0,): 6, (1,): 15, (2,): 24}

print("-"*30)

# Convierte una matriz 2x3 en un diccionario donde las claves sean tuplas de índices (i, j) y los valores sean los elementos de la matriz.
# Ejemplo de entrada: [[5, 6], [7, 8], [9, 10]]

def claves_matriz(matriz: list) -> dict:
    diccionario = {}

    for i in range(len(matriz)):
        for j in range(len(matriz[i])):
            diccionario[(i,j)] = matriz[i][j]
    return diccionario

print(claves_matriz([[5, 6], [7, 8], [9, 10]]))

# Salida esperada: {(0, 0): 5, (0, 1): 6, (1, 0): 7, (1, 1): 8, (2, 0): 9, (2, 1): 10}

print("-"*30)

# Genera una matriz de 4x4 con números aleatorios entre 1 y 10, luego guarda en un diccionario cuántas veces aparece cada número.
# Ejemplo de entrada: [[1, 2], [2, 3], [3, 4], [4, 5]]

import random 

def matriz_random(matriz: list) -> dict:
    matriz = [[random.randint(1,10) for k in range(4)] for i in range(4)]
    print("Matriz generada: ")
    for fila in matriz:
        print(fila)
    diccionario = {}
    for i in range(len(matriz)):
        for j in range(len(matriz[i])):
            num = matriz[i][j]
            if num in diccionario:
                diccionario[num] += 1
            else:
                diccionario[num] = 1
    return diccionario

print(matriz_random([[1, 2], [2, 3], [3, 4], [4, 5]]))

# Salida esperada: {1: 1, 2: 2, 3: 2, 4: 2, 5: 1}

print("-"*30)

# Crea una matriz 5x5 y llena un conjunto con los elementos únicos de la matriz.
# Ejemplo de entrada: [[1, 2], [2, 3], [3, 1], [1, 2]]

def matriz_unicos(matriz: list) -> set:
    conjunto = set()
    for fila in matriz:
        for elemento in fila:
            conjunto.add(elemento)
    return conjunto

print(matriz_unicos([[1, 2], [2, 3], [3, 1], [1, 2]]))
                
# Salida esperada: {1, 2, 3}

print("-"*30)

# Genera una matriz aleatoria 3x3 y crea un diccionario que relacione cada valor único con su posición (en forma de conjunto de tuplas).
# Ejemplo de entrada: [[1, 1, 2], [3, 3, 3], [2, 2, 2]]

def posiciones(matriz: list) -> dict:
    matriz = [[random.randint(1, 5) for _ in range(3)] for _ in range(3)]
    diccionario = {}
    for i in range(len(matriz)):
        for j in range(len(matriz[i])):
            valor = matriz[i][j]
            if valor not in diccionario:
                diccionario[valor] = set()
            diccionario[valor].add((i, j))
    return diccionario

print(posiciones([[1, 1, 2], [3, 3, 3], [2, 2, 2]]))


# Salida esperada: {1: {(0, 0), (0, 1)}, 2: {(0, 2), (2, 0), (2, 1), (2, 2)}, 3: {(1, 0), (1, 1), (1, 2)}}

print("-"*30)

# Llena una matriz 4x4 con números aleatorios entre 1 y 5 y elimina los duplicados utilizando conjuntos.
# Ejemplo de entrada: [[1, 1, 1], [1, 1, 1], [1, 1, 1]]

def eliminar_duplicados(matriz: list) -> set:
    matriz = [[random.randint(1,5) for j in range(4)] for i in range(4)]
    for fila in matriz:
        print(fila)
    conjunto = set()
    for fila in matriz:
        for elemento in fila:
            conjunto.add(elemento)
    return conjunto

print(eliminar_duplicados([[1, 1, 2], [3, 3, 3], [2, 2, 2]]))

# Salida esperada: {1}

print("-"*30)

# Convierte una matriz 2x3 en un conjunto con todos sus elementos únicos y muestra cuántos elementos únicos contiene.
# Ejemplo de entrada: [[1, 2, 3], [4, 5, 6]]

def contar_unicos(matriz: list) -> int:
    conjunto = set()
    for fila in matriz:
        for elemento in fila:
            conjunto.add(elemento)
    return len(conjunto)

print(contar_unicos([[1, 2, 3], [4, 5, 6]]))

# Salida esperada: 6

print("-"*30)

# Crea una matriz 3x3 y almacena la suma de cada fila en un diccionario, donde las claves sean tuplas con los índices de cada fila.
# Ejemplo de entrada: [[1, 2, 3], [4, 5, 6], [7, 8, 9]]

def suma_y_claves(matriz: list) -> dict: 
    diccionario = {}
    for i in range(len(matriz)):
            diccionario[(i,)] = sum(matriz[i])
    return diccionario

print(suma_y_claves([[1, 2, 3], [4, 5, 6], [7, 8, 9]]))

# Salida esperada: {(0,): 6, (1,): 15, (2,): 24}

print("-"*30)

# Dado un diccionario que asocia números con tuplas de coordenadas, crea una matriz de ceros y llena las posiciones indicadas por las tuplas con los números correspondientes.
# Ejemplo de entrada: {1: (0, 0), 2: (1, 1), 3: (2, 2)}

def num_coord(diccionario: dict) -> list:
    matriz = [[0 for j in range(3)] for i in range(3)]
    for valor, (i,j) in diccionario.items():
        matriz [i][j] = valor
    return matriz

print(num_coord({1: (0, 0), 2: (1, 1), 3: (2, 2)}))

# Salida esperada: [[1, 0, 0], [0, 2, 0], [0, 0, 3]]

print("-"*30)

# Convierte una matriz 2x3 en un diccionario donde las claves sean tuplas de índices (i, j) y los valores sean los elementos de la matriz.
# Ejemplo de entrada: [[5, 6], [7, 8], [9, 10]]

def inversa(matriz: list) -> dict:
    diccionario = {}
    for i in range(len(matriz)):
        for j in range(len(matriz[i])):
            diccionario[(i,j)] = matriz[i][j]
    return diccionario

print(inversa([[5, 6], [7, 8], [9, 10]]))

# Salida esperada: {(0, 0): 5, (0, 1): 6, (1, 0): 7, (1, 1): 8, (2, 0): 9, (2, 1): 10

print("-"*30)

# Genera una matriz de 4x4 con números aleatorios entre 1 y 10, luego guarda en un diccionario cuántas veces aparece cada número.
# Ejemplo de entrada: [[1, 2], [2, 3], [3, 4], [4, 5]]

def random_count(matriz: list) -> dict:
    diccionario = {}
    matriz = [[random.randint(1,10) for j in range(4)] for i in range(4)]
    print("Matriz generada: ")
    for fila in matriz:
        print(fila)
    for fila in matriz:
        for elemento in fila:
            if elemento in diccionario:
                diccionario[elemento] += 1
            else:
                diccionario[elemento] = 1
    return diccionario

print(random_count([[1, 2], [2, 3], [3, 4], [4, 5]]))

# Salida esperada: {1: 1, 2: 2, 3: 2, 4: 2, 5: 1}

print("-"*30)

# Dado un diccionario de estudiantes con sus calificaciones, selecciona 
# un estudiante aleatorio y su calificación.
# Entrada esperada: {'Juan': 85, 'María': 90, 'Carlos': 78, 'Ana': 92}

import random

# Diccionario de estudiantes con sus calificaciones
estudiantes = {
    'Juan': 85,
    'María': 90,
    'Carlos': 78,
    'Ana': 92
}

# Usamos random.choice para seleccionar un estudiante aleatorio (una clave)
estudiante_aleatorio = random.choice(list(estudiantes.keys()))  # Convertimos las claves en una lista
calificacion_aleatoria = estudiantes[estudiante_aleatorio]  # Obtenemos la calificación correspondiente

# Imprimir el estudiante y su calificación seleccionados aleatoriamente
print(f"'{estudiante_aleatorio}' -> {calificacion_aleatoria}")

# Salida esperada: Ejemplo de salida esperada: 'Carlos' -> 78

print("-"*30)

import random

# Diccionario de países y sus capitales
paises = {
    'España': 'Madrid',
    'Francia': 'París',
    'Alemania': 'Berlín',
    'Italia': 'Roma'
}

# Usamos random.choice para seleccionar un país aleatorio (una clave)
pais_aleatorio = random.choice(list(paises.keys()))  # Convertimos las claves en una lista
capital_aleatoria = paises[pais_aleatorio]  # Obtenemos la capital correspondiente

# Imprimir el país y su capital seleccionados aleatoriamente
print(f"'{pais_aleatorio}' -> '{capital_aleatoria}'")

print("-"*30)

import random

def seleccionar_pais_y_capital(paises: dict) -> str:
    # Seleccionar un país aleatorio
    pais_aleatorio = random.choice(list(paises.keys()))  # Convertimos las claves en una lista
    capital_aleatoria = paises[pais_aleatorio]  # Obtenemos la capital correspondiente
    
    # Devolver el resultado en el formato esperado
    return f"'{pais_aleatorio}' -> '{capital_aleatoria}'"

# Diccionario de países y sus capitales
paises = {
    'España': 'Madrid',
    'Francia': 'París',
    'Alemania': 'Berlín',
    'Italia': 'Roma'
}

# Llamamos a la función y mostramos el resultado
print(seleccionar_pais_y_capital(paises))

print("-"*30)

import random

def promedio_ventas(ventas: dict) -> str:
    # Seleccionamos aleatoriamente un empleado
    empleado_aleatorio = random.choice(list(ventas.keys()))  # Convertimos las claves (empleados) en una lista
    
    # Obtenemos las ventas del empleado seleccionado
    ventas_empleado = ventas[empleado_aleatorio]
    
    # Calculamos el promedio de las ventas
    promedio = sum(ventas_empleado) / len(ventas_empleado)
    
    # Devolvemos el nombre del empleado y el promedio formateado a dos decimales
    return f"'{empleado_aleatorio}' -> Promedio: {promedio:.2f}"

# Diccionario de ventas mensuales por empleado
ventas = {
    'Juan': [1200, 1500, 1300],
    'María': [1700, 1600, 1800],
    'Carlos': [1100, 1050, 1150]
}

# Llamamos a la función y mostramos el resultado
print(promedio_ventas(ventas))

print("-"*30)

import random

def seleccionar_palabra_y_frecuencia(palabras: dict) -> str:
    # Seleccionamos aleatoriamente una palabra
    palabra_aleatoria = random.choice(list(palabras.keys()))  # Convertimos las claves en una lista
    
    # Obtenemos la frecuencia de la palabra seleccionada
    frecuencia = palabras[palabra_aleatoria]
    
    # Devolvemos el resultado en el formato adecuado
    return f"'{palabra_aleatoria}' -> Frecuencia: {frecuencia}"

# Diccionario de palabras y sus frecuencias
palabras = {
    'Python': 45,
    'es': 30,
    'genial': 15
}

# Llamamos a la función y mostramos el resultado
print(seleccionar_palabra_y_frecuencia(palabras))

print("-"*30)

import random

def poblacion_total(paises: dict) -> str:
    # Seleccionamos un país aleatorio
    pais_aleatorio = random.choice(list(paises.keys()))  # Convertimos las claves en una lista
    
    # Obtenemos las ciudades y poblaciones del país seleccionado
    ciudades = paises[pais_aleatorio]
    
    # Calculamos la población total sumando las poblaciones de las ciudades
    poblacion = sum(ciudades.values())
    
    # Devolvemos el resultado en el formato adecuado
    return f"'{pais_aleatorio}' -> Población total: {poblacion}"

# Diccionario con países, sus ciudades principales y las poblaciones de estas ciudades
paises = {
    'España': {'Madrid': 3200000, 'Barcelona': 1600000},
    'Francia': {'París': 2200000, 'Lyon': 520000}
}

# Llamamos a la función y mostramos el resultado
print(poblacion_total(paises))

print("-"*30)

import random

def puntuacion_maxima(equipos: dict) -> str:
    # Seleccionamos un equipo aleatorio
    equipo_aleatorio = random.choice(list(equipos.keys()))  # Convertimos las claves en una lista
    
    # Obtenemos las puntuaciones del equipo seleccionado
    puntuaciones = equipos[equipo_aleatorio]
    
    # Encontramos la puntuación máxima del equipo
    max_puntuacion = max(puntuaciones)
    
    # Devolvemos el resultado en el formato adecuado
    return f"'{equipo_aleatorio}' -> Máximo: {max_puntuacion}"

# Diccionario con equipos y sus puntuaciones
equipos = {
    'Equipo A': [3, 1, 4, 2],
    'Equipo B': [5, 2, 3, 1]
}

# Llamamos a la función y mostramos el resultado
print(puntuacion_maxima(equipos))

print("-"*30)

def gestionar_asignaturas(estudiantes):
    for estudiante, asignaturas in estudiantes.items():
        # Usamos un conjunto para eliminar duplicados
        asignaturas_unicas = set(asignaturas)
        # Mostramos el estudiante y sus asignaturas únicas
        print(f"Estudiante: {estudiante}")
        print(f"Asignaturas: {asignaturas_unicas}\n")

# Diccionario de entrada
estudiantes = {
    "Juan": ["Matemáticas", "Física", "Matemáticas", "Inglés"],
    "Ana": ["Física", "Inglés", "Historia", "Historia"],
    "Carlos": ["Programación", "Inglés", "Programación", "Física"]
}

# Llamamos a la función
gestionar_asignaturas(estudiantes)

print("-"*30)

def validar_notas(notas):
    """Valida las notas del diccionario. Asegura que todas sean números válidos."""
    for estudiante, nota in notas.items():
        try:
            # Intentamos convertir la nota a un número (float)
            notas[estudiante] = float(nota)
        except ValueError:
            # Si no es posible convertir la nota, mostramos un error
            print(f"Error: La nota de {estudiante} no es válida: {nota}")
            return False
    return True


def imprimir_notas(notas):
    """Imprime las notas de los estudiantes de manera ordenada y con formato, solo si son válidas."""
    # Primero validamos las notas
    if not validar_notas(notas):
        return  # Si alguna nota no es válida, no procedemos a imprimir

    # Si las notas son válidas, las imprimimos
    for estudiante, nota in notas.items():
        # Formateamos el nombre del estudiante y la nota
        nombre_formateado = estudiante.capitalize()
        print(f"Estudiante: {nombre_formateado}, Nota: {nota}")


# Diccionario de entrada
notas = {
    "juan": "8.5",
    "ana": "7.2",
    "carlos": "9.0",
    "maria": "5.3"
}

# Llamamos a la función que valida las notas e imprime los resultados
imprimir_notas(notas)

print("-"*30)

def validar_notas(asignaturas: dict) -> bool:
    """
    Función para validar que las notas sean números entre 0 y 10.
    Retorna True si todas las notas son válidas, de lo contrario lanza un error.
    """
    try:
        if not isinstance(asignaturas, dict):
            raise ValueError("Error: El argumento debe ser un diccionario.")
        if not asignaturas:
            raise KeyError("Error: El diccionario no puede estar vacío.")
        
        # Comprobamos que todas las asignaturas tengan un formato adecuado
        for asignatura, nota in asignaturas.items():
            if nota < 0 or nota > 10:
                raise ValueError(f"Error: La nota para {asignatura} debe ser entre 0 y 10.")
            if not isinstance(nota, (int, float)):
                raise TypeError(f"Error: La nota para {asignatura} debe ser un número.")
        
        return True
    
    except (KeyError, ValueError, TypeError) as e:
        print(e)
        return False


def asignar_calificacion(asignaturas: dict) -> dict:
    """
    Función para asignar una calificación según la nota de cada asignatura.
    """
    try:
        resultado = {}
        for asignatura, nota in asignaturas.items():
            if nota < 5:
                resultado[asignatura] = ("Suspenso", nota)
            elif 5 <= nota < 6:
                resultado[asignatura] = ("Suficiente", nota)
            elif 6 <= nota < 8:
                resultado[asignatura] = ("Bien", nota)
            elif 8 <= nota < 9:
                resultado[asignatura] = ("Notable", nota)
            elif 9 <= nota < 10:
                resultado[asignatura] = ("Sobresaliente", nota)
            elif nota == 10:
                resultado[asignatura] = ("Matrícula de honor", nota)
        return resultado
    
    except Exception as e:
        print("Error inesperado:", e)
        return {}


def imprimir_resultados(resultado: dict) -> None:
    """
    Función para imprimir los resultados de las calificaciones.
    """
    for asignatura, (calificacion, nota) in resultado.items():
        print(f"{asignatura.capitalize()} -> {calificacion} (Nota: {nota})")


# Ejemplo de uso
asignaturas = {
    "matemáticas": 8.5,
    "física": 7.0,
    "historia": 5.5,
    "biología": 9.0,
}

print("-"*30)

def validar_notas(asignaturas: dict) -> bool:
    """
    Función para validar que las notas sean números entre 0 y 10.
    Retorna True si todas las notas son válidas, de lo contrario lanza un error.
    """
    try:
        if not isinstance(asignaturas, dict):
            raise ValueError("Error: El argumento debe ser un diccionario.")
        if not asignaturas:
            raise KeyError("Error: El diccionario no puede estar vacío.")

        # Usamos un conjunto para garantizar que no haya duplicados de asignaturas
        asignaturas_set = set(asignaturas.keys())

        # Comprobamos que todas las asignaturas tengan un formato adecuado
        for asignatura, nota in asignaturas.items():
            if nota < 0 or nota > 10:
                raise ValueError(f"Error: La nota para {asignatura} debe ser entre 0 y 10.")
            if not isinstance(nota, (int, float)):
                raise TypeError(f"Error: La nota para {asignatura} debe ser un número.")
        
        print("Las notas son válidas.")
        return True
    
    except (KeyError, ValueError, TypeError) as e:
        print(e)
        return False


def asignar_calificacion(asignaturas: dict) -> dict:
    """
    Función para asignar una calificación según la nota de cada asignatura.
    """
    try:
        resultado = {}
        for asignatura, nota in asignaturas.items():
            if nota < 5:
                resultado[asignatura] = ("Suspenso", nota)
            elif 5 <= nota < 6:
                resultado[asignatura] = ("Suficiente", nota)
            elif 6 <= nota < 8:
                resultado[asignatura] = ("Bien", nota)
            elif 8 <= nota < 9:
                resultado[asignatura] = ("Notable", nota)
            elif 9 <= nota < 10:
                resultado[asignatura] = ("Sobresaliente", nota)
            elif nota == 10:
                resultado[asignatura] = ("Matrícula de honor", nota)
        return resultado
    
    except Exception as e:
        print("Error inesperado:", e)
        return {}


def imprimir_resultados(resultado: dict) -> None:
    """
    Función para imprimir los resultados de las calificaciones.
    """
    for asignatura, (calificacion, nota) in resultado.items():
        print(f"{asignatura.capitalize()} -> {calificacion} (Nota: {nota})")


# Ejemplo de uso
asignaturas = {
    "matemáticas": 8.5,
    "física": 7.0,
    "historia": 5.5,
    "biología": 9.0,
}

# Usamos un conjunto para asegurar que no haya asignaturas repetidas
asignaturas_set = set(asignaturas.keys())

# Validar las notas
if validar_notas(asignaturas):
    # Asignar calificaciones y almacenar el resultado
    resultado = asignar_calificacion(asignaturas)

    # Imprimir los resultados
    imprimir_resultados(resultado)
else:
    print("Hubo un error con las notas ingresadas.")

print("-"*30)

def procesar_notas(asignaturas: dict) -> dict:
    """
    Función que valida las notas, asigna calificaciones y devuelve el resultado.
    Utiliza un conjunto para verificar duplicados en las asignaturas.
    """
    try:
        # Validación de duplicados
        asignaturas_set = set(asignaturas.keys())
        if len(asignaturas_set) != len(asignaturas):
            raise ValueError("Error: Existen asignaturas duplicadas.")

        # Validación de que las notas estén en el rango adecuado
        resultado = {}
        for asignatura, nota in asignaturas.items():
            if not isinstance(nota, (int, float)) or nota < 0 or nota > 10:
                raise ValueError(f"Error: La nota para {asignatura} debe ser un número entre 0 y 10.")
            
            # Asignación de calificación
            if nota < 5:
                resultado[asignatura] = ("Suspenso", nota)
            elif 5 <= nota < 6:
                resultado[asignatura] = ("Suficiente", nota)
            elif 6 <= nota < 8:
                resultado[asignatura] = ("Bien", nota)
            elif 8 <= nota < 9:
                resultado[asignatura] = ("Notable", nota)
            elif 9 <= nota < 10:
                resultado[asignatura] = ("Sobresaliente", nota)
            elif nota == 10:
                resultado[asignatura] = ("Matrícula de honor", nota)

        return resultado

    except (ValueError, TypeError) as e:
        print(e)
        return {}


def imprimir_resultados(resultado: dict) -> None:
    """
    Función para imprimir los resultados de las calificaciones.
    """
    for asignatura, (calificacion, nota) in resultado.items():
        print(f"{asignatura.capitalize()} -> {calificacion} (Nota: {nota})")


# Ejemplo de uso
asignaturas = {
    "matemáticas": 8.5,
    "física": 7.0,
    "historia": 5.5,
    "biología": 9.0,
}

# Procesamos las notas y asignamos calificaciones
resultado = procesar_notas(asignaturas)

# Si el diccionario no está vacío (no hubo error), se imprimen los resultados
if resultado:
    imprimir_resultados(resultado)

print("-"*30)

def procesar_notas(asignaturas: dict) -> dict:
    """
    Función que valida el diccionario de notas, asigna calificaciones y devuelve el resultado.
    Utiliza un conjunto para verificar duplicados en las asignaturas.
    """
    try:
        # Validar si el diccionario es vacío
        if not asignaturas:
            raise ValueError("El diccionario de asignaturas no puede estar vacío.")

        # Validación de duplicados en las asignaturas
        asignaturas_set = set(asignaturas.keys())
        if len(asignaturas_set) != len(asignaturas):
            raise ValueError("Error: Existen asignaturas duplicadas.")

        # Validación de que las notas sean números entre 0 y 10
        resultado = {}
        for asignatura, nota in asignaturas.items():
            if not isinstance(nota, (int, float)):
                raise TypeError(f"Error: La nota para {asignatura} debe ser un número.")
            if nota < 0 or nota > 10:
                raise ValueError(f"Error: La nota para {asignatura} debe estar entre 0 y 10.")
            
            # Asignación de calificación
            if nota < 5:
                resultado[asignatura.capitalize()] = ("Suspenso", nota)
            elif 5 <= nota < 6:
                resultado[asignatura.capitalize()] = ("Suficiente", nota)
            elif 6 <= nota < 8:
                resultado[asignatura.capitalize()] = ("Bien", nota)
            elif 8 <= nota < 9:
                resultado[asignatura.capitalize()] = ("Notable", nota)
            elif 9 <= nota < 10:
                resultado[asignatura.capitalize()] = ("Sobresaliente", nota)
            elif nota == 10:
                resultado[asignatura.capitalize()] = ("Matrícula de honor", nota)

        return resultado

    except (ValueError, TypeError) as e:
        print(e)
        return {}


def imprimir_resultados(resultado: dict) -> None:
    """
    Función para imprimir los resultados de las calificaciones.
    """
    if not resultado:
        print("No se pudo procesar ninguna nota debido a un error.")
        return

    for asignatura, (calificacion, nota) in resultado.items():
        print(f"{asignatura.capitalize()} -> {calificacion} (Nota: {nota})")


# Ejemplo de uso
asignaturas = {
    "matemáticas": 8.5,
    "física": 7.0,
    "historia": 5.5,
    "biología": 9.0,
}

print(procesar_notas(asignaturas))

print("-"*30)

def validar_coche(coche: dict) -> bool:
    """
    Función para validar los datos de un coche. Verifica que el diccionario tenga las claves y valores correctos.
    """
    try:
        # Validar si el argumento es un diccionario
        if not isinstance(coche, dict):
            raise TypeError("El argumento debe ser un diccionario.")
        
        # Verificar que el diccionario contenga las claves necesarias
        required_keys = ['marca', 'modelo', 'anio', 'color', 'precio']
        for key in required_keys:
            if key not in coche:
                raise KeyError(f"Falta la clave '{key}' en el diccionario.")
        
        # Validar que los tipos de datos sean correctos
        if not isinstance(coche['marca'], str):
            raise TypeError("La marca debe ser una cadena de texto.")
        if not isinstance(coche['modelo'], str):
            raise TypeError("El modelo debe ser una cadena de texto.")
        if not isinstance(coche['anio'], int) or not (1900 <= coche['anio'] <= 2024):
            raise ValueError("El año debe ser un número entre 1900 y 2024.")
        if not isinstance(coche['color'], str):
            raise TypeError("El color debe ser una cadena de texto.")
        if not isinstance(coche['precio'], (int, float)) or coche['precio'] <= 0:
            raise ValueError("El precio debe ser un número positivo.")
        
        return True
    
    except (TypeError, KeyError, ValueError) as e:
        print(f"Error: {e}")
        return False


def procesar_coche(coche: dict) -> dict:
    """
    Función que usa la función validar_coche para comprobar los datos y luego devuelve un diccionario con
    la información procesada (como una posible estimación de precio con descuentos).
    """
    if validar_coche(coche):  # Solo procesamos el coche si es válido
        # Suponiendo que si el coche tiene más de 10 años, tiene un descuento
        descuento = 0
        if 2024 - coche['anio'] > 10:
            descuento = 0.15  # 15% de descuento si el coche tiene más de 10 años
        
        # Calcular el precio con el descuento (si lo tiene)
        precio_final = coche['precio'] * (1 - descuento)

        # Crear un nuevo diccionario con la información procesada
        resultado = {
            'marca': coche['marca'].capitalize(),
            'modelo': coche['modelo'].capitalize(),
            'anio': coche['anio'],
            'color': coche['color'].capitalize(),
            'precio_original': coche['precio'],
            'precio_final': round(precio_final, 2)
        }
        
        return resultado
    else:
        return {}


# Ejemplo de uso
coche = {
    'marca': 'toyota',
    'modelo': 'corolla',
    'anio': 2015,
    'color': 'rojo',
    'precio': 15000
}

# Procesamos el coche
resultado = procesar_coche(coche)

# Imprimimos el resultado
if resultado:
    print("Información del coche procesada:")
    for key, value in resultado.items():
        print(f"{key.capitalize()}: {value}")

print("-"*30)

