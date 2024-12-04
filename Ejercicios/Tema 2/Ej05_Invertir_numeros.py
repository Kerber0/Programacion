# Diseñar una función que invierta los dígitos de un número entero 
# positivo (debe comprobarse que el número es positivo).


def invertir_numero(n: int) -> int:
    if n < 0:
        print("El número debe ser positivo")
        return None  # Salir si el número es negativo

    invertido = 0
    while n > 0:
        digito = n % 10         # Obtener el último dígito
        invertido = invertido * 10 + digito  # Construir el número invertido
        n = n // 10             # Eliminar el último dígito del número original

    return invertido
