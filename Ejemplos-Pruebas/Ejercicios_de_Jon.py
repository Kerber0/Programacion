# Hacete este ejercicio, te dan por input una serie de letras y vos tenés 
# que imprimir un string que cuente las letras repetidas consecutivas, ejemplo:

# Input: aaabccd

# Output: a3b1c2d1


contador = 0
letra_anterior = None
resultado = ""
x = input("Ingresar lo que sea: ") 

for i in range(len(x)):
  letra = x[i]
  if letra == letra_anterior or letra_anterior == None:
    contador +=1
  else: 
    resultado += letra_anterior + str(contador)
    contador = 1  
  if i == len(x)-1:
    resultado += letra + str(contador)
  letra_anterior = x[i]

print(resultado)




  
   
  

