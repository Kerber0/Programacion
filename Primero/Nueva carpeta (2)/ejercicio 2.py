'''
Crea un programa que gestione un inventario simple utilizando un diccionario donde las claves sean los nombres de los productos y los valores sean la cantidad disponible. El programa debe ofrecer las siguientes funcionalidades mediante un menú interactivo:

1. ** Añadir/Actualizar producto: ** Solicitar el nombre del producto y la cantidad. Si el producto ya existe, actualizar su cantidad
si no, añadirlo.
2. ** Ver inventario: ** Mostrar todos los productos y sus cantidades en el inventario.
3. ** Eliminar producto: ** Solicitar el nombre de un producto y eliminarlo del inventario. Si el producto no existe, mostrar un mensaje de error.
4. ** Buscar producto: ** Solicitar el nombre de un producto y mostrar su cantidad si existe, o un mensaje de que no se encuentra.
5. ** Salir: ** Terminar el programa.
'''


def menu():
    productos = {"Banana": 1, "Manzana": 2, "Pera": 5}
    valido = ("1", "2", "3", "4", "0")
    try:
        while True:
            opcion = input("""
                            Seleccione la opcion deseada:
                            1- Añadir/Actualizar producto
                            2- Ver inventario
                            3- Eliminar producto
                            4- Buscar producto
                            0- Salir
                            """)

            match opcion:
                case "1":
                    agregar_actualizar(productos)
                case "2":
                    mostrar(productos)
                case "3":
                    eliminar(productos)
                case "4":
                    buscar(productos)
                case "0":
                    print("Adios.")
                    break
            
    except Exception:
        print("error")


def agregar_actualizar(productos: dict):
    agregar = str(input(
        "Seleccione 1 para agregar o modifciar un producto o 0 para volver al menu"))

    while agregar not in ["1", "0"]:
        agregar = input("Error: debe seleccionar una opcion válida.")

    if agregar == "1":
        agregar_stock(productos)

    if agregar == "0":
        print("Volviendo al menú.")
        return menu()


def agregar_stock(productos):
    producto = input("Ingrese el nombre del producto: ")
    cantidad = int(input("Ingrese la cantidad del producto"))
    if cantidad < 0:
        print("Error: la cantidad del producto debe ser un numero positivo.")
    if producto in productos:
        print("El producto ya existe, se actualziará su stock")
    else:
        print("Se agregara el nuevo producto")
    productos[producto] = cantidad


def eliminar(productos: dict) -> dict:
    mostrar(productos)
    borrar = input(
        'Indique el producto a eliminar o "Salir" para salir: ')

    if str(borrar).lower() == "salir":
        print("Volviendo al menu")
        return

    while borrar not in productos:
        borrar = input(
            "El producto proporcionado no está disponible, intentelo de nuevo: ")

    productos.pop(borrar)
    print(f"El producto {borrar} ha sido eliminado ")
    return productos


def mostrar(productos: dict) -> str:

    print("\nLista de productos disponibles:")
    if not productos:
        print("No hay productos en stock.")
    else:
        for producto, cantidad in productos.items():
            print(f"{producto}: {cantidad}")

    input("\nPresione Enter para volver al menú.")


def buscar(productos: dict):
    try:
        busqueda = input("Ingrese el nombre del producto que desea buscar: ")
        if not busqueda in productos:
            raise KeyError("Error: El producto no se encuentra en el stock")
        else: 
            print(productos[busqueda])
    except KeyError as e:
        print(e)


if __name__ == "__main__":
    menu()
