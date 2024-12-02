def main():
    # Palabras con las que probar. Descomentar sólo una de ellas.
    palabra = "amor"  # debe dar True
    # Añadir el resto de pruebas que se consideren necesarias
    if orden(palabra):
        print("La palabra está ordenada alfabéticamente")
    else:
        print("La palabra NO está ordenada alfabéticamente")


def orden(cadena):
    """
    Verifica si una cadena está ordenada alfabéticamente.
    :param cadena: Cadena a verificar.
    :return: True si está ordenada alfabéticamente, False en caso contrario.
    """
    cadena = cadena.lower()  # Convertimos la cadena a minúsculas.
    if len(cadena) > 1:  # Si la longitud de la cadena es mayor que uno
        if cadena[0] <= cadena[1]:  # Si el primer carácter es menor o igual al segundo
            # Llamada recursiva con la subcadena desde el índice 1 hasta el final
            return orden(cadena[1:])
        else:
            return False  # Si no está ordenada, devolvemos False
    else:
        return True  # Si queda un solo carácter o está vacía, está ordenada por defecto


if __name__ == "__main__":
    main()
