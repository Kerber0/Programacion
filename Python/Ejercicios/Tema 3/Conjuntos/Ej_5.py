# Escribir una función que reciba una lista de palabras y devuelva un
# conjunto con las palabras que tienen más de n caracteres.

def palabras_mas_de_n_caracteres(palabras: list, n: int):
    lista = []
    for palabra in palabras:
        if len(palabra) > n:
            lista.append(palabra)
    return set(lista)

def palabras_mas_de_n_caracteresv2(palabras: list, n: int):

    return { palabra for palabra in palabras if len(palabra) > n}

# Pruebas
print(palabras_mas_de_n_caracteres(
    ["hola", "mundo", "python", "adiós"], 4))  # {"python", "adiós"}
print(palabras_mas_de_n_caracteres(["hola", "mundo", "python", "adiós"], 5))
# {"python"} ya que solo hay una palabra con más de 5 caracteres
