import random
import time

# Función para generar un cartón de bingo válido (5x5)
def generar_carton():
    # Números de bingo por columna (cada columna tiene un rango específico)
    rango_columna = {
        0: (1, 15),    # Columna 1: números entre 1 y 15
        1: (16, 30),   # Columna 2: números entre 16 y 30
        2: (31, 45),   # Columna 3: números entre 31 y 45
        3: (46, 60),   # Columna 4: números entre 46 y 60
        4: (61, 75),   # Columna 5: números entre 61 y 75
    }
    
    carton = [[] for _ in range(5)]  # Inicializamos las 5 columnas como listas vacías
    
    # Generar los números para cada columna
    for i in range(5):
        # Crear una lista con todos los números posibles para la columna
        posibles_numeros = list(range(rango_columna[i][0], rango_columna[i][1] + 1))
        random.shuffle(posibles_numeros)  # Mezclamos los números para elegirlos aleatoriamente

        # Tomamos los 5 primeros números de la lista mezclada para cada columna
        for j in range(5):
            carton[j].append(posibles_numeros[j])  # Colocamos los números en las filas correspondientes

    # En la casilla del centro debe ir "X" (representando el espacio libre)
    carton[2][2] = "X"
    
    return carton

# Función para imprimir el cartón de Bingo
def imprimir_matriz(matriz):
    for fila in matriz:
        for celda in fila:
            print(celda, end="\t")
        print()

# Función para generar números aleatorios
def generar_numeros():
    return random.randint(1, 100)

# Función para marcar los números en el cartón
def marcar_numeros(carton_bingo, numero):
    for i in range(len(carton_bingo)):  # Iterar por filas
        for j in range(len(carton_bingo[i])):  # Iterar por columnas en cada fila
            if carton_bingo[i][j] == numero:  # Comparar si el número es igual al sorteado
                carton_bingo[i][j] = "X"  # Marcar con "X" si hay coincidencia
                return True  # Retornar True si se marca el número
    return False  # Retornar False si no se encuentra el número

# Función para verificar si hay una línea (fila completa con "X")
def verificar_linea(carton_bingo):
    for fila in carton_bingo:
        if fila == ["X", "X", "X", "X", "X"]:  # Verificar si toda la fila está llena de "X"
            return True  # Retornar True si encontramos una fila completa con "X"
    return False  # Retornar False si no hay fila completa

# Función para verificar si hay Bingo (toda la matriz llena de "X")
def verificar_bingo(carton_bingo):
    for fila in carton_bingo:
        if fila != ["X", "X", "X", "X", "X"]:  # Si alguna fila no está llena de "X"
            return False  # Retornar False si alguna fila no está completa
    return True  # Retornar True si todas las filas están completas

# Generar una lista de 100 cartones de Bingo
cartones_bingo = [generar_carton() for _ in range(100)]

# Seleccionar aleatoriamente un cartón de Bingo de la lista
carton_bingo = random.choice(cartones_bingo)

# Imprimir el cartón de Bingo seleccionado
print("Cartón de Bingo seleccionado:")
imprimir_matriz(carton_bingo)

# Usar un conjunto para almacenar los números sorteados (evita repeticiones automáticamente)
numeros_sorteo = set()

# Bucle de juego
bingo = False
sorteos_realizados = 0
linea_cantada = False

while not bingo:
    numero = generar_numeros()
    
    # Asegurarse de que el número no se repita
    while numero in numeros_sorteo:
        numero = generar_numeros()
    
    # Agregar el número sorteado al conjunto
    numeros_sorteo.add(numero)
    sorteos_realizados += 1
    
    # Mostrar el número sorteado
    print(f"Número sorteado: {numero}")
    
    # Pausa de 1 segundo
    time.sleep(1)
    
    # Marcar el número en el cartón
    if marcar_numeros(carton_bingo, numero):
        print("¡Número marcado!")
    
    # Verificar si hay una línea
    if not linea_cantada and verificar_linea(carton_bingo):
        print("¡Línea!")
        imprimir_matriz(carton_bingo)  # Imprimir el cartón al cantar línea
        linea_cantada = True  # Solo se canta la línea una vez
    
    # Verificar si hay Bingo
    if verificar_bingo(carton_bingo):
        bingo = True
        print("¡Bingo!")
        imprimir_matriz(carton_bingo)  # Imprimir el cartón al cantar bingo
        break

# Imprimir el cartón después del juego
print(f"Cartón de Bingo final después de {sorteos_realizados} sorteos: ")
imprimir_matriz(carton_bingo)
