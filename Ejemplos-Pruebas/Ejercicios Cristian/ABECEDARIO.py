# Función que dibuja letras del abecedario, vacías (sólo bordes)
def dibujar_letra(letra, altura):
    if altura < 2:
        print("La altura debe ser mayor o igual a 2 para dibujar letras.")
        return
    
    if letra == 'A':
        for i in range(altura):
            if i == 0:
                print(' ' * (altura - 1) + '*')  # Parte superior de la A
            elif i == altura - 1:
                print('*' * (2 * altura - 1))  # Parte inferior de la A (base)
            else:
                print(' ' * (altura - i - 1) + '*' + ' ' * (2 * i - 1) + '*')  # Lados de la A
    elif letra == 'B':
        for i in range(altura):
            if i == 0 or i == altura - 1:
                print('*' * (altura))  # Parte superior e inferior de la B
            elif i == altura // 2:
                print('*' * (altura))  # Parte media de la B
            else:
                print('*' + ' ' * (altura - 2) + '*')  # Lados de la B
    elif letra == 'C':
        for i in range(altura):
            if i == 0 or i == altura - 1:
                print('*' * (altura - 1))  # Parte superior e inferior de la C
            else:
                print('*')  # Lados de la C
    elif letra == 'D':
        for i in range(altura):
            if i == 0 or i == altura - 1:
                print('*' * altura)  # Parte superior e inferior de la D
            else:
                print('*' + ' ' * (altura - 2) + '*')  # Lados de la D
    elif letra == 'E':
        for i in range(altura):
            if i == 0 or i == altura - 1 or i == altura // 2:
                print('*' * altura)  # Partes superior, inferior y media de la E
            else:
                print('*')  # Lado de la E
    elif letra == 'F':
        for i in range(altura):
            if i == 0 or i == altura // 2:
                print('*' * altura)  # Parte superior y media de la F
            else:
                print('*')  # Lado de la F
    elif letra == 'G':
        for i in range(altura):
            if i == 0 or i == altura - 1:
                print('*' * (altura - 1))  # Parte superior e inferior de la G
            elif i == altura // 2:
                print('*' * (altura // 2))  # Parte media de la G
            else:
                print('*')  # Lado izquierdo de la G
    elif letra == 'H':
        for i in range(altura):
            if i == altura // 2:
                print('*' * altura)  # Parte media de la H
            else:
                print('*' + ' ' * (altura - 2) + '*')  # Lados de la H
    elif letra == 'I':
        for i in range(altura):
            if i == 0 or i == altura - 1:
                print('*' * altura)  # Parte superior e inferior de la I
            else:
                print(' ' * (altura // 2) + '*')  # Centro de la I
    elif letra == 'J':
        for i in range(altura):
            if i == 0:
                print(' ' * (altura - 1) + '*')  # Parte superior de la J
            elif i == altura - 1:
                print('*' * (altura // 2))  # Parte inferior de la J
            else:
                print(' ' * (altura // 2) + '*')  # Lados de la J
    elif letra == 'K':
        for i in range(altura):
            if i == 0 or i == altura - 1:
                print('*')  # Lados de la K
            else:
                print(' ' * (altura - i - 1) + '*' + ' ' * (i - 1) + '*')  # Lados de la K
    elif letra == 'L':
        for i in range(altura):
            if i == altura - 1:
                print('*' * altura)  # Parte inferior de la L
            else:
                print('*')  # Lado de la L
    elif letra == 'M':
        for i in range(altura):
            if i == 0:
                print('*' + ' ' * (altura - 2) + '*')  # Parte superior de la M
            elif i == altura - 1:
                print('*' * altura)  # Parte inferior de la M
            else:
                print('*' + ' ' * (2 * i - 1) + '*')  # Lados de la M
    elif letra == 'N':
        for i in range(altura):
            if i == 0 or i == altura - 1:
                print('*' + ' ' * (altura - 2) + '*')  # Lados de la N
            else:
                print('*' + ' ' * (i - 1) + '*' + ' ' * (altura - i - 2) + '*')  # Diagonal de la N
    elif letra == 'O':
        for i in range(altura):
            if i == 0 or i == altura - 1:
                print(' ' * (altura - 1) + '*')  # Parte superior e inferior de la O
            else:
                print('*' + ' ' * (altura - 2) + '*')  # Lados de la O
    elif letra == 'P':
        for i in range(altura):
            if i == 0 or i == altura // 2:
                print('*' * altura)  # Partes superior y media de la P
            elif i == altura - 1:
                print('*')  # Lado de la P
    elif letra == 'Q':
        for i in range(altura):
            if i == 0 or i == altura - 1:
                print('*' * altura)  # Parte superior e inferior de la Q
            elif i == altura // 2:
                print('*' + ' ' * (altura - 2) + '*')  # Parte media de la Q
            else:
                print('*' + ' ' * (altura - 2) + '*')  # Lados de la Q
    elif letra == 'R':
        for i in range(altura):
            if i == 0 or i == altura // 2:
                print('*' * altura)  # Partes superior y media de la R
            elif i == altura - 1:
                print('*')  # Lado de la R
    elif letra == 'S':
        for i in range(altura):
            if i == 0 or i == altura - 1:
                print('*' * (altura - 1))  # Parte superior e inferior de la S
            elif i == altura // 2:
                print('*' * (altura // 2))  # Parte media de la S
            else:
                print('*')  # Lados de la S
    elif letra == 'T':
        for i in range(altura):
            if i == 0:
                print('*' * altura)  # Parte superior de la T
            else:
                print(' ' * (altura // 2) + '*')  # Lado de la T
    elif letra == 'U':
        for i in range(altura):
            if i == altura - 1:
                print('*' * altura)  # Parte inferior de la U
            else:
                print('*' + ' ' * (altura - 2) + '*')  # Lados de la U
    elif letra == 'V':
        for i in range(altura):
            print(' ' * i + '*' + ' ' * (altura - 2 * i - 3) + '*' if i != altura - 1 else '*' * (2 * i - 1))
    elif letra == 'W':
        for i in range(altura):
            print('*' + ' ' * (altura - i - 2) + '*' + ' ' * (i - 1) + '*' if i != altura - 1 else '*' * (2 * i - 1))
    elif letra == 'X':
        for i in range(altura):
            print(' ' * (altura - i - 1) + '*' + ' ' * (2 * i - 1) + '*' if i != altura - 1 else '*' * (2 * i - 1))
    elif letra == 'Y':
        for i in range(altura):
            # Dibujar las partes superiores de la Y
            if i < altura // 2:
                print(' ' * i + '*' + ' ' * (altura - 2 * i - 3) + '*' if i != 0 else '*' * (altura - 1))
            else:
                # Parte inferior de la Y (línea vertical)
                print(' ' * (altura // 2) + '*')

    elif letra == 'Z':
        for i in range(altura):
            if i == 0 or i == altura - 1:
                # Parte superior e inferior de la Z
                print('*' * altura)
            else:
                # Lados diagonales de la Z
                print(' ' * (altura - i - 1) + '*')

# Función para mostrar todas las letras del abecedario
def mostrar_abecedario(altura):
    for letra in "ABCDEFGHIJKLMNOPQRSTUVWXYZ":
        print(f"\nDibujando la letra {letra}:")
        dibujar_letra(letra, altura)

# Pedir altura al usuario
altura = int(input("Introduce la altura para las letras (número mayor o igual a 2): "))
mostrar_abecedario(altura)