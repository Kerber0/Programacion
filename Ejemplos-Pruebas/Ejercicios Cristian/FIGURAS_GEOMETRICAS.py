def dibujar_cuadrado(tamaño):
    for i in range(tamaño):
        print('*' * tamaño)

def dibujar_rectangulo(base, altura):
    for i in range(altura):
        print('*' * base)

def dibujar_triangulo_equilatero(tamaño):
    for i in range(1, tamaño + 1):
        print(' ' * (tamaño - i) + '*' * (2 * i - 1))

def dibujar_circulo(radio):
    for i in range((2 * radio) + 1):
        for j in range((2 * radio) + 1):
            dist = (i - radio) ** 2 + (j - radio) ** 2
            if dist >= (radio - 0.5) ** 2 and dist <= (radio + 0.5) ** 2:
                print('*', end='')
            else:
                print(' ', end='')
        print()

def dibujar_diamante(tamaño):
    # Parte superior del diamante
    for i in range(1, tamaño + 1):
        print(' ' * (tamaño - i) + '*' * (2 * i - 1))
    # Parte inferior del diamante
    for i in range(tamaño - 1, 0, -1):
        print(' ' * (tamaño - i) + '*' * (2 * i - 1))

def dibujar_trapecio(base_mayor, base_menor, altura):
    diferencia = (base_mayor - base_menor) // 2
    for i in range(altura):
        espacios = diferencia + i
        asteriscos = base_menor + (i * 2)
        print(' ' * espacios + '*' * asteriscos)

def dibujar_rombo(tamaño):
    # Parte superior del rombo
    for i in range(1, tamaño + 1):
        print(' ' * (tamaño - i) + '*' * (2 * i - 1))
    # Parte inferior del rombo
    for i in range(tamaño - 1, 0, -1):
        print(' ' * (tamaño - i) + '*' * (2 * i - 1))

def dibujar_hexagono(tamaño):
    # Parte superior del hexágono
    for i in range(tamaño):
        print(' ' * (tamaño - i) + '*' * (2 * i + 3))
    # Parte central
    for i in range(tamaño):
        print('*' * (2 * tamaño + 3))
    # Parte inferior del hexágono
    for i in range(tamaño - 1, -1, -1):
        print(' ' * (tamaño - i) + '*' * (2 * i + 3))

# Octágono
def dibujar_octogono(tamaño):
    # Parte superior del octágono
    for i in range(tamaño):
        print(' ' * (tamaño - i) + '*' * (2 * i + 5))
    # Parte central
    for i in range(tamaño):
        print('*' * (2 * tamaño + 5))
    # Parte inferior del octágono
    for i in range(tamaño - 1, -1, -1):
        print(' ' * (tamaño - i) + '*' * (2 * i + 5))

# Funciones para probar las figuras

# Cuadrado
print("Cuadrado:")
dibujar_cuadrado(5)
print("\n")

# Rectángulo
print("Rectángulo:")
dibujar_rectangulo(8, 4)
print("\n")

# Triángulo equilátero
print("Triángulo equilátero:")
dibujar_triangulo_equilatero(5)
print("\n")

# Círculo
print("Círculo:")
dibujar_circulo(5)
print("\n")

# Diamante
print("Diamante:")
dibujar_diamante(5)
print("\n")

# Trapecio
print("Trapecio:")
dibujar_trapecio(10, 4, 5)
print("\n")

# Rombo
print("Rombo:")
dibujar_rombo(5)

# Hexágono
print("Hexágono:")
dibujar_hexagono(4)
print("\n")

# Octágono
print("Octágono:")
dibujar_octogono(4)