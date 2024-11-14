# Ahora un menú con las diferenes tablas de multiplicar. La tabla del 1, la tabla del 2, la tabla del 3,
#  la tabla del 4, la tabla del 5, la tabla del 6, la tabla del 7, la tabla del 8, la tabla del 9, la tabla del 10.

    
# Lo mismo pero con recursividad.

def tabla_multiplicar(numero: int, i: int = 1) -> None:
    if i == 11:
        return
    print(f"{numero} x {i} = {numero * i}")
    tabla_multiplicar(numero, i + 1)
    
def menu_tablas() -> None:
    while True:
        print("1. Tabla del 1")
        print("2. Tabla del 2")
        print("3. Tabla del 3")
        print("4. Tabla del 4")
        print("5. Tabla del 5")
        print("6. Tabla del 6")
        print("7. Tabla del 7")
        print("8. Tabla del 8")
        print("9. Tabla del 9")
        print("10. Tabla del 10")
        print("11. Salir")
        opcion = int(input("Introduce una opción: "))
        if opcion == 1:
            tabla_multiplicar(1)
        elif opcion == 2:
            tabla_multiplicar(2)
        elif opcion == 3:
            tabla_multiplicar(3)
        elif opcion == 4:
            tabla_multiplicar(4)
        elif opcion == 5:
            tabla_multiplicar(5)
        elif opcion == 6:
            tabla_multiplicar(6)
        elif opcion == 7:
            tabla_multiplicar(7)
        elif opcion == 8:
            tabla_multiplicar(8)
        elif opcion == 9:
            tabla_multiplicar(9)
        elif opcion == 10:
            tabla_multiplicar(10)
        elif opcion == 11:
            break
        
if __name__ == "__main__":
    menu_tablas()
    
    