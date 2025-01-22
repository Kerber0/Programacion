def ordenar(lista: list) -> list:
    if len(lista) <= 1:
        return (lista)

    maximo = max(lista)
    lista.remove(maximo)

    return [maximo] + ordenar(lista)


print("Ejercicio 4 - Ordenar lista")
print(ordenar([3]))
print(ordenar([3, 1, 5, 2, 4]))  # [5, 4, 3, 2, 1]
print(ordenar([10, 20, 30, 40, 50]))  # [50, 40, 30, 20, 10]
print(ordenar([1, 2, 3, 4, 5]))  # [5, 4, 3, 2, 1]
print("-"*20)