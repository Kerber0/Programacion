# Escribir una función que reciba un diccionario con los precios
# de distintos productos y un diccionario con los productos y la cantidad de
# cada uno que ha comprado un cliente y devuelva el precio total de la compra.

def precio_total(productos: dict, compra: dict) -> dict:
    total = 0
    for producto, precio in productos.items():
        if producto in compra:
            total += precio * compra[producto]
    return total


# Pruebas
print(precio_total({"Manzanas": 1, "Peras": 2, "Plátanos": 3}, {
      "Manzanas": 2, "Peras": 1}))  # 4
print(precio_total({"Manzanas": 1, "Peras": 2, "Plátanos": 3}, {
      "Manzanas": 2, "Peras": 1, "Plátanos": 3}))  # 13
