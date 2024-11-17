def dibujar_trapecio(base_mayor, base_menor, altura):
    diferencia = (base_mayor - base_menor) // 2
    for i in range(altura):
        espacios = diferencia + i
        asteriscos = base_menor + (i * 2)
        print(' ' * espacios + '*' * asteriscos)


print(dibujar_trapecio(5,4,4))