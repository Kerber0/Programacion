# Escribir una función que reciba un diccionario con las asignaturas y las notas 
# de un alumno y devuelva otro diccionario con las asignaturas en mayúsculas y 
# las calificaciones correspondientes a las notas aprobadas.    


suspensas = {}
aprobadas = {}
def aprobado(materias: dict) -> dict:
    try:
        for notas in materias:
            if materias[notas] < 0:
                raise ValueError(f"La nota de {notas} debe ser positiva")

            if materias[notas] >= 5 :
                aprobadas[notas] = materias[notas]

            else:
                suspensas[notas] = materias[notas]

        return aprobadas
    except ValueError as e:
        print("Error:", e)

# Pruebas
print(aprobado({"Matemáticas": -100, "Lengua": 6, "Historia": 5, "Inglés": 3})) # {'LENGUA': 6, 'HISTORIA': 5}    
print(aprobado({"Matemáticas": 5, "Lengua": 5, "Historia": 5, "Inglés": 5})) # {'MATEMÁTICAS': 5, 'LENGUA': 5, 'HISTORIA': 5, 'INGLÉS': 5} 
print("Suspensas:", suspensas)
print("Aprobadas:", aprobadas)