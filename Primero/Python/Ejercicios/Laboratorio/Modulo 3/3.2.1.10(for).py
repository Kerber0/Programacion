"""La sentencia continue se usa para omitir el bloque actual y avanzar a la siguiente 
iteración, sin ejecutar las sentencias dentro del bucle.

Se puede usar tanto con while y for.

Tu tarea aquí es muy especial: ¡Debes diseñar un devorador de vocales! Escribe un 
programa que use:

Un bucle for.
El concepto de ejecución condicional (if-elif-else).
La sentencia continue.
Tu programa debe:

Pedir al usuario que ingrese una palabra.
Utiliza user_word = user_word.upper() para convertir la palabra ingresada por el usuario
a mayúsculas; hablaremos sobre los llamados métodos de cadena y el upper() muy pronto, no 
te preocupes.
Utiliza la ejecución condicional y la instrucción continue para "comer" las siguientes 
vocales A , E , I , O , U de la palabra ingresada.
Imprime las letras no consumidas en la pantalla, cada una de ellas en una línea separada.
Prueba tu programa con los datos que le proporcionamos.


Datos de Prueba
Entrada de muestra: Gregory

Salida esperada:

G
R
G
R
Y
Entrada de muestra: abstemious

Salida esperada:

B
S
T
M
S
Entrada de muestra: IOUEA

Salida esperada:
"""
palabra = input("Ingrese una palabra: ")
palabra = palabra.lower()
resultado = ""
vocales = "aeiou"
for i in palabra:
  if i in vocales: 
    continue
  else:
    resultado += i

print(resultado)