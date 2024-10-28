# Crea una función que reciba un String de cualquier tipo y se encargue de
# poner en mayúscula la primera letra de cada palabra.
# - No se pueden utilizar operaciones del lenguaje que
#   lo resuelvan directamente.



text = "Este código es muy útil."
word = text.split()

for i in range (len(word)): # for char in word:
  letter = word[i][0].upper() 
  word[i] = letter + word[i][1:]         #   print(char)

resultado = " ".join(word)
print(resultado)







