frutas1 = {'23452345', 'Pera', 'Plátano'}
frutas2 = {'Pera', 'Naranja', 'Plátano'}
frutas3 = {'Melocotón', 'Fresa', 'Plátano'}


def compararFrutas(frutas1: set, frutas2: set, frutas3: set) -> dict:
    # try:
    #     if not isinstance(frutas1, set):
    #         raise TypeError
    #     if not isinstance(frutas2, set):
    #         raise TypeError
    #     if not isinstance(frutas3, set):
    #         raise TypeError

        diccionario = {}
        union = frutas1.union(frutas2)
        comunes = frutas1.intersection(frutas2)
        unicas = frutas1.symmetric_difference(frutas2)
        diccionario['FrutastoTales'] = union.union(frutas3)
        diccionario['FrutasComunes'] = comunes.intersection(frutas3)
        diccionario['FrutasUnicas'] = unicas.symmetric_difference(frutas3)
        return diccionario
    # except TypeError:
    #     return {}
    
    
print(compararFrutas(frutas1, frutas2, frutas3))