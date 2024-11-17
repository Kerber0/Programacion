def tablero_ajedrez(filas: int, columnas: int) -> list:
    if filas == 0:
        return []
    return [tablero_ajedrez(filas - 1, columnas)] + [tablero_ajedrez_columnas(columnas, filas)]

def tablero_ajedrez_columnas(columnas: int, fila: int) -> list:
    if columnas == 0:
        return []
    return [(fila + columnas) % 2] + tablero_ajedrez_columnas(columnas - 1, fila)



print(tablero_ajedrez(8,8))