# Escribir una función que reciba un diccionario con las asignaturas y
# las notas de un alumno y devuelva la media de las notas.

def media_notas(resultados: dict) -> float:
    suma = 0
    errores = {}  # Para almacenar notas negativas y sus detalles
    cantidad = 0  # Para contar las notas válidas

    for nombre, nota in resultados.items():
        if not isinstance(nota, (int, float)):  # Comprobar si la nota es un número
            errores[nombre] = f"Error: el valor {
                nota} no es un número válido."
            continue  # Continuar con la siguiente iteración si no es un número

        if nota < 0:  # Si la nota es negativa
            errores[nombre] = f"Error: la nota {
                nota} no es válida (debe ser positiva)."
        else:
            suma += nota
            cantidad += 1

    if cantidad > 0:
        media = suma / cantidad
    else:
        media = 0  # Si no hay notas válidas, la media es 0

    # Mostrar los errores si los hay
    if errores:
        print("Notas con errores:")
        for nombre, error in errores.items():
            print(f"{nombre}: {error}")

    # Si no hay notas válidas, mostramos un mensaje
    if cantidad == 0:
        print("No se puede calcular la media porque no hay notas válidas.")
    return f"La media es: {media}"


# Pruebas
print(media_notas({"Matemáticas": 4, "Lengua": 6,
      "Historia": 5, "Inglés": 3}))  # 4.5
print(media_notas({"Matemáticas": 5, "Lengua": 5,
      "Historia": 5, "Inglés": 5}))  # 5.0
print(media_notas({"Matemáticas": (), "Lengua": 5,
      "Historia": 5, "Inglés": 5}))  # 5.0
