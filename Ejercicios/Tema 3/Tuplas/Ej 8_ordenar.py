# Escribir una función que reciba una tupla de números y 
# devuelva la tupla con sus elementos ordenados de
#  menor a mayor.

def ordenar_tupla(tupla: tuple) -> tuple:
    ""
    
    
    
    
    
    
    try:
        return tupla(sorted(tupla))
    except TypeError:
        print("Error: ")
    except:
        print("Error inesperado")
        
# Pruebas
print(ordenar_tupla((5, 4, 3, 2, 1))) # (1, 2, 3, 4, 5)
print(ordenar_tupla((1, 2, 3, 5, 4))) # (1, 2, 3, 4, 5)