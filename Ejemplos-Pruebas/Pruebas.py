def imprimir_letra_f(altura):
       for i in range(altura):
            if i == 0 or i == altura - 1:
                # Parte superior e inferior de la Z
                print('*' * altura)
            else:
                # Lados diagonales de la Z
                print(' ' * (altura - i - 1) + '*')

print(imprimir_letra_f(5))