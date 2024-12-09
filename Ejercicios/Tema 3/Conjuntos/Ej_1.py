# Escribir una función que reciba dos conjuntos y devuelva un conjunto con
# los elementos que están en ambos conjuntos.

def interseccion(conj1: set, conj2: set) -> set:
    try:
        conj3 = conj1.intersection(conj2)
        return conj3
    except:
        print("Error")


# Pruebas
print(interseccion({1, 2, 3}, {3, 4, 5}))  # {3}
# set() ya que no tienen elementos en común
print(interseccion({1, 2, 3}, {4, 5, 6}))
