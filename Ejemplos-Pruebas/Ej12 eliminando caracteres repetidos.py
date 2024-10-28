# Crea una función que reciba dos cadenas como parámetro (str1, str2)
# e imprima otras dos cadenas como salida (out1, out2).
# - out1 contendrá todos los caracteres presentes en la str1 pero NO
#   estén presentes en str2.
# - out2 contendrá todos los caracteres presentes en la str2 pero NO
#   estén presentes en str1.


out1 = ""
out2 = ""
in1 = 'abcdefghi' #input("Ingrese primera cadena de caracteres:")
in2 = 'aeiou'#input("Ingrese segunda cadena de caracteres:")



for i in in1:
  if i not in in2:
    out1 += i
for i in in2:
  if i not in in1:
    out2 += i
 

    
print(out1, out2)



