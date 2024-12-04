# Escribir una función que reciba un diccionario con el horario
# de un alumno y lo recorra imprimiendo los días de la semana y las
# asignaturas que tiene en cada uno.

def imprimir_horario(diccionario: dict) -> None:
    """ este programa sirve para bla bla bla"""
    try:
        for clave in diccionario:
            if diccionario[clave] == []:
                print(f"El día {clave} no se cursan materias")
            else:
                print(clave, diccionario[clave])
        print()
    except AttributeError:
        print("Error: el argumento debe ser un diccionario")
    except TypeError:
        print("El valor de cada día debe ser un elemento iterable, pero no una string")
    except:
        print("Error inesperado")

def imprimir_horario_v2(diccionario: dict) -> None:
    for clave in diccionario:
        if isinstance(diccionario[clave], list):  # Verifica si el valor es una lista
            if diccionario[clave] == []:
                print(f"El día {clave} no se cursan materias")
            else:
                print(clave + ":", ", ".join(diccionario[clave]))
        else:  # Si el valor no es una lista, simplemente lo imprime
            print(f"{clave}: {diccionario[clave]}")
    print()


# Pruebas


(imprimir_horario({"Lunes": ["Matemáticas", "Lengua"], "Martes": [
 "Historia", "Inglés"], "Miércoles": ["Física", "Química"], "Jueves": []}))
# Lunes: Matemáticas, Lengua
# Martes: Historia, Inglés
# Miércoles: Física, Química
imprimir_horario({"Lunes": ["Matemáticas"], "Martes": [
                 "Historia", "Inglés"], "Miércoles": ["Física", "Química"]})
imprimir_horario({"Lunes": ["Matemáticas"], "Martes": [
                 "Historia", "Inglés"], "Miércoles": ["Física", "Química"]})

(imprimir_horario_v2({"Lunes": ["Matemáticas", "Lengua"], "Martes": [
 "Historia", "Inglés"], "Miércoles": ["Física", "Química"], "Jueves": []}))
# Lunes: Matemáticas, Lengua
# Martes: Historia, Inglés
# Miércoles: Física, Química
imprimir_horario_v2({"Lunes": "Matemáticas", "Martes": [
                 "Historia", "Inglés"], "Miércoles": ["Física", "Química"]})
imprimir_horario_v2({"Lunes": ["Matemáticas"], "Martes": [
                 "Historia", "Inglés"], "Miércoles": ["Física", "Química"]})
