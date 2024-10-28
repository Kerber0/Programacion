#Diseñar un algoritmo que lea números enteros positivos de teclado y sólo acepte como 
#válidos aquellos que sean mayores que el anterior número leído. El algoritmo terminará 
#cuando se introduzca el 0.



num = int(input("Introducir número entero positivo: "))
while num <= 0:
    num = int(input("Número inválido, introducir nuevo número:")) # verifico que num sea + que 0

mayor = True
while mayor:
    num2 = int(input("Introducir siguiente número entero positivo: "))
    
    if num2 == 0: # primero verifico si es 0, al igualar num a num2 lo que
        print("Fin del programa") # se vuelve a ingresar es num2, basta con verificar si es 0 para que termine
        break

    while num2 <= num:# verifico que num2 sea mayor a num, al igualarlo siempre es el ultimo valor que ingrese
        num2 = int(input("Número inválido, introducir nuevo número mayor que el anterior:"))
    
    num = num2 # Igualo num a num2 para que el bucle se repita sin repetir código

