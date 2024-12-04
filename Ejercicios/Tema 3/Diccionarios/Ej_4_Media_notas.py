# Escribir una función que reciba un diccionario con las asignaturas y 
# las notas de un alumno y devuelva la media de las notas. 

def media_notas(resultados: dict) -> float:
    suma = 0
    for notas in resultados.values():
        suma += notas
    media = suma / len(resultados)

    return media


# Pruebas
print(media_notas({"Matemáticas": 4, "Lengua": 6, "Historia": 5, "Inglés": 3})) # 4.5
print(media_notas({"Matemáticas": 5, "Lengua": 5, "Historia": 5, "Inglés": 5})) # 5.0
