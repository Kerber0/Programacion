# "Escribir una función que reciba un diccionario con los planetas del sistema solar"
# # y sus distancias al sol, además debe recibir un planeta y devolver su distancia a la Tierra
# # Las distancias se expresan en millones de kilómetros.
# # La distancia de la Tierra al Sol es de 149.6 millones de kilómetros.
# # La distancia de los planetas al Sol son las siguientes:

# Mercurio: 57.9
# Venus: 108.2
# Tierra: 149.6
# Marte: 227.9
# Júpiter: 778.5
# Saturno: 1433.4
# Urano: 2872.5
# Neptuno: 4495.1
# Plutón: 5906.4


# Pruebas
# Distancia de la Tierra al Sol: 149.6
# Distancia de Marte al Sol: 227.9
# Distancia de Marte a la Tierra: 78.3
# Distancia de Plutón al Sol: 5906.4
# Distancia de Plutón a la Tierra: 5756.8
# Distancia de Venus al Sol: 108.2
# Distancia de Venus a la Tierra: 41.4
# Distancia de Saturno al Sol: 1433.4
# Distancia de Saturno a la Tierra: 1283.8
# Distancia de Júpiter al Sol: 778.5
# Distancia de Júpiter a la Tierra: 628.9
# Distancia de Neptuno al Sol: 4495.1
# Distancia de Neptuno a la Tierra: 4345.5
# Distancia de Urano al Sol: 2872.5
# Distancia de Urano a la Tierra: 2722.9
# Distancia de Mercurio al Sol: 57.9
# Distancia de Mercurio a la Tierra: 91.7

def distancia_a_tierra(sistema: dict, n: str) -> float:

    # Validar que todas las distancias sean números positivos
    for planeta, distancia in sistema.items():
        if not isinstance(distancia, (int, float)):
            print(f"Error: La distancia de '{
                  planeta}' no es un número válido.")
            return -1
        if distancia < 0:
            print(f"Error: La distancia de '{
                  planeta}' es negativa ({distancia}).")
            return -1

    # Asegurarse de que "Tierra" está en el sistema
    if "Tierra" not in sistema:
        print("Error: El sistema no contiene la distancia de la Tierra.")
        return -1

    tierra = sistema["Tierra"]  # Distancia de la Tierra al Sol
    try:
        # Calcular la distancia absoluta
        distancia = abs(sistema[n] - tierra)
        return round(distancia, 2)
    except KeyError:
        print(f"Error: el planeta '{n}' no existe en el sistema.")
        return -1


planetas = {"Mercurio": 57.9, "Venus": 108.2, "Tierra": 149.6, "Marte": 227.9,
            "Júpiter": 778.5, "Saturno": 1433.4, "Urano": 2872.5, "Neptuno": 4495.1, "Plutón": 5906.4}
print(distancia_a_tierra(planetas, "Marte"))  # 78.3
print(distancia_a_tierra(planetas, "Plutón"))  # 5756.8
print(distancia_a_tierra(planetas, "Venus"))  # 41.4
print(distancia_a_tierra(planetas, "Saturno"))  # 1283.8
print(distancia_a_tierra(planetas, "Júpiter"))  # 628.9
print(distancia_a_tierra(planetas, "Neptuno"))  # 4345.5
print(distancia_a_tierra(planetas, "Urano"))  # 2722.9
print(distancia_a_tierra(planetas, "Mercurio"))  # 91.7
print(distancia_a_tierra(planetas, "Tierra"))  # 0.0
print(distancia_a_tierra(planetas, "Alderaan"))  # -1
