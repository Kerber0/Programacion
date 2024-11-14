def verificar_altura(altura):
    if altura < 2:
        print("La altura debe ser mayor o igual a 2.")
        return False
    return True

# Cuadrado vacío
def dibujar_cuadrado_vacio(altura):
    if not verificar_altura(altura):
        return
    for i in range(altura):
        if i == 0 or i == altura - 1:
            print('*' * altura)  # Primera y última fila
        else:
            print('*' + ' ' * (altura - 2) + '*')  # Filas intermedias

# Rectángulo vacío
def dibujar_rectangulo_vacio(base, altura):
    if not verificar_altura(altura) or base < 2:
        return
    for i in range(altura):
        if i == 0 or i == altura - 1:
            print('*' * base)  # Primera y última fila
        else:
            print('*' + ' ' * (base - 2) + '*')  # Filas intermedias

# Triángulo equilátero vacío
def dibujar_triangulo_equilatero_vacio(altura):
    if not verificar_altura(altura):
        return
    for i in range(1, altura + 1):
        if i == 1:
            print(' ' * (altura - i) + '*')  # Primer asterisco en la punta
        elif i == altura:
            print('*' * (2 * i - 1))  # Base completa
        else:
            print(' ' * (altura - i) + '*' + ' ' * (2 * i - 3) + '*')  # Bordes con espacios

# Círculo vacío
def dibujar_circulo_vacio(radio):
    if radio < 2:
        print("El radio debe ser mayor o igual a 2.")
        return
    for i in range((2 * radio) + 1):
        for j in range((2 * radio) + 1):
            dist = (i - radio) ** 2 + (j - radio) ** 2
            if dist >= (radio - 0.5) ** 2 and dist <= (radio + 0.5) ** 2:
                print('*', end='')
            else:
                print(' ', end='')
        print()

# Diamante vacío
def dibujar_diamante_vacio(altura):
    if not verificar_altura(altura):
        return
    # Parte superior del diamante
    for i in range(1, altura + 1):
        if i == 1:
            print(' ' * (altura - i) + '*')
        elif i == altura:
            print('*' * (2 * i - 1))
        else:
            print(' ' * (altura - i) + '*' + ' ' * (2 * i - 3) + '*')
    # Parte inferior del diamante
    for i in range(altura - 1, 0, -1):
        if i == 1:
            print(' ' * (altura - i) + '*')
        else:
            print(' ' * (altura - i) + '*' + ' ' * (2 * i - 3) + '*')

# Trapecio vacío corregido
def dibujar_trapecio_vacio(base_mayor, base_menor, altura):
    if not verificar_altura(altura) or base_mayor < 2 or base_menor < 2 or base_mayor < base_menor:
        print("Las bases deben ser mayores o iguales a 2 y la base mayor debe ser mayor o igual a la base menor.")
        return
    
    diferencia = (base_mayor - base_menor) // 2  # Diferencia entre las bases

    for i in range(altura):
        # Calcular el número de espacios antes de los asteriscos en la fila actual
        espacios_inicio = i
        # Calcular el largo de la fila de asteriscos
        largo_fila = base_menor + (i * 2)
        
        # Imprimir los bordes del trapecio
        if i == 0 or i == altura - 1:
            print(' ' * (diferencia - i) + '*' * largo_fila)  # Primera y última fila
        else:
            print(' ' * (diferencia - i) + '*' + ' ' * (largo_fila - 2) + '*')  # Filas intermedias con espacios

# Rombo vacío
def dibujar_rombo_vacio(altura):
    if not verificar_altura(altura):
        return
    # Parte superior del rombo
    for i in range(1, altura + 1):
        if i == 1:
            print(' ' * (altura - i) + '*')
        elif i == altura:
            print('*' * (2 * i - 1))
        else:
            print(' ' * (altura - i) + '*' + ' ' * (2 * i - 3) + '*')
    # Parte inferior del rombo
    for i in range(altura - 1, 0, -1):
        if i == 1:
            print(' ' * (altura - i) + '*')
        else:
            print(' ' * (altura - i) + '*' + ' ' * (2 * i - 3) + '*')

