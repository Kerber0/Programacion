# Escribir una función que reciba un diccionario con las asignaturas y las notas 
# de un alumno y devuelva otro diccionario con las asignaturas en mayúsculas y 
# las calificaciones correspondientes a las notas aprobadas.    




def aprobado(materias: dict) -> dict:
    """
    return (asignatura.upper(): nota for asignatura, nota in diccionario.items() if nota >= 5)
     
     resolucion por compresion 
      
    """
    aprobadas = {}
    try:
        for notas in materias:
            if materias[notas] < 0 or materias[notas] >10:
                print(f"La nota de {notas} debe ser entre 0 y 10")
                continue
            if materias[notas] >= 5 :
                aprobadas[notas] = materias[notas]
        return aprobadas
    except AttributeError:
        print("Error: el argunento devbe ser un diccionario")
    


def aprobado_v2(diccionario: dict) -> dict:
    aprobadas = {}
    for asignatura, nota in diccionario.items():
        if nota >=5:
            aprobadas[asignatura.upper()] = nota
    return aprobadas



# Pruebas
print(aprobado({"Matemáticas": -100, "Lengua": 6, "Historia": 5, "Inglés": 3})) # {'LENGUA': 6, 'HISTORIA': 5}    
print(aprobado({"Matemáticas": 5, "Lengua": 5, "Historia": 5, "Inglés": 5})) # {'MATEMÁTICAS': 5, 'LENGUA': 5, 'HISTORIA': 5, 'INGLÉS': 5} 
