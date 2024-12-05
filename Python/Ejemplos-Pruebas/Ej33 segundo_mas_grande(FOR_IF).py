# Dado un listado de números, encuentra el SEGUNDO más grande

num = "13213654987"
max_num = 0
casimax = None

for i in range (len(num)):
  if (int(num[i])) > int(max_num):
    casimax = max_num
    max_num = num[i]
  elif casimax < (num[i]):
    casimax = num[i]
 
print(max)
print(casimax)
 