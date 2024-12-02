# Escribir una función que reciba una cadena y un número n y
# devuelva la cadena repetida n veces. Si el número es negativo debe
# devolver un mensaje de error.

def repetir(cadena: str, n: int) -> str:
    try:
        if n < 0:
            raise ValueError
        # Transformamos cadena a str para asegurarnos q sea un String
        return str(cadena) * n

    except ValueError:
        print("Error: El segundo argumento debe ser positivo")
    except TypeError:
        print("Error: El segundo argumento debe ser un número")
    except Exception:
        print("Error inesperado")


# Pruebas
print(repetir("hola", 3))  # holaholahola
print(repetir("adiós", -2))  # Error: El segundo argumento debe ser positivo
print(repetir(2, 3))  # Error
print(repetir("hola", "3"))  # Error: El segundo argumento debe ser un numero
