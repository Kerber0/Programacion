# Escribir una función que reciba una tupla de números y devuelva su media y su varianza.   

def media_varianza(tupla: tuple) -> tuple:

    try:
        media = sum(tupla) / len(tupla)
        varianza = sum((x - media)**2 for x in tupla) / len(tupla)
        return (media, varianza)
    except ZeroDivisionError:
        print("Error: la tupla esta vacía")
    except TypeError:
        print("Error: la tupla debe estar compuesta de números")

# Pruebas
print(media_varianza((1, 2, 3, 4, 5))) # (3.0, 2.0)
print(media_varianza((1, 2, 3, 4, 5, 6, 7, 8, 9, 10))) # (5.5, 8.25)