# Hexágono vacío
def dibujar_hexagono_vacio(altura):
    if not verificar_altura(altura):
        return
    # Parte superior del hexágono
    for i in range(altura):
        if i == 0 or i == altura - 1:
            print(' ' * (altura - i) + '*' * (2 * i + 3))
        else:
            print(' ' * (altura - i) + '*' + ' ' * (2 * i + 1) + '*')
    # Parte central
    for i in range(altura):
        print('*' * (2 * altura + 3))
    # Parte inferior del hexágono
    for i in range(altura - 1, -1, -1):
        if i == 0 or i == altura - 1:
            print(' ' * (altura - i) + '*' * (2 * i + 3))
        else:
            print(' ' * (altura - i) + '*' + ' ' * (2 * i + 1) + '*')

# Octágono vacío
def dibujar_octogono_vacio(altura):
    if not verificar_altura(altura):
        return
    # Parte superior del octágono
    for i in range(altura):
        if i == 0 or i == altura - 1:
            print(' ' * (altura - i) + '*' * (2 * i + 5))
        else:
            print(' ' * (altura - i) + '*' + ' ' * (2 * i + 3) + '*')
    # Parte central
    for i in range(altura):
        print('*' * (2 * altura + 5))
    # Parte inferior del octágono
    for i in range(altura - 1, -1, -1):
        if i == 0 or i == altura - 1:
            print(' ' * (altura - i) + '*' * (2 * i + 5))
        else:
            print(' ' * (altura - i) + '*' + ' ' * (2 * i + 3) + '*')

# Solicitar altura al usuario4
def pedir_altura(figura):
    altura_valida = False
    while not altura_valida:
        altura = input(f"Introduce la altura para el {figura} (número mayor o igual a 2): ")
        if altura.isdigit():  # Verificamos si la entrada es un número
            altura = int(altura)  # Convertimos la entrada a un entero
            if altura >= 2:
                altura_valida = True  # Si la altura es válida, salimos del bucle
            else:
                print("La altura debe ser mayor o igual a 2.")
        else:
            print("Por favor, introduce un número válido.")
    return altura

# Funciones para probar las figuras

# Cuadrado vacío
print("Cuadrado vacío:")
altura_cuadrado = pedir_altura("cuadrado")
dibujar_cuadrado_vacio(altura_cuadrado)
print("\n")

# Rectángulo vacío
print("Rectángulo vacío:")
base_rectangulo = int(input("Introduce la base para el rectángulo (número mayor o igual a 2): "))
altura_rectangulo = pedir_altura("rectángulo")
dibujar_rectangulo_vacio(base_rectangulo, altura_rectangulo)
print("\n")

# Triángulo equilátero vacío
print("Triángulo equilátero vacío:")
altura_triangulo = pedir_altura("triángulo equilátero")
dibujar_triangulo_equilatero_vacio(altura_triangulo)
print("\n")

# Círculo vacío
print("Círculo vacío:")
radio_circulo = int(input("Introduce el radio para el círculo (número mayor o igual a 2): "))
dibujar_circulo_vacio(radio_circulo)
print("\n")

# Diamante vacío
print("Diamante vacío:")
altura_diamante = pedir_altura("diamante")
dibujar_diamante_vacio(altura_diamante)
print("\n")

# Trapecio vacío
print("Trapecio vacío:")
base_mayor = int(input("Introduce la base mayor para el trapecio (número mayor o igual a 2): "))
base_menor = int(input("Introduce la base menor para el trapecio (número mayor o igual a 2): "))
altura_trapecio = pedir_altura("trapecio")
dibujar_trapecio_vacio(base_mayor, base_menor, altura_trapecio)
