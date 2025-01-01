
def decimalABinario(decimal: int) -> str:
    try:
        if decimal == 0:
            return 0
        elif decimal == 1:
            return 1
        else:
            return decimalABinario((decimal // 2) + (decimal % 2))
    except:
        return ()


# Ejemplo de uso:
print("Probando función ejercicio 3:")
print("10 en binario:")
# Devuelve la representación en binario del número decimal introducido (1010)
print(decimalABinario(10))
print("0 en binario:")
print(decimalABinario(0))  # Devuelve "0"
print("1 en binario:")
print(decimalABinario(1))  # Devuelve "1"
print("1486 en binario:")
# Devuelve la representación en binario del número decimal introducido (10111001110)
print(decimalABinario(1486))
print("Probando excepciones:")
print(decimalABinario(-10))  # Devuelve una cadena vacía
print(decimalABinario("asdf"))  # Devuelve una cadena vacía
print(decimalABinario(3.4))  # Devuelve una cadena vacía
