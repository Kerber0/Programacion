def imprimir_letra_a(altura):
    if altura < 3:
        print("La altura debe ser al menos 3.")
        return
    
    ancho = 2 * altura - 1
    medio = ancho // 2
    for i in range(altura):
        # Genera cada línea de la letra "A" usando comprensión de lista
        linea = ''.join(
            "*" if j == medio - i or j == medio + i or (i == altura // 2 and medio - i < j < medio + i) else " "
            for j in range(ancho)
        )
        print(linea)

def imprimir_letra_b(altura):
    if altura < 3:
        print("La altura debe ser al menos 3.")
        return
    
    for i in range(altura):
        linea = ''.join(
            "*" if j == 0 or (i == 0 and j < altura - 1) or (i == altura // 2 and j < altura - 1) or 
                 (i == altura - 1 and j < altura - 1) or (j == altura - 1 and i != 0 and i != altura // 2 and i != altura - 1)
            else " "
            for j in range(altura)
        )
        print(linea)

def imprimir_letra_c(altura):
    if altura < 3:
        print("La altura debe ser al menos 3.")
        return
    
    for i in range(altura):
        linea = ''.join(
            "*" if (i == 0 and j > 0) or (i == altura - 1 and j > 0) or (j == 0 and i != 0 and i != altura - 1)
            else " "
            for j in range(altura)
        )
        print(linea)

def imprimir_letra_d(altura):
    if altura < 3:
        print("La altura debe ser al menos 3.")
        return
    
    for i in range(altura):
        linea = ''.join(
            "*" if j == 0 or (j == altura - 1 and i != 0 and i != altura - 1) or 
                 (i == 0 and j < altura - 1) or (i == altura - 1 and j < altura - 1)
            else " "
            for j in range(altura)
        )
        print(linea)

# Función para imprimir todas las letras deseadas
def imprimir_abecedario(altura):
    print("Letra A:")
    imprimir_letra_a(altura)
    print("\nLetra B:")
    imprimir_letra_b(altura)
    print("\nLetra C:")
    imprimir_letra_c(altura)
    print("\nLetra D:")
    imprimir_letra_d(altura)
    # Agregar más letras según el mismo formato

# Ejemplo de uso
altura = 5  # Cambia la altura para probar diferentes tamaños
imprimir_abecedario(altura)


