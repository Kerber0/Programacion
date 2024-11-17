# Escriba un programa que pida un número y a continuación escriba la 
# lista de todos los números primos hasta él..

# Dígame un número: 100
# Primos hasta 100: 1 2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59
#  61 67 71 73 79 83 89 97


def es_primo(n):
    if n < 2:
        return False
    for i in range(2, int(n**0.5) + 1):
        if n % i == 0:
            return False
    return True

def obtener_primos_hasta():
    numero = int(input("Dígame un número: "))
    
    # Generar lista de números primos hasta el número dado
    primos = [i for i in range(1, numero + 1) if es_primo(i)]
    
    # Mostrar los números primos en formato solicitado
    print(f"Primos hasta {numero}: {' '.join(map(str, primos))}")

# Llamar a la función
obtener_primos_hasta()